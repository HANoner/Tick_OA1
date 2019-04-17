package com.qianfeng.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.ImportExcel;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@ResponseBody
@RequiresPermissions("fa-users")
public class StaffServlet {
    @Autowired
    private StaffService staffService;

    @RequestMapping("/staff/list.do")
    public Map<String, Object> findAllGrade(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = staffService.findAllGrade(page,pageSize);
        return map;
    }
    @RequestMapping("/staff/delete.do")
    public JsonBean deleteStaffById(String no){
        staffService.deleteStaff(no);
        return  JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/photoupload.do")
    public JsonBean upload(@RequestParam("file") MultipartFile upfile, HttpServletRequest request, HttpSession session){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取上传文件的文件名
        String fileName = upfile.getOriginalFilename();
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称

        String newFileName = uuid + "."+ suffixName;
        System.out.println(newFileName);

        session.setAttribute("newFileName",newFileName);
        String path = request.getServletContext().getRealPath("/");
        System.out.println(path);
        File parentPath = new File(path);
        // 获取父级目录的路径
        path = parentPath.getParent() + "/webapp/media/images";

        System.out.println("path == " + path);

        File dirPath = new File(path);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
        //upfile.getInputStream()
        File file = new File(path, newFileName);

        try {
            // 保存文件
            upfile.transferTo(file);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/staff/update.do")
    public JsonBean updataStaff(staff staff,HttpSession session){
        /*获取上传文件的名字*/
        String fileName = (String)session.getAttribute("newFileName");
        /*取值之后清除该属性*/
        session.removeAttribute("newFileName");
        /*如果名字不为空，就将原来实体中的文件名重新设置*/
        if (fileName !=null){
        staff.setPhoto(fileName);
        }
        staffService.updateStaff(staff);
        return  JsonUtils.createJsonBean(1,null);

    }
    @RequestMapping("/staff/add.do")
    public JsonBean addStaff(staff staff,HttpSession session){
        /*获取上传t头像的名字*/
        String fileName = (String)session.getAttribute("newFileName");
        /*取值之后清除该属性*/
        session.removeAttribute("newFileName");
        /*如果名字不为空，就将原来实体中的文件名重新设置*/
        if (fileName !=null){
            staff.setPhoto(fileName);
        }
        staff.setFlag(1);
        staffService.addStaff(staff);
        return JsonUtils.createJsonBean(1,"添加成功");
    }
    @RequestMapping("/staff/lastNo.do")
    public Map<String,Object> findLastNo(){
        String lastNo = staffService.findLastNo();
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg",lastNo);
       return  map;
    }

    @RequestMapping("/staff/import.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile mFile){


        try {
            String fileName = mFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = mFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

            // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
            ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(sourceList);

            // json字符串转对象
            List<staff> list = objMapper.readValue(infos, new TypeReference<List<staff>>() {});

            // 批量添加
            staffService.addStaffBatch(list);

            return JsonUtils.createJsonBean(1, "添加成功");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return JsonUtils.createJsonBean(0, e.getMessage());
        }

    }
}
