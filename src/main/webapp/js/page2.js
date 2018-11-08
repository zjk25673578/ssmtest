var dom = document.getElementById("bar");
var myChart = echarts.init(dom);
// app.title = '坐标轴刻度与标签对齐';

option = {
    title: {
        text: '柱状图',
        subtext: '纯属虚构',
        x: 'center' // 标题位置
    },
    color: ['#3398DB','#DB2F1F'], // 柱子的背景色
    tooltip: {
        trigger: 'axis', // 坐标轴(axis)触发有效, item是指在柱子上触发, axis是指在轴上触发
        axisPointer: {  // 坐标轴指示器
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%', // 左边距
        right: '4%', // 右边距
        bottom: '3%', // 下边距
        containLabel: true
    },
    // X轴
    xAxis: [
        {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    // Y轴
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: '直接访问',
            type: 'bar',
            barWidth: '20%', // 柱子宽, 占每个模块的百分比, 或者直接写number
            data: [10, 52, 200, 334, 390, 330, 220]
        },
        {
            name: '电话咨询',
            type: 'bar',
            barWidth: '20%', // 柱子宽, 占每个模块的百分比, 或者直接写number
            data: [101, 522, 20, 33, 256, 333, 126]
        }
    ]
};
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}