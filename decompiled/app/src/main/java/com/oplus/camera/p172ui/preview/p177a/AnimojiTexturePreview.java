package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Size;
import com.arcsoft.arcsoftjni.ArcSoftAvatarEngine;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.sticker.StickerItemDBHelper;
import com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: AnimojiTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class AnimojiTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21154a = "0ms";

    /* renamed from: A */
    private String f21155A;

    /* renamed from: B */
    private String f21156B;

    /* renamed from: C */
    private boolean f21157C;

    /* renamed from: D */
    private boolean f21158D;

    /* renamed from: E */
    private boolean f21159E;

    /* renamed from: F */
    private ArcSoftAvatarEngine f21160F;

    /* renamed from: G */
    private ArcSoftOffscreen f21161G;

    /* renamed from: H */
    private ArcSoftOffscreen f21162H;

    /* renamed from: I */
    private ArcSoftOffscreen f21163I;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Runnable f21164b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Runnable f21165c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Runnable f21166d;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Object f21167k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21168l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21169m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21170n;

    /* renamed from: o */
    private float[] f21171o;

    /* renamed from: p */
    private RawTexture f21172p;

    /* renamed from: q */
    private boolean f21173q;

    /* renamed from: r */
    private boolean f21174r;

    /* renamed from: s */
    private boolean f21175s;

    /* renamed from: t */
    private boolean f21176t;

    /* renamed from: u */
    private Size f21177u;

    /* renamed from: v */
    private TexturePreviewRequest f21178v;

    /* renamed from: w */
    private boolean f21179w;

    /* renamed from: x */
    private boolean f21180x;

    /* renamed from: y */
    private boolean f21181y;

    /* renamed from: z */
    private boolean f21182z;

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 16;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        boolean z;
        synchronized (this.f21167k) {
            z = this.f21158D;
        }
        return z;
    }

    public AnimojiTexturePreview(Context context) {
        super(context);
        this.f21167k = new Object();
        this.f21168l = 0;
        this.f21169m = 0;
        this.f21170n = 0;
        this.f21171o = new float[3];
        this.f21172p = null;
        this.f21173q = false;
        this.f21174r = false;
        this.f21175s = false;
        this.f21176t = false;
        this.f21177u = null;
        this.f21178v = null;
        this.f21179w = false;
        this.f21180x = false;
        this.f21181y = false;
        this.f21182z = false;
        this.f21155A = null;
        this.f21156B = null;
        this.f21157C = false;
        this.f21158D = false;
        this.f21159E = false;
        this.f21160F = null;
        this.f21161G = null;
        this.f21162H = null;
        this.f21163I = null;
        this.f21164b = new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AnimojiTexturePreview.this.f21167k) {
                    if (AnimojiTexturePreview.this.f21182z) {
                        return;
                    }
                    AnimojiTexturePreview.this.m22522r();
                }
            }
        };
        this.f21165c = new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AnimojiTexturePreview.this.f21167k) {
                    AnimojiTexturePreview.this.m22508a(AnimojiTexturePreview.this.f21546j, AnimojiTexturePreview.this.f21168l, AnimojiTexturePreview.this.f21169m);
                }
            }
        };
        this.f21166d = new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.3
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                AnimojiTexturePreview.this.m22506B();
            }
        };
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22524a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (this.f21179w) {
            synchronized (this.f21167k) {
                if (this.f21161G == null || OplusGLSurfaceView_13 != this.f21161G.getWidth() || i2 != this.f21161G.getHeight()) {
                    this.f21161G = new ArcSoftOffscreen(OplusGLSurfaceView_13, i2, (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER_USE_NV12) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12)) ? 2049 : 2050);
                    CameraLog.m12954a("AnimojiTexturePreview", "onPreviewCallback, new ArcSoftOffscreen, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
                }
                if (this.f21161G != null && this.f21178v != null && bArr != null) {
                    this.f21161G.setData(bArr);
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21178v;
        if (c3397aa == null) {
            return false;
        }
        if (c3397aa.m22334C() > 0 && this.f21157C) {
            this.f21157C = false;
        }
        if (mo22673a_(OplusGLSurfaceView_13) && this.f21180x && this.f21178v.m22401r() && this.f21178v.m22402s() && 2 == this.f21178v.m22398o().getMaterialType()) {
            return !this.f21157C;
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) throws Throwable {
        ArcSoftOffscreen arcSoftOffscreen;
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21178v == null || !this.f21179w || this.f21160F == null || this.f21172p == null || (arcSoftOffscreen = this.f21161G) == null || arcSoftOffscreen.getData() == null || aVar == null || aVar.f21556j <= 0 || aVar.f21557k <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("process, something wrong, so return! mRequest: ");
            sb.append(this.f21178v);
            sb.append(", mbInitialized: ");
            sb.append(this.f21179w);
            sb.append(", mAvatarEngineRender: ");
            sb.append(this.f21160F);
            sb.append(", mOutputAnimojiTexture: ");
            sb.append(this.f21172p);
            sb.append(", mPreviewOffscreen: ");
            sb.append(this.f21161G);
            sb.append(", mPreviewOffscreen.data: ");
            ArcSoftOffscreen arcSoftOffscreen2 = this.f21161G;
            sb.append(arcSoftOffscreen2 != null ? arcSoftOffscreen2.getData() : null);
            sb.append(", frameInfo: ");
            sb.append(aVar);
            sb.append(", outTextureWidth: ");
            sb.append(aVar == null ? 0 : aVar.f21556j);
            sb.append(", outTextureHeight: ");
            sb.append(aVar == null ? 0 : aVar.f21557k);
            CameraLog.m12966e("AnimojiTexturePreview", sb.toString());
            return false;
        }
        int OplusGLSurfaceView_13 = this.f21170n;
        int i2 = this.f21542f;
        int i3 = aVar.f21556j;
        int i4 = aVar.f21557k;
        synchronized (this.f21167k) {
            try {
                try {
                    if (this.f21160F == null) {
                        return false;
                    }
                    if (!this.f21173q) {
                        if (!this.f21159E) {
                            Util.m24279a(this.f21166d);
                            this.f21159E = true;
                        }
                        CameraLog.m12967f("AnimojiTexturePreview", "process, non selected template!");
                        return false;
                    }
                    boolean z = this.f21543g;
                    this.f21160F.setDevicesOrientation(OplusGLSurfaceView_13);
                    int iMo22924a = this.f21545i != null ? this.f21545i.mo22924a(i2, OplusGLSurfaceView_13) : 0;
                    if (this.f21181y && this.f21162H != null && this.f21162H.getData() != null) {
                        this.f21160F.process(this.f21161G, this.f21162H, 90, iMo22924a, z);
                    } else {
                        this.f21160F.process(this.f21161G, null, 90, iMo22924a, z);
                    }
                    float COUIBaseListPopupWindow_12 = this.f21171o[0];
                    float f2 = this.f21171o[1];
                    float f3 = this.f21171o[2];
                    GLES20.glClearColor(COUIBaseListPopupWindow_12, f2, f3, 1.0f);
                    GLES20.glViewport(0, 0, i3, i4);
                    int[] iArr = new int[1];
                    long jRender = this.f21160F.render(i3, i4, 0, false, iArr, null);
                    this.f21172p.m14190a(aVar.f21547a, iArr[0], i3, i4);
                    this.f21158D = true;
                    if (this.f21175s) {
                        CameraLog.m12959b("AnimojiTexturePreview", "process, captureRender start");
                        this.f21175s = false;
                        this.f21163I = new ArcSoftOffscreen(this.f21177u.getWidth(), this.f21177u.getHeight(), (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER_USE_NV12) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12)) ? 2049 : 2050);
                        this.f21163I.setData(new byte[(int) (this.f21177u.getWidth() * this.f21177u.getHeight() * 1.5f)]);
                        GLES20.glClearColor(COUIBaseListPopupWindow_12, f2, f3, 1.0f);
                        CameraLog.m12959b("AnimojiTexturePreview", "process, captureRender end, captureResult: " + this.f21160F.render(this.f21163I.getWidth(), this.f21163I.getHeight(), 270, this.f21176t, null, this.f21163I));
                    }
                    f21154a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                    return jRender != -1;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("AnimojiTexturePreview", "createEngine, reques: " + c3397aa + ", mbCreateEngine: " + this.f21182z);
        this.f21178v = c3397aa;
        if (this.f21182z) {
            return;
        }
        CameraLog.m12952a("Animoji.createEngine");
        this.f21182z = true;
        this.f21157C = true;
        this.f21158D = false;
        Util.m24279a(this.f21165c);
        synchronized (this.f21167k) {
            Util.m24279a(this.f21166d);
        }
        CameraLog.m12958b("Animoji.createEngine");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("AnimojiTexturePreview", "destroyEngine, mReques: " + this.f21178v);
        if (this.f21182z) {
            this.f21182z = false;
            this.f21157C = false;
            if (this.f21178v == null || this.f21544h == null) {
                return;
            }
            this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnimojiTexturePreview.this.f21167k) {
                        AnimojiTexturePreview.this.m22505A();
                    }
                    Util.m24279a(AnimojiTexturePreview.this.f21164b);
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21172p;
    }

    /* renamed from: q */
    private boolean m22521q() {
        CameraCharacteristicsUtil.PlatformImplementations.kt_3 aVarM12977b = CameraCharacteristicsUtil.m12977b();
        CameraCharacteristicsUtil.PlatformImplementations.kt_3 aVarM12979c = CameraCharacteristicsUtil.m12979c();
        if (aVarM12977b == null || aVarM12979c == null || !aVarM12977b.m13004a() || !aVarM12979c.m13004a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("setCameraConf, masterCalibParam valid: ");
            sb.append(aVarM12977b == null ? null : Boolean.valueOf(aVarM12977b.m13004a()));
            sb.append(", depthCalibParam valid: ");
            sb.append(aVarM12979c != null ? Boolean.valueOf(aVarM12979c.m13004a()) : null);
            CameraLog.m12967f("AnimojiTexturePreview", sb.toString());
            return false;
        }
        ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera = new ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera.iFrameWidth = CameraCharacteristicsUtil.m12977b().f13229a;
        avatarEngineCamera.iFrameHeight = CameraCharacteristicsUtil.m12977b().f13230b;
        avatarEngineCamera.fCameraFx = CameraCharacteristicsUtil.m12977b().f13231c;
        avatarEngineCamera.fCameraFy = CameraCharacteristicsUtil.m12977b().f13232d;
        avatarEngineCamera.fCameraCx = CameraCharacteristicsUtil.m12977b().f13233e;
        avatarEngineCamera.fCameraCy = CameraCharacteristicsUtil.m12977b().f13234f;
        ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera2 = new ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera2.iFrameWidth = CameraCharacteristicsUtil.m12979c().f13229a;
        avatarEngineCamera2.iFrameHeight = CameraCharacteristicsUtil.m12979c().f13230b;
        avatarEngineCamera2.fCameraFx = CameraCharacteristicsUtil.m12979c().f13231c;
        avatarEngineCamera2.fCameraFy = CameraCharacteristicsUtil.m12979c().f13232d;
        avatarEngineCamera2.fCameraCx = CameraCharacteristicsUtil.m12979c().f13233e;
        avatarEngineCamera2.fCameraCy = CameraCharacteristicsUtil.m12979c().f13234f;
        long camera = -1;
        ArcSoftAvatarEngine arcSoftAvatarEngine = this.f21160F;
        if (arcSoftAvatarEngine != null) {
            camera = arcSoftAvatarEngine.setCamera(avatarEngineCamera, avatarEngineCamera2);
            CameraLog.m12954a("AnimojiTexturePreview", "setCameraConf, masterCalibParam: " + aVarM12977b.toString() + ", depthCalibParam: " + aVarM12979c.toString() + ", result: " + camera);
        }
        return camera == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public long m22508a(Context context, int OplusGLSurfaceView_13, int i2) throws Throwable {
        CameraLog.m12959b("AnimojiTexturePreview", "initAnimojiEngine, start, mbInitialized: " + this.f21179w + ", width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        long jInitialize = -1;
        if (this.f21546j == null) {
            return -1L;
        }
        String strM22507C = m22507C();
        m22513a(this.f21546j, "/odm/etc/camera/sticker/material/animoji/data.zip", strM22507C, false);
        synchronized (this.f21167k) {
            if (!this.f21179w && this.f21160F == null) {
                CameraLog.m12952a("Animoji.initAnimojiEngine");
                this.f21160F = new ArcSoftAvatarEngine(context);
                jInitialize = this.f21160F.initialize(strM22507C.concat("/data/track_data.dat"), strM22507C.concat("/data/config.txt"), 1);
                CameraLog.m12959b("AnimojiTexturePreview", "initAnimojiEngine, end, mCurrentTemplatePath: " + this.f21155A + ", initResult: " + jInitialize);
                this.f21181y = m22521q();
                this.f21179w = true;
                CameraLog.m12958b("Animoji.initAnimojiEngine");
                CameraLog.m12959b("AnimojiTexturePreview", "initAnimojiEngine, end, initResult: " + jInitialize + ", dataPath: " + strM22507C);
            }
        }
        return jInitialize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m22522r() {
        CameraLog.m12959b("AnimojiTexturePreview", "unInitAnimojiEngine, mbInitialized: " + this.f21179w + ", mAvatarEngineRender: " + this.f21160F);
        if (!this.f21179w || this.f21160F == null) {
            return;
        }
        CameraLog.m12952a("Animoji.unInitAnimojiEngine");
        this.f21160F.uninitialize();
        this.f21160F = null;
        this.f21161G = null;
        this.f21173q = false;
        this.f21159E = false;
        this.f21162H = null;
        this.f21179w = false;
        this.f21181y = false;
        CameraLog.m12958b("Animoji.unInitAnimojiEngine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m22505A() {
        CameraLog.m12959b("AnimojiTexturePreview", "releaseAnimojiRender, mbInitialized: " + this.f21179w + ", mAvatarEngineRender: " + this.f21160F);
        if (this.f21179w && this.f21160F != null) {
            CameraLog.m12952a("Animoji.releaseAnimojiRender");
            this.f21160F.releaseRender();
            ArcSoftOffscreen arcSoftOffscreen = this.f21161G;
            if (arcSoftOffscreen != null) {
                arcSoftOffscreen.setData(null);
            }
            ArcSoftOffscreen arcSoftOffscreen2 = this.f21162H;
            if (arcSoftOffscreen2 != null) {
                arcSoftOffscreen2.setData(null);
            }
            CameraLog.m12958b("Animoji.releaseAnimojiRender");
        }
        CameraLog.m12959b("AnimojiTexturePreview", "releaseAnimojiEngine, end");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        synchronized (this.f21167k) {
            Util.m24389b(this.f21166d);
            Util.m24279a(this.f21166d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m22506B() throws Throwable {
        StickerItem stickerItemM22398o = this.f21178v.m22398o();
        if (stickerItemM22398o == null) {
            CameraLog.m12967f("AnimojiTexturePreview", "initTemplateResource, item is null");
            return;
        }
        CameraLog.m12952a("Animoji.initTemplateResource");
        String fileContentUri = stickerItemM22398o.getFileContentUri();
        String stickerName = stickerItemM22398o.getStickerName();
        AnimojiStickerExtendedInfo animojiStickerExtendedInfoM16955b = StickerItemDBHelper.m16955b(this.f21546j, stickerItemM22398o);
        String backgroundColor = animojiStickerExtendedInfoM16955b != null ? animojiStickerExtendedInfoM16955b.getBackgroundColor() : "#F5E274";
        String str = m22507C() + File.separator + stickerName;
        if (this.f21546j != null) {
            ImageStickerTools.m22687b(this.f21546j);
            boolean zM22514a = m22514a(ImageStickerTools.m22685a(this.f21546j, fileContentUri), str);
            synchronized (this.f21167k) {
                long template = -1;
                CameraLog.m12959b("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + zM22514a);
                boolean z = true;
                if (zM22514a) {
                    this.f21155A = m22511a(stickerName);
                    if (backgroundColor != null) {
                        int color = Color.parseColor(backgroundColor);
                        this.f21171o[0] = Color.red(color) / 255.0f;
                        this.f21171o[1] = Color.green(color) / 255.0f;
                        this.f21171o[2] = Color.blue(color) / 255.0f;
                    }
                    if (this.f21160F != null) {
                        template = this.f21160F.setTemplate(this.f21155A);
                    }
                }
                CameraLog.m12958b("Animoji.initTemplateResource");
                CameraLog.m12959b("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + zM22514a + ", templateResult: " + template);
                if (0 != template) {
                    z = false;
                }
                this.f21173q = z;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m22511a(String str) {
        File[] fileArrListFiles;
        File file = new File(m22507C() + File.separator + str);
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return null;
        }
        return fileArrListFiles[0].getPath();
    }

    /* renamed from: C */
    private String m22507C() {
        if (this.f21156B == null && this.f21546j != null) {
            this.f21156B = this.f21546j.getExternalCacheDir().getPath() + "/animoji";
        }
        return this.f21156B;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        this.f21172p = new RawTexture(this.f21168l, this.f21169m, true);
        this.f21180x = true;
        CameraLog.m12954a("AnimojiTexturePreview", "newTextures, mOutputAnimojiTexture: " + this.f21172p);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("AnimojiTexturePreview", "recycleTextures, mbTextureInited: " + this.f21180x + ", mOutputAnimojiTexture: " + this.f21172p);
        if (this.f21180x) {
            RawTexture c2768s = this.f21172p;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21172p = null;
            }
            this.f21180x = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b("AnimojiTexturePreview", "setSize, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", mWidth: " + this.f21168l + ", mHeight: " + this.f21169m);
        this.f21174r = (OplusGLSurfaceView_13 == this.f21168l && i2 == this.f21169m) ? false : true;
        this.f21168l = OplusGLSurfaceView_13;
        this.f21169m = i2;
        if (!this.f21174r || this.f21544h == null) {
            return;
        }
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AnimojiTexturePreview.this.f21167k) {
                    AnimojiTexturePreview.this.m22505A();
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21170n = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22523a(Size size, boolean z) {
        synchronized (this.f21167k) {
            this.f21175s = true;
            this.f21176t = z;
            this.f21177u = size;
            CameraLog.m12959b("AnimojiTexturePreview", "capture, mOutputOffscreen: " + this.f21163I + ", mbMirror: " + this.f21176t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m22512a(File file, String str) throws Throwable {
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        ArrayList arrayList = new ArrayList();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String name = zipEntryNextElement.getName();
            if (!name.contains("../")) {
                InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                String strReplaceAll = (str + File.separator + name).replaceAll("\\*", File.separator);
                File file3 = new File(strReplaceAll);
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File file4 = new File(strReplaceAll.substring(0, strReplaceAll.lastIndexOf(File.separator)));
                        if (!file4.exists()) {
                            file4.mkdirs();
                        }
                        if (!file3.isDirectory()) {
                            if (file3.getName().toLowerCase().endsWith(".zip")) {
                                arrayList.add(file3.getPath());
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int OplusGLSurfaceView_13 = inputStream.read(bArr);
                                    if (OplusGLSurfaceView_13 <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, OplusGLSurfaceView_13);
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                fileOutputStream2.close();
                            } catch (Exception COUIBaseListPopupWindow_8) {
                                fileOutputStream = fileOutputStream2;
                                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                                COUIBaseListPopupWindow_8.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } else if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e2) {
                        COUIBaseListPopupWindow_8 = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        zipFile.close();
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file5 = new File((String) it.next());
                m22512a(file5, file5.getParentFile().getPath());
                file5.delete();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22514a(byte[] bArr, String str) throws Throwable {
        boolean z = false;
        if (bArr == null || str == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if (!new File(str).exists()) {
                        String strConcat = str.concat(".zip");
                        File file = new File(strConcat);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            m22512a(file, strConcat.substring(0, strConcat.lastIndexOf(".zip")));
                            file.delete();
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                            fileOutputStream = fileOutputStream2;
                            COUIBaseListPopupWindow_8.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    z = true;
                } catch (Exception e3) {
                    COUIBaseListPopupWindow_8 = e3;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22513a(Context context, String str, String str2, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        String str3;
        File file;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!new File(str2).exists() || z) {
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                fileInputStream = new FileInputStream(str);
                try {
                    try {
                        String[] strArrSplit = str.split(File.separator);
                        str3 = str2 + File.separator + strArrSplit[strArrSplit.length - 1];
                        file = new File(str3);
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int OplusGLSurfaceView_13 = fileInputStream.read(bArr);
                        if (OplusGLSurfaceView_13 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    }
                    m22512a(file, str3.substring(0, str3.lastIndexOf(".zip")));
                    file.delete();
                    fileOutputStream2 = fileOutputStream;
                } catch (Exception e2) {
                    COUIBaseListPopupWindow_8 = e2;
                    fileOutputStream2 = fileOutputStream;
                    COUIBaseListPopupWindow_8.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } else {
                fileInputStream = null;
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return true;
                }
            }
            if (fileInputStream == null) {
                return true;
            }
            fileInputStream.close();
            return true;
        } catch (Exception e6) {
            COUIBaseListPopupWindow_8 = e6;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
