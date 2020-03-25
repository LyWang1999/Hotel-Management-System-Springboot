package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.repository.HotelAdminMapper;
import cn.zjut.hotel.repository.HotelWaiterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现服务员和管理员登录后台管理系统
 *
 * @author kuluo
 */
@Service
public class LoginServiceImpl implements LoginServiceInterface {
    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private HotelAdminMapper adminMapper;
    private HotelWaiterMapper waiterMapper;

    @Autowired
    public void setAdminMapper(HotelAdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Autowired
    public void setWaiterMapper(HotelWaiterMapper waiterMapper) {
        this.waiterMapper = waiterMapper;
    }

    @Override
    public boolean findWaiterAccount(HotelWaiter waiter) {
        if (waiter == null) {
            logger.info("由LoginController传入LoginService的findWaiterAccount方法参数为空");
            return false;
        }

        List<HotelWaiter> waiterList = waiterMapper.select(waiter);
        return waiterList != null && waiterList.size() == 1;
    }

    @Override
    public boolean findAdminAccount(HotelAdmin admin) {
        if (admin == null) {
            logger.info("由LoginController传入LoginService的findAdminAccount方法参数为空");
            return false;
        }

        List<HotelAdmin> adminList = adminMapper.select(admin);
        return adminList != null && adminList.size() == 1;
    }
}
