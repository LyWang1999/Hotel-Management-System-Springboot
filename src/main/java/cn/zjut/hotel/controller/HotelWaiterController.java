package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelWaiterServiceImpl;
import cn.zjut.hotel.service.HotelWaiterServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/Info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getWaiters(@PathVariable int pageId,
                                 @PathVariable int pageSize,
                                 @PathVariable boolean asc,
                                 @RequestParam(value = "waiterNo", required = false) String waiterNo,
                                 @RequestParam(value = "waiterName", required = false) String waiterName,
                                 @RequestParam(value = "beginWorkTime", required = false) String beginWorkTime,
                                 @RequestParam(value = "endWorkTime", required = false) String endWorkTime,
                                 @RequestParam(value = "workDay", required = false) String workDay) {
        HotelWaiter waiter = new HotelWaiter();
        waiter.setWaiterNo(waiterNo);
        waiter.setWaiterName(waiterName);
        waiter.setBeginWorkTime(!StringUtils.isEmpty(beginWorkTime) ? Time.valueOf(beginWorkTime + ":00") : null);
        waiter.setEndWorkTime(!StringUtils.isEmpty(endWorkTime) ? Time.valueOf(endWorkTime + ":00") : null);
        waiter.setWorkDay(workDay);
        List<HotelWaiter> waiterList = waiterService.findWaiters(pageId, pageSize, asc, waiter);

        int num = waiterService.getNum();

        Table returnTable = new Table(waiterList, num);
        return JsonResult.ok("服务员信息查询成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeWaiterById(@RequestBody HotelWaiter waiter) {
        boolean res = waiterService.modifyOneWaiterById(waiter);
        return JsonResult.ok("修改服务员信息成功", res);
    }

    @PostMapping("/info")
    public JsonResult addOneWaiterById(@RequestBody HotelWaiter waiter) {
        boolean res = waiterService.addOneWaiter(waiter);
        return JsonResult.ok("添加服务员信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult deleteOneWaiterById(@RequestBody Map<String, Integer> map) {
        boolean res = waiterService.removeOneWaiterById(map.get("waiterId"));
        return JsonResult.ok("删除服务员信息成功", res);
    }
}
