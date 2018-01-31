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
  "line": 59,
  "name": "Delete a playlist",
  "description": "",
  "id": "daily-video-api;delete-a-playlist",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 58,
      "name": "@DeletePlaylist"
    }
  ]
});
formatter.step({
  "line": 60,
  "name": "Delete an existing playlist by ID",
  "keyword": "Given "
});
formatter.match({
  "location": "DailySongAPI.GetPlaylisttoDelete()"
});
formatter.result({
  "duration": 151159671,
  "status": "passed"
});
});