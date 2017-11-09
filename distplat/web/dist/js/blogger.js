$(function () {
    "use strict";
    //博主分析--男女比例
    var donut = new Morris.Donut({
        element: 'men_women',
        resize: true,
        colors: ["#3c8dbc", "#f56954", "#00a65a"],
        data: [
            {label: "男性", value: 75.86},
            {label: "女性", value: 24.14},
        ],
        hideHover: 'auto'
    });
});