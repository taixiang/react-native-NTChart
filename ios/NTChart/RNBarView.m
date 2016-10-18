//
//  RNBarView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/9/21.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RNBarView.h"

@implementation RNBarView : RCTViewManager

RCT_EXPORT_MODULE()

RCT_EXPORT_VIEW_PROPERTY(barData, NSArray)

RCT_EXPORT_VIEW_PROPERTY(xLabel, NSArray)

RCT_EXPORT_VIEW_PROPERTY(cssStyle, NSArray)

RCT_EXPORT_VIEW_PROPERTY(isShowNumber, BOOL)

-(UIView *)view{
  
  BarView *barView;
  barView = [[BarView alloc]initWithFrame:CGRectMake(0,0,50,50)];
  barView.backgroundColor=[UIColor clearColor];
  return barView;
  
}

@end
