package top.lajijson.mblog.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;

    private String nickName;

    private String account;

    @JSONField(serialize = false)
    private String password;

    @JSONField(serialize = false)
    private String salt;

    private String ip;

    private Boolean status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Date updateTime;
}