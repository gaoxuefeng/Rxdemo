package cn.com.ethank;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;



/**
 * Toast工具类
 */
public class ToastUtil {
    static Toast toast;
    private static Handler handler;

    public static void show(String text) {
        //在子线程中调用是禁止的

        try {
            if (TextUtils.isEmpty(text)) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (toast == null) {
                    toast = Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(text);
                }
                toast.show();
                if (handler == null) {
                    initHandler();
                }
            } else if (handler != null) {
                //不是主线程
                Message message = new Message();
                message.obj = text;
                handler.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(String text, Boolean LENGTH_LONG) {
        try {

            if (toast == null) {
                toast = Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_LONG);
            } else {
                toast.setText(text);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(int resId, Boolean LENGTH_LONG) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getInstance(), resId, Toast.LENGTH_LONG);
        } else {
            toast.setText(resId);
        }
        toast.show();
    }

    public static void show(int resId) {
        String text = BaseApplication.getInstance().getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            show(text);
        }
    }

    public void dismisstoast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    public static void showTest(String text) {
        if (AppSettingUtil.isDebug && !TextUtils.isEmpty(text)) {
            show("测试:" + text);
        }
    }

    /**
     * 程序入口需要在主线程中初始化handler
     */
    public static void initHandler() {
        try {
            if (handler == null) {
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg != null && msg.obj != null && msg.obj instanceof String) {
                            show(msg.obj.toString());
                        }

                    }
                };
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
