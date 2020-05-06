package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelMessage;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelMessageServiceImpl;
import cn.zjut.hotel.service.HotelMessageServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/message")
public class HotelMessageController {
    private HotelMessageServiceInterface messageService;

    @Autowired
    public void setMessageService(HotelMessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getMessages(@PathVariable int pageId,
                                  @PathVariable int pageSize,
                                  @PathVariable boolean asc,
                                  @RequestParam(value = "beginDate", defaultValue = "") String begin,
                                  @RequestParam(value = "endDate", defaultValue = "") String end,
                                  @RequestParam(value = "sortField", defaultValue = "") String sortField) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = null, endDate = null;
        if (!StringUtils.isEmpty(begin)) {
            beginDate = format.parse(begin);
        }
        if (!StringUtils.isEmpty(end)) {
            endDate = format.parse(end);
        }

        Table returnTable = messageService.findMessages(pageId, pageSize, asc, beginDate, endDate, sortField);
        return JsonResult.ok("查找公告信息成功", returnTable);
    }

    @PostMapping("/info")
    public JsonResult addOneMessage(@RequestBody HotelMessage message) {
        boolean res = messageService.addOneMessage(message);
        return JsonResult.ok("添加公告信息成功", res);
    }

    @PatchMapping("/info")
    public JsonResult changeOneMessageById(@RequestBody HotelMessage message) {
        boolean res = messageService.modifyOneMessageById(message);
        return JsonResult.ok("修改公告信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult dropOneMessageById(@RequestBody Map<String, Long> map) {
        boolean res = messageService.removeOneMessageById(map.get("messageId"));
        return JsonResult.ok("删除公告信息成功", res);
    }
}
