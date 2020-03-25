package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.Order;
import cn.zjut.hotel.repository.OrderMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询订单、添加订单、修改订单、删除订单
 *
 * @author kuluo
 */
@Service
public class OrderServiceImpl implements OrderServiceInterface {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> findAllOrders(Integer pageId, Integer pageSize) {
        PageHelper.startPage(pageId, pageSize);
        return orderMapper.selectAll();
    }
}
