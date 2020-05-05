package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelRoomType;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelRoomTypeServiceImpl;
import cn.zjut.hotel.service.HotelRoomTypeServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JsonResult getTypeNames() {
        List<String> typeNames = roomTypeService.findTypeNames();
        return JsonResult.ok("查找房间类型名成功", typeNames);
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getTypes(@PathVariable(value = "pageId") int pageId,
                               @PathVariable(value = "pageSize") int pageSize,
                               @PathVariable(value = "asc") boolean asc,
                               @RequestParam(value = "sortField", defaultValue = "roomTypeId") String sortField,
                               @RequestParam(value = "roomTypeName", defaultValue = "") String roomTypeName) {
        Table returnTable = roomTypeService.findRoomTypes(pageId, pageSize, asc, roomTypeName, sortField);
        return JsonResult.ok("查找房间类型成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeOneRoomTypeById(HotelRoomType roomType) {
        boolean res = roomTypeService.modifyRoomTypeById(roomType);
        return JsonResult.ok("修改房间类型成功", res);
    }

    @PostMapping("/info")
    public JsonResult createOneRoom(HotelRoomType roomType) {
        boolean res = roomTypeService.addOneRoomType(roomType);
        return JsonResult.ok("添加房间类型成功", res);
    }
}
