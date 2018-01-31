package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;
import org.hamcrest.core.IsEqual;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DailySongAPI {

    private String VideoURL = "http://turing.niallbunting.com:3009/api/video/";
    private String PlaylistURL = "http://turing.niallbunting.com:3009/api/playlist/";
    private String response;
    private String response2;
    private String vResponse;
    private String vResponse1;
    private String vResponse2;
    private String plResponse;
    private String plResponse1;
    private String plResponse2;
    private String addVideo;
    private String delVideo;
    private String delPlaylist;
    private String artist1;
    private String artist2;
    private String publishDate1;
    private String publishDate2;
    private String video1;
    private String video2;
    private String id1;
    private String id2;
    private String videoID;
    private String playlistTitle;
    private String playlistID;
    private String PLid;
    private String newvideoID;
    private String newvideo;
    private String newvideoArtist;
    private String newvideoPublishDate;
    private String newDesc;
    private String newTitle;
    private String newVideos;
    private HttpResponse httpResponse;
    private HttpResponse httpResponse2;


    //Return a list of videos

    @Given("^Add videos to the database$")
    public void PostNewVideo() throws IOException {
        //Post a new video
        String json = "{\n" +
                "\t\"artist\": \"Lady Gaga\",\n" +
                "\t\"song\": \"Poker Face\",\n" +
                "\t\"publishDate\": \"2017-09-01\"\n" +
                "}";
        String json2 = "{\n" +
                "\t\"artist\": \"Ed Sheeran\",\n" +
                "\t\"song\": \"Galway Girl\",\n" +
                "\t\"publishDate\": \"2013-02-01T00:00:00.000Z\"\n" +
                "}";
        httpResponse = Request.Post(VideoURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        httpResponse2 = Request.Post(VideoURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json2, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
    }

    @And("^Get all videos$")
    public void retrieveVideo() throws Throwable {
        // Get all the videos in API
        httpResponse = Request.Get(VideoURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response = handler.handleResponse(httpResponse);
        ChangeToString();
        System.out.println("\n-> GET all videos");
    }

    private void ChangeToString() throws Throwable {

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonArray videos = element.getAsJsonArray();

        //Get artist of first video from the API
        JsonObject artistJson = (JsonObject) videos.get(0);
        JsonElement firstartist = artistJson.get("artist");
        artist1 = firstartist.toString();
        artist1 = artist1.replace("\"", "");

        //Get artist of second video from the API
        JsonObject artistJson2 = (JsonObject) videos.get(1);
        JsonElement secondartist = artistJson2.get("artist");
        artist2 = secondartist.toString();
        artist2 = artist2.replace("\"", "");

        //Get title of first video from the API
        JsonObject videosJson = (JsonObject) videos.get(0);
        JsonElement firstvideo = videosJson.get("song");
        video1 = firstvideo.toString();
        video1 = video1.replace("\"", "");

        //Get title of second video from the API
        JsonObject videosJson1 = (JsonObject) videos.get(1);
        JsonElement secondvideo = videosJson1.get("song");
        video2 = secondvideo.toString();
        video2 = video2.replace("\"", "");

        //Get publish date of first video from the API
        JsonObject publishDateJson = (JsonObject) videos.get(0);
        JsonElement publishDatevideo = publishDateJson.get("publishDate");
        publishDate1 = publishDatevideo.toString();
        publishDate1 = publishDate1.replace("\"", "");

        //Get publish date of second video from the API
        JsonObject publishDateJson1 = (JsonObject) videos.get(1);
        JsonElement publishDate1video = publishDateJson1.get("publishDate");
        publishDate2 = publishDate1video.toString();
        publishDate2 = publishDate2.replace("\"", "");

        //Get ID of first video from the API
        JsonObject videosJson3 = (JsonObject) videos.get(0);
        JsonElement thirdvideo = videosJson3.get("_id");
        id1 = thirdvideo.toString();
        id1 = id1.replace("\"", "");

        //Get ID of second video from the API
        JsonObject videosJson4 = (JsonObject) videos.get(1);
        JsonElement fourthvideo = videosJson4.get("_id");
        id2 = fourthvideo.toString();
        id2 = id2.replace("\"", "");

    }

    //Check API response code
    @Then("^Check video GET response code$")
    public void CheckGETvideoStatus() throws Throwable {
        int response = httpResponse.getStatusLine().getStatusCode();
        assertThat(response, equalTo(200));
        System.out.println("Response matched: " + response);
    }

    //Check title from the API
    @And("Check GET video title from API$")
    public void CheckGETvideoTitle() throws Throwable {
        assertThat(video1, IsEqual.<String>equalTo("Poker Face"));
        assertThat(video2, IsEqual.<String>equalTo("Galway Girl"));
        System.out.println("Title1 matched: " + video1);
        System.out.println("Title2 matched: " + video2);
    }

    //Check artist from the API
    @And("^Check GET artist from API$")
    public void CheckGETvideoArtist() throws Throwable {
        assertThat(artist1, IsEqual.<String>equalTo("Lady Gaga"));
        assertThat(artist2, IsEqual.<String>equalTo("Ed Sheeran"));
        System.out.println("Artist1 matched: " + artist1);
        System.out.println("Artist2 matched: " + artist2);
    }

    //Check publish date from the API
    @And("^Check GET publish date from API$")
    public void CheckGETvideoDate() throws Throwable {
        assertThat(publishDate1, IsEqual.<String>equalTo("2017-09-01T00:00:00.000Z"));
        assertThat(publishDate2, IsEqual.<String>equalTo("2013-02-01T00:00:00.000Z"));
        System.out.println("Publish date1 matched: " + publishDate1);
        System.out.println("Publish date2 matched: " + publishDate2);
    }

    //Returns data about a single video
    @Then("^Return data about single video by ID$")
    public void videoGetCall() throws Throwable {
        //Get the first video with ID
        httpResponse = Request.Get(VideoURL + id2)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        System.out.println("\n-> GET video by ID");
        ResponseHandler<String> handler = new BasicResponseHandler();
        String vResponse = handler.handleResponse(httpResponse);
        int response = httpResponse.getStatusLine().getStatusCode();

        assertThat(response, equalTo(200));

        System.out.println("Response matched: " + response);
        System.out.println("video information for " + id2 + " : " + vResponse);

        assertThat(video2, IsEqual.<String>equalTo("Galway Girl"));
        System.out.println("Title matched: " + video2);

        assertThat(artist2, IsEqual.<String>equalTo("Ed Sheeran"));
        System.out.println("Artist matched: " + artist2);

        assertThat(publishDate2, IsEqual.<String>equalTo("2013-02-01T00:00:00.000Z"));
        System.out.println("Publish date matched: " + publishDate2);

    }

    //Update video

    @Given("^Get all API videos$")
    public void GetAllvideos() throws Throwable {
        // Get all videos from API
        httpResponse = Request.Get(VideoURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response = handler.handleResponse(httpResponse);
        AllStrings();
    }

    private void AllStrings() throws Throwable {

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonArray videos = element.getAsJsonArray();

        //Get first video's ID from API
        JsonObject videosJson3 = (JsonObject) videos.get(0);
        JsonElement thirdvideo = videosJson3.get("_id");
        videoID = thirdvideo.toString();
        videoID = videoID.replace("\"", "");
    }

    @Then("^Update information of a video by ID$")
    public void Updatevideo() throws Throwable {

        //Update first video by ID
        try {
            httpResponse = Request.Patch(VideoURL + videoID)
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute()
                    .returnResponse();
            System.out.println("\n-> Update video");
            System.out.println(httpResponse.getStatusLine());
        } catch (HttpResponseException e) {
            StatusLine status = httpResponse.getStatusLine();
            System.out.println("\n-> Update video");
            System.out.println("Video has not been updated: " + status);
        }
    }

    //Create a video

    @Given("^Post new video to the API$")
    public void PostVideo() throws Throwable {
        //Post a new video
        String json = "{\n" +
                "\t\"artist\": \"Lady Gaga\",\n" +
                "\t\"song\": \"Poker Face\",\n" +
                "\t\"publishDate\": \"2017-09-01\"\n" +
                "}";

        httpResponse = Request.Post(VideoURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        System.out.println("\n-> POST video");
        ResponseHandler<String> handler = new BasicResponseHandler();
        vResponse = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();

        JsonElement elementID = parser.parse(vResponse).getAsJsonObject().get("_id");
        newvideoID = elementID.toString();
        newvideoID = newvideoID.replace("\"", "");

        JsonElement elementvideo = parser.parse(vResponse).getAsJsonObject().get("song");
        newvideo = elementvideo.toString();
        newvideo = newvideo.replace("\"", "");

        JsonElement elementArtist = parser.parse(vResponse).getAsJsonObject().get("artist");
        newvideoArtist = elementArtist.toString();
        newvideoArtist = newvideoArtist.replace("\"", "");

        JsonElement elementPublishDate = parser.parse(vResponse).getAsJsonObject().get("publishDate");
        newvideoPublishDate = elementPublishDate.toString();
        newvideoPublishDate = newvideoPublishDate.replace("\"", "");
    }

    @Then("^Check video POST response code$")
    public void CheckPostStatus() throws Throwable {
        int postStatus = httpResponse.getStatusLine().getStatusCode();
        assertThat(postStatus, equalTo(201));
        System.out.println("Response matched: " + postStatus);
    }

    @And("^Check POST video title from API$")
    public void CheckPostTitle() throws Throwable {
        assertThat(newvideo, IsEqual.<String>equalTo("Poker Face"));
        System.out.println("video matched: " + newvideo);
    }

    @And("^Check POST artist from API$")
    public void CheckPostArtist() throws Throwable {
        assertThat(newvideoArtist, IsEqual.<String>equalTo("Lady Gaga"));
        System.out.println("Artist matched: " + newvideoArtist);
    }

    @And("^Check POST publish date from API$")
    public void CheckPostDate() throws Throwable {
        assertThat(newvideoPublishDate, IsEqual.<String>equalTo("2017-09-01T00:00:00.000Z"));
        System.out.println("Publish date matched: " + newvideoPublishDate);
    }

    //Delete a video

    @Given("^Delete an existing video$")
    public void DeleteVideo() throws Throwable {
        //Delete the video you have just uploaded to the API
        String json = "{\n" +
                "\t\"artist\": \"Lady Gaga\",\n" +
                "\t\"song\": \"Poker Face\",\n" +
                "\t\"publishDate\": \"2017-09-01\"\n" +
                "}";

        httpResponse = Request.Post(VideoURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        vResponse = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();

        JsonElement elementID = parser.parse(vResponse).getAsJsonObject().get("_id");
        newvideoID = elementID.toString();
        newvideoID = newvideoID.replace("\"", "");
        httpResponse = Request.Delete(VideoURL + newvideoID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler1 = new BasicResponseHandler();
        handler1.handleResponse(httpResponse);
        int status = httpResponse.getStatusLine().getStatusCode();
        assertThat(status, equalTo(204));
        System.out.println("\n-> Delete video");
        System.out.println("Video " + newvideoID + " deleted: " + status);
    }

    //Create a playlist

    @Given("^Create a new playlist$")
    public void NewPlayList() throws Throwable {
        String json = "{\n" +
                "\t\"desc\": \"My first playlist\",\n" +
                "\t\"title\": \"My List\"\n" +
                "}";
        httpResponse = Request.Post(PlaylistURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response2 = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();


        JsonElement elementID = parser.parse(response2).getAsJsonObject().get("_id");
        newDesc = elementID.toString();
        newDesc = newDesc.replace("\"", "");

        JsonElement elementDesc = parser.parse(response2).getAsJsonObject().get("desc");
        newDesc = elementDesc.toString();
        newDesc = newDesc.replace("\"", "");

        JsonElement elementTitle = parser.parse(response2).getAsJsonObject().get("title");
        newTitle = elementTitle.toString();
        newTitle = newTitle.replace("\"", "");

        JsonElement elementVideos = parser.parse(response2).getAsJsonObject().get("videos");
        newVideos = elementVideos.toString();
        newVideos = newVideos.replace("\"", "");
    }


    @Then("^Check playlist POST response code$")
    public void CheckPlStatus() throws Throwable {
        int response2 = httpResponse.getStatusLine().getStatusCode();
        assertThat(response2, equalTo(201));
        System.out.println("\n-> Post video");
        System.out.println("Response matched: " + response2);
    }

    @And("^Check playlist POST Desc$")
    public void CheckDesc() throws Throwable {
        assertThat(newDesc, IsEqual.<String>equalTo("Top 40 playlist."));
        System.out.println("Desc matched: " + newDesc);
    }

    @And("^Check playlist POST title$")
    public void CheckTitle() throws Throwable {
        assertThat(newTitle, IsEqual.<String>equalTo("Top 40"));
        System.out.println("Title matched: " + newTitle);
    }

    @And("^Check playlist POST videos$")
    public void CheckVideos() throws Throwable {
        assertThat(newVideos, IsEqual.<String>equalTo("[]"));
        System.out.println("Videos matched: " + newVideos);
    }


    //Add and remove video from the playlist.

    @Given("^Create another playlist$")
    public void CreateNewPlayList() throws Throwable {
        String json = "{\n" +
                "\t\"desc\": \"List for my use.\",\n" +
                "\t\"title\": \"My List\"\n" +
                "}";
        httpResponse = Request.Post(PlaylistURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response2 = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();

        JsonElement elementDesc = parser.parse(response2).getAsJsonObject().get("_id");
        PLid = elementDesc.toString();
        PLid = PLid.replace("\"", "");
    }

    @Then("^Add another video to the new playlist$")
    public void AddvideotoPL() throws Throwable {
        httpResponse = Request.Get(VideoURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonArray videos = element.getAsJsonArray();

        JsonObject videosJson3 = (JsonObject) videos.get(0);
        JsonElement thirdvideo = videosJson3.get("_id");
        id1 = thirdvideo.toString();
        id1 = id1.replace("\"", "");

        //Get ID of second video from the API
        JsonObject videosJson4 = (JsonObject) videos.get(1);
        JsonElement fourthvideo = videosJson4.get("_id");
        id2 = fourthvideo.toString();
        id2 = id2.replace("\"", "");
        //Add a video from the video api to playlist
        String json = "{ \"videos\": [ {\"" + id1 + "\": \"add\"}, {\"" + id2 + "\": \"add\"} ] }";
        httpResponse = Request.Patch(PlaylistURL + PLid)
                    .addHeader("content-type", "application/json")
                    .addHeader("Accept", "application/json")
                    .bodyString(json, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnResponse();
        ResponseHandler < String > handler1 = new BasicResponseHandler();
        addVideo = handler1.handleResponse(httpResponse);
        System.out.println("\n-> Update playlist");
        System.out.println(httpResponse.getStatusLine());
    }

    @And("^Delete the video added from the playlist$")
    public void RemovevideoFromPL() throws Throwable {
        //Remove a video from the playlist
        String json = "{ \"videos\": [ {\"" + id1 + "\": \"remove\"} ] }";
        try {
            httpResponse = Request.Patch(PlaylistURL + PLid)
                    .addHeader("content-type", "application/json")
                    .addHeader("Accept", "application/json")
                    .bodyString(json, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnResponse();
            ResponseHandler<String> handler = new BasicResponseHandler();
            delVideo = handler.handleResponse(httpResponse);
            System.out.println(delVideo);
        }
        catch (HttpResponseException e){
            StatusLine status = httpResponse.getStatusLine();
            System.out.println("video not removed from playlist: " + status);
        }
    }

    //Return playlists.

    @Given("^Get all playlists$")
    public void GetPlaylist() throws Throwable {
        // Get all playlists from the api
        httpResponse = Request.Get(PlaylistURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        plResponse = handler.handleResponse(httpResponse);
        getPlayListID();
        getPlaylistTitle();
    }

    private void getPlaylistTitle() {
        
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(plResponse);
        JsonArray playlists = element.getAsJsonArray();

        //Get last video's ID from API
        JsonObject plJson = (JsonObject) playlists.get(playlists.size() - 1);
        JsonElement plElement = plJson.get("title");
        playlistTitle = plElement.toString();
        playlistTitle = playlistTitle.replace("\"", "");
    }

    private void getPlayListID() {
        System.out.println("\n-> Get all playlists");
        System.out.println("List of playlists in the API: " + plResponse);
        System.out.println("Title: " + playlistTitle);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(plResponse);
        JsonArray playlists = element.getAsJsonArray();

        JsonObject plJson = (JsonObject) playlists.get(playlists.size() - 1);
        JsonElement plElement = plJson.get("_id");
        playlistID = plElement.toString();
        playlistID = playlistID.replace("\"", "");
        System.out.println("ID: " + playlistID);
    }

    @Then("^Check playlist GET response code$")
    public void CheckGetApiResponse() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        assertThat(status, equalTo(200));
        System.out.println("Response code matched: " + status);
    }

    @And("^Return data about single playlist by ID$")
    public void PlayListGetCallByID() throws Throwable {
        // Get a playlist by a specific ID
        httpResponse = Request.Get(PlaylistURL + playlistID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        plResponse1 = handler.handleResponse(httpResponse);
        System.out.println("Playlist data for ID " + playlistID + ": " + plResponse1);
    }

    @Then("^Check GET playlist by ID response code$")
    public void CheckAPIResponse() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
        assertThat(status, equalTo(200));
        System.out.println("Response code matched for ID " + playlistID + ": " + status);
    }

    //Delete a playlist

    @Given("^Delete an existing playlist by ID$")

    public void GetPlaylisttoDelete() throws Throwable {
        // Get all playlists from the API
        httpResponse = Request.Get(PlaylistURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        plResponse = handler.handleResponse(httpResponse);
        getPlaylistIDtoDelete();
        Check204Status();
    }

    private void getPlaylistIDtoDelete() throws Throwable {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(plResponse);
        JsonArray playlists = element.getAsJsonArray();
        System.out.println(playlists);
        JsonObject plJson = (JsonObject) playlists.get(0);
        JsonElement plElement = plJson.get("_id");
        playlistID = plElement.toString();
        playlistID = playlistID.replace("\"", "");
        System.out.println("\n-> Delete playlist");
        System.out.println("Deleting " + playlistID);
        httpResponse = Request.Delete(PlaylistURL + playlistID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        plResponse = handler.handleResponse(httpResponse);
    }
    public void Check204Status() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        assertThat(status, equalTo(204));
        System.out.println("Playlist deleted: " + status);
    }
}