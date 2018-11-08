var dom = document.getElementById("pie");
var myChart = echarts.init(dom);
option = {
    title: {
        text: '某站点用户访问来源(饼图)',
        subtext: '纯属虚构',
        x: 'center' // 标题位置
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical', // 标签的布局朝向:'horizontal', 'vertical'
        left: 'right', // 标签在容器的位置
        data: ['A类客户', 'B类客户', 'C类客户', 'D类客户', 'E类客户', 'F类客户', 'G类客户']
    },
    series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: '55%', // 饼的半径占容器的比例(垂直距离)
            center: ['50%', '60%'], // 饼的圆心在容器中的位置(支持百分比和数字)
            data: [
                {value: 335, name: 'A类客户'},
                {value: 310, name: 'B类客户'},
                {value: 234, name: 'C类客户'},
                {value: 135, name: 'D类客户'},
                {value: 234, name: 'E类客户'},
                {value: 135, name: 'F类客户'},
                {value: 548, name: 'G类客户'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 0, // 鼠标移上去阴影的大小
                    shadowOffsetX: 0, // 鼠标移上去阴影的偏移
                    shadowColor: 'rgba(0, 0, 0, 0.5)' // 阴影的颜色
                }
            }
        }
    ]
};

if (option && typeof option === "object") {
    myChart.setOption(option, true);
}