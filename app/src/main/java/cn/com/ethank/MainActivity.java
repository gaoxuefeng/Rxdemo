package cn.com.ethank;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends BaseActiivty {

    private TextView tv_rx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
        tv_rx = (TextView) findViewById(R.id.tv_rx);
//        BaseDemo baseDemo = new Demo6();
//        Observable.interval(1, TimeUnit.SECONDS).compose(this.bindUntilEvent(ActivityEvent.STOP)).subscribe(new Action1<Object>() {
//            @Override
//            public void call(Object o) {
//                Log.i("demo",""+o)   ;     }
//        });
        tv_rx.setText("延时开始" + System.currentTimeMillis());
        Observable.empty().delaySubscription(5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {

            }
        });
//        baseDemo.setView(tv_rx);
//        baseDemo.run();


//        RxView.clicks(findViewById(R.id.ll_content)).throttleFirst(10000, TimeUnit.MILLISECONDS).subscribe(new Action1<Void>() {
//            @Override
//            public void call(Void aVoid) {
//                ToastUtil.show("点击了");
//                toActiivty(AboutRxJavaActiivty.class);
//            }
//        });

    }

}
