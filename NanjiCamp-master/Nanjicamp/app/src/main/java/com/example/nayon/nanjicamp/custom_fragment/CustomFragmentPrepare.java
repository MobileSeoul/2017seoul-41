package com.example.nayon.nanjicamp.custom_fragment;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.layout.MyVideoView;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomFragmentPrepare extends Fragment {

    int fragmentNum;

    public MyVideoView videoView;

    int[] video1s = {R.raw.video_prepare_2_3, R.raw.video_prepare_2_2, R.raw.video_prepare_2_1};
    int[] video2s = {R.raw.video_prepare_1_2, R.raw.video_prepare_1_1, R.raw.video_prepare_1_3};
    int[] video3s = {R.raw.video_prepare_3_3, R.raw.video_prepare_3_1, R.raw.video_prepare_3_2};

    Boolean[] icon1 = {false, true, true};
    Boolean[] icon2 = {false, true, false};
    Boolean[] icon3 = {false, false, true};

    String[] txt11s = {"침낭", "발포매트", "담요"};
    String[] txt12s = {"난지캠핑장에서 보다 더 포근한 캠핑을 하기", "난지캠핑장에서 포근한 캠핑을 하기 위해서는", "난지캠핑장에서 보다 더 따뜻한 캠핑을 하기"};
    String[] txt13s = {"위해서는 침낭이 필수입니다.", "발포매트가 필요합니다.", "위해서는 담요가 필요합니다."};

    String[] txt21s = {"물병과 종이컵", "그릴", "주전자"};
    String[] txt22s = {"난지캠핑장에 배치되어 있는 식수를 마시기", "난지캠핑장에서 바베큐를 하기 위해서는", "난지캠핑장에서 식수를 따뜻하게 데우기"};
    String[] txt23s = {"위해서는 물병과 종이컵이 필수입니다.", "그릴이 필수입니다.", "위해서는 주전자가 필요합니다."};

    String[] txt31s = {"비상약", "휴지", "랜턴"};
    String[] txt32s = {"캠핑을 즐기다 비상시에 사용가능한", "다용도로 사용가능한", "어두워진 밤에 주위를 밝혀주는"};
    String[] txt33s = {"비상약은 필수입니다.", "휴지는 캠핑에 필수입니다.", "랜턴은 캠핑에 필수입니다."};

    public static Fragment newInstance(Activity context, int position, float scale, int fragmentNum) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        bundle.putInt("fragmentNum", fragmentNum);
        return Fragment.instantiate(context, CustomFragmentPrepare.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        Log.e("dd","OnCreateView");

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_prepare, container, false);

        int position = this.getArguments().getInt("position");
        fragmentNum = this.getArguments().getInt("fragmentNum");

        videoView = (MyVideoView) linearLayout.findViewById(R.id.video_prepare);
        TextView textView1 = (TextView) linearLayout.findViewById(R.id.txt_prepare_1);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.txt_prepare_2);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.txt_prepare_3);
        ImageView icon = (ImageView) linearLayout.findViewById(R.id.icon_prepare_avail);
        int iconId = R.drawable.icon_prepare_avail;

        if (fragmentNum == Manager.FRAGMENT_PREPARE_1) {

            /*icon avail*/
            if (icon1[position]) {
                icon.setImageResource(iconId);
            }

            /*videoView*/
            //MediaController mc = new MediaController(this);
            Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video1s[position]);
            //videoIntro.setMediaController(mc);
            videoView.setSource(uri);
            //videoView.setSeekTo(true);
            if (position == 0) {
                //videoView.setSeekTo(true);
                videoView.setSeekTo(false);
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        videoView.setSeekTo(false);
//                        mp.setLooping(true);
//                    }
//                });
            }

            /*textView*/
            textView1.setText(txt11s[position]);
            textView2.setText(txt12s[position]);
            textView3.setText(txt13s[position]);
        } else if (fragmentNum == Manager.FRAGMENT_PREPARE_2) {

             /*icon avail*/
            if (icon2[position]) {
                icon.setImageResource(iconId);
            }

            /*videoView*/
            //MediaController mc = new MediaController(this);
            Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video2s[position]);
            //videoIntro.setMediaController(mc);
            videoView.setSource(uri);
            //videoView.setSeekTo(true);
            if (position == 0) {
                //videoView.setSeekTo(true);
                videoView.setSeekTo(false);
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        videoView.setSeekTo(false);
//                        mp.setLooping(true);
//                    }
//                });
            }

            /*textView*/
            textView1.setText(txt21s[position]);
            textView2.setText(txt22s[position]);
            textView3.setText(txt23s[position]);

//            /*icon avail*/
//            if (icon2[position]) {
//                icon.setImageResource(iconId);
//            }
//
//             /*videoView*/
//            //MediaController mc = new MediaController(this);
//            Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video2s[position]);
//            //videoIntro.setMediaController(mc);
//            videoView.setVideoURI(uri);
//            videoView.seekTo(1000);
//            if (position == 0) {
//                videoView.seekTo(0);
//                videoView.start();
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        videoView.start();
//                        mp.setLooping(true);
//                    }
//                });
//            }
//
//        /*textView*/
//            textView1.setText(txt21s[position]);
//            textView2.setText(txt22s[position]);
//            textView3.setText(txt23s[position]);
        } else {

            /*icon avail*/
            if (icon3[position]) {
                icon.setImageResource(iconId);
            }

            /*videoView*/
            //MediaController mc = new MediaController(this);
            Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + video3s[position]);
            //videoIntro.setMediaController(mc);
            videoView.setSource(uri);
            //videoView.setSeekTo(true);
            if (position == 0) {
                //videoView.setSeekTo(true);
                videoView.setSeekTo(false);
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        videoView.setSeekTo(false);
//                        mp.setLooping(true);
//                    }
//                });
            }

            /*textView*/
            textView1.setText(txt31s[position]);
            textView2.setText(txt32s[position]);
            textView3.setText(txt33s[position]);
        }

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.item_root_prepare);

        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;
    }

}
