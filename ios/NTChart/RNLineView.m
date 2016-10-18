//
//  RNLineView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/9/22.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RNLineView.h"

@implementation RNLineView: RCTViewManager

RCT_EXPORT_MODULE()

RCT_EXPORT_VIEW_PROPERTY(lineData, NSArray)

RCT_EXPORT_VIEW_PROPERTY(xLabel, NSArray)

RCT_EXPORT_VIEW_PROPERTY(cssStyle, NSArray)


-(UIView *)view{
  
  LineView *lineView;
  lineView = [[LineView alloc]initWithFrame:CGRectMake(0,0,50,50)];
  lineView.backgroundColor=[UIColor clearColor];
  return lineView;
  
}

@end
