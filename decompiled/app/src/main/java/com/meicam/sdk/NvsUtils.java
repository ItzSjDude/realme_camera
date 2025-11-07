package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsUtils {
    private static final java.lang.String TAG = "Meicam";

    public static boolean isMainThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    public static boolean checkFunctionInMainThread() {
        if (isMainThread()) {
            return true;
        }
        java.lang.String methodName = getMethodName(4);
        if (android.text.TextUtils.isEmpty(methodName)) {
            return false;
        }
        java.lang.String methodName2 = getMethodName(5);
        android.util.Log.w_renamed(TAG, "Main Thread Checker:\"" + methodName + "\" API called on_renamed a_renamed background thread.");
        if (!android.text.TextUtils.isEmpty(methodName2)) {
            android.util.Log.w_renamed(TAG, "Invoking method: \"" + methodName2 + "\".");
        }
        return false;
    }

    public static java.lang.String getMethodName(int i_renamed) {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i_renamed || i_renamed < 0) {
            return null;
        }
        return stackTrace[i_renamed].getMethodName();
    }
}
