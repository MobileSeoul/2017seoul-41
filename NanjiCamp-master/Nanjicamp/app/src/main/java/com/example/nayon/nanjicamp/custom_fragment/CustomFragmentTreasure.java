package com.example.nayon.nanjicamp.custom_fragment;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.layout.MyVideoView;
import com.example.nayon.nanjicamp.widget.CustomLinearLayout;

public class CustomFragmentTreasure extends Fragment {

    String[] txts = {"1. 마음에 드는 동물 코스를 골라보세요 !","2. AR영상 속 동물을 찾아보세요 !","3. 퀴즈를 풀고 보물을 획득하세요 !"};
    int[] videos = {R.raw.video_treasure_1, R.raw.video_treasure_2, R.raw.video_treasure_3};

    public static Fragment newInstance(Activity context, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        return Fragment.instantiate(context, CustomFragmentTreasure.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item_treasure, container, false);

        int position = this.getArguments().getInt("position");

        final MyVideoView videoView = (MyVideoView) linearLayout.findViewById(R.id.video_treasure);

        /*videoView*/
        //MediaController mc = new MediaController(this);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + videos[position]);
        //videoIntro.setMediaController(mc);
        videoView.setSource(uri);

        TextView textView = (TextView) linearLayout.findViewById(R.id.txt_treasure);
        textView.setText(txts[position]);

        return linearLayout;
    }
}
