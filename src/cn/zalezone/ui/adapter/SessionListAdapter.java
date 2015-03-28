package cn.zalezone.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import cn.zalezone.domain.UserInfo;

import com.example.zalechat.R;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SessionListAdapter extends BaseAdapter {

    private ArrayList<UserInfo> list;           // 填充数据的list
    private Context             context;        // 上下文
    private LayoutInflater      inflater = null; // 用来导入布局

    private static class ViewHolder {
        TextView  alpha;
        ImageView avatar;
        TextView  title;
        TextView  time;
        TextView  des;
        TextView  messageHint;
    }

    public SessionListAdapter(ArrayList<UserInfo> list, Context context)// 构造器
    {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.list = list;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.session_style, null);
            viewHolder = new ViewHolder();
            viewHolder.alpha = (TextView) convertView.findViewById(R.id.alpha);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatarImageView);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.des = (TextView) convertView.findViewById(R.id.des);
            viewHolder.messageHint = (TextView) convertView.findViewById(R.id.paopao);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        UserInfo userInfo = list.get(position);
        viewHolder.alpha.setText(userInfo.getAlpha());
        viewHolder.title.setText(userInfo.getTitle());
        viewHolder.time.setText(userInfo.getTime());
        viewHolder.des.setText(userInfo.getDes());
        int num = Integer.valueOf(userInfo.getMessageHint());
        if (num>0) {
            viewHolder.messageHint.setText(userInfo.getMessageHint());
            TextView textView =(TextView)convertView.findViewById(R.id.paopao);
            textView.setVisibility(1);
        }
        return convertView;
    }
}
