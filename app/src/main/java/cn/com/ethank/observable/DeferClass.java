package cn.com.ethank.observable;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import cn.com.ethank.BaseActiivty;
import cn.com.ethank.R;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Created by dddd on 2016/6/6.
 */
public class DeferClass extends BaseActiivty{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        final Observable<Long> deferObserver=deferObserver();
        final Observable<Long> justObserver=justObserver();
        findViewById(R.id.ll_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("current", "" + System.currentTimeMillis());
                deferObserver.subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.e("def", "" + aLong);
                    }
                });
                justObserver.subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.e("just", "" + aLong);
                    }
                });
            }
        });
    }


    private Observable<Long> deferObserver() {
        return Observable.defer(new Func0<Observable<Long>>() {
            @Override
            public Observable<Long> call() {
                return  Observable.just(System.currentTimeMillis());
            }
        });
    }

    private Observable<Long> justObserver() {
        return Observable.just(System.currentTimeMillis());
    }
}
