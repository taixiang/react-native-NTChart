//
//  BarView.h
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/9/21.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface BarView : UIView

@property (nonatomic,strong) NSArray *barData;

@property (nonatomic,strong) NSArray *cssStyle;

@property (nonatomic,assign) BOOL *isShowNumber;

@property (nonatomic,strong) NSArray *xLabel;

@end
