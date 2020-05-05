package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelRegister;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelRegisterServiceImpl;
import cn.zjut.hotel.service.RegisterServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/register")
public class HotelRegisterController {
    private RegisterServiceInterface registerService;

    @Autowired
    public void setRegisterService(HotelRegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/info/phone/{registerPhone}")
    public JsonResult getOneRegisterById(@PathVariable String registerPhone) {
        HotelRegister register = registerService.findOneRegisterById(registerPhone);
        return JsonResult.ok("注册用户信息查询成功", register);
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getRegisters(@PathVariable int pageId,
                                   @PathVariable int pageSize,
                                   @PathVariable boolean asc,
                                   @RequestParam(value = "registerPhone", defaultValue = "") String registerPhone,
                                   @RequestParam(value = "registerAccount", defaultValue = "") String registerAccount) {
        HotelRegister register = new HotelRegister();
        register.setRegisterPhone(registerPhone);
        register.setRegisterAccount(registerAccount);
        Table returnTable = registerService.findRegisters(pageId, pageSize, asc, register);

        return JsonResult.ok("注册用户信息查询成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeRegisterById(@RequestBody HotelRegister register) {
        boolean res = registerService.modifyOneRegisterById(register);
        return JsonResult.ok("修改注册用户信息成功", res);
    }

    @PostMapping("/info")
    public JsonResult createOneRegister(@RequestBody HotelRegister register) {
        boolean res = registerService.addOneRegisterById(register);
        return JsonResult.ok("添加注册用户信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult dropOneRegisterById(@RequestBody Map<String, Long> map) {
        boolean res = registerService.removeOneRegisterById(map.get("registerId"));
        return JsonResult.ok("删除注册用户信息成功", res);
    }

}
