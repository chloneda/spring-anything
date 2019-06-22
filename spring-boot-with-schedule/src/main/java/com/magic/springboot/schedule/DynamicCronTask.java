package com.magic.springboot.schedule;

import com.magic.springboot.service.DataProcService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chl
 * Description:Cron表达式
 *
 * 一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。按顺序依次为
 * 秒（0~59）
 * 分钟（0~59）
 * 小时（0~23）
 * 天（月）（0~31，但是你需要考虑你月的天数）
 * 月（0~11）
 * 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
 * 年份（1970－2099）
 *
 * 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),
 * 一个列表(1,3,5),通配符。由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?
 *
 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 * 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
 * 0 0 12 ? * WED 表示每个星期三中午12点
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 */
@Component("scheduledTask")
@EnableScheduling
public class DynamicCronTask implements SchedulingConfigurer{
    private static final Logger LOGGER= LoggerFactory.getLogger(DynamicCronTask.class);
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DataProcService dataProcService;

    /**
     * 方式1: 注解实现，缺点是修改时需要重启服务器
     */
    //@Scheduled(cron = "${scheduledTask.cron}")
    public void scheduled(){
        // 逻辑任务
        List<Map<String,Object>> userList = dataProcService.doQuery("select * from mag_user");
        LOGGER.info("Scheduled is running...The userList data is : "+userList);
    }

    /**
     * 方式2: spring中实现,动态获取Cron表达式，修改时不需重启服务器
     * @param taskRegister
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegister) {
        taskRegister.addTriggerTask(task,trigger);
    }

    Runnable task=new Runnable() {
        @Override
        public void run() {
            // 逻辑任务
            List<Map<String,Object>> userList=dataProcService.doQuery("select * from mag_user");
            LOGGER.info("DynamicCronTask is running...The userList data is : "+userList);
        }
    };

    Trigger trigger=new Trigger() {
        @Override
        public Date nextExecutionTime(TriggerContext triggerContext) {
            String cron=null;
            try {
//                String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
//                InputStream in =new FileInputStream(path+"/application.properties");
//                Properties properties=new Properties();
//                properties.load(in);

                ClassPathResource resource=new ClassPathResource("application.properties");
                Properties properties=PropertiesLoaderUtils.loadProperties(resource);
                cron=properties.getProperty("scheduledTask.cron");
            } catch (IOException e) { }
            if(StringUtils.isBlank(cron))return null;
            // 任务触发，可修改任务的执行周期
            CronTrigger cronTrigger = new CronTrigger(cron);
            Date nextExecTime=cronTrigger.nextExecutionTime(triggerContext);
            return nextExecTime;
        }
    };

    /**
     * 方式3: JDK原生定时任务方法，缺点因为Timer底层是使用一个单线来实现多个Timer任务处理的，所有任务都是由同一个线程来调度，
     * 所有任务都是串行执行，意味着同一时间只能有一个任务得到执行，而前一个任务的延迟或者异常会影响到之后的任务。
     */
    @PostConstruct
    public void scheduledWithTimer(){
        long interval=1;
        long now = System.currentTimeMillis();
        long start = interval - now % interval;
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 逻辑任务
                List<Map<String,Object>> userList=dataProcService.doQuery("select * from mag_user");
                LOGGER.info("ScheduledWithTimer is running...The userList data is : "+userList);

            }
        },start,3*1000);
    }

    /**
     * 方式4: Timer的替代方法
     */
    @PostConstruct
    public void scheduledWithScheduledExecutorService(){
        //ScheduledExecutorService exec1= Executors.newScheduledThreadPool(1);
        ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(1);

        //创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(format.format(new Date()));
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);

        //开始执行后就触发异常,next周期将不会运行
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("RuntimeException no catch,next time can't run");
                throw new RuntimeException();
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);

        //虽然抛出了运行异常,当被拦截了,next周期继续运行
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    throw new RuntimeException();
                }catch (Exception e){
                    LOGGER.info("RuntimeException catched,can run next");
                }
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);

        // 在给定初始延迟后,每一次执行终止和下一次执行开始之间都存在给定的延迟。
        exec.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("scheduleWithFixedDelay:begin,"+format.format(new Date()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("scheduleWithFixedDelay:end,"+format.format(new Date()));
            }
        },1000,3000, TimeUnit.MILLISECONDS);

        //创建并执行在给定延迟后启用的一次性操作。
        exec.schedule(new Runnable() {
            public void run() {
                LOGGER.info("The thread can only run once!");
            }
        },3000,TimeUnit.MILLISECONDS);

    }

}
