package com.example.pendataanpenduduk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<DataModel> data;

  public ListAdapter(Context context, ArrayList<DataModel> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int position) {
    return data.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.list_data, parent, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    DataModel data = this.data.get(position);
    holder.tvName.setText(data.getName());
    holder.tvDesc.setText(data.getCity());

    convertView.setOnClickListener(v -> {
      Intent intent = new Intent(context, UserDetailActivity.class);
      intent.putExtra("user_data", data);
      context.startActivity(intent);
    });

    return convertView;
  }

  private static class ViewHolder {
    private final TextView tvName;
    private final TextView tvDesc;

    public ViewHolder(View view) {
      tvName = view.findViewById(R.id.name_view);
      tvDesc = view.findViewById(R.id.description_view);
    }
  }
}
