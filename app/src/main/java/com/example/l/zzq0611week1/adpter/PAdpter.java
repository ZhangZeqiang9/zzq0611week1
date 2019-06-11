package com.example.l.zzq0611week1.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.l.zzq0611week1.R;
import com.example.l.zzq0611week1.bean.ManBean;

import java.util.List;

public class PAdpter extends BaseAdapter {
    private List<ManBean.Data> list;
    private Context context;

    public PAdpter(List<ManBean.Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vh vh;
        if(convertView==null){
            vh = new Vh();
            convertView = View.inflate(context, R.layout.iteam,null);
            vh.img = convertView.findViewById(R.id.i_img);
            vh.tv1 = convertView.findViewById(R.id.i_tv1);
            vh.tv2 = convertView.findViewById(R.id.i_tv2);
            vh.tv3 = convertView.findViewById(R.id.i_tv3);
            convertView.setTag(vh);
        }else{
            vh = (Vh) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getProfile_image()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(vh.img);
        vh.tv1.setText(list.get(position).getTheme_name());
        vh.tv2.setText(list.get(position).getPasstime());
        vh.tv3.setText(list.get(position).getText());
        return convertView;
    }

    private class Vh {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ImageView img;
    }
}
