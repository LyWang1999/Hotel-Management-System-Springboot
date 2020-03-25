package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.service.LoginServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现服务员和管理员登录后台管理系统
 *
 * @author kuluo
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private LoginServiceInterface loginService;

    @Autowired
    public void setLoginService(LoginServiceInterface loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public JsonResult getWaiterAccount(HotelWaiter waiter) {
        boolean result = loginService.findWaiterAccount(waiter);
        if (result) {
            return JsonResult.ok("服务员登录成功", true);
        } else {
            return JsonResult.ok("服务员登录失败", false);
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public JsonResult getAdminAccount(HotelAdmin admin) {
        boolean result = loginService.findAdminAccount(admin);
        if (result) {
            return JsonResult.ok("管理员登录成功", true);
        } else {
            return JsonResult.ok("管理员登录失败", false);
        }
    }

}
