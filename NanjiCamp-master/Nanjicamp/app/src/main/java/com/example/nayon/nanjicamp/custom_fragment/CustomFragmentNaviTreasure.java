package com.example.nayon.nanjicamp.custom_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomFragmentNaviTreasure extends Fragment {

    String[] txt1s = {"맑은 난지수","맑은 난지 음료","난지 쓰레기"};
    String[] txt2s = {"생수","음료","쓰레기 봉투"};
    int[] imgs = {R.drawable.img_navi_treasure_1, R.drawable.img_navi_treasure_2, R.drawable.img_navi_treasure_3};

    public static Fragment newInstance(Activity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragmentNaviTreasure.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_navi_treasure, container, false);

        int position = this.getArguments().getInt("position");

        ImageView imgView = (ImageView) linearLayout.findViewById(R.id.img__navi_treasure);
        imgView.setImageResource(imgs[position]);
        TextView textView1 = (TextView) linearLayout.findViewById(R.id.txt_navi_treasure_1);
        textView1.setText(txt1s[position]);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.txt_navi_treasure_2);
        textView2.setText(txt2s[position]);

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.item_root_navi_treasure);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;
    }
}
