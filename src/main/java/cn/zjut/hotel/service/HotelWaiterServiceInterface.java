package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelWaiter;

import java.util.List;

public interface HotelWaiterServiceInterface {
    HotelWaiter findOneWaiterById(Integer id);

    int getNum();

    List<HotelWaiter> findWaiters(int pageId, int pageSize, boolean asc, HotelWaiter waiter);

    boolean modifyOneWaiterById(HotelWaiter waiter);

    boolean addOneWaiter(HotelWaiter waiter);

    boolean removeOneWaiterById(int waiterId);
}
