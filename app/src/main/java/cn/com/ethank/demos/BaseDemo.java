package cn.com.ethank.demos;

import android.widget.TextView;

/**
 * Created by dddd on 2016/6/7.
 */
public abstract class BaseDemo {
    protected String TAG = "demo";
    private TextView view;

    public abstract void run();
    public  void  setText(String str){
        if(view!=null&&str!=null){
            view.setText(str);
        }
    }
    public  void  appand(String str){
        if(view!=null&&str!=null){
            view.append("\n\r"+str);
        }
    }

    public void setView(TextView view) {
        this.view = view;
    }
}
