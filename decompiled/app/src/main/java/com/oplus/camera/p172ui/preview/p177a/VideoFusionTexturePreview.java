package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.opengl.GLES20;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p136a.ModelStorage;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.ocs.camera.HumanEffectFusionApiHelper;
import java.io.File;

/* compiled from: VideoFusionTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ad */
/* loaded from: classes2.dex */
public class VideoFusionTexturePreview extends TexturePreview implements TexturePreviewRequest.COUIBaseListPopupWindow_8 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f21042a = new Object();

    /* renamed from: A */
    private TexturePreviewRequest f21043A;

    /* renamed from: B */
    private HumanEffectFusionApiHelper.HumanEffectFusionConfig f21044B;

    /* renamed from: C */
    private HumanEffectFusionApiHelper.HumanVideoFusionParams f21045C;

    /* renamed from: D */
    private byte[] f21046D;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21047b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21048c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21049d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21050k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21051l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f21052m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21053n;

    /* renamed from: o */
    private boolean f21054o;

    /* renamed from: p */
    private boolean f21055p;

    /* renamed from: q */
    private boolean f21056q;

    /* renamed from: r */
    private boolean f21057r;

    /* renamed from: s */
    private boolean f21058s;

    /* renamed from: t */
    private boolean f21059t;

    /* renamed from: u */
    private int[] f21060u;

    /* renamed from: v */
    private int[] f21061v;

    /* renamed from: w */
    private int[] f21062w;

    /* renamed from: x */
    private RawTexture f21063x;

    /* renamed from: y */
    private RawTexture f21064y;

    /* renamed from: z */
    private HumanEffectFusionApiHelper f21065z;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r5 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r5 != false) goto L8;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m22441a(int r4, boolean r5) {
        /*
            r3 = this;
            r3 = 180(0xb4, float:2.52E-43)
            r0 = 0
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r4 == 0) goto L15
            if (r4 == r2) goto L18
            if (r4 == r3) goto Lf
            r3 = r0
            goto L18
        Lf:
            if (r5 == 0) goto L13
        L11:
            r3 = r1
            goto L18
        L13:
            r3 = r2
            goto L18
        L15:
            if (r5 == 0) goto L11
            goto L13
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.VideoFusionTexturePreview.m22441a(int, boolean):int");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 32;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public VideoFusionTexturePreview(Context context) {
        super(context);
        this.f21047b = 0;
        this.f21048c = 0;
        this.f21049d = 0;
        this.f21050k = -1;
        this.f21051l = false;
        this.f21052m = false;
        this.f21053n = false;
        this.f21054o = false;
        this.f21055p = true;
        this.f21056q = false;
        this.f21057r = false;
        this.f21058s = false;
        this.f21059t = false;
        this.f21060u = null;
        this.f21061v = null;
        this.f21062w = new int[11];
        this.f21063x = null;
        this.f21064y = null;
        this.f21065z = null;
        this.f21043A = null;
        this.f21044B = null;
        this.f21045C = null;
        this.f21046D = null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (f21042a) {
            if (this.f21043A != null && (this.f21054o || this.f21043A.m22366b())) {
                if (this.f21051l) {
                    return true;
                }
                CameraLog.m12954a("VideoFusionTexturePreview", "canProcess, texture is not init");
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        int iM22442a;
        boolean z;
        HumanEffectFusionApiHelper.FeatureType featureType;
        HumanEffectFusionApiHelper.FeatureType featureType2;
        synchronized (f21042a) {
            if (this.f21043A != null && aVar != null && aVar.f21549c != null && this.f21063x != null) {
                RawTexture c2768s = aVar.f21549c;
                synchronized (f21042a) {
                    if (this.f21065z == null) {
                        m22453c(this.f21543g);
                    }
                    if (this.f21052m && this.f21065z != null) {
                        HumanEffectFusionApiHelper humanEffectFusionApiHelper = this.f21065z;
                        if (this.f21054o) {
                            featureType2 = HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_NEON;
                        } else {
                            featureType2 = HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_BOKEH;
                        }
                        humanEffectFusionApiHelper.setFeatureType(featureType2);
                        m22438A();
                        this.f21052m = false;
                        this.f21056q = false;
                        this.f21057r = false;
                    }
                    if (this.f21055p && this.f21065z != null) {
                        HumanEffectFusionApiHelper humanEffectFusionApiHelper2 = this.f21065z;
                        if (this.f21054o) {
                            featureType = HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_NEON;
                        } else {
                            featureType = HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_BOKEH;
                        }
                        humanEffectFusionApiHelper2.setFeatureType(featureType);
                        m22438A();
                        this.f21055p = false;
                        this.f21056q = false;
                        this.f21057r = false;
                    }
                    if (this.f21056q) {
                        m22449a(this.f21060u[0] / 100.0f, this.f21060u[1] / 100.0f, this.f21060u[2] / 100.0f, this.f21060u[3] / 100.0f, this.f21060u[4] / 100.0f, this.f21060u[5] / 100.0f, this.f21060u[6] / 100.0f, this.f21060u[7] / 100.0f, this.f21060u[8] / 100.0f, this.f21060u[9] / 100.0f, this.f21060u[10] / 100.0f);
                        this.f21056q = false;
                    }
                    if (this.f21057r) {
                        OplusGLSurfaceView_13 = 1;
                        i2 = 3;
                        i3 = 4;
                        i4 = 5;
                        m22448a(this.f21061v[0] / 100.0f, this.f21061v[1] / 100.0f, this.f21061v[2] / 100.0f, this.f21061v[3] / 100.0f, this.f21061v[4] / 100.0f, this.f21061v[5] / 100.0f, this.f21061v[6] / 100.0f);
                        this.f21057r = false;
                    } else {
                        OplusGLSurfaceView_13 = 1;
                        i2 = 3;
                        i3 = 4;
                        i4 = 5;
                    }
                    int iM22441a = m22441a(this.f21049d, this.f21543g);
                    int iM13934e = c2768s.m13934e();
                    int[] iArr = new int[OplusGLSurfaceView_13];
                    iArr[0] = this.f21063x.m13934e();
                    iM22442a = m22442a(iM13934e, iArr, iM22441a);
                    z = OplusGLSurfaceView_13;
                    z = OplusGLSurfaceView_13;
                    z = OplusGLSurfaceView_13;
                    z = OplusGLSurfaceView_13;
                }
                if (iM22442a != 0 && i2 != iM22442a && i3 != iM22442a && i4 != iM22442a) {
                    z = OplusGLSurfaceView_13;
                    if (6 != iM22442a) {
                        z = 0;
                    }
                }
                this.f21053n = z;
                return this.f21053n;
            }
            CameraLog.m12954a("VideoFusionTexturePreview", "process, false");
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22447a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
        if (this.f21058s) {
            this.f21045C.UpdateBlurIntensity(0.0f);
            this.f21065z.setParams(this.f21045C);
            CameraLog.m12954a("VideoFusionTexturePreview", "setVideoNeonParams, set blurIntensity zero when rear orientation invalid.");
            return;
        }
        if (this.f21059t) {
            COUIBaseListPopupWindow_12 = ((int) ((COUIBaseListPopupWindow_12 * 1.3f) * 100.0f)) / 100.0f;
        }
        this.f21045C.UpdateBlurIntensity(COUIBaseListPopupWindow_12);
        this.f21045C.UpdateSaturation(f2);
        this.f21045C.UpdateFaculaDensity(f3);
        this.f21045C.UpdateLightFactor(f4);
        this.f21045C.UpdateSmoothAmount(f5);
        this.f21065z.setParams(this.f21045C);
        CameraLog.m12954a("VideoFusionTexturePreview", "setVideoNeonParams, intensity: " + COUIBaseListPopupWindow_12 + ", saturation: " + f2 + ", faculaDensity: " + f3 + ", lightFactor: " + f4 + ", smoothAmount: " + f5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22449a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        if (this.f21058s) {
            this.f21045C.UpdateBlurIntensity(0.0f);
            this.f21065z.setParams(this.f21045C);
            CameraLog.m12954a("VideoFusionTexturePreview", "setVideoNeonParams, set blurIntensity zero when rear orientation invalid.");
            return;
        }
        if (this.f21059t) {
            COUIBaseListPopupWindow_12 = ((int) ((COUIBaseListPopupWindow_12 * 1.3f) * 100.0f)) / 100.0f;
        }
        this.f21045C.UpdateBlurIntensity(COUIBaseListPopupWindow_12);
        this.f21045C.UpdateSaturation(f2);
        this.f21045C.UpdateFaculaDensity(f3);
        this.f21045C.UpdateLightFactor(f4);
        this.f21045C.UpdateSmoothAmount(f5);
        this.f21045C.UpdateBokehMaxRadiusFactor(f6);
        this.f21045C.UpdateColorValue(f7, f8, f9, f10);
        this.f21045C.UpdateBgLightFactor(f11);
        this.f21065z.setParams(this.f21045C);
        CameraLog.m12954a("VideoFusionTexturePreview", "setVideoNeonParams, intensity: " + COUIBaseListPopupWindow_12 + ", saturation: " + f2 + ", faculaDensity: " + f3 + ", lightFactor: " + f4 + ", smoothAmount: " + f5 + ", bokehMaxRadiusFactor: " + f6 + ", red: " + f7 + ", green: " + f8 + ", blue: " + f9 + ", yellow: " + f10 + ", bGlightFactor: " + f11);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22448a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f21045C.UpdateSaturation(COUIBaseListPopupWindow_12);
        this.f21045C.UpdateLightFactor(f6);
        this.f21045C.UpdateColorValue(f2, f3, f4, f5);
        this.f21045C.UpdateBgLightFactor(f7);
        this.f21065z.setParams(this.f21045C);
        CameraLog.m12954a("VideoFusionTexturePreview", "setVideoBlurParams, saturation: " + COUIBaseListPopupWindow_12 + ", lightFactor: " + f6 + ", red: " + f2 + ", green: " + f3 + ", blue: " + f4 + ", yellow: " + f5 + ", bGlightFactor: " + f7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m22438A() {
        boolean z = true;
        if (this.f21054o) {
            if (this.f21060u != null) {
                m22449a(r0[0] / 100.0f, r0[1] / 100.0f, r0[2] / 100.0f, r0[3] / 100.0f, r0[4] / 100.0f, r0[5] / 100.0f, r0[6] / 100.0f, r0[7] / 100.0f, r0[8] / 100.0f, r0[9] / 100.0f, r0[10] / 100.0f);
                return;
            }
            int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(this.f21543g ? ConfigDataBase.KEY_VIDEO_NEON_APP_FRONT_PARAMS : ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS);
            if (configIntArrayValue != null) {
                if (11 == configIntArrayValue.length) {
                    m22449a(configIntArrayValue[0] / 100.0f, configIntArrayValue[1] / 100.0f, configIntArrayValue[2] / 100.0f, configIntArrayValue[3] / 100.0f, configIntArrayValue[4] / 100.0f, configIntArrayValue[5] / 100.0f, configIntArrayValue[6] / 100.0f, configIntArrayValue[7] / 100.0f, configIntArrayValue[8] / 100.0f, configIntArrayValue[9] / 100.0f, configIntArrayValue[10] / 100.0f);
                    return;
                } else {
                    m22447a(configIntArrayValue[0] / 100.0f, configIntArrayValue[1] / 100.0f, configIntArrayValue[2] / 100.0f, configIntArrayValue[3] / 100.0f, configIntArrayValue[4] / 100.0f);
                    return;
                }
            }
            return;
        }
        float fM22383g = this.f21043A.m22383g();
        this.f21045C.UpdateBlurIntensity(fM22383g);
        if (this.f21061v != null) {
            m22448a(r0[0] / 100.0f, r0[1] / 100.0f, r0[2] / 100.0f, r0[3] / 100.0f, r0[4] / 100.0f, r0[5] / 100.0f, r0[6] / 100.0f);
        } else {
            int[] configIntArrayValue2 = CameraConfig.getConfigIntArrayValue(this.f21543g ? ConfigDataBase.KEY_VIDEO_BLUR_APP_FRONT_PARAMS : ConfigDataBase.KEY_VIDEO_BLUR_APP_REAR_PARAMS);
            if (configIntArrayValue2 == null || 11 != configIntArrayValue2.length) {
                z = false;
            } else {
                m22448a(configIntArrayValue2[0] / 100.0f, configIntArrayValue2[7] / 100.0f, configIntArrayValue2[8] / 100.0f, configIntArrayValue2[9] / 100.0f, configIntArrayValue2[10] / 100.0f, configIntArrayValue2[5] / 100.0f, configIntArrayValue2[6] / 100.0f);
            }
        }
        if (!z) {
            this.f21065z.setParams(this.f21045C);
        }
        CameraLog.m12954a("VideoFusionTexturePreview", "initVideoFusionParams, currBlurIntensity: " + fM22383g);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: y */
    public boolean mo22428y() {
        if (this.f21054o && this.f21058s) {
            return false;
        }
        return this.f21053n;
    }

    /* renamed from: q */
    public int[] m22458q() {
        int[] iArr = this.f21060u;
        if (iArr == null) {
            boolean z = this.f21059t;
            String str = ConfigDataBase.KEY_VIDEO_NEON_APP_FRONT_PARAMS;
            if (z) {
                if (!this.f21543g) {
                    str = ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS;
                }
                int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(str);
                if (configIntArrayValue != null) {
                    int[] iArr2 = this.f21062w;
                    iArr2[0] = (int) (configIntArrayValue[0] * 1.3f);
                    iArr2[1] = configIntArrayValue[1];
                    iArr2[2] = configIntArrayValue[2];
                    iArr2[3] = configIntArrayValue[3];
                    iArr2[4] = configIntArrayValue[4];
                    if (11 == configIntArrayValue.length) {
                        iArr2[5] = configIntArrayValue[5];
                        iArr2[6] = configIntArrayValue[6];
                        iArr2[7] = configIntArrayValue[7];
                        iArr2[8] = configIntArrayValue[8];
                        iArr2[9] = configIntArrayValue[9];
                        iArr2[10] = configIntArrayValue[10];
                    }
                }
                return this.f21062w;
            }
            if (!this.f21543g) {
                str = ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS;
            }
            return CameraConfig.getConfigIntArrayValue(str);
        }
        if (!this.f21059t) {
            return iArr;
        }
        int[] iArr3 = this.f21062w;
        iArr3[0] = (int) (iArr[0] * 1.3f);
        iArr3[1] = iArr[1];
        iArr3[2] = iArr[2];
        iArr3[3] = iArr[3];
        iArr3[4] = iArr[4];
        iArr3[5] = iArr[5];
        iArr3[6] = iArr[6];
        iArr3[7] = iArr[7];
        iArr3[8] = iArr[8];
        iArr3[9] = iArr[9];
        iArr3[10] = iArr[10];
        return iArr3;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: z */
    public int[] mo22437z() {
        CameraLog.m12954a("VideoFusionTexturePreview", "getVideoBlurParams");
        int[] iArr = this.f21061v;
        if (iArr == null) {
            return CameraConfig.getConfigIntArrayValue(this.f21543g ? ConfigDataBase.KEY_VIDEO_BLUR_APP_FRONT_PARAMS : ConfigDataBase.KEY_VIDEO_BLUR_APP_REAR_PARAMS);
        }
        return iArr;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
        CameraLog.m12959b("VideoFusionTexturePreview", "onDestroy");
        mo22290e();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(final TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("VideoFusionTexturePreview", "createEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ad.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VideoFusionTexturePreview.f21042a) {
                    VideoFusionTexturePreview.this.f21043A = c3397aa;
                    if (VideoFusionTexturePreview.this.f21043A != null) {
                        VideoFusionTexturePreview.this.f21043A.m22356a(VideoFusionTexturePreview.this);
                    }
                    CameraLog.m12954a("VideoFusionTexturePreview", "createEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12959b("VideoFusionTexturePreview", "destroyEngine, mHumanEffectFusionApi: " + this.f21065z);
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ad.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VideoFusionTexturePreview.f21042a) {
                    if (VideoFusionTexturePreview.this.f21065z != null) {
                        CameraLog.m12959b("VideoFusionTexturePreview", "destroyEngine, mHumanEffectFusionApi release");
                        VideoFusionTexturePreview.this.f21544h.m14133g();
                        VideoFusionTexturePreview.this.f21065z.release();
                        VideoFusionTexturePreview.this.f21065z = null;
                        VideoFusionTexturePreview.this.f21045C = null;
                    }
                    VideoFusionTexturePreview.this.f21043A = null;
                    CameraLog.m12954a("VideoFusionTexturePreview", "destroyEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21064y;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21063x;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("VideoFusionTexturePreview", "newTextures");
        this.f21064y = new RawTexture(this.f21047b, this.f21048c, true);
        this.f21063x = new RawTexture(this.f21047b, this.f21048c, true);
        this.f21051l = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21064y;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21064y.m14193c(interfaceC2757h);
            CameraLog.m12954a("VideoFusionTexturePreview", "prepareTextures, mInputTexture.getId: " + this.f21064y.m13934e());
        }
        RawTexture c2768s2 = this.f21063x;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21063x.m14193c(interfaceC2757h);
        CameraLog.m12954a("VideoFusionTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.f21063x.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("VideoFusionTexturePreview", "recycleTextures");
        if (this.f21051l) {
            RawTexture c2768s = this.f21064y;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21064y = null;
            }
            RawTexture c2768s2 = this.f21063x;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21063x = null;
            }
            this.f21051l = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("VideoFusionTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21047b = i2;
        this.f21048c = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        synchronized (f21042a) {
            this.f21052m = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21049d = OplusGLSurfaceView_13;
        if (90 == OplusGLSurfaceView_13 || (270 == OplusGLSurfaceView_13 && !this.f21059t)) {
            this.f21059t = true;
            m22439B();
        } else if (this.f21059t) {
            this.f21059t = false;
            m22439B();
        }
    }

    /* renamed from: B */
    private void m22439B() {
        if (this.f21054o) {
            this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ad.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (VideoFusionTexturePreview.f21042a) {
                        if (VideoFusionTexturePreview.this.f21043A != null && VideoFusionTexturePreview.this.f21065z != null) {
                            VideoFusionTexturePreview.this.m22438A();
                        }
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22457d(int OplusGLSurfaceView_13) {
        this.f21050k = OplusGLSurfaceView_13;
        if (!this.f21058s && -1 == OplusGLSurfaceView_13) {
            this.f21058s = true;
            m22439B();
        } else {
            if (!this.f21058s || -1 == OplusGLSurfaceView_13) {
                return;
            }
            this.f21058s = false;
            m22439B();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22453c(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        GLES20.glFinish();
        CameraLog.m12954a("VideoFusionTexturePreview", "initFusionEffect, isFrontCamera: " + z);
        if (this.f21044B == null) {
            this.f21044B = m22440C();
        }
        this.f21044B.isBackCamera = !z;
        this.f21065z = HumanEffectFusionApiHelper.getPreviewInstance();
        this.f21065z.preInit();
        this.f21045C = new HumanEffectFusionApiHelper.HumanVideoFusionParams();
        this.f21065z.setLogLevel(CameraLog.m12957a() ? 4 : 0);
        int iInitByConfig = this.f21065z.initByConfig(this.f21044B);
        GLES20Canvas.m14010i();
        CameraLog.m12954a("VideoFusionTexturePreview", "initFusionEffect end, res: " + iInitByConfig + ", sdk version: " + this.f21065z.getVersion());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22442a(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        if (iArr == null) {
            return -1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM22450b = m22450b(OplusGLSurfaceView_13, iArr, i2);
        CameraLog.m12954a("VideoFusionTexturePreview", "processVideoFusion, res: " + iM22450b + ", costTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        GLES20Canvas.m14010i();
        return iM22450b;
    }

    /* renamed from: C */
    private HumanEffectFusionApiHelper.HumanEffectFusionConfig m22440C() {
        String str = this.f21546j.getApplicationContext().getCacheDir() + File.separator + "anc_cache";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        HumanEffectFusionApiHelper.HumanEffectFusionConfig humanEffectFusionConfig = new HumanEffectFusionApiHelper.HumanEffectFusionConfig();
        humanEffectFusionConfig.isRealTime = true;
        if (this.f21046D == null) {
            this.f21046D = ModelStorage.m11168a("megvii/fusion_model");
        }
        humanEffectFusionConfig.model_data = this.f21046D;
        humanEffectFusionConfig.cache_path = str;
        humanEffectFusionConfig.native_lib_path = "/odm/lib64;/odm/lib/rfsa/adsp";
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_FUSION_APP_LOAD_SO_TYPE);
        if (configIntValue == 0) {
            humanEffectFusionConfig.sdkLoadType = HumanEffectFusionApiHelper.SdkLoadType.ANC_LOAD_TYPE_DLOEPN.getValue();
        } else if (configIntValue == 1) {
            humanEffectFusionConfig.sdkLoadType = HumanEffectFusionApiHelper.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN.getValue();
        }
        CameraLog.m12954a("VideoFusionTexturePreview", "getFusionConfig, loadType: " + configIntValue);
        return humanEffectFusionConfig;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m22450b(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        return this.f21065z.process(OplusGLSurfaceView_13, iArr, this.f21047b, this.f21048c, i2, this.f21543g);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.COUIBaseListPopupWindow_8
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22415b(boolean z) {
        synchronized (f21042a) {
            if (this.f21054o != z) {
                CameraLog.m12954a("VideoFusionTexturePreview", "onVideoNeonOpenChanged, isOpen: " + z);
                this.f21054o = z;
                this.f21055p = true;
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.COUIBaseListPopupWindow_8
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22413a(final float COUIBaseListPopupWindow_12) {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ad.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VideoFusionTexturePreview.f21042a) {
                    if (!VideoFusionTexturePreview.this.f21054o && VideoFusionTexturePreview.this.f21065z != null) {
                        VideoFusionTexturePreview.this.f21045C.UpdateBlurIntensity(COUIBaseListPopupWindow_12);
                        VideoFusionTexturePreview.this.f21065z.setParams(VideoFusionTexturePreview.this.f21045C);
                        CameraLog.m12954a("VideoFusionTexturePreview", "onVideoBlurLevelChange, blurLevel: " + COUIBaseListPopupWindow_12);
                    }
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.COUIBaseListPopupWindow_8
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22414a(int[] iArr) {
        if (this.f21054o && 11 == iArr.length) {
            if (this.f21060u != null) {
                boolean z = false;
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    int[] iArr2 = this.f21060u;
                    if (OplusGLSurfaceView_13 >= iArr2.length) {
                        break;
                    }
                    if (iArr2[OplusGLSurfaceView_13] != iArr[OplusGLSurfaceView_13]) {
                        z = true;
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
                if (!z) {
                    return;
                }
            }
            synchronized (f21042a) {
                this.f21060u = iArr;
                this.f21056q = true;
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.COUIBaseListPopupWindow_8
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22416b(int[] iArr) {
        CameraLog.m12954a("VideoFusionTexturePreview", "onVideoBlurTuningParamsChange, received params");
        if (this.f21054o || 7 != iArr.length) {
            return;
        }
        if (this.f21061v != null) {
            boolean z = false;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                int[] iArr2 = this.f21061v;
                if (OplusGLSurfaceView_13 >= iArr2.length) {
                    break;
                }
                if (iArr2[OplusGLSurfaceView_13] != iArr[OplusGLSurfaceView_13]) {
                    z = true;
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            if (!z) {
                return;
            }
        }
        synchronized (f21042a) {
            this.f21061v = iArr;
            this.f21057r = true;
        }
    }
}
