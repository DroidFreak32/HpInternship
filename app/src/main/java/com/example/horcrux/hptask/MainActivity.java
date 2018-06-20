package com.example.horcrux.hptask;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button[] videoButtons;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        path = "android.resource://" + getPackageName() + "/" + R.raw.test;
        videoView.setVideoURI(Uri.parse(path));
        videoButtons = new Button[3];
        videoButtons[0] = findViewById(R.id.button);
        videoButtons[1] = findViewById(R.id.button2);
        videoButtons[2] = findViewById(R.id.button3);

        videoButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
            }
        });

        videoButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
            }
        });

        videoButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.stopPlayback();
                videoView.setVideoURI(Uri.parse(path));
            }
        });

    }
}
