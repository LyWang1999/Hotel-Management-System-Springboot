package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelCheckCustomer;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelCheckCustomerServiceImpl;
import cn.zjut.hotel.service.HotelCheckCustomerServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/check-customer")
public class HotelCheckCustomerController {
    private HotelCheckCustomerServiceInterface checkCustomerService;

    @Autowired
    public void setCheckCustomerService(HotelCheckCustomerServiceImpl checkCustomerService) {
        this.checkCustomerService = checkCustomerService;
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getCheckCustomers(@PathVariable int pageId,
                                        @PathVariable int pageSize,
                                        @PathVariable boolean asc,
                                        @RequestParam(value = "checkCustomerIdCard", defaultValue = "") String checkCustomerIdCard,
                                        @RequestParam(value = "checkCustomerPhone", defaultValue = "") String checkCustomerPhone,
                                        @RequestParam(value = "checkCustomerName", defaultValue = "") String checkCustomerName,
                                        @RequestParam(value = "orderId", defaultValue = "0") long orderId,
                                        @RequestParam(value = "roomNo", defaultValue = "") String roomNo) {
        HotelCheckCustomer checkCustomer = new HotelCheckCustomer();
        checkCustomer.setCheckCustomerIdCard(checkCustomerIdCard);
        checkCustomer.setCheckCustomerName(checkCustomerName);
        checkCustomer.setCheckCustomerPhone(checkCustomerPhone);
        checkCustomer.setOrderId(orderId);
        checkCustomer.setRoomNo(roomNo);
        Table returnTable = checkCustomerService.findCheckCustomers(pageId, pageSize, asc, checkCustomer);

        return JsonResult.ok("查询入住顾客信息成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeOneCheckCustomerById(@RequestBody HotelCheckCustomer checkCustomer) {
        boolean res = checkCustomerService.modifyOneCheckCustomerById(checkCustomer);
        return JsonResult.ok("修改入住顾客信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult deleteOneCheckCustomerById(@RequestBody Map<String, Long> map) {
        boolean res = checkCustomerService.removeOneCheckCustomer(map.get("checkCustomerId"));
        return JsonResult.ok("删除入住顾客信息成功", res);
    }
}
