package com.example.xq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xq.entity.*;
import com.example.xq.entity.common.Result;
import com.example.xq.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xq
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/query")
@CrossOrigin(allowCredentials ="true")//设置是否允许客户端发送cookie信息。默认是false
public class QueryController {

    @Autowired
    BuildingService buildingService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;
    @Autowired
    RepairService repairService;
    @Autowired
    UserRoomService userRoomService;
    @Autowired
    UserPaymentService userPaymentService;

    //获取所有的楼
    @PostMapping("/building")
    public Result building() {
        System.out.println("-----building-----");
        List<Building> list = buildingService.list();
        return Result.succ(list);
    }

    //根据楼获取相应的房子
    @PostMapping(value = "/room", produces = { "application/json;charset=UTF-8" })
    public Result room(@RequestBody Map<String,Integer> date) {
        System.out.println("-----room-----");
        List<Room> list = roomService.list(new QueryWrapper<Room>().eq("building_id",date.get("id")));
        return Result.succ(list);
    }

    //获取所有的业主
    @PostMapping("/user")
    public Result user() {
        System.out.println("-----user-----");
        List<User> list = userService.list();
        return Result.succ(list);
    }

    //管理员获取所有物管需求单
    @PostMapping("/repair")
    public Result repair() {
        System.out.println("-----repair-----");
        List<Repair> list = repairService.list(new QueryWrapper<Repair>().ne("user_id",""));
        return Result.succ(list);
    }

    //业主获取自己的物管需求单
    @PostMapping("/userRepair")
    public Result userRepair(HttpServletRequest httpServletRequest) {
        System.out.println("-----userRepair-----");
        User user = userService.getOne(new QueryWrapper<User>().eq("username","1"));
        List<Repair> list = repairService.list(new QueryWrapper<Repair>().eq("user_id",user.getId()));
        return Result.succ(list);
    }

    //管理员获取所有物业缴费单
    @PostMapping("/payment")
    public Result payment() {
        System.out.println("-----payment-----");
        List<UserPayment> list = userPaymentService.list();
        return Result.succ(list);
    }

    //业主获取自己的物业缴费单
    @PostMapping("/userPayment")
    public Result userPayment(HttpServletRequest httpServletRequest) {
        System.out.println("-----userPayment-----");
        User user = userService.getOne(new QueryWrapper<User>().eq("username","1"));
        List<UserPayment> list = userPaymentService.list(new QueryWrapper<UserPayment>().eq("user_id",user.getId()));
        return Result.succ(list);
    }

    //管理员获取所有房屋登记表
    @PostMapping("/userRoom")
    public Result userRoom() {
        System.out.println("-----userRoom-----");
        List<UserRoom> list = userRoomService.list();
        return Result.succ(list);
    }

    //业主获取自己的房屋登记表
    @PostMapping("/myRoom")
    public Result myRoom(HttpServletRequest httpServletRequest) {
        System.out.println("-----myRoom-----");
        User user = userService.getOne(new QueryWrapper<User>().eq("username","1"));
        List<UserRoom> list = userRoomService.list(new QueryWrapper<UserRoom>().eq("user_id",user.getId()));
        return Result.succ(list);
    }

}
