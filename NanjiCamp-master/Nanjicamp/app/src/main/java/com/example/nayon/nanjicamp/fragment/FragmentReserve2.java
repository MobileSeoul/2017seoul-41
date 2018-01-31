package com.example.nayon.nanjicamp.fragment;


import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;

/**
 * Created by nayon on 2017-04-11.
 */
public class FragmentReserve2 extends Fragment {

    int num1, num2, num3, num4;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_reserve_2, parentViewGroup, false);

        num1 = 0;
        num2 = 0;
        num3 = 0;
        num4 = 0;

        img1 = (ImageView) rootView.findViewById(R.id.img_reserve_2_1);
        img2 = (ImageView) rootView.findViewById(R.id.img_reserve_2_2);
        img3 = (ImageView) rootView.findViewById(R.id.img_reserve_2_3);
        img4 = (ImageView) rootView.findViewById(R.id.img_reserve_2_4);
        btnNext = (Button) rootView.findViewById(R.id.btn_reserve_next_2);

        Glide.with(this).load(R.drawable.img_reserve_2_1_1).into(img1);
        Glide.with(this).load(R.drawable.img_reserve_2_2_1).into(img2);
        Glide.with(this).load(R.drawable.img_reserve_2_3_1).into(img3);
        Glide.with(this).load(R.drawable.img_reserve_2_4_1).into(img4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1++;
                if (num1 % 3 == 1) {
                    img1.setImageResource(R.drawable.img_reserve_2_1_2);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_1_2).into(img1);
                } else if (num1 % 3 == 2){
                    img1.setImageResource(R.drawable.img_reserve_2_1_3);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_1_3).into(img1);
                }else{
                    img1.setImageResource(R.drawable.img_reserve_2_1_2);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_1_1).into(img1);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2++;
                if (num2 % 3 == 1) {
                    img2.setImageResource(R.drawable.img_reserve_2_2_2);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_2_2).into(img2);
                } else if (num2 % 3 == 2){
                    img2.setImageResource(R.drawable.img_reserve_2_2_3);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_2_3).into(img2);
                }else{
                    img2.setImageResource(R.drawable.img_reserve_2_2_1);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_2_1).into(img2);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num3++;
                if (num3 % 3 == 1) {
                    img3.setImageResource(R.drawable.img_reserve_2_3_2);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_3_2).into(img3);
                } else if (num3 % 3 == 2){
                    img3.setImageResource(R.drawable.img_reserve_2_3_3);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_3_3).into(img3);
                }else{
                    img3.setImageResource(R.drawable.img_reserve_2_3_1);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_3_1).into(img3);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num4++;
                if (num4 % 3 == 1) {
                    img4.setImageResource(R.drawable.img_reserve_2_4_2);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_4_2).into(img4);
                } else if (num4 % 3 == 2){
                    img4.setImageResource(R.drawable.img_reserve_2_4_3);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_4_3).into(img4);
                }else{
                    img4.setImageResource(R.drawable.img_reserve_2_4_1);
//                    Glide.with(getActivity()).load(R.drawable.img_reserve_2_4_1).into(img4);
                }
            }
        });

        //reserve fragment로 이동
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_RESERVE_3);
            }
        });

        return rootView;
    }
}
