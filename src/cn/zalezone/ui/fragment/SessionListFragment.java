package cn.zalezone.ui.fragment;

import java.util.ArrayList;

import com.example.zalechat.R;

import cn.zalezone.domain.UserInfo;
import cn.zalezone.ui.ChatActivity;
import cn.zalezone.ui.adapter.SessionListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SessionListFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.listview, container, false);
        listview = (ListView) view.findViewById(R.id.session_list);
        addData();
        adapter = new SessionListAdapter(userInfoslist, getActivity());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent ChatActivityIntent = new Intent(v.getContext(),ChatActivity.class);
                String name =((UserInfo)adapter.getItem(position)).getName();
                ChatActivityIntent.putExtra("title", name);
                startActivity(ChatActivityIntent);
            }
        });

        return view;
    }

    private void addData() {
        userInfoslist = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo("1", "zale", "张鎏锟", "早上8：00", "hello,我的英文名是zale", "2");
        userInfoslist.add(userInfo);
    }

}
