package com.guhecloud.rudez.npmarket.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;


/**
 * Created by Chanin on 2017-08-17.
 */

public class ActivityUtil {


    public static void startActivity(Activity activity, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }

    public static void startActivity(Context activity, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivityForResult(intent, requestCode, options.toBundle());
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

}
