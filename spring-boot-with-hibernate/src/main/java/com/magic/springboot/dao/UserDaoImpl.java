package com.magic.springboot.dao;

import com.magic.springboot.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public User getUserByName(String username) {
        User user = this.getHibernateTemplate().get(User.class,username);
        return user;
    }

    @Override
    public void save(Object obj) {
        this.getHibernateTemplate().save(obj);
    }

}
