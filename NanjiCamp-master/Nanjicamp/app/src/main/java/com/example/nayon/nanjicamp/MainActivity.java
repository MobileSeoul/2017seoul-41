package com.example.nayon.nanjicamp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.nayon.nanjicamp.adapter.DrawerAdapter;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve1;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve3;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.fragment.FragmentAR;
import com.example.nayon.nanjicamp.fragment.FragmentAR2;
import com.example.nayon.nanjicamp.fragment.FragmentAnswer;
import com.example.nayon.nanjicamp.fragment.FragmentIntro;
import com.example.nayon.nanjicamp.fragment.FragmentPrepare1;
import com.example.nayon.nanjicamp.fragment.FragmentPrepare2;
import com.example.nayon.nanjicamp.fragment.FragmentPrepare3;
import com.example.nayon.nanjicamp.fragment.FragmentQuiz;
import com.example.nayon.nanjicamp.fragment.FragmentReserve1;
import com.example.nayon.nanjicamp.fragment.FragmentReserve2;
import com.example.nayon.nanjicamp.fragment.FragmentReserve3;
import com.example.nayon.nanjicamp.fragment.FragmentReserve4;
import com.example.nayon.nanjicamp.fragment.FragmentSharing;
import com.example.nayon.nanjicamp.fragment.FragmentTreasure1;
import com.example.nayon.nanjicamp.fragment.FragmentTreasure2;
import com.example.nayon.nanjicamp.navi.FragmentNaviStamp;
import com.example.nayon.nanjicamp.navi.FragmentNaviTicket;
import com.example.nayon.nanjicamp.navi.FragmentNaviTreasure;
import com.example.nayon.nanjicamp.widget.NanumBoldTextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "my nanji";
    FragmentManager fManager;
    FragmentTransaction fTrans;
    AlphaAnimation fadein1;
    Fragment frag;
    int position;

    NanumBoldTextView txtTopbar;
    ImageButton btnIntro;
    ImageButton btnReserve;
    ImageButton btnTreasure;
    ImageButton btnPrepare;
    ImageButton btnShare;
    ImageButton btnToggle;
    ImageButton btnCamera;
    ProgressBar progressBar;

    public RelativeLayout topBar;
    public LinearLayout bottomBar;
    public LinearLayout topBarMargin;
    public ImageView shadowTop;
    public ImageView shadowBottom;

    public static DrawerLayout drawer;
    public static int whatVideo = 0;
    public static int gps = 0;
    FrameLayout frameLayout;
    RecyclerView drawerMenu;

    public static SparseArray<CustomFragmentReserve1> registeredFragments = new SparseArray<CustomFragmentReserve1>();
    public static SparseArray<CustomFragmentReserve3> registeredFragments3 = new SparseArray<CustomFragmentReserve3>();
    public static int animal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_main);
        txtTopbar = (NanumBoldTextView) findViewById(R.id.txt_main_topbar);
        btnIntro = (ImageButton) findViewById(R.id.btn_main_intro);
        btnReserve = (ImageButton) findViewById(R.id.btn_main_reserve);
        btnTreasure = (ImageButton) findViewById(R.id.btn_main_treasure);
        btnPrepare = (ImageButton) findViewById(R.id.btn_main_prepare);
        btnShare = (ImageButton) findViewById(R.id.btn_main_share);
        btnToggle = (ImageButton) findViewById(R.id.nav_toggle);
        btnCamera = (ImageButton) findViewById(R.id.btn_camera);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        drawer = (DrawerLayout) findViewById(R.id.nav_drawer);
        drawerMenu = (RecyclerView) findViewById(R.id.drawer_menu);

        topBar = (RelativeLayout) findViewById(R.id.lay_main_topbar);
        topBarMargin = (LinearLayout) findViewById(R.id.lay_main_topbar_margin);
        bottomBar = (LinearLayout) findViewById(R.id.lay_main_bottombar);
        shadowTop = (ImageView) findViewById(R.id.img_main_shadow_top);
        shadowBottom = (ImageView) findViewById(R.id.img_main_shadow_bottom);

        btnIntro.setImageResource(R.drawable.icon_main_intro_clicked);
        progressBar.setVisibility(View.GONE);

        fadein1 = new AlphaAnimation(0.1f, 1.0f);
        fadein1.setDuration(500);
        fadein1.setRepeatCount(0);

        this.position = Manager.FRAGMENT_INTRO;
        frag = new FragmentIntro();

        fManager = getSupportFragmentManager();
        fTrans = fManager.beginTransaction().addToBackStack("Main");
        fTrans.add(R.id.fragment_main, frag);
        fTrans.commit();

        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transFragment(Manager.FRAGMENT_INTRO);
            }
        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler handler = new Handler();
                txtTopbar.setText("예약하기");

                frameLayout.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                setImg();
                btnReserve.setImageResource(R.drawable.icon_main_reserve_clicking);
                btnReserve.startAnimation(fadein1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnReserve.setImageResource(R.drawable.icon_main_reserve_clicked);
                    }
                }, 500);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        transFragment(Manager.FRAGMENT_RESERVE);
                    }
                }, 500);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        frameLayout.setVisibility(View.VISIBLE);
                    }
                }, 1500);


            }
        });

        btnTreasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transFragment(Manager.FRAGMENT_TREASURE);
            }
        });

        btnPrepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transFragment(Manager.FRAGMENT_PREPARE);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transFragment(Manager.FRAGMENT_SHARE);
            }
        });

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawers();

                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });

        drawerMenu.setLayoutManager(new LinearLayoutManager(this));
        drawerMenu.setAdapter(new DrawerAdapter(this));
    }

    public void startLoginActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void setImg() {
        btnIntro.setImageResource(R.drawable.icon_main_intro);
        btnReserve.setImageResource(R.drawable.icon_main_reserve);
        btnTreasure.setImageResource(R.drawable.icon_main_treasure);
        btnPrepare.setImageResource(R.drawable.icon_main_prepare);
        btnShare.setImageResource(R.drawable.icon_main_share);
    }

    public void transFragment(int position) {

        this.position = position;
        btnCamera.setVisibility(View.INVISIBLE);

        if (position != Manager.FRAGMENT_RESERVE) {
            setImg();
        }
        final Handler handler = new Handler();
        frag = null;

        switch (position) {
            case Manager.FRAGMENT_INTRO:

                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                txtTopbar.setText("난지소개");

                btnIntro.setImageResource(R.drawable.icon_main_intro_clicking);
                btnIntro.startAnimation(fadein1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnIntro.setImageResource(R.drawable.icon_main_intro_clicked);
                    }
                }, 500);

                frag = new FragmentIntro();
                break;

            case Manager.FRAGMENT_RESERVE:

                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                frag = new FragmentReserve1();
                break;

            case Manager.FRAGMENT_RESERVE_2:
                btnReserve.setImageResource(R.drawable.icon_main_reserve_clicked);
                frag = new FragmentReserve2();
                break;

            case Manager.FRAGMENT_RESERVE_3:
                btnReserve.setImageResource(R.drawable.icon_main_reserve_clicked);
                frag = new FragmentReserve3();
                break;

            case Manager.FRAGMENT_RESERVE_4:
                btnReserve.setImageResource(R.drawable.icon_main_reserve_clicked);
                frag = new FragmentReserve4();
                break;

            case Manager.FRAGMENT_PREPARE:

                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                txtTopbar.setText("준비물");
                btnPrepare.setImageResource(R.drawable.icon_main_prepare_clicking);
                btnPrepare.startAnimation(fadein1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnPrepare.setImageResource(R.drawable.icon_main_prepare_clicked);
                    }
                }, 500);
                frag = new FragmentPrepare1();
                break;

            case Manager.FRAGMENT_PREPARE_1:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                btnPrepare.setImageResource(R.drawable.icon_main_prepare_clicked);
                frag = new FragmentPrepare1();
                break;

            case Manager.FRAGMENT_PREPARE_2:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                btnPrepare.setImageResource(R.drawable.icon_main_prepare_clicked);
                frag = new FragmentPrepare2();
                break;

            case Manager.FRAGMENT_PREPARE_3:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                btnPrepare.setImageResource(R.drawable.icon_main_prepare_clicked);
                frag = new FragmentPrepare3();
                break;

            case Manager.FRAGMENT_TREASURE:

                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                txtTopbar.setText("보물찾기");
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicking);
                btnTreasure.startAnimation(fadein1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                    }
                }, 500);
                frag = new FragmentTreasure1();
                break;

            case Manager.FRAGMENT_TREASURE_2:
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                frag = new FragmentTreasure2();
                break;

            case Manager.FRAGMENT_TREASURE_3_1:
                showBars();
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                frag = new FragmentAR(gps);
                break;

            case Manager.FRAGMENT_TREASURE_3_2:
                hideBars();
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                frag = new FragmentAR2();
                break;

            case Manager.FRAGMENT_TREASURE_4:
                showBars();
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                frag = new FragmentQuiz();
                break;

            case Manager.FRAGMENT_TREASURE_5:
                hideBars();
                btnTreasure.setImageResource(R.drawable.icon_main_treasure_clicked);
                frag = new FragmentAnswer();
                break;

            case Manager.FRAGMENT_SHARE:

                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                txtTopbar.setText("쉐어링");
                btnCamera.setVisibility(View.VISIBLE);
                btnShare.setImageResource(R.drawable.icon_main_share_clicking);
                btnShare.startAnimation(fadein1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnShare.setImageResource(R.drawable.icon_main_share_clicked);
                    }
                }, 500);
                frag = new FragmentSharing();
                break;

            case Manager.FRAGMENT_NAVI_TICKET:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                txtTopbar.setText("입장권");
                frag = new FragmentNaviTicket();
                break;

            case Manager.FRAGMENT_NAVI_STAMP:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                txtTopbar.setText("스탬프");
                frag = new FragmentNaviStamp();
                break;

            case Manager.FRAGMENT_NAVI_TREASURE:
                fManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                txtTopbar.setText("보물함");
                frag = new FragmentNaviTreasure();
                break;

