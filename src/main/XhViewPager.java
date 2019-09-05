package com.example.xh.viewpager.ui.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class XhViewPager extends ViewPager {
    private float mLastMotionX;
    private float mLastMotionY;
    private int mActivePointerId = -1;
    private boolean isIntercept = false;

    private final int mTouchSlop = 16;

    public XhViewPager(@NonNull Context context) {
        super(context);
    }

    public XhViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (!isIntercept) {
                    final int activePointerId = mActivePointerId;
                    final int pointerIndex = ev.findPointerIndex(activePointerId);
                    final float x = ev.getX(pointerIndex);
                    final float dx = x - mLastMotionX;
                    final float xDiff = Math.abs(dx);
                    final float y = ev.getY(pointerIndex);
                    final float yDiff = Math.abs(y - mLastMotionY);

                    if (xDiff > mTouchSlop && xDiff > yDiff) {
                        isIntercept = true;
                        return true;
                    }
                }
                break;
            case MotionEvent.ACTION_DOWN:
                mLastMotionX = ev.getX();
                mLastMotionY = ev.getY();
                mActivePointerId = ev.getPointerId(0);
                isIntercept = false;
                break;
        }

        return super.onInterceptTouchEvent(ev);


    }
}
