package com.uflowertv.wechat.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "wx_menu_tree")
public class Tree implements Serializable{
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableId
    private String id;

    private String pid;

    private String name;

    private String url;

}