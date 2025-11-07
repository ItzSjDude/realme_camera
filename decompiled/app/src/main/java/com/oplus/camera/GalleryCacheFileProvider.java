package com.oplus.camera;

/* loaded from: classes2.dex */
public class GalleryCacheFileProvider extends androidx.core.a_renamed.b_renamed {
    @Override // androidx.core.a_renamed.b_renamed, android.content.ContentProvider
    public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo providerInfo) {
        try {
            super.attachInfo(context, providerInfo);
        } catch (java.lang.IllegalArgumentException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("GalleryCacheFileProvider", "attachInfo error, authority: " + providerInfo.authority, e_renamed);
        }
    }
}
