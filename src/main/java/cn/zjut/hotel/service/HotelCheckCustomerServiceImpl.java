package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelCheckCustomer;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelCheckCustomerMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kuluo
 */
@Service
public class HotelCheckCustomerServiceImpl implements HotelCheckCustomerServiceInterface {
    private HotelCheckCustomerMapper checkCustomerMapper;

    @Autowired
    public void setCheckCustomerMapper(HotelCheckCustomerMapper checkCustomerMapper) {
        this.checkCustomerMapper = checkCustomerMapper;
    }

    @Override
    public Table findCheckCustomers(int pageId, int pageSize, boolean asc, HotelCheckCustomer checkCustomer) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelCheckCustomer.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(checkCustomer.getCheckCustomerIdCard())) {
            criteria.andEqualTo("checkCustomerIdCard", checkCustomer.getCheckCustomerIdCard());
        }
        if (!StringUtils.isEmpty(checkCustomer.getCheckCustomerName())) {
            criteria.andLike("checkCustomerName", "%" + checkCustomer.getCheckCustomerName() + "%");
        }
        if (!StringUtils.isEmpty(checkCustomer.getCheckCustomerPhone())) {
            criteria.andEqualTo("checkCustomerPhone", checkCustomer.getCheckCustomerPhone());
        }
        if (!StringUtils.isEmpty(checkCustomer.getRoomNo())) {
            criteria.andEqualTo("roomNo", checkCustomer.getRoomNo());
        }
        if (checkCustomer.getOrderId() != null && checkCustomer.getOrderId() != 0L) {
            criteria.andEqualTo("orderId", checkCustomer.getOrderId());
        }

        if (asc) {
            example.orderBy("checkCustomerId").asc();
        } else {
            example.orderBy("checkCustomerId").desc();
        }

        List<HotelCheckCustomer> checkCustomerList = checkCustomerMapper.selectByExample(example);
        long count = ((Page<HotelCheckCustomer>) checkCustomerList).getTotal();

        return new Table(checkCustomerList, count);
    }

    @Override
    public boolean modifyOneCheckCustomerById(HotelCheckCustomer checkCustomer) {
        return checkCustomerMapper.updateByPrimaryKeySelective(checkCustomer) > 0;
    }

    @Override
    public boolean removeOneCheckCustomer(int checkCustomerId) {
        return checkCustomerMapper.deleteByPrimaryKey(checkCustomerId) > 0;
    }
}
