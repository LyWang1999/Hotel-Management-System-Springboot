package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 订单表
 *
 * @author kuluo
 */
@Table(name = "hotel_order")
public class Order {
    /**
     * 订单序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 注册会员手机号
     */
    @Column(name = "register_phone")
    private String registerPhone;

    /**
     * 房间类型
     */
    @Column(name = "room_type_name")
    private String roomTypeName;

    /**
     * 预定时间
     */
    @Column(name = "order_created_time")
    private Date orderCreatedTime;

    /**
     * 入住时间
     */
    @Column(name = "order_check_in_time")
    private Date orderCheckInTime;

    /**
     * 离开时间
     */
    @Column(name = "order_leave_time")
    private Date orderLeaveTime;

    /**
     * 支付金额
     */
    @Column(name = "order_payment")
    private Double orderPayment;

    /**
     * 房间数量
     */
    @Column(name = "order_room_num")
    private Integer orderRoomNum;

    /**
     * 详细信息
     */
    @Column(name = "order_detail")
    private String orderDetail;

    /**
     * 订单状态
     * 0 未完成
     * 1 已完成
     */
    @Column(name = "is_completed")
    private Byte isCompleted;

    /**
     * 获取订单序号
     *
     * @return order_id - 订单序号
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单序号
     *
     * @param orderId 订单序号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取注册会员手机号
     *
     * @return register_phone - 注册会员手机号
     */
    public String getRegisterPhone() {
        return registerPhone;
    }

    /**
     * 设置注册会员手机号
     *
     * @param registerPhone 注册会员手机号
     */
    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
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
     * 获取预定时间
     *
     * @return order_created_time - 预定时间
     */
    public Date getOrderCreatedTime() {
        return orderCreatedTime;
    }

    /**
     * 设置预定时间
     *
     * @param orderCreatedTime 预定时间
     */
    public void setOrderCreatedTime(Date orderCreatedTime) {
        this.orderCreatedTime = orderCreatedTime;
    }

    /**
     * 获取入住时间
     *
     * @return order_check_in_time - 入住时间
     */
    public Date getOrderCheckInTime() {
        return orderCheckInTime;
    }

    /**
     * 设置入住时间
     *
     * @param orderCheckInTime 入住时间
     */
    public void setOrderCheckInTime(Date orderCheckInTime) {
        this.orderCheckInTime = orderCheckInTime;
    }

    /**
     * 获取离开时间
     *
     * @return order_leave_time - 离开时间
     */
    public Date getOrderLeaveTime() {
        return orderLeaveTime;
    }

    /**
     * 设置离开时间
     *
     * @param orderLeaveTime 离开时间
     */
    public void setOrderLeaveTime(Date orderLeaveTime) {
        this.orderLeaveTime = orderLeaveTime;
    }

    /**
     * 获取支付金额
     *
     * @return order_payment - 支付金额
     */
    public Double getOrderPayment() {
        return orderPayment;
    }

    /**
     * 设置支付金额
     *
     * @param orderPayment 支付金额
     */
    public void setOrderPayment(Double orderPayment) {
        this.orderPayment = orderPayment;
    }

    /**
     * 获取房间数量
     *
     * @return order_room_num - 房间数量
     */
    public Integer getOrderRoomNum() {
        return orderRoomNum;
    }

    /**
     * 设置房间数量
     *
     * @param orderRoomNum 房间数量
     */
    public void setOrderRoomNum(Integer orderRoomNum) {
        this.orderRoomNum = orderRoomNum;
    }

    /**
     * 获取详细信息
     *
     * @return order_detail - 详细信息
     */
    public String getOrderDetail() {
        return orderDetail;
    }

    /**
     * 设置详细信息
     *
     * @param orderDetail 详细信息
     */
    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     * 获取订单状态
     * 0 未完成
     * 1 已完成
     *
     * @return is_completed - 订单状态
     * 0 未完成
     * 1 已完成
     */
    public Byte getIsCompleted() {
        return isCompleted;
    }

    /**
     * 设置订单状态
     * 0 未完成
     * 1 已完成
     *
     * @param isCompleted 订单状态
     *                    0 未完成
     *                    1 已完成
     */
    public void setIsCompleted(Byte isCompleted) {
        this.isCompleted = isCompleted;
    }
}
