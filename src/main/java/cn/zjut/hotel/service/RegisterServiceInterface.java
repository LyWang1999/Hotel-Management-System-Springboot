package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.Register;
import cn.zjut.hotel.domain.Table;

public interface RegisterServiceInterface {
    Table findRegisters(int pageId, int pageSize, boolean asc, Register register);

    boolean modifyOneRegisterById(Register register);

    boolean addOneRegisterById(Register register);

    boolean removeOneRegisterById(int registerId);
}
