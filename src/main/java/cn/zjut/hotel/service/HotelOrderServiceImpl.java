package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelOrder;
import cn.zjut.hotel.repository.HotelOrderMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<HotelOrder> findOrders(Integer pageId, Integer pageSize) {
        PageHelper.startPage(pageId, pageSize);
        return orderMapper.selectAll();
    }

    @Override
    public HotelOrder findOneOrderById(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
