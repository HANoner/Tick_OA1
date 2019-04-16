package com.qianfeng.service;

import com.qianfeng.entity.depart;
import com.qianfeng.entity.grade;

import java.util.Map;

public interface DepartService {

    public Map<String, Object> findDepartAll(Integer page, Integer pageSize);

    public void deleteDepartById(Integer id);

    public void updateDepart(depart depart);

    public void addDepart(depart depart);
}
