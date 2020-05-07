package com.example.android0409;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android0409.fragment.FindFragment;
import com.example.android0409.fragment.FriendFragment;
import com.example.android0409.fragment.MyFragment;
import com.example.android0409.fragment.WeChatFragment;

import java.lang.reflect.Method;


public class FragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        ImageView i1 = findViewById(R.id.w001);
        ImageView i2 = findViewById(R.id.w002);
        ImageView i3 = findViewById(R.id.w003);
        ImageView i4 = findViewById(R.id.w004);
        i1.setOnClickListener(a);
        i2.setOnClickListener(a);
        i3.setOnClickListener(a);
        i4.setOnClickListener(a);

    }

    View.OnClickListener a = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.w001:
                    f = new WeChatFragment();
                    break;
                case R.id.w002:
                    f = new FriendFragment();
                    break;
                case R.id.w003:
                    f = new FindFragment();
                    break;
                case R.id.w004:
                    f = new MyFragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment, f);
            ft.commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      /*  menu.add("添加好友");
        menu.add("打开扫一扫");
        menu.add("收付款");
        menu.add(1,2,2,"999");
        menu.add("e");
        SubMenu subMenu  = menu.addSubMenu("子菜单");
        subMenu.add("a");
        subMenu.add("添加好友");
        subMenu.add("打开扫一扫");
        subMenu.add("收付款");
        subMenu.add("d");
        subMenu.add("e");*/

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        menu.add("这是扫一扫噢").setIcon(R.drawable.scan);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Toast.makeText(FragmentActivity.this,item.getTitle()
                +"被点击"+item.getItemId(),Toast.LENGTH_SHORT).show();
//        switch (item.getItemId()){
//            case 1:
//        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if ("添加朋友".equals(item.getTitle())){

            Intent intent = new Intent(FragmentActivity.this, ListActivity.class);
            startActivity(intent);

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("bbb");
        menu.add("ccc");
        menu.add("999");
        menu.add("888");


        super.onCreateContextMenu(menu, v, menuInfo);
    }
};