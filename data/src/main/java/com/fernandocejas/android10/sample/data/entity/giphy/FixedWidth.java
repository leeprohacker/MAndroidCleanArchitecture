package com.fernandocejas.android10.sample.data.entity.giphy;

import javax.annotation.Generated;

import com.fernandocejas.android10.sample.domain.giphy.DFixedWidth;
import com.fernandocejas.android10.sample.domain.giphy.DOriginalStill;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class FixedWidth{

	@SerializedName("mp4")
	private String mp4;

	@SerializedName("size")
	private String size;

	@SerializedName("width")
	private String width;

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("webp")
	private String webp;

	@SerializedName("webp_size")
	private String webpSize;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private String height;

	public void setMp4(String mp4){
		this.mp4 = mp4;
	}

	public String getMp4(){
		return mp4;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setWidth(String width){
		this.width = width;
	}

	public String getWidth(){
		return width;
	}

	public void setMp4Size(String mp4Size){
		this.mp4Size = mp4Size;
	}

	public String getMp4Size(){
		return mp4Size;
	}

	public void setWebp(String webp){
		this.webp = webp;
	}

	public String getWebp(){
		return webp;
	}

	public void setWebpSize(String webpSize){
		this.webpSize = webpSize;
	}

	public String getWebpSize(){
		return webpSize;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}


	public DFixedWidth transform() {
		DFixedWidth dFixedWidth = new DFixedWidth();
		dFixedWidth.setUrl(url);
		dFixedWidth.setWidth(width);
		dFixedWidth.setHeight(height);
		dFixedWidth.setSize(size);
		return dFixedWidth;
	}
}