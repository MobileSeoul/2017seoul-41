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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.layout.MyVideoView;
import com.example.nayon.nanjicamp.widget.NanumBoldTextView;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentTreasure2 extends Fragment {

    int position = 0;

    VideoView video1, video2;
    ImageView img1, img2;
    NanumBoldTextView txtDetail1, txtDetail2, txt1, txt2;
    ImageButton btnLeft, btnRight, btnStart;

    int[] video1s = {R.raw.video_treasure_4_1, R.raw.video_treasure_3_1, R.raw.video_treasure_1_1, R.raw.video_treasure_2_1};
    int[] video2s = {R.raw.video_treasure_4_2, R.raw.video_treasure_3_2, R.raw.video_treasure_1_2, R.raw.video_treasure_2_2};

    int[] img1s = {R.drawable.icon_treasure_4_1, R.drawable.icon_treasure_3_1, R.drawable.icon_treasure_1_1, R.drawable.icon_treasure_2_1};
    int[] img2s = {R.drawable.icon_treasure_4_2, R.drawable.icon_treasure_3_2, R.drawable.icon_treasure_1_2, R.drawable.icon_treasure_2_2};
    int[] imgStarts = {R.drawable.btn_treasure_4, R.drawable.btn_treasure_3,R.drawable.btn_treasure_1,R.drawable.btn_treasure_2};

    String[] txtDetail1s = {"난지한강공원에 서식하는 호사비오리의 형태로","난지한강공원에 방문했을 때 안내센터에서","난지한강공원에 서식하는 누룩뱀의 형태로", "난지한강공원에 서식하는 맹꽁이의 형태로" };
    String[] txtDetail2s = {"한적한 산책로를 즐길 수 있는 오리 코스", "가장 먼저 보이는 멧토끼 코스","생태섬을 따라 산책할 수 있는 누룩뱀 코스", "자전거 타기와 산책을 한 번에 즐길 수 있는 맹꽁이 코스"};

    String[] txt1s = {"50", "40", "40", "60"};
    String[] txt2s = { "1.9", "1.5", "1.3","2"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_treasure, parentViewGroup, false);

        video1 = (VideoView) rootView.findViewById(R.id.video_treasure_1);
        video2 = (VideoView) rootView.findViewById(R.id.video_treasure_2);
        img1 = (ImageView) rootView.findViewById(R.id.icon_treasure_1);
        img2 = (ImageView) rootView.findViewById(R.id.icon_treasure_2);
        txtDetail1 = (NanumBoldTextView) rootView.findViewById(R.id.txt_treasure_detail_1);
        txtDetail2 = (NanumBoldTextView) rootView.findViewById(R.id.txt_treasure_detail_2);
        txt1 = (NanumBoldTextView) rootView.findViewById(R.id.txt_treasure_time);
        txt2 = (NanumBoldTextView) rootView.findViewById(R.id.txt_treasure_distance);
        btnLeft = (ImageButton) rootView.findViewById(R.id.btn_treasure_left);
        btnRight = (ImageButton) rootView.findViewById(R.id.btn_treasure_right);
        btnStart = (ImageButton) rootView.findViewById(R.id.btn_treasure_start);

        setData(position);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0){
                    setData(--position);
                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<3){
                    setData(++position);
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.animal = position;
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_3_1);
            }
        });

        return rootView;
    }

    public void setData(int position) {

        setVideo(position);
        setTxt(position);
        setImg(position);

    }

    public void setVideo(int position) {
        Uri uri1 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video1s[position]);
        video1.setVideoURI(uri1);
        video1.setBackgroundColor(Color.WHITE);
        //video1.start();
        //proba
        video1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video1.start();
                video1.setBackgroundColor(Color.TRANSPARENT);
                mp.setLooping(true);
            }
        });

        Uri uri2 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video2s[position]);
        video2.setVideoURI(uri2);
        video2.setBackgroundColor(Color.WHITE);
        //video2.start();
        //proba
        video2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video2.start();
                video2.setBackgroundColor(Color.TRANSPARENT);
                mp.setLooping(true);
            }
        });
    }

    public void setTxt(int position) {
        txtDetail1.setText(txtDetail1s[position]);
        txtDetail2.setText(txtDetail2s[position]);
        txt1.setText(txt1s[position]);
        txt2.setText(txt2s[position]);
    }

    public void setImg(int position) {
        img1.setImageResource(img1s[position]);
        img2.setImageResource(img2s[position]);
        btnStart.setImageResource(imgStarts[position]);
    }


}