package cn.com.ethank.demos;

import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Observable和subscribe联合起来简写
 * Created by dddd on 2016/6/7.
 */
public class Demo3 extends BaseDemo {
    @Override
    public void run() {
        setText("");
        Observable.just("1", "2", "dd", "8").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(
                        new Action1<Integer>() {

            @Override
            public void call(Integer integer) {
                Log.i(TAG, integer + "");

            }
        }
        );

    }
}
