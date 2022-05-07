package com.example.xq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.xq.entity.Repair;
import com.example.xq.entity.User;
import com.example.xq.entity.UserPayment;
import com.example.xq.entity.common.Result;
import com.example.xq.service.RepairService;
import com.example.xq.service.UserPaymentService;
import com.example.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xq
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials ="true")//设置是否允许客户端发送cookie信息。默认是false
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    RepairService repairService;
    @Autowired
    UserPaymentService userPaymentService;

    @PostMapping("/login")
    public Result login(@RequestBody User user ,HttpServletRequest httpServletRequest) {
        System.out.println(user);
        User user1 = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        Assert.notNull(user1, "用户不存在");

        HttpSession session= (HttpSession) httpServletRequest.getSession();
        session.setAttribute("user",user1);

        if (user.getPassword() == null || !user.getPassword().equals(user1.getPassword())) {
            return Result.fail("密码没填或者密码不正确！");
        } else
            return Result.succ(user1);
    }

    //业主上报物业
    @PostMapping("/addRepair")
    public Result addRepair(@RequestBody Repair repair, HttpServletRequest httpServletRequest) {
        System.out.println("-----addRepair-----");
        User user = userService.getOne(new QueryWrapper<User>().eq("username","1"));
        repair.setStatus("0");
        repair.setId(user.getId());
        boolean flag = false;
        if (repair.getContent() != null && repair.getTime() != null) {
            flag = repairService.save(repair);
        } else
            Result.fail("信息未填完整，上报失败！");

        if (flag)
            return Result.succ(null);

        else
            return Result.fail("失败");
    }


    //业主评价物管处理
    @PostMapping("/updateRepair")
    public Result updateRepair(@RequestBody Repair repair, HttpServletRequest httpServletRequest) {
        System.out.println("-----updateRepair-----");

        boolean flag = false;
        if (repair.getId()!=null&&repair.getResult()!=null) {
             flag = repairService.update(repair, new UpdateWrapper<Repair>().eq("id", repair.getId()));
        }else
        return Result.fail("失败");

        if (flag)
            return Result.succ(null);

        else
            return Result.fail("失败");
    }

    //业主缴费
    @PostMapping("/toPay")
    public Result toPay(@RequestBody UserPayment userPayment) {
        System.out.println("-----toPay-----");

        userPayment.setStatus(1);
        boolean flag = userPaymentService.update(userPayment, new UpdateWrapper<UserPayment>().eq("id", userPayment.getId()));

        if (flag)
            return Result.succ(null);

        else
            return Result.fail("失败");
    }

}
