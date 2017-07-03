package com.uflowertv.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XxjUi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xxj_ui")
public class XxjUi implements java.io.Serializable {
	private static final long serialVersionUID = -3775502272447583371L;
	// Fields
	private Integer uiId;
	private String uiName;
	private String uiUrl;
	private Integer createAt;
	private Integer updateAt;
	private Byte status;

	// Constructors

	/** default constructor */
	public XxjUi() {
	}

	/** full constructor */
	public XxjUi(String uiName, String uiUrl, Integer createAt,
			Integer updateAt, Byte status) {
		this.uiName = uiName;
		this.uiUrl = uiUrl;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ui_id", unique = true, nullable = false)
	public Integer getUiId() {
		return this.uiId;
	}

	public void setUiId(Integer uiId) {
		this.uiId = uiId;
	}

	@Column(name = "ui_name", unique = true, nullable = false, length = 100)
	public String getUiName() {
		return this.uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	@Column(name = "ui_url", nullable = false, length = 250)
	public String getUiUrl() {
		return this.uiUrl;
	}

	public void setUiUrl(String uiUrl) {
		this.uiUrl = uiUrl;
	}

	@Column(name = "create_at", nullable = false)
	public Integer getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

	@Column(name = "update_at", nullable = false)
	public Integer getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Integer updateAt) {
		this.updateAt = updateAt;
	}

	@Column(name = "status", nullable = false)
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}