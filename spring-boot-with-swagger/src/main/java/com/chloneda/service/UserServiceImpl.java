package com.chloneda.service;

import com.chloneda.dto.DtoUser;
import com.chloneda.model.User;
import com.chloneda.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Created by chloneda
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public DtoUser findUser(String username) {
        User user = userRepository.findByName(username);
        DtoUser dtoUser = DtoUtils.copyObject(DtoUser.class, user);
        return dtoUser;
    }

    @Override
    public DtoUser createUser(DtoUser dtoUser) {
        User user = new User();
        BeanUtils.copyProperties(dtoUser, user);
        userRepository.saveAndFlush(user);
        return dtoUser;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public DtoUser updateUser(DtoUser dtoUser) {//??
        Optional<User> userOptional = userRepository.findById(dtoUser.getId());
        if (userOptional.isPresent()) {
            User userObj = userOptional.get();
            userObj.setId(dtoUser.getId());
            userObj.setName(dtoUser.getName());
            userObj.setAge(dtoUser.getAge());
            userObj.setSex(dtoUser.getSex());
            userObj.setAddress(dtoUser.getAddress());
            userObj.setEmail(dtoUser.getEmail());
            userObj.setPhone(dtoUser.getPhone());
            dtoUser = DtoUtils.copyObject(DtoUser.class, userObj);
            userRepository.saveAndFlush(userObj);
            return dtoUser;
        }
        return null;
    }

    @Override
    public List<DtoUser> findAll() {
        List<User> userList = userRepository.findAll();
        List<DtoUser> dtoUserList=DtoUtils.copyArray(DtoUser.class,userList);
        return dtoUserList;
    }

    public static final class DtoUtils {
        public static <T> T copyObject(Class<T> cls, Object src) {
            if (src == null) {
                return null;
            }
            try {
                Object dst = cls.newInstance();
                BeanUtils.copyProperties(dst, src);
                return (T) dst;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static <T, E> List<T> copyArray(Class<T> cls, Collection<E> srcArray) {
            List<T> deslist = new ArrayList<>();
            copyCollection(cls, srcArray, deslist);
            return deslist;
        }

        public static <T, E> void copyCollection(Class<T> cls, Collection<E> srcArray, Collection<T> desCollection) {
            try {
                if (srcArray == null) {
                    return;
                }
                for (E src : srcArray) {
                    Object dst = cls.newInstance();
                    BeanUtils.copyProperties(dst, src);
                    desCollection.add((T) dst);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
