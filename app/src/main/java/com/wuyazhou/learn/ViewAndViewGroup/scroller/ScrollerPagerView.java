package com.wuyazhou.learn.ViewAndViewGroup.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.ViewAndViewGroup.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class ScrollerPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private ScrollViewByScroller mScrollViewByScroller;

    public ScrollerPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ScrollerPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public ScrollerPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_scroller_layout, null);

        addView(mLayout);

        mScrollViewByScroller = mLayout.findViewById(R.id.view);
        mScrollViewByScroller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.view){
            mScrollViewByScroller.smoothScrollTo(-400,0);
        }
    }
}
