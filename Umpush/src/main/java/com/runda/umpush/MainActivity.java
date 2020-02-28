package com.runda.umpush;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


/**
 *
 * @Description:    友盟推送
 *      关于角标问题:
 *          1.小米推送的离线消息是自带角标的
 *          2.华为推送的离线小时角标是服务端发送给系统桌面的
 * @Author:         An_K
 * @CreateDate:     2020/2/26 14:16
 * @Version:        1.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerXgPush(View view) {

    }
}
