package com.qianfeng.service;

import com.qianfeng.entity.staff;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;
import java.util.Map;

public interface StaffService {
    public Map<String, Object> findAllGrade(Integer page, Integer pageSize);

    public void deleteStaff(String no);

    public void updateStaff(staff staff);

    public void addStaff(staff staff);
/*查找最后的id*/
    public String findLastNo();

    public void addStaffBatch(List<staff> list);

}
