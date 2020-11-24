package com.lwf.pojo;

/**
 * @author lwf
 * @title: Message
 * @projectName 11_17ServletFilter
 * @description: TODO
 * @date 2020/11/1816:02
 */
public class Message {
    private String code;
    private String msg;
    private String url;

    public Message(String code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
