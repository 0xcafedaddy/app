package com.uflowertv.model.vo;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.MoreObjects;
import com.uflowertv.model.dto.XxjRatedDTO;

import lombok.Data;
/**
 * 
 * 版权所有：2016年12月28日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：JSON实体类
 * 类名称：com.uflowertv.json.CommonsEntityJson     
 * 创建人：liguoliang 
 * 创建时间：2016年12月28日 下午2:22:11   
 * 修改人：
 * 修改时间：2016年12月28日 下午2:22:11   
 * 修改备注：   
 * @version   V1.0
 */
@Data
public class CommonsEntityJson implements Serializable{
	private static final long serialVersionUID = 2758056347163267810L;
	/**
	 * 产品
	 */
	private String product_id;//产品ID
	private String product_name;//产品名称
	private String product_introduce;//产品介绍
	private String product_type;//产品类型
	private String product_status;//产品状态
	private String subject_type;//文理科  1文科2理科3全部
	private String buy_tips;//购买提示
	private String flag;//是否购买产品
	
	private String price_full_month;//包月价格
	private String price_half_year;//包半年价格
	private String price_full_year;//包年价格
	
	private List<XxjRatedDTO> prices;//专题价格
	
	/**
	 * 内容包
	 */
	private String content_list;//内容包列表
	private String content_id;//内容包ID
	private String content_name;//内容包名称
	private String content_status;//内容包状态
	private String content_introduce;//内容包介绍
	private String video_list;//视频列表
	
	/**
	 * 视频
	 */
	private String duration;//视频时长
	private String video_status;//视频状态
	private String is_free;//是否免费
	private String courseware_count;//课件数
	private String video_url;//视频地址
	private String teacher_id;//教师ID
	
	/**
	 * 教师
	 */
	private String tc_id;//教师ID
	private String tc_name;//教师名称
	private String tc_image;//教师小图片
	private String tc_pic;//教师大图片
	private String tc_say;//教师介绍
	private String tc_introduce;//教师简介
	private String tc_job;//教师职位
	private String grade_list;//年级列表
	private String subject_list;//科目列表
	
	/**
	 * 专题
	 */
	private String special_id;//专题ID
	private String special_name;//专题名称
	private String template;//专题模版
	private String special_image;//专题图片
	
	/**
	 * 公共属性
	 */
	private Integer id;
	private String url;
	private String platformId;//平台ID
	private String user_id;//用户ID
	private String params;//页面参数
	private String effective;//生效时间
	private String expires;//失效时间
	private String xued_id;//学段ID
	private String xued_name;//学段名称
	private String grade_id;//年级ID
	private String grade_name;//年级名称
	private String subject_id;//科目ID
	private String subject_name;//科目名称
	private String subject_image;//科目图片
	private String term;//学期
	private String point_id;//知识点ID
	private String point_name;//知识点名称
	private String video_id;//视频ID
	private String video_name;//视频名称
	private List<CommonsEntityJson> productList;//产品
	private List<CommonsEntityJson> xueds;//学段
	private List<CommonsEntityJson> grades;//年级
	private List<CommonsEntityJson> subjects;//科目
	private List<CommonsEntityJson> points ;//知识点
	private List<CommonsEntityJson> videos ;//视频 
	private List<CommonsEntityJson> pictures;//首页图片
	private List<CommonsEntityJson> terms ;//学期
	
	public CommonsEntityJson() {}
	
	public static CommonsEntityJson getInstance(){
		return new CommonsEntityJson();
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("product_id", product_id)
						  .add("product_name", product_name)
						  .add("product_status", product_status)
						  .add("subject_type", subject_type)
						  .add("buy_tips", buy_tips)
						  .add("effective", effective)
						  .add("expires", expires)
						  .add("content_list", content_list)
						  .add("content_id", content_id)
						  .add("content_name", content_name)
						  .add("content_status", content_status)
						  .add("content_introduce", content_introduce)
						  .add("video_list", video_list)
						  .add("duration", duration)
						  .add("video_status", video_status)
						  .add("is_free", is_free)
						  .add("courseware_count", courseware_count)
						  .add("video_url", video_url)
						  .add("teacher_id", teacher_id)
						  .add("tc_id", tc_id)
						  .add("tc_name", tc_name)
						  .add("tc_image", tc_image)
						  .add("tc_pic", tc_pic)
						  .add("tc_say", tc_say)
						  .add("tc_introduce", tc_introduce)
						  .add("tc_job", tc_job)
						  .add("grade_list", grade_list)
						  .add("subject_list", subject_list)
						  .add("flag", flag)
						  .add("id", id)
						  .add("url", url)
						  .add("price_full_month", price_full_month)
						  .add("price_half_year", price_half_year)
						  .add("price_full_year", price_full_year)
						  .add("prices", prices)
						  .add("platformId", platformId)
						  .add("user_id", user_id)
						  .add("params", params)
						  .add("xued_id", xued_id)
						  .add("xued_name", xued_name)
						  .add("grade_id", grade_id)
						  .add("grade_name", grade_name)
						  .add("subject_id", subject_id)
						  .add("subject_name", subject_name)
						  .add("subject_image", subject_image)
						  .add("term", term)
						  .add("point_id", point_id)
						  .add("point_name", point_name)
						  .add("video_id", video_id)
						  .add("video_name", video_name)
						  .add("special_id", special_id)
						  .add("special_name", special_name)
						  .add("template", template)
						  .add("special_image", special_image)
						  .add("productList", productList)
						  .add("xueds", xueds)
						  .add("grades", grades)
						  .add("subjects", subjects)
						  .add("points", points)
						  .add("videos", videos)
						  .add("pictures", pictures)
						  .add("terms", terms)
						  .omitNullValues()
						  .toString();
	}
}
