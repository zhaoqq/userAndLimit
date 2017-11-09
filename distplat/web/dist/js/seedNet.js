/**
 * Created by liyin521xinxin on 2017/9/24.
 */


var width = 900;
var height = 600;

var svg = d3.select("#d_G")
    .append("svg")
    .attr("width",width)
    .attr("height",height);
    /*.call(d3.zoom().scaleExtent([0.5, 2]).on("zoom", zoomed));*/

var color = d3.scaleOrdinal(d3.schemeCategory10);

var simulation = d3.forceSimulation() //创建力导向模拟器
    .force("link", d3.forceLink().id(function(d) { return d.id; }))
    .force("charge", d3.forceManyBody())
    .force("center", d3.forceCenter(width / 2, height / 2));  //设定图的中心

/*var zoomed = function(){
    d3.select(this).selectAll("g").attr("transform",   d3.event.transform);
}*/


d3.json("http://10.108.17.218:8090/jobs/541b8812-21b5-4c57-b63d-9a8892255580", function(error, data) {
    if (error) throw error;


    var graph = JSON.parse(data.result);

    var link = svg.append("g")
        .attr("class", "links")   //设置属性为links类型
        .selectAll("line")
        .data(graph.links)
        .enter()
        .append("line")
        .attr("stroke-width", function(d) { return Math.sqrt(d.value); });

    var node = svg.append("g")
        .attr("class", "nodes")    //设置属性为nodes类型
        .selectAll("circle")
        .data(graph.nodes)
        .enter()
        .append("circle")
        .attr("r", function(d){
            if(d.group == 1)
                return 7;
            else
                return 10;
        })
        .attr("fill", function(d) { return color(d.group); })
        .call(d3.drag()
            .on("start", dragstarted)
            .on("drag", dragged)
            .on("end", dragended));

    node.append("title")
        .text(function(d) {
            if(d.group == 1)
                return "普通节点，id："+ d.id;
            else
                return "种子节点，id："+ d.id;
        });

    simulation
        .nodes(graph.nodes)
        .on("tick", ticked);   //更新坐标

    simulation
        .force("link")
        .links(graph.links);

    function ticked() {
        link
            .attr("x1", function(d) { return d.source.x; })
            .attr("y1", function(d) { return d.source.y; })
            .attr("x2", function(d) { return d.target.x; })
            .attr("y2", function(d) { return d.target.y; });

        node
            .attr("cx", function(d) { return d.x; })
            .attr("cy", function(d) { return d.y; });
    }

});

function dragstarted(d) {
    if (!d3.event.active) simulation.alphaTarget(0.3).restart();  //restart是重新恢复模拟
    d.fx = d.x;  //d.x是当前位置，d.fx是固定位置
    d.fy = d.y;
}

function dragged(d) {
    d.fx = d3.event.x;
    d.fy = d3.event.y;
}

function dragended(d) {
    if (!d3.event.active) simulation.alphaTarget(0);
    d.fx = null;    //解除dragged中固定的坐标
    d.fy = null;
}
