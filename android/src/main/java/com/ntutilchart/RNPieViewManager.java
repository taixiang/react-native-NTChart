package com.ntutilchart;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by taixiang on 16/10/12.
 */
public class RNPieViewManager extends SimpleViewManager<RNPieView> {
	@Override
	public String getName() {
		return "RNView";
	}

	@Override
	protected RNPieView createViewInstance(ThemedReactContext reactContext) {
		return new RNPieView(reactContext);
	}

	@ReactProp(name = "pieData" )
	public void setPieData(RNPieView barView ,ReadableArray dataList){
		barView.setPieData(dataList);
	}

	@ReactProp(name = "colorData" )
	public void setPieColor(RNPieView barView ,ReadableArray color){
		barView.setPieColor(color);
	}

	@ReactProp(name = "isHaveData")
	public void setNoDataColor(RNPieView barView ,boolean isHaveData){
		barView.setIsHaveData(isHaveData);
	}

}
