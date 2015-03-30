package cn.zalezone.ui;

import com.example.zalechat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SearchActivity extends Activity{

    private Button backButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        initUI();
        addListener();
        
    }

    private void addListener() {
        backButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(v.getContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });
    }

    private void initUI() {
        backButton = (Button)findViewById(R.id.leftBarButton);
        
    }
    
}
