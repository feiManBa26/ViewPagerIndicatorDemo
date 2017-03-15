package viewpagerindicatordemo.growing.com.viewpagerindicatordemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private String[] strArray = new String[]{"KKKKE", "BBBE", "AAAE", "TTTE", "OOKKSKS", "AKDKDMD", "AASSC", "ACSSC", "SSAAA", "CCSSS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        mVp = (ViewPager) findViewById(R.id.vp);

    }
}
