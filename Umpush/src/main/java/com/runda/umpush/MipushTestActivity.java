package com.runda.umpush;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.umeng.message.UmengNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

public class MipushTestActivity extends UmengNotifyClickActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mipush_test);
    }

    @Override
    public void onMessage(Intent intent) {
        super.onMessage(intent);  //此方法必须调用，否则无法统计打开数
        String body = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        Log.e(TAG, body);
    }
}
