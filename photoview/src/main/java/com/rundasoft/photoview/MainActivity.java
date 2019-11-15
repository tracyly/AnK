package com.rundasoft.photoview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import uk.co.senab.photoview.PhotoView;


/**
 * Created by Kongdq
 * @date 2019/11/15
 * Description:
 *  1.根部gradle添加maven
 *  2.module的gradle添加依赖
 *  3.和ImageView一样用就ok
 *
 *  注意=====================
 *  用本地类库没问题 ,但是用gradle依赖图片无法缩小只能放大...
 */
public class MainActivity extends AppCompatActivity {

    String imgUri = "http://cdn.liziyd.com/8BA31A9A7277496FB29C4DD422AEFE45_聂卫平围棋道场名师课堂-进阶课-专业自主-500-296.jpg";

    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoView = findViewById(R.id.photoView);

        photoView.setZoomable(true);


//        Glide加载https注意不一样

        Glide.with(this)
                .load(imgUri)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(photoView);
        photoView.setAllowParentInterceptOnEdge(false);

//        photoView.setImageDrawable(getResources().getDrawable(R.drawable.newp));
    }

}
