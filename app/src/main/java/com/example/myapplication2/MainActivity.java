package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    TextView textview_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //定位textview_1
        textview_1=(TextView)findViewById(R.id.textview_1);

        //添加点击监听器
        textview_1.setOnClickListener(new TextView.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //设置text
                        textview_1.setText("欢迎你，小明");
                        //控制台打印
                        Log.e("textview_welcome","我被点击了");
                    }
                });
    }




    public void test_1(View view) {
        textview_1=(TextView)findViewById(R.id.textview_1);
        textview_1.setText("123456789");

        Toast.makeText(this, "恭喜，通过", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"这是xml方式指定的Button响应",Toast.LENGTH_LONG).show();
    }

    public void transfer(View view) {
        Intent intent =new Intent(); //新建Intent对象
        intent.setClass(MainActivity.this,testapplication2.class);
        startActivityForResult(intent,0);   //返回前一页

    }

}
