package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.utils.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * 订单 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface HotelOrderMapper extends CommonMapper<HotelOrder> {
}
