package com.runda.umpush;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

/**
 * @Description:
 * @Author: An_K
 * @CreateDate: 2020/2/26 10:16
 * @Version: 1.0
 */
public class MyApplication extends Application {

    private String TAG = getClass().getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        regintUMpush();
        registHWpush();
        registerMipush();
    }



    private void regintUMpush() {

        UMConfigure.init(this, "5e560c96570df327780000e9", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "20ed7e167eaa6cba5ed9e7bb6d7cf7e4");
//      获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
//      注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG,"注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });
    }

    private void registHWpush() {
        HuaWeiRegister.register(this);
    }

    private void registerMipush() {
        MiPushRegistar.register(this,"2882303761518329975","5501832979975");
    }

}
