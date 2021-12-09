package com.example.lab_10;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class OnlineVideoActivity extends AppCompatActivity {
    private VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_video);

        videoPlayer = findViewById(R.id.videoPlayerOnline);
        videoPlayer.setVideoPath("https://129vod-adaptive.akamaized.net/exp=1639073326~acl=/6314467b-3742-46d8-9883-b8c18086ce88/*~hmac=5dde2547a1a8752207ad71859512c8fd96d9c800d7180988cd3f72755e5abba5/6314467b-3742-46d8-9883-b8c18086ce88/parcel/video/fb5c8449.mp4");

        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
    }

    public void play(View view){
        videoPlayer.start();
    }

    public void pause(View view){
        videoPlayer.pause();
    }

    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
}