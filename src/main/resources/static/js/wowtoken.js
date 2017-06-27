$(function() {
    Highcharts.setOptions({lang:{
        months:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        shortMonths:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        weekdays:['星期日','星期一','星期二','星期三','星期四','星期五','星期六',]}});
    $("#msg").html("加载数据,请稍等...");
    $.get("/wowtokens", function(data) {
        if(data.length > 0) {
            // 修正时间
            for(var j in data) {
                data[j][0] = data[j][0]+8*60*60*1000;
            }
            var past24 = data[data.length-1][0] - 24*60*60*1000;
            var minBuy = 0;
            var maxBuy = 0;
            for(var i in data) {
                var updated = data[i][0];
                var buy = data[i][1];
                if(updated >= past24) {
                    if(minBuy === 0 || minBuy > buy) {
                        minBuy = buy;
                    }
                    if(maxBuy === 0 || maxBuy < buy) {
                        maxBuy = buy;
                    }
                }
            }
            $("#msg").html("<h3>时光徽章</h3><h4>当前价格: " + data[data.length-1][1] + "G</h4><h4>更新时间: " + new Date(data[data.length-1][0]).format("MM-dd hh:mm:ss")+"</h4><h4>24小时内:</h4><h4>最低价格: "+minBuy+"G</h4><h4>最高价格: "+maxBuy+"G</h4>");
        }
    }).fail(function() {
        $("#msg").html("数据加载出错");
    });
});