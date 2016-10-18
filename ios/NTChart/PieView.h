//
//  PieView.h
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/6/6.
//  Copyright © 2016年 Facebook. All rights reserved.
//
#import <UIKit/UIKit.h>

@interface PieView : UIView

@property (nonatomic,strong) NSArray *pieData;

@property (nonatomic,assign) BOOL isHaveData;

@property (nonatomic,strong) NSArray *cssStyle;

@property (nonatomic,strong) NSArray *colorData;

@end
