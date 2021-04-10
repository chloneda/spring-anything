package com.chloneda.dao.impl;

import com.chloneda.dao.UserDao;
import com.chloneda.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository
public class UserDaoImpl extends DaoSupportImpl<User> implements UserDao {

    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public List<User> getUserById(String userId) {
        return getSession().createQuery("FROM User u where u.id=:userId order by u.birthday")
                //.setString("userId", userId)
                .setParameter("userId",userId)
                .list();
    }

    @Override
    public boolean hasUserById( String userId) {
        User user = (User) getSession().createQuery("FROM User u " +
                "where u.id=:userId")
                .setParameter("userId",userId)
                .setMaxResults(1)
                .uniqueResult();
        return user != null;
    }

}
