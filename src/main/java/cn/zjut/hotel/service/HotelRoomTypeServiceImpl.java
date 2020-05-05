package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelRoomType;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelRoomTypeMapper;
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
public class HotelRoomTypeServiceImpl implements HotelRoomTypeServiceInterface {
    private HotelRoomTypeMapper roomTypeMapper;

    @Autowired
    public void setRoomTypeMapper(HotelRoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    @Override
    public List<String> findTypeNames() {
        return roomTypeMapper.selectRoomTypeNames();
    }

    @Override
    public Table findRoomTypes(int pageId, int pageSize, boolean asc, String roomTypeName, String sortField) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelRoomType.class);
        if (!StringUtils.isEmpty(roomTypeName)) {
            example.createCriteria().andEqualTo("roomTypeName", roomTypeName);
        }

        if (asc) {
            if ("roomTypeId".equals(sortField)) {
                example.orderBy("roomTypeId").asc();
            } else if ("roomTypePrice".equals(sortField)){
                example.orderBy("roomTypePrice").asc();
            }
        } else {
            if ("roomTypeId".equals(sortField)) {
                example.orderBy("roomTypeId").desc();
            } else if ("roomTypePrice".equals(sortField)){
                example.orderBy("roomTypePrice").desc();
            }
        }

        List<HotelRoomType> roomTypeList = roomTypeMapper.selectByExample(example);
        long count = ((Page<HotelRoomType>) roomTypeList).getTotal();

        return new Table(roomTypeList, count);
    }

    @Override
    public boolean modifyRoomTypeById(HotelRoomType roomType) {
        return roomTypeMapper.updateByPrimaryKeySelective(roomType) > 0;
    }

    @Override
    public boolean addOneRoomType(HotelRoomType roomType) {
        return roomTypeMapper.insertSelective(roomType) > 0;
    }
}
