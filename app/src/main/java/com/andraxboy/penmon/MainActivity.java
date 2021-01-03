package com.andraxboy.penmon;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn4 = (Button) findViewById(R.id.twodisable);
        Button btn2 = (Button) findViewById(R.id.onedisable);
        btn2.setEnabled(false);
        btn4.setEnabled(false);
        copyiw();
        copysh();
        myDialog = new Dialog(this);
    }
    final String path = "/data/data/com.andraxboy.penmon/cache/";
    final String Name = "iwpriv";
    public void copyiw(){
        try {
            OutputStream myOutput = new FileOutputStream(path + Name);
            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open("iwpriv");
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showpopup(View v) {
        myDialog.setContentView(R.layout.popup);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    public void showpopup3(View v) {
        myDialog.setContentView(R.layout.popup3);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void showpopup2(View v) {
        myDialog.setContentView(R.layout.popup2);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    final String path2 = "/data/data/com.andraxboy.penmon/cache/";
    final String Name2 = "on.sh";
    public void copysh(){
        try {
            OutputStream myOutput = new FileOutputStream(path2 + Name2);
            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open("on.sh");
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startone(View view) {
        try{Runtime.getRuntime().exec("su -c ip link set wlan0 down");
            Runtime.getRuntime().exec("su -c echo 4 > /sys/module/wlan/parameters/con_mode");
            Runtime.getRuntime().exec("su -c ip link set wlan0 up");
            Button btn1 = (Button) findViewById(R.id.oneenable);
            Button btn2 = (Button) findViewById(R.id.onedisable);
            Button btn3 = (Button) findViewById(R.id.twoenable);
            Button btn4 = (Button) findViewById(R.id.twodisable);
            btn1.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn2.setEnabled(true);

        }
        catch (IOException e) {
            e.printStackTrace();
        }}
    public void offone(View view) {
        try{Runtime.getRuntime().exec("su -c ip link set wlan0 down;;su -c ip link set wlan0 up");
            Runtime.getRuntime().exec("su -c echo 0 > /sys/module/wlan/parameters/con_mode");
            Runtime.getRuntime().exec("su -c svc wifi enable");
            Button btn1 = (Button) findViewById(R.id.oneenable);
            Button btn2 = (Button) findViewById(R.id.onedisable);
            Button btn3 = (Button) findViewById(R.id.twoenable);
            Button btn4 = (Button) findViewById(R.id.twodisable);
            btn1.setEnabled(true);
            btn3.setEnabled(true);
            btn2.setEnabled(false);
            btn4.setEnabled(false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
    public void starttwo(View view) {
        try{
            Runtime.getRuntime().exec("chmod +x /data/data/com.andraxboy.penmon/cache/on.sh");
            Runtime.getRuntime().exec("chmod +x /data/data/com.andraxboy.penmon/cache/iwpriv");
            Runtime.getRuntime().exec("su -c /data/data/com.andraxboy.penmon/cache/on.sh");
            Button btn1 = (Button) findViewById(R.id.oneenable);
            Button btn2 = (Button) findViewById(R.id.onedisable);
            Button btn3 = (Button) findViewById(R.id.twoenable);
            Button btn4 = (Button) findViewById(R.id.twodisable);
            btn3.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn4.setEnabled(true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
