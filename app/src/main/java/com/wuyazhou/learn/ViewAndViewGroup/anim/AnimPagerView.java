package com.wuyazhou.learn.ViewAndViewGroup.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.ViewAndViewGroup.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class AnimPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private View mScrollViewOne;
    private View mScrollViewTwo;

    public AnimPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public AnimPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public AnimPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_anim_layout, null);

        addView(mLayout);

        mScrollViewOne = mLayout.findViewById(R.id.view);
        mScrollViewOne.setOnClickListener(this);

        mScrollViewTwo = mLayout.findViewById(R.id.view_2);
        mScrollViewTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.view){
            invalidate();
            //mScrollView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.translate));
            mScrollViewOne.startAnimation(AnimationUtils.loadAnimation(mContext,R.anim.translate));
        }else if (i == R.id.view_2){
            ObjectAnimator.ofFloat(mScrollViewTwo,"translationY",0,300)
                    .setDuration(1000)
                    .start();
        }
    }
}
