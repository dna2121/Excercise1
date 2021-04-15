package com.example.excercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

public class ListviewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public ListviewAdapter(Context context, ArrayList<ClassNama> classNamaArrayList) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(HomePage.classNamaArrayList);
    }

    public class ViewHolder{
        TextView name;
    }

    @Override
    public int getCount() {
        return HomePage.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomePage.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(HomePage.classNamaArrayList.get(i).getName());
        return view;
    }

    /*public void filter(String query) {
        HomePage.classNamaArrayList.clear();
        if (query.isEmpty()) {
            HomePage.classNamaArrayList.addAll(arrayList);
        } else {
            query = query.toLowerCase();
            for (ClassNama sd : arrayList) {
                if (sd.getName().toLowerCase().contains(query)) {
                    HomePage.classNamaArrayList.add(sd);
                }
            }
        }
        notifyDataSetChanged();
    }*/
}