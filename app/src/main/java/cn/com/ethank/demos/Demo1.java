package cn.com.ethank.demos;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;

/**
 * RxJava的基本用法和简化的Observable
 * Created by dddd on 2016/6/7.
 */
public class Demo1 extends BaseDemo {

    @Override
    public void run() {

//        //观察得到的
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        });


        //用户，订户 ; 预约者; 签署者
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                appand(TAG+"com");
                Log.i(TAG, "com");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG + "E", e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, integer + "");
                setText(TAG+integer);

            }
        };
        //把订阅者跟观察者关联起来
        observable.subscribe(subscriber);
    }
    //拓展
    //    Observable.just(1);
    //defer跟just的区别
    //    Observable<Integer> observable=Observable.defer(new Func0<Observable<Integer>>() {
    //        @Override
    //        public Observable<Integer> call() {
    //            return Observable.just(1);
    //        }
    //    });

    //怎么样触发onError()
//    Observable<Integer> observable = Observable.just("dd").map(new Func1<String, Integer>() {
//        @Override
//        public Integer call(String s) {
//            return Integer.parseInt(s);
//        }
//    });

}
