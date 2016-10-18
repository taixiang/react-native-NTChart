//
//  PieView.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/6/6.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "PieView.h"

#import "PNChart.h"

@implementation PieView

-(void)setPieData:(NSArray *)pieData{
  _pieData = pieData;
  [self setNeedsDisplay];
}

-(void)setCssStyle:(NSArray *)cssStyle{
  _cssStyle = cssStyle;
  [self setNeedsDisplay];
}

-(void)setIsHaveData:(BOOL)isHaveData{
  _isHaveData = isHaveData;
  [self setNeedsDisplay];
}

-(void)setColorData:(NSArray *)colorData{
  _colorData = colorData;
}

- (void)drawRect:(CGRect)rect
{
  dispatch_async(dispatch_get_main_queue(), ^{

  [super drawRect:rect];
  self.backgroundColor=[UIColor clearColor];
     
     int dataCount = [_pieData count];
     NSMutableArray *mutArray =[[NSMutableArray alloc]init];
     if(_isHaveData){
//       NSArray *array=@[PNRed,PNBlue,PNGreen,PNGrey,PNBlack,PNBrown,PNWhite,PNMauve];
       
       for(int i=0;i<dataCount;i++){
         PNPieChartDataItem *item =[PNPieChartDataItem dataItemWithValue:[[NSString stringWithFormat:@"%@",_pieData[i]] intValue] color:[self getColor:_colorData[i]] description:@""];
         
         [mutArray addObject:item];
       }
     }else{
       [mutArray addObject:[PNPieChartDataItem dataItemWithValue:1 color:PNPinkGrey]];
     }
     
  
  PNPieChart *pieChart = [[PNPieChart alloc] initWithFrame:CGRectMake([[NSString stringWithFormat:@"%@",_cssStyle[0]] floatValue], [[NSString stringWithFormat:@"%@",_cssStyle[1]] floatValue], [[NSString stringWithFormat:@"%@",_cssStyle[2]] floatValue], [[NSString stringWithFormat:@"%@",_cssStyle[3]] floatValue]) items:mutArray];
  pieChart.descriptionTextColor = [UIColor whiteColor];
  pieChart.descriptionTextFont  = [UIFont fontWithName:@"Avenir-Medium" size:14.0];
  pieChart.hideValues = YES;
  [pieChart strokeChart];
  
  [self addSubview:pieChart];

     
   });
}


/**
 *  @author wuxiaochen, 2015-09-17 11:09:46
 *
 *  #ffffff  转换成 UIColor
 *
 *  @param hexColor 如#fffffff
 *
 *  @return uicolor
 */
- (UIColor *)getColor:(NSString*)hexColor
{
  unsigned int red,green,blue;
  NSRange range;
  range.length = 2;
  
  range.location = 0;
  [[NSScanner scannerWithString:[hexColor substringWithRange:range]]scanHexInt:&red];
  
  range.location = 2;
  [[NSScanner scannerWithString:[hexColor substringWithRange:range]]scanHexInt:&green];
  
  range.location = 4;
  [[NSScanner scannerWithString:[hexColor substringWithRange:range]]scanHexInt:&blue];
  
  return [UIColor colorWithRed:(float)(red/255.0f)green:(float)(green / 255.0f) blue:(float)(blue / 255.0f)alpha:1.0f];
}

@end
