package com.wuyazhou.learn.ViewAndViewGroup.layoutParams;

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
public class LayoutParamsPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;

    public LayoutParamsPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public LayoutParamsPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public LayoutParamsPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_layout_params_layout, null);

        addView(mLayout);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
    }
}
