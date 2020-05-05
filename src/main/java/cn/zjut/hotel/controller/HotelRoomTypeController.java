package cn.zjut.hotel.controller;

import cn.zjut.hotel.service.HotelRoomTypeServiceImpl;
import cn.zjut.hotel.service.HotelRoomTypeServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kuluo
 */
@RestController
@RequestMapping("/room-type")
public class HotelRoomTypeController {
    private HotelRoomTypeServiceInterface roomTypeService;

    @Autowired
    public void setRoomTypeService(HotelRoomTypeServiceImpl roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/types")
    public JsonResult getTypes() {
        List<String> typeNames = roomTypeService.findTypes();
        return JsonResult.ok("查找房间类型成功", typeNames);
    }
}
