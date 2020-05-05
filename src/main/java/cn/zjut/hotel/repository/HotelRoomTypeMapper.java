package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.HotelRoomType;
import cn.zjut.hotel.utils.CommonMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 房间类型 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface HotelRoomTypeMapper extends CommonMapper<HotelRoomType> {
    List<String> selectRoomTypeNames();
}
