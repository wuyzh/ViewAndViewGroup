package com.wuyazhou.learn.ViewAndViewGroup.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author wuyzh
 * */
public class ScrollViewByScrollBy extends View {
    private int lastX;
    private int lastY;
    public ScrollViewByScrollBy(Context context) {
        super(context);
    }

    public ScrollViewByScrollBy(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewByScrollBy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollViewByScrollBy(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }
        return true;
    }
}
