package com.prosay.oa.mapper;

import com.prosay.oa.domain.ApproveInfo;
import com.prosay.oa.domain.ApproveInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApproveInfoMapper {
    int countByExample(ApproveInfoExample example);

    int deleteByExample(ApproveInfoExample example);

    int deleteByPrimaryKey(Integer approveInfoId);

    int insert(ApproveInfo record);

    int insertSelective(ApproveInfo record);

    List<ApproveInfo> selectByExample(ApproveInfoExample example);

    ApproveInfo selectByPrimaryKey(Integer approveInfoId);

    int updateByExampleSelective(@Param("record") ApproveInfo record, @Param("example") ApproveInfoExample example);

    int updateByExample(@Param("record") ApproveInfo record, @Param("example") ApproveInfoExample example);

    int updateByPrimaryKeySelective(ApproveInfo record);

    int updateByPrimaryKey(ApproveInfo record);
}