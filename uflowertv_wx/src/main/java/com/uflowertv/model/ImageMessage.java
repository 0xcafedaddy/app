package com.uflowertv.model;

import lombok.Data;

public class ImageMessage extends BaseMessage{
	private Image Image;

	public com.uflowertv.model.Image getImage() {
		return Image;
	}

	public void setImage(com.uflowertv.model.Image image) {
		Image = image;
	}
}
