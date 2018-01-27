package fan.icehouse.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import fan.icehouse.R;

/**
 * Created by Fan on 2018/1/27.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.mViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private ArrayList<Map<String, Object>> data;
    private Context context;
    private OnRecyclerViewClickListener onRecyclerViewClickListener = null;

    public RecyclerViewAdapter(Context context, ArrayList<Map<String, Object>> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_item, parent, false);
        view.setOnLongClickListener(this);
        view.setOnClickListener(this);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        Map<String, Object> item = data.get(position);
        holder.App_name.setText((String) item.get("name"));
        holder.App_image.setImageResource(R.drawable.ic_process);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        if (onRecyclerViewClickListener != null) {
            onRecyclerViewClickListener.OnItemClick(view, (int) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (onRecyclerViewClickListener != null) {
            onRecyclerViewClickListener.OnItemLongClick(view, (int) view.getTag());
        }
        return true;
    }

    //点击事件
    public static interface OnRecyclerViewClickListener {
        void OnItemClick(View view, int p);

        void OnItemLongClick(View v, int p);
    }

    class mViewHolder extends RecyclerView.ViewHolder {
        ImageView App_image = (ImageView) itemView.findViewById(R.id.app_image);
        TextView App_name = (TextView) itemView.findViewById(R.id.app_name);

        mViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener listener) {
        this.onRecyclerViewClickListener = listener;
    }
}
