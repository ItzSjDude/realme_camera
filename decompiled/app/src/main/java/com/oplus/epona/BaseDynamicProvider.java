package com.oplus.epona;

/* loaded from: classes2.dex */
public abstract class BaseDynamicProvider implements com.oplus.epona.DynamicProvider {
    private final java.lang.String mPackageName;

    protected abstract java.lang.String getProviderName();

    public BaseDynamicProvider(java.lang.String str) {
        this.mPackageName = str;
    }

    public BaseDynamicProvider(android.content.Context context) {
        this(context.getPackageName());
    }

    @Override // com.oplus.epona.DynamicProvider
    public java.lang.String getName() {
        return buildName(getProviderName());
    }

    private java.lang.String buildName(java.lang.String str) {
        return this.mPackageName + "." + str;
    }
}
