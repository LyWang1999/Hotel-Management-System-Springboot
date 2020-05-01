package cn.zjut.hotel.service;

import cn.zjut.hotel.repository.HotelRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author kuluo
 */
@Service
public class HotelRoomServiceImpl implements HotelRoomServiceInterface {
    private HotelRoomMapper roomMapper;

    @Autowired
    public void setRoomMapper(HotelRoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public List<Map<String, Byte>> findRoomNumByTypes() {
        return roomMapper.selectRoomNumByTypes();
    }
}
