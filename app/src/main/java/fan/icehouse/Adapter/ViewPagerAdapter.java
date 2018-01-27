package fan.icehouse.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import fan.icehouse.Fragment.MainPager1;
import fan.icehouse.Fragment.MainPager2;
import fan.icehouse.R;

/**
 * Created by Fan on 2018/1/26.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] title={"窖内","窖外"};
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if(position==1){
            return new MainPager2();
        }
        return new MainPager1();
    }

    @Override
    public int getCount() {
        return title.length;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return title[position];
//    }

}
