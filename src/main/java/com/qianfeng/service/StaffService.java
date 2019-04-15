package com.qianfeng.service;

import com.qianfeng.entity.staff;

import java.util.List;
import java.util.Map;

public interface StaffService {
    public Map<String, Object> findAllGrade(Integer page, Integer pageSize);
}
