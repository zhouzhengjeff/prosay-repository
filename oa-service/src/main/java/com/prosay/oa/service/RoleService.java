package com.prosay.oa.service;


import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoleList();

    Role findRoleById(Integer roleId);

    List<Privilege> findPrivilegeListByRoleId(Integer roleId);

    void setPrivilege(Integer roleId, Integer[] privilegeIds);
}
