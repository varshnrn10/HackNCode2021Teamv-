package com.example.climatechange;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class seminar extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView1,youTubePlayerView2,youTubePlayerView3,youTubePlayerView4,youTubePlayerView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seminar);

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
                String videoId = "KeX7x5NtNFg";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "HK8LLWSIIm4";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        youTubePlayerView3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "2Jp1D1dzxj8";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        youTubePlayerView4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "ztWHqUFJRTs";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        youTubePlayerView5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "JMeEkaPw3m4";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }
}
