package cn.zjut.hotel.service;

import cn.zjut.hotel.repository.HotelRoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kuluo
 */
@Service
public class HotelRoomTypeServiceImpl implements HotelRoomTypeServiceInterface {
    private HotelRoomTypeMapper roomTypeMapper;

    @Autowired
    public void setRoomTypeMapper(HotelRoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    @Override
    public List<String> findTypes() {
        return roomTypeMapper.selectRoomTypeNames();
    }
}
