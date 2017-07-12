package com.uflowertv.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "xxj_user", uniqueConstraints = @UniqueConstraint(columnNames = "card"))
public class XxjUser implements java.io.Serializable {

	private static final long serialVersionUID = -4721286597276384515L;
	
	// Fields
	@Id
	@GeneratedValue
	private Integer user_id;
	private Integer platformId;
	private String card;
	private String user_addr;
	private String user_name;
	private String user_phone;
	private String post_code;
	private String openId;
	private Date created;

	// Constructors
	/** default constructor */
	/*public XxjUser() {
		
	}*/

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("user_id", user_id)
						  .add("platformId", platformId)
						  .add("card", card)
						  .add("user_addr", user_addr)
						  .add("user_name", user_name)
						  .add("user_phone", user_phone)
						  .add("post_code", post_code)
						  .add("openId", openId)
						  .add("created", created)
						  .omitNullValues()
						  .toString();
	}
	
}