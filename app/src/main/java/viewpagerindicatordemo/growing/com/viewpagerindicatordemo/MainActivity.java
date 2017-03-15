package viewpagerindicatordemo.growing.com.viewpagerindicatordemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import viewpagerindicatordemo.growing.com.viewpagerindicatordemo.adapter.FragmentVpAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private String[] strArray = new String[]{"KKKKE", "BBBE", "AAAE", "TTTE", "OOKKSKS", "AKDKDMD", "AASSC", "ACSSC", "SSAAA", "CCSSS"};
    private int[] idL = new int[]{R.layout.tab_one, R.layout.tab_two, R.layout.tab_three, R.layout.tab_four, R.layout.tab_one,
            R.layout.tab_two, R.layout.tab_three, R.layout.tab_four, R.layout.tab_one, R.layout.tab_two};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        ArrayList<TabFragment> tbFrg = new ArrayList<>();
        mVp = (ViewPager) findViewById(R.id.vp);
        for (int i = 0; i < strArray.length; i++) {
            TabFragment fragment = TabFragment.getInstence(idL[i]);
            tbFrg.add(fragment);
        }

        FragmentVpAdapter adapter = new FragmentVpAdapter(getSupportFragmentManager(), tbFrg);
        mVp.setAdapter(adapter);

    }
}
