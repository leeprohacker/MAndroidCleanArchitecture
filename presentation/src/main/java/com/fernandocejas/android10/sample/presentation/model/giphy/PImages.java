package com.fernandocejas.android10.sample.presentation.model.giphy;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PImages {

	private PFixedHeightSmallStill fixedHeightSmallStill;

	private PFixedWidth fixedWidth;

	private PFixedHeightStill fixedHeightStill;

	private POriginalStill originalStill;

	public void setFixedHeightSmallStill(PFixedHeightSmallStill fixedHeightSmallStill){
		this.fixedHeightSmallStill = fixedHeightSmallStill;
	}

	public PFixedHeightSmallStill getFixedHeightSmallStill(){
		return fixedHeightSmallStill;
	}

	public void setFixedWidth(PFixedWidth fixedWidth){
		this.fixedWidth = fixedWidth;
	}

	public PFixedWidth getFixedWidth(){
		return fixedWidth;
	}

	public void setFixedHeightStill(PFixedHeightStill fixedHeightStill){
		this.fixedHeightStill = fixedHeightStill;
	}

	public PFixedHeightStill getFixedHeightStill(){
		return fixedHeightStill;
	}

	public void setOriginalStill(POriginalStill originalStill){
		this.originalStill = originalStill;
	}

	public POriginalStill getOriginalStill(){
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