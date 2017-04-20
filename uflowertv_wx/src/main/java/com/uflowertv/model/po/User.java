package com.uflowertv.model.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName(value = "wx_system_user")
public class User implements Serializable{

    private transient static final long serialVersionUID = 1L;

    /** 主键ID */
    @TableId
    private String id;

    private String pwd;

    private String uname;

    private String email;

    private String created;

    private String logintime;

    private String validatecode;

    private Date outdate;

    private transient String ip;

}