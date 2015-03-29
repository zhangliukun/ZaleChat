package com.example.zalechat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChatInfoActivity extends Activity{

    private Button backButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatinfo);
        
        initUI();
        addListener();
    }
    private void addListener() {
        backButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent chatActivity = new Intent(v.getContext(),ChatActivity.class);
                startActivity(chatActivity);
                finish();
            }
        });
    }
    private void initUI() {
        backButton = (Button)findViewById(R.id.leftBarButton);
    }
    
    
}
