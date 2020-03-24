package cn.zjut.hotel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "check_customer")
public class CheckCustomer {
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
     * 姓名
     */
    @Column(name = "check_customer_name")
    private String checkCustomerName;

    /**
     * 性别 1 男 0 女
     */
    @Column(name = "is_male")
    private Byte male;

    /**
     * 手机号码
     */
    @Column(name = "check_customer_phone")
    private String checkCustomerPhone;

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
     * 获取姓名
     *
     * @return check_customer_name - 姓名
     */
    public String getCheckCustomerName() {
        return checkCustomerName;
    }

    /**
     * 设置姓名
     *
     * @param checkCustomerName 姓名
     */
    public void setCheckCustomerName(String checkCustomerName) {
        this.checkCustomerName = checkCustomerName;
    }

    /**
     * 获取性别 1 男 0 女
     *
     * @return is_male - 性别 1 男 0 女
     */
    public Byte getMale() {
        return male;
    }

    /**
     * 设置性别 1 男 0 女
     *
     * @param male 性别 1 男 0 女
     */
    public void setMale(Byte male) {
        this.male = male;
    }

    /**
     * 获取手机号码
     *
     * @return check_customer_phone - 手机号码
     */
    public String getCheckCustomerPhone() {
        return checkCustomerPhone;
    }

    /**
     * 设置手机号码
     *
     * @param checkCustomerPhone 手机号码
     */
    public void setCheckCustomerPhone(String checkCustomerPhone) {
        this.checkCustomerPhone = checkCustomerPhone;
    }
}
