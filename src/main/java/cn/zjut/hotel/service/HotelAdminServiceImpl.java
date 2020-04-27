package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.repository.HotelAdminMapper;
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
public class HotelAdminServiceImpl implements HotelAdminServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(HotelAdminServiceImpl.class);
    private HotelAdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(HotelAdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public HotelAdmin findOneAdminById(Integer id) {
        if (id == null) {
            logger.info("查询失败，主键为空");
            return null;
        }

        HotelAdmin admin = adminMapper.selectByPrimaryKey(id);
        if (admin == null) {
            logger.info("查询失败，未找到匹配的管理员信息");
            return null;
        } else {
            return admin;
        }
    }

    @Override
    public List<HotelAdmin> findAdmins(int pageId, int pageSize, boolean asc, HotelAdmin admin) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelAdmin.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(admin.getAdminNo())) {
            criteria.andEqualTo("adminNo", admin.getAdminNo());
        }
        if (!StringUtils.isEmpty(admin.getAdminName())) {
            criteria.andLike("adminName", "%" + admin.getAdminName() + "%");
        }
        if (!StringUtils.isEmpty(admin.getAdminDuty())) {
            criteria.andLike("adminDuty", "%" + admin.getAdminDuty() + "%");
        }

        if (asc) {
            example.orderBy("adminId").asc();
        } else {
            example.orderBy("adminId").desc();
        }

        return adminMapper.selectByExample(example);
    }

    @Override
    public int getNum() {
        Example example = new Example(HotelAdmin.class);
        example.selectProperties("adminId");
        return adminMapper.selectByExample(example).size();
    }
}
