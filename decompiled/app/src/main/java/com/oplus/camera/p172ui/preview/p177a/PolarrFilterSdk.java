package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import co.polarr.renderer.PolarrRender;
import co.polarr.renderer.entities.DrawingItem;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import java.util.List;

/* compiled from: PolarrFilterSdk.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.s */
/* loaded from: classes2.dex */
public class PolarrFilterSdk extends AbstractFilterSdk {

    /* renamed from: PlatformImplementations.kt_3 */
    private PolarrRender f21466a = null;

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22237a(Context context, int OplusGLSurfaceView_13, int i2, boolean z) {
        if (z || this.f21466a == null) {
            m22771b(context, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22773a(Context context, int OplusGLSurfaceView_13, int i2) {
        if (this.f21466a == null) {
            CameraLog.m12954a("PolarrFilterSdk", "initFilterEngine mPolarrRender");
            this.f21466a = new PolarrRender();
            GLES20Canvas.m14010i();
            this.f21466a.initRender(context.getResources(), OplusGLSurfaceView_13, i2, true, 1);
            GLES20Canvas.m14010i();
            CameraLog.m12954a("PolarrFilterSdk", "initFilterEngine mPolarrRender X");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22772a(int OplusGLSurfaceView_13, int i2) {
        if (this.f21466a != null) {
            CameraLog.m12954a("PolarrFilterSdk", "updateSize, inputWidth: " + OplusGLSurfaceView_13 + ", inputHeight: " + i2);
            this.f21466a.updateSize(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22240a() {
        return this.f21466a != null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22236a(int OplusGLSurfaceView_13) {
        this.f21466a.setOutputTexture(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22242b(int OplusGLSurfaceView_13) {
        this.f21466a.setInputTexture(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22235a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        PolarrRender.setupVignetteParams(COUIBaseListPopupWindow_12, f2, f3, f4, f5, f6);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22238a(String str) {
        this.f21466a.fastUpdateFilter(str);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22241b() {
        this.f21466a.updateInputTexture();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22243c() {
        this.f21466a.drawFrameWithVignette();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22244d() {
        this.f21466a.drawFrame();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22245e() {
        CameraLog.m12954a("PolarrFilterSdk", "destroyEngine, mPolarrRender: " + this.f21466a);
        PolarrRender polarrRender = this.f21466a;
        if (polarrRender != null) {
            polarrRender.release();
            GLES20Canvas.m14010i();
            this.f21466a = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m22774f() {
        PolarrRender polarrRender = this.f21466a;
        if (polarrRender != null) {
            polarrRender.clearThumbCache();
            CameraLog.m12954a("PolarrFilterSdk", "clearThumbCache");
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22239a(List<DrawingItem> list, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2) {
        this.f21466a.setInputTexture(OplusGLSurfaceView_13);
        this.f21466a.drawFiltersFrame(list, i2, true, 0.5f, COUIBaseListPopupWindow_12, 0.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22771b(Context context, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("PolarrFilterSdk", "initPolarrRender, version: " + PolarrRender.Version());
        CameraLog.m12952a("initPolarrRender");
        PolarrRender polarrRender = this.f21466a;
        if (polarrRender != null) {
            polarrRender.release();
        }
        this.f21466a = new PolarrRender();
        this.f21466a.initRender(context.getResources(), OplusGLSurfaceView_13, i2, true, 0);
        CameraLog.m12958b("initPolarrRender");
        CameraLog.m12954a("PolarrFilterSdk", "initPolarrRender X");
    }
}
