package com.oplus.camera.p141e;

import com.oplus.camera.aps.util.CameraApsDecision;

/* compiled from: CameraRequestTag.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CameraRequestTag implements Cloneable {

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean f13398a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean f13407b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean f13408c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String f13409d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String f13410e = "rosy_nude";

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f13411f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean f13412g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean f13413h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    public String f13414i = "default";

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean f13415j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean f13416k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean f13417l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    public int f13418m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean f13419n = false;

    /* renamed from: o */
    public boolean f13420o = false;

    /* renamed from: p */
    public boolean f13421p = false;

    /* renamed from: q */
    public String f13422q = null;

    /* renamed from: r */
    public boolean f13423r = false;

    /* renamed from: s */
    public boolean f13424s = false;

    /* renamed from: t */
    public boolean f13425t = false;

    /* renamed from: u */
    public int f13426u = 0;

    /* renamed from: v */
    public int f13427v = -1;

    /* renamed from: w */
    public boolean f13428w = false;

    /* renamed from: x */
    public boolean f13429x = false;

    /* renamed from: y */
    public int f13430y = 1;

    /* renamed from: z */
    public int f13431z = 0;

    /* renamed from: A */
    public String f13372A = "";

    /* renamed from: B */
    public int f13373B = 0;

    /* renamed from: C */
    public String f13374C = "";

    /* renamed from: D */
    public boolean f13375D = false;

    /* renamed from: E */
    public String f13376E = "";

    /* renamed from: F */
    public boolean f13377F = false;

    /* renamed from: G */
    public String f13378G = "";

    /* renamed from: H */
    public String f13379H = "";

    /* renamed from: I */
    public String f13380I = "";

    /* renamed from: J */
    public int f13381J = -1;

    /* renamed from: K */
    public String[] f13382K = null;

    /* renamed from: L */
    public int[] f13383L = null;

    /* renamed from: M */
    public boolean f13384M = false;

    /* renamed from: N */
    public CameraApsDecision f13385N = null;

    /* renamed from: O */
    public int f13386O = 0;

    /* renamed from: P */
    public int f13387P = 0;

    /* renamed from: Q */
    public boolean f13388Q = false;

    /* renamed from: R */
    public int f13389R = 60;

    /* renamed from: S */
    public float f13390S = 0.0f;

    /* renamed from: T */
    public int f13391T = 1;

    /* renamed from: U */
    public int f13392U = 0;

    /* renamed from: V */
    public int f13393V = 0;

    /* renamed from: W */
    public int f13394W = 0;

    /* renamed from: X */
    public int f13395X = 0;

    /* renamed from: Y */
    public boolean f13396Y = false;

    /* renamed from: Z */
    public String f13397Z = null;

    /* renamed from: aa */
    public boolean f13399aa = false;

    /* renamed from: ab */
    public long f13400ab = 0;

    /* renamed from: ac */
    public boolean f13401ac = false;

    /* renamed from: ad */
    public long f13402ad = 0;

    /* renamed from: ae */
    public boolean f13403ae = false;

    /* renamed from: af */
    public int f13404af = 0;

    /* renamed from: ag */
    public boolean f13405ag = false;

    /* renamed from: ah */
    private PlatformImplementations.kt_3 f13406ah = PlatformImplementations.kt_3.PREVIEW;

    /* compiled from: CameraRequestTag.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        PREVIEW,
        CAPTURE,
        CAPTURE_RAW,
        CAPTURE_REPROCESS
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13007a(PlatformImplementations.kt_3 aVar) {
        this.f13406ah = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PlatformImplementations.kt_3 m13006a() {
        return this.f13406ah;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return this;
        }
    }
}
