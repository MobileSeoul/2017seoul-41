package com.example.nayon.nanjicamp.adapter;

/**
 * Created by nayon on 2017-05-03.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentNaviTreasure;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentTreasure;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomPagerAdapterTreasure extends FragmentPagerAdapter implements ViewPager.PageTransformer {

    private Activity mContext;
    private FragmentManager mFragmentManager;

    public CustomPagerAdapterTreasure(Activity context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mFragmentManager = fragmentManager;
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return CustomFragmentTreasure.newInstance(mContext, position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void transformPage(View page, float position) {
        //CustomLinearLayout myLinearLayout = (CustomLinearLayout) page.findViewById(R.id.item_root_navi_treasure);
    }
}
