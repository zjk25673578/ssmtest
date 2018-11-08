var dom = document.getElementById("funnel");
var myChart = echarts.init(dom);
option = {
    title: {
        text: '漏斗图',
        subtext: '纯属虚构',
        x: 'center' // 标题位置
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c}" // {a}是series.name, {b}是series.data[idx].name, {c}是series.data[idx]series.data[idx].value
    },
    toolbox: { // 右上角工具按钮
        show: false, // 是否显示
        feature: {
            dataView: {readOnly: false}, // 数据视图
            restore: {}, // 还原
            saveAsImage: {} // 保存成图片
        }
    },
    /* 如果legend.data[idx]和series.data[idx].name对应不起来, 上面的标签是不显示的 */
    legend: {
        orient: 'vertical', // 标签的布局朝向:'horizontal', 'vertical'
        left: 'right', // 标签在容器的位置
        // 显示在上面的标签
        data: ['A类客户', 'B类客户', 'C类客户', 'D类客户', 'E类客户', 'F类客户', 'G类客户']
    },
    calculable: true,
    series: [
        {
            name: '客户分析',
            type: 'funnel',
            left: 0, // 左边距, 0是居中
            top: 60, // 上边距
            //x2: 80,
            bottom: 10, // 下边距
            width: '100%',
            // height: {totalHeight} - y - y2,
            min: 0, // series.data[idx].value的最小值
            max: 2380, // series.data[idx].value的最小值
            minSize: '20%', // 最小的漏斗占据外层容器尺寸百分比
            maxSize: '80%', // 最大的漏斗占据外层容器尺寸百分比
            sort: 'descending',
            gap: 0, // 每个漏斗的间距
            label: {
                normal: {
                    show: true, // 是否在漏斗上显示标签
                    position: 'inside' // 外边显示还是里面显示
                },
                emphasis: {
                    textStyle: {
                        fontSize: 12
                    }
                }
            },
            labelLine: {
                normal: {
                    length: 5, // 当label.normal.position为outside时指示线的长度
                    lineStyle: {
                        width: 1, // 当label.normal.position为outside时指示线的宽度
                        type: 'solid' // 当label.normal.position为outside时指示线的样式
                    }
                }
            },
            itemStyle: {
                normal: {
                    borderColor: '#000', // 边框颜色
                    borderWidth: 0 // 边框宽度
                }
            },
            data: [
                {value: 382, name: 'A类客户'},
                {value: 800, name: 'B类客户'},
                {value: 1142, name: 'C类客户'},
                {value: 1763, name: 'D类客户'},
                {value: 1988, name: 'E类客户'},
                {value: 2211, name: 'F类客户'},
                {value: 2380, name: 'G类客户'}
            ]
        }
    ]
};

if (option && typeof option === "object") {
    myChart.setOption(option, true);
}