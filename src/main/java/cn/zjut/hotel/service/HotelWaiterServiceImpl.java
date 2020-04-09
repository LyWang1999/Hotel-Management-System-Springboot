package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.repository.HotelWaiterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kuluo
 */
@Service
public class HotelWaiterServiceImpl implements HotelWaiterServiceInterface {
    private static Logger logger = LoggerFactory.getLogger(HotelWaiterServiceImpl.class);
    private HotelWaiterMapper waiterMapper;

    @Autowired
    public void setWaiterMapper(HotelWaiterMapper waiterMapper) {
        this.waiterMapper = waiterMapper;
    }

    @Override
    public HotelWaiter findOneWaiterById(Integer id) {
        if (id == null) {
            logger.info("查询失败，主键为空");
            return null;
        }

        HotelWaiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter == null) {
            logger.info("查询失败，未找到匹配的服务员信息");
            return null;
        } else {
            return waiter;
        }
    }
}
