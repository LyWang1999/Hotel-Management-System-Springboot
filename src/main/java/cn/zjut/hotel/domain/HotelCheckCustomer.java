package cn.zjut.hotel.domain;

import cn.zjut.hotel.config.JavaDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "hotel_check_customer")
public class HotelCheckCustomer {
    /**
     * 入住顾客序号
     */
    @Id
    @Column(name = "check_customer_id")
    private Long checkCustomerId;

    /**
     * 入住顾客身份证号
     */
    @Column(name = "check_customer_id_card")
    private String checkCustomerIdCard;

    /**
     * 入住顾客姓名
     */
    @Column(name = "check_customer_name")
    private String checkCustomerName;

    /**
     * 入住顾客性别 1 男 0 女
     */
    @Column(name = "is_male")
    private Byte male;

    /**
     * 入住顾客手机号码
     */
    @Column(name = "check_customer_phone")
    private String checkCustomerPhone;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 入住顾客房间号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 入住顾客入住时间
     */
    @JsonDeserialize(using = JavaDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "check_customer_check_in_time")
    private Date checkCustomerCheckInTime;

    /**
     * 入住顾客离开时间
     */
    @JsonDeserialize(using = JavaDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "check_customer_leave_time")
    private Date checkCustomerLeaveTime;

    /**
     * 是否居住 0 离开 1居住
     */
    @Column(name = "is_living")
    private Byte living;

    /**
     * 获取入住顾客序号
     *
     * @return check_customer_id - 入住顾客序号
     */
    public Long getCheckCustomerId() {
        return checkCustomerId;
    }

    /**
     * 设置入住顾客序号
     *
     * @param checkCustomerId 入住顾客序号
     */
    public void setCheckCustomerId(Long checkCustomerId) {
        this.checkCustomerId = checkCustomerId;
    }

    /**
     * 获取入住顾客身份证号
     *
     * @return check_customer_id_card - 入住顾客身份证号
     */
    public String getCheckCustomerIdCard() {
        return checkCustomerIdCard;
    }

    /**
     * 设置入住顾客身份证号
     *
     * @param checkCustomerIdCard 入住顾客身份证号
     */
    public void setCheckCustomerIdCard(String checkCustomerIdCard) {
        this.checkCustomerIdCard = checkCustomerIdCard;
    }

    /**
     * 获取入住顾客姓名
     *
     * @return check_customer_name - 入住顾客姓名
     */
    public String getCheckCustomerName() {
        return checkCustomerName;
    }

    /**
     * 设置入住顾客姓名
     *
     * @param checkCustomerName 入住顾客姓名
     */
    public void setCheckCustomerName(String checkCustomerName) {
        this.checkCustomerName = checkCustomerName;
    }

    /**
     * 获取入住顾客性别 1 男 0 女
     *
     * @return is_male - 入住顾客性别 1 男 0 女
     */
    public Byte getMale() {
        return male;
    }

    /**
     * 设置入住顾客性别 1 男 0 女
     *
     * @param male 入住顾客性别 1 男 0 女
     */
    public void setMale(Byte male) {
        this.male = male;
    }

    /**
     * 获取入住顾客手机号码
     *
     * @return check_customer_phone - 入住顾客手机号码
     */
    public String getCheckCustomerPhone() {
        return checkCustomerPhone;
    }

    /**
     * 设置入住顾客手机号码
     *
     * @param checkCustomerPhone 入住顾客手机号码
     */
    public void setCheckCustomerPhone(String checkCustomerPhone) {
        this.checkCustomerPhone = checkCustomerPhone;
    }

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取入住顾客房间号
     *
     * @return room_no - 入住顾客房间号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 设置入住顾客房间号
     *
     * @param roomNo 入住顾客房间号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 获取入住顾客入住时间
     *
     * @return check_customer_check_in_time - 入住顾客入住时间
     */
    public Date getCheckCustomerCheckInTime() {
        return checkCustomerCheckInTime;
    }

    /**
     * 设置入住顾客入住时间
     *
     * @param checkCustomerCheckInTime 入住顾客入住时间
     */
    public void setCheckCustomerCheckInTime(Date checkCustomerCheckInTime) {
        this.checkCustomerCheckInTime = checkCustomerCheckInTime;
    }

    /**
     * 获取入住顾客离开时间
     *
     * @return check_customer_leave_time - 入住顾客离开时间
     */
    public Date getCheckCustomerLeaveTime() {
        return checkCustomerLeaveTime;
    }

    /**
     * 设置入住顾客离开时间
     *
     * @param checkCustomerLeaveTime 入住顾客离开时间
     */
    public void setCheckCustomerLeaveTime(Date checkCustomerLeaveTime) {
        this.checkCustomerLeaveTime = checkCustomerLeaveTime;
    }

    /**
     * 获取是否居住 0 离开 1居住
     *
     * @return is_living - 是否居住 0 离开 1居住
     */
    public Byte getLiving() {
        return living;
    }

    /**
     * 设置是否居住 0 离开 1居住
     *
     * @param living 是否居住 0 离开 1居住
     */
    public void setLiving(Byte living) {
        this.living = living;
    }
}
