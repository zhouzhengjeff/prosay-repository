package com.prosay.oa.service;

import com.prosay.oa.domain.Privilege;

import java.util.List;

public interface PrivilegeService {

    List<Privilege> findTopPrivilegeList();

    List<Privilege> findPrivilegeChildrenById(Integer id);
}
