package com.example.nayon.nanjicamp.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.Manager;

/**
 * Created by nayong on 2017. 5. 27..
 */

public class DialogFragmentReserve4 extends DialogFragment{

    public DialogFragmentReserve4 (){}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_reserve_4, parentViewGroup, false);
        builder.setView(rootView);

        final ImageView imgView = (ImageView)rootView.findViewById(R.id.dialog_reserve_4);

        // remove dialog title
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        // remove dialog background
        getDialog().getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imgView);
        Glide.with(this).load(R.drawable.img_reserve_4_success).into(imageViewTarget);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgView.setImageResource(R.drawable.img_reserve_4_end);
            }
        }, 2500);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).transFragment(Manager.FRAGMENT_NAVI_TICKET);
                getDialog().dismiss();
            }
        }, 3000);

        return rootView;
    }

}
