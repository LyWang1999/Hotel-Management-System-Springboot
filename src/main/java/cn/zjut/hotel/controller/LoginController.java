package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.service.LoginServiceImpl;
import cn.zjut.hotel.service.LoginServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 服务员和管理员登录
 *
 * @author kuluo
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private LoginServiceInterface loginService;

    @Autowired
    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public JsonResult getWaiterAccount(@RequestParam("username") String waiterNo,
                                       @RequestParam("password") String waiterPassword) {
        HotelWaiter waiter = new HotelWaiter();
        waiter.setWaiterNo(waiterNo);
        waiter.setWaiterPassword(waiterPassword);
        Map<String, Object> map = loginService.findWaiterAccount(waiter);
        if (map == null) {
            return JsonResult.ok("服务员登录失败", null);
        } else {
            return JsonResult.ok("服务员登录成功", map);
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public JsonResult getAdminAccount(@RequestParam("username") String adminNo,
                                      @RequestParam("password") String adminPassword) {
        HotelAdmin admin = new HotelAdmin();
        admin.setAdminNo(adminNo);
        admin.setAdminPassword(adminPassword);
        Map<String, Object> map = loginService.findAdminAccount(admin);
        if (map == null) {
            return JsonResult.ok("管理员登录失败", null);
        } else {
            return JsonResult.ok("管理员登录成功", map);
        }
    }

}
