package com.chloneda.service;

import com.chloneda.model.User;
import com.chloneda.repository.CacheUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Cacheable(value = "user")
    public User findUserByName(String username) {
        System.out.println("业务类查询了数据库!");
        User user = cacheUserRepository.findUserByName(username);
        return user;
    }

    //@CacheEvict 从缓存user中删除key为 userId 的数据
    @CacheEvict(value = "user")
    @Override
    public void remove(String userId) {
        /**这里不做实际删除操作，只删除缓存的数据*/
        System.out.println("删除了userId为： " + userId + "的数据缓存");
    }

    @Cacheable(value = "user")
    @Override
    public User findOne(User user) {
        Optional<User> u = cacheUserRepository.findById(user.getId());
        System.out.println("id为:" + u.get().getId() + "数据做了缓存");
        return u.get();
    }

}
