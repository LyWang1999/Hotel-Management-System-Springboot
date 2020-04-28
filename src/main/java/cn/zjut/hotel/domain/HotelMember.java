package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author kuluo
 */
@Table(name = "hotel_member")
public class HotelMember {
    /**
     * 会员等级序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "member_id")
    private Long memberId;

    /**
     * 会员折扣
     */
    @Column(name = "member_discount")
    private BigDecimal memberDiscount;

    /**
     * 详细信息
     */
    @Column(name = "member_detail")
    private String memberDetail;

    /**
     * 会员积分分界线
     */
    @Column(name = "in_scores")
    private Integer inScores;

    /**
     * 获取会员等级序号
     *
     * @return member_id - 会员等级序号
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 设置会员等级序号
     *
     * @param memberId 会员等级序号
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取会员折扣
     *
     * @return member_discount - 会员折扣
     */
    public BigDecimal getMemberDiscount() {
        return memberDiscount;
    }

    /**
     * 设置会员折扣
     *
     * @param memberDiscount 会员折扣
     */
    public void setMemberDiscount(BigDecimal memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    /**
     * 获取详细信息
     *
     * @return member_detail - 详细信息
     */
    public String getMemberDetail() {
        return memberDetail;
    }

    /**
     * 设置详细信息
     *
     * @param memberDetail 详细信息
     */
    public void setMemberDetail(String memberDetail) {
        this.memberDetail = memberDetail;
    }

    /**
     * 获取会员积分分界线
     *
     * @return in_scores - 会员积分分界线
     */
    public Integer getInScores() {
        return inScores;
    }

    /**
     * 设置会员积分分界线
     *
     * @param inScores 会员积分分界线
     */
    public void setInScores(Integer inScores) {
        this.inScores = inScores;
    }
}
