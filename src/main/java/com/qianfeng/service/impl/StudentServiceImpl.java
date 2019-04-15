package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.studentMapper;
import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.student;
import com.qianfeng.service.StudentService;
import com.qianfeng.vo.VGrade;
import com.qianfeng.vo.VStudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
private studentMapper studentMapper;

    @Override
    public void StudentAdd(student student) {

        studentMapper.insert(student);
    }

    @Override
    public void AddStudengbatch(List<student> list) {


        // 每100条记录，进行一次批量操作
        int count = 1;
        List<student> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                studentMapper.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            studentMapper.addBatch(tempList);
        }
    }

    @Override
    public Map<String, Object> findStudentAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<VStudentList>  list = studentMapper.findAllStudent();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page)list).getTotal();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;
    }

    @Override
    public void deleteStudentByNo(String no) {
        studentMapper.deleteStudent(no);
    }

    @Override
    public void updateStudent(student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }


}
