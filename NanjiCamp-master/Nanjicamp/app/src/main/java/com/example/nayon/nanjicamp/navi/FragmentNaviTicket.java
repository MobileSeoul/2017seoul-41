package com.example.nayon.nanjicamp.navi;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.layout.MyVideoView;

public class FragmentNaviTicket extends Fragment {

    MyVideoView videoTicket;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_navi_ticket,parentViewGroup,false);
        videoTicket = (MyVideoView) rootView.findViewById(R.id.video_ticket);

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_ticket);

        videoTicket.setSource(uri);
        videoTicket.setLooping(false);

        return rootView;
    }
}
