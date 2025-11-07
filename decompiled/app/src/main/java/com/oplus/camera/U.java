package com.oplus.camera;

/* compiled from: GalleryPreCodeClient.java */
/* loaded from: classes2.dex */
public class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f4888a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.gallery.predecode.IPreDecode f4889b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.ServiceConnection f4890c = new android.content.ServiceConnection() { // from class: com.oplus.camera.n_renamed.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "onServiceConnected");
            com.oplus.camera.n_renamed.this.f4889b = com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "onServiceDisconnected");
            synchronized (this) {
                com.oplus.camera.n_renamed.this.f4889b = null;
            }
        }
    };

    public void a_renamed(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(com.oplus.camera.util.Util.aP_renamed(), "com.oplus.gallery.picture_page.predecode.OplusPreTileDecodeService"));
        try {
            this.f4888a = context.bindService(intent, this.f4890c, 1);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "bindPreDecodeService context: " + context + "mbBinded: " + this.f4888a + ", intent: " + intent);
    }

    public void b_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "unBindPreDecodeService context: " + context + ", mbBinded: " + this.f4888a);
        if (this.f4888a) {
            try {
                context.unbindService(this.f4890c);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            this.f4888a = false;
        }
        this.f4890c = null;
    }

    public void a_renamed(android.content.Context context, android.net.Uri uri, java.lang.String str, long j_renamed, boolean z_renamed) {
        if (this.f4889b == null) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, null == preDecodeService");
            return;
        }
        if (j_renamed == -1) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, date == -1 not support pre encode!");
            return;
        }
        if (uri == null) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, null == image_uri ");
            return;
        }
        if (context == null) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, null == mContext ");
            return;
        }
        if (com.oplus.camera.util.Util.g_renamed(context).totalMem <= 1073741824) {
            if (com.oplus.camera.util.Util.k_renamed(context) <= 262144000) {
                com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, AvailMemory < 250M, will cause lmk and kill com.oplus.gallery.provider.AlbumsProvider.");
                return;
            }
        } else if (com.oplus.camera.util.Util.k_renamed(context) <= 367001600) {
            com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, AvailMemory < 350M, will cause lmk and kill com.oplus.gallery.provider.AlbumsProvider.");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("GalleryPreCodeClient", "call, image_uri: " + uri.toString() + ", image_path: " + str + ", image_date: " + j_renamed);
        try {
            synchronized (this) {
                if (this.f4889b != null) {
                    this.f4889b.a_renamed(uri.toString(), str, j_renamed, z_renamed);
                }
            }
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
        }
    }
}
