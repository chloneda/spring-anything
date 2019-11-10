package com.magic.springboot.repository;

import com.magic.springboot.model.Girl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chloneda
 * @description:
 */
public class GirlRepositoryTest {

    @Autowired
    private GirlRepository girlRepository;

    @Test
    public void testCreate() {
        Girl girl = new Girl();
        girl.setId("1");
        girl.setName("小明");
        girl.setAge("13");
        girlRepository.create(girl);
    }

    @Test
    public void findGirlByName() {
        Girl user = girlRepository.findGirlByName("小明");
        System.out.println("Girl is " + user);
    }

    @Test
    public void update() {
        Girl girl = new Girl();
        girl.setId("2");
        girl.setName("天空");
        girl.setAge("18");
        girlRepository.update(girl);
    }

    @Test
    public void deleteGirlById() {
        girlRepository.deleteGirlById("1");
    }

}
