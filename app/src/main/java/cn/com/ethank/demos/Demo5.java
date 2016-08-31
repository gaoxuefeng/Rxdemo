package cn.com.ethank.demos;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 线程的使用
 * Created by dddd on 2016/6/7.
 */
public class Demo5 extends BaseDemo {
    @Override
    public void run() {
//        Observable.just(getData())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        Log.i(TAG, "在这儿第一次" + Thread.currentThread());
//                        return s;
//                    }
//                })
//
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.i(TAG, "在这儿输出" + Thread.currentThread());
//                    }
//                });
       Observable.create(new Observable.OnSubscribe<String>() {
           @Override
           public void call(Subscriber<? super String> subscriber) {
               subscriber.onNext("是你啊");
               Log.i(TAG, "在这儿创建" + Thread.currentThread());
//               appand("在这儿创建");
           }
       })
               .observeOn(Schedulers.io())
               .subscribeOn(Schedulers.newThread())
               .map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                Log.i(TAG + "", "在这儿运行" + Thread.currentThread());
                return "";
            }
        })
               .subscribeOn(AndroidSchedulers.mainThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Action1<String>() {
                   @Override
                   public void call(String s) {
                       Log.i(TAG + "", "在这儿输出" + Thread.currentThread());
//                    appand(Thread.currentThread()+"");
                   }
               });
    }

    public String getData() {
        Log.i(TAG, "demo在这儿产生数据" + Thread.currentThread());
        return "在这儿";
    }
}
