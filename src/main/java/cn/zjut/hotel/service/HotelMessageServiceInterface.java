package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelMessage;
import cn.zjut.hotel.domain.Table;

import java.util.Date;

public interface HotelMessageServiceInterface {
    int getMessageNum();

    Table findMessages(int pageId, int pageSize, boolean asc, Date beginDate, Date endDate, String sortField);

    boolean addOneMessage(HotelMessage message);

    boolean modifyOneMessageById(HotelMessage message);

    boolean removeOneMessageById(long messageId);
}
