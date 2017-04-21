package com.uflowertv.model;

import lombok.Data;

public class MusicMessage extends BaseMessage{
	private Music Music;

	public com.uflowertv.model.Music getMusic() {
		return Music;
	}

	public void setMusic(com.uflowertv.model.Music music) {
		Music = music;
	}
}
