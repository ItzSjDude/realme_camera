package com.oplus.compat.app;

import android.app.IWallpaperManagerCallback;
import android.app.IWallpaperManagerCallbackNative;
import android.app.WallpaperColors;
import android.os.RemoteException;

/* loaded from: classes2.dex */
class IWallpaperManagerNative$1 extends IWallpaperManagerCallback.Stub {

    /* renamed from: PlatformImplementations.kt_3 */
    final /* synthetic */ IWallpaperManagerCallbackNative f23259a;

    public void onWallpaperChanged() throws RemoteException {
        this.f23259a.onWallpaperChanged();
    }

    public void onWallpaperColorsChanged(WallpaperColors wallpaperColors, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        this.f23259a.onWallpaperColorsChanged(wallpaperColors, OplusGLSurfaceView_13, i2);
    }
}
