package com.chloneda.batch;

import com.chloneda.listener.JobListener;
import com.chloneda.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

/**
 * @author chloneda
 * @description:
 * Spring Batch 提供了一组实现 ItemReader 和 ItemWriter 的构建器, 参考官网，
 * 支持从多种数据源中读取数据，可以以多种方式输出数据，支持的 ItemReader 和 ItemWriter 参考官网。可以直接看源码!
 *
 * Spring Batch 主要由以下几部分组成：
 *
 * 名称	            用途
 * JobRepository	用于持久化 job 运行时的元数据
 * JobLanucher	    用于启动Job的接口
 * Job	            实际要执行的任务，包含一个或多个 Step
 * Step	            Step-步骤包含 ItemReader、ItemProcessor 和 ItemWriter
 * ItemReader	    用于读取数据的接口
 * ItemProcessor	用于处理数据的接口
 * ItemWriter	    用于输出数据的接口
 *
 * @EnableBatchProcessing提供用于构建批处理作业的基本配置
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private static final Logger log = LoggerFactory.getLogger(BatchConfig.class);

    /**
     * 用于构建JOB
     */
    @Resource
    private JobBuilderFactory jobBuilderFactory;

    /**
     * 用于构建Step
     */
    @Resource
    private StepBuilderFactory stepBuilderFactory;

    /**
     * 注入实例化Factory 访问数据
     */
    @Resource
    private EntityManagerFactory managerFactory;

    /**
     * 任务监听器
     */
    @Resource
    private JobListener jobListener;

    /**
     * Job通常由一个或者多个Step组成
     */
    @Bean
    public Job handleJob() {
        return jobBuilderFactory.get("handleJob").
                incrementer(new RunIdIncrementer()).
                start(handleStep()). //start是JOB执行的第一个step
                listener(jobListener). //设置JobListener
                build();
    }

    /**
     * Step主要分为三个部分
     * ItemReader: 读取数据
     * ItemProcessor: 处理数据
     * ItemWriter: 写数据
     */
    @Bean
    public Step handleStep() {
        return stepBuilderFactory.get("getData").
                <User, User>chunk(100).  // <输入,输出> chunk通俗的讲类似于SQL的commit; 这里表示处理(processor)100条后写入(writer)一次。
                faultTolerant().retryLimit(3).retry(Exception.class).skipLimit(100).skip(Exception.class). //捕捉到异常就重试,重试100次还是异常,JOB就停止并标志失败
                reader(getItemReader()).         //指定ItemReader
                processor(getItemProcessor()).   //指定ItemProcessor
                writer(getItemWriter()).         //指定ItemWriter
                build();
    }

    @Bean
    public ItemReader<? extends User> getItemReader() {
        //读取数据,这里可以用JPA,JDBC,JMS 等方式 读入数据
        JpaPagingItemReader<User> reader = new JpaPagingItemReader<>();
        //这里选择JPA方式读数据
        String sqlQuery = "SELECT * FROM user";
        try {
            JpaNativeQueryProvider<User> queryProvider = new JpaNativeQueryProvider<>();
            queryProvider.setSqlQuery(sqlQuery);
            queryProvider.setEntityClass(User.class);
            queryProvider.afterPropertiesSet();
            reader.setEntityManagerFactory(managerFactory);
            reader.setPageSize(3);
            reader.setQueryProvider(queryProvider);
            reader.afterPropertiesSet();
            //所有ItemReader和ItemWriter实现都会在ExecutionContext提交之前将其当前状态存储在其中,如果不希望这样做,可以设置setSaveState(false)
            reader.setSaveState(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    @Bean
    public ItemProcessor<User, User> getItemProcessor() {
        /**
         * 模拟处理数据,这里处理就是打印一下
         */
        return new ItemProcessor<User, User>() {
            @Override
            public User process(User user) {
                log.info("Processor data : " + user.toString());
                return user;
            }
        };
    }

    @Bean
    public ItemWriter<User> getItemWriter() {
        /**
         * 采用lambda表达式,模拟写数据,即真正写入数据的逻辑
         */
        return list -> {
            for (User user : list) {
                log.info("Write data : " + user);
            }
        };
    }

}
