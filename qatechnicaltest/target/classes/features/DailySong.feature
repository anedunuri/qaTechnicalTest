@DailyVideo
Feature: Daily Video API

  @ReturnVideo
  Scenario: Return a list of videos
    Given Add videos to the database
    And Get all videos
    Then Check video GET response code
    And Check GET video title from API
    And Check GET artist from API
    And Check GET publish date from API
    And Return data about single video by ID

  @PatchVideo
  Scenario: Update video
    Given Get all API videos
    Then Update information of a video by ID


  @CreateVideo
  Scenario: Create a video
    Given Post new video to the API
    Then Check video POST response code
    And Check POST video title from API
    And Check POST artist from API
    And Check POST publish date from API


  @DeleteVideo
  Scenario: Delete a video
    Given Delete an existing video


  @CreatePlaylist
  Scenario: Create a playlist
    Given Create a new playlist
    Then Check playlist POST response code
    And Check playlist POST Desc
    And Check playlist POST title
    And Check playlist POST videos


  @PatchPlaylist
  Scenario: Add and remove song from the playlist
    Given Create another playlist
    Then Add another video to the new playlist
    And Delete the video added from the playlist


  @GetPlaylist
  Scenario: Return a single playlist
    Given Get all playlists
    Then Check playlist GET response code
    And Return data about single playlist by ID
    Then Check GET playlist by ID response code


  @DeletePlaylist
  Scenario: Delete a playlist
    Given Delete an existing playlist by ID