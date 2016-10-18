/**
 * Created by wuxiaochen on 16/6/6.
 */
//import { requireNativeComponent } from 'react-native';

// requireNativeComponent automatically resolves this to "RCTMapManager"
//module.exports = requireNativeComponent('PieView', null);



import React from 'react';
import { requireNativeComponent ,PropTypes,Platform,View } from 'react-native';

if(Platform.OS=='ios'){
    class PieView extends React.Component {
        render() {
            return <RCTPie {...this.props} />;
        }
    }

    PieView.propTypes = {

        pieData:React.PropTypes.array,

        cssStyle:React.PropTypes.array,

        isHaveData:React.PropTypes.bool,

        colorData : React.PropTypes.array,
    };

    var RCTPie = requireNativeComponent('RNView', PieView);

    module.exports = PieView;
}else {
    var barView = {
        name: 'PieView',
        propTypes: {
            pieData:React.PropTypes.array,
            colorData:React.PropTypes.array,
            isHaveData:React.PropTypes.bool,
            ...View.propTypes // include the default view properties
        },
    };

    module.exports = requireNativeComponent('RNView', barView);
}

