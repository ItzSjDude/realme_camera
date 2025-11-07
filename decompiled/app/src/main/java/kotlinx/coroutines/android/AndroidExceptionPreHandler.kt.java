package kotlinx.coroutines.android;

import android.os.Build;
import androidx.annotation.Keep;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlinx.coroutines.CoroutineExceptionHandler.kt_2;
import p061c.p064c.CoroutineContextImpl.kt_2;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: AndroidExceptionPreHandler.kt.kt */
@Keep
/* loaded from: classes2.dex */
public final class AndroidExceptionPreHandler.kt extends CoroutineContextImpl.kt_2 implements CoroutineExceptionHandler.kt_2 {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler.kt() {
        super(CoroutineExceptionHandler.kt_2.f24546a);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler.kt_2
    public void handleException(CoroutineContext.kt_4 interfaceC0932g, Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            return;
        }
        Method methodPreHandler = preHandler();
        Object objInvoke = methodPreHandler != null ? methodPreHandler.invoke(null, new Object[0]) : null;
        if (!(objInvoke instanceof Thread.UncaughtExceptionHandler)) {
            objInvoke = null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) objInvoke;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
        }
    }
}
