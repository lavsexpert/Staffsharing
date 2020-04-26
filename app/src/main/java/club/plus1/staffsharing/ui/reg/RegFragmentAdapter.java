package club.plus1.staffsharing.ui.reg;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;

public class RegFragmentAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    private String[] tabTitles = new String[]{
            App.getAppContext().getString(R.string.reg_company),
            App.getAppContext().getString(R.string.reg_employee)};
    private List<RegFragment> fragments;

    RegFragmentAdapter(FragmentManager fm, List<RegFragment> fragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        RegFragment fragment;
        try{
            fragment = fragments.get(position);
        } catch (Exception e) {
            fragment = RegFragment.newInstance(position);
            fragments.add(position, fragment);
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
