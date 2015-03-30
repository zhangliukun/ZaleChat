package cn.zalezone.ui;

import com.example.zalechat.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChatActivity extends Activity {

    private TextView friendName;
    private Button backButton;
    private Button friendInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //获取意图，得到title值
        Intent intent = getIntent();
        String title= intent.getStringExtra("title");
        initUI();
        addListener();
        friendName.setText(title);
        
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
    }

    private void initUI() {
        friendName = (TextView)findViewById(R.id.friendName);
        backButton = (Button)findViewById(R.id.leftBarButton);
        friendInfo = (Button)findViewById(R.id.rightBarButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat, menu);
        return true;
    }

}
