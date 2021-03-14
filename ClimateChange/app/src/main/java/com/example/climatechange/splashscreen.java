package com.example.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.climatechange.credentials.login;

public class splashscreen extends AppCompatActivity {

   TextView t1;
    LottieAnimationView lottie;
    private static int SPLASH_SCREEN =5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        t1=findViewById(R.id.txt);
        t1.animate().translationX(2000).setDuration(1100).setStartDelay(4000);
        lottie=findViewById(R.id.lottie);
        lottie.animate().translationY(1600).setDuration(1100).setStartDelay(4000);

        t1.setShadowLayer(40, 0, 0, Color.rgb(49  ,217, 187));

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splashscreen.this, login.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);

    }
}