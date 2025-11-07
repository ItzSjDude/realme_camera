package kotlinx.coroutines.internal;

/* compiled from: MainDispatcherFactory.kt.kt */
/* loaded from: classes2.dex */
public interface MainDispatcherFactory.kt {
    kotlinx.coroutines.bf_renamed createDispatcher(java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory.kt> list);

    int getLoadPriority();

    java.lang.String hintOnError();
}
