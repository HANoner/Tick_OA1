package com.qianfeng.dao;

import com.qianfeng.entity.check;
import com.qianfeng.entity.processtodo;

import java.util.List;

public interface processtodoMapper {
    int deleteByPrimaryKey(String id);

    int insert(processtodo record);

    int insertSelective(processtodo record);

    processtodo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(processtodo record);

    int updateByPrimaryKey(processtodo record);

    public List<check> findAllprocesstodo();

    public void processUpdateById(Integer id);

    public void processUpdateYById(Integer id);
}