package com.prosay.oa.mapper;

import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.Role;
import com.prosay.oa.domain.User;
import com.prosay.oa.domain.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Role> findRolesByUserId(Integer userId);

    void save(User user);

    List<Privilege> findPrivilegesByLoginName(String loginName);
}