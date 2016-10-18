/**
 * Created by wuxiaochen on 16/9/21.
 */

import React from 'react';
import { requireNativeComponent,PropTypes,Platform,View } from 'react-native';

if(Platform.OS=='ios') {
    class BarView extends React.Component {
        render() {
            return <RCTBar {...this.props} />;
        }
    }

    BarView.propTypes = {

        barData:React.PropTypes.array,

        cssStyle:React.PropTypes.array,

        xLabel : React.PropTypes.array,

        isShowNumber:React.PropTypes.bool,
    };

    var RCTBar = requireNativeComponent('RNBarView', BarView);

    module.exports = BarView;

}else {
    var barView = {
        name: 'BarView',
        propTypes: {
            barData:React.PropTypes.array,
            xLabel:React.PropTypes.array,
            isShowNumber:React.PropTypes.bool,
            ...View.propTypes // include the default view properties
        },
    };

    module.exports = requireNativeComponent('RNBarView', barView);
}
