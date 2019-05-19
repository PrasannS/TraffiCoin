package cryptonite.android.apps.com.traficoin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment pageFrament = new FragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt("pageNumber", i+1);
        pageFrament.setArguments(bundle);

        return pageFrament;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
