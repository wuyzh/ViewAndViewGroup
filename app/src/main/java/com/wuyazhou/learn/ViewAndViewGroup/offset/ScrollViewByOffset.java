package com.wuyazhou.learn.ViewAndViewGroup.offset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author wuyzh
 * */
public class ScrollViewByOffset extends View {
    private int lastX;
    private int lastY;
    public ScrollViewByOffset(Context context) {
        super(context);
    }

    public ScrollViewByOffset(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewByOffset(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollViewByOffset(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x-lastX;
                int offsetY = y-lastY;
                //offSet
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
