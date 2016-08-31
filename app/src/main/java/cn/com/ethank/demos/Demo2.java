package cn.com.ethank.demos;

import android.util.Log;

import rx.Observable;
import rx.functions.Action1;

/**
 * 简化的subscribe
 * Created by dddd on 2016/6/7.
 */
public class Demo2 extends BaseDemo {
    @Override
    public void run() {

        Observable<String> observable = Observable.just("车来了");
//Observable.empty().subscribe(new Action0() {
//    @Override
//    public void call() {
//
//    }
//});
//        //next只关注onNext,不关心结果
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, s);
                setText(s);
            }
        };


        observable.subscribe(onNextAction);
    }
//    //error
//    Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//        @Override
//        public void call(Throwable throwable) {
//
//        }
//    };
//    //完成
//    Action0 onComAction=new Action0() {
//        @Override
//        public void call() {
//
//        }
//    };
}
