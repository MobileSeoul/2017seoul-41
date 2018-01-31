package com.example.nayon.nanjicamp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.adapter.CustomPagerAdapterReserve3;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentPrepare;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve1;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve3;
import com.example.nayon.nanjicamp.data.Manager;

/**
 * Created by nayon on 2017-04-11.
 */
public class FragmentReserve3 extends Fragment {

    public CustomPagerAdapterReserve3 mAdapter;
    public ViewPager mViewPager;
    public LinearLayout indicator;
    private int dotCount;
    private ImageView[] dots;

    private int mCurrentPosition;
    CustomFragmentReserve3 fragment;
    CustomFragmentReserve3 fragmentBefore;
    CustomFragmentReserve3 fragmentAfter;

    public final static int PAGES = 3;
    public final static int FIRST_PAGE = 0;

    public static SparseArray<CustomFragmentReserve3> registeredFragments3 = new SparseArray<CustomFragmentReserve3>();


    public FragmentReserve3(){
        super();
    }

    public FragmentReserve3(SparseArray<CustomFragmentReserve3> registeredFragments3){
        super();
        this.registeredFragments3 = registeredFragments3;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reserve_3,parentViewGroup,false);

        Button btnNext = (Button)rootView.findViewById(R.id.btn_reserve_next_3);
        mViewPager = (ViewPager) rootView.findViewById(R.id.view_reserve_3);
        indicator = (LinearLayout) rootView.findViewById(R.id.indicator_reserve_3);

        mAdapter = new CustomPagerAdapterReserve3(this.getActivity(), this.getChildFragmentManager());
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
        mViewPager.setPageMargin(-Manager.pageMargin);

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

                 /*get seleceted fragment*/
                mCurrentPosition = position;
                fragment = mAdapter.getRegisteredFragment(mCurrentPosition);

                fragment.checked = 0;
                fragment.back.setVisibility(View.INVISIBLE);
                fragment.imgChecked.setVisibility(View.INVISIBLE);

                fragmentAfter = mAdapter.getRegisteredFragment(mCurrentPosition-1);
                fragmentBefore = mAdapter.getRegisteredFragment(mCurrentPosition+1);

                if(fragmentAfter!=null){
                    fragmentAfter.back.setVisibility(View.INVISIBLE);
                    fragmentAfter.imgChecked.setVisibility(View.INVISIBLE);
                }
                if(fragmentBefore!=null){
                    fragmentBefore.back.setVisibility(View.INVISIBLE);
                    fragmentBefore.imgChecked.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //reserve fragment로 이동
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).transFragment(Manager.FRAGMENT_RESERVE_4);
            }
        });

        MainActivity.registeredFragments3 = registeredFragments3;

        return rootView;
    }
}
