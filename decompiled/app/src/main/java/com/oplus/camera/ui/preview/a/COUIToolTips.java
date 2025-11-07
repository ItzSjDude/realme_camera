package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: PolarrFilterSdk.java */
/* loaded from: classes2.dex */
public class s_renamed extends com.oplus.camera.ui.preview.a_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private co_renamed.polarr.renderer.PolarrRender f6952a = null;

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(android.content.Context context, int i_renamed, int i2, boolean z_renamed) {
        if (z_renamed || this.f6952a == null) {
            b_renamed(context, i_renamed, i2);
        }
    }

    public void a_renamed(android.content.Context context, int i_renamed, int i2) {
        if (this.f6952a == null) {
            com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "initFilterEngine mPolarrRender");
            this.f6952a = new co_renamed.polarr.renderer.PolarrRender();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            this.f6952a.initRender(context.getResources(), i_renamed, i2, true, 1);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "initFilterEngine mPolarrRender X_renamed");
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        if (this.f6952a != null) {
            com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "updateSize, inputWidth: " + i_renamed + ", inputHeight: " + i2);
            this.f6952a.updateSize(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public boolean a_renamed() {
        return this.f6952a != null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        this.f6952a.setOutputTexture(i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void b_renamed(int i_renamed) {
        this.f6952a.setInputTexture(i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        co_renamed.polarr.renderer.PolarrRender.setupVignetteParams(f_renamed, f2, f3, f4, f5, f6);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(java.lang.String str) {
        this.f6952a.fastUpdateFilter(str);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void b_renamed() {
        this.f6952a.updateInputTexture();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void c_renamed() {
        this.f6952a.drawFrameWithVignette();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void d_renamed() {
        this.f6952a.drawFrame();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "destroyEngine, mPolarrRender: " + this.f6952a);
        co_renamed.polarr.renderer.PolarrRender polarrRender = this.f6952a;
        if (polarrRender != null) {
            polarrRender.release();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            this.f6952a = null;
        }
    }

    public void f_renamed() {
        co_renamed.polarr.renderer.PolarrRender polarrRender = this.f6952a;
        if (polarrRender != null) {
            polarrRender.clearThumbCache();
            com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "clearThumbCache");
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed
    public void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed, int i2, float f_renamed, float f2) {
        this.f6952a.setInputTexture(i_renamed);
        this.f6952a.drawFiltersFrame(list, i2, true, 0.5f, f_renamed, 0.0f);
    }

    private void b_renamed(android.content.Context context, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "initPolarrRender, version: " + co_renamed.polarr.renderer.PolarrRender.Version());
        com.oplus.camera.e_renamed.a_renamed("initPolarrRender");
        co_renamed.polarr.renderer.PolarrRender polarrRender = this.f6952a;
        if (polarrRender != null) {
            polarrRender.release();
        }
        this.f6952a = new co_renamed.polarr.renderer.PolarrRender();
        this.f6952a.initRender(context.getResources(), i_renamed, i2, true, 0);
        com.oplus.camera.e_renamed.b_renamed("initPolarrRender");
        com.oplus.camera.e_renamed.a_renamed("PolarrFilterSdk", "initPolarrRender X_renamed");
    }
}
