package cn.zalezone.ui.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import cn.zalezone.domain.UserInfo;
import cn.zalezone.ui.adapter.SessionListAdapter;

import com.example.zalechat.ChatActivity;
import com.example.zalechat.R;

public class FriendListFragment extends Fragment{
    public static final String  TITLE  = "title";
    private String              mTitle = "default";
    private ListView            listview;
    private ArrayList<UserInfo> userInfoslist;
    private SessionListAdapter  adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
        View view = inflater.inflate(R.layout.session_list, container, false);
        listview = (ListView) view.findViewById(R.id.session_list);
        addData();
        adapter = new SessionListAdapter(userInfoslist, getActivity());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent ChatActivityIntent = new Intent(v.getContext(),ChatActivity.class);
                String name =((UserInfo)adapter.getItem(position)).getTitle();
                ChatActivityIntent.putExtra("title", name);
                startActivity(ChatActivityIntent);
            }
        });

        return view;
    }

    private void addData() {
        userInfoslist = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo("1", "zale", "张鎏锟", "早上8：00", "hello,我的英文名是zale", "2");
        UserInfo userInfo2 = new UserInfo("2", "tt", "zale", "早上6：00", "hello,我的英文名是zale2", "2");
        userInfoslist.add(userInfo);
        userInfoslist.add(userInfo2);
    }
}
