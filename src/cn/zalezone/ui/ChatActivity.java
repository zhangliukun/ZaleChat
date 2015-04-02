package cn.zalezone.ui;

import java.util.ArrayList;

import cn.zalezone.ui.adapter.MessageListAdapter;

import com.example.zalechat.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


/**
 * 聊天的activity
 * @author zlk
 *
 */
public class ChatActivity extends Activity {

    private TextView friendName;
    private Button backButton;
    private Button friendInfo;
    private Button multiMedoaButton;
    private EditText inputText;
    private ListView chatListView;
    private MessageListAdapter messageListAdapter;
    
    private ArrayList<String> messageList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //获取意图，得到title值
        Intent intent = getIntent();
        String title= intent.getStringExtra("title");
        initUI();
        initData();
        addListener();
        friendName.setText(title);
        
    }

    private void initData() {
		messageList = new ArrayList<String>();
		messageListAdapter = new MessageListAdapter(messageList,getApplicationContext());
		chatListView.setAdapter(messageListAdapter);
	}

	private void addListener() {
        //返回键按钮
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(v.getContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });
        //查看朋友信息按钮
        friendInfo.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent chatInfoActivity = new Intent(v.getContext(),ChatInfoActivity.class);
                startActivity(chatInfoActivity);
                finish();
            }
        });
        
        //当点击输入框时将listview选择最后一行数据
        inputText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				chatListView.setSelection(messageList.size()-1);
				
			}
		});
        /*
        inputText.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				
				return false;
			}
		});
        */
        
        //发送信息按钮
        multiMedoaButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String msg = inputText.getText().toString();
				if (msg!=null) {
					messageList.add(msg);
					messageListAdapter.notifyDataSetChanged();
					chatListView.setSelection(messageList.size()-1);
				}
			}
		});
    }

    private void initUI() {
        friendName = (TextView)findViewById(R.id.friendName);
        multiMedoaButton = (Button)findViewById(R.id.multiMediaButton);
        backButton = (Button)findViewById(R.id.leftBarButton);
        friendInfo = (Button)findViewById(R.id.rightBarButton);
        chatListView = (ListView)findViewById(R.id.chat_list);
        inputText = (EditText)findViewById(R.id.chat_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat, menu);
        return true;
    }

}
