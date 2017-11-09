

d3.json("../../data/adviceleader.json", function(error,data) {
    if (error) throw error;
    var dataset = data.result;

    var i = 0;
    for(var k in dataset){
        var user_header = "";
        var user_body = "";

        var l_header = document.getElementById('leader_header'+ i);
        var l_body = document.getElementById('leader_body' + i);

        var user_id = dataset[k][0][0];
        var user_img = dataset[k][1][0][1][0];
        var user_name = dataset[k][1][0][1][1];
        var user_fans = dataset[k][1][0][1][2];
        var user_follow = dataset[k][1][0][1][3];
        var user_resend = dataset[k][1][0][1][4];
        var user_weibo = dataset[k][1][0][1][5];

        user_header =
            "<img class=\"img-rounded\" alt=\"User Image\" src=\" " + user_img + "\">" +
            "<span class=\"username\"><a>" + user_name +"</a></span>" +
            "<div class=\"col-sm-3\"><div class=\"description-block\" style=\"text-align: center\"><h6 class=\"description-text\" style=\"margin-bottom: 2px\">粉丝</h6><h6 style=\"margin-top: 2px\">" + user_fans +"</h6></div></div>" +
            "<div class=\"col-sm-3\"><div class=\"description-block\" style=\"text-align: center\"><h6 class=\"description-text\" style=\"margin-bottom: 2px\">关注</h6><h6 style=\"margin-top: 2px\">" + user_follow +"</h6></div></div>" +
            "<div class=\"col-sm-3\"><div class=\"description-block\" style=\"text-align: center\"><h6 class=\"description-text\" style=\"margin-bottom: 2px\">转发</h6><h6 style=\"margin-top: 2px\">" + user_resend +"</h6></div></div>";

        user_body = "<p>" + user_weibo + "</p>";
        l_header.innerHTML = user_header;
        l_body.innerHTML = user_body;
        i++;
    }
});