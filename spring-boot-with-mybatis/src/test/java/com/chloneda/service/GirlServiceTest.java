package com.chloneda.service;

import com.chloneda.model.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testFindGirlByName(){
        System.out.println("======> " + girlService.getGirlById("001").getAddress());
    }

    @Test
    public void testGetGirlById(){
        System.out.println("======> " + girlService.getGirlById("001").getAddress());
    }

    @Test
    public void testCreate(){
        Girl girl=new Girl();
        girl.setId("005");
        girl.setName("minyi");
        girl.setAge("18");
        girl.setAddress("GuangZhou");
        girl.setEmail("minyi@163.com");
        girl.setPhone("132-xxxx-3156");
        System.out.println("======> " + girlService.create(girl));
    }

    @Test
    public void testDelete(){
        System.out.println("======> " + girlService.delete("005"));
    }

    @Test
    public void testUpdate(){
        System.out.println("======> " + girlService.update("005","yiran"));
    }

}
