package com.example.liyanju.androiddemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liyanju.androiddemo.asynBinder.AsynBinderActivity;
import com.example.liyanju.androiddemo.cootek.CootekApiActivity;
import com.example.liyanju.androiddemo.customview.BezierActivity;
import com.example.liyanju.androiddemo.customview.DrawBitmapActivity;
import com.example.liyanju.androiddemo.customview.XFermodeActivity;
import com.example.liyanju.androiddemo.customview.coupondisplay.MyCouponDisplayActivity;
import com.example.liyanju.androiddemo.dianhuabang.DianhuaBangActivity;
import com.example.liyanju.androiddemo.input.InputActivity;
import com.example.liyanju.androiddemo.phone360.Phone360Activity;

public class MainActivity extends Activity {

    String items[] = {"binder异步回调", "input ", "CootekApiActivity",
            "Phone360Activity", "DianhuaBangActivity", "DrawBitmapActivity",
            "BezierActivity", "MyCouponDisplayActivity", "XFermodeActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.demo_listview);

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return items.length;
            }

            @Override
            public Object getItem(int position) {
                return items[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.demo_item, null);
                }
                TextView tv = (TextView)convertView.findViewById(R.id.item_demo_tv);
                tv.setText(items[position]);
                return convertView;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, AsynBinderActivity.class));
                        break;
                    case 1:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, InputActivity.class));
                        break;
                    case 2:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, CootekApiActivity.class));
                        break;
                    case 3:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, Phone360Activity.class));
                        break;
                    case 4:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, DianhuaBangActivity.class));
                        break;
                    case 5:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, DrawBitmapActivity.class));
                        break;
                    case 6:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, BezierActivity.class));
                        break;
                    case 7:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, MyCouponDisplayActivity.class));
                        break;
                    case 8:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, XFermodeActivity.class));
                        break;
                }
            }
        });

    }
}
