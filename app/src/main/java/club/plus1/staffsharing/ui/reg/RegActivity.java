package club.plus1.staffsharing.ui.reg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import club.plus1.staffsharing.R;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        ViewPager viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab);
        viewPager.setAdapter(new RegFragmentAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
