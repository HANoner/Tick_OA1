package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.staffMapper;
import com.qianfeng.entity.staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

      //  staffDao.findAllStaff();

        return map;
    }

    @Override
    public void deleteStaff(String no) {

        staffDao.deleteStaffById(no);
    }

    @Override
    public void updateStaff(staff staff) {
        staffDao.updateByPrimaryKeySelective(staff);
    }

    @Override
    public void addStaff(staff staff) {
        staffDao.insertSelective(staff);
    }

    @Override
    public String findLastNo() {
        String lastNo = staffDao.findLastNo();
        return lastNo;
    }

    @Override
    public void addStaffBatch(List<staff> list) {
        // 每100条记录，进行一次批量操作
        int count = 1;
        List<staff> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                staffDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }
        }
        if(tempList.size() != 0){
            staffDao.addBatch(tempList);
        }
    }


}
