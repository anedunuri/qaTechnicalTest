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
  "line": 5,
  "name": "Return a list of videos",
  "description": "",
  "id": "daily-video-api;return-a-list-of-videos",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@ReturnVideo"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Add videos to the database",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Get all videos",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Check video GET response code",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Check GET video title from API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Check GET artist from API",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Check GET publish date from API",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Return data about single video by ID",
  "keyword": "And "
});
formatter.match({
  "location": "DailySongAPI.PostNewVideo()"
});
formatter.result({
  "duration": 1906973228,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.retrieveVideo()"
});
formatter.result({
  "duration": 76276132,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckGETvideoStatus()"
});
formatter.result({
  "duration": 11972125,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckGETvideoTitle()"
});
formatter.result({
  "duration": 266740,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckGETvideoArtist()"
});
formatter.result({
  "duration": 213923,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckGETvideoDate()"
});
formatter.result({
  "duration": 1384994,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.videoGetCall()"
});
formatter.result({
  "duration": 47834546,
  "status": "passed"
});
});