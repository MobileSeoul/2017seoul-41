package com.example.nayon.nanjicamp.adapter;

/**
 * Created by nayon on 2017-05-03.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentPrepare;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

import static com.example.nayon.nanjicamp.fragment.FragmentPrepare1.FIRST_PAGE;
import static com.example.nayon.nanjicamp.fragment.FragmentPrepare1.PAGES;

public class CustomPagerAdapterPrepare extends FragmentPagerAdapter implements ViewPager.PageTransformer {

    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;


    private Activity mContext;
    private FragmentManager mFragmentManager;
    private int fragmentNum;
    private float mScale;
    SparseArray<CustomFragmentPrepare> registeredFragments = new SparseArray<CustomFragmentPrepare>();

    public CustomPagerAdapterPrepare(Activity context, FragmentManager fragmentManager, int fragmentNum) {
        super(fragmentManager);
        this.mFragmentManager = fragmentManager;
        this.mContext = context;
        this.fragmentNum = fragmentNum;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first mViewPager bigger than others
        if (position == FIRST_PAGE)
            mScale = BIG_SCALE;
        else
            mScale = SMALL_SCALE;
        return CustomFragmentPrepare.newInstance(mContext, position, mScale, fragmentNum);
    }

    @Override
    public int getCount() {
        return PAGES;
    }

    @Override
    public void transformPage(View page, float position) {
        CustomLinearLayout myLinearLayout = (CustomLinearLayout) page.findViewById(R.id.item_root_prepare);
        float scale = BIG_SCALE;
        if (position > 0) {
            scale = scale - position * DIFF_SCALE;
        } else {
            scale = scale + position * DIFF_SCALE;
        }
        if (scale < 0) scale = 0;
        myLinearLayout.setScaleBoth(scale);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        CustomFragmentPrepare fragment = (CustomFragmentPrepare) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public CustomFragmentPrepare getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

}
