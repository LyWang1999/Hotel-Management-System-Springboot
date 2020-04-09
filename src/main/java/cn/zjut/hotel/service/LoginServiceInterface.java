package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.domain.HotelWaiter;

import java.util.Map;

/**
 * 实现服务员和管理员登录后台管理系统
 *
 * @author kuluo
 */
public interface LoginServiceInterface {
    /**
     * 服务员登录
     *
     * @param waiter 包含服务员的账号和密码
     * @return 若查找到则返回true，否则返回false
     */
    Map<String, Object> findWaiterAccount(HotelWaiter waiter);

    /**
     * 管理员登录
     *
     * @param admin 包含管理员的账号和密码
     * @return 若查找到则返回true，否则返回false
     */
    Map<String, Object> findAdminAccount(HotelAdmin admin);
}
