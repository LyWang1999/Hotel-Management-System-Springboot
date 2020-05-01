package cn.zjut.hotel.controller;

import cn.zjut.hotel.service.HotelRoomServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/room")
public class HotelRoomController {
    private HotelRoomServiceInterface roomService;

    @Autowired
    public void setRoomService(HotelRoomServiceInterface roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/spare-num")
    public JsonResult getRoomNumByTypes() {
        List<Map<String, Byte>> map = roomService.findRoomNumByTypes();
        return JsonResult.ok("房间类型及数量查询成功", map);
    }
}
