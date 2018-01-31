package com.example.nayon.nanjicamp.navi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.adapter.CustomPagerAdapterNaviTreasure;
import com.example.nayon.nanjicamp.data.Manager;

public class FragmentNaviTreasure extends Fragment {

    public CustomPagerAdapterNaviTreasure mAdapter;
    public ViewPager mViewPager;
    public LinearLayout indicator;
    private int dotCount;
    private ImageView[] dots;

    public final static int PAGES = 3;
    public final static int FIRST_PAGE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_navi_treasure,parentViewGroup,false);

        mViewPager = (ViewPager) rootView.findViewById(R.id.view_navi_treasure);
        indicator = (LinearLayout) rootView.findViewById(R.id.indicator_navi_treasure);

        mAdapter = new CustomPagerAdapterNaviTreasure(this.getActivity(), this.getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, mAdapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        mViewPager.setCurrentItem(FIRST_PAGE);

        // Necessary or the mViewPager will only have one extra page to show
        // make this at least however many pages you can see
        mViewPager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        mViewPager.setPageMargin(-(int)(Manager.pageMargin*1.4));

        dotCount = mAdapter.getCount();
        dots = new ImageView[dotCount];

        for(int i = 0; i < dotCount; i++){
            dots[i] = new ImageView(this.getActivity());
            dots[i].setImageResource(R.drawable.icon_indicator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Manager.indicatorSize, Manager.indicatorSize);
            params.setMargins(Manager.indicatorMargin,0,Manager.indicatorMargin,0);
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

        return rootView;
    }
}
