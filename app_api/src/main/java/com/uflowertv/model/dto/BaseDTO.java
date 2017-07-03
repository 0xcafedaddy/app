package com.uflowertv.model.dto;

import java.util.List;

import com.uflowertv.model.vo.CommonsEntityJson;

import lombok.Data;
@Data
public class BaseDTO {

	private Integer id;
	private String name;
	private String url;
	private String user_id;//用户ID
	private String image;//图片地址
	private String location;//图片位置
	private String UIID;//页面ID
	private String params;//页面参数
	private String product_name;//产品名称
	private String product_introduce;//产品介绍
	private String product_type;//产品类型
	private String product_status;//产品状态
	private String arts_or_science;//是否文理科
	private String buy_tips;//购买提示
	private String content_list;//内容包列表
	private String content_id;//内容包ID
	private String content_name;//内容包名称
	private String content_status;//内容包状态
	private String content_introduce;//内容包介绍
	private String video_list;//视频列表
	private String duration;//视频时长
	private String video_status;//视频状态
	private String courseware_id;//课件ID
	private String is_free;//是否免费
	private String courseware_count;//课件数
	private String teacher_id;//教师ID
	private String teacher_name;//教师名称
	private String teacher_image;//教师图片
	private String teacher_say;//教师介绍
	private String teacher_introduce;//教师简介
	private String teacher_job;//教师职位
	private String school_age;//教龄
	private String show_price;//显示价格
	private String flag;//是否购买产品
	private String order_id;//订单ID
	private String order_price;//订单价格
	private String serial_number;//订单流水号
	private String pay_desc;//支付描述
	private String platformId;//平台ID
	private String product_effective;//产品生效时间
	private String product_expires;//产品失效时间
	private String order_effective;//订单生效时间
	private String order_expires;//订单失效时间
	private String combo_id;//套餐ID
	private String xued_id;//学段ID
	private String xued_name;//学段名称
	private String grade_id;//年级ID
	private String grade_name;//年级名称
	private String subject_id;//科目ID
	private String subject_name;//科目名称
	private String term;//学期
	private String point_id;//知识点ID
	private String point_name;//知识点名称
	private String video_id;//视频ID
	private String video_name;//视频名称
	private List<CommonsEntityJson> productList;//产品
	private List<CommonsEntityJson> xueds;//学段
	private List<CommonsEntityJson> grades;//年级
	private List<XxjSubjectDTO> subjects;//科目
	private List<CommonsEntityJson> points ;//知识点
	private List<CommonsEntityJson> videos ;//视频 
	private List<CommonsEntityJson> pictures;//首页图片
	
	public BaseDTO() {
		// TODO Auto-generated constructor stub
	}
}
