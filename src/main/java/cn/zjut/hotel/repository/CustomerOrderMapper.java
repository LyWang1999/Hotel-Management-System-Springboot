package cn.zjut.hotel.repository;

import cn.zjut.hotel.domain.CustomerOrder;
import cn.zjut.hotel.utils.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * 入住顾客订单 DAO 类
 *
 * @author kuluo
 */
@Repository
public interface CustomerOrderMapper extends CommonMapper<CustomerOrder> {
}
