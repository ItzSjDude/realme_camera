package com.oplus.epona;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class BaseDynamicProvider implements DynamicProvider {
    private final String mPackageName;

    protected abstract String getProviderName();

    public BaseDynamicProvider(String str) {
        this.mPackageName = str;
    }

    public BaseDynamicProvider(Context context) {
        this(context.getPackageName());
    }

    @Override // com.oplus.epona.DynamicProvider
    public String getName() {
        return buildName(getProviderName());
    }

    private String buildName(String str) {
        return this.mPackageName + "." + str;
    }
}
