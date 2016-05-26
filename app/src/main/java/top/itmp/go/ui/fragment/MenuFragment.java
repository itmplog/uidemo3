package top.itmp.go.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import top.itmp.go.R;
import top.itmp.go.base.BaseFragment;
import top.itmp.go.dummy;
import top.itmp.go.model.MenuItem;
import top.itmp.go.ui.MainActivity;
import top.itmp.go.ui.SettingsActivity;

/**
 * Created by hz on 16/5/23.
 */
public class MenuFragment extends BaseFragment {

    private MainActivity mainActivity;
    private RecyclerView mRecyclerView;
    private RelativeLayout mRelativeLayout;
    private MenuAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity)context;
        } else {
            throw new IllegalArgumentException("The Activity must be MainActivity!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.realtive_layout);
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                mainActivity.closeDrawer();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new MenuAdapter();

        addDummySource(mAdapter);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<MenuItem> menuItems;

        public MenuAdapter() {
            menuItems = new ArrayList<>();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final MenuItem menuItem = menuItems.get(position);

            holder.textView.setText(menuItem.getTitle());
            holder.imageView.setImageResource(menuItem.getResourceId());
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                    mainActivity.closeDrawer();
                }
            });
        }

        @Override
        public int getItemCount() {
            return menuItems.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relativeLayout;
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.realtive_layout);
            imageView = (ImageView) view.findViewById(R.id.image);
            textView = (TextView) view.findViewById(R.id.text);
        }
    }

    private void addDummySource(MenuAdapter mAdapter) {
        mAdapter.menuItems.clear();

        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
        mAdapter.menuItems.add(new MenuItem(dummy.dummy(), R.mipmap.ic_launcher));
    }
}
