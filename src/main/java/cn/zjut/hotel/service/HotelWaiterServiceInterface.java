package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.domain.Table;

public interface HotelWaiterServiceInterface {
    HotelWaiter findOneWaiterById(Integer id);

    Table findWaiters(int pageId, int pageSize, boolean asc, HotelWaiter waiter);

    boolean modifyOneWaiterById(HotelWaiter waiter);

    boolean addOneWaiter(HotelWaiter waiter);

    boolean removeOneWaiterById(int waiterId);
}
