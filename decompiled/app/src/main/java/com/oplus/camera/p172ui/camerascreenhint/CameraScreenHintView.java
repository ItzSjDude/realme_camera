package com.oplus.camera.p172ui.camerascreenhint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OrientationAnimation;
import com.oplus.camera.p172ui.CompoundHintView;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import com.oplus.tblplayer.misc.MediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraScreenHintView extends RelativeLayout implements InverseAble {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f17819b;

    /* renamed from: A */
    private int f17823A;

    /* renamed from: B */
    private int f17824B;

    /* renamed from: C */
    private int f17825C;

    /* renamed from: D */
    private int f17826D;

    /* renamed from: E */
    private boolean f17827E;

    /* renamed from: F */
    private int f17828F;

    /* renamed from: G */
    private int f17829G;

    /* renamed from: H */
    private long f17830H;

    /* renamed from: I */
    private boolean f17831I;

    /* renamed from: J */
    private boolean f17832J;

    /* renamed from: K */
    private boolean f17833K;

    /* renamed from: L */
    private boolean f17834L;

    /* renamed from: M */
    private boolean f17835M;

    /* renamed from: N */
    private boolean f17836N;

    /* renamed from: O */
    private boolean f17837O;

    /* renamed from: P */
    private RotateImageView f17838P;

    /* renamed from: Q */
    private CompoundHintView f17839Q;

    /* renamed from: R */
    private List<HashMap> f17840R;

    /* renamed from: S */
    private List<String> f17841S;

    /* renamed from: T */
    private AnimationAnimationListenerC3146a f17842T;

    /* renamed from: U */
    private OrientationAnimation f17843U;

    /* renamed from: V */
    private CameraScreenHintListener f17844V;

    /* renamed from: W */
    private CameraScreenHintInterface f17845W;

    /* renamed from: aa */
    private Size f17846aa;

    /* renamed from: ab */
    private boolean f17847ab;

    /* renamed from: ac */
    private boolean f17848ac;

    /* renamed from: ad */
    private boolean f17849ad;

    /* renamed from: ae */
    private boolean f17850ae;

    /* renamed from: af */
    private boolean f17851af;

    /* renamed from: ag */
    private boolean f17852ag;

    /* renamed from: ah */
    private boolean f17853ah;

    /* renamed from: ai */
    private boolean f17854ai;

    /* renamed from: aj */
    private boolean f17855aj;

    /* renamed from: ak */
    private Handler f17856ak;

    /* renamed from: al */
    private OrientationAnimation.PlatformImplementations.kt_3 f17857al;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathInterpolator f17858f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PathInterpolator f17859g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f17860h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f17861i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f17862j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f17863k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f17864l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f17865m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f17866n;

    /* renamed from: o */
    private int f17867o;

    /* renamed from: p */
    private int f17868p;

    /* renamed from: q */
    private int f17869q;

    /* renamed from: r */
    private int f17870r;

    /* renamed from: s */
    private int f17871s;

    /* renamed from: t */
    private int f17872t;

    /* renamed from: u */
    private int f17873u;

    /* renamed from: v */
    private int f17874v;

    /* renamed from: w */
    private int f17875w;

    /* renamed from: x */
    private int f17876x;

    /* renamed from: y */
    private int f17877y;

    /* renamed from: z */
    private int f17878z;

    /* renamed from: PlatformImplementations.kt_3 */
    private static HashMap<Integer, String> f17818a = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f17820c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f17821d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f17822e = 0;

    public CameraScreenHintView(Context context) {
        this(context, null);
    }

    public CameraScreenHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraScreenHintView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17858f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f17859g = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f17860h = 1;
        this.f17861i = 0;
        this.f17862j = 0;
        this.f17863k = 0;
        this.f17864l = 0;
        this.f17865m = 0;
        this.f17866n = 0;
        this.f17867o = 0;
        this.f17868p = 0;
        this.f17871s = -1;
        this.f17872t = 0;
        this.f17873u = 0;
        this.f17876x = 0;
        this.f17877y = 0;
        this.f17878z = 0;
        this.f17823A = 0;
        this.f17824B = 0;
        this.f17825C = -1;
        this.f17826D = 0;
        this.f17827E = false;
        this.f17828F = 0;
        this.f17829G = -1;
        this.f17831I = false;
        this.f17832J = false;
        this.f17833K = false;
        this.f17834L = false;
        this.f17835M = false;
        this.f17836N = false;
        this.f17837O = false;
        this.f17838P = null;
        this.f17839Q = null;
        this.f17840R = null;
        this.f17841S = new ArrayList();
        this.f17842T = new AnimationAnimationListenerC3146a();
        this.f17843U = null;
        this.f17844V = null;
        this.f17845W = null;
        this.f17846aa = null;
        this.f17847ab = false;
        this.f17848ac = false;
        this.f17849ad = false;
        this.f17850ae = false;
        this.f17851af = false;
        this.f17852ag = false;
        this.f17853ah = false;
        this.f17854ai = false;
        this.f17855aj = false;
        this.f17856ak = new Handler() { // from class: com.oplus.camera.ui.camerascreenhint.CameraScreenHintView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a("CameraScreenHintView", "handleMessage, what: " + message.what);
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2) {
                        CameraScreenHintView.this.m18808a(true);
                        return;
                    }
                    if (i2 == 3) {
                        CameraScreenHintView.this.m18816e();
                        return;
                    } else if (i2 == 4) {
                        CameraScreenHintView.this.m18793m();
                        return;
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        CameraScreenHintView.this.m18796n();
                        return;
                    }
                }
                synchronized (CameraScreenHintView.this) {
                    if (CameraScreenHintView.this.f17840R == null || CameraScreenHintView.this.f17840R.size() <= 0) {
                        if (CameraScreenHintView.this.f17831I) {
                            CameraScreenHintView.this.m18768a(8, true);
                            if (CameraScreenHintView.this.f17838P.getVisibility() != 0 || 0.0f == CameraScreenHintView.this.f17838P.getAlpha()) {
                                CameraScreenHintView.this.f17838P.setVisibility(0);
                                CameraScreenHintView.this.f17838P.setAlpha(0.0f);
                                CameraScreenHintView.this.f17842T.m18823a(1, 0);
                            }
                        } else if (CameraScreenHintView.this.f17839Q.m20081d()) {
                            CameraScreenHintView.this.f17842T.m18823a(2, 0);
                        }
                    } else if (CameraScreenHintView.this.f17840R.size() <= 1 && CameraScreenHintView.this.f17831I) {
                        CameraScreenHintView.this.m18776b(R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color);
                        CameraScreenHintView.this.f17838P.setVisibility(0);
                        CameraScreenHintView.this.m18768a(8, true);
                        CameraScreenHintView.this.f17838P.setAlpha(0.0f);
                        if (CameraScreenHintView.this.f17839Q.m20075b().equals(CameraScreenHintView.this.getResources().getString(R.string.camera_toast_LDAF))) {
                            CameraScreenHintView.this.f17851af = false;
                        }
                        CameraScreenHintView.this.f17842T.m18823a(1, 0);
                    } else {
                        CameraScreenHintView.this.m18776b(((Integer) ((HashMap) CameraScreenHintView.this.f17840R.get(0)).get("TEXT_BG_COLOR")).intValue(), ((Integer) ((HashMap) CameraScreenHintView.this.f17840R.get(0)).get("TEXT_COLOR")).intValue());
                        CameraScreenHintView.this.f17839Q.m20074a((String) ((HashMap) CameraScreenHintView.this.f17840R.get(0)).get(MediaInfo.RENDERER_TYPE_TEXT));
                        CameraScreenHintView.this.setHintTextViewVisible(0);
                        CameraScreenHintView.this.f17839Q.m20068a(0.0f);
                        CameraScreenHintView.this.f17842T.m18823a(0, 0);
                    }
                }
                CameraScreenHintView.this.m18798o();
                CameraScreenHintView.this.m18816e();
            }
        };
        this.f17857al = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.camerascreenhint.CameraScreenHintView.2
            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18007a(int i2) {
                CameraScreenHintView.this.f17861i = i2;
                if (CameraScreenHintView.this.f17838P != null) {
                    CameraScreenHintView.this.f17838P.m18348a(CameraScreenHintView.this.f17861i, false);
                }
                if (CameraScreenHintView.this.f17839Q != null) {
                    CameraScreenHintView.this.f17839Q.m20072a(CameraScreenHintView.this.f17861i, false);
                    if (CameraScreenHintView.this.m18787j()) {
                        if (i2 != 0 || CameraScreenHintView.this.f17855aj) {
                            CameraScreenHintView.this.f17839Q.m20076b(R.drawable.screen_hint_textview_bg);
                        } else {
                            CameraScreenHintView.this.f17839Q.m20076b(R.drawable.screen_hint_textview_white_bg);
                        }
                    }
                }
                CameraScreenHintView.this.m18816e();
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo18008a() {
                if (CameraScreenHintView.this.getVisibility() != 0) {
                    return false;
                }
                return (CameraScreenHintView.this.f17838P != null && CameraScreenHintView.this.f17838P.getVisibility() == 0) || (CameraScreenHintView.this.f17839Q != null && CameraScreenHintView.this.f17839Q.m20081d());
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18006a(float COUIBaseListPopupWindow_12) {
                if (CameraScreenHintView.this.f17838P != null) {
                    CameraScreenHintView.this.f17838P.setAlpha(COUIBaseListPopupWindow_12);
                }
                if (CameraScreenHintView.this.f17839Q != null) {
                    CameraScreenHintView.this.f17839Q.m20068a(COUIBaseListPopupWindow_12);
                }
            }
        };
        if (f17818a.size() == 0) {
            f17818a.put(Integer.valueOf(R.string.rio_toast_shell_covered_camera_lens), context.getString(R.string.rio_toast_shell_covered_camera_lens));
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraScreenHintView);
        try {
            this.f17863k = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 42);
            this.f17864l = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 42);
            this.f17865m = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 20);
            this.f17876x = getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_default_max_width);
            this.f17877y = getResources().getDimensionPixelOffset(R.dimen.camera_up_hint_text_secondary_max_width);
            this.f17878z = getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_video_max_width);
            typedArrayObtainStyledAttributes.recycle();
            this.f17840R = new ArrayList();
            f17820c = Util.m24186N() + context.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
            f17821d = Util.m24186N() + context.getResources().getDimensionPixelSize(R.dimen.toast_margin_top_text);
            f17822e = Util.m24186N();
            f17819b = (int) (Util.getScreenWidth() * 1.3333333333333333d);
            this.f17873u = (int) (Util.getScreenWidth() * 1.7777777777777777d);
            this.f17874v = (int) (Util.getScreenWidth() * 1.0d);
            this.f17875w = Util.getScreenHeight();
            this.f17824B = getResources().getDimensionPixelSize(R.dimen.movie_time_margin_bottom);
            InverseManager.INS.registerInverse(getContext(), this);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m18778b(String str) {
        return f17818a.containsValue(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18810a() {
        boolean zM18778b = m18778b(this.f17839Q.m20075b().toString());
        CameraLog.m12954a("CameraScreenHintView", "isDisplayingUninterruptibleHintText, text: " + this.f17839Q.m20075b().toString() + "@" + this.f17839Q.hashCode() + ", displaying: " + zM18778b + " in: " + f17818a.toString());
        return zM18778b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m18787j() {
        return Util.m24495t() && !Util.m24498u() && 2 == Util.m24178H();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f17838P = (RotateImageView) findViewById(R.id_renamed.camera_screen_hint_icon);
        this.f17838P.setVisibility(8);
        this.f17839Q = new CompoundHintView(this);
        setHintTextViewVisible(8);
        this.f17838P.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public OplusTextView getHintTextView() {
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            return c3210f.m20083f();
        }
        return null;
    }

    public void setChangeHintColor(boolean z) {
        this.f17835M = z;
    }

    public RotateImageView getHintIconView() {
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView != null) {
            return rotateImageView;
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m18789k() {
        this.f17843U = new OrientationAnimation(1.0f, 0.0f);
        this.f17843U.setDuration(300L);
        this.f17843U.m23903a(this.f17857al);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18811b() {
        this.f17833K = true;
        this.f17832J = false;
        this.f17852ag = false;
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            c3210f.m20084g();
            setHintTextViewVisible(8);
        }
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView != null) {
            rotateImageView.clearAnimation();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18814c() {
        this.f17833K = false;
        this.f17852ag = false;
    }

    public int getIconWidth() {
        return this.f17870r;
    }

    public int getTextWidth() {
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f == null) {
            return 0;
        }
        return c3210f.m20088k();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized void m18772a(String str, int OplusGLSurfaceView_13, int i2) {
        if (this.f17840R == null) {
            this.f17840R = new ArrayList();
        }
        if (!TextUtils.isEmpty(str)) {
            HashMap map = new HashMap();
            map.put(MediaInfo.RENDERER_TYPE_TEXT, str);
            map.put("TEXT_BG_COLOR", Integer.valueOf(OplusGLSurfaceView_13));
            map.put("TEXT_COLOR", Integer.valueOf(i2));
            for (int i3 = 0; i3 < this.f17840R.size(); i3++) {
                if (str.equals(this.f17840R.get(i3).get(MediaInfo.RENDERER_TYPE_TEXT))) {
                    this.f17840R.remove(i3);
                }
            }
            this.f17840R.add(0, map);
            if (this.f17840R.size() > 2) {
                this.f17840R.remove(this.f17840R.size() - 1);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private synchronized void m18780c(String str) {
        if (this.f17840R != null && !TextUtils.isEmpty(str)) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f17840R.size(); OplusGLSurfaceView_13++) {
                if (str.equals(this.f17840R.get(OplusGLSurfaceView_13).get(MediaInfo.RENDERER_TYPE_TEXT))) {
                    this.f17840R.remove(OplusGLSurfaceView_13);
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private synchronized void m18791l() {
        if (this.f17840R != null && this.f17840R.size() > 0) {
            this.f17840R.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18776b(int OplusGLSurfaceView_13, int i2) {
        if (!this.f17835M || this.f17839Q == null) {
            return;
        }
        if (1 == this.f17826D || m18787j() || 4 == this.f17826D) {
            this.f17839Q.m20071a(OplusGLSurfaceView_13, i2, getHintTextViewBGDrawableID());
        } else {
            this.f17839Q.m20071a(OplusGLSurfaceView_13, i2, -1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18806a(CameraScreenHintInfo c3147a) {
        String strM18824a = c3147a.m18824a();
        boolean zM18832i = c3147a.m18832i();
        boolean zM18831h = c3147a.m18831h();
        boolean zM18833j = c3147a.m18833j();
        int iM18827d = c3147a.m18827d();
        int iM18828e = c3147a.m18828e();
        boolean zM18825b = c3147a.m18825b();
        boolean zM18826c = c3147a.m18826c();
        int iM18829f = c3147a.m18829f();
        int iM18830g = c3147a.m18830g();
        CameraLog.m12959b("CameraScreenHintView", "showCameraScreenHintText, hintText: " + strM18824a + ", mCurOrientation: " + this.f17862j + ", showAlways: " + zM18825b + ", hideAuto: " + zM18826c + ", bgDrawable: " + iM18827d + ", color: " + iM18828e + ", hideAutoTime: " + iM18829f + ", showRecordCenter: " + zM18831h + ", showFullScreen: " + zM18832i + ", mbMoreMode: " + this.f17847ab + ", mbAnimationRunning: " + this.f17832J + ", startOffset: " + iM18830g);
        boolean z = !TextUtils.isEmpty(strM18824a) && strM18824a.equals(getResources().getString(R.string.camera_toast_LDAF));
        if (this.f17847ab) {
            return;
        }
        if (this.f17832J && z) {
            return;
        }
        this.f17849ad = zM18832i;
        if (!this.f17850ae) {
            this.f17848ac = zM18831h;
        }
        if (this.f17839Q == null || TextUtils.isEmpty(strM18824a)) {
            return;
        }
        this.f17854ai = this.f17832J;
        boolean z2 = !strM18824a.equals(this.f17839Q.m20075b().toString());
        if ((z2 || zM18833j) && !m18810a()) {
            m18776b(iM18827d, iM18828e);
            RotateImageView rotateImageView = this.f17838P;
            if (rotateImageView != null) {
                rotateImageView.setVisibility(8);
            }
            this.f17856ak.removeMessages(1);
            if (zM18825b) {
                m18772a(strM18824a, iM18827d, iM18828e);
            }
            setOrientation(getSupportRotaeScreen() ? this.f17862j : 0);
            if (z) {
                this.f17851af = true;
                this.f17852ag = true;
            }
            this.f17839Q.m20079c(iM18827d);
            setHintTextViewVisible(0);
            this.f17839Q.m20074a(strM18824a);
            if (z2 || this.f17853ah) {
                this.f17853ah = false;
                this.f17839Q.m20068a(0.0f);
                this.f17842T.m18823a(0, iM18830g);
            }
            if (!zM18825b && zM18826c) {
                this.f17856ak.removeMessages(1);
                this.f17856ak.sendEmptyMessageDelayed(1, iM18829f + iM18830g);
            }
            if (z2 || this.f17831I) {
                m18798o();
                this.f17856ak.sendEmptyMessage(3);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18807a(String str) {
        CompoundHintView c3210f;
        if (TextUtils.isEmpty(str) || (c3210f = this.f17839Q) == null) {
            return;
        }
        boolean zEquals = str.equals(c3210f.m20075b().toString());
        m18780c(str);
        if (zEquals) {
            this.f17853ah = true;
            this.f17856ak.removeMessages(1);
            this.f17856ak.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m18793m() {
        this.f17825C = (this.f17825C + 1) % this.f17841S.size();
        m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(this.f17841S.get(this.f17825C)).m18846a(true).m18849b(false).m18847a());
        this.f17856ak.sendEmptyMessageDelayed(5, this.f17830H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m18796n() {
        m18807a(this.f17841S.get(this.f17825C));
        this.f17856ak.sendEmptyMessageDelayed(4, 3000L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18803a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, boolean z3, int i3) {
        CompoundHintView c3210f;
        RotateImageView rotateImageView;
        CameraLog.m12959b("CameraScreenHintView", "showCameraScreenHintImage, lowPriority: " + z + ", hideAuto: " + z2 + ", hideAutoTime: " + i2 + ", startOffset: " + i3);
        if (this.f17847ab) {
            return;
        }
        if ((this.f17871s == OplusGLSurfaceView_13 && (rotateImageView = this.f17838P) != null && rotateImageView.getVisibility() == 0) || -1 == OplusGLSurfaceView_13) {
            return;
        }
        this.f17849ad = z3;
        if (!this.f17850ae) {
            this.f17848ac = false;
        }
        this.f17871s = OplusGLSurfaceView_13;
        if (this.f17838P != null) {
            if (this.f17837O) {
                InverseManager.INS.registerInverse(getContext(), this.f17838P);
            }
            this.f17838P.setImageResource(OplusGLSurfaceView_13);
            setOrientation(getSupportRotaeScreen() ? this.f17862j : 0);
            Drawable drawableM2248a = ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13);
            this.f17869q = drawableM2248a.getIntrinsicHeight();
            this.f17870r = drawableM2248a.getIntrinsicWidth();
            this.f17831I = true;
            if (z && this.f17856ak.hasMessages(1) && (c3210f = this.f17839Q) != null && c3210f.m20078c() == 0) {
                CameraLog.m12954a("CameraScreenHintView", "showCameraScreenHintImage, lowPriority, so wait text hint hide.");
                return;
            }
            if (this.f17839Q != null) {
                setHintTextViewVisible(8);
            }
            this.f17838P.clearAnimation();
            this.f17838P.setVisibility(0);
            this.f17838P.setAlpha(0.0f);
            this.f17842T.m18823a(1, i3);
            if (z2) {
                this.f17856ak.removeMessages(2);
                this.f17856ak.sendEmptyMessageDelayed(2, i2);
            }
            m18798o();
            m18816e();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18808a(boolean z) {
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView == null || !this.f17831I) {
            return;
        }
        this.f17831I = false;
        this.f17871s = -1;
        if (z) {
            if (rotateImageView.getVisibility() == 0) {
                this.f17842T.m18823a(3, 0);
            }
        } else {
            rotateImageView.setVisibility(8);
        }
        synchronized (this) {
            if (this.f17840R != null && this.f17840R.size() > 0) {
                m18776b(((Integer) this.f17840R.get(0).get("TEXT_BG_COLOR")).intValue(), ((Integer) this.f17840R.get(0).get("TEXT_COLOR")).intValue());
                this.f17839Q.m20074a((String) this.f17840R.get(0).get(MediaInfo.RENDERER_TYPE_TEXT));
                setHintTextViewVisible(0);
                this.f17839Q.m20068a(0.0f);
                this.f17842T.m18823a(0, 0);
                m18816e();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18813b(boolean z) {
        m18809a(z, true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18815d() {
        this.f17842T.cancel();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18809a(boolean z, boolean z2) {
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f == null || c3210f.m20078c() != 8) {
            this.f17831I = false;
            this.f17854ai = false;
            CompoundHintView c3210f2 = this.f17839Q;
            if (c3210f2 != null) {
                if (z) {
                    this.f17842T.m18823a(4, 0);
                } else {
                    c3210f2.m20084g();
                    this.f17839Q.m20085h();
                    this.f17832J = false;
                    setHintTextViewVisible(8);
                }
            }
            if (z2) {
                m18791l();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18802a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        this.f17867o = OplusGLSurfaceView_13;
        this.f17866n = i2;
        this.f17868p = i3;
        this.f17834L = z;
        m18816e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18801a(int OplusGLSurfaceView_13, int i2) {
        this.f17868p = OplusGLSurfaceView_13;
        this.f17867o = i2;
        m18816e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18800a(int OplusGLSurfaceView_13) {
        int i2 = this.f17826D;
        if (1 == i2 || 4 == i2) {
            return;
        }
        this.f17867o = OplusGLSurfaceView_13;
    }

    public void setIconAlpha(float COUIBaseListPopupWindow_12) {
        this.f17838P.setAlpha(COUIBaseListPopupWindow_12);
    }

    public void setRecordTimeWidth(int OplusGLSurfaceView_13) {
        this.f17823A = OplusGLSurfaceView_13;
        m18816e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m18798o() {
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            c3210f.m20070a(Util.getScreenWidth(), f17819b);
        }
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView != null) {
            rotateImageView.measure(Util.getScreenWidth(), f17819b);
        }
    }

    private int getChildMeasureWidth() {
        int OplusGLSurfaceView_13;
        int i2 = this.f17861i;
        int iM20086i = 0;
        if (i2 == 90 || i2 == 270) {
            CompoundHintView c3210f = this.f17839Q;
            if (c3210f != null && c3210f.m20081d() && this.f17839Q.m20086i() >= 0) {
                iM20086i = this.f17839Q.m20086i();
            }
            RotateImageView rotateImageView = this.f17838P;
            return (rotateImageView == null || rotateImageView.getVisibility() != 0 || iM20086i > (OplusGLSurfaceView_13 = this.f17869q)) ? iM20086i : OplusGLSurfaceView_13;
        }
        CompoundHintView c3210f2 = this.f17839Q;
        if (c3210f2 != null && c3210f2.m20081d()) {
            iM20086i = 0 + this.f17839Q.m20086i();
        }
        RotateImageView rotateImageView2 = this.f17838P;
        return (rotateImageView2 == null || rotateImageView2.getVisibility() != 0) ? iM20086i : iM20086i + this.f17870r;
    }

    private int getChildMeasureHeight() {
        int OplusGLSurfaceView_13;
        int i2 = this.f17861i;
        int iM20087j = 0;
        if (i2 == 90 || i2 == 270) {
            CompoundHintView c3210f = this.f17839Q;
            if (c3210f != null && c3210f.m20081d()) {
                iM20087j = 0 + this.f17839Q.m20087j();
            }
            RotateImageView rotateImageView = this.f17838P;
            return (rotateImageView == null || rotateImageView.getVisibility() != 0) ? iM20087j : iM20087j + this.f17870r;
        }
        CompoundHintView c3210f2 = this.f17839Q;
        if (c3210f2 != null && c3210f2.m20081d() && this.f17839Q.m20087j() >= 0) {
            iM20087j = this.f17839Q.m20087j();
        }
        RotateImageView rotateImageView2 = this.f17838P;
        return (rotateImageView2 == null || rotateImageView2.getVisibility() != 0 || iM20087j > (OplusGLSurfaceView_13 = this.f17869q)) ? iM20087j : OplusGLSurfaceView_13;
    }

    public int getViewGap() {
        int OplusGLSurfaceView_13 = this.f17861i;
        return (90 == OplusGLSurfaceView_13 || 270 == OplusGLSurfaceView_13) ? this.f17864l : this.f17863k;
    }

    public void setOrientationNoAnim(int OplusGLSurfaceView_13) {
        if (getSupportRotaeScreen() && OplusGLSurfaceView_13 % 180 == 0) {
            OplusGLSurfaceView_13 = 0;
        }
        this.f17862j = OplusGLSurfaceView_13;
        this.f17861i = OplusGLSurfaceView_13;
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            c3210f.m20072a(this.f17862j, false);
        }
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView != null) {
            rotateImageView.m18348a(this.f17862j, false);
        }
        m18816e();
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        CameraScreenHintListener interfaceC3149c;
        this.f17862j = OplusGLSurfaceView_13;
        boolean supportRotaeScreen = getSupportRotaeScreen();
        if (!getSupportRotaeScreen() && this.f17861i != 0) {
            supportRotaeScreen = true;
            OplusGLSurfaceView_13 = 0;
        }
        if (supportRotaeScreen) {
            if (this.f17843U == null) {
                m18789k();
            }
            if (OplusGLSurfaceView_13 == -1) {
                OplusGLSurfaceView_13 = 0;
            }
            if (OplusGLSurfaceView_13 % 180 == 0) {
                OplusGLSurfaceView_13 = 0;
            }
            OrientationAnimation.PlatformImplementations.kt_3 aVar = this.f17857al;
            if (aVar != null && aVar.mo18008a() && getSupportRotaeScreen() && ((((interfaceC3149c = this.f17844V) != null && 1 == interfaceC3149c.mo18855a()) || !m18810a()) && !this.f17843U.m23904b() && this.f17843U.m23901a() != OplusGLSurfaceView_13)) {
                startAnimation(this.f17843U);
            }
            this.f17843U.m23902a(OplusGLSurfaceView_13, getSupportRotaeScreen());
        }
    }

    public int getCurrentOrientation() {
        return this.f17862j;
    }

    public void setSupportRotateScreen(int OplusGLSurfaceView_13) {
        this.f17860h = OplusGLSurfaceView_13 & 3;
    }

    public boolean getSupportRotaeScreen() {
        return (this.f17860h & 3) == 1;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18816e() {
        int screenHeight;
        int dimensionPixelSize;
        RotateImageView rotateImageView;
        int dimensionPixelSize2;
        int childMeasureWidth = getChildMeasureWidth();
        int childMeasureHeight = getChildMeasureHeight();
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            c3210f.m20067a();
        }
        Size size = this.f17846aa;
        int iM24426d = size != null ? Util.m24426d(size.getWidth(), this.f17846aa.getHeight()) : 0;
        CameraLog.m12954a("CameraScreenHintView", "refreshLayout, width: " + childMeasureWidth + ", height: " + childMeasureHeight + ", mOrientation: " + this.f17861i + ", sizeType: " + iM24426d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(childMeasureWidth, childMeasureHeight);
        m18818g();
        if (iM24426d == 1) {
            screenHeight = this.f17873u;
            Util.m24185M();
            int OplusGLSurfaceView_13 = f17822e;
        } else if (iM24426d == 2) {
            screenHeight = this.f17874v;
            Util.m24184L();
            int i2 = f17822e;
        } else if (iM24426d == 5) {
            screenHeight = this.f17875w;
        } else {
            screenHeight = f17819b;
            int i3 = f17822e;
        }
        if (this.f17849ad) {
            screenHeight = Util.getScreenHeight();
        }
        CompoundHintView c3210f2 = this.f17839Q;
        if (c3210f2 != null && !this.f17832J) {
            c3210f2.m20080d(this.f17848ac ? this.f17878z : getUpHintMaxWidth());
        }
        int i4 = this.f17861i;
        if (i4 == 90) {
            layoutParams.addRule(10);
            if (this.f17834L) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f17864l + this.f17868p;
                if (2 == iM24426d) {
                    layoutParams.topMargin = ((screenHeight - childMeasureHeight) / 2) + f17822e + Util.m24184L();
                } else if (5 == iM24426d) {
                    layoutParams.topMargin = (screenHeight - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = ((screenHeight - childMeasureHeight) / 2) + f17822e;
                }
            } else {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.f17864l + this.f17868p;
                if (this.f17849ad) {
                    layoutParams.topMargin = (screenHeight - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = (((f17819b - childMeasureHeight) + this.f17872t) / 2) + f17822e;
                    if (3 == this.f17826D) {
                        layoutParams.topMargin = (((((int) ((Util.getScreenWidth() / 2.0f) * 1.3333333333333333d)) - childMeasureHeight) + this.f17872t) / 2) + getResources().getDimensionPixelSize(R.dimen.fold_split_hint_view_margin_top_offset_rotate);
                    }
                }
            }
        } else if (i4 == 270) {
            layoutParams.addRule(10);
            if (this.f17834L) {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.f17864l + this.f17868p;
                if (2 == iM24426d) {
                    layoutParams.topMargin = ((screenHeight - childMeasureHeight) / 2) + Util.m24184L();
                } else if (5 == iM24426d) {
                    layoutParams.topMargin = (screenHeight - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = ((screenHeight - childMeasureHeight) / 2) + f17822e;
                }
            } else {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f17864l + this.f17868p;
                if (this.f17849ad) {
                    if (this.f17823A == 0) {
                        layoutParams.topMargin = ((screenHeight - childMeasureHeight) / 2) + this.f17867o;
                    } else {
                        layoutParams.topMargin = (((screenHeight - childMeasureHeight) / 2) - (childMeasureHeight / 2)) - this.f17824B;
                    }
                } else {
                    layoutParams.topMargin = (((f17819b - childMeasureHeight) - this.f17872t) / 2) + f17822e;
                }
                if (3 == this.f17826D) {
                    layoutParams.topMargin = (((((int) ((Util.getScreenWidth() / 2.0f) * 1.3333333333333333d)) - childMeasureHeight) - this.f17872t) / 2) + getResources().getDimensionPixelSize(R.dimen.fold_split_hint_view_margin_top_offset_rotate);
                }
            }
        } else if (this.f17834L) {
            layoutParams.addRule(12);
            if (4 == this.f17826D && this.f17827E) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = ((Util.getScreenHeight() - childMeasureWidth) + this.f17872t) / 2;
            } else {
                layoutParams.addRule(14);
            }
            layoutParams.bottomMargin = this.f17863k + this.f17866n;
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            if (this.f17831I && (rotateImageView = this.f17838P) != null && rotateImageView.getVisibility() == 0) {
                int i5 = this.f17826D;
                if (1 == i5) {
                    dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.fold_full_hint_icon_view_margin_top_offset);
                } else {
                    dimensionPixelSize2 = 4 == i5 ? getResources().getDimensionPixelSize(R.dimen.rack_mode_hint_icon_view_margin_top_offset) : 0;
                }
                layoutParams.topMargin = ((f17820c + this.f17863k) + this.f17867o) - dimensionPixelSize2;
            } else {
                int i6 = this.f17826D;
                if (1 == i6) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fold_full_hint_text_view_margin_top_offset);
                } else {
                    dimensionPixelSize = 4 == i6 ? getResources().getDimensionPixelSize(R.dimen.rack_mode__hint_text_view_margin_top_offset) : 0;
                }
                layoutParams.topMargin = ((f17821d + this.f17863k) + this.f17867o) - dimensionPixelSize;
            }
            layoutParams.rightMargin = ((Util.getScreenWidth() - childMeasureWidth) + this.f17872t) / 2;
            if (1 == this.f17826D && this.f17828F != 0) {
                layoutParams.topMargin -= getResources().getDimensionPixelSize(R.dimen.fold_full_hint_view_margin_top_offset_rotate);
                layoutParams.rightMargin = ((Util.getScreenHeight() - childMeasureWidth) + this.f17872t) / 2;
            } else {
                int i7 = this.f17826D;
                if (3 == i7) {
                    if (this.f17829G == 0) {
                        layoutParams.topMargin += getResources().getDimensionPixelSize(R.dimen.fold_split_screen_front_setting_topMargin_offset_20);
                    }
                    layoutParams.rightMargin = (((Util.getScreenWidth() / 2) - childMeasureWidth) + this.f17872t) / 2;
                } else if (4 == i7) {
                    layoutParams.rightMargin = ((Util.getScreenHeight() - childMeasureWidth) + this.f17872t) / 2;
                }
            }
        }
        setLayoutParams(layoutParams);
    }

    private int getUpHintMaxWidth() {
        CameraScreenHintInterface interfaceC3148b = this.f17845W;
        if (interfaceC3148b != null && interfaceC3148b.mo15097a()) {
            return this.f17877y;
        }
        return this.f17876x;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5 = i3 - OplusGLSurfaceView_13;
        int i6 = i4 - i2;
        int i7 = this.f17861i;
        if (i7 == 90) {
            CompoundHintView c3210f = this.f17839Q;
            if (c3210f != null && c3210f.m20081d()) {
                int i8 = i5 / 2;
                RotateImageView rotateImageView = this.f17838P;
                iM20089l = (rotateImageView == null || rotateImageView.getVisibility() != 0) ? 0 + (i6 / 2) : 0;
                this.f17839Q.m20077b(i8, iM20089l, this.f17861i);
                iM20089l += this.f17839Q.m20089l();
            }
            RotateImageView rotateImageView2 = this.f17838P;
            if (rotateImageView2 == null || rotateImageView2.getVisibility() != 0) {
                return;
            }
            int i9 = (i5 - this.f17869q) / 2;
            int i10 = iM20089l + (((i6 - iM20089l) - this.f17870r) / 2);
            RotateImageView rotateImageView3 = this.f17838P;
            rotateImageView3.layout(i9, i10, rotateImageView3.getMeasuredWidth() + i9, this.f17838P.getMeasuredHeight() + i10);
            this.f17838P.layout(i9, i10, this.f17869q + i9, this.f17870r + i10);
            return;
        }
        if (i7 == 270) {
            RotateImageView rotateImageView4 = this.f17838P;
            if (rotateImageView4 != null && rotateImageView4.getVisibility() == 0) {
                int i11 = (i5 - this.f17869q) / 2;
                CompoundHintView c3210f2 = this.f17839Q;
                if (c3210f2 == null || !c3210f2.m20081d()) {
                    iM20089l = 0 + (((i6 + 0) - this.f17870r) / 2);
                } else {
                    i11 = 0;
                }
                this.f17838P.layout(i11, iM20089l, this.f17869q + i11, this.f17870r + iM20089l);
                iM20089l += this.f17870r;
            }
            CompoundHintView c3210f3 = this.f17839Q;
            if (c3210f3 == null || !c3210f3.m20081d()) {
                return;
            }
            this.f17839Q.m20077b(i5 / 2, iM20089l + ((i6 - iM20089l) / 2), this.f17861i);
            return;
        }
        RotateImageView rotateImageView5 = this.f17838P;
        if (rotateImageView5 != null && rotateImageView5.getVisibility() == 0) {
            int i12 = (i6 - this.f17869q) / 2;
            CompoundHintView c3210f4 = this.f17839Q;
            iM20089l = (c3210f4 == null || !c3210f4.m20081d()) ? (i5 - this.f17870r) / 2 : 0;
            this.f17838P.layout(iM20089l, i12, this.f17870r + iM20089l, this.f17869q + i12);
            iM20089l += this.f17870r;
        }
        CompoundHintView c3210f5 = this.f17839Q;
        if (c3210f5 == null || !c3210f5.m20081d()) {
            return;
        }
        this.f17839Q.m20077b(iM20089l + ((i5 - iM20089l) / 2), i6 / 2, this.f17861i);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18812b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f17872t) {
            this.f17872t = OplusGLSurfaceView_13;
            m18816e();
        }
    }

    public void setScreenLayoutParams(BaseScreenMode abstractC2934a) {
        m18805a(abstractC2934a, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18805a(BaseScreenMode abstractC2934a, int OplusGLSurfaceView_13) {
        this.f17826D = abstractC2934a.mo16539j();
        this.f17829G = abstractC2934a.mo16602p();
        this.f17828F = OplusGLSurfaceView_13;
        this.f17862j = OplusGLSurfaceView_13;
    }

    public void setIsLowRack(boolean z) {
        this.f17827E = z;
    }

    public void setBMarginBottom(boolean z) {
        this.f17834L = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18817f() {
        CompoundHintView c3210f = this.f17839Q;
        if (c3210f != null) {
            c3210f.m20076b(getHintTextViewBGDrawableID());
        }
    }

    private int getHintTextViewBGDrawableID() {
        Size size = this.f17846aa;
        int iM24426d = size != null ? Util.m24426d(size.getWidth(), this.f17846aa.getHeight()) : 0;
        int OplusGLSurfaceView_13 = this.f17828F;
        int i2 = R.drawable.screen_hint_textview_white_bg;
        if (OplusGLSurfaceView_13 == 0 ? !m18787j() || this.f17861i != 0 || this.f17855aj : this.f17855aj || (iM24426d != 0 && 1 != iM24426d)) {
            i2 = R.drawable.screen_hint_textview_bg;
        }
        return 4 == this.f17826D ? R.drawable.screen_hint_textview_bg : i2;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f17855aj = z;
        m18817f();
    }

    /* renamed from: com.oplus.camera.ui.camerascreenhint.CameraScreenHintView$PlatformImplementations.kt_3 */
    private class AnimationAnimationListenerC3146a extends Animation implements Animation.AnimationListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f17882b = 1.0f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f17883c = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f17884d = 1.2f;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f17885e = 1.0f;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f17886f = 0;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f17887g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f17888h = 0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        public AnimationAnimationListenerC3146a() {
            setAnimationListener(this);
            CameraScreenHintView.this.f17832J = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m18823a(int OplusGLSurfaceView_13, int i2) {
            CameraLog.m12954a("CameraScreenHintView", "startScreenAnimation, animationType: " + OplusGLSurfaceView_13 + ", mbAnimationRunning: " + CameraScreenHintView.this.f17832J + ", startOffset: " + i2);
            if (OplusGLSurfaceView_13 == 0) {
                int i3 = this.f17888h;
                if (i3 == 1 || i3 == 3) {
                    if (CameraScreenHintView.this.f17838P != null) {
                        CameraScreenHintView.this.f17838P.clearAnimation();
                        CameraScreenHintView.this.f17838P.setVisibility(8);
                    }
                    CameraScreenHintView.this.f17832J = false;
                }
                m18822b(i2, 500);
                this.f17883c = 0.0f;
                this.f17882b = 1.0f;
            } else if (OplusGLSurfaceView_13 == 1) {
                int i4 = this.f17888h;
                if (i4 == 0 || i4 == 2) {
                    if (CameraScreenHintView.this.f17839Q != null) {
                        CameraScreenHintView.this.f17839Q.m20084g();
                        CameraScreenHintView.this.setHintTextViewVisible(8);
                    }
                    CameraScreenHintView.this.f17832J = false;
                }
                m18822b(i2, 300);
                this.f17883c = 0.0f;
                this.f17882b = 1.0f;
            } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                m18822b(0, 300);
                this.f17883c = 1.0f;
                this.f17882b = 0.0f;
            } else if (OplusGLSurfaceView_13 == 4) {
                if (CameraScreenHintView.this.m18810a()) {
                    return;
                }
                m18822b(0, 300);
                this.f17883c = 1.0f;
                this.f17882b = 0.0f;
            } else {
                m18822b(0, 300);
            }
            this.f17888h = OplusGLSurfaceView_13;
            boolean z = CameraScreenHintView.this.f17832J && !CameraScreenHintView.this.f17833K;
            int i5 = this.f17888h;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        if (z || CameraScreenHintView.this.f17839Q == null) {
                            return;
                        }
                        if (CameraScreenHintView.this.f17833K) {
                            CameraScreenHintView.this.setHintTextViewVisible(8);
                            CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                            return;
                        } else {
                            CameraScreenHintView.this.f17839Q.m20084g();
                            CameraScreenHintView.this.f17839Q.m20073a((Animation) CameraScreenHintView.this.f17842T, false);
                            return;
                        }
                    }
                    if (i5 != 3) {
                        if (CameraScreenHintView.this.f17833K) {
                            if (CameraScreenHintView.this.f17839Q != null) {
                                CameraScreenHintView.this.setHintTextViewVisible(8);
                                CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                            }
                            if (CameraScreenHintView.this.f17838P != null) {
                                CameraScreenHintView.this.f17838P.setVisibility(8);
                                CameraScreenHintView.this.f17838P.setAlpha(1.0f);
                                return;
                            }
                            return;
                        }
                        if (z || CameraScreenHintView.this.f17839Q == null) {
                            return;
                        }
                        CameraScreenHintView.this.f17839Q.m20084g();
                        CameraScreenHintView.this.f17839Q.m20073a((Animation) CameraScreenHintView.this.f17842T, false);
                        return;
                    }
                }
                if (z || CameraScreenHintView.this.f17838P == null) {
                    return;
                }
                if (CameraScreenHintView.this.f17833K) {
                    CameraScreenHintView.this.f17838P.setAlpha(this.f17882b);
                    return;
                } else {
                    CameraScreenHintView.this.f17838P.clearAnimation();
                    CameraScreenHintView.this.f17838P.startAnimation(CameraScreenHintView.this.f17842T);
                    return;
                }
            }
            if (CameraScreenHintView.this.f17839Q != null) {
                if (CameraScreenHintView.this.f17833K) {
                    CameraScreenHintView.this.setHintTextViewVisible(8);
                    CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                } else {
                    CameraScreenHintView.this.f17839Q.m20084g();
                    CameraScreenHintView.this.f17839Q.m20073a((Animation) CameraScreenHintView.this.f17842T, true);
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m18822b(int OplusGLSurfaceView_13, int i2) {
            setStartOffset(OplusGLSurfaceView_13);
            setDuration(i2);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m18821a(float COUIBaseListPopupWindow_12, Transformation transformation) {
            float scaleFactor = getScaleFactor();
            float f2 = this.f17884d;
            float f3 = f2 + ((this.f17885e - f2) * COUIBaseListPopupWindow_12);
            transformation.getMatrix().setScale(f3, f3, this.f17886f * scaleFactor, scaleFactor * this.f17887g);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
            if (CameraScreenHintView.this.f17833K) {
                return;
            }
            int OplusGLSurfaceView_13 = this.f17888h;
            float interpolation = (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 2) ? CameraScreenHintView.this.f17858f.getInterpolation(COUIBaseListPopupWindow_12) : COUIBaseListPopupWindow_12;
            float f2 = this.f17883c;
            float f3 = f2 + ((this.f17882b - f2) * interpolation);
            int i2 = this.f17888h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (CameraScreenHintView.this.f17839Q != null) {
                            CameraScreenHintView.this.f17839Q.m20068a(f3);
                            return;
                        }
                        return;
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                            return;
                        }
                        if ((!CameraScreenHintView.this.f17854ai || CameraScreenHintView.this.f17832J) && CameraScreenHintView.this.f17839Q != null) {
                            CameraScreenHintView.this.f17839Q.m20068a(f3);
                        }
                        if (CameraScreenHintView.this.f17838P != null) {
                            CameraScreenHintView.this.f17838P.setAlpha(f3);
                            return;
                        }
                        return;
                    }
                }
                if (CameraScreenHintView.this.f17838P != null) {
                    CameraScreenHintView.this.f17838P.setAlpha(f3);
                    return;
                }
                return;
            }
            m18821a(CameraScreenHintView.this.f17859g.getInterpolation(COUIBaseListPopupWindow_12), transformation);
            if (CameraScreenHintView.this.f17839Q != null) {
                CameraScreenHintView.this.f17839Q.m20068a(f3);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CameraLog.m12954a("CameraScreenHintView", "onAnimationEnd(), mAnimationType: " + this.f17888h);
            int OplusGLSurfaceView_13 = this.f17888h;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 1) {
                    if (OplusGLSurfaceView_13 != 2) {
                        if (OplusGLSurfaceView_13 != 3) {
                            if (OplusGLSurfaceView_13 == 4) {
                                if (!CameraScreenHintView.this.f17854ai) {
                                    if (CameraScreenHintView.this.f17839Q != null) {
                                        CameraScreenHintView.this.setHintTextViewVisible(8);
                                        CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                                    }
                                    if (CameraScreenHintView.this.f17838P != null) {
                                        CameraScreenHintView.this.f17838P.setVisibility(8);
                                        CameraScreenHintView.this.f17838P.setAlpha(1.0f);
                                    }
                                } else if (CameraScreenHintView.this.f17839Q != null) {
                                    CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                                }
                            }
                        } else if (CameraScreenHintView.this.f17838P != null) {
                            CameraScreenHintView.this.f17838P.setVisibility(8);
                            CameraScreenHintView.this.f17838P.setAlpha(1.0f);
                        }
                    } else if (CameraScreenHintView.this.f17839Q != null) {
                        CameraScreenHintView.this.m18768a(8, true);
                        CameraScreenHintView.this.f17839Q.m20068a(1.0f);
                    }
                } else if (CameraScreenHintView.this.f17838P != null) {
                    CameraScreenHintView.this.f17838P.setAlpha(this.f17882b);
                }
            } else if (CameraScreenHintView.this.f17839Q != null) {
                CameraScreenHintView.this.f17839Q.m20068a(this.f17882b);
            }
            CameraScreenHintView.this.f17832J = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            CameraLog.m12954a("CameraScreenHintView", "onAnimationStart(), mbActivityPause: " + CameraScreenHintView.this.f17833K);
            if (CameraScreenHintView.this.f17833K) {
                return;
            }
            CameraScreenHintView.this.f17832J = true;
            int OplusGLSurfaceView_13 = this.f17888h;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 1) {
                    if (OplusGLSurfaceView_13 == 2) {
                        if (CameraScreenHintView.this.f17839Q != null) {
                            CameraScreenHintView.this.f17839Q.m20068a(this.f17883c);
                            return;
                        }
                        return;
                    } else if (OplusGLSurfaceView_13 != 3) {
                        if (OplusGLSurfaceView_13 != 4) {
                            return;
                        }
                        if (CameraScreenHintView.this.f17839Q != null) {
                            CameraScreenHintView.this.f17839Q.m20068a(this.f17883c);
                        }
                        if (CameraScreenHintView.this.f17838P != null) {
                            CameraScreenHintView.this.f17838P.setAlpha(this.f17883c);
                            return;
                        }
                        return;
                    }
                }
                if (CameraScreenHintView.this.f17838P != null) {
                    CameraScreenHintView.this.f17838P.setAlpha(this.f17883c);
                    return;
                }
                return;
            }
            if (CameraScreenHintView.this.f17839Q != null) {
                if (CameraScreenHintView.this.f17861i % 180 == 0) {
                    this.f17886f = CameraScreenHintView.this.f17839Q.m20086i() / 2;
                    this.f17887g = CameraScreenHintView.this.f17839Q.m20087j() / 2;
                } else {
                    this.f17886f = CameraScreenHintView.this.f17839Q.m20087j() / 2;
                    this.f17887g = CameraScreenHintView.this.f17839Q.m20086i() / 2;
                }
                CameraScreenHintView.this.f17839Q.m20068a(this.f17883c);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m18818g() {
        CompoundHintView c3210f;
        if (this.f17844V == null || (c3210f = this.f17839Q) == null || !c3210f.m20081d()) {
            return;
        }
        this.f17872t = 0;
    }

    public void setCameraScreenHintListener(CameraScreenHintListener interfaceC3149c) {
        this.f17844V = interfaceC3149c;
    }

    public void setCameraScreenHintInterface(CameraScreenHintInterface interfaceC3148b) {
        this.f17845W = interfaceC3148b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHintTextViewVisible(int OplusGLSurfaceView_13) {
        m18768a(OplusGLSurfaceView_13, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18768a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("CameraScreenHintView", "setHintTextViewVisible, visible: " + OplusGLSurfaceView_13 + ", force: " + z);
        if (z || OplusGLSurfaceView_13 == 0 || !m18810a()) {
            CameraScreenHintListener interfaceC3149c = this.f17844V;
            if (interfaceC3149c != null) {
                if (OplusGLSurfaceView_13 == 0) {
                    interfaceC3149c.mo18856a(0);
                } else {
                    interfaceC3149c.mo18856a(8);
                }
            }
            if (OplusGLSurfaceView_13 != 0) {
                this.f17839Q.m20074a((CharSequence) null);
            }
            this.f17839Q.m20069a(OplusGLSurfaceView_13);
        }
    }

    public String getHintTextViewString() {
        CompoundHintView c3210f = this.f17839Q;
        return (c3210f == null || !c3210f.m20081d()) ? "" : this.f17839Q.m20075b().toString();
    }

    public int getHintIconViewResId() {
        RotateImageView rotateImageView = this.f17838P;
        if (rotateImageView == null || rotateImageView.getVisibility() != 0) {
            return 0;
        }
        return this.f17871s;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18819h() {
        this.f17839Q.m20074a((CharSequence) null);
        this.f17839Q.m20085h();
    }

    public int getMarginTop() {
        return getViewGap() + this.f17867o;
    }

    public int getMarginLeft() {
        return getViewGap() + this.f17868p;
    }

    @Override // android.view.View
    public boolean isShown() {
        if (super.isShown()) {
            return this.f17839Q.m20082e() || this.f17838P.isShown();
        }
        return false;
    }

    public void setMoreMode(boolean z) {
        this.f17847ab = z;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m18820i() {
        return this.f17832J;
    }

    public void setLDAFShowed(boolean z) {
        this.f17852ag = z;
    }

    public void setShowRecorderCenter(boolean z) {
        this.f17848ac = z;
    }

    public void setShowRecorderCenterAlways(boolean z) {
        this.f17850ae = z;
    }

    public void setChangeHintTextShadow(boolean z) {
        this.f17836N = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18804a(Size size) {
        this.f17846aa = size;
    }

    public void setIsGestureHintNeedInverse(boolean z) {
        this.f17837O = z;
    }
}
