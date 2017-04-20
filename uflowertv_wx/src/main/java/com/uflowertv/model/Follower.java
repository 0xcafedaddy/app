package com.uflowertv.model;

import lombok.Data;
import org.nutz.json.JsonField;


/**
 * 微信用户信息
 * 
 * @author 凡梦星尘(elkan1788@gmail.com)
 * @since 2.0
 */
@Data
public class Follower {
    /**
     * 是否订阅(0 退订, 1 订阅)
     */
    private int subscribe;
    /**
     * 关注公众号唯一标识
     */
    private String openid;
    /**
     * 微信昵称
     */
    private String nickname;
    /**
     * 性别(1 男, 2 女, 0 未知)
     */
    private int sex;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 用户所在国家
     */
    private String country;
    /**
     * 用户所在省份
     */
    private String province;
    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;
    /**
     * 用户头像，最后一个数值代表正方形头像大小<br/>
     * （有0、46、64、96、132数值可选，0代表640*640正方<br/>
     * 形头像），用户没有头像时该项为空
     */
    private String headimgurl;
    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
/*    @JsonField(value = "subscribe_time")
    private String subscribeTime;*/
    @JsonField(value = "subscribe_time")
    private String subscribetime;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
     */
    private String unionid;
    /**
     * 粉丝的备注
     */
    private String remark;
    /**
     * 用户所在的分组ID
     */
    private int groupid;
    
    private String[] privilege;
}
