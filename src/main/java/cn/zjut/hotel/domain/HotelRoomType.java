package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 房间类型表
 *
 * @author kuluo
 */
@Table(name = "hotel_room_type")
public class HotelRoomType {
    /**
     * 房间类型序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "room_type_id")
    private Long roomTypeId;

    /**
     * 房间类型
     */
    @Column(name = "room_type_name")
    private String roomTypeName;

    /**
     * 房间最多入住人数
     */
    @Column(name = "room_type_max_living")
    private Integer roomTypeMaxLiving;

    /**
     * 房间价格
     */
    @Column(name = "room_type_price")
    private BigDecimal roomTypePrice;

    /**
     * 获取房间类型序号
     *
     * @return room_type_id - 房间类型序号
     */
    public Long getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * 设置房间类型序号
     *
     * @param roomTypeId 房间类型序号
     */
    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    /**
     * 获取房间类型
     *
     * @return room_type_name - 房间类型
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * 设置房间类型
     *
     * @param roomTypeName 房间类型
     */
    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    /**
     * 获取房间最多入住人数
     *
     * @return room_type_max_living - 房间最多入住人数
     */
    public Integer getRoomTypeMaxLiving() {
        return roomTypeMaxLiving;
    }

    /**
     * 设置房间最多入住人数
     *
     * @param roomTypeMaxLiving 房间最多入住人数
     */
    public void setRoomTypeMaxLiving(Integer roomTypeMaxLiving) {
        this.roomTypeMaxLiving = roomTypeMaxLiving;
    }

    /**
     * 获取房间价格
     *
     * @return room_type_price - 房间价格
     */
    public BigDecimal getRoomTypePrice() {
        return roomTypePrice;
    }

    /**
     * 设置房间价格
     *
     * @param roomTypePrice 房间价格
     */
    public void setRoomTypePrice(BigDecimal roomTypePrice) {
        this.roomTypePrice = roomTypePrice;
    }
}
