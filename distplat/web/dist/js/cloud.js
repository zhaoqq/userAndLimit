

d3.json("../../data/hotworlds.json", function(error,data) {
    if (error) throw error;
    var tags = data.result;
    WordCloud(document.getElementById('cloud'), {
        list : tags.map(function(word) { return [word[0], Math.round(word[1]/5500)]; })
    });
});



