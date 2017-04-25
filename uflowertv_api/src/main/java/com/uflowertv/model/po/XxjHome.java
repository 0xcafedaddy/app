package com.uflowertv.model.po;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XxjHome entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xxj_home")
public class XxjHome implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3401566964264386194L;
	private Integer homeId;
	private Integer platformId;
	private Integer recommendId;
	private String homeName;
	private String homeImage;
	private Integer homeLocation;
	private Integer uiid;
	private Date effective;
	private Date expires;
	private String params;
	private Integer status;

	// Constructors

	/** default constructor */
	public XxjHome() {
	}

	/** full constructor */
	public XxjHome(Integer platformId, Integer recommendId, String homeName,
			String homeImage, Integer homeLocation, Integer uiid,
			Date effective, Date expires, String params, Integer status) {
		this.platformId = platformId;
		this.recommendId = recommendId;
		this.homeName = homeName;
		this.homeImage = homeImage;
		this.homeLocation = homeLocation;
		this.uiid = uiid;
		this.effective = effective;
		this.expires = expires;
		this.params = params;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "home_id", unique = true, nullable = false)
	public Integer getHomeId() {
		return this.homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	@Column(name = "platformId", nullable = false)
	public Integer getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	@Column(name = "recommend_id", nullable = false)
	public Integer getRecommendId() {
		return this.recommendId;
	}

	public void setRecommendId(Integer recommendId) {
		this.recommendId = recommendId;
	}

	@Column(name = "home_name", nullable = false, length = 50)
	public String getHomeName() {
		return this.homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	@Column(name = "home_image", nullable = false, length = 200)
	public String getHomeImage() {
		return this.homeImage;
	}

	public void setHomeImage(String homeImage) {
		this.homeImage = homeImage;
	}

	@Column(name = "home_location", nullable = false)
	public Integer getHomeLocation() {
		return this.homeLocation;
	}

	public void setHomeLocation(Integer homeLocation) {
		this.homeLocation = homeLocation;
	}

	@Column(name = "UIID", nullable = false)
	public Integer getUiid() {
		return this.uiid;
	}

	public void setUiid(Integer uiid) {
		this.uiid = uiid;
	}

	@Column(name = "effective", nullable = false, length = 19)
	public Date getEffective() {
		return this.effective;
	}

	public void setEffective(Date effective) {
		this.effective = effective;
	}

	@Column(name = "expires", nullable = false, length = 19)
	public Date getExpires() {
		return this.expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	@Column(name = "params", nullable = false)
	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}