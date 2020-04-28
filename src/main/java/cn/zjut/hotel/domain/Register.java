package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 注册用户表
 *
 * @author kuluo
 */
@Table(name = "hotel_register")
public class Register {
    /**
     * 注册用户序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "register_id")
    private Long registerId;

    /**
     * 注册用户手机号码
     */
    @Column(name = "register_phone")
    private String registerPhone;

    /**
     * 注册用户账号名
     */
    @Column(name = "register_account")
    private String registerAccount;

    /**
     * 注册用户密码
     */
    @Column(name = "register_password")
    private String registerPassword;

    /**
     * 性别 1 男 0 女
     */
    @Column(name = "is_male")
    private Byte male;

    /**
     * 注册用户邮箱
     */
    @Column(name = "register_email")
    private String registerEmail;

    /**
     * 注册用户会员详细信息
     */
    @Column(name = "member_detail")
    private String memberDetail;

    /**
     * 注册用户会员积分
     */
    @Column(name = "member_score")
    private Integer memberScore;

    /**
     * 注册用户会员折扣
     */
    @Column(name = "member_discount")
    private BigDecimal memberDiscount;

    /**
     * 获取注册用户序号
     *
     * @return register_id - 注册用户序号
     */
    public Long getRegisterId() {
        return registerId;
    }

    /**
     * 设置注册用户序号
     *
     * @param registerId 注册用户序号
     */
    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    /**
     * 获取注册用户手机号码
     *
     * @return register_phone - 注册用户手机号码
     */
    public String getRegisterPhone() {
        return registerPhone;
    }

    /**
     * 设置注册用户手机号码
     *
     * @param registerPhone 注册用户手机号码
     */
    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
    }

    /**
     * 获取注册用户账号名
     *
     * @return register_account - 注册用户账号名
     */
    public String getRegisterAccount() {
        return registerAccount;
    }

    /**
     * 设置注册用户账号名
     *
     * @param registerAccount 注册用户账号名
     */
    public void setRegisterAccount(String registerAccount) {
        this.registerAccount = registerAccount;
    }

    /**
     * 获取注册用户密码
     *
     * @return register_password - 注册用户密码
     */
    public String getRegisterPassword() {
        return registerPassword;
    }

    /**
     * 设置注册用户密码
     *
     * @param registerPassword 注册用户密码
     */
    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
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
     * 获取注册用户邮箱
     *
     * @return register_email - 注册用户邮箱
     */
    public String getRegisterEmail() {
        return registerEmail;
    }

    /**
     * 设置注册用户邮箱
     *
     * @param registerEmail 注册用户邮箱
     */
    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    /**
     * 获取注册用户会员详细信息
     *
     * @return member_detail - 注册用户会员详细信息
     */
    public String getMemberDetail() {
        return memberDetail;
    }

    /**
     * 设置注册用户会员详细信息
     *
     * @param memberDetail 注册用户会员详细信息
     */
    public void setMemberDetail(String memberDetail) {
        this.memberDetail = memberDetail;
    }

    /**
     * 获取注册用户会员积分
     *
     * @return member_score - 注册用户会员积分
     */
    public Integer getMemberScore() {
        return memberScore;
    }

    /**
     * 设置注册用户会员积分
     *
     * @param memberScore 注册用户会员积分
     */
    public void setMemberScore(Integer memberScore) {
        this.memberScore = memberScore;
    }

    /**
     * 获取注册用户会员折扣
     *
     * @return member_discount - 注册用户会员折扣
     */
    public BigDecimal getMemberDiscount() {
        return memberDiscount;
    }

    /**
     * 设置注册用户会员折扣
     *
     * @param memberDiscount 注册用户会员折扣
     */
    public void setMemberDiscount(BigDecimal memberDiscount) {
        this.memberDiscount = memberDiscount;
    }
}
