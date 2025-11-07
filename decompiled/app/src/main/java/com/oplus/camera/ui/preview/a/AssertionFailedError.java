package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: AncFilterSdk.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.ui.preview.a_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, byte[]> f6869a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.concurrent.ExecutorService f6870b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.anc.sdk.AncFilterApi f6871c = null;
    private com.anc.sdk.AncFilterApi.FilterInfo d_renamed = null;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private java.lang.String i_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.m_renamed j_renamed = null;

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void b_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(android.content.Context context, int i_renamed, int i2, boolean z_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && this.f6871c == null) {
            com.oplus.camera.e_renamed.a_renamed("initAncRender");
            this.f6871c = new com.anc.sdk.AncFilterApi();
            com.oplus.camera.e_renamed.a_renamed("AncFilterSdk", "initAncRender, version: " + this.f6871c.getVersion());
            int iInit = this.f6871c.init(true);
            if (iInit != 0) {
                com.oplus.camera.e_renamed.f_renamed("AncFilterSdk", "init, error: " + iInit);
            }
            this.d_renamed = new com.anc.sdk.AncFilterApi.FilterInfo();
            this.g_renamed = i_renamed;
            this.h_renamed = i2;
            com.oplus.camera.e_renamed.b_renamed("initAncRender");
            com.oplus.camera.e_renamed.a_renamed("AncFilterSdk", "initAncRender X_renamed");
        }
    }

    public void a_renamed(android.content.Context context, int i_renamed, int i2) {
        if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && this.f6871c == null) {
            com.oplus.camera.e_renamed.a_renamed("AncFilterSdk", "initFilterEngine mAncFilterSdk");
            this.f6871c = new com.anc.sdk.AncFilterApi();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            int iInit = this.f6871c.init(true);
            if (iInit != 0) {
                com.oplus.camera.e_renamed.f_renamed("AncFilterSdk", "init, error: " + iInit);
            }
            this.j_renamed = new com.oplus.camera.ui.preview.a_renamed.m_renamed(context);
            this.d_renamed = new com.anc.sdk.AncFilterApi.FilterInfo();
            com.oplus.camera.e_renamed.a_renamed("AncFilterSdk", "initFilterEngine mAncFilterSdk X_renamed");
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public boolean a_renamed() {
        return this.f6871c != null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void b_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(java.lang.String str) {
        this.i_renamed = str;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0062  */
    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d_renamed() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.b_renamed.d_renamed():void");
    }

    private byte[] b_renamed(final java.lang.String str) {
        if (f6869a == null) {
            f6869a = new java.util.concurrent.ConcurrentHashMap();
        }
        if (f6870b == null) {
            f6870b = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
        if (!f6869a.containsKey(str)) {
            f6870b.submit(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.-$$Lambda$b_renamed$LB1KmbHsjVSsEnjn_6ydWe8goKQ
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.camera.ui.preview.a_renamed.b_renamed.c_renamed(str);
                }
            });
        }
        return f6869a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c_renamed(java.lang.String str) {
        if (f6869a.containsKey(str)) {
            return;
        }
        android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile("/odm/etc/camera/micFilter/" + str);
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(bitmapDecodeFile.getByteCount());
        bitmapDecodeFile.copyPixelsToBuffer(byteBufferAllocate);
        f6869a.put(str, byteBufferAllocate.array());
        com.oplus.camera.e_renamed.b_renamed("AncFilterSdk", "getLutBuffer, load: " + str);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("AncFilterSdk", "destroyEngine, mAncFilterApi: " + this.f6871c);
        com.anc.sdk.AncFilterApi ancFilterApi = this.f6871c;
        if (ancFilterApi != null) {
            ancFilterApi.release();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            this.f6871c = null;
            this.d_renamed = null;
        }
        com.oplus.camera.ui.preview.a_renamed.m_renamed mVar = this.j_renamed;
        if (mVar != null) {
            mVar.a_renamed();
            this.j_renamed = null;
        }
        java.util.Map<java.lang.String, byte[]> map = f6869a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed, int i2, float f_renamed, float f2) {
        this.j_renamed.a_renamed(this, list, i_renamed, i2, 0.0f);
    }

    public void a_renamed(int i_renamed, int i2) {
        this.g_renamed = i_renamed;
        this.h_renamed = i2;
    }
}
