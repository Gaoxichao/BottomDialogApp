package com.example.administrator.bottomdialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowBottomDialogAct extends AppCompatActivity {
    private Button showBtn;

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
        DialogUtil.showBottomDialog(ShowBottomDialogAct.this, R.id.activity_show_bottom_dialog, new BottomDialogOnclickListener() {
            @Override
            public void onPositiveClick(String contentStr, BottomDialogView dialogView) {
                dialogView.dismiss();
            }
        });
    }

}
