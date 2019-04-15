package com.qianfeng.service.impl;

import com.qianfeng.dao.staffMapper;
import com.qianfeng.entity.staff;
import com.qianfeng.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private staffMapper staffDao;
    @Override
    public List<staff> findAllGrade() {

        staffDao.findAllStaff();
        return null;
    }
}
