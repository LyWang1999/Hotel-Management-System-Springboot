package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelAdminServiceImpl;
import cn.zjut.hotel.service.HotelAdminServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/info")
    public JsonResult getOneAdminById(@RequestParam("id") Integer id) {
        HotelAdmin admin = adminService.findOneAdminById(id);
        if (admin == null) {
            return JsonResult.ok("未查询到匹配的管理员信息", null);
        } else {
            return JsonResult.ok("管理员信息查询成功", admin);
        }
    }

    @GetMapping(value = "/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getAdmins(@PathVariable int pageId,
                                @PathVariable int pageSize,
                                @PathVariable boolean asc,
                                @RequestParam(value = "adminNo", defaultValue = "") String adminNo,
                                @RequestParam(value = "adminName", defaultValue = "") String adminName,
                                @RequestParam(value = "adminDuty", defaultValue = "") String adminDuty) {
        HotelAdmin admin = new HotelAdmin();
        admin.setAdminNo(adminNo);
        admin.setAdminName(adminName);
        admin.setAdminDuty(adminDuty);
        List<HotelAdmin> adminList = adminService.findAdmins(pageId, pageSize, asc, admin);

        int num = adminService.getNum();

        Table returnTable = new Table(adminList, num);
        return JsonResult.ok("管理员信息查询成功", returnTable);
    }
}
