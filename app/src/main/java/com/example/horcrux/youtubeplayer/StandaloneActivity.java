package com.example.horcrux.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.horcrux.youtubeplayer.R.layout.activity_standalone);

        Button btnPlayVideo = findViewById(com.example.horcrux.youtubeplayer.R.id.btnPlayVideo);
        Button btnPlaylist = findViewById(com.example.horcrux.youtubeplayer.R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()){
            case com.example.horcrux.youtubeplayer.R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;

            case com.example.horcrux.youtubeplayer.R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, false);
                break;

            default:
                // no code
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
