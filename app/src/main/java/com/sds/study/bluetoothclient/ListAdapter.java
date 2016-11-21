package com.sds.study.bluetoothclient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Device> list = new ArrayList<Device>();

    public ListAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view=null;//반환할 뷰
        Device dto=list.get(i);

        //이미 채워진 아이템이 있는 경우
        if (convertView !=null) {
            view=convertView;

            ((DeviceItem)view).init(dto);

        //아무것도 채워지지 않은 경우(최초의 경우!)
        } else {
            view=new DeviceItem(context, dto);

        }

        return view;

    }

}
