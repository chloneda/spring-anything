package com.chloneda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chloneda.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chloneda
 * @description: UserMapper 接口类
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}