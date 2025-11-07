package kotlinx.coroutines.android;

/* compiled from: AndroidExceptionPreHandler.kt.kt */
@androidx.annotation.Keep
/* loaded from: classes2.dex */
public final class AndroidExceptionPreHandler.kt extends c_renamed.c_renamed.a_renamed implements kotlinx.coroutines.CoroutineExceptionHandler.kt_2 {
    private volatile java.lang.Object _preHandler;

    public AndroidExceptionPreHandler.kt() {
        super(kotlinx.coroutines.CoroutineExceptionHandler.kt_2.f7778a);
        this._preHandler = this;
    }

    private final java.lang.reflect.Method preHandler() {
        java.lang.Object obj = this._preHandler;
        if (obj != this) {
            return (java.lang.reflect.Method) obj;
        }
        java.lang.reflect.Method method = null;
        try {
            boolean z_renamed = false;
            java.lang.reflect.Method declaredMethod = java.lang.Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new java.lang.Class[0]);
            if (java.lang.reflect.Modifier.isPublic(declaredMethod.getModifiers())) {
                if (java.lang.reflect.Modifier.isStatic(declaredMethod.getModifiers())) {
                    z_renamed = true;
                }
            }
            if (z_renamed) {
                method = declaredMethod;
            }
        } catch (java.lang.Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler.kt_2
    public void handleException(c_renamed.c_renamed.g_renamed gVar, java.lang.Throwable th) {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            return;
        }
        java.lang.reflect.Method methodPreHandler = preHandler();
        java.lang.Object objInvoke = methodPreHandler != null ? methodPreHandler.invoke(null, new java.lang.Object[0]) : null;
        if (!(objInvoke instanceof java.lang.Thread.UncaughtExceptionHandler)) {
            objInvoke = null;
        }
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (java.lang.Thread.UncaughtExceptionHandler) objInvoke;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
        }
    }
}
