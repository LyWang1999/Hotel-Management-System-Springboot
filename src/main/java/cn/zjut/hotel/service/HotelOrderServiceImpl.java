package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelOrderMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 查询订单、添加订单、修改订单、删除订单
 *
 * @author kuluo
 */
@Service
public class HotelOrderServiceImpl implements HotelOrderServiceInterface {
    private HotelOrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(HotelOrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Table findOrders(int pageId, int pageSize, boolean asc, HotelOrder order, Date beginDate, Date endDate) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelOrder.class);
        Example.Criteria criteria = example.createCriteria();

        if (order.getOrderId() != null && order.getOrderId() != 0) {
            criteria.andEqualTo("orderId", order.getOrderId());
        }
        if (!StringUtils.isEmpty(order.getRegisterPhone())) {
            criteria.andEqualTo("registerPhone", order.getRegisterPhone());
        }
        if (!StringUtils.isEmpty(order.getRoomTypeName())) {
            criteria.andEqualTo("roomTypeName", order.getRoomTypeName());
        }
        if (beginDate != null) {
            criteria.andGreaterThanOrEqualTo("orderCreatedTime", beginDate);
        }
        if (endDate != null) {
            criteria.andLessThanOrEqualTo("orderCreatedTime", endDate);
        }

        if (asc) {
            example.orderBy("orderId").asc();
        } else {
            example.orderBy("orderId").desc();
        }

        List<HotelOrder> orderList = orderMapper.selectByExample(example);
        long count = ((Page<HotelOrder>) orderList).getTotal();

        return new Table(orderList, count);
    }

    @Override
    public HotelOrder findOneOrderById(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public boolean modifyOneOrderById(HotelOrder order) {
        return orderMapper.updateByPrimaryKeySelective(order) > 0;
    }

    @Override
    public boolean removeOneOrderById(long orderId) {
        return orderMapper.deleteByPrimaryKey(orderId) > 0;
    }
}
