package com.example.nayon.nanjicamp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.VideoView;

import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.layout.MyVideoView;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentAnswer extends Fragment {

    Uri uri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_answer, parentViewGroup, false);

        ImageButton btnNext = (ImageButton) rootView.findViewById(R.id.btn_answer_x);
        MyVideoView videoView = (MyVideoView) rootView.findViewById(R.id.video_answer);

        if(FragmentQuiz.answer==1) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_answer_o);
        }else{
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_answer_x);
        }

        videoView.setSource(uri);
        videoView.setStart();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).transFragment(Manager.FRAGMENT_TREASURE_4);
            }
        });

        return rootView;
    }

}