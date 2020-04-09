package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelAdmin;
import cn.zjut.hotel.repository.HotelAdminMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kuluo
 */
@Service
public class HotelAdminServiceImpl implements HotelAdminServiceInterface {
    private static Logger logger = LoggerFactory.getLogger(HotelAdminServiceImpl.class);
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
}
