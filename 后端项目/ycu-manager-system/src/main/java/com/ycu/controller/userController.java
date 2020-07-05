package com.ycu.controller;

import com.sun.xml.internal.xsom.impl.UName;
import com.ycu.pojo.user;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ycu.service.userService;

import java.util.List;

@RestController
public class userController
{
    @Resource
    private userService userSerive;

    @RequestMapping("/queryAlluser")
    public List<user> queryAlluser()
    {
        return userSerive.selectAllUser();
    }
    @RequestMapping("/deleteUser/{id}")
    public int deleteUsER(@PathVariable("id") String id)
    {
        return userSerive.deleteUser(id);
    }


    @RequestMapping("/insertUser")
  @ResponseBody
    public void insertUser(  @RequestBody user user)
    {
        userSerive.inseertUser(user);
    }

    @RequestMapping("/updateUser")
    public int updateUser(  @RequestBody user user)
    {
        return userSerive.UpdateUser(user);
    }

    @RequestMapping("/selectUser")
    public user selece(@RequestParam("uname") String uname,@RequestParam("upassword") String upassword)
    {
        return userSerive.selectUser(uname,upassword);
    }
    //查找项目负责人
   @RequestMapping("/projectUser")
    public List<String>  selectprojectUser()
   {
       return userSerive.selectProjectUser();
   }

   //查找普通员工
    @RequestMapping("/queryStaff")
    public List<String> selectStaff()
    {
        return userSerive.selectStaff();
    }

    //修改个人信息
    @RequestMapping("/updateUserOne")
    public user  updateUser1(@RequestBody user user)
    {
        return userSerive.updateUserInfo(user);
    }
    //修改密码
    @RequestMapping("/updatePassword")
    public user updatePS(@RequestBody user user)
    {
        return userSerive.updatePsssword(user);
    }

}
