package viewpagerindicatordemo.growing.com.viewpagerindicatordemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ejiang on 2017-03-15.
 */

public class TabFragment extends Fragment {
    private static final String BUNDLE_ID = "bundleId";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = null;
        if (bundle != null) {
            view = View.inflate(getContext(), bundle.getInt(BUNDLE_ID), null);
        }
        return view;
    }

    public static TabFragment getInstence(int id) {
        TabFragment fragment = new TabFragment();
        if (id != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(BUNDLE_ID, id);
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
