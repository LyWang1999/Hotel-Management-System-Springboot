package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.service.HotelOrderServiceImpl;
import cn.zjut.hotel.service.HotelOrderServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/order")
public class HotelOrderController {
    private HotelOrderServiceInterface orderService;

    @Autowired
    public void setOrderService(HotelOrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/info/id/{orderId}")
    public JsonResult getOneOrderById(@PathVariable("orderId") int orderId) {
        HotelOrder order = orderService.findOneOrderById(orderId);
        return JsonResult.ok("查询订单信息成功", order);
    }
}
