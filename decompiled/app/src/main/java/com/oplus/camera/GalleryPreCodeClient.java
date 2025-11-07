package com.oplus.camera;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.camera.util.Util;
import com.oplus.gallery.predecode.IPreDecode;

/* compiled from: GalleryPreCodeClient.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class GalleryPreCodeClient {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f14721a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IPreDecode f14722b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ServiceConnection f14723c = new ServiceConnection() { // from class: com.oplus.camera.OplusGLSurfaceView_11.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CameraLog.m12954a("GalleryPreCodeClient", "onServiceConnected");
            GalleryPreCodeClient.this.f14722b = IPreDecode.Stub.m25011a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CameraLog.m12954a("GalleryPreCodeClient", "onServiceDisconnected");
            synchronized (this) {
                GalleryPreCodeClient.this.f14722b = null;
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14717a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(Util.m24327aP(), "com.oplus.gallery.picture_page.predecode.OplusPreTileDecodeService"));
        try {
            this.f14721a = context.bindService(intent, this.f14723c, 1);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12954a("GalleryPreCodeClient", "bindPreDecodeService context: " + context + "mbBinded: " + this.f14721a + ", intent: " + intent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14719b(Context context) {
        CameraLog.m12954a("GalleryPreCodeClient", "unBindPreDecodeService context: " + context + ", mbBinded: " + this.f14721a);
        if (this.f14721a) {
            try {
                context.unbindService(this.f14723c);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.f14721a = false;
        }
        this.f14723c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14718a(Context context, Uri uri, String str, long OplusGLSurfaceView_15, boolean z) {
        if (this.f14722b == null) {
            CameraLog.m12954a("GalleryPreCodeClient", "call, null == preDecodeService");
            return;
        }
        if (OplusGLSurfaceView_15 == -1) {
            CameraLog.m12954a("GalleryPreCodeClient", "call, date == -1 not support pre encode!");
            return;
        }
        if (uri == null) {
            CameraLog.m12954a("GalleryPreCodeClient", "call, null == image_uri ");
            return;
        }
        if (context == null) {
            CameraLog.m12954a("GalleryPreCodeClient", "call, null == mContext ");
            return;
        }
        if (Util.m24452g(context).totalMem <= 1073741824) {
            if (Util.m24468k(context) <= 262144000) {
                CameraLog.m12954a("GalleryPreCodeClient", "call, AvailMemory < 250M, will cause lmk and kill com.oplus.gallery.provider.AlbumsProvider.");
                return;
            }
        } else if (Util.m24468k(context) <= 367001600) {
            CameraLog.m12954a("GalleryPreCodeClient", "call, AvailMemory < 350M, will cause lmk and kill com.oplus.gallery.provider.AlbumsProvider.");
            return;
        }
        CameraLog.m12954a("GalleryPreCodeClient", "call, image_uri: " + uri.toString() + ", image_path: " + str + ", image_date: " + OplusGLSurfaceView_15);
        try {
            synchronized (this) {
                if (this.f14722b != null) {
                    this.f14722b.mo25009a(uri.toString(), str, OplusGLSurfaceView_15, z);
                }
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
