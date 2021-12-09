package com.example.lab_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayer = findViewById(R.id.videoPlayer);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.anime);

        videoPlayer.setVideoURI(myVideoUri);

        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_online) {
            Intent intent = new Intent();
            intent.setClass(this, OnlineVideoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_audio) {
            Intent intent = new Intent();
            intent.setClass(this, AudioActivity.class);
            startActivity(intent);
            return true;
        } else {
            return true;
        }
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