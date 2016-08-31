package cn.com.ethank.demos;

import rx.functions.Action1;

/**
 * Created by dddd on 2016/6/13.
 */
public class Demo6 extends BaseDemo{
    @Override
    public void run() {
////        Observable<Long> aLongObservable = Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread().
////        aLongObservable.compose(LifecycleTransformer.)
////        public void call (Long aLong){
////
////        }
////    }
//
//    );
    Action1<Long> a = new Action1<Long>() {
            @Override
            public void call(Long aLong) {

            }
        };
    }
}
