package com.wuyazhou.learn.ViewAndViewGroup.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**
 * @author wuyzh
 * */
public class ScrollViewByLayout extends View {
    private int lastX;
    private int lastY;
    public ScrollViewByLayout(Context context) {
        super(context);
    }

    public ScrollViewByLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewByLayout(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollViewByLayout(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
                //调用layout来重新放置他的位置
                layout(getLeft()+offsetX,getTop()+offsetY,
                        getRight()+offsetX,getBottom()+offsetY);
                break;
        }
        return true;
    }
}
