package com.prosay.oa.service.impl;

import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.PrivilegeExample;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.PrivilegeMapper;
import com.prosay.oa.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findTopPrivilegeList() {
        PrivilegeExample privilegeExample = new PrivilegeExample();
        PrivilegeExample.Criteria criteria = privilegeExample.createCriteria();
        criteria.andParentIdIsNull();
        return this.privilegeMapper.selectByExample(privilegeExample);
    }

    @Override
    public List<Privilege> findPrivilegeChildrenById(Integer id) {
        if (id == null || id <= 0) {
            throw new SsmException("");
        }

        PrivilegeExample privilegeExample = new PrivilegeExample();
        PrivilegeExample.Criteria criteria = privilegeExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<Privilege> privilegeList = this.privilegeMapper.selectByExample(privilegeExample);
        return privilegeList;
    }
}
