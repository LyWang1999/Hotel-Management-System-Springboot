package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelAdmin;

import java.util.List;

public interface HotelAdminServiceInterface {
    HotelAdmin findOneAdminById(Integer id);

    List<HotelAdmin> findAdmins(int pageId, int pageSize, boolean asc, HotelAdmin admin);

    int getNum();
}
