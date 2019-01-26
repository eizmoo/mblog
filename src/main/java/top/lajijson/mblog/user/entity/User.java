package top.lajijson.mblog.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;

    private String nickName;

    private String account;

    private String password;

    private String ip;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private String salt;
}