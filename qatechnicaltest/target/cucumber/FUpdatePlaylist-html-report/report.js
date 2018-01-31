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
  "line": 44,
  "name": "Add and remove song from the playlist",
  "description": "",
  "id": "daily-video-api;add-and-remove-song-from-the-playlist",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 43,
      "name": "@PatchPlaylist"
    }
  ]
});
formatter.step({
  "line": 45,
  "name": "Create another playlist",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "Add another video to the new playlist",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "Delete the video added from the playlist",
  "keyword": "And "
});
formatter.match({
  "location": "DailySongAPI.CreateNewPlayList()"
});
formatter.result({
  "duration": 53574767,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.AddvideotoPL()"
});
formatter.result({
  "duration": 113944935,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.RemovevideoFromPL()"
});
formatter.result({
  "duration": 49827873,
  "status": "passed"
});
});