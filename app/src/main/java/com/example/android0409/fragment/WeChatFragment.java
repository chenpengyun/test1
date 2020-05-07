package com.example.android0409.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.android0409.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeChatFragment extends Fragment {

    private ListView list;
    private String[] names = new String[] { "张三", "李四", "王五", "赵六", "刘七", "孙八"};
    private String[] descs = new String[] { "今天晚上几点在哪集合？", "今天晚上几点在哪集合？",
            "今天晚上几点在哪集合？", "不知道","不知道","不知道"};
    private String[] descs2 = new String[] { "下午3:29","下午6:35", "下午7:05","下午7：18","下午:7:35","晚上8：28"};
    private int[] descs3 = new int[] { R.drawable.n02, R.drawable.n10,
            R.drawable.n01, R.drawable.n07, R.drawable.n03, R.drawable.n01 };
    private int[] imageIds = new int[] { R.drawable.p0, R.drawable.p1, R.drawable.p2,
            R.drawable.p3, R.drawable.pkq, R.drawable.pkq1};


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wechetlistview,null);
        list = (ListView) view.findViewById(R.id.mylist);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItem.put("desc", descs[i]);
            listItem.put("desc2", descs2[i]);
            listItem.put("desc3", descs3[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),listItems,R.layout.wclvborder,new String[]{
                "personName", "header", "desc", "desc2", "desc3" },
                new int[] {R.id.name,R.id.header,R.id.desc,R.id.desc2,R.id.desc3 });
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
/**这里就是实现界面跳转以及数据传递的地方，具体代码参考我以前的数据传递*/
                Toast.makeText(getActivity(),names[position]+"被点击了",Toast.LENGTH_LONG).show();
            }
        });return view;
    }
}
