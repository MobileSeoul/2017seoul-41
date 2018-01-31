package com.example.nayon.nanjicamp.custom_fragment;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomFragmentReserve3 extends Fragment {

    String[] txt1s = {"랜턴", "담요", "그릴"};
    String[] txt2s = {"2000원", "3000원", "9000원"};
    String[] txt3s = {"건전지 별도구매(5,000원)", "포근한 푸른색 담요", "2~3인용"};
    int[] imgs = {R.drawable.img_reserve_3_1, R.drawable.img_reserve_3_2, R.drawable.img_reserve_3_3};

    public ImageView back;
    public ImageView imgChecked;
    public int checked = 0;
    final Handler handler = new Handler();

    public static Fragment newInstance(Activity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragmentReserve3.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        final LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_reserve_3, container, false);

        int position = this.getArguments().getInt("position");

        ImageView imgView = (ImageView) linearLayout.findViewById(R.id.img_reserve_3);
        imgView.setImageResource(imgs[position]);
        TextView textView1 = (TextView) linearLayout.findViewById(R.id.txt_reserve_3_1);
        textView1.setText(txt1s[position]);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.txt_reserve_3_2);
        textView2.setText(txt2s[position]);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.txt_reserve_3_3);
        textView3.setText(txt3s[position]);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.txt_reserve_3_4);
        if (position == 0) {
            textView4.setText("보증금 5,000원");
        }else{
            textView4.setVisibility(View.GONE);
        }

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.item_root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        LinearLayout lay = (LinearLayout) linearLayout.findViewById(R.id.lay_reserve_3);
        back = (ImageView) linearLayout.findViewById(R.id.backgroud_reserve_3_check);
        imgChecked = (ImageView) linearLayout.findViewById(R.id.video_reserve_3_checked);

        final GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imgChecked);

        // SurfaceHolder surfaceHolder = videoView.getHolder();

//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
////
//                videoView.setZOrderOnTop(false);
//                videoView.setBackgroundColor(Color.TRANSPARENT);
//
//                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//                    @Override
//                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                        SurfaceHolder placeholder = (SurfaceHolder) ((VideoView) linearLayout.findViewById(R.id.video_reserve_3_checked)).getHolder();
//                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
////                             video started; hide the placeholder.
//                            placeholder.setVisibility(View.GONE);
//                            return true;
//                        }
//                        return false;
//                    }
//                });
//            }
//        });

        back.setVisibility(View.INVISIBLE);
        imgChecked.setVisibility(View.INVISIBLE);

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked == 0) {
                    //videoView.start();
                    back.setVisibility(View.VISIBLE);
                    imgChecked.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load(R.drawable.img_reserve_3_checked).into(imageViewTarget);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgChecked.setImageResource(R.drawable.img_reserve_3_checked_last);
                        }
                    },1050);
                    checked++;
                } else {
                    back.setVisibility(View.INVISIBLE);
                    imgChecked.setVisibility(View.INVISIBLE);
                    checked--;
                }
            }
        });


        return linearLayout;
    }

}
