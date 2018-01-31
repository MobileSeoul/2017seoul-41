package com.example.nayon.nanjicamp.data;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.nayon.nanjicamp.R;

import java.util.ArrayList;

/**
 * Created by nayon on 2017-04-11.
 */
public class Manager {

    View view;

    public static int height = 0;
    public static int width = 0;
    public static int indicatorSize = 0;
    public static int indicatorMargin = 0;
    public static int pageMargin = 0;

    public static final int NAVTYPE_HEADER = 0;
    public static final int NAVTYPE_MENU = 1;
    public static final int NAVTYPE_TAIL = 2;

    public static final int FRAGMENT_NAVI_TICKET = 51;
    public static final int FRAGMENT_NAVI_STAMP = 52;
    public static final int FRAGMENT_NAVI_TREASURE = 53;
    public static final int FRAGMENT_NAVI_NOTICE = 54;
    public static final int FRAGMENT_NAVI_SETTING = 55;

    public static final int FRAGMENT_INTRO = 0;
    public static final int FRAGMENT_RESERVE = 1;
    public static final int FRAGMENT_TREASURE = 2;
    public static final int FRAGMENT_PREPARE = 3;
    public static final int FRAGMENT_SHARE = 4;

    public static final int FRAGMENT_RESERVE_2 = 12;
    public static final int FRAGMENT_RESERVE_3 = 13;
    public static final int FRAGMENT_RESERVE_4 = 14;

    public static final int FRAGMENT_TREASURE_2 = 22;
    public static final int FRAGMENT_TREASURE_3_1 = 231;
    public static final int FRAGMENT_TREASURE_3_2 = 232;
    public static final int FRAGMENT_TREASURE_4 = 24;
    public static final int FRAGMENT_TREASURE_5 = 25;

    public static final int FRAGMENT_PREPARE_1 = 31;
    public static final int FRAGMENT_PREPARE_2 = 32;
    public static final int FRAGMENT_PREPARE_3 = 33;


    public Manager(View view) {
        this.view = view;
    }

    public static final ArrayList<DrawerData> mDrawerData = new ArrayList<DrawerData>() {
        {
            /** header view data **/
            add(new DrawerData(NAVTYPE_HEADER, 0, 0, null));
            /** menu list data **/
            add(new DrawerData(NAVTYPE_MENU, FRAGMENT_NAVI_TICKET, R.drawable.icon_navi_ticket, "입장권"));
            add(new DrawerData(NAVTYPE_MENU, FRAGMENT_NAVI_STAMP, R.drawable.icon_navi_stamp, "스탬프"));
            add(new DrawerData(NAVTYPE_MENU, FRAGMENT_NAVI_TREASURE, R.drawable.icon_navi_treasure, "보물함"));
            add(new DrawerData(NAVTYPE_MENU, FRAGMENT_NAVI_NOTICE, R.drawable.icon_navi_notice, "공지사항"));
            add(new DrawerData(NAVTYPE_MENU, FRAGMENT_NAVI_SETTING, R.drawable.icon_navi_setting, "설정"));
            /** footer view data **/
            add(new DrawerData(NAVTYPE_TAIL, 0, 0, null));
        }
    };

    public static void setDisplaySize(Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        indicatorSize = width * 38 / 1440;
        indicatorMargin = width * 14 / 1440;
        pageMargin = width * 500 / 1440;
        Log.w("Nayong || ", "SetDisplaySize width=" + width + "height=" + height);

    }

//    public int getWidth() {
//        if (width != 0) {
//            return width;
//        }
//        Log.e("Nayong | Manager.java ", "getWidth ERROR, It is not set");
//        return -1; //error
//    }
//
//    public int getHeight() {
//        if (height != 0) {
//            return height;
//        }
//        Log.e("Nayong | Manager.java ", "getHeight ERROR, It is not set");
//        return -1; //error
//    }

}
