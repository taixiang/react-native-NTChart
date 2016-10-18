//
//  LineView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/9/22.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "LineView.h"
#import "PNChart.h"

@implementation LineView

-(void)setLineData:(NSArray *)lineData{
  _lineData = lineData;
  [self setNeedsDisplay];
}

-(void)setCssStyle:(NSArray *)cssStyle{
  _cssStyle = cssStyle;
  [self setNeedsDisplay];
}

//-(void)setIsShowNumber:(BOOL *)isShowNumber{
//  _isShowNumber = isShowNumber;
//  [self setNeedsDisplay];
//}

-(void)setXLabel:(NSArray *)xLabel{
  _xLabel = xLabel;
  [self setNeedsDisplay];
}

- (void)drawRect:(CGRect)rect {
  
  dispatch_async(dispatch_get_main_queue(), ^{
    
    [super drawRect:rect];
    self.backgroundColor=[UIColor clearColor];
   
    //For Line Chart
    PNLineChart * lineChart = [[PNLineChart alloc] initWithFrame:CGRectMake([_cssStyle[0] floatValue], [_cssStyle[1] floatValue], [_cssStyle[2] floatValue], [_cssStyle[3] floatValue])];
    [lineChart setXLabels:_xLabel];
    lineChart.showCoordinateAxis = YES; // 是否显示坐标轴
    // Line Chart No.1
    NSArray * data01Array = _lineData;
    PNLineChartData *data01 = [PNLineChartData new];
    data01.color = PNTwitterColor;
    data01.itemCount = lineChart.xLabels.count;
    data01.inflexionPointColor = PNRed;
    data01.inflexionPointStyle = PNLineChartPointStyleSquare;
    data01.getData = ^(NSUInteger index) {
      CGFloat yValue = [data01Array[index] floatValue];
      return [PNLineChartDataItem dataItemWithY:yValue];
    };
    
    lineChart.chartData = @[data01];
    [lineChart strokeChart];
    
    //Add Line Titles for the Legend
//    data01.dataTitle = @"Alpha";
    
    //Build the legend
//    lineChart.legendStyle = PNLegendItemStyleSerial;
//    lineChart.legendFont = [UIFont systemFontOfSize:12.0];
//    UIView *legend = [lineChart getLegendWithMaxWidth:320];
//    
//    //Move legend to the desired position and add to view
//    [legend setFrame:CGRectMake(100, 350, legend.frame.size.width, legend.frame.size.height)];
//    [self addSubview:legend];
    
    [self addSubview:lineChart];
  });
  
  
}


@end
