package cn.zjut.hotel.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 通知表
 *
 * @author kuluo
 */
@Table(name = "hotel_message")
public class Message {
    /**
     * 通知序号
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "message_id")
    private Long messageId;

    /**
     * 消息标题
     */
    @Column(name = "message_title")
    private String messageTitle;

    /**
     * 消息内容
     */
    @Column(name = "message_content")
    private String messageContent;

    /**
     * 消息发送时间
     */
    @Column(name = "message_send_time")
    private Date messageSendTime;

    /**
     * 获取通知序号
     *
     * @return message_id - 通知序号
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * 设置通知序号
     *
     * @param messageId 通知序号
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取消息标题
     *
     * @return message_title - 消息标题
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * 设置消息标题
     *
     * @param messageTitle 消息标题
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     * 获取消息内容
     *
     * @return message_content - 消息内容
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 设置消息内容
     *
     * @param messageContent 消息内容
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * 获取消息发送时间
     *
     * @return message_send_time - 消息发送时间
     */
    public Date getMessageSendTime() {
        return messageSendTime;
    }

    /**
     * 设置消息发送时间
     *
     * @param messageSendTime 消息发送时间
     */
    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }
}
