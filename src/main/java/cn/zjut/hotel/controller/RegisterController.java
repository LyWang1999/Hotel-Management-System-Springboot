package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.Register;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.RegisterServiceImpl;
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
public class RegisterController {
    private RegisterServiceInterface registerService;

    @Autowired
    public void setRegisterService(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getRegisters(@PathVariable int pageId,
                                   @PathVariable int pageSize,
                                   @PathVariable boolean asc,
                                   @RequestParam(value = "registerPhone", defaultValue = "") String registerPhone,
                                   @RequestParam(value = "registerAccount", defaultValue = "") String registerAccount) {
        Register register = new Register();
        register.setRegisterPhone(registerPhone);
        register.setRegisterAccount(registerAccount);
        Table returnTable = registerService.findRegisters(pageId, pageSize, asc, register);

        return JsonResult.ok("注册用户信息查询成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeRegisterById(@RequestBody Register register) {
        boolean res = registerService.modifyOneRegisterById(register);
        return JsonResult.ok("修改注册用户信息成功", res);
    }

    @PostMapping("/info")
    public JsonResult createOneRegisterById(@RequestBody Register register) {
        boolean res = registerService.addOneRegisterById(register);
        return JsonResult.ok("添加注册用户信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult dropOneRegisterById(@RequestBody Map<String, Integer> map) {
        boolean res = registerService.removeOneRegisterById(map.get("registerId"));
        return JsonResult.ok("删除注册用户信息成功", res);
    }

}
