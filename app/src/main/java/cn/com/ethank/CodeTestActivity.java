package cn.com.ethank;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func0;

public class CodeTestActivity extends BaseActiivty {

    private TextView tv_code;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_test);
        for (int i = 0; i < 100; i++) {
            arrayList.add("aaaaa" + i);
        }
        Observable.interval(1000, TimeUnit.MILLISECONDS);//间隔多久出发一次
        tv_code = (TextView) findViewById(R.id.tv_code);
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                //执行局提的操作
//            }
//        });
//        observable.create(new AsyncOnSubscribe<String, String>() {
//            @Override
//            protected String generateState() {
//                Log.i(TAG, "aaa" + Thread.currentThread());
//                return "aaa";
//            }
//
//            @Override
//            protected String next(String state, long requested, Observer<Observable<? extends String>> observer) {
//                Log.i(TAG, "bbb" + Thread.currentThread());
//                return "bbb";
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.i(TAG + "NEXT", "完成");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i(TAG, e.getMessage());
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i(TAG + "NEXT", s);
//            }
//        });
//        Observable.just("aaa", "aaaa", "bbbb").subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i(TAG + "NEXT", s);
//            }
//        });
//        Observable<String> o1 = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("o1");
//                subscriber.onNext("o2");
//                subscriber.onNext("o3");
//            }
//        });
//        Observable<String> o2 = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("o4");
//                subscriber.onNext("o5");
//                subscriber.onNext("o6");
//            }
//        });
//        Observable.combineLatest(o1, o2, new Func2<String, String, String>() {
//            @Override public String call(String s, String s2) {
//                Log.e("combine --- >", "s = " + s + " | s2 = " + s2);
//                return s + s2;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Log.e("onCompleted --- >", "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("onError --- >", "onError");
//
//            }
//
//            @Override
//            public void onNext(String o) {
//                Log.e("onNext --- >", o);
//            }
//        });

    }



}
