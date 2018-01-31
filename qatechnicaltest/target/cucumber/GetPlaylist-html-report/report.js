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
  "line": 51,
  "name": "Return a single playlist",
  "description": "",
  "id": "daily-video-api;return-a-single-playlist",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 50,
      "name": "@GetPlaylist"
    }
  ]
});
formatter.step({
  "line": 52,
  "name": "Get all playlists",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "Check playlist GET response code",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "Return data about single playlist by ID",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "Check GET playlist by ID response code",
  "keyword": "Then "
});
formatter.match({
  "location": "DailySongAPI.GetPlaylist()"
});
formatter.result({
  "duration": 74232649,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckGetApiResponse()"
});
formatter.result({
  "duration": 173266,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.PlayListGetCallByID()"
});
formatter.result({
  "duration": 49798995,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckAPIResponse()"
});
formatter.result({
  "duration": 158448,
  "status": "passed"
});
});