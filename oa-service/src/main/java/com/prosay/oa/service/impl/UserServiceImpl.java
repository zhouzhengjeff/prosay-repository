package com.prosay.oa.service.impl;

import com.prosay.oa.domain.*;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.UserMapper;
import com.prosay.oa.mapper.UserRoleMapper;
import com.prosay.oa.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> findAllUserList() {
        UserExample userExample = new UserExample();
        List<User> userList = this.userMapper.selectByExample(userExample);
        return userList;
    }

    @Override
    public List<Role> findAllRoleListByUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new SsmException("");
        }

        return this.userMapper.findRolesByUserId(userId);
    }

    @Override
    public void addUser(User user, Integer[] roleIds) {
        if (user == null) {
            throw new SsmException("");
        }

        user.setUserPassword("1234");
        this.userMapper.save(user);

        if (ArrayUtils.isNotEmpty(roleIds)) {
            for (Integer roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(roleId);
                this.userRoleMapper.insertSelective(userRole);
            }
        }

    }

    @Override
    public User findUserByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new SsmException("");
        }

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(name);
        List<User> userList = this.userMapper.selectByExample(userExample);

        if (CollectionUtils.isNotEmpty(userList)) {
            return userList.get(0);
        }

        return null;

    }

    /**
     * 根据登录名称查询该用户的所有的权限的Code
     *
     * @param loginName
     * @return
     */
    @Override
    public List<String> findAllPrivilegeCodeListByLoginName(String loginName) {
        List<String> privilegeCodeList = new ArrayList<>();

        List<Privilege> privilegeList = this.userMapper.findPrivilegesByLoginName(loginName);
        for (Privilege privilege : privilegeList) {
            privilegeCodeList.add(privilege.getPrivilegeCode());
        }

        return privilegeCodeList;
    }

    @Override
    public List<Privilege> findAllTopPrivilegeListByLoginName(String loginName) {
        Set<Privilege> tempSet = new HashSet<>();
        List<Privilege> privilegeList = this.userMapper.findPrivilegesByLoginName(loginName);
        for (Privilege privilege : privilegeList) {
            if (privilege.getParentId() == null) {
                tempSet.add(privilege);
            }
        }
        return new ArrayList<>(tempSet);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName);

        List<User> userList = this.userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(userList)) {
            return userList.get(0);
        }

        return null;
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public User findDepartmentManagerByApplicant(User applicant) {
        return null;
    }
}
