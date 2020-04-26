package cn.zjut.hotel.domain;

import cn.zjut.hotel.config.SqlTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

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
     * 性别 1 男 0 女
     */
    @Column(name = "is_male")
    private Byte male;

    /**
     * 上班时间
     */
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    @Column(name = "begin_work_time")
    private Time beginWorkTime;

    /**
     * 下班时间
     */
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    @Column(name = "end_work_time")
    private Time endWorkTime;

    /**
     * 工作日
     */
    @Column(name = "work_day")
    private String workDay;

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
     * 获取上班时间
     *
     * @return begin_work_time - 上班时间
     */
    public Time getBeginWorkTime() {
        return beginWorkTime;
    }

    /**
     * 设置上班时间
     *
     * @param beginWorkTime begin_work_time - 上班时间
     */
    public void setBeginWorkTime(Time beginWorkTime) {
        this.beginWorkTime = beginWorkTime;
    }

    /**
     * 获取下班时间
     *
     * @return end_word_time - 下班时间
     */
    public Time getEndWorkTime() {
        return endWorkTime;
    }

    /**
     * 设置下班时间
     *
     * @param endWorkTime end_word_time - 下班时间
     */
    public void setEndWorkTime(Time endWorkTime) {
        this.endWorkTime = endWorkTime;
    }

    /**
     * 获取工作日
     *
     * @return work_day - 工作日
     */
    public String getWorkDay() {
        return workDay;
    }

    /**
     * 设置工作日
     *
     * @param workDay work_day - 工作日
     */
    public void setWorkDay(String workDay) {
        this.workDay = workDay;
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
