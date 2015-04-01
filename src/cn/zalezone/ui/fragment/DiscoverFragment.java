package cn.zalezone.ui.fragment;

import com.example.zalechat.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiscoverFragment extends Fragment{

    public static final String  TITLE  = "title";
    private String              mTitle = "default";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
        
        View view = inflater.inflate(R.layout.fragment_discover, container,false);
        return view;
    }
}
