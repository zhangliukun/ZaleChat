package cn.zalezone.ui.adapter;

import java.util.ArrayList;

import cn.zalezone.domain.UserInfo;

import com.example.zalechat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 朋友列表的自定义adapter
 * @author zlk
 *
 */

public class FriendListAdapter extends BaseAdapter{

    private ArrayList<UserInfo> list;           // 填充数据的list
    private Context             context;        // 上下文
    private LayoutInflater      inflater = null; // 用来导入布局

    private static class ViewHolder {
        TextView  alpha;
        ImageView avatar;
        TextView  name;
    }

    public FriendListAdapter(ArrayList<UserInfo> list, Context context)// 构造器
    {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.session_listview_style, null);
            viewHolder = new ViewHolder();
            viewHolder.alpha = (TextView) convertView.findViewById(R.id.alpha);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatarImageView);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        UserInfo userInfo = list.get(position);
        viewHolder.alpha.setText(userInfo.getAlpha());
        viewHolder.name.setText(userInfo.getName());
        return convertView;
    }
}
