package com.example.nayon.nanjicamp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nayon.nanjicamp.MainActivity;
import com.example.nayon.nanjicamp.R;
import com.example.nayon.nanjicamp.adapter.CustomPagerAdapterReserve1;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve1;
import com.example.nayon.nanjicamp.custom_fragment.CustomFragmentReserve3;
import com.example.nayon.nanjicamp.data.Manager;
import com.example.nayon.nanjicamp.widget.NanumBoldTextView;
import com.example.nayon.nanjicamp.widget.NanumTextView;

import java.util.ArrayList;

/**
 * Created by nayon on 2017-04-10.
 */
public class FragmentReserve1 extends Fragment {


    Context context;
    private GridView gridView;
    private GridAdapter gridAdapter;
    ImageButton btnBefore;
    ImageButton btnNext;
    NanumTextView txtMonth;
    ImageButton btnTentMinus;
    ImageButton btnTentPlus;
    ImageButton btnPeopleMinus;
    ImageButton btnPeoplePlus;
    NanumTextView txtTent;
    NanumTextView txtPeople;
    ProgressBar progressBar;


    int clicked = 0;
    int month = 6;

    public static CustomPagerAdapterReserve1 mAdapter;
    public ViewPager mViewPager;
    public LinearLayout indicator;
    private int dotCount;
    private ImageView[] dots;

    private int mCurrentPosition;
    CustomFragmentReserve1 fragment;
    CustomFragmentReserve1 fragmentBefore;
    CustomFragmentReserve1 fragmentAfter;

    public static SparseArray<CustomFragmentReserve1> registeredFragments = new SparseArray<CustomFragmentReserve1>();


    public final static int PAGES = 3;
    public final static int FIRST_PAGE = 0;

    public FragmentReserve1(){
        super();
    }

    public FragmentReserve1(SparseArray<CustomFragmentReserve1> registeredFragments){
        super();
        this.registeredFragments = registeredFragments;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, final ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reserve_1, parentViewGroup, false);

