package com.studies.study.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 减刑假释平台返回实体.
 *
 * @author xiapeng on 2020-02-26 14:07
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class JxjsResponseVO {

    /**
     * 是否成功，true:成功 false：失败
     */
    @XmlElement(name = "success")
    private boolean success;

    /**
     * 失败原因.
     */
    @XmlElement(name = "message")
    private String failMsg;

    /**
     * 构造器.
     */
    public JxjsResponseVO() {
        this.success = true;
    }

    /**
     * 失败时调用的构造器.
     *
     * @param failMsg 失败原因
     */
    public JxjsResponseVO(String failMsg) {
        this.success = false;
        this.failMsg = failMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置 success.
     *
     * @param success success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取 failMsg.
     *
     * @return failMsg
     */
    public String getFailMsg() {
        return failMsg;
    }

    /**
     * 设置 failMsg.
     *
     * @param failMsg failMsg
     */
    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }
}
