package com.chloneda.service;

import com.chloneda.domain.User;

/**
 * @author chloneda
 * @description: User逻辑接口类
 */
public interface UserService {

    /**
     * 根据用户ID删除
     *
     * @param userId
     * @return
     */
    void delete(String userId);

    void update(User user);

    void create(User user);

    User getUserById(String userId);

}
