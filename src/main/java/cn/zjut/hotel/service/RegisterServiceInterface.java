package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelRegister;
import cn.zjut.hotel.domain.Table;

public interface RegisterServiceInterface {
    HotelRegister findOneRegisterById(String registerPhone);

    Table findRegisters(int pageId, int pageSize, boolean asc, HotelRegister register);

    boolean modifyOneRegisterById(HotelRegister register);

    boolean addOneRegisterById(HotelRegister register);

    boolean removeOneRegisterById(int registerId);
}
