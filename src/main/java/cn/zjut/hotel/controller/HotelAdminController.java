package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.service.HotelAdminServiceImpl;
import cn.zjut.hotel.service.HotelAdminServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/admin")
public class HotelAdminController {
    private HotelAdminServiceInterface adminService;

    @Autowired
    public void setAdminService(HotelAdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public JsonResult getOneAdminById(@RequestParam("id") Integer id) {
        HotelAdmin admin = adminService.findOneAdminById(id);
        if (admin == null) {
            return JsonResult.ok("未查询到匹配的管理员信息", null);
        } else {
            return JsonResult.ok("管理员信息查询成功", admin);
        }
    }
}
