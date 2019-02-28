package com.prosay.oa.service;

import com.prosay.oa.domain.Department;
import com.prosay.oa.vo.DepartmentVo;

import java.util.List;

public interface DepartmentService {

    List<DepartmentVo> findTopDepartmentVoList();

    List<DepartmentVo> findDepartmentVoListByParentId(Integer parentId);

    List<DepartmentVo> findEqualLevelDepartmentVoListById(Integer id);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

}
