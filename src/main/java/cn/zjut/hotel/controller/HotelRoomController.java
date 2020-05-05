package cn.zjut.hotel.controller;

import cn.zjut.hotel.domain.HotelRoom;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.service.HotelRoomServiceInterface;
import cn.zjut.hotel.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/empty/num")
    public JsonResult getEmptyRoomNumByAllTypes() {
        List<Map<String, Byte>> map = roomService.findEmptyRoomNumByAllTypes();
        return JsonResult.ok("房间类型及数量查询成功", map);
    }

    @GetMapping("/empty/type")
    public JsonResult getEmptyRoomsByType(@RequestParam(value = "roomTypeName", defaultValue = "") String roomTypeName) {
        List<HotelRoom> roomList = roomService.findEmptyRoomsByType(roomTypeName);
        return JsonResult.ok("房间类型查找成功", roomList);
    }

    @GetMapping("/info/page/{pageId}/limit/{pageSize}/asc/{asc}")
    public JsonResult getRooms(@PathVariable int pageId,
                               @PathVariable int pageSize,
                               @PathVariable boolean asc,
                               @RequestParam(value = "roomNo", defaultValue = "") String roomNo,
                               @RequestParam(value = "roomTypeName", defaultValue = "") String roomTypeName,
                               @RequestParam(value = "empty", required = false) Byte empty) {
        HotelRoom room = new HotelRoom();
        room.setRoomNo(roomNo);
        room.setRoomTypeName(roomTypeName);
        room.setEmpty(empty);
        Table returnTable = roomService.findRooms(pageId, pageSize, asc, room);

        return JsonResult.ok("查找房间信息成功", returnTable);
    }

    @PatchMapping("/info")
    public JsonResult changeOneRoomById(@RequestBody HotelRoom room) {
        boolean res = roomService.modifyOneRoomById(room);
        return JsonResult.ok("修改房间信息成功", res);
    }

    @PostMapping("/info")
    public JsonResult createOneRoom(@RequestBody HotelRoom room) {
        boolean res = roomService.addOneRoom(room);
        return JsonResult.ok("添加房间信息成功", res);
    }

    @DeleteMapping("/info")
    public JsonResult dropOneRoomById(@RequestBody Map<String, Long> map) {
        boolean res = roomService.removeOneRoomById(map.get("roomId"));
        return JsonResult.ok("删除房间信息成功", res);
    }
}