//            case Manager.FRAGMENT_NAVI_NOTICE:
//                frag = new FragmentNaviTicket();
//                break;
//
//            case Manager.FRAGMENT_NAVI_SETTING:
//                frag = new FragmentNaviTicket();
//                break;


        }

//        fTrans = fManager.beginTransaction().addToBackStack(frag.toString());
        fTrans = fManager.beginTransaction();
        fTrans.replace(R.id.fragment_main, frag);
        fTrans.commit();
    }

    public void showBars() {
        topBarMargin.setVisibility(View.VISIBLE);
        shadowTop.setVisibility(View.VISIBLE);
        topBar.setVisibility(View.VISIBLE);
        shadowBottom.setVisibility(View.VISIBLE);
        bottomBar.setVisibility(View.VISIBLE);
    }

    public void hideBars() {
        topBarMargin.setVisibility(View.GONE);
        shadowTop.setVisibility(View.GONE);
        topBar.setVisibility(View.GONE);
        shadowBottom.setVisibility(View.GONE);
        bottomBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (position == Manager.FRAGMENT_RESERVE_2) {
            transFragment(Manager.FRAGMENT_RESERVE);
        } else if (position == Manager.FRAGMENT_RESERVE_3) {
            transFragment(Manager.FRAGMENT_RESERVE_2);
        } else if (position == Manager.FRAGMENT_RESERVE_4) {
            transFragment(Manager.FRAGMENT_RESERVE_3);
        } else if (position == Manager.FRAGMENT_TREASURE_2) {
            transFragment(Manager.FRAGMENT_TREASURE);
        } else if (position == Manager.FRAGMENT_TREASURE_3_1) {
            transFragment(Manager.FRAGMENT_TREASURE_2);
        } else if (position == Manager.FRAGMENT_TREASURE_3_2) {
            transFragment(Manager.FRAGMENT_TREASURE_3_1);
        } else if (position == Manager.FRAGMENT_TREASURE_4) {
            transFragment(Manager.FRAGMENT_TREASURE_3_1);
        } else if (position == Manager.FRAGMENT_TREASURE_5) {
            transFragment(Manager.FRAGMENT_TREASURE_4);
        } else if (position == Manager.FRAGMENT_INTRO) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (position == Manager.FRAGMENT_SHARE){
            if(((FragmentSharing)frag).cardClicked != 0){
                ((FragmentSharing)frag).cardClicked = 0;
                FragmentSharing.removeVisibility();
            }
            else {
                transFragment(Manager.FRAGMENT_INTRO);
            }
        } else {
            transFragment(Manager.FRAGMENT_INTRO);
        }
    }
}