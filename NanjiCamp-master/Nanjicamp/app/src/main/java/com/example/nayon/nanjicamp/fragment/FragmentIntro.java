package com.example.nayon.nanjicamp.fragment;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.layout.MyVideoView;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentIntro extends Fragment {

    public static MyVideoView videoIntro;
    ImageView btnTicket;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_intro,parentViewGroup,false);

        videoIntro = (MyVideoView) rootView.findViewById(R.id.video_intro);

        //MediaController mc = new MediaController(this);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_intro);

        //videoIntro.setMediaController(mc);
        videoIntro.setSource(uri);
        //videoIntro.setBackgroundColor(Color.WHITE);
        //videoIntro.setZOrderOnTop(true); //hide black screen before video started
        videoIntro.setLooping(true);
//        if(videoIntro.isPlaying()){
//            videoIntro.setBackgroundColor(Color.TRANSPARENT);
//        }


//        //proba
//        videoIntro.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                videoIntro.start();
//                videoIntro.setBackgroundColor(Color.TRANSPARENT);
//                mp.setLooping(true);
//            }
//        });

        return rootView;
    }


}