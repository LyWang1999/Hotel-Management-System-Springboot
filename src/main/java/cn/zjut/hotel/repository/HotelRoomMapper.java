package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.HotelRoom;
import cn.zjut.hotel.utils.CommonMapper;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 房间 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface HotelRoomMapper extends CommonMapper<HotelRoom> {
    @MapKey("roomTypeName")
    List<Map<String, Byte>> selectRoomNumByTypes();
}
