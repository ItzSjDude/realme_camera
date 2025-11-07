package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher.kt;
import kotlinx.coroutines.internal.MainDispatcherFactory.kt;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class HandlerDispatcher.kt_3 implements MainDispatcherFactory.kt {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public /* bridge */ /* synthetic */ MainCoroutineDispatcher.kt createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory.kt>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory.kt
    public HandlerDispatcher.kt_2 createDispatcher(List<? extends MainDispatcherFactory.kt> list) {
        return new HandlerDispatcher.kt_2(HandlerDispatcher.kt.m25642a(Looper.getMainLooper(), true), null, 2, null);
    }
}
