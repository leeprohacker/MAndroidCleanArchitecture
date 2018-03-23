package com.fernandocejas.android10.sample.data.entity.giphy;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class FixedWidthDownsampled{

	@SerializedName("size")
	private String size;

	@SerializedName("width")
	private String width;

	@SerializedName("webp")
	private String webp;

	@SerializedName("webp_size")
	private String webpSize;

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

	@Override
 	public String toString(){
		return 
			"FixedWidthDownsampled{" + 
			"size = '" + size + '\'' + 
			",width = '" + width + '\'' + 
			",webp = '" + webp + '\'' + 
			",webp_size = '" + webpSize + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}