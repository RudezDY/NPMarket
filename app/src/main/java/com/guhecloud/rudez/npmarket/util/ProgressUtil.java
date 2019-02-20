package com.guhecloud.rudez.npmarket.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Chanin on 2017-10-30.
 */

public class ProgressUtil {


    public static ProgressDialog create(Context context,String msg){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        return progressDialog;
    }



}
