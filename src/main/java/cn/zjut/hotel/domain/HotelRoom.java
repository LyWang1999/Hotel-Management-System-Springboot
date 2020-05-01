package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 房间表
 *
 * @author kuluo
 */
@Table(name = "hotel_room")
public class HotelRoom {
    /**
     * 房间序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 房间号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 房间类型
     */
    @Column(name = "room_type_name")
    private String roomTypeName;

    /**
     * 详细信息
     */
    @Column(name = "room_detail")
    private String roomDetail;

    /**
     * 1 房间空余 0 房间不空余
     */
    @Column(name = "is_empty")
    private Byte empty;

    /**
     * @return room_id
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取房间号
     *
     * @return room_no - 房间号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 设置房间号
     *
     * @param roomNo 房间号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
     * 获取详细信息
     *
     * @return room_detail - 详细信息
     */
    public String getRoomDetail() {
        return roomDetail;
    }

    /**
     * 设置详细信息
     *
     * @param roomDetail 详细信息
     */
    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    /**
     * 获取1 房间空余 0 房间不空余
     *
     * @return is_empty - 1 房间空余 0 房间不空余
     */
    public Byte getEmpty() {
        return empty;
    }

    /**
     * 设置1 房间空余 0 房间不空余
     *
     * @param empty 1 房间空余 0 房间不空余
     */
    public void setEmpty(Byte empty) {
        this.empty = empty;
    }
}
