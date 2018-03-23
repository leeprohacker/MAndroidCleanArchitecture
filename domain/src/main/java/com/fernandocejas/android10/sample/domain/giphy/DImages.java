package com.fernandocejas.android10.sample.domain.giphy;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DImages {

	private DFixedHeightSmallStill fixedHeightSmallStill;

	private DFixedWidth fixedWidth;

	private DFixedHeightStill fixedHeightStill;

	private DOriginalStill originalStill;

	public void setFixedHeightSmallStill(DFixedHeightSmallStill fixedHeightSmallStill){
		this.fixedHeightSmallStill = fixedHeightSmallStill;
	}

	public DFixedHeightSmallStill getFixedHeightSmallStill(){
		return fixedHeightSmallStill;
	}

	public void setFixedWidth(DFixedWidth fixedWidth){
		this.fixedWidth = fixedWidth;
	}

	public DFixedWidth getFixedWidth(){
		return fixedWidth;
	}

	public void setFixedHeightStill(DFixedHeightStill fixedHeightStill){
		this.fixedHeightStill = fixedHeightStill;
	}

	public DFixedHeightStill getFixedHeightStill(){
		return fixedHeightStill;
	}

	public void setOriginalStill(DOriginalStill originalStill){
		this.originalStill = originalStill;
	}

	public DOriginalStill getOriginalStill(){
		return originalStill;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"fixed_height_small_still = '" + fixedHeightSmallStill + '\'' + 
			",fixed_width = '" + fixedWidth + '\'' + 
			",fixed_height_still = '" + fixedHeightStill + '\'' + 
			",original_still = '" + originalStill + '\'' + 
			"}";
		}
}