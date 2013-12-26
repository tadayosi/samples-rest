$(document).ready(function() {
    $.get("/sample/rest/hello/Sample", function(data) {
        $("#result-hello").text(data.result);
    });
    $.get("/sample/rest/goodbye/Sample", function(data) {
        $("#result-goodbye").text($(data).find("result").text());
    });
});
