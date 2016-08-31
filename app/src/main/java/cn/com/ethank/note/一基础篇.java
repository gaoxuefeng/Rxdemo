package cn.com.ethank.note;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * http://blog.csdn.net/lzyzsd/article/details/41833541
 * 深入浅出RxJava（一：基础篇）
 * Created by dddd on 2016/6/1.
 */
public class 一基础篇 extends AppCompatActivity {
    private String Tag = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable<String> observable2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("我是高雪峰");
                subscriber.onCompleted();
            }
        });
        //执行者
        Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("fffff ");
                subscriber.onCompleted();
            }
        });

        //观察者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(Tag, s);
            }
        };
        //这两个是对应的
        Observable<String> onNextAction = Observable.just("fuck");
        Action1<String> stringAction1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(Tag + "Action1", s);
            }
        };
        observable1.subscribe(subscriber);
        observable2.subscribe(subscriber);
        onNextAction.subscribe(stringAction1);
        //最简单的方法
        Observable.just("你是谁").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(Tag + "最简单", s);
            }
        });
        Observable.just("你试试").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "duibudui";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(Tag + "最简单", s);
            }
        });
        //map中的两个参数前面的代表入参,后面的代表出参
        Observable.just("你试试").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.hashCode();
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(Tag + "最简单", Integer.toString(integer));
            }
        });
        Observable.just("你试试").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.hashCode();
            }
        }).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "haha";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(Tag + "最简单",s);
            }
        });
    }

}
