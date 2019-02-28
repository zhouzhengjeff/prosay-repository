package com.prosay.oa.service.impl;

import com.prosay.oa.domain.*;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.RoleMapper;
import com.prosay.oa.mapper.RolePrivilegeMapper;
import com.prosay.oa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public List<Role> findAllRoleList() {
        RoleExample roleExample = new RoleExample();
        return this.roleMapper.selectByExample(roleExample);
    }

    @Override
    public Role findRoleById(Integer roleId) {
        if (roleId == null || roleId <= 0) {
            throw new SsmException("");
        }

        return this.roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Privilege> findPrivilegeListByRoleId(Integer roleId) {
        if (roleId == null || roleId <= 0) {
            throw new SsmException("");
        }
        return this.roleMapper.findPrivilegesById(roleId);
    }

    @Override
    public void setPrivilege(Integer roleId, Integer[] privilegeIds) {
        if (roleId == null || roleId <= 0) {
            throw new SsmException("");
        }

        RolePrivilegeExample rolePrivilegeExample = new RolePrivilegeExample();
        RolePrivilegeExample.Criteria criteria = rolePrivilegeExample.createCriteria();

        // 先删除该角色的所有的权限然后再添加新的权限
        criteria.andRoleIdEqualTo(roleId);
        rolePrivilegeMapper.deleteByExample(rolePrivilegeExample);

        for (Integer privilegeId : privilegeIds) {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setRoleId(roleId);
            rolePrivilege.setPrivilegeId(privilegeId);
            this.rolePrivilegeMapper.insertSelective(rolePrivilege);
        }
    }
}