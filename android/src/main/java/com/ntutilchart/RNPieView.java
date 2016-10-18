package com.ntutilchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.facebook.react.bridge.ReadableArray;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * Created by taixiang on 16/10/12.
 */
public class RNPieView extends PieChart {

	private ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容
	private ArrayList<Entry> yValues = new ArrayList<Entry>();  //yVals用来表示封装每个饼块的实际数据
	private ArrayList<Integer> colors = new ArrayList<Integer>();
	private PieDataSet pieDataSet;
	private ReadableArray colorData;
	private ReadableArray pieData;
	private boolean isHaveData;

	public RNPieView(Context context) {
		super(context);
		initPieView();
	}

	private void initPieView(){
		setDescription("");
//		setHoleColorTransparent(true);
		setHoleRadius(30f);  //半径
		setTransparentCircleRadius(0f); // 半透明圈

		setDrawCenterText(true);  //饼状图中间可以添加文字
		setDrawHoleEnabled(true);
//        pieChart.setRotationAngle(90); // 初始旋转角度

		setRotationEnabled(false); // 可以手动旋转
		setUsePercentValues(false);  //显示成百分比
		setCenterText("");  //饼状图中间的文字
		setCenterTextSize(16);
		setTouchEnabled(false);

		Legend mLegend = getLegend();  //设置比例图
		mLegend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_CENTER);  //最左边显示
		mLegend.setForm(Legend.LegendForm.SQUARE);  //设置比例图的形状，默认是方形 SQUARE
		mLegend.setXEntrySpace(7f);
		mLegend.setYEntrySpace(5f);
		mLegend.setEnabled(false);

//      animateXY(1000, 1000);  //设置动画
//		pieChart.invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawPie();
	}

	public void setPieData(ReadableArray pieData){
		this.pieData = pieData;
		for (int i = 0; i < pieData.size(); i++) {
//            xValues.add("PieChart" + (i + 1));  //饼块上显示成PieChart1, PieChart2, PieChart3, PieChart4，PieChart5，PieChart6
			xValues.add("");
		}
		for (int i = 0; i < pieData.size(); i++) {
			yValues.add(new Entry(Float.parseFloat(pieData.getString(i)), i));
		}
		pieDataSet = new PieDataSet(yValues, "");
		pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离
		pieDataSet.setDrawValues(false);
	}

	public void setPieColor(ReadableArray colorData){
		this.colorData = colorData;
	}

	public void setIsHaveData(boolean isHaveData){
		this.isHaveData = isHaveData;
	}

	private void drawPie(){
		//饼图颜色
		for(int i=0;i<colorData.size();i++){
			colors.add(isHaveData ? Color.parseColor("#"+colorData.getString(i)):Color.parseColor("#c8c1c1"));
		}
		pieDataSet.setColors(colors);
		setData(new PieData(xValues, pieDataSet));
		invalidate();
	}
}
