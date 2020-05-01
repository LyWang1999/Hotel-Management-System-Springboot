package cn.zjut.hotel.service;

import java.util.List;
import java.util.Map;

public interface HotelRoomServiceInterface {
    List<Map<String, Byte>> findRoomNumByTypes();
}
