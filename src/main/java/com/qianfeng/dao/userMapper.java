package com.qianfeng.dao;

import com.qianfeng.entity.user;
import com.qianfeng.vo.VUserLimit;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    /*以下  shiro 权限控制*/
    public user findPwdByName(String name);

    public List<String> findRoleByName(String name);

    public List<String> findPermisionByName(String name);


    /*个人信息的展示*/

    public user findUser(String no);


    public List<VUserLimit> findSearch(@Param("no") String no, @Param("flag") Integer flag);

    public  void userDelById(int id);
}