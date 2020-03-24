package cn.zjut.hotel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "customer_order")
public class CustomerOrder {
    /**
     * 入住顾客订单序号
     */
    @Id
    @Column(name = "customer_order_id")
    private Long customerOrderId;

    /**
     * 入住顾客订单号
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 入住顾客身份证号
     */
    @Column(name = "check_customer_id_card")
    private Long checkCustomerIdCard;

    /**
     * 房间号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 入住时间
     */
    @Column(name = "customer_order_check_In_time")
    private Date customerOrderCheckInTime;

    /**
     * 离开时间
     */
    @Column(name = "customer_order_leave_time")
    private Date customerOrderLeaveTime;

    /**
     * 0 表示未居住 1 表示居住
     */
    @Column(name = "is_living")
    private Byte isLiving;

    /**
     * 获取入住顾客订单序号
     *
     * @return customer_order_id - 入住顾客订单序号
     */
    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    /**
     * 设置入住顾客订单序号
     *
     * @param customerOrderId 入住顾客订单序号
     */
    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    /**
     * 获取入住顾客订单号
     *
     * @return order_id - 入住顾客订单号
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置入住顾客订单号
     *
     * @param orderId 入住顾客订单号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取入住顾客身份证号
     *
     * @return check_customer_id_card - 入住顾客身份证号
     */
    public Long getCheckCustomerIdCard() {
        return checkCustomerIdCard;
    }

    /**
     * 设置入住顾客身份证号
     *
     * @param checkCustomerIdCard 入住顾客身份证号
     */
    public void setCheckCustomerIdCard(Long checkCustomerIdCard) {
        this.checkCustomerIdCard = checkCustomerIdCard;
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
     * 获取入住时间
     *
     * @return customer_order_check_In_time - 入住时间
     */
    public Date getCustomerOrderCheckInTime() {
        return customerOrderCheckInTime;
    }

    /**
     * 设置入住时间
     *
     * @param customerOrderCheckInTime 入住时间
     */
    public void setCustomerOrderCheckInTime(Date customerOrderCheckInTime) {
        this.customerOrderCheckInTime = customerOrderCheckInTime;
    }

    /**
     * 获取离开时间
     *
     * @return customer_order_leave_time - 离开时间
     */
    public Date getCustomerOrderLeaveTime() {
        return customerOrderLeaveTime;
    }

    /**
     * 设置离开时间
     *
     * @param customerOrderLeaveTime 离开时间
     */
    public void setCustomerOrderLeaveTime(Date customerOrderLeaveTime) {
        this.customerOrderLeaveTime = customerOrderLeaveTime;
    }

    /**
     * 获取0 表示未居住 1 表示居住
     *
     * @return is_living - 0 表示未居住 1 表示居住
     */
    public Byte getIsLiving() {
        return isLiving;
    }

    /**
     * 设置0 表示未居住 1 表示居住
     *
     * @param isLiving 0 表示未居住 1 表示居住
     */
    public void setIsLiving(Byte isLiving) {
        this.isLiving = isLiving;
    }
}
