package viewpagerindicatordemo.growing.com.viewpagerindicatordemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import viewpagerindicatordemo.growing.com.viewpagerindicatordemo.TabFragment;

/**
 * Created by ejiang on 2017-03-15.
 */

public class FragmentVpAdapter extends FragmentPagerAdapter {
    private ArrayList<TabFragment> mFragments;

    public FragmentVpAdapter(FragmentManager fm, ArrayList<TabFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments == null ? null : mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public long getItemId(int position) {
        int hashCode = mFragments.get(position).hashCode();
        return hashCode;
    }

    @Override
    public int getItemPosition(Object object) {

        return POSITION_NONE;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        try {
            super.finishUpdate(container);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
        }
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(mFragments.get(position).getView());
//    }
}
