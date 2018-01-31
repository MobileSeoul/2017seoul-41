package com.example.nayon.nanjicamp.navi;

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

import com.example.nayon.nanjicamp.R;

/**
 * Created by nayon on 2017-04-23.
 */
public class FragmentNaviStamp extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_navi_stamp, parentViewGroup, false);
        final VideoView videoView = (VideoView)rootView.findViewById(R.id.video_navi_stamp_gauge);

        //MediaController mc = new MediaController(this);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_stamp_gauge);

        //videoIntro.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.setBackgroundColor(Color.WHITE);
//        videoView.start();
        //proba
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
                videoView.setBackgroundColor(Color.TRANSPARENT);
                mp.setLooping(true);
            }
        });

        //Glide.with(this).load(R.drawable.img_navi_stamp).into(imgStamp);
//        TextView txtStamp1 = (TextView)rootView.findViewById(R.id.txt_nav_stamp_1) ;
//
//        txtStamp1.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/NanumGothic.ttf.mp3"));
//
//        TextView txtStamp2 = (TextView)rootView.findViewById(R.id.txt_nav_stamp_2) ;
//        txtStamp1.setTypeface(Typeface.createFromAsset(rootView.getContext().getAssets(), "fonts/NanumGothicBold.ttf.mp3"));
//
//        TextView txtStamp3 = (TextView)rootView.findViewById(R.id.txt_nav_stamp_3) ;
//        txtStamp1.setTypeface(Typeface.createFromAsset(rootView.getContext().getAssets(), "fonts/NanumGothicBold.ttf.mp3"));
//
//        TextView txtStamp4 = (TextView)rootView.findViewById(R.id.txt_nav_stamp_4) ;
//        txtStamp1.setTypeface(Typeface.createFromAsset(rootView.getContext().getAssets(), "fonts/NanumGothicBold.ttf.mp3"));
//
//        TextView txtStamp5 = (TextView)rootView.findViewById(R.id.txt_nav_stamp_5) ;
//        txtStamp1.setTypeface(Typeface.createFromAsset(rootView.getContext().getAssets(), "fonts/NanumGothicBold.ttf.mp3"));

        return rootView;
    }
}
