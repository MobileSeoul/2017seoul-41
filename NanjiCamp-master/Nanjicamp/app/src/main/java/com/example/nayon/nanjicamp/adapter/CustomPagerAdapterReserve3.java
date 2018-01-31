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
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve3;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

import static com.example.nayon.nanjicamp.fragment.FragmentReserve3.FIRST_PAGE;
import static com.example.nayon.nanjicamp.fragment.FragmentReserve3.PAGES;

public class CustomPagerAdapterReserve3 extends FragmentPagerAdapter implements ViewPager.PageTransformer {
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    private Activity mContext;
    private FragmentManager mFragmentManager;
    private float mScale;

    public static SparseArray<CustomFragmentReserve3> registeredFragments = new SparseArray<CustomFragmentReserve3>();

    public CustomPagerAdapterReserve3(Activity context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mFragmentManager = fragmentManager;
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first mViewPager bigger than others
        if (position == FIRST_PAGE)
            mScale = BIG_SCALE;
        else
            mScale = SMALL_SCALE;

        return CustomFragmentReserve3.newInstance(mContext, position, mScale);
    }

    @Override
    public int getCount() {
        return PAGES;
    }

    @Override
    public void transformPage(View page, float position) {
        CustomLinearLayout myLinearLayout = (CustomLinearLayout) page.findViewById(R.id.item_root);
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
        CustomFragmentReserve3 fragment = (CustomFragmentReserve3) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public CustomFragmentReserve3 getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
