package com.example.administrator.bottomdialogapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class BottomDialogView extends PopupWindow {
    private View mMenuView;
    private LinearLayout payPassModuleLl;
    private EditText payPassEt;
    private Button cancelBtn, confirmBtn;
    private ImageView backDialogIv;

    public BottomDialogView(Activity context, OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.dialog, null);
        backDialogIv = (ImageView)mMenuView.findViewById(R.id.backDialogIv);
        payPassModuleLl = (LinearLayout) mMenuView.findViewById(R.id.payPassModuleLl);
        payPassEt = (EditText) mMenuView.findViewById(R.id.payPassEt);
        cancelBtn = (Button) mMenuView.findViewById(R.id.cancelBtn);
        confirmBtn = (Button) mMenuView.findViewById(R.id.confirmBtn);

        backDialogIv.setOnClickListener(itemsOnClick);
        payPassEt.setOnClickListener(itemsOnClick);
        cancelBtn.setOnClickListener(itemsOnClick);
        confirmBtn.setOnClickListener(itemsOnClick);

        this.setContentView(mMenuView);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.MATCH_PARENT);
        this.setFocusable(true);

        this.setAnimationStyle(R.style.DialogShowStyle); //设置SelectPicPopupWindow弹出窗体动画效果
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);

        mMenuView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) { //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
//                        dismiss();
                    }
                }
                return true;
            }
        });

    }

}