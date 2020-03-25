package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.Order;

import java.util.List;

/**
 * 查询订单、添加订单、修改订单、删除订单
 *
 * @author kuluo
 */
public interface OrderServiceInterface {
    /**
     * 查询所有订单
     *
     * @param pageId   页号
     * @param pageSize 每页大小
     * @return 订单集合
     */
    List<Order> findAllOrders(Integer pageId, Integer pageSize);
}
