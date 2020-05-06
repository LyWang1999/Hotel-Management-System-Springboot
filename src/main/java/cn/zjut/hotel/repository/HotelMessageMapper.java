package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.HotelMessage;
import cn.zjut.hotel.utils.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * 通知 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface HotelMessageMapper extends CommonMapper<HotelMessage> {
}
