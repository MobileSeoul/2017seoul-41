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
public class FragmentAR2 extends Fragment {

    public static MyVideoView videoView2;
    ImageButton btnGps;
    ImageView btnSwitch;
    LinearLayout layTop;
    ImageView imgAnimal;
    Handler handler, handler2, handler3, handler4;

    int gpsClicked = 0, switchClicked = 0, switchSource = 0;
    int position = 0;

    int[] imgs = {R.drawable.img_ar_animal_1, R.drawable.img_ar_animal_2,R.drawable.img_ar_animal_3,R.drawable.img_ar_animal_4 };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ar_2, parentViewGroup, false);

        videoView2 = (MyVideoView) rootView.findViewById(R.id.video_ar);
        btnGps = (ImageButton) rootView.findViewById(R.id.btn_ar_gps);
        btnSwitch = (ImageView) rootView.findViewById(R.id.btn_ar_switch);
        layTop = (LinearLayout) rootView.findViewById(R.id.lay_ar_top);
        imgAnimal = (ImageView) rootView.findViewById(R.id.img_ar_animal);

        position = MainActivity.animal;

        if(MainActivity.whatVideo % 2 == 0) {
            MainActivity.whatVideo++;
            Uri uri2 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_ar_on);
            videoView2.setSource(uri2);
        }else{
            MainActivity.whatVideo++;
            Uri uri2 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_ar_on_2);
            videoView2.setSource(uri2);
        }
        moveAnimal();
        videoView2.setStart();

        final GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imgAnimal);
        Glide.with(this).load(imgs[position]).into(imageViewTarget);

        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.gps = 1;
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_3_1);
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.gps = 0;
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_3_1);
            }
        });

        imgAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_4);
            }
        });

        return rootView;
    }

    public void moveAnimal() {

//        final TranslateAnimation moveLeft = new TranslateAnimation(800, -100, -50, -50);
//        moveLeft.setDuration(2000);
        final TranslateAnimation moveRight = new TranslateAnimation(-100, 0, -50, -50);
        moveRight.setDuration(2000);
        final TranslateAnimation moveDown = new TranslateAnimation(0, 0, -50, 0);
        moveDown.setDuration(6000);

//        handler = new Handler();
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                imgAnimal.setVisibility(View.VISIBLE);
////                imgAnimal.startAnimation(moveLeft);
//            }
//        }, 4500);

        handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgAnimal.setVisibility(View.VISIBLE);
                imgAnimal.startAnimation(moveRight);
            }
        }, 4500);

        handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgAnimal.startAnimation(moveDown);
            }
        }, 6500);

        handler4 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveAnimal();
            }
        }, 12500);

    }


}