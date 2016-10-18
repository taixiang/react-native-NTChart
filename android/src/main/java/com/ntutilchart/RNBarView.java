package com.ntutilchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.facebook.react.bridge.ReadableArray;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * Created by taixiang on 16/10/12.
 */
public class RNBarView extends BarChart {


	private ArrayList<String> xVals = new ArrayList<String>();
	private ReadableArray xList;
	private ReadableArray yList;
	private BarDataSet set1;
	private boolean isShowNumber;

	public RNBarView(Context context) {
		super(context);
		initBar();
	}

	private void initBar(){
		setDrawGridBackground(false);
		setDrawBorders(false);  //是否在折线图上添加边框
		setDescription("");// 数据描述
		setNoDataTextDescription(""); // 如果没有数据，显示
		setDrawGridBackground(false); // 是否显示表格颜色
		setGridBackgroundColor(Color.WHITE); // 表格的的颜色，在这里是是给颜色设置一个透明度

		setTouchEnabled(false); // 设置是否可以触摸
		setDragEnabled(false);// 是否可以拖拽
		setScaleEnabled(false);// 是否可以缩放
		setPinchZoom(false);//
		setDrawBarShadow(false);//没有数据的地方显示阴影
		setDrawValueAboveBar(true);

		setDrawBorders(false); //是否在折线图上添加边框

		getXAxis().setEnabled(true);  //x轴
		getXAxis().setDrawLabels(true);
		getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
		getXAxis().setDrawGridLines(false);
		getAxisLeft().setEnabled(true);//左y轴
		getAxisLeft().setDrawLabels(true);
		getAxisRight().setEnabled(false);//右y轴
//        getXAxis().setLabelsToSkip(0);//横轴之间的距离
//        barChart.getAxisLeft().setAxisMaxValue(1000);//y轴数值最大数

		Legend mLegend = getLegend(); // 设置比例图标示
		mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
		mLegend.setFormSize(6f);// 字体
		mLegend.setTextColor(Color.BLACK);// 颜色
		mLegend.setEnabled(false);

		// X轴设定
//        barChart.animateY(3000);
		invalidate();
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawBar();
	}

	public void setXData(ReadableArray xList){
		this.xList = xList;
		for (int i = 0; i < xList.size(); i++) {
			xVals.add(xList.getString(i));
		}
	}

	public void setYData(ReadableArray yList){
		this.yList = yList;
		ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
		for (int i = 0; i < yList.size(); i++) {
			yVals.add(new BarEntry(Float.parseFloat(yList.getString(i)), i));
		}
		set1 = new BarDataSet(yVals,"");
		set1.setHighLightColor(Color.rgb(244, 117, 117));
		set1.setColor(Color.rgb(104, 241, 175));
		set1.setValueTextSize(10f); //设置数据值的大小

	}

	public void setIsShowNumber(boolean isShowNumber){
		this.isShowNumber = isShowNumber;
	}

	private void drawBar(){
		set1.setDrawValues(isShowNumber);
		setData(new BarData(xVals, set1));
		invalidate();
	}

}
