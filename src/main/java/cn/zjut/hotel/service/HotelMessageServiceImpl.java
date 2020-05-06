package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelMessage;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelMessageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author kuluo
 */
@Service
public class HotelMessageServiceImpl implements HotelMessageServiceInterface {
    private HotelMessageMapper messageMapper;

    @Autowired
    public void setMessageMapper(HotelMessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public Table findMessages(int pageId, int pageSize, boolean asc, Date beginDate, Date endDate, String sortFiled) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelMessage.class);
        Example.Criteria criteria = example.createCriteria();

        if (beginDate != null) {
            criteria.andGreaterThanOrEqualTo("messageSendTime", beginDate);
        }
        if (endDate != null) {
            criteria.andLessThanOrEqualTo("messageSendTime", endDate);
        }

        if (asc) {
            if ("messageId".equals(sortFiled)) {
                example.orderBy("messageId").asc();
            } else {
                example.orderBy("messageSendTime").asc();
            }
        } else {
            if ("messageId".equals(sortFiled)) {
                example.orderBy("messageId").desc();
            } else {
                example.orderBy("messageSendTime").desc();
            }
        }

        List<HotelMessage> messageList = messageMapper.selectByExample(example);
        long count = ((Page<HotelMessage>) messageList).getTotal();

        return new Table(messageList, count);
    }

    @Override
    public boolean addOneMessage(HotelMessage message) {
        return messageMapper.insertSelective(message) > 0;
    }

    @Override
    public boolean modifyOneMessageById(HotelMessage message) {
        return messageMapper.updateByPrimaryKeySelective(message) > 0;
    }

    @Override
    public boolean removeOneMessageById(long messageId) {
        return messageMapper.deleteByPrimaryKey(messageId) > 0;
    }
}
