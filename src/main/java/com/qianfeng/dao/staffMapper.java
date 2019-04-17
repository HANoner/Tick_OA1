package com.qianfeng.dao;





import com.qianfeng.entity.staff;
import com.qianfeng.vo.VStaff;

import java.util.List;

public interface staffMapper {
    int deleteByPrimaryKey(String no);

    int insert(staff record);

    int insertSelective(staff record);

    staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(staff record);

    int updateByPrimaryKey(staff record);

    public List<VStaff> findAllStaff();
    /*根据员工号删除员工*/
    public void  deleteStaffById(String no );
    /*查找最后的员工No*/
    public String findLastNo();

    // 批量添加
    public void addBatch(List<staff> list);
}