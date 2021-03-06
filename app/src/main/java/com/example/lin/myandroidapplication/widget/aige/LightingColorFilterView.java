package com.example.lin.myandroidapplication.widget.aige;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/14.
 * LightingColorFilter bitmap
 */

public class LightingColorFilterView extends View {

    private Paint mPaint;

    private Bitmap mBitmap;

    private Context mContext;

    private boolean isClick;

    public LightingColorFilterView(Context context) {
        super(context, null);
    }

    public LightingColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
        initRes();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    mPaint.setColorFilter(null);
                    isClick = false;
                } else {
                    mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FFFF00));
                    isClick = true;
                }

                invalidate();
            }
        });
    }

    private void initRes() {
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.test_img);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //抗锯齿


        /**
         * 设置描边的粗细，单位:像素px
         * 注意:当setStrokeWidth(0)的时候描边的宽度并不为0而是占一个像素
         */
//        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, AppUtils.getScreenWidthM() / 2 - mBitmap.getWidth() / 2,
                AppUtils.getScreenHeightM() / 2 - mBitmap.getHeight() / 2, mPaint);
    }
}
