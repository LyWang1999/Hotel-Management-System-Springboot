package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelWaiter;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelWaiterMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kuluo
 */
@Service
public class HotelWaiterServiceImpl implements HotelWaiterServiceInterface {
    private static Logger logger = LoggerFactory.getLogger(HotelWaiterServiceImpl.class);
    private HotelWaiterMapper waiterMapper;

    @Autowired
    public void setWaiterMapper(HotelWaiterMapper waiterMapper) {
        this.waiterMapper = waiterMapper;
    }

    @Override
    public HotelWaiter findOneWaiterById(Integer id) {
        if (id == null) {
            logger.info("查询失败，主键为空");
            return null;
        }

        HotelWaiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter == null) {
            logger.info("查询失败，未找到匹配的服务员信息");
            return null;
        } else {
            return waiter;
        }
    }

    @Override
    public Table findWaiters(int pageId, int pageSize, boolean asc, HotelWaiter waiter) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelWaiter.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(waiter.getWaiterNo())) {
            criteria.andEqualTo("waiterNo", waiter.getWaiterNo());
        }
        if (!StringUtils.isEmpty(waiter.getWaiterName())) {
            criteria.andLike("waiterName", "%" + waiter.getWaiterName() + "%");
        }
        if (waiter.getBeginWorkTime() != null) {
            criteria.andGreaterThanOrEqualTo("beginWorkTime", waiter.getBeginWorkTime());
        }
        if (waiter.getEndWorkTime() != null) {
            criteria.andLessThanOrEqualTo("endWorkTime", waiter.getEndWorkTime());
        }
        if (!StringUtils.isEmpty(waiter.getWorkDay())) {
            criteria.andLike("workDay", "%" + waiter.getWorkDay() + "%");
        }

        if (asc) {
            example.orderBy("waiterId").asc();
        } else {
            example.orderBy("waiterId").desc();
        }

        List<HotelWaiter> waiterList = waiterMapper.selectByExample(example);
        long count = ((Page<HotelWaiter>) waiterList).getTotal();

        return new Table(waiterList, count);
    }

    @Override
    public boolean modifyOneWaiterById(HotelWaiter waiter) {
        return waiterMapper.updateByPrimaryKeySelective(waiter) > 0;
    }

    @Override
    public boolean addOneWaiter(HotelWaiter waiter) {
        return waiterMapper.insertSelective(waiter) > 0;
    }

    @Override
    public boolean removeOneWaiterById(long waiterId) {
        return waiterMapper.deleteByPrimaryKey(waiterId) > 0;
    }
}
