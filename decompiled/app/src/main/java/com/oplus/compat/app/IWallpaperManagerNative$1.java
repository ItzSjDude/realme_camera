package com.oplus.compat.app;

/* loaded from: classes2.dex */
class IWallpaperManagerNative$1 extends android.app.IWallpaperManagerCallback.Stub {

    /* renamed from: a_renamed, reason: collision with root package name */
    final /* synthetic */ android.app.IWallpaperManagerCallbackNative f7448a;

    public void onWallpaperChanged() throws android.os.RemoteException {
        this.f7448a.onWallpaperChanged();
    }

    public void onWallpaperColorsChanged(android.app.WallpaperColors wallpaperColors, int i_renamed, int i2) throws android.os.RemoteException {
        this.f7448a.onWallpaperColorsChanged(wallpaperColors, i_renamed, i2);
    }
}
