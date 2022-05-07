package com.example.xq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.xq.entity.*;
import com.example.xq.entity.common.Result;
import com.example.xq.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xq
 * @since 2020-11-20
 */

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowCredentials ="true")//设置是否允许客户端发送cookie信息。默认是false
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    RepairService repairService;
    @Autowired
    UserRoomService userRoomService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserPaymentService userPaymentService;


    //管理员登陆
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest httpServletRequest) {
        System.out.println("-----login-----");

        Admin admin1 = adminService.getOne(new QueryWrapper<Admin>().eq("username", admin.getUsername()));
        Assert.notNull(admin1, "用户不存在");

        HttpSession session= (HttpSession) httpServletRequest.getSession();
        session.setAttribute("admin",admin1);
        System.out.println(session.getId());

        if( admin.getPassword()==null ||!admin.getPassword().equals(admin1.getPassword())){
            return Result.fail("密码没填或者密码不正确！");
        }else
        return Result.succ(admin1);
    }

    //管理员新增业主
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        System.out.println("-----addUser-----");
        User user1 = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));

        if( user.getPassword() !=null && user.getUsername() != null && user.getPhone() != null && user.getSex() != null && user.getName() != null &&
            user.getUserId() != null && user.getFamily() != null  ) {
            if (user1!=null)
                return Result.fail("用户名重复");
            userService.save(user);
            return Result.succ(null);
        }else
            return Result.fail("信息未填完整！");
    }

    //删除业主
    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody User user) {
        System.out.println("-----deleteUser-----");
        if(user.getId() != null){
            userService.removeById(user.getId());
            return Result.succ(null);
        }else
            return Result.fail("没有此用户！");
    }

    //处理物管需求
    @PostMapping("/updateRepair")
    public Result updateRepair(@RequestBody Repair repair,HttpServletRequest httpServletRequest) {
        System.out.println("-----updateRepair-----");

        HttpSession session= (HttpSession) httpServletRequest.getSession();
        System.out.println(session.getId());
        Admin admin = adminService.getOne(new QueryWrapper<Admin>().eq("username","admin"));
        repair.setAdminName(admin.getName());

        boolean flag = repairService.update(repair, new UpdateWrapper<Repair>()
                .eq("id", repair.getId()));

        if (flag)
            return Result.succ(null);
        else
            return Result.fail("失败！");
    }

    //分配房屋
    @PostMapping("/sendRoom")
    public Result sendRoom(@RequestBody UserRoom userRoom) {
        System.out.println("-----sendRoom-----");
        boolean flag=false;
        //在房屋表里记录
        if (userRoom.getUserId()!=null && userRoom.getRoomId()!=null)
         flag = userRoomService.saveOrUpdate(userRoom);

        if (flag){
            //标记房屋已经被分配了
            Room room = new Room();
            room.setStatus("1");
            room.setId(userRoom.getId());
            roomService.update(room,new UpdateWrapper<Room>().eq("id",userRoom.getRoomId()));
            return Result.succ(null);
        }
        else
            return Result.fail("失败");
    }

    //删除房屋分配
    @PostMapping("/cancelRoom")
    public Result cancelRoom(@RequestBody Room room) {
        System.out.println("-----cancelRoom-----");
        boolean flag=false;
            //修改房屋入住标记
        if (room.getStatus().equals("1")) {
            room.setStatus("0");
            flag = roomService.update(room, new UpdateWrapper<Room>().eq("id", room.getId()));
        }
        else
            return Result.fail("房屋未分配！");

        if (flag){
            //删除记录表里的房屋分配
            userRoomService.remove(new QueryWrapper<UserRoom>().eq("room_id",room.getId()));
            return Result.succ(null);
        }
        else
            return Result.fail("失败");
    }

    //发物业缴费通知
    @PostMapping("/addPay")
    public Result addPay(@RequestBody UserPayment userPayment) {
        System.out.println("-----addPay-----");
        Boolean flag=false;
        //检验信息是否填完整
        if (userPayment.getUserId()!=null && userPayment.getRoomId()!=null
           && userPayment.getTime()!=null && userPayment.getValue()!=null)
            //执行数据库操作
        flag = userPaymentService.save(userPayment);

        else
            return Result.fail("信息未填完整！");

        if (flag){
           return Result.succ(null);
        }
        else
            return Result.fail("失败");
    }





}
