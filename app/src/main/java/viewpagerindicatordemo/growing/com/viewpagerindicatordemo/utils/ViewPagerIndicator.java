package viewpagerindicatordemo.growing.com.viewpagerindicatordemo.utils;

import android.content.Context;
import android.content.res.ObbInfo;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import viewpagerindicatordemo.growing.com.viewpagerindicatordemo.R;

/**
 * Created by ejiang on 2017-03-15.
 */

public class ViewPagerIndicator<T extends String> extends LinearLayout implements ViewPager.OnPageChangeListener,
        View.OnClickListener {


    private ViewPager viewPager;
    private ArrayList<T> arrayList;
    private ImageView mImgIndicator;
    private LinearLayout mLlTab;
    private HorizontalScrollView mHs;
    private Context context;

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.indicator_style, null);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(view, lp);
        mHs = (HorizontalScrollView) view.findViewById(R.id.hs);
        mLlTab = (LinearLayout) view.findViewById(R.id.ll_tab);
        mImgIndicator = (ImageView) view.findViewById(R.id.img_indicator);
        if (arrayList != null && arrayList.size() > 0) {
            initTab(arrayList);
        }
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);
        }
    }

    /**
     * 初始化
     *
     * @param list
     */
    private void initTab(@NonNull ArrayList<T> list) {
        for (T model : list) {
            TextView child = getTextViewChild();
            child.setText(model);
            child.setTag(model);
            child.setOnClickListener(this);
            mLlTab.addView(child);
        }
    }

    /**
     * 添加ViewPager对象
     *
     * @param viewPager
     */
    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    /**
     * add Indicator
     *
     * @param arrayList
     */
    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private int txtColor = Color.parseColor("#ffffff");
    private int txtSize = 18;

    public TextView getTextViewChild() {
        TextView txtTab = new TextView(context);
        LayoutParams lp = new LayoutParams(getWindowsWith() / 6, LayoutParams.MATCH_PARENT);
        txtTab.setLayoutParams(lp);
        txtTab.setTextSize(txtSize);
        txtTab.setTextColor(txtColor);
        txtTab.setGravity(Gravity.CENTER);
        return txtTab;
    }

    /**
     * 获取屏幕的宽
     *
     * @return
     */
    public int getWindowsWith() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager winManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        winManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的高度
     *
     * @return
     */
    public int getWindowHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager winManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        winManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    @Override
    public void onClick(View v) {

    }
}
