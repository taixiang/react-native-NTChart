package com.ntutilchart;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by taixiang on 16/10/12.
 */
public class RNBarViewManager extends SimpleViewManager<RNBarView> {
	@Override
	public String getName() {
		return "RNBarView";
	}

	@Override
	protected RNBarView createViewInstance(ThemedReactContext reactContext) {
		return new RNBarView(reactContext);
	}

	@ReactProp(name = "xLabel" )
	public void setxData(RNBarView barView ,ReadableArray xList){
		barView.setXData(xList);
	}

	@ReactProp(name = "barData" )
	public void setyData(RNBarView barView ,ReadableArray yList){
		barView.setYData(yList);
	}

	@ReactProp(name = "isShowNumber")
	public void setIsShowNum(RNBarView barView ,boolean isShowNum){
		barView.setIsShowNumber(isShowNum);
	}

}
