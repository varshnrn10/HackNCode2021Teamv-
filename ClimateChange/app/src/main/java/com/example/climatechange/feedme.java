package com.example.climatechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class feedme extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView1,youTubePlayerView2,youTubePlayerView3,youTubePlayerView4,youTubePlayerView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedme);

        youTubePlayerView1 = findViewById(R.id.youtube_player_view1);
        youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
        youTubePlayerView3 = findViewById(R.id.youtube_player_view3);
        youTubePlayerView4 = findViewById(R.id.youtube_player_view4);
        youTubePlayerView5 = findViewById(R.id.youtube_player_view5);
        getLifecycle().addObserver(youTubePlayerView1);
        getLifecycle().addObserver(youTubePlayerView2);
        getLifecycle().addObserver(youTubePlayerView3);
        getLifecycle().addObserver(youTubePlayerView4);
        getLifecycle().addObserver(youTubePlayerView5);

        youTubePlayerView1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "MrOMlJbH_NA";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "lYsmauK8Oko";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        youTubePlayerView3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "MBkYD2HLy34";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        youTubePlayerView4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "LqM3MH0cswY";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        youTubePlayerView5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "gxHzkeT9O24";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
}