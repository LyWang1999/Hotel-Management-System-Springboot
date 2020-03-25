package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.Order;
import cn.zjut.hotel.service.OrderServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询订单、添加订单、修改订单、删除订单
 *
 * @author kuluo
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderServiceInterface orderService;

    @Autowired
    public void setOrderService(OrderServiceInterface orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult getAllOrders(Integer pageId, Integer pageSize) {
        List<Order> orderList = orderService.findAllOrders(pageId, pageSize);
        return JsonResult.ok("第" + pageId + "页的数据查询成功", orderList);
    }
}
