package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 服务员表
 *
 * @author kuluo
 */
@Table(name = "hotel_waiter")
public class HotelWaiter {
    /**
     * 服务员序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "waiter_id")
    private Long waiterId;

    /**
     * 服务员工号
     */
    @Column(name = "waiter_no")
    private String waiterNo;

    /**
     * 服务员姓名
     */
    @Column(name = "waiter_name")
    private String waiterName;

    /**
     * 服务员密码
     */
    @Column(name = "waiter_password")
    private String waiterPassword;

    /**
     * 获取服务员序号
     *
     * @return waiter_id - 服务员序号
     */
    public Long getWaiterId() {
        return waiterId;
    }

    /**
     * 设置服务员序号
     *
     * @param waiterId 服务员序号
     */
    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    /**
     * 获取服务员工号
     *
     * @return waiter_no - 服务员工号
     */
    public String getWaiterNo() {
        return waiterNo;
    }

    /**
     * 设置服务员工号
     *
     * @param waiterNo 服务员工号
     */
    public void setWaiterNo(String waiterNo) {
        this.waiterNo = waiterNo;
    }

    /**
     * 获取服务员姓名
     *
     * @return waiter_name - 服务员姓名
     */
    public String getWaiterName() {
        return waiterName;
    }

    /**
     * 设置服务员姓名
     *
     * @param waiterName 服务员姓名
     */
    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    /**
     * 获取服务员密码
     *
     * @return waiter_password - 服务员密码
     */
    public String getWaiterPassword() {
        return waiterPassword;
    }

    /**
     * 设置服务员密码
     *
     * @param waiterPassword 服务员密码
     */
    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }
}
