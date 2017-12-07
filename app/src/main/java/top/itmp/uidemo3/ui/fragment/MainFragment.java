package top.itmp.uidemo3.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dp on 2017/12/7.
 */

public class MainFragment extends Fragment {
    private String txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            txt = arguments.getString("txt");
        }
        TextView textView1 = new TextView(container.getContext());
        textView1.setText(txt);
        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        textView1.setGravity(Gravity.CENTER);

        textView1.setLayoutParams(lllp);
        return textView1;
    }

    public static MainFragment newInstance(String text) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("txt", text);
        //fragment保存参数，传入一个Bundle对象
        mainFragment.setArguments(bundle);
        return mainFragment;
    }
}
