$(document).ready(function() {
    $.get("http://localhost:8080/sample/rest/hello/Sample", function(data) {
        $("#result-hello").text(data.result);
    });
    $.get("http://localhost:8080/sample/rest/goodbye/Sample", function(data) {
        $("#result-goodbye").text($(data).find("result").text());
    });
});
