$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DailySong.feature");
formatter.feature({
  "line": 2,
  "name": "Daily Video API",
  "description": "",
  "id": "daily-video-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@DailyVideo"
    }
  ]
});
formatter.scenario({
  "line": 30,
  "name": "Delete a video",
  "description": "",
  "id": "daily-video-api;delete-a-video",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@DeleteVideo"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "Delete an existing video",
  "keyword": "Given "
});
formatter.match({
  "location": "DailySongAPI.DeleteVideo()"
});
formatter.result({
  "duration": 2581283010,
  "status": "passed"
});
});