package com.prosay.oa.service;

import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.Role;
import com.prosay.oa.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUserList();

    List<Role> findAllRoleListByUserId(Integer userId);

    void addUser(User user, Integer[] roleIds);

    User findUserByName(String name);

    List<String> findAllPrivilegeCodeListByLoginName(String name);

    List<Privilege> findAllTopPrivilegeListByLoginName(String loginName);

    User findUserByLoginName(String loginName);

    User findUserById(Integer id);

    User findDepartmentManagerByApplicant(User applicant);
}
