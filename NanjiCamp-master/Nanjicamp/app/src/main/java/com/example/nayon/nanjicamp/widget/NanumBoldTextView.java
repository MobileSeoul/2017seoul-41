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
public class NanumBoldTextView extends TextView{


    public NanumBoldTextView(Context context) {
        super(context);
        setType(context);
    }

    public NanumBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public NanumBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setType(context);
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public NanumBoldTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleAttr);
        setType(context);
    }

    private void setType(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/NanumGothicBold.ttf.mp3"));
    }
}
