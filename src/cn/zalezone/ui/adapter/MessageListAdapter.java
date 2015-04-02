package cn.zalezone.ui.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import cn.zalezone.domain.UserInfo;

import com.example.zalechat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * 自定义的对话时消息框的adapter
 * @author zlk
 *
 */
public class MessageListAdapter extends BaseAdapter {

	private static class ViewHolderRightText {
		TextView timeTV;
		ImageView rightAvatar;
		TextView rightNockName;
		TextView rightText;
		ProgressBar rightBarProgressBar;
	}

	private ArrayList<String> items;
	private ListView adapterList;
	private LayoutInflater inflater;

	
	 public MessageListAdapter(ArrayList<String > list, Context context)// 构造器
	    {
		 	items = list;
	        inflater = LayoutInflater.from(context);
	    }
	
	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolderRightText holderRightText;
		String message = items.get(position);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.chat_right_text, null);
			holderRightText = new ViewHolderRightText();
			holderRightText.rightText = (TextView)convertView.findViewById(R.id.textview_content_r);
			holderRightText.rightAvatar = (ImageView)convertView.findViewById(R.id.image_portrait_r);
			convertView.setTag(holderRightText);
		} else {
			holderRightText = (ViewHolderRightText) convertView.getTag();
		}
		holderRightText.rightText.setText(message);
		
		return convertView;
	}

}
