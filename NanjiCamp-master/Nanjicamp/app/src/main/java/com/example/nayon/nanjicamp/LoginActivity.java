package com.example.nayon.nanjicamp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.data.Manager;

public class LoginActivity extends AppCompatActivity {

    VideoView videoView;
    LinearLayout layLogin;
    ImageButton btnLogin;
    AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_backgroud);

        videoView = (VideoView) findViewById(R.id.video_login);
        layLogin = (LinearLayout) findViewById(R.id.lay_login_login);
        btnLogin = (ImageButton) findViewById(R.id.btn_login);

        Manager.setDisplaySize(this);

        /* for videoView */
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_login);

        //videoIntro.setMediaController(mc);
        videoView.setVideoURI(uri);
        //videoView.setZOrderOnTop(true); //hide black screen before video started

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
            }
        });

        /* for layout animation */
        animationSet = new AnimationSet(true);

        final AlphaAnimation fadein = new AlphaAnimation(0.0f, 1.0f);
        fadein.setDuration(880);
        fadein.setRepeatCount(0);
        animationSet.addAnimation(fadein);

        TranslateAnimation move = new TranslateAnimation(0, 0, 180, 0);
        move.setDuration(880);
        animationSet.addAnimation(move);

        Handler handler = new Handler();

        layLogin.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layLogin.bringToFront();
                layLogin.setVisibility(View.VISIBLE);
                layLogin.setAnimation(animationSet);
            }
        }, 2850);


        /* for button */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        return;
    }

}
