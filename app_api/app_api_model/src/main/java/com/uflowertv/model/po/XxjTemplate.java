package com.uflowertv.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XxjTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xxj_template")
public class XxjTemplate implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8619421746288729075L;
	// Fields
	private Integer templateId;
	private String templateImage;
	private String templateName;
	private Integer platformId;
	private Integer uiid;
	private String params;
	private Integer num;

	// Constructors

	/** default constructor */
	public XxjTemplate() {
	}

	/** full constructor */
	public XxjTemplate(String templateImage, String templateName,
			Integer platformId, Integer uiid, String params, Integer num) {
		this.templateImage = templateImage;
		this.templateName = templateName;
		this.platformId = platformId;
		this.uiid = uiid;
		this.params = params;
		this.num = num;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "template_id", unique = true, nullable = false)
	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	@Column(name = "template_image", nullable = false)
	public String getTemplateImage() {
		return this.templateImage;
	}

	public void setTemplateImage(String templateImage) {
		this.templateImage = templateImage;
	}

	@Column(name = "template_name", nullable = false)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "platformId", nullable = false)
	public Integer getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	@Column(name = "UIID", nullable = false)
	public Integer getUiid() {
		return this.uiid;
	}

	public void setUiid(Integer uiid) {
		this.uiid = uiid;
	}

	@Column(name = "params", nullable = false, length = 65535)
	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Column(name = "num", nullable = false)
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}