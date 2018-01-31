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

import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.adapter.CustomPagerAdapterTreasure;
import com.example.nayon.nanjicamp.data.Manager;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentTreasure1 extends Fragment {

    public CustomPagerAdapterTreasure mAdapter;
    public ViewPager mViewPager;
    public LinearLayout indicator;
    private int dotCount;
    private ImageView[] dots;
    ImageButton btnNext;

    public final static int PAGES = 3;
    public final static int FIRST_PAGE = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_treasure_1, parentViewGroup, false);


        mViewPager = (ViewPager) rootView.findViewById(R.id.view_treasure);
        indicator = (LinearLayout) rootView.findViewById(R.id.indicator_treasure);
        btnNext = (ImageButton) rootView.findViewById(R.id.btn_treasure_next);

        mAdapter = new CustomPagerAdapterTreasure(this.getActivity(), this.getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, mAdapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        mViewPager.setCurrentItem(FIRST_PAGE);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed

        dotCount = mAdapter.getCount();
        dots = new ImageView[dotCount];

        for(int i = 0; i < dotCount; i++){
            dots[i] = new ImageView(this.getActivity());
            dots[i].setImageResource(R.drawable.icon_indicator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Manager.indicatorSize, Manager.indicatorSize);
            params.setMargins(Manager.indicatorMargin, 0, Manager.indicatorMargin, 0);
            indicator.addView(dots[i], params);
        }
        dots[0].setImageResource(R.drawable.icon_indicator_selected);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i<dotCount; i++){
                    dots[i].setImageResource(R.drawable.icon_indicator);
                }
                dots[position].setImageResource(R.drawable.icon_indicator_selected);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_TREASURE_2);
            }
        });

        return rootView;
    }

}