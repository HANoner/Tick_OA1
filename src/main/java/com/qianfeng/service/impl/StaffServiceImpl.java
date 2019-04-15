package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.staffMapper;
import com.qianfeng.entity.staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private staffMapper staffDao;
    @Override
    public Map<String, Object> findAllGrade(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<VStaff> list = staffDao.findAllStaff();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page)list).getTotal();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;


    }
}
