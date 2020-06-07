package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelOrderServiceImpl;
import cn.zjut.hotel.service.HotelOrderServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    @GetMapping("/num")
    public JsonResult getOrderNum() {
        int num = orderService.getOrderNum();
        return JsonResult.ok("查询订单数量成功", num);
    }

    @GetMapping("/price-sum")
    public JsonResult getOrderPriceSum() {
        long sum = orderService.getOrderPriceSum();
        return JsonResult.ok("查询订单价格总额成功", sum);
    }

    @GetMapping("/info/id/{orderId}")
    public JsonResult getOneOrderById(@PathVariable("orderId") int orderId) {
        HotelOrder order = orderService.findOneOrderById(orderId);
        return JsonResult.ok("查询订单信息成功", order);
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getOrders(@PathVariable int pageId,
                                @PathVariable int pageSize,
                                @PathVariable boolean asc,
                                @RequestParam(value = "orderId", required = false) Long orderId,
                                @RequestParam(value = "registerPhone", defaultValue = "") String registerPhone,
                                @RequestParam(value = "roomTypeName", defaultValue = "") String roomTypeName,
                                @RequestParam(value = "beginDate", defaultValue = "") String beginDateStr,
                                @RequestParam(value = "endDate", defaultValue = "") String endDateStr) throws ParseException {
        HotelOrder order = new HotelOrder();
        order.setOrderId(orderId);
        order.setRegisterPhone(registerPhone);
        order.setRoomTypeName(roomTypeName);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = null, endDate = null;
        if (!"".equals(beginDateStr)) {
            beginDate = format.parse(beginDateStr);
        }
        if (!"".equals(endDateStr)) {
            endDate = format.parse(endDateStr);
        }

        Table returnTable = orderService.findOrders(pageId, pageSize, asc, order, beginDate, endDate);

        return JsonResult.ok("订单信息查询成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeOneOrderById(@RequestBody HotelOrder order) {
        boolean res = orderService.modifyOneOrderById(order);
        return JsonResult.ok("订单信息更新成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult dropOneOrderById(@RequestBody Map<String, Long> map) {
        boolean res = orderService.removeOneOrderById(map.get("orderId"));
        return JsonResult.ok("订单信息删除成功", res);
    }
}
