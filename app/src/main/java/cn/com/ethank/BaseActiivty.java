package cn.com.ethank;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by dddd on 2016/6/6.
 */
public class BaseActiivty extends RxAppCompatActivity {
    protected String TAG = this.getClass().getName();
    public static final String temp = "";

    public <T> void toActiivty(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

}
