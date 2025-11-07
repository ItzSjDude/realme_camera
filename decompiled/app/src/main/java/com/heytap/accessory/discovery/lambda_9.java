package com.heytap.accessory.discovery;

import java.util.function.Consumer;

/* compiled from: lambda */
/* renamed from: com.heytap.accessory.discovery.-$$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8 implements Consumer {
    public static final /* synthetic */ $$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8 INSTANCE = new $$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8();

    private /* synthetic */ $$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((IManagerCallback) obj).onReleased();
    }
}
