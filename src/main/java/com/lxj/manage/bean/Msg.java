package com.lxj.manage.bean;

import java.io.Serializable;

/**
 * @author lxj
 *
 * 信息bena(用于与页面进行交互信息)
 * */
public class Msg implements Serializable {
    private String title;  //标题
    private String content;  //内容
    private String etraInfo;  //详情

    public Msg () {}

    public Msg(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", etraInfo='" + etraInfo + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
