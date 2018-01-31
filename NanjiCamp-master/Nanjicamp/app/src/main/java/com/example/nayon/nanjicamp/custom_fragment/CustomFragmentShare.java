package com.example.nayon.nanjicamp.custom_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.fragment.FragmentSharing;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomFragmentShare extends Fragment {

    String[] txt1s = {"jisso","iiihuiii","harrrim"};
    String[] txt2s = {"부탄가스", "종이컵", "나무젓가락"};
    String[] txt3s = {"어제 캠핑 후 남은 부탄가스 공유합니다.", "어제 캠핑 후 남은 종이컵 공유합니다 ~ ", "어제 바베큐 후에 남은 나무젓가락"};
    String[] txt4s = {"필요하신 분 가져가세요.", "필요하신 분 가져가세용 !!", "공유합니다 !"};
    String[] txt5s = {"2개 있습니다.", "3개 남아있습니다 ~ ", "총 20개로 넉넉해요 ~ "};

    int[] img1s = {R.drawable.icon_sharing_face_2, R.drawable.icon_sharing_face_3, R.drawable.icon_sharing_face_4};
    int[] img2s = {R.drawable.img_sharing_item1, R.drawable.img_sharing_item2, R.drawable.img_sharing_item3};

    public static Fragment newInstance(Activity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragmentShare.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_sharing, container, false);

        final int position = this.getArguments().getInt("position");

        TextView textView1 = (TextView) linearLayout.findViewById(R.id.txt_sharing_1);
        textView1.setText(txt1s[position]);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.txt_sharing_2);
        textView2.setText(txt2s[position]);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.txt_sharing_3);
        textView3.setText(txt3s[position]);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.txt_sharing_4);
        textView4.setText(txt4s[position]);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.txt_sharing_5);
        textView5.setText(txt5s[position]);
        ImageView imgView1 = (ImageView) linearLayout.findViewById(R.id.img_sharing_1);
        imgView1.setImageResource(img1s[position]);
        ImageView imgView2 = (ImageView) linearLayout.findViewById(R.id.img_sharing_2);
        imgView2.setImageResource(img2s[position]);

        final LinearLayout layCard = (LinearLayout)  linearLayout.findViewById(R.id.lay_sharing_card);

        layCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSharing.cardClicked++;
                FragmentSharing.setVisibility(position);
            }
        });

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.item_root_sharing);

        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;
    }
}
