package cn.com.ethank.demos;

import android.util.Log;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by dddd on 2016/6/7.
 */
public class Demo4 extends BaseDemo {
    @Override
    public void run() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i + "jjj");
        Observable.from(list)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + "来吧";
                    }
                })
                .take(10)//只截取5条
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.contains("5");
                    }
                })
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {

                        return Observable.just(s).filter(new Func1<String, Boolean>() {
                            @Override
                            public Boolean call(String s) {
                                return s.startsWith("5");
                            }
                        });

                    }
                })
                //在输出之前做的事,也可以作为输出用
                .doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {
        appand("doOnNext");
            }
        })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i(TAG, s);
                        appand(s);
                    }
                });

    }

}
