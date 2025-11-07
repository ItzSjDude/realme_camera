package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher.kt;

/* compiled from: MainDispatcherFactory.kt.kt */
/* loaded from: classes2.dex */
public interface MainDispatcherFactory.kt {
    MainCoroutineDispatcher.kt createDispatcher(List<? extends MainDispatcherFactory.kt> list);

    int getLoadPriority();

    String hintOnError();
}
