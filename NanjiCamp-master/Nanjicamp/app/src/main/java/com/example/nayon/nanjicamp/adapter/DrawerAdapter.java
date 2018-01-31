package com.example.nayon.nanjicamp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nayon.nanjicamp.LoginActivity;
import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.data.DrawerData;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.widget.NanumTextView;

import java.util.ArrayList;

/**
 * Created by nayong on 2017. 4. 17..
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    Context context;
    private ArrayList<DrawerData> mDrawerData = Manager.mDrawerData;
    FragmentManager fManager;
    FragmentTransaction fTrans;
    Fragment frag;

    public  DrawerAdapter(Context context){
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        if (viewType == Manager.NAVTYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_header, parent, false);
        } else if (viewType == Manager.NAVTYPE_MENU) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_menu, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_tail, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view, viewType);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DrawerData data = mDrawerData.get(position);

        if (data != null) {
            switch (getItemViewType(position)) {
                case Manager.NAVTYPE_HEADER:
                    holder.btnX.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.drawer.closeDrawers();
                        }
                    });
                    break;
                case Manager.NAVTYPE_MENU:
                    holder.imgMenu.setImageResource(data.getIconRes());
                    holder.txtMenu.setText(data.getTitle());
                    switch (data.getFragPos()){
                        case Manager.FRAGMENT_NAVI_TICKET:
                            holder.layMenu.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    MainActivity.drawer.closeDrawers();
                                    ((MainActivity)context).transFragment(Manager.FRAGMENT_NAVI_TICKET);
                                }
                            });
                            break;
                        case Manager.FRAGMENT_NAVI_STAMP:
                            holder.layMenu.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    MainActivity.drawer.closeDrawers();
                                    ((MainActivity)context).transFragment(Manager.FRAGMENT_NAVI_STAMP);
                                }
                            });
                            break;
                        case Manager.FRAGMENT_NAVI_TREASURE:
                            holder.layMenu.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                MainActivity.drawer.closeDrawers();
                                ((MainActivity)context).transFragment(Manager.FRAGMENT_NAVI_TREASURE);
                            }
                        });
                            break;
                        case Manager.FRAGMENT_NAVI_NOTICE:
                            break;
                        case Manager.FRAGMENT_NAVI_SETTING:
                            break;
                    }

                    break;
                case Manager.NAVTYPE_TAIL:
                    holder.btnLogout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((MainActivity)context).startLoginActivity();
                        }
                    });
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDrawerData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDrawerData.get(position).getViewType();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

//        TextView txtHeader;
//        TextView txtHeader2;
        ImageButton btnX;
        ImageView imgMenu;
        NanumTextView txtMenu;
        LinearLayout layMenu;
        Button btnLogout;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if(viewType == Manager.NAVTYPE_HEADER){
                btnX = (ImageButton) itemView.findViewById(R.id.btn_nav_x);
//                txtHeader = (TextView)itemView.findViewById(R.id.txt_nav_header);
//                txtHeader2 = (TextView)itemView.findViewById(R.id.txt_nav_header2);
            } else if(viewType == Manager.NAVTYPE_MENU){
                imgMenu = (ImageView) itemView.findViewById(R.id.img_nav_menu);
                txtMenu = (NanumTextView) itemView.findViewById(R.id.txt_nav_menu);
                layMenu = (LinearLayout) itemView.findViewById(R.id.item_nav_menu);
            } else{
                btnLogout = (Button) itemView.findViewById(R.id.btn_nav_tail);
            }
        }
    }

}


