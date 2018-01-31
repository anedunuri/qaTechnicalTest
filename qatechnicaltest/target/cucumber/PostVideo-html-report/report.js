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
  "line": 21,
  "name": "Create a video",
  "description": "",
  "id": "daily-video-api;create-a-video",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@CreateVideo"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "Post new video to the API",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "Check video POST response code",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Check POST video title from API",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Check POST artist from API",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Check POST publish date from API",
  "keyword": "And "
});
formatter.match({
  "location": "DailySongAPI.PostVideo()"
});
formatter.result({
  "duration": 53553868,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckPostStatus()"
});
formatter.result({
  "duration": 148949,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckPostTitle()"
});
formatter.result({
  "duration": 154268,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckPostArtist()"
});
formatter.result({
  "duration": 202905,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckPostDate()"
});
formatter.result({
  "duration": 136789,
  "status": "passed"
});
});