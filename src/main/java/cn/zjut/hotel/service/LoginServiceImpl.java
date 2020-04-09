package cn.zjut.hotel.service;

import cn.zjut.hotel.config.RoleToken;
import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.repository.HotelAdminMapper;
import cn.zjut.hotel.repository.HotelWaiterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现服务员和管理员登录后台管理系统
 *
 * @author kuluo
 */
@Service
public class LoginServiceImpl implements LoginServiceInterface {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
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
    public Map<String, Object> findWaiterAccount(HotelWaiter waiter) {
        if (waiter.getWaiterNo() == null || waiter.getWaiterPassword() == null) {
            logger.info("登录失败，服务员工号或密码为空");
            return null;
        }

        List<HotelWaiter> waiterList = waiterMapper.select(waiter);
        if (waiterList.isEmpty()) {
            logger.info("登录失败，用户名或密码错误");
            return null;
        } else {
            Map<String, Object> map = new HashMap<>(2);
            map.put("token", RoleToken.WAITER.getTokenName());
            map.put("id", waiterList.get(0).getWaiterId());
            return map;
        }
    }

    @Override
    public Map<String, Object> findAdminAccount(HotelAdmin admin) {
        if (admin.getAdminNo() == null || admin.getAdminPassword() == null) {
            logger.info("登录失败，管理员工号或密码为空");
            return null;
        }

        List<HotelAdmin> adminList = adminMapper.select(admin);
        if (adminList.isEmpty()) {
            logger.info("登录失败，用户名或密码错误");
            return null;
        } else {
            Map<String, Object> map = new HashMap<>(2);
            map.put("token", RoleToken.ADMIN.getTokenName());
            map.put("id", adminList.get(0).getAdminId());
            return map;
        }
    }
}
