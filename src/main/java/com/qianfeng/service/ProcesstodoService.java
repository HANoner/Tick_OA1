package com.qianfeng.service;

import com.qianfeng.entity.processtodo;

import java.util.Map;

public interface ProcesstodoService {

    public Map<String,Object> findprocesstodoAll(Integer page, Integer pageSize);

    public void processUpdateById(Integer id);
    public void processUpdateYById(Integer id);


}
