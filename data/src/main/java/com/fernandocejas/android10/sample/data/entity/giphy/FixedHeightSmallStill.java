package com.fernandocejas.android10.sample.data.entity.giphy;

import javax.annotation.Generated;

import com.fernandocejas.android10.sample.domain.giphy.DFixedHeightSmallStill;
import com.fernandocejas.android10.sample.domain.giphy.DFixedWidth;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class FixedHeightSmallStill{

	@SerializedName("size")
	private String size;

	@SerializedName("width")
	private String width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private String height;

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

	public DFixedHeightSmallStill transform() {
		DFixedHeightSmallStill dFixedHeightSmallStill = new DFixedHeightSmallStill();
		dFixedHeightSmallStill.setUrl(url);
		dFixedHeightSmallStill.setWidth(width);
		dFixedHeightSmallStill.setHeight(height);
		dFixedHeightSmallStill.setSize(size);
		return dFixedHeightSmallStill;
	}
}