package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelCheckCustomer;
import cn.zjut.hotel.domain.Table;

public interface HotelCheckCustomerServiceInterface {
    Table findCheckCustomers(int pageId, int pageSize, boolean asc, HotelCheckCustomer checkCustomer);

    boolean modifyOneCheckCustomerById(HotelCheckCustomer checkCustomer);

    boolean removeOneCheckCustomer(int checkCustomerId);
}
