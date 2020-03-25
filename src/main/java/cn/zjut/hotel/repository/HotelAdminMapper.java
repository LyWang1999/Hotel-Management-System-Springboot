package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.utils.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * 酒店管理员 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface HotelAdminMapper extends CommonMapper<HotelAdmin> {
}