        /* calendar */
        context = this.getContext();
        gridView = (GridView) rootView.findViewById(R.id.grid_reserve);
        final NanumBoldTextView txtStart = (NanumBoldTextView) rootView.findViewById(R.id.txt_reserve_1_start);
        final NanumBoldTextView txtEnd = (NanumBoldTextView) rootView.findViewById(R.id.txt_reserve_1_end);
        btnBefore = (ImageButton) rootView.findViewById(R.id.btn_calender_before);
        btnNext = (ImageButton) rootView.findViewById(R.id.btn_calender_next);
        txtMonth = (NanumTextView) rootView.findViewById(R.id.txt_calender_month);
        btnTentMinus = (ImageButton) rootView.findViewById(R.id.btn_reserve_1_tent_minus);
        btnTentPlus = (ImageButton) rootView.findViewById(R.id.btn_reserve_1_tent_plus);
        btnPeopleMinus = (ImageButton) rootView.findViewById(R.id.btn_reserve_1_people_minus);
        btnPeoplePlus = (ImageButton) rootView.findViewById(R.id.btn_reserve_1_people_plus);
        txtTent = (NanumTextView) rootView.findViewById(R.id.txt_reserve_1_tent_num);
        txtPeople = (NanumTextView) rootView.findViewById(R.id.txt_reserve_1_people);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_calendar);
        progressBar.setVisibility(View.GONE);

        gridAdapter = new GridAdapter(month);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (gridAdapter.dayList.get(position) == Integer.toString(0)
                        || Integer.parseInt(gridAdapter.dayList.get(position)) > gridAdapter.maxDay) {
                    return;
                }
                clicked++;
                if (clicked % 3 == 1) {
                    gridAdapter.setStartDay(position);
                    txtStart.setText(gridAdapter.month + "월 " + gridAdapter.dayList.get(position) + "일");
                } else if (clicked % 3 == 2) {
                    gridAdapter.setEndDay(position);
                    txtEnd.setText(gridAdapter.month + "월 " + gridAdapter.dayList.get(position) + "일");
                } else {
                    gridAdapter.setStartDay(-1);
                    gridAdapter.setEndDay(-1);
                    txtStart.setText("");
                    txtEnd.setText("");
                }
                gridAdapter.notifyDataSetChanged();
            }
        });

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month == 7 || month == 8) {
                    month--;
                    txtMonth.setText(month + "월");
                    progressBar.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.INVISIBLE);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.INVISIBLE);
                            gridView.setVisibility(View.VISIBLE);
                        }
                    },2000);

                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gridAdapter = new GridAdapter(month);
                            gridView.setAdapter(gridAdapter);
                            gridAdapter.notifyDataSetChanged();
                        }
                    },1000);


                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month == 6 || month == 7) {
                    month++;
                    txtMonth.setText(month + "월");

                    progressBar.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.INVISIBLE);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.INVISIBLE);
                            gridView.setVisibility(View.VISIBLE);
                        }
                    },2000);

                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gridAdapter = new GridAdapter(month);
                            gridView.setAdapter(gridAdapter);
                            gridAdapter.notifyDataSetChanged();
                        }
                    },1000);
                }
            }
        });


        /* others */
        btnTentMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tentNum = Integer.parseInt(txtTent.getText().toString());
                if(tentNum < 1){
                    return;
                }
                txtTent.setText(String.valueOf(tentNum - 1));
            }
        });
        btnTentPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tentNum = Integer.parseInt(txtTent.getText().toString());
                txtTent.setText(String.valueOf(tentNum + 1));
            }
        });
        btnPeopleMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int peopleNum = Integer.parseInt(txtPeople.getText().toString());
                if(peopleNum < 1) {
                    return;
                }
                txtPeople.setText(String.valueOf(peopleNum - 1));
            }
        });
        btnPeoplePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int peopleNum = Integer.parseInt(txtPeople.getText().toString());
                txtPeople.setText(String.valueOf(peopleNum + 1));
            }
        });







        ImageButton btnNext = (ImageButton) rootView.findViewById(R.id.btn_reserve_next);

        //reserve fragment로 이동
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).transFragment(Manager.FRAGMENT_RESERVE_2);
            }
        });


        /* card */

        mViewPager = (ViewPager) rootView.findViewById(R.id.card_reserve_tent);
        indicator = (LinearLayout) rootView.findViewById(R.id.indicator_reserve_1);

        mAdapter = new CustomPagerAdapterReserve1(this.getActivity(), this.getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, mAdapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        mViewPager.setCurrentItem(FIRST_PAGE);

        // Necessary or the mViewPager will only have one extra page to show
        // make this at least however many pages you can see
        mViewPager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        mViewPager.setPageMargin(-Manager.pageMargin);

        dotCount = mAdapter.getCount();
        dots = new ImageView[dotCount];

        for (int i = 0; i < dotCount; i++) {
            dots[i] = new ImageView(this.getActivity());
            dots[i].setImageResource(R.drawable.icon_indicator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Manager.indicatorSize, Manager.indicatorSize);
            params.setMargins(Manager.indicatorMargin, 0, Manager.indicatorMargin, 0);
            indicator.addView(dots[i], params);
        }
        dots[0].setImageResource(R.drawable.icon_indicator_selected);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position<0 || position>2){
                    position=0;
                }
                for (int i = 0; i < dotCount; i++) {
                    dots[i].setImageResource(R.drawable.icon_indicator);
                }
                dots[position].setImageResource(R.drawable.icon_indicator_selected);

                for(int i = 0; i<dotCount; i++){
                    dots[i].setImageResource(R.drawable.icon_indicator);
                }
                dots[position].setImageResource(R.drawable.icon_indicator_selected);

                 /*get seleceted fragment*/
                mCurrentPosition = position;
                fragment = mAdapter.getRegisteredFragment(mCurrentPosition);
                if(fragment==null){
                    fragment = mAdapter.getRegisteredFragment(mCurrentPosition);
                }

                fragment.checked = 0;
                fragment.back.setVisibility(View.INVISIBLE);
                fragment.imgChecked.setVisibility(View.INVISIBLE);

                fragmentAfter = mAdapter.getRegisteredFragment(mCurrentPosition-1);
                fragmentBefore = mAdapter.getRegisteredFragment(mCurrentPosition+1);

                if(fragmentAfter!=null){
                    fragmentAfter.back.setVisibility(View.INVISIBLE);
                    fragmentAfter.imgChecked.setVisibility(View.INVISIBLE);
                }
                if(fragmentBefore!=null){
                    fragmentBefore.back.setVisibility(View.INVISIBLE);
                    fragmentBefore.imgChecked.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        MainActivity.registeredFragments = registeredFragments;

        return rootView;
    }

    public class GridAdapter extends BaseAdapter {

        LayoutInflater inflater;
        ArrayList<String> dayList = new ArrayList<String>();
        int month;
        int maxDay;
        int startDay = -1;
        int endDay = -1;

        public GridAdapter(int month) {
            this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.month = month;
            if (month == 8) {
                maxDay = 31;
            } else if (month == 6) {
                maxDay = 30;
                dayList.add("0");
                dayList.add("0");
            } else if (month == 7) {
                maxDay = 31;
                dayList.add("0");
                dayList.add("0");
                dayList.add("0");
                dayList.add("0");
            }
            for (int i = 1; i < 36; i++) {
                dayList.add(Integer.toString(i));
            }
        }

        @Override
        public int getCount() {
            return 35;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Log.e("a", parent.toString());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_reserve_1_calendar, parent, false);
            }

            final RelativeLayout layout = (RelativeLayout) convertView.findViewById(R.id.lay_calender);
            final ImageView back1 = (ImageView) convertView.findViewById(R.id.back_calender_1);
            final ImageView back2 = (ImageView) convertView.findViewById(R.id.back_calender_2);
            final ImageView imageView = (ImageView) convertView.findViewById(R.id.img_calender);
            final NanumTextView textView = (NanumTextView) convertView.findViewById(R.id.txt_calender);
            final NanumBoldTextView textViewClicked = (NanumBoldTextView) convertView.findViewById(R.id.txt_calender_clicked);

            if (dayList.get(position) != Integer.toString(0) && Integer.parseInt(dayList.get(position)) < maxDay + 1) {
                textView.setText(dayList.get(position));
                textView.setVisibility(View.VISIBLE);
                textViewClicked.setText(dayList.get(position));
                textViewClicked.setVisibility(View.INVISIBLE);
            } else {
                textView.setVisibility(View.INVISIBLE);
                textViewClicked.setVisibility(View.INVISIBLE);
            }

            if (position == startDay && endDay == -1) {
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewClicked.setTextColor(getResources().getColor(R.color.NanjiTextGray));
                textViewClicked.setVisibility(View.VISIBLE);
            } else if (position == startDay && endDay != -1) {
                back2.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewClicked.setTextColor(getResources().getColor(R.color.NanjiTextGray));
                textViewClicked.setVisibility(View.VISIBLE);
            } else if (position > startDay && position < endDay) {
                back1.setVisibility(View.VISIBLE);
                back2.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewClicked.setTextColor(getResources().getColor(R.color.colorWhite));
                textViewClicked.setVisibility(View.VISIBLE);
            } else if (position == endDay) {
                back1.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewClicked.setTextColor(getResources().getColor(R.color.NanjiTextGray));
                textViewClicked.setVisibility(View.VISIBLE);
            } else if (startDay == -1 && endDay == -1) {
                imageView.setVisibility(View.INVISIBLE);
                back1.setVisibility(View.INVISIBLE);
                back2.setVisibility(View.INVISIBLE);
                textViewClicked.setVisibility(View.INVISIBLE);
            }

            return convertView;
        }

        public void setStartDay(int startDay) {
            this.startDay = startDay;
        }

        public void setEndDay(int endDay) {
            this.endDay = endDay;
        }

    }


}