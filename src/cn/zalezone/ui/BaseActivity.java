package cn.zalezone.ui;

import android.app.Activity;

/**
 * 提供给每个Activity的基父类
 * @author zlk
 *
 */
public abstract class BaseActivity extends Activity{

	//自己定义通用的父类,这个类以后再慢慢实现
	public abstract void initUI();
	public abstract void initData();
	public abstract void addListener();
	
}
