package com.qianfeng.dao;

import com.qianfeng.entity.depart;
import com.qianfeng.vo.VDepart;
import com.qianfeng.vo.VGrade;

import java.util.List;

public interface departMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(depart record);

    int insertSelective(depart record);

    depart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(depart record);

    int updateByPrimaryKey(depart record);

    public List<VDepart> findAllDepart();

    public void deleteDepart(Integer id);
}