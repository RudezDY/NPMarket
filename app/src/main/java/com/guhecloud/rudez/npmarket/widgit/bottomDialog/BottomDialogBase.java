package com.guhecloud.rudez.npmarket.widgit.bottomDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.guhecloud.rudez.npmarket.R;

/**
 * Created by homework on 2019/4/24.
 */

public abstract class BottomDialogBase  extends Dialog {
    public BottomDialogBase(Context context) {
        super(context);
        init();
    }

    protected void init(){
        Window win = this.getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        onCreate();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.BottomInAndOutStyle;
        lp.gravity = Gravity.BOTTOM;
        win.setAttributes(lp);
        win.setBackgroundDrawableResource(android.R.color.transparent);
    }
    protected void onCreate(){
        setContentView(getContentView());
        initViewAndData();
    }

    protected abstract int getContentView();
    protected abstract void initViewAndData();
}