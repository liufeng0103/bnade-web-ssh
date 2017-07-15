package com.bnade.wow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 留言板
 * Created by liufeng0103@163.com on 2017/7/16.
 */
@Entity
public class MessageBoard {
    @Id
    private Integer id;
    @NotNull
    private String nickname;
    @NotNull
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBoard{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
