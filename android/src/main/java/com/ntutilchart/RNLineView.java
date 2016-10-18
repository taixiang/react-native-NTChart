package com.ntutilchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.facebook.react.bridge.ReadableArray;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by taixiang on 16/10/11.
 */
public class RNLineView extends LineChart {

	private ArrayList<String> xVals = new ArrayList<String>();
	private ReadableArray xList;
	private ReadableArray yList;
	private LineDataSet set1;

	public RNLineView(Context context) {
		super(context);
		initLineView();
	}

	private void initLineView(){
		setDrawGridBackground(false);
		setDrawBorders(false);
		// 设置右下角描述
		setDescription("");
		//设置透明度
		setAlpha(0.8f);
		//设置网格底下的那条线的颜色
		setBorderColor(Color.rgb(213, 216, 214));
		//设置高亮显示
//        mChart.setHighlightEnabled(true);
		//设置是否可以触摸，如为false，则不能拖动，缩放等
		setTouchEnabled(false);
		//设置是否可以拖拽
		setDragEnabled(false);
		//设置是否可以缩放
		setScaleEnabled(false);
		//设置是否能扩大扩小
		setPinchZoom(false);
		//x、y轴设置
		XAxis xAxis = getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
		xAxis.setDrawGridLines(false);
		YAxis yAxis = getAxisRight();
		yAxis.setEnabled(false);
		Legend l = getLegend();
		l.setEnabled(false);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		setData(new LineData(xVals, set1));
		invalidate();
	}

	public void setXData(ReadableArray xList){
		this.xList = xList;
		for (int i = 0; i < xList.size(); i++) {
			xVals.add(xList.getString(i));
		}
	}

	public void setYData(ReadableArray yList){
		this.yList = yList;
		ArrayList<Entry> yVals = new ArrayList<Entry>();
		for (int i = 0; i < yList.size(); i++) {
			yVals.add(new Entry(Float.parseFloat(yList.getString(i)), i));
		}
		set1 = new LineDataSet(yVals,"");
		set1.setDrawCubic(false);  //设置曲线为圆滑的线
		set1.setCubicIntensity(0.2f);
		set1.setDrawFilled(false);  //设置包括的范围区域填充颜色
		set1.setDrawCircles(true);  //设置有圆点
		set1.setLineWidth(2f);    //设置线的宽度
		set1.setCircleSize(2f);   //设置小圆的大小
		set1.setHighLightColor(Color.rgb(244, 117, 117));
		set1.setColor(Color.rgb(104, 241, 175));    //设置曲线的颜色
		set1.setValueTextSize(10f); //设置数据值的大小

	}
}
