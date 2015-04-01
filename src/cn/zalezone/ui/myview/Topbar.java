package cn.zalezone.ui.myview;

import com.example.zalechat.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 自定义的view，topbar，可代替默认的actionbar
 * @author zlk
 */
public class Topbar extends RelativeLayout{

    private Button leftButton,rightButton;
    private TextView tvTitle;
    
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;
    
    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;
    
    private float titleTextSize;
    private int titleTextColor;
    private String title;
    
    private LayoutParams leftParams,rightParams,titleParams;
    
    private topbarClickListener listener;
    
    //自定义接口回调机制实现
    public interface topbarClickListener{
        public void leftClick();
        public void rightClick();
    }
    
    public void setOnTopbarClickListener(topbarClickListener listener)
    {
        this.listener = listener;
        
    }
    
    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        //获得自定义属性值
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = ta.getString(R.styleable.TopBar_leftText);
        
        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);
        
        titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 0);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        title = ta.getString(R.styleable.TopBar_title);
        
        //回收节省资源以及避免缓存产生问题
        ta.recycle();
        
        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);
        
        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftTextColor);
        
        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightTextColor);
        
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);
        
        //setBackgroundColor(0xFFFFFFFF);
        
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton,leftParams);
        
        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton,rightParams);
        
        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tvTitle,titleParams);
        
        
        leftButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });
        
        rightButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
    }

}
