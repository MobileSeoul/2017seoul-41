package com.example.nayon.nanjicamp.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.layout.MyVideoView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentAR extends Fragment {

    ImageView imgGps;
    public static MyVideoView videoView;
    ImageButton btnGps;
    ImageView btnSwitch;

    int gps = 0;
    int gpsClicked = 0, switchClicked = 0, switchSource = 0;
    int position = 0;

    PhotoViewAttacher photoViewAttacher;
    //AnimationSet animationSet;

    public FragmentAR(int isGps){
        gps = isGps;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ar, parentViewGroup, false);

        imgGps = (ImageView) rootView.findViewById(R.id.img_ar_map);
        videoView = (MyVideoView) rootView.findViewById(R.id.video_ar_gps);
        btnGps = (ImageButton) rootView.findViewById(R.id.btn_ar_gps);
        btnSwitch = (ImageView) rootView.findViewById(R.id.btn_ar_switch);

        photoViewAttacher = new PhotoViewAttacher(imgGps);
        photoViewAttacher.setScaleType(ImageView.ScaleType.CENTER_CROP);
        photoViewAttacher.getImageView().setBackgroundColor(Color.WHITE);
        photoViewAttacher.update();

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_ar_gps);
        videoView.setSource(uri);
        if (gps % 2 == 1){
            MainActivity.gps = 0;
            gpsClicked++;
            btnGps.performClick();
        }

        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpsClicked++;
                if (gpsClicked % 2 == 1) {
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setStart();
                } else {
                    videoView.setVisibility(View.INVISIBLE);
                    videoView.setStop();
                }
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_3_2);
            }
        });

        return rootView;
    }

}