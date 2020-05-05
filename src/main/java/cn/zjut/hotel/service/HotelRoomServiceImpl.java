package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelRoom;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelRoomMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author kuluo
 */
@Service
public class HotelRoomServiceImpl implements HotelRoomServiceInterface {
    private HotelRoomMapper roomMapper;

    @Autowired
    public void setRoomMapper(HotelRoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public List<Map<String, Byte>> findEmptyRoomNumByAllTypes() {
        return roomMapper.selectRoomNumByTypes();
    }

    @Override
    public List<HotelRoom> findEmptyRoomsByType(String roomTypeName) {
        Example example = new Example(HotelRoom.class);
        example.createCriteria()
                .andEqualTo("roomTypeName", roomTypeName)
                .andEqualTo("empty", 1);
        example.orderBy("roomId")
                .asc();
        return roomMapper.selectByExample(example);
    }

    @Override
    public Table findRooms(int pageId, int pageSize, boolean asc, HotelRoom room) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(HotelRoom.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(room.getRoomNo())) {
            criteria.andEqualTo("roomNo", room.getRoomNo());
        }
        if (!StringUtils.isEmpty(room.getRoomTypeName())) {
            criteria.andEqualTo("roomTypeName", room.getRoomTypeName());
        }
        if ((room.getEmpty() != null)) {
            criteria.andEqualTo("empty", room.getEmpty());
        }

        if (asc) {
            example.orderBy("roomId").asc();
        } else {
            example.orderBy("roomId").desc();
        }

        List<HotelRoom> roomList = roomMapper.selectByExample(example);
        long count = ((Page<HotelRoom>) roomList).getTotal();

        return new Table(roomList, count);
    }

    @Override
    public boolean modifyOneRoomById(HotelRoom room) {
        return roomMapper.updateByPrimaryKeySelective(room) > 0;
    }

    @Override
    public boolean addOneRoom(HotelRoom room) {
        return roomMapper.insertSelective(room) > 0;
    }

    @Override
    public boolean removeOneRoomById(long roomId) {
        return roomMapper.deleteByPrimaryKey(roomId) > 0;
    }
}
