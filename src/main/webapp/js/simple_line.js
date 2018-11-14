var dom = document.getElementById("line2");
var myChart = echarts.init(dom);
option = {
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        },
        borderWidth: 1,
        borderColor: '#ccc',
        padding: 10
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line'
    }]
};
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}