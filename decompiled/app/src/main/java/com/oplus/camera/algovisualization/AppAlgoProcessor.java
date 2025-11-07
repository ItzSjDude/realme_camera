package com.oplus.camera.algovisualization;

import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p172ui.preview.p177a.TiltShiftTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.VideoBlurTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.VideoRetentionTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.AnimojiTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.BlurTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FaceSlenderTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FishEyeTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.StickerTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.SuperTextTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.p178a.DoubleExposureTexturePreview;
import java.util.ArrayList;

/* compiled from: AppAlgoProcessor.java */
/* renamed from: com.oplus.camera.algovisualization.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class AppAlgoProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f12490a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f12491b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f12492c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f12493d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f12494e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f12495f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12496g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12497h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f12498i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12499j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12500k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f12501l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f12502m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f12503n;

    /* renamed from: o */
    private boolean f12504o;

    /* renamed from: p */
    private boolean f12505p;

    /* renamed from: q */
    private boolean f12506q;

    /* renamed from: r */
    private boolean f12507r;

    /* renamed from: s */
    private boolean f12508s;

    /* renamed from: t */
    private float f12509t;

    /* renamed from: u */
    private int f12510u;

    /* renamed from: v */
    private String f12511v = "FR";

    /* renamed from: w */
    private String f12512w = "SB";

    /* renamed from: x */
    private String f12513x = "FI";

    /* renamed from: y */
    private String f12514y = "FB";

    /* renamed from: z */
    private String f12515z = "DE";

    /* renamed from: A */
    private String f12471A = "VB";

    /* renamed from: B */
    private String f12472B = "VR";

    /* renamed from: C */
    private String f12473C = "FLM";

    /* renamed from: D */
    private String f12474D = "FL";

    /* renamed from: E */
    private String f12475E = "EE";

    /* renamed from: F */
    private String f12476F = "ST";

    /* renamed from: G */
    private String f12477G = "SBT";

    /* renamed from: H */
    private String f12478H = "FE";

    /* renamed from: I */
    private String f12479I = "TS";

    /* renamed from: J */
    private String f12480J = "RM";

    /* renamed from: K */
    private String f12481K = "UP";

    /* renamed from: L */
    private String f12482L = "WM";

    /* renamed from: M */
    private String f12483M = "SK";

    /* renamed from: N */
    private String f12484N = "AMJ";

    /* renamed from: O */
    private String f12485O = "DE";

    /* renamed from: P */
    private String f12486P = "BL";

    /* renamed from: Q */
    private String f12487Q = ApsConstant.CAPTURE_MODE_MACRO;

    /* renamed from: R */
    private String f12488R = ApsConstant.REC_MODE_MICROSCOPE;

    /* renamed from: S */
    private final int f12489S = 0;

    public AppAlgoProcessor(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        this.f12490a = z;
        this.f12491b = z2;
        this.f12492c = z3;
        this.f12493d = z4;
        this.f12494e = z5;
        this.f12495f = z6;
        this.f12496g = z7;
        this.f12497h = z8;
        this.f12498i = z9;
        this.f12499j = z10;
        this.f12500k = z11;
        this.f12501l = z12;
        this.f12502m = z13;
        this.f12503n = z14;
        this.f12504o = z15;
        this.f12505p = z16;
        this.f12506q = z17;
        this.f12507r = z18;
        this.f12508s = z19;
        this.f12509t = COUIBaseListPopupWindow_12;
        this.f12510u = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayList<String> m11614a() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f12490a) {
            arrayList.add(this.f12486P + ":" + BlurTexturePreview.f21204a);
        }
        if (this.f12491b) {
            arrayList.add(this.f12474D + ":" + FilterTexturePreview.f21341a);
        }
        if (this.f12492c && DataProcessorUtils.m11624b() > 0) {
            arrayList.add(this.f12514y + ":" + FaceSlenderTexturePreview.f21232a);
        }
        if (this.f12493d) {
            arrayList.add(this.f12483M + ":" + StickerTexturePreview.f21495a);
        }
        if (this.f12494e) {
            arrayList.add(this.f12484N + ":" + AnimojiTexturePreview.f21154a);
        }
        if ((this.f12495f && this.f12490a) || this.f12496g) {
            arrayList.add(this.f12471A + ":" + VideoBlurTexturePreview.f21027a);
        }
        if (this.f12497h) {
            arrayList.add(this.f12476F + ":" + SuperTextTexturePreview.f21530a);
        }
        if (this.f12498i) {
            arrayList.add(this.f12472B + ":" + VideoRetentionTexturePreview.f21072a);
        }
        if (this.f12499j && this.f12509t > 0.0f) {
            arrayList.add(this.f12479I + ":" + TiltShiftTexturePreview.f21011a);
        }
        if (this.f12500k) {
            arrayList.add(this.f12485O + ":" + DoubleExposureTexturePreview.f20895a);
        }
        if (this.f12501l) {
            arrayList.add(this.f12478H + ":" + FishEyeTexturePreview.f21391a);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayList<String> m11615a(CameraRequestTag c2693c) {
        String strValueOf;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f12503n && !this.f12502m && DataProcessorUtils.m11624b() > 0) {
            arrayList.add(String.valueOf(this.f12511v));
        }
        if (c2693c.f13409d != null) {
            arrayList.add(String.valueOf(this.f12512w));
        }
        String str = c2693c.f13372A;
        if (c2693c.f13407b || ((this.f12504o && this.f12505p) || !"none".equals(c2693c.f13410e))) {
            if (AlgoSwitchConfig.getSupportCaptureAlgo(str, this.f12510u, CameraUnitKeys.ALGO_NAME_FACE_INFO)) {
                arrayList.add(String.valueOf(this.f12513x));
            }
            if (c2693c.f13407b && 4 != c2693c.f13418m && 5 != c2693c.f13418m && 3 != c2693c.f13418m && DataProcessorUtils.m11624b() > 0 && !this.f12493d) {
                arrayList.add(String.valueOf(this.f12514y));
            } else if (!"none".equals(c2693c.f13410e) && !arrayList.contains(CameraUnitKeys.ALGO_NAME_FACE_BEAUTY) && DataProcessorUtils.m11624b() > 0 && !this.f12493d) {
                arrayList.add(String.valueOf(this.f12514y));
            }
            if (this.f12504o && this.f12505p) {
                arrayList.add(String.valueOf(this.f12515z));
            }
        }
        if ((this.f12495f && this.f12490a) || this.f12496g) {
            arrayList.add(String.valueOf(this.f12471A));
        }
        if (this.f12506q && this.f12498i) {
            arrayList.add(String.valueOf(this.f12472B));
        }
        if (this.f12491b) {
            if (str.equals(this.f12487Q) || str.equals(this.f12488R)) {
                strValueOf = String.valueOf(this.f12473C);
            } else {
                strValueOf = String.valueOf(this.f12474D);
            }
            arrayList.add(strValueOf);
        }
        if (c2693c.f13421p) {
            arrayList.add(String.valueOf(this.f12475E));
        }
        if (this.f12497h && this.f12507r) {
            arrayList.add(String.valueOf(this.f12476F));
        }
        if (CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_REPROCESS == c2693c.m13006a() && c2693c.f13423r) {
            arrayList.add(String.valueOf(this.f12477G));
        }
        if (this.f12501l) {
            arrayList.add(String.valueOf(this.f12478H));
        }
        if (this.f12499j && this.f12509t > 0.0f) {
            arrayList.add(String.valueOf(this.f12479I));
        }
        if (AlgoSwitchConfig.getSupportCaptureAlgo(str, this.f12510u, CameraUnitKeys.ALGO_NAME_ROTATE_MIRROR) || c2693c.f13428w) {
            arrayList.add(String.valueOf(this.f12480J));
        }
        if (AlgoSwitchConfig.getSupportCaptureAlgo(str, this.f12510u, CameraUnitKeys.ALGO_NAME_UPSCALE)) {
            arrayList.add(String.valueOf(this.f12481K));
        }
        if (this.f12508s) {
            arrayList.add(String.valueOf(this.f12482L));
        }
        return arrayList;
    }
}
