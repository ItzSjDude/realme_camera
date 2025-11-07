package com.heytap.accessory.discovery;

import java.util.function.Consumer;

/* compiled from: lambda */
/* renamed from: com.heytap.accessory.discovery.-$$Lambda$jao6ooJJhKIvmFGirPbP16Y1-xA, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA implements Consumer {
    public static final /* synthetic */ $$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA INSTANCE = new $$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA();

    private /* synthetic */ $$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((IManagerCallback) obj).onInited();
    }
}
