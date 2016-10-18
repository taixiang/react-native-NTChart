//
//  BarView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/9/21.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "BarView.h"
#import "PNChart.h"

@implementation BarView

-(void)setBarData:(NSArray *)barData{
  _barData = barData;
  [self setNeedsDisplay];
}

-(void)setCssStyle:(NSArray *)cssStyle{
  _cssStyle = cssStyle;
  [self setNeedsDisplay];
}

-(void)setIsShowNumber:(BOOL *)isShowNumber{
  _isShowNumber = isShowNumber;
  [self setNeedsDisplay];
}

-(void)setXLabel:(NSArray *)xLabel{
  _xLabel = xLabel;
  [self setNeedsDisplay];
}

- (void)drawRect:(CGRect)rect {

  dispatch_async(dispatch_get_main_queue(), ^{
    
    [super drawRect:rect];
    self.backgroundColor=[UIColor clearColor];
    PNBarChart * barChart = [[PNBarChart alloc] initWithFrame:CGRectMake([_cssStyle[0] floatValue], [_cssStyle[1] floatValue], [_cssStyle[2] floatValue], [_cssStyle[3] floatValue])];
//    [barChart setStrokeColors:@[[UIColor redColor],[UIColor greenColor],[UIColor yellowColor],[UIColor blueColor]]];
    [barChart setXLabels:_xLabel];
    [barChart setYValues:_barData];
    barChart.isShowNumbers = _isShowNumber;
    [barChart strokeChart];
    [self addSubview:barChart];
  });


}


@end
