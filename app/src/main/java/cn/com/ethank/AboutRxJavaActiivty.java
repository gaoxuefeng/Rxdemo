package cn.com.ethank;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import rx.Observable;


public class AboutRxJavaActiivty extends BaseActiivty {

    private Observable observable;
    private LinearLayout ll_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_rx_java);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        ll_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActiivty(CodeTestActivity.class);
            }
        });

    }


}
