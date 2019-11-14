package com.rundasoft.permissionsdispatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Kongdq
 * @date 2019/11/14
 * Description:
 *  1.gradle导包
 *  2.@RuntimePermissions
 *  3.rebuilt
 */

@RuntimePermissions
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_single).setOnClickListener(this);
        findViewById(R.id.button_multi).setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_single:
                MainActivityPermissionsDispatcher.singleNeedsPermissionWithPermissionCheck(this);
                break;
            case R.id.button_multi:
                MainActivityPermissionsDispatcher.multiNeedsPermissionWithPermissionCheck(this);
                break;
            default:
                break;
        }
    }



    //单个权限

    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    void singleNeedsPermission() {
        Toast.makeText(this, "单个权限申请通过", Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.READ_PHONE_STATE)
    void singleOnShowRationale(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("使用此功能需要读取手机状态储权限，下一步将继续请求权限")
                .setPositiveButton("下一步", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 继续执行请求
                        request.proceed();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 取消执行请求
                request.cancel();
            }
        })
                .show();
    }

    @OnPermissionDenied(Manifest.permission.READ_PHONE_STATE)
    void singleOnPermissionDenied() {
        Toast.makeText(this, "单个权限申请拒绝", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.READ_PHONE_STATE)
    void singleOnNeverAskAgain() {
        Toast.makeText(this, "单个权限申请拒绝并且设置不在询问", Toast.LENGTH_SHORT).show();
    }

    //多权限

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiNeedsPermission() {
        Toast.makeText(this, "多个权限申请通过", Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiOnShowRationale(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("使用此功能需要多个权限，下一步将继续请求权限")
                .setPositiveButton("下一步", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 继续执行请求
                        request.proceed();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 取消执行请求
                request.cancel();
            }
        })
                .show();
    }

    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiOnPermissionDenied() {
        Toast.makeText(this, "多个权限申请拒绝", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiOnNeverAskAgain() {
        Toast.makeText(this, "多个权限并且设置不再询问", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
        Log.e("TAG","requestCode=="+requestCode);
    }


}
