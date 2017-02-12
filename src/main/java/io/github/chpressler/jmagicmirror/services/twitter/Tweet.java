package io.github.chpressler.jmagicmirror.services.twitter;

import javafx.scene.image.Image;
import javafx.scene.media.VideoTrack;

/**
 * Created by christian on 12/23/16.
 */
public class Tweet {

    String tweet;
    Image image;
    VideoTrack video;

    public Tweet(String tweet, Image image, VideoTrack video) {
        this.tweet = tweet;
        this.image = image;
        this.video = video;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public VideoTrack getVideo() {
        return video;
    }

    public void setVideo(VideoTrack video) {
        this.video = video;
    }
    
}
