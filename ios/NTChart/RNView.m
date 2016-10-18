//
//  RNView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/6/12.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RNView.h"

@implementation RNView: RCTViewManager

RCT_EXPORT_MODULE()

RCT_EXPORT_VIEW_PROPERTY(pieData, NSArray)

RCT_EXPORT_VIEW_PROPERTY(cssStyle, NSArray)

RCT_EXPORT_VIEW_PROPERTY(colorData, NSArray)

RCT_EXPORT_VIEW_PROPERTY(isHaveData, BOOL)

-(UIView *)view{
  
  PieView *pieView ;
  pieView = [[PieView alloc]initWithFrame:CGRectMake(0,0,50,50)];
  pieView.backgroundColor=[UIColor clearColor];
  return pieView;
  
}

@end
