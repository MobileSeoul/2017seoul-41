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
import android.view.animation.AnimationSet;
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
public class FragmentQuiz extends Fragment {

    static int answer = -1;
    int p = 25;
    int position = 0;
    int[] imgs = {R.drawable.img_quiz_animal_1, R.drawable.img_quiz_animal_2, R.drawable.img_quiz_animal_3, R.drawable.img_quiz_animal_4};
    String[] colors = {"#FFF5BC1A","#FF8E9F34", "#FFEE8117", "#FF559B81"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_quiz, parentViewGroup, false);

        ImageView imgAnimal = (ImageView) rootView.findViewById(R.id.img_quiz_animal);
        LinearLayout layBack = (LinearLayout) rootView.findViewById(R.id.back_quiz);
        ImageButton btnNext = (ImageButton) rootView.findViewById(R.id.btn_quiz_next);
        final ImageButton btnO = (ImageButton) rootView.findViewById(R.id.btn_quiz_o);
        final ImageButton btnX = (ImageButton) rootView.findViewById(R.id.btn_quiz_x);

        position = MainActivity.animal;

        imgAnimal.setImageResource(imgs[position]);
        layBack.setBackgroundColor(Color.parseColor(colors[position]));

        btnO.setPadding(p, p, p, p);
        btnX.setPadding(p, p, p, p);

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == 1) {
                    answer = -1;
                    btnO.setPadding(p, p, p, p);
                    btnO.setImageResource(R.drawable.btn_quiz_o);
                    return;
                }
                answer = 1;
                btnX.setPadding(p, p, p, p);
                btnO.setPadding(0, 0, 0, 0);
                btnO.setImageResource(R.drawable.btn_quiz_o_clicked);
                btnX.setImageResource(R.drawable.btn_quiz_x);
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == 0) {
                    answer = -1;
                    btnX.setPadding(p, p, p, p);
                    btnX.setImageResource(R.drawable.btn_quiz_x);
                    return;
                }
                answer = 0;
                btnO.setPadding(p, p, p, p);
                btnX.setPadding(0, 0, 0, 0);
                btnX.setImageResource(R.drawable.btn_quiz_x_clicked);
                btnO.setImageResource(R.drawable.btn_quiz_o);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_5);
            }
        });

        return rootView;
    }

}