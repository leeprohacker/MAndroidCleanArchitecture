package com.fernandocejas.android10.sample.domain.giphy;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DFixedHeightStill {

	private String size;

	private String width;

	private String url;

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

	@Override
 	public String toString(){
		return 
			"FixedHeightStill{" + 
			"size = '" + size + '\'' + 
			",width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}