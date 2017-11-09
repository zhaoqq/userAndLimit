

d3.json("../../data/corePeople.json", function(error,data) {
    if (error) throw error;
    var dataset = data.result;

    //core_ins
    var i = 0;
    var c_ins = document.getElementById('core_ins');

    var core_header = "";
    for(var k in dataset){
        core_header +=
            "<div class=\"col-md-4\"><div class=\"user-block\">"+
            "<img class=\"img-rounded\" alt=\"User Image\" src=\" " + dataset[k][1] + "\">" +
            "<span class=\"username\"><a>" + dataset[k][2] +"</a></span>" +
            "<div class=\"col-sm-5\"><h6 class=\"description-text\">粉丝：<span>" + dataset[k][3] +"</span></h6></div>" +
            "<div class=\"col-sm-4\"><h6 class=\"description-text\">关注：<span>" + dataset[k][4] +"</span></h6></div></div></div>";
        if((k+1) % 3 == 0){
            core_header += "<div class=\"clearfix\"></div><br>"
        }
    }
    c_ins.innerHTML = core_header;

});




