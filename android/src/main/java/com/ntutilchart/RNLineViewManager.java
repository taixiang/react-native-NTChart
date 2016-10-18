package com.ntutilchart;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by taixiang on 16/10/11.
 */
public class RNLineViewManager extends SimpleViewManager<RNLineView> {
	@Override
	public String getName() {
		return "RNLineView";
	}

	@Override
	protected RNLineView createViewInstance(ThemedReactContext reactContext) {
		return new RNLineView(reactContext);
	}

	@ReactProp(name = "xLabel" )
	public void setxData(RNLineView lineView ,ReadableArray xList){
		lineView.setXData(xList);

	}

	@ReactProp(name = "lineData" )
	public void setyData(RNLineView lineView ,ReadableArray yList){
		lineView.setYData(yList);
	}

}
