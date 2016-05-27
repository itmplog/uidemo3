package top.itmp.go.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baidu.mapapi.map.MapView;

import top.itmp.go.R;
import top.itmp.go.base.BaseActivity;

/**
 * Created by hz on 2016/5/26.
 */
public class MapActivity extends BaseActivity {
    private MapView mapView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);
        mapView = (MapView)findViewById(R.id.bmapView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
}
