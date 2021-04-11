package com.chloneda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.chloneda.domain.User;
import com.chloneda.repository.UserRepository;

/**
 * @author chloneda
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    /**
     * 简单的事物回滚 由Spring框架进行回滚
     */
    @Override
    @Transactional
    public boolean create(User user) {
        String userId = user.getId();
        System.out.println("查询的数据1:" + userRepository.findById(userId).get());
        // 新增两次，会出现主键ID冲突，看是否可以回滚该条数据
        userRepository.saveAndFlush(user);
        System.out.println("查询的数据2:" + userRepository.findById(userId));
        userRepository.saveAndFlush(user);
        return false;
    }

    /**
     * 简单的事物回滚 自己捕获该异常进行手动回滚
     */
    @Override
    @Transactional
    public boolean createUser(User user) {
        String userId = user.getId();
        try {
            System.out.println("查询的数据1:" + userRepository.findById(userId).get());
            // 新增两次，会出现主键ID冲突，看是否可以回滚该条数据
            userRepository.saveAndFlush(user);
            System.out.println("查询的数据2:" + userRepository.findById(userId).get());
            userRepository.saveAndFlush(user);
        } catch (Exception e) {
            System.out.println("发生异常,进行手动回滚！");
            // 手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 注意手动回滚事物要在异常抛出之前！
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 手动进行事物控制
     */
    @Override
    public boolean add(User user) {
        TransactionStatus transactionStatus = null;
        boolean isCommit = false;
        try {
            transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            System.out.println("查询的数据1:" + userRepository.findById(user.getId()));
            // 进行新增/修改
            userRepository.saveAndFlush(user);
            System.out.println("查询的数据2:" + userRepository.findById(user.getId()));
            if (Integer.valueOf(user.getAge()) < 20) {
                user.setAge(String.valueOf(Integer.valueOf(user.getAge()) + 2));
                userRepository.saveAndFlush(user);
                System.out.println("查询的数据3:" + userRepository.findById(user.getId()));
            } else {
                throw new Exception("模拟一个异常!");
            }
            //手动提交
            dataSourceTransactionManager.commit(transactionStatus);
            isCommit = true;
            System.out.println("手动提交事物成功!");
            throw new Exception("模拟第二个异常!");
        } catch (Exception e) {
            //如果未提交就进行回滚
            if (!isCommit) {
                System.out.println("发生异常,进行手动回滚！");
                //手动回滚事物
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            e.printStackTrace();
        }
        return false;
    }

}
