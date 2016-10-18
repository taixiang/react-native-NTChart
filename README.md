# react-native-NTChart
安装：  
  `npm install react-native-ntchart`  
  `rnpm link react-native-ntchart`  
 
Android 添加:  
  `找到getPackages方法所在的类`    
  `头部添加import com.ntutilchart.ChartPackage;`   
  `getPackages 方法里添加 new ChartPackage()(如下)`  
  `@Override`   
    `protected List<ReactPackage> getPackages() {`  
      `return Arrays.<ReactPackage>asList(`  
         `new MainReactPackage(),`  
         `new ChartPackage()`  
      `);`  
    `}`  
 
JS调用:  
  `折线图LineView`
  ` import React from 'react';
  import { requireNativeComponent,PropTypes,Platform,View} from 'react-native';
  if(Platform.OS=='ios'){
    class LineView extends React.Component {
        render() {
            return <RCTLine {...this.props} />;
        }
    }
    LineView.propTypes = {
        xLabel : React.PropTypes.array, //x轴数据
        lineData:React.PropTypes.array, //y轴数值
        cssStyle:React.PropTypes.array, //仅ios使用
    };
    var RCTLine = requireNativeComponent('RNLineView', LineView);
    module.exports = LineView;
    }else {
    var lineView = {
        name: 'LineView',
        propTypes: {
            lineData:React.PropTypes.array,
            xLabel:React.PropTypes.array,
            ...View.propTypes // include the default view properties
        },
    };
    module.exports = requireNativeComponent('RNLineView', lineView);
}`  
  `折线图 xLabel：x轴数据  lineData：y轴数值`  
  `<LineView style={{width:200,height:200}}`  
             `lineData = {['1','2','5']}`  
             `xLabel = {['1','2','5']}`  
      `/>`  

  `柱状图 xLabel：x轴数据  lineData：y轴数值  isShowNumber：是否在柱状图上显示数据`  
      `<BarView style={{width:200,height:200}}`  
               `barData = {['1','2','5']}`  
                `xLabel = {['1','2','5']}`  
               `isShowNumber = {true}`  
      `/>`  

  `柱状图 pieData：数据  colorData：颜色块  isHaveData：是否有数据(false 默认为灰色)`  
      `<PieView style={{width:100,height:100}}`  
               `pieData = {['1','2','5']}`  
               `colorData = {['ff0000','00ff00','0000ff']}`  
               `isHaveData = {true}`  
      `/>`  
