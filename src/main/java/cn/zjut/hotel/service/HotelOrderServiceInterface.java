package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.domain.Table;

import java.util.Date;

/**
 * 查询订单、添加订单、修改订单、删除订单
 *
 * @author kuluo
 */
public interface HotelOrderServiceInterface {
    Table findOrders(int pageId, int pageSize, boolean asc, HotelOrder order, Date beginDate, Date endDate);

    HotelOrder findOneOrderById(int orderId);

    boolean modifyOneOrderById(HotelOrder order);

    boolean removeOneOrderById(int orderId);
}
