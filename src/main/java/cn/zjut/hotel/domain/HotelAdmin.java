package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员表
 *
 * @author kuluo
 */
@Table(name = "hotel_admin")
public class HotelAdmin {
    /**
     * 管理员序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "admin_id")
    private Long adminId;

    /**
     * 管理员工号
     */
    @Column(name = "admin_no")
    private String adminNo;

    /**
     * 管理员姓名
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 管理员密码
     */
    @Column(name = "admin_password")
    private String adminPassword;

    /**
     * 获取管理员序号
     *
     * @return admin_id - 管理员序号
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员序号
     *
     * @param adminId 管理员序号
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员工号
     *
     * @return admin_no - 管理员工号
     */
    public String getAdminNo() {
        return adminNo;
    }

    /**
     * 设置管理员工号
     *
     * @param adminNo 管理员工号
     */
    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

    /**
     * 获取管理员姓名
     *
     * @return admin_name - 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员姓名
     *
     * @param adminName 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取管理员密码
     *
     * @return admin_password - 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员密码
     *
     * @param adminPassword 管理员密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
