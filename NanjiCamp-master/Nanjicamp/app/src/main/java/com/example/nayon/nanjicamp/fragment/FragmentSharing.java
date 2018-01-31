package com.example.nayon.nanjicamp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.adapter.CustomPagerAdapterShare;
import com.example.nayon.nanjicamp.data.Manager;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentSharing extends Fragment {

    static View rootView;
    public CustomPagerAdapterShare mAdapter;
    public ViewPager mViewPager;
    public static TextView backClicked;
    public static LinearLayout layClicked;
    public static ImageButton btnSave;
    public static ImageView imgClicked;
    public static TextView txtClicked;
    ImageButton btnCardX;

    public static int cardClicked = 0;

    public final static int PAGES = 3;
    public final static int FIRST_PAGE = 0;

    static int[] imgs = {R.drawable.img_sharing_item1, R.drawable.img_sharing_item2, R.drawable.img_sharing_item3};
    static String[] txts = {"부탄가스", "종이컵", "나무젓가락"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_sharing, parentViewGroup, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.view_sharing);
        backClicked = (TextView) rootView.findViewById(R.id.background_sharing_clicked);
        layClicked = (LinearLayout) rootView.findViewById(R.id.lay_sharing_clicked);
        imgClicked = (ImageView) rootView.findViewById(R.id.img_sharing_clicked);
        txtClicked = (TextView) rootView.findViewById(R.id.txt_sharing_clicked);
        btnSave = (ImageButton) rootView.findViewById(R.id.btn_share_clicked_save);
        btnCardX = (ImageButton) rootView.findViewById(R.id.btn_share_clicked_x);

        mAdapter = new CustomPagerAdapterShare(this.getActivity(), this.getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, mAdapter);

        mViewPager.setCurrentItem(FIRST_PAGE);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(-(int)(Manager.pageMargin*1.2));

        layClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeVisibility();
            }
        });

        backClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeVisibility();
            }
        });


        btnCardX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeVisibility();
            }
        });


        return rootView;
    }

    public static void setVisibility(int position) {
        imgClicked.setImageResource(imgs[position]);
        txtClicked.setText(txts[position]);
        backClicked.setVisibility(View.VISIBLE);
        layClicked.setVisibility(View.VISIBLE);
    }

    public static void removeVisibility() {
        if(cardClicked > 0) cardClicked = 0;
        backClicked.setVisibility(View.INVISIBLE);
        layClicked.setVisibility(View.INVISIBLE);
    }




}