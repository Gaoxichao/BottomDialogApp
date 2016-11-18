package com.example.administrator.bottomdialogapp;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class ShowBottomDialogAct extends AppCompatActivity {
    private Button showBtn;
    private BottomDialogView menuWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bottom_dialog);
        showBtn = (Button) findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private void showDialog() {
        menuWindow = new BottomDialogView(ShowBottomDialogAct.this, itemsOnClick);
        //设置窗口显示在parent布局的位置并显示
        menuWindow.showAtLocation(ShowBottomDialogAct.this.findViewById(R.id.activity_show_bottom_dialog), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.payPassEt:
                    Log.e("adf", "sddfs");
                    break;
                case R.id.cancelBtn:
                    menuWindow.dismiss();
                    break;
                case R.id.confirmBtn:
                    menuWindow.dismiss();
                    //doSomething()
                    break;
                default:
                    break;
            }


        }

    };


    @Override
    protected void onDestroy() {
        if (menuWindow != null) {
            menuWindow = null;
        }
        super.onDestroy();
    }
}
