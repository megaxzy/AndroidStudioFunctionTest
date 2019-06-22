package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class testapplication2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testapplication2);
    }

    public void write(View view){
        EditText edit_text_write;
        edit_text_write=(EditText)findViewById(R.id.editText_write);
        String KEY_NAME="text_file";
        SharedPreferences shared_pref=this.getSharedPreferences(KEY_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=shared_pref.edit();
        editor.putString(KEY_NAME,edit_text_write.getText().toString());
        editor.commit();
        Toast.makeText(this, "恭喜，写入成功", Toast.LENGTH_SHORT).show();
    }
    public void read(View view){
        EditText edit_text_read;
        edit_text_read=(EditText)findViewById(R.id.editText_read);
        String KEY_NAME="text_file";
        SharedPreferences shared_pref=getSharedPreferences(KEY_NAME,Context.MODE_PRIVATE);
        edit_text_read.setText(shared_pref.getString(KEY_NAME,"none"));
        Toast.makeText(this, "恭喜，读取成功", Toast.LENGTH_SHORT).show();
    }

    public void write2(View view){
        EditText edit_text_write;
        edit_text_write=(EditText)findViewById(R.id.editText_write);
        SharedPreferences shared_pref=this.getSharedPreferences("data",Context.MODE_PRIVATE);  //建立editor
        SharedPreferences.Editor editor=shared_pref.edit();  //建立editor
        editor.remove("name");  //remove
        editor.clear();  //clear
        editor.putInt("age",20);
        editor.putString("name","Tom");
        editor.putString("name2",edit_text_write.getText().toString());
        editor.putBoolean("boy",true);
        editor.commit();//相当于保存
        Toast.makeText(this, "恭喜，写入成功", Toast.LENGTH_SHORT).show();
    }

    public void read2(View view){
        EditText edit_text_read;
        EditText edit_text_write;
        edit_text_read=(EditText)findViewById(R.id.editText_read);
        edit_text_write=(EditText)findViewById(R.id.editText_write);
        SharedPreferences shared_pref=getSharedPreferences("data",Context.MODE_PRIVATE);
        edit_text_write.setText(shared_pref.getString("name2","none"));
        try{
            edit_text_read.setText(shared_pref.getInt("age",0));  //TODO 出错
        }
        catch (Exception e){
            System.out.println("testEx,catch exception");
        }
        Toast.makeText(this, "恭喜，读取成功", Toast.LENGTH_SHORT).show();
    }

    public void write3(View view){
        EditText edit_text_write;
        edit_text_write=(EditText)findViewById(R.id.editText_write);
        SharedPreferences shared_pref=this.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=shared_pref.edit();
        editor.putInt("age",20);
        editor.commit();
        Toast.makeText(this, "恭喜，写入成功", Toast.LENGTH_SHORT).show();
    }

    public void read3(View view){
        EditText edit_text_write;
        edit_text_write=(EditText)findViewById(R.id.editText_write);
        SharedPreferences shared_pref=getSharedPreferences("data",Context.MODE_PRIVATE);
        try{
            //edit_text_write.setText(shared_pref.getInt("age",-1));  //TODO 出错
            int x=shared_pref.getInt("age",-1);
            String y= Integer.toString(x);
            edit_text_write.setText(y);
        }
        catch (Exception e){
            System.out.println("Catch Exception");
        }
        Toast.makeText(this, "恭喜，读取成功", Toast.LENGTH_SHORT).show();
    }

}
