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
  "line": 35,
  "name": "Create a playlist",
  "description": "",
  "id": "daily-video-api;create-a-playlist",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 34,
      "name": "@CreatePlaylist"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "Create a new playlist",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Check playlist POST response code",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Check playlist POST Desc",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "Check playlist POST title",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "Check playlist POST videos",
  "keyword": "And "
});
formatter.match({
  "location": "DailySongAPI.NewPlayList()"
});
formatter.result({
  "duration": 1908956675,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckPlStatus()"
});
formatter.result({
  "duration": 5944646,
  "status": "passed"
});
formatter.match({
  "location": "DailySongAPI.CheckDesc()"
});
formatter.result({
  "duration": 3074346,
  "error_message": "java.lang.AssertionError: \nExpected: \"Top 40 playlist.\"\n     but: was \"My first playlist\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.junit.Assert.assertThat(Assert.java:956)\r\n\tat org.junit.Assert.assertThat(Assert.java:923)\r\n\tat definitions.DailySongAPI.CheckDesc(DailySongAPI.java:418)\r\n\tat ✽.And Check playlist POST Desc(DailySong.feature:38)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "DailySongAPI.CheckTitle()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DailySongAPI.CheckVideos()"
});
formatter.result({
  "status": "skipped"
});
});