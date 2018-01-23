package api.url;

public class ApiUrl {
    private final String videoApi = "https://youtube-api-challenger.appspot.com/videos";
    private final String membersApi = "https://youtube-api-challenger.appspot.com/members";
    private final String authenticationApi = "https://youtube-api-challenger.appspot.com/authentication";
    private final String playlistApi = "https://youtube-api-challenger.appspot.com/playlists";

    public String getVideoApi() {
        return videoApi;
    }

    public String getMembersApi() {
        return membersApi;
    }

    public String getAuthenticationApi() {
        return authenticationApi;
    }

    public String getPlaylistApi() {
        return playlistApi;
    }
}
