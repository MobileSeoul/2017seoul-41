package com.example.nayon.nanjicamp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nayon.nanjicamp.R;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentReserve4 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reserve_4,parentViewGroup,false);

        ImageButton btnNext = (ImageButton) rootView.findViewById(R.id.btn_reserve_4_next);

        ImageView imgReserve1 = (ImageView)rootView.findViewById(R.id.img_reserve_4_1);
        Glide.with(this).load(R.drawable.img_reserve_4_1).into(imgReserve1);

        ImageView imgReserve2 = (ImageView)rootView.findViewById(R.id.img_reserve_4_2);
        Glide.with(this).load(R.drawable.img_reserve_4_2).into(imgReserve2);

        ImageView imgReserve3 = (ImageView)rootView.findViewById(R.id.img_reserve_4_3);
        Glide.with(this).load(R.drawable.img_reserve_4_3).into(imgReserve3);

        ImageView imgReserve4 = (ImageView)rootView.findViewById(R.id.img_reserve_4_4);
        Glide.with(this).load(R.drawable.img_reserve_4_4).into(imgReserve4);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    FragmentManager fm = getActivity().getSupportFragmentManager();
                DialogFragmentReserve4 dialogFragment = new DialogFragmentReserve4();
                dialogFragment.setTargetFragment(FragmentReserve4.this, 0);
                dialogFragment.show(getFragmentManager(), "DialogFragmentReserve4");
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_reserve_4, null);
//                builder.setView(view);
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();

            }
        });

        return rootView;
    }


}