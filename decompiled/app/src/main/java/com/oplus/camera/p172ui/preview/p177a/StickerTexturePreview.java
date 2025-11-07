package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.sticker.MaterailInfo;
import com.oplus.camera.sticker.STStickerContainer;
import com.oplus.camera.sticker.StickerCaptureInfo;
import com.oplus.camera.sticker.StickerItemDBHelper;
import com.oplus.camera.sticker.data.MultiStickerExtendedInfo;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.sensetime.stmobile.STGLRender;
import com.sensetime.stmobile.STMobileHardwareBufferNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STSoundPlayManager;
import com.sensetime.stmobile.model.STHumanAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StickerTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.w */
/* loaded from: classes2.dex */
public class StickerTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21495a = "0ms";

    /* renamed from: A */
    private Map<Long, Integer> f21496A;

    /* renamed from: B */
    private Map<Long, Integer> f21497B;

    /* renamed from: C */
    private boolean f21498C;

    /* renamed from: D */
    private boolean f21499D;

    /* renamed from: E */
    private float f21500E;

    /* renamed from: F */
    private final Object f21501F;

    /* renamed from: G */
    private StickerCaptureInfo f21502G;

    /* renamed from: H */
    private ConcurrentHashMap<MaterailInfo, List<MultiStickerExtendedInfo>> f21503H;

    /* renamed from: I */
    private CopyOnWriteArrayList<MaterailInfo> f21504I;

    /* renamed from: J */
    private STMobileHumanActionNative f21505J;

    /* renamed from: K */
    private STMobileHardwareBufferNative f21506K;

    /* renamed from: L */
    private STGLRender f21507L;

    /* renamed from: M */
    private byte[] f21508M;

    /* renamed from: N */
    private Handler f21509N;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21510b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21511c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21512d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21513k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21514l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f21515m;

    /* renamed from: OplusGLSurfaceView_11 */
    private volatile int f21516n;

    /* renamed from: o */
    private int f21517o;

    /* renamed from: p */
    private ArrayList<RawTexture> f21518p;

    /* renamed from: q */
    private RawTexture f21519q;

    /* renamed from: r */
    private RawTexture f21520r;

    /* renamed from: s */
    private RawTexture f21521s;

    /* renamed from: t */
    private boolean f21522t;

    /* renamed from: u */
    private boolean f21523u;

    /* renamed from: v */
    private volatile boolean f21524v;

    /* renamed from: w */
    private TexturePreviewRequest f21525w;

    /* renamed from: x */
    private STSoundPlayManager f21526x;

    /* renamed from: y */
    private ArrayList<Long> f21527y;

    /* renamed from: z */
    private ArrayList<Long> f21528z;

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22957a(long OplusGLSurfaceView_15) {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22523a(Size size, boolean z) {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 8;
    }

    public StickerTexturePreview(Context context) {
        super(context);
        this.f21510b = 0;
        this.f21511c = 0;
        this.f21512d = 0;
        this.f21513k = 0;
        this.f21514l = 0;
        this.f21515m = false;
        this.f21516n = 0;
        this.f21517o = 0;
        this.f21518p = new ArrayList<>();
        this.f21519q = null;
        this.f21520r = null;
        this.f21521s = null;
        this.f21522t = false;
        this.f21523u = false;
        this.f21524v = false;
        this.f21525w = null;
        this.f21526x = null;
        this.f21527y = null;
        this.f21528z = null;
        this.f21496A = null;
        this.f21497B = null;
        this.f21498C = true;
        this.f21499D = false;
        this.f21500E = 1.0f;
        this.f21501F = new Object();
        this.f21502G = null;
        this.f21503H = null;
        this.f21504I = new CopyOnWriteArrayList<>();
        this.f21505J = null;
        this.f21506K = null;
        this.f21507L = null;
        this.f21508M = null;
        this.f21509N = null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        this.f21525w = c3397aa;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("StickerTexturePreview", "destroyEngine");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21521s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21520r;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21516n = OplusGLSurfaceView_13;
        int i2 = this.f21516n;
        if (i2 == 0) {
            this.f21517o = 0;
            return;
        }
        if (i2 == 90) {
            this.f21517o = 1;
        } else if (i2 == 180) {
            this.f21517o = 2;
        } else {
            if (i2 != 270) {
                return;
            }
            this.f21517o = 3;
        }
    }

    /* renamed from: A */
    private void m22932A() {
        if (this.f21497B == null) {
            this.f21497B = new HashMap();
            this.f21497B.put(2L, Integer.valueOf(R.string.sticker_hint_blink));
            this.f21497B.put(4L, Integer.valueOf(R.string.sticker_hint_open_month));
            this.f21497B.put(8L, Integer.valueOf(R.string.sticker_hint_shake_head));
            this.f21497B.put(16L, Integer.valueOf(R.string.sticker_hint_node_head));
            this.f21497B.put(32L, Integer.valueOf(R.string.sticker_hint_pick_eyebrow));
        }
        if (this.f21496A == null) {
            this.f21496A = new HashMap();
            this.f21496A.put(4096L, Integer.valueOf(R.string.sticker_hint_show_palm));
            this.f21496A.put(16384L, Integer.valueOf(R.string.sticker_hint_heart_shape_two_hand));
            this.f21496A.put(32768L, Integer.valueOf(R.string.sticker_hint_hold_up_hand));
            this.f21496A.put(131072L, Integer.valueOf(R.string.sticker_hint_congratulate));
            this.f21496A.put(262144L, Integer.valueOf(R.string.sticker_hint_heart_shape_one_hand));
            this.f21496A.put(2048L, Integer.valueOf(R.string.sticker_hint_thumb_up));
            this.f21496A.put(512L, Integer.valueOf(R.string.sticker_hint_ok));
            this.f21496A.put(1024L, Integer.valueOf(R.string.sticker_hint_yeah));
            this.f21496A.put(8192L, Integer.valueOf(R.string.sticker_hint_pistol));
            this.f21496A.put(1048576L, Integer.valueOf(R.string.sticker_hint_index_finger));
        }
    }

    /* renamed from: B */
    private void m22933B() {
        if (!this.f21523u && this.f21522t && this.f21524v) {
            CameraLog.m12952a("initGLRes");
            CameraLog.m12954a("StickerTexturePreview", "initGLRes");
            synchronized (this.f21501F) {
                m22938G();
            }
            this.f21526x = new STSoundPlayManager(this.f21546j);
            synchronized (this.f21501F) {
                this.f21523u = true;
            }
            CameraLog.m12958b("initGLRes");
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo22958m() throws IllegalStateException {
        STSoundPlayManager sTSoundPlayManager = this.f21526x;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.pauseSound();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo22959n() throws IllegalStateException {
        STSoundPlayManager sTSoundPlayManager = this.f21526x;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.resumeSound();
        }
    }

    /* renamed from: C */
    private void m22934C() {
        STSoundPlayManager sTSoundPlayManager = this.f21526x;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.release();
            this.f21526x = null;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("StickerTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2 + ", mCameraId: " + this.f21542f);
        if (i2 <= 0 || OplusGLSurfaceView_13 <= 0) {
            return;
        }
        this.f21510b = OplusGLSurfaceView_13;
        this.f21511c = i2;
    }

    /* renamed from: D */
    private void m22935D() {
        if (this.f21510b == 0 || this.f21511c == 0) {
            return;
        }
        this.f21512d = this.f21543g ? 320 : CameraParameter.VideoFps.FPS_480;
        int OplusGLSurfaceView_13 = this.f21510b;
        int i2 = this.f21511c;
        if (OplusGLSurfaceView_13 >= i2) {
            int i3 = this.f21512d;
            this.f21500E = OplusGLSurfaceView_13 / i3;
            this.f21513k = i3;
            this.f21514l = (i2 * i3) / OplusGLSurfaceView_13;
        } else {
            int i4 = this.f21512d;
            this.f21500E = i2 / i4;
            this.f21514l = i4;
            this.f21513k = (OplusGLSurfaceView_13 * i4) / i2;
        }
        CameraLog.m12954a("StickerTexturePreview", "checkInitActionDetectImageSize, mActionDetectImageWidth: " + this.f21513k + ", mActionDetectImageHeight: " + this.f21514l);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: o */
    public void mo22960o() {
        if (this.f21545i != null) {
            this.f21545i.mo22926a();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: p */
    public void mo22961p() {
        ConcurrentHashMap<MaterailInfo, List<MultiStickerExtendedInfo>> concurrentHashMap = this.f21503H;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        this.f21503H.clear();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() throws Throwable {
        StickerItem stickerItemM22398o = this.f21525w.m22398o();
        if (!this.f21522t || stickerItemM22398o == null) {
            CameraLog.m12967f("StickerTexturePreview", "updateMaterialInfos, mbTextureInited: " + this.f21522t + ", item: " + stickerItemM22398o);
            return false;
        }
        CameraLog.m12952a("Sticker.onPreviewEffectChanged");
        m22936E();
        this.f21499D = true;
        HashMap<String, List<MultiStickerExtendedInfo>> mapM22942a = m22942a(stickerItemM22398o.getStickerName());
        HashMap<String, MaterailInfo> mapM22943a = m22943a(mapM22942a);
        ConcurrentHashMap<MaterailInfo, List<MultiStickerExtendedInfo>> concurrentHashMap = this.f21503H;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        } else {
            this.f21503H = new ConcurrentHashMap<>();
        }
        if (mapM22943a != null) {
            for (String str : mapM22943a.keySet()) {
                this.f21503H.put(mapM22943a.get(str), mapM22942a.get(str));
            }
        }
        CameraLog.m12958b("Sticker.onPreviewEffectChanged");
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HashMap<String, List<MultiStickerExtendedInfo>> m22942a(String str) throws Throwable {
        StickerItem stickerItemM22398o = this.f21525w.m22398o();
        if (stickerItemM22398o == null) {
            CameraLog.m12967f("StickerTexturePreview", "getExtendedInfoMap, item is null");
            return null;
        }
        List<MultiStickerExtendedInfo> listM16954a = StickerItemDBHelper.m16954a(this.f21546j, stickerItemM22398o);
        HashMap<String, List<MultiStickerExtendedInfo>> map = new HashMap<>();
        if (listM16954a != null && listM16954a.size() > 0) {
            for (MultiStickerExtendedInfo multiStickerExtendedInfo : listM16954a) {
                if (multiStickerExtendedInfo != null) {
                    if (map.containsKey(multiStickerExtendedInfo.getStickerName())) {
                        map.get(multiStickerExtendedInfo.getStickerName()).add(multiStickerExtendedInfo);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(multiStickerExtendedInfo);
                        map.put(multiStickerExtendedInfo.getStickerName(), arrayList);
                    }
                }
            }
        } else {
            map.put(str, new ArrayList());
        }
        return map;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HashMap<String, MaterailInfo> m22943a(HashMap<String, List<MultiStickerExtendedInfo>> map) {
        String strM16800a;
        RawTexture c2768s;
        StickerItem stickerItemM22398o = this.f21525w.m22398o();
        if (stickerItemM22398o == null || map == null) {
            CameraLog.m12967f("StickerTexturePreview", "getMaterialInfoMap, item: " + stickerItemM22398o + ", extendedInfoMap: " + map);
            return null;
        }
        String fileContentUri = stickerItemM22398o.getFileContentUri();
        HashMap<String, MaterailInfo> map2 = new HashMap<>();
        synchronized (this.f21501F) {
            String str = fileContentUri;
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            for (String str2 : map.keySet()) {
                List<MultiStickerExtendedInfo> list = map.get(str2);
                if (OplusGLSurfaceView_13 >= this.f21504I.size()) {
                    CameraLog.m12967f("StickerTexturePreview", "getMaterialInfoMap, Just support " + this.f21504I.size() + " materials.");
                } else {
                    int i3 = OplusGLSurfaceView_13 + 1;
                    MaterailInfo c2974b = this.f21504I.get(OplusGLSurfaceView_13);
                    if (list != null && list.size() > 0) {
                        if (list.get(0).getPositionType() == 0) {
                            c2768s = this.f21519q;
                        } else if (list.get(0).getPositionType() == 2) {
                            c2768s = this.f21520r;
                        } else {
                            c2768s = this.f21518p.get(i2);
                            i2++;
                        }
                        strM16800a = STStickerContainer.m16800a(list.get(0), Util.m24426d(this.f21511c, this.f21510b));
                    } else {
                        strM16800a = str;
                        c2768s = this.f21520r;
                    }
                    c2974b.m16774a(this.f21510b / c2768s.mo13935f());
                    c2974b.m16776a(c2768s);
                    m22948a(c2974b, strM16800a);
                    map2.put(str2, c2974b);
                    str = strM16800a;
                    OplusGLSurfaceView_13 = i3;
                }
            }
        }
        return map2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22948a(MaterailInfo c2974b, String str) throws Resources.NotFoundException, IOException {
        CameraLog.m12954a("StickerTexturePreview", "changeStickerNative, sticker: " + str);
        ImageStickerTools.m22687b(this.f21546j);
        byte[] bArrM22685a = ImageStickerTools.m22685a(this.f21546j, str);
        if (bArrM22685a != null) {
            c2974b.m16773a().changeStickerFromBuffer(bArrM22685a, bArrM22685a.length);
        } else {
            CameraLog.m12967f("StickerTexturePreview", "changeStickerNative failed, bytes: " + bArrM22685a);
        }
        mo22960o();
        m22953b(c2974b.m16773a().getTriggerAction());
        m22949a(c2974b, str, c2974b.m16773a().getTriggerAction());
    }

    /* renamed from: E */
    private void m22936E() {
        StickerItem stickerItemM22398o = this.f21525w.m22398o();
        if (stickerItemM22398o != null) {
            ImageStickerTools c3420qM22687b = ImageStickerTools.m22687b(this.f21546j);
            STSoundPlayManager sTSoundPlayManager = this.f21526x;
            if (sTSoundPlayManager != null) {
                sTSoundPlayManager.setPauseState(c3420qM22687b.m22717a(stickerItemM22398o.getStickerUUID()));
                return;
            }
            return;
        }
        CameraLog.m12967f("StickerTexturePreview", "checkStickerMusicPauseState, non selected sticker!");
    }

    /* renamed from: F */
    private void m22937F() {
        if (this.f21504I != null) {
            CameraLog.m12967f("StickerTexturePreview", "destroyStInstance");
            Iterator<MaterailInfo> it = this.f21504I.iterator();
            while (it.hasNext()) {
                MaterailInfo next = it.next();
                if (next != null) {
                    next.m16773a().destroyInstance();
                }
            }
            this.f21504I.clear();
        }
    }

    /* renamed from: G */
    private void m22938G() {
        CopyOnWriteArrayList<MaterailInfo> copyOnWriteArrayList = this.f21504I;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() != 0) {
            return;
        }
        CameraLog.m12967f("StickerTexturePreview", "createStInstance");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 5; OplusGLSurfaceView_13++) {
            MaterailInfo c2974b = new MaterailInfo();
            c2974b.m16773a().createInstance(Util.m24472l());
            this.f21504I.add(c2974b);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
        if (this.f21509N == null) {
            HandlerThread handlerThread = new HandlerThread("InitResThread");
            handlerThread.start();
            this.f21509N = new Handler(handlerThread.getLooper());
        }
        this.f21509N.post(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.w.1
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12952a("Sticker.initHumanAction");
                synchronized (StickerTexturePreview.this.f21501F) {
                    StickerTexturePreview.this.m22963r();
                    StickerTexturePreview.this.f21524v = true;
                }
                CameraLog.m12958b("Sticker.initHumanAction");
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("StickerTexturePreview", "newTextures");
        CameraLog.m12952a("Sticker.newTextures");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            this.f21518p.add(new RawTexture(this.f21510b / 2, this.f21511c / 2, true));
        }
        this.f21519q = new RawTexture(this.f21510b, this.f21511c, true);
        this.f21520r = new RawTexture(this.f21510b, this.f21511c, true);
        this.f21521s = new RawTexture(this.f21510b, this.f21511c, true);
        this.f21522t = true;
        CameraLog.m12958b("Sticker.newTextures");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        m22933B();
        CameraLog.m12952a("Sticker.prepareTextures");
        ArrayList<RawTexture> arrayList = this.f21518p;
        if (arrayList != null) {
            Iterator<RawTexture> it = arrayList.iterator();
            while (it.hasNext()) {
                RawTexture next = it.next();
                if (next != null && !next.m13943n()) {
                    next.m14193c(interfaceC2757h);
                    CameraLog.m12954a("StickerTexturePreview", "prepareTextures, texture id_renamed: " + next.m13934e());
                }
            }
        }
        RawTexture c2768s = this.f21519q;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21519q.m14193c(interfaceC2757h);
            CameraLog.m12954a("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.f21519q.m13934e());
        }
        RawTexture c2768s2 = this.f21520r;
        if (c2768s2 != null && !c2768s2.m13943n()) {
            this.f21520r.m14193c(interfaceC2757h);
            CameraLog.m12954a("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.f21520r.m13934e());
        }
        RawTexture c2768s3 = this.f21521s;
        if (c2768s3 != null && !c2768s3.m13943n()) {
            this.f21521s.m14193c(interfaceC2757h);
            CameraLog.m12954a("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.f21521s.m13934e());
        }
        CameraLog.m12958b("Sticker.prepareTextures");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("StickerTexturePreview", "recycleTextures, mbGLInit: " + this.f21523u + ", mbTextureInited: " + this.f21522t);
        if (this.f21523u) {
            CameraLog.m12952a("Sticker.eglInit");
            synchronized (this.f21501F) {
                if (this.f21505J != null) {
                    this.f21505J.reset();
                }
            }
            this.f21515m = false;
            m22934C();
            Map<Long, Integer> map = this.f21496A;
            if (map != null) {
                map.clear();
                this.f21496A = null;
            }
            Map<Long, Integer> map2 = this.f21497B;
            if (map2 != null) {
                map2.clear();
                this.f21497B = null;
            }
            mo22960o();
            this.f21523u = false;
            CameraLog.m12958b("Sticker.eglInit");
        }
        if (this.f21522t) {
            CameraLog.m12952a("Sticker.recycleTextures");
            ArrayList<RawTexture> arrayList = this.f21518p;
            if (arrayList != null) {
                Iterator<RawTexture> it = arrayList.iterator();
                while (it.hasNext()) {
                    RawTexture next = it.next();
                    if (next != null) {
                        CameraLog.m12954a("StickerTexturePreview", "recycleTextures, texture id_renamed: " + next.m13934e());
                        next.mo13944o();
                    }
                }
                this.f21518p.clear();
            }
            if (this.f21519q != null) {
                CameraLog.m12954a("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.f21519q.m13934e());
                this.f21519q.mo13944o();
                this.f21519q = null;
            }
            if (this.f21520r != null) {
                CameraLog.m12954a("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.f21520r.m13934e());
                this.f21520r.mo13944o();
                this.f21520r = null;
            }
            if (this.f21521s != null) {
                CameraLog.m12954a("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.f21521s.m13934e());
                this.f21521s.mo13944o();
                this.f21521s = null;
            }
            STMobileHardwareBufferNative sTMobileHardwareBufferNative = this.f21506K;
            if (sTMobileHardwareBufferNative != null) {
                sTMobileHardwareBufferNative.release();
                this.f21506K = null;
                this.f21508M = null;
                STGLRender sTGLRender = this.f21507L;
                if (sTGLRender != null) {
                    sTGLRender.destroy();
                    this.f21507L = null;
                }
            }
            this.f21522t = false;
            CameraLog.m12958b("Sticker.recycleTextures");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22949a(MaterailInfo c2974b, String str, long OplusGLSurfaceView_15) {
        if (str == null) {
            OplusGLSurfaceView_15 = 0;
        }
        c2974b.m16775a(OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22950a(STHumanAction sTHumanAction) {
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            c2974b.m16780b(sTHumanAction);
            c2974b.m16777a(sTHumanAction);
            m22954b(c2974b.m16779b(this.f21500E));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m22952b(RawTexture c2768s) throws IOException {
        CameraLog.m12952a("processNoFrontTexture");
        int iProcessTexture = -1;
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            List<MultiStickerExtendedInfo> list = this.f21503H.get(c2974b);
            if (list == null || list.size() == 0 || list.get(0).getPositionType() != 0) {
                GLES20Canvas.m14010i();
                iProcessTexture = c2974b.m16773a().processTexture(c2768s.m13934e(), c2974b.m16779b(this.f21500E), this.f21517o, c2974b.m16781c().mo13935f(), c2974b.m16781c().mo13936g(), 0, 0, false, null, c2974b.m16781c().m13934e());
                GLES20Canvas.m14010i();
                if (Util.m24390b()) {
                    Util.m24276a(c2974b.m16781c(), "NONFORE");
                }
            }
        }
        CameraLog.m12958b("processNoFrontTexture");
        return iProcessTexture;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22944a(GLCanvas interfaceC2757h, RawTexture c2768s) throws IOException {
        if (m22955c(c2768s)) {
            m22945a(interfaceC2757h, c2768s, -16777216);
        }
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            List<MultiStickerExtendedInfo> list = this.f21503H.get(c2974b);
            if (list != null && list.size() > 0) {
                for (MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!c2974b.m16781c().equals(c2768s)) {
                        RectF rectFM16799a = STStickerContainer.m16799a(multiStickerExtendedInfo, c2768s.mo13935f(), c2768s.mo13936g());
                        m22947a(interfaceC2757h, c2974b.m16781c(), c2768s, STStickerContainer.m16798a(c2974b.m16781c().mo13935f(), c2974b.m16781c().mo13936g(), rectFM16799a), rectFM16799a);
                        if (Util.m24390b()) {
                            Util.m24276a(c2768s, "OUTPUT");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22940a(int OplusGLSurfaceView_13, RawTexture c2768s) throws IOException {
        int iProcessTexture = OplusGLSurfaceView_13;
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            List<MultiStickerExtendedInfo> list = this.f21503H.get(c2974b);
            if (list != null && list.size() > 0 && list.get(0).getPositionType() == 0) {
                GLES20Canvas.m14010i();
                iProcessTexture = c2974b.m16773a().processTexture(c2974b.m16781c().m13934e(), c2974b.m16779b(this.f21500E), this.f21517o, c2974b.m16781c().mo13935f(), c2974b.m16781c().mo13936g(), 0, 0, false, null, c2768s.m13934e());
                GLES20Canvas.m14010i();
                if (Util.m24390b()) {
                    Util.m24276a(c2768s, "FORE");
                }
            }
        }
        return iProcessTexture;
    }

    /* renamed from: H */
    private RawTexture m22939H() {
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            List<MultiStickerExtendedInfo> list = this.f21503H.get(c2974b);
            if (list != null && list.size() > 0 && list.get(0).getPositionType() == 0) {
                return c2974b.m16781c();
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m22955c(RawTexture c2768s) {
        boolean z = false;
        boolean z2 = false;
        for (MaterailInfo c2974b : this.f21503H.keySet()) {
            List<MultiStickerExtendedInfo> list = this.f21503H.get(c2974b);
            if (list != null && list.size() > 0) {
                for (MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!c2974b.m16781c().equals(c2768s)) {
                        z2 = true;
                    }
                }
                if (list.get(0).getPositionType() == 2) {
                    z = true;
                }
            }
        }
        return !z && z2;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        return this.f21525w != null && mo22673a_(OplusGLSurfaceView_13) && this.f21522t && this.f21525w.m22401r() && this.f21525w.m22402s() && !ImageStickerTools.m22691b(this.f21525w.m22398o());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) throws IOException {
        long jM11591a = AlgoListProcessor.m11591a();
        if (aVar == null) {
            CameraLog.m12967f("StickerTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        int iM22952b = -1;
        if (this.f21525w != null && aVar.f21549c != null) {
            if (!this.f21515m) {
                if (this.f21523u && mo22293h()) {
                    this.f21515m = true;
                } else {
                    m22946a(aVar.f21547a, this.f21521s, this.f21520r);
                    CameraLog.m12967f("StickerTexturePreview", "process, non selected sticker!");
                    return false;
                }
            }
            if (this.f21506K == null) {
                m22935D();
                this.f21506K = new STMobileHardwareBufferNative();
                this.f21506K.init(this.f21513k, this.f21514l, 0, 1);
                this.f21508M = new byte[this.f21513k * this.f21514l * 4];
                if (this.f21507L == null) {
                    this.f21507L = new STGLRender();
                    this.f21507L.init(this.f21510b, this.f21511c);
                }
            }
            m22956e(aVar.f21549c.m13934e());
            iM22952b = m22952b(aVar.f21549c);
            RawTexture c2768sM22939H = m22939H();
            if (c2768sM22939H != null) {
                m22944a(aVar.f21547a, c2768sM22939H);
                iM22952b = m22940a(iM22952b, this.f21520r);
            } else {
                m22944a(aVar.f21547a, this.f21520r);
            }
            OpenGLUtils.m24594a("process");
        } else if (this.f21525w == null) {
            CameraLog.m12954a("StickerTexturePreview", "process, mRequest is null");
        }
        if (iM22952b != 0) {
            CameraLog.m12967f("StickerTexturePreview", "process, result: " + iM22952b);
        }
        f21495a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return iM22952b == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m22956e(int OplusGLSurfaceView_13) {
        STHumanAction sTHumanActionHumanActionDetect;
        CameraLog.m12952a("doHumanActionDetect");
        int textureId = this.f21506K.getTextureId();
        this.f21507L.copyTexture(this.f21507L.resizeTexture(OplusGLSurfaceView_13, this.f21513k, this.f21514l, 0), textureId, this.f21513k, this.f21514l);
        this.f21506K.downloadRgbaImage(this.f21513k, this.f21514l, this.f21508M);
        synchronized (this.f21501F) {
            m22963r();
            sTHumanActionHumanActionDetect = this.f21505J.humanActionDetect(this.f21508M, 6, STStickerContainer.m16797a(this.f21503H), this.f21517o, this.f21513k, this.f21514l);
        }
        m22950a(sTHumanActionHumanActionDetect);
        CameraLog.m12958b("doHumanActionDetect");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22946a(GLCanvas interfaceC2757h, RawTexture c2768s, RawTexture c2768s2) {
        interfaceC2757h.mo13975a(c2768s2);
        interfaceC2757h.mo13968a(c2768s, 0, 0, c2768s2.mo13935f(), c2768s2.mo13936g());
        interfaceC2757h.mo13987h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22947a(GLCanvas interfaceC2757h, RawTexture c2768s, RawTexture c2768s2, RectF rectF, RectF rectF2) {
        interfaceC2757h.mo13975a(c2768s2);
        interfaceC2757h.mo13971a(c2768s, rectF, rectF2);
        interfaceC2757h.mo13987h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22945a(GLCanvas interfaceC2757h, RawTexture c2768s, int OplusGLSurfaceView_13) {
        interfaceC2757h.mo13975a(c2768s);
        interfaceC2757h.mo13963a(0.0f, 0.0f, c2768s.m13937h(), c2768s.m13938i(), OplusGLSurfaceView_13);
        interfaceC2757h.mo13987h();
    }

    /* renamed from: q */
    public void m22962q() {
        CameraLog.m12954a("StickerTexturePreview", "destroyHumanAction");
        STMobileHumanActionNative sTMobileHumanActionNative = this.f21505J;
        if (sTMobileHumanActionNative != null) {
            sTMobileHumanActionNative.reset();
            this.f21505J.destroyInstance();
            this.f21505J.destroyInstanceImage();
            this.f21505J = null;
        }
        this.f21524v = false;
    }

    /* renamed from: r */
    public void m22963r() {
        if (this.f21505J == null) {
            CameraLog.m12954a("StickerTexturePreview", "initNativeInstance");
            this.f21505J = new STMobileHumanActionNative();
            int iCreateInstanceFromAssetFile = this.f21505J.createInstanceFromAssetFile("M_SenseME_Action_5.2.12.model", STStickerContainer.f16204a, Util.m24472l().getAssets());
            int iCreateInstanceImage = this.f21505J.createInstanceImage("M_SenseME_Action_5.2.12.model", STStickerContainer.f16205b, Util.m24472l().getAssets());
            if (iCreateInstanceFromAssetFile == 0) {
                this.f21505J.setParam(2, 0.3f);
                this.f21505J.setParam(1, 320.0f);
                this.f21505J.setParam(20, 0.2f);
                this.f21505J.setParam(3, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STICKER_SUPPORT_MAX_FACE_NUM));
            }
            if (iCreateInstanceImage == 0) {
                this.f21505J.setParamImage(2, 0.1f);
                this.f21505J.setParamImage(1, 640.0f);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
        Handler handler = this.f21509N;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f21509N = null;
        }
        m22937F();
        synchronized (this.f21501F) {
            if (this.f21503H != null) {
                this.f21503H.clear();
                this.f21503H = null;
            }
            m22962q();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22953b(long OplusGLSurfaceView_15) throws Resources.NotFoundException {
        if (this.f21527y == null) {
            this.f21527y = new ArrayList<>();
        }
        this.f21527y.clear();
        if (this.f21528z == null) {
            this.f21528z = new ArrayList<>();
        }
        this.f21528z.clear();
        m22932A();
        Set<Long> setKeySet = this.f21497B.keySet();
        Set<Long> setKeySet2 = this.f21496A.keySet();
        if (setKeySet != null) {
            Iterator<Long> it = setKeySet.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (OplusGLSurfaceView_15 >= 0 && (OplusGLSurfaceView_15 & jLongValue) > 0) {
                    this.f21527y.add(Long.valueOf(jLongValue));
                }
            }
        }
        if (setKeySet2 != null) {
            Iterator<Long> it2 = setKeySet2.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = it2.next().longValue();
                if (OplusGLSurfaceView_15 >= 0 && (OplusGLSurfaceView_15 & jLongValue2) > 0) {
                    this.f21528z.add(Long.valueOf(jLongValue2));
                }
            }
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f21527y.size(); OplusGLSurfaceView_13++) {
            if (this.f21545i != null) {
                this.f21498C = false;
                this.f21545i.mo22930a(this.f21546j.getResources().getString(this.f21497B.get(this.f21527y.get(OplusGLSurfaceView_13)).intValue()));
                return;
            }
        }
        for (int i2 = 0; i2 < this.f21528z.size(); i2++) {
            if (this.f21545i != null) {
                this.f21498C = false;
                this.f21545i.mo22930a(this.f21546j.getResources().getString(this.f21496A.get(this.f21528z.get(i2)).intValue()));
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22954b(STHumanAction sTHumanAction) {
        ArrayList<Long> arrayList;
        ArrayList<Long> arrayList2;
        if (sTHumanAction == null || this.f21498C) {
            return;
        }
        if (sTHumanAction.faceCount > 0 && (arrayList2 = this.f21527y) != null && arrayList2.size() > 0) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sTHumanAction.faceCount; OplusGLSurfaceView_13++) {
                long OplusGLSurfaceView_15 = sTHumanAction.faces[OplusGLSurfaceView_13].faceAction;
                for (int i2 = 0; i2 < this.f21527y.size(); i2++) {
                    if ((this.f21527y.get(i2).longValue() & OplusGLSurfaceView_15) > 0) {
                        this.f21498C = true;
                        mo22960o();
                        return;
                    }
                }
            }
        }
        if (sTHumanAction.handCount <= 0 || (arrayList = this.f21528z) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < sTHumanAction.handCount; i3++) {
            long j2 = sTHumanAction.hands[i3].handAction;
            for (int i4 = 0; i4 < this.f21528z.size(); i4++) {
                if ((this.f21528z.get(i4).longValue() & j2) > 0) {
                    this.f21498C = true;
                    mo22960o();
                    return;
                }
            }
        }
    }
}
