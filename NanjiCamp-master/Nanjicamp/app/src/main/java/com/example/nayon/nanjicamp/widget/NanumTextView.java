package com.example.nayon.nanjicamp.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by nayon on 2017-04-23.
 */
public class NanumTextView extends TextView{


    public NanumTextView(Context context) {
        super(context);
        setType(context);
    }

    public NanumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public NanumTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setType(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NanumTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setType(context);
    }

    private void setType(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/NanumGothic.ttf.mp3"));
    }
}
