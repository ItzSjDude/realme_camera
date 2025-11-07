package com.oplus.camera;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.core.p027a.FileProvider;

/* loaded from: classes2.dex */
public class GalleryCacheFileProvider extends FileProvider {
    @Override // androidx.core.p027a.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        try {
            super.attachInfo(context, providerInfo);
        } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("GalleryCacheFileProvider", "attachInfo error, authority: " + providerInfo.authority, COUIBaseListPopupWindow_8);
        }
    }
}
