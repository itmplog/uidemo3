package top.itmp.uidemo3.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hz on 16/5/23.
 */
public class BaseActivity extends AppCompatActivity {
    public void transFragment(int view_id, Fragment fragment) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(view_id, fragment);
        mFragmentTransaction.commit();
    }
}
