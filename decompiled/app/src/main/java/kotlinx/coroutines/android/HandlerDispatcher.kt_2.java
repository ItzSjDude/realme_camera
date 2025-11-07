package kotlinx.coroutines.android;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class HandlerDispatcher.kt_2 implements kotlinx.coroutines.internal.MainDispatcherFactory.kt {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public java.lang.String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be_renamed used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public /* bridge */ /* synthetic */ kotlinx.coroutines.bf_renamed createDispatcher(java.util.List list) {
        return createDispatcher((java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory.kt>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public kotlinx.coroutines.android.a_renamed createDispatcher(java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory.kt> list) {
        return new kotlinx.coroutines.android.a_renamed(kotlinx.coroutines.android.c_renamed.a_renamed(android.os.Looper.getMainLooper(), true), null, 2, null);
    }
}
