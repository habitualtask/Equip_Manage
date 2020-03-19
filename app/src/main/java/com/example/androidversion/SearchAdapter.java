package com.example.androidversion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Equipment> list = new ArrayList<Equipment>();
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public SearchAdapter(ArrayList<Equipment> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGroup) {
        if (converView == null) {
            converView = inflate.inflate(R.layout.search_listview, null);

            viewHolder = new ViewHolder();
            viewHolder.label3 = (ImageView) converView.findViewById(R.id.list_image);
            viewHolder.label1 = (TextView) converView.findViewById(R.id.list_title);
            viewHolder.label2 = (TextView) converView.findViewById(R.id.list_desc);

            converView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) converView.getTag();
        }
            viewHolder.label3.setImageResource(list.get(position).getList_image());
            viewHolder.label1.setText(list.get(position).getList_title());
            viewHolder.label2.setText(list.get(position).getList_desc());
            //리스트에 있는 데이터를 리스트뷰 셀에 뿌림
            return converView;
        }

        private class ViewHolder {
            public TextView label1;
            public TextView label2;
            public ImageView label3;
        }
    }
