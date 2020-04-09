package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.service.HotelWaiterServiceImpl;
import cn.zjut.hotel.service.HotelWaiterServiceInterface;
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
@RequestMapping("/waiter")
public class HotelWaiterController {
    private HotelWaiterServiceInterface waiterService;

    @Autowired
    public void setWaiterService(HotelWaiterServiceImpl waiterService) {
        this.waiterService = waiterService;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public JsonResult getOneWaiterById(@RequestParam("id") Integer id) {
        HotelWaiter waiter = waiterService.findOneWaiterById(id);
        if (waiter == null) {
            return JsonResult.ok("未查询到匹配的服务员信息", null);
        } else {
            return JsonResult.ok("服务员信息查询成功", waiter);
        }
    }
}
