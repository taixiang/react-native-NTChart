/**
 * Created by wuxiaochen on 16/9/22.
 */
import React from 'react';
import { requireNativeComponent,PropTypes,Platform,View} from 'react-native';

if(Platform.OS=='ios'){
    class LineView extends React.Component {
        render() {
            return <RCTLine {...this.props} />;
        }
    }

    LineView.propTypes = {

        lineData:React.PropTypes.array,

        cssStyle:React.PropTypes.array,

        xLabel : React.PropTypes.array,

        //isShowNumber:React.PropTypes.bool,
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
}



