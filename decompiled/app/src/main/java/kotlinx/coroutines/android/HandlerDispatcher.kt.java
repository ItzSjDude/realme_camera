package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import p061c.Result.kt;
import p061c.Result.kt_4;

/* compiled from: HandlerDispatcher.kt */
/* renamed from: kotlinx.coroutines.android.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class HandlerDispatcher.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final HandlerDispatcher.kt_4 f24585a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Handler m25642a(Looper looper, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            if (objInvoke != null) {
                return (Handler) objInvoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    static {
        Object objM26270constructorimpl;
        try {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(new HandlerDispatcher.kt_2(m25642a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
        }
        f24585a = (HandlerDispatcher.kt_4) (Result.kt.m26276isFailureimpl(objM26270constructorimpl) ? null : objM26270constructorimpl);
    }
}
