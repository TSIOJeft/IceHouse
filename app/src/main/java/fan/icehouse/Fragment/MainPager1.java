package fan.icehouse.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fan.icehouse.Adapter.RecyclerViewAdapter;
import fan.icehouse.R;

/**
 * Created by Fan on 2018/1/26.
 */

public class MainPager1 extends Fragment {
    private ArrayList<Map<String, Object>> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainpager1, container, false);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), data);
        final HashMap<String, Object> item = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            item.put("name", "AppName");
            item.put("image", R.drawable.ic_process);
            data.add(item);
            recyclerViewAdapter.notifyItemInserted(0);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAdapter.setOnRecyclerViewClickListener(new RecyclerViewAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(View view, int p) {
                Map<String, Object> item = new HashMap<>();
                item.put("name", "添加数据");
                data.add(p, item);
                recyclerViewAdapter.notifyItemInserted(p);
                Toast.makeText(getActivity(), "点击了List", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View v, int p) {
                data.remove(p);
                Toast.makeText(getActivity(),"删除数据",Toast.LENGTH_SHORT);
                recyclerViewAdapter.notifyItemRemoved(p);
            }
        });
        return view;
    }

}
