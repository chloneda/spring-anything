package com.chloneda.service;

import com.chloneda.model.User;
import com.chloneda.repository.CacheUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Created by chloneda
 * @Description:
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheUserRepository cacheUserRepository;

    /**
     * 没有使用缓存，如果调用了该方法十次，必定输出十次 "业务类查询了数据库!",
     * 使用了缓存，调用了该方法十次，只输出了一次 "业务类查询了数据库!",
     * 具体请看测试类com.chloneda.service.CacheServiceTest
     */
    @Override
    @Cacheable("user")
    public User findUserByName(String username) {
        System.out.println("业务类查询了数据库!");
        User user = cacheUserRepository.findUserByName(username);
        return user;
    }

}
