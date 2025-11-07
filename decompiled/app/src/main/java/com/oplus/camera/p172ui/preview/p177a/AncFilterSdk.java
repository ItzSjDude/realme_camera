package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import co.polarr.renderer.entities.DrawingItem;
import com.anc.sdk.AncFilterApi;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.p146gl.GLES20Canvas;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: AncFilterSdk.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AncFilterSdk extends AbstractFilterSdk {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, byte[]> f21106a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ExecutorService f21107b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AncFilterApi f21108c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private AncFilterApi.FilterInfo f21109d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f21110e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f21111f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f21112g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f21113h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f21114i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private FilterThumbDrawer f21115j = null;

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22235a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22241b() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22243c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22237a(Context context, int OplusGLSurfaceView_13, int i2, boolean z) {
        if (CameraConfig.isSupportMicroscope() && this.f21108c == null) {
            CameraLog.m12952a("initAncRender");
            this.f21108c = new AncFilterApi();
            CameraLog.m12954a("AncFilterSdk", "initAncRender, version: " + this.f21108c.getVersion());
            int iInit = this.f21108c.init(true);
            if (iInit != 0) {
                CameraLog.m12967f("AncFilterSdk", "init, error: " + iInit);
            }
            this.f21109d = new AncFilterApi.FilterInfo();
            this.f21112g = OplusGLSurfaceView_13;
            this.f21113h = i2;
            CameraLog.m12958b("initAncRender");
            CameraLog.m12954a("AncFilterSdk", "initAncRender X");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22496a(Context context, int OplusGLSurfaceView_13, int i2) {
        if (CameraConfig.isSupportMicroscope() && this.f21108c == null) {
            CameraLog.m12954a("AncFilterSdk", "initFilterEngine mAncFilterSdk");
            this.f21108c = new AncFilterApi();
            GLES20Canvas.m14010i();
            int iInit = this.f21108c.init(true);
            if (iInit != 0) {
                CameraLog.m12967f("AncFilterSdk", "init, error: " + iInit);
            }
            this.f21115j = new FilterThumbDrawer(context);
            this.f21109d = new AncFilterApi.FilterInfo();
            CameraLog.m12954a("AncFilterSdk", "initFilterEngine mAncFilterSdk X");
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22240a() {
        return this.f21108c != null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22236a(int OplusGLSurfaceView_13) {
        this.f21111f = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22242b(int OplusGLSurfaceView_13) {
        this.f21110e = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22238a(String str) {
        this.f21114i = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo22244d() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.AncFilterSdk.mo22244d():void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private byte[] m22493b(final String str) {
        if (f21106a == null) {
            f21106a = new ConcurrentHashMap();
        }
        if (f21107b == null) {
            f21107b = Executors.newSingleThreadExecutor();
        }
        if (!f21106a.containsKey(str)) {
            f21107b.submit(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$LB1KmbHsjVSsEnjn_6ydWe8goKQ
                @Override // java.lang.Runnable
                public final void run() {
                    AncFilterSdk.m22494c(str);
                }
            });
        }
        return f21106a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static /* synthetic */ void m22494c(String str) {
        if (f21106a.containsKey(str)) {
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile("/odm/etc/camera/micFilter/" + str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmapDecodeFile.getByteCount());
        bitmapDecodeFile.copyPixelsToBuffer(byteBufferAllocate);
        f21106a.put(str, byteBufferAllocate.array());
        CameraLog.m12959b("AncFilterSdk", "getLutBuffer, load: " + str);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22245e() {
        CameraLog.m12954a("AncFilterSdk", "destroyEngine, mAncFilterApi: " + this.f21108c);
        AncFilterApi ancFilterApi = this.f21108c;
        if (ancFilterApi != null) {
            ancFilterApi.release();
            GLES20Canvas.m14010i();
            this.f21108c = null;
            this.f21109d = null;
        }
        FilterThumbDrawer c3416m = this.f21115j;
        if (c3416m != null) {
            c3416m.m22671a();
            this.f21115j = null;
        }
        Map<String, byte[]> map = f21106a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22239a(List<DrawingItem> list, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2) {
        this.f21115j.m22672a(this, list, OplusGLSurfaceView_13, i2, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22495a(int OplusGLSurfaceView_13, int i2) {
        this.f21112g = OplusGLSurfaceView_13;
        this.f21113h = i2;
    }
}
