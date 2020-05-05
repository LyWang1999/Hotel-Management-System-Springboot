package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelRoom;
import cn.zjut.hotel.domain.Table;

import java.util.List;
import java.util.Map;

public interface HotelRoomServiceInterface {
    List<Map<String, Byte>> findRoomNumByTypes();

    Table findRooms(int pageId, int pageSize, boolean asc, HotelRoom room);

    boolean modifyOneRoomById(HotelRoom room);

    boolean addOneRoom(HotelRoom room);

    boolean removeOneRoomById(long roomId);
}
