package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelRoomType;
import cn.zjut.hotel.domain.Table;

import java.util.List;

public interface HotelRoomTypeServiceInterface {
    List<String> findTypeNames();

    Table findRoomTypes(int pageId, int pageSize, boolean asc, String roomTypeName, String sortField);

    boolean modifyRoomTypeById(HotelRoomType roomType);

    boolean addOneRoomType(HotelRoomType roomType);
}
