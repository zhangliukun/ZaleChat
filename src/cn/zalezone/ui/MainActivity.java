package cn.zalezone.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.zalechat.R;

import cn.zalezone.domain.UserInfo;
import cn.zalezone.ui.fragment.DiscoverFragment;
import cn.zalezone.ui.fragment.FriendListFragment;
import cn.zalezone.ui.fragment.MeFragment;
import cn.zalezone.ui.fragment.SessionListFragment;
import cn.zalezone.ui.myview.ChangeIconColor;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class MainActivity extends FragmentActivity implements OnClickListener, OnPageChangeListener {

    private ViewPager             mViwePager;
    private List<Fragment>        mTabs         = new ArrayList<Fragment>();
    private FragmentPagerAdapter  fragmentPagerAdapter;
    private List<ChangeIconColor> tabIndicators = new ArrayList<ChangeIconColor>();
    private String[]              fragmentTitle = new String[] { "tab1", "tab2", "tab3", "tab4" };

    private Button                searchButton;
    private Button                moreButton;

    private PopupMenu             pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initDatas();
        mViwePager.setAdapter(fragmentPagerAdapter);
        initEvent();
    }

    /**
     * 初始化选项卡
     */
    private void initUI() {

        // 初始化顶部导航栏的按钮
        searchButton = (Button) findViewById(R.id.top_tab_search);
        moreButton = (Button) findViewById(R.id.top_tab_more);

        // 初始化Viewpager
        mViwePager = (ViewPager) findViewById(R.id.id_viewpager);

        // 初始化底部导航栏组件
        ChangeIconColor one = (ChangeIconColor) findViewById(R.id.id_indicator_one);
        ChangeIconColor two = (ChangeIconColor) findViewById(R.id.id_indicator_two);
        ChangeIconColor three = (ChangeIconColor) findViewById(R.id.id_indicator_three);
        ChangeIconColor four = (ChangeIconColor) findViewById(R.id.id_indicator_four);

        tabIndicators.add(one);
        tabIndicators.add(two);
        tabIndicators.add(three);
        tabIndicators.add(four);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        one.setIconAlpha(1.0f);
    }

    /**
     * 初始化fragment的信息
     */
    public void initDatas()
    {
        SessionListFragment sessionListFragment = new SessionListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SessionListFragment.TITLE, fragmentTitle[0]);
        sessionListFragment.setArguments(bundle);
        mTabs.add(sessionListFragment);

        FriendListFragment friendListFragment = new FriendListFragment();
        bundle.clear();
        bundle.putString(friendListFragment.TITLE, fragmentTitle[1]);
        friendListFragment.setArguments(bundle);
        mTabs.add(friendListFragment);

        DiscoverFragment discoverFragment = new DiscoverFragment();
        bundle.clear();
        bundle.putString(discoverFragment.TITLE, fragmentTitle[2]);
        discoverFragment.setArguments(bundle);
        mTabs.add(discoverFragment);

        MeFragment meFragment = new MeFragment();
        bundle.clear();
        bundle.putString(meFragment.TITLE, fragmentTitle[3]);
        meFragment.setArguments(bundle);
        mTabs.add(meFragment);

        // 定义viewpager的适配器，使得可以滑动操作
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }
        };
    }

    private void initEvent()
    {
        mViwePager.setOnPageChangeListener(this);
        searchButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent searchActivity = new Intent(v.getContext(), SearchActivity.class);
                startActivity(searchActivity);
            }
        });
    }

    /**
     * 点击tab标签
     * 
     * @param v
     */
    public void clickTab(View v)
    {
        resetOtherTabs();

        switch (v.getId()) {
            case R.id.id_indicator_one:
                tabIndicators.get(0).setIconAlpha(1.0f);
                mViwePager.setCurrentItem(0, false);
                break;
            case R.id.id_indicator_two:
                tabIndicators.get(1).setIconAlpha(1.0f);
                mViwePager.setCurrentItem(1, false);
                break;
            case R.id.id_indicator_three:
                tabIndicators.get(2).setIconAlpha(1.0f);
                mViwePager.setCurrentItem(2, false);
                break;
            case R.id.id_indicator_four:
                tabIndicators.get(3).setIconAlpha(1.0f);
                mViwePager.setCurrentItem(3, false);
                break;
            default:
                break;
        }
    }

    /**
     * 重置其他的View的标签
     * 
     */

    public void resetOtherTabs()
    {
        for (int i = 0; i < tabIndicators.size(); i++) {
            tabIndicators.get(i).setIconAlpha(0);
        }
    }

    public void onpopupmenu(View button) {
        pop = new PopupMenu(this, button);
        pop.getMenuInflater().inflate(R.menu.more_popupmenu, pop.getMenu());
        pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem arg0) {

                switch (arg0.getItemId()) {
                    case R.id.item1:

                        break;
                    case R.id.item2:

                        break;
                    case R.id.item3:

                        break;
                    case R.id.item4:

                        break;
                    default:
                        break;
                }

                return false;
            }
        });
        pop.show();
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Log.e("TAG", "position = " + position + " ,positionOffset =  "+ positionOffset);
        if (positionOffset > 0) {
            Log.d("pageScrolledPosition", String.valueOf(position));
            ChangeIconColor left = tabIndicators.get(position);
            ChangeIconColor right = tabIndicators.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int arg0) {

    }

    public void onClick(DialogInterface arg0, int arg1) {

    }

    @Override
    public void onClick(View v) {
        clickTab(v);
    }

}
