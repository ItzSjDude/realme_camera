package com.oplus.camera.p172ui.menu.shareedit;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.p034f.TextUtilsCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p154m.ImageSaverThread;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.control.CameraControlUI;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.util.DisableUitl;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: ShareEditThumbMenu.java */
/* renamed from: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ShareEditThumbMenu implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathInterpolator f20381a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final PathInterpolator f20382b = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);

    /* renamed from: Q */
    private RelativeLayout f20399Q;

    /* renamed from: W */
    private ThumbImageView f20405W;

    /* renamed from: Y */
    private CameraControlUI f20407Y;

    /* renamed from: aD */
    private IntrinsicsJvm.kt_4 f20412aD;

    /* renamed from: aE */
    private CameraUIListener f20413aE;

    /* renamed from: aI */
    private boolean f20417aI;

    /* renamed from: aM */
    private ValueAnimator f20421aM;

    /* renamed from: aN */
    private ValueAnimator f20422aN;

    /* renamed from: ab */
    private boolean f20424ab;

    /* renamed from: ac */
    private boolean f20425ac;

    /* renamed from: ar */
    private Camera f20440ar;

    /* renamed from: at */
    private SpringInterpolator f20442at;

    /* renamed from: au */
    private Handler f20443au;

    /* renamed from: av */
    private Thumbnail f20444av;

    /* renamed from: aw */
    private Interpolator f20445aw;

    /* renamed from: ax */
    private ComboPreferences f20446ax;

    /* renamed from: ay */
    private SharedPreferences f20447ay;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20449c = 1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20450d = 1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f20451e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f20452f = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f20453g = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f20454h = 0.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f20455i = 0.0f;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f20456j = 0.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f20457k = 0.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f20458l = 0.0f;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f20459m = 0.0f;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f20460n = 0;

    /* renamed from: o */
    private int f20461o = 0;

    /* renamed from: p */
    private int f20462p = 0;

    /* renamed from: q */
    private int f20463q = 0;

    /* renamed from: r */
    private int f20464r = 0;

    /* renamed from: s */
    private int f20465s = 0;

    /* renamed from: t */
    private int f20466t = 0;

    /* renamed from: u */
    private int f20467u = 0;

    /* renamed from: v */
    private int f20468v = 0;

    /* renamed from: w */
    private int f20469w = 0;

    /* renamed from: x */
    private int f20470x = 0;

    /* renamed from: y */
    private int f20471y = 0;

    /* renamed from: z */
    private int f20472z = 0;

    /* renamed from: A */
    private int f20383A = 0;

    /* renamed from: B */
    private int f20384B = 0;

    /* renamed from: C */
    private float f20385C = 0.0f;

    /* renamed from: D */
    private float f20386D = 0.0f;

    /* renamed from: E */
    private float f20387E = 0.0f;

    /* renamed from: F */
    private float f20388F = 0.0f;

    /* renamed from: G */
    private float f20389G = 0.0f;

    /* renamed from: H */
    private RelativeLayout.LayoutParams f20390H = null;

    /* renamed from: I */
    private RelativeLayout.LayoutParams f20391I = null;

    /* renamed from: J */
    private RelativeLayout.LayoutParams f20392J = null;

    /* renamed from: K */
    private RelativeLayout.LayoutParams f20393K = null;

    /* renamed from: L */
    private RelativeLayout.LayoutParams f20394L = null;

    /* renamed from: M */
    private float f20395M = 0.0f;

    /* renamed from: N */
    private float f20396N = 0.0f;

    /* renamed from: O */
    private float f20397O = 0.0f;

    /* renamed from: P */
    private float f20398P = 0.0f;

    /* renamed from: R */
    private PopupWindow f20400R = null;

    /* renamed from: S */
    private ShareArrowImageView f20401S = null;

    /* renamed from: T */
    private RotateImageView f20402T = null;

    /* renamed from: U */
    private RotateImageView f20403U = null;

    /* renamed from: V */
    private RotateImageView f20404V = null;

    /* renamed from: X */
    private ThumbImageView f20406X = null;

    /* renamed from: Z */
    private boolean f20408Z = false;

    /* renamed from: aa */
    private boolean f20423aa = false;

    /* renamed from: ad */
    private boolean f20426ad = false;

    /* renamed from: ae */
    private boolean f20427ae = false;

    /* renamed from: af */
    private boolean f20428af = false;

    /* renamed from: ag */
    private boolean f20429ag = false;

    /* renamed from: ah */
    private boolean f20430ah = false;

    /* renamed from: ai */
    private boolean f20431ai = false;

    /* renamed from: aj */
    private PlatformImplementations.kt_3 f20432aj = null;

    /* renamed from: ak */
    private PlatformImplementations.kt_3 f20433ak = null;

    /* renamed from: al */
    private PlatformImplementations.kt_3 f20434al = null;

    /* renamed from: am */
    private PlatformImplementations.kt_3 f20435am = null;

    /* renamed from: an */
    private PlatformImplementations.kt_3 f20436an = null;

    /* renamed from: ao */
    private GradientDrawable f20437ao = null;

    /* renamed from: ap */
    private float f20438ap = m21716p();

    /* renamed from: aq */
    private float f20439aq = this.f20455i;

    /* renamed from: as */
    private long f20441as = 0;

    /* renamed from: az */
    private boolean f20448az = false;

    /* renamed from: aA */
    private boolean[] f20409aA = {false, false, false, false};

    /* renamed from: aB */
    private int[] f20410aB = {R.id_renamed.thumbnail, R.id_renamed.share, R.id_renamed.edit, R.id_renamed.soloop};

    /* renamed from: aC */
    private View[] f20411aC = null;

    /* renamed from: aF */
    private boolean f20414aF = false;

    /* renamed from: aG */
    private boolean f20415aG = true;

    /* renamed from: aH */
    private boolean f20416aH = false;

    /* renamed from: aJ */
    private boolean f20418aJ = false;

    /* renamed from: aK */
    private boolean f20419aK = false;

    /* renamed from: aL */
    private float f20420aL = 0.0f;

    /* compiled from: ShareEditThumbMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo19220a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21675a(int OplusGLSurfaceView_13) {
        return Util.m24472l().getResources().getDimensionPixelSize(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m21713n() {
        this.f20468v = m21675a(R.dimen.thumbnail_width_nomal);
        this.f20470x = m21675a(R.dimen.share_icon_margin_bottom);
        this.f20469w = m21675a(R.dimen.thumb_margin_bottom);
        this.f20471y = m21675a(R.dimen.share_button_width);
        this.f20472z = m21675a(R.dimen.arrow_total_size);
        int OplusGLSurfaceView_13 = this.f20469w;
        int i2 = this.f20468v;
        int i3 = this.f20471y;
        int i4 = this.f20470x;
        this.f20452f = (OplusGLSurfaceView_13 * 2) + i2 + i3 + i4;
        this.f20453g = (OplusGLSurfaceView_13 * 2) + i2 + (i3 * 2) + (i4 * 3);
        this.f20454h = (OplusGLSurfaceView_13 * 2) + i2 + (i3 * 3) + (i4 * 5);
        this.f20451e = this.f20454h + i3 + i4;
        this.f20455i = i2 + OplusGLSurfaceView_13 + this.f20472z;
        this.f20456j = OplusGLSurfaceView_13 + i2;
        this.f20457k = 0.0f;
        this.f20458l = m21675a(R.dimen.arrow_anim_height);
        this.f20459m = m21675a(R.dimen.arrow_anim_offset);
        int i5 = this.f20469w;
        this.f20460n = i5;
        int i6 = this.f20470x;
        int i7 = this.f20468v;
        int i8 = this.f20471y;
        this.f20461o = (i6 * 3) + i7 + i5 + (i8 * 2);
        this.f20462p = i5;
        this.f20463q = (i6 * 2) + i7 + i5 + i8;
        this.f20464r = i5;
        this.f20465s = i6 + i7 + i5;
        this.f20466t = m21675a(R.dimen.share_button_width);
        this.f20383A = m21675a(R.dimen.share_anim_up_region);
        this.f20384B = m21675a(R.dimen.share_anim_down_region);
        this.f20467u = this.f20468v + (this.f20469w * 2);
    }

    /* renamed from: o */
    private void m21715o() {
        this.f20400R = new PopupWindow(this.f20399Q, this.f20467u, (int) this.f20451e);
        this.f20400R.setSplitTouchEnabled(false);
        this.f20399Q.setBackgroundResource(R.drawable.share_and_edit_layout_background_drawable);
        RelativeLayout relativeLayout = this.f20399Q;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(this.f20467u, relativeLayout.getMeasuredHeight()));
        this.f20390H = (RelativeLayout.LayoutParams) this.f20399Q.getLayoutParams();
        this.f20437ao = (GradientDrawable) this.f20399Q.getBackground();
        this.f20437ao.setCornerRadius(this.f20467u / 2);
        this.f20388F = m21675a(R.dimen.thumbnail_margin_start) - ((((this.f20467u - this.f20468v) - this.f20405W.getPaddingLeft()) - this.f20405W.getPaddingRight()) / 2);
        this.f20389G = (((m21675a(R.dimen.control_panel_button_height) - this.f20468v) / 2) - this.f20469w) + ((Util.m24187O() - Util.m24188P()) - m21675a(R.dimen.control_panel_margin_top)) + m21675a(R.dimen.thumbnail_margin_top_offset);
        if (Util.m24495t()) {
            this.f20389G = ((m21675a(R.dimen.control_panel_button_height) - this.f20468v) / 2) + this.f20469w + ((Util.m24187O() - Util.m24188P()) - m21675a(R.dimen.control_panel_margin_top));
        }
        this.f20400R.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (ShareEditThumbMenu.this.f20413aE != null) {
                        ShareEditThumbMenu.this.f20413aE.mo10851i(true);
                    }
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20414aF = (sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20407Y == null || ShareEditThumbMenu.this.f20407Y.m19129ap() || (ShareEditThumbMenu.this.f20451e - motionEvent.getY() >= ((float) ShareEditThumbMenu.this.f20468v) && (!ShareEditThumbMenu.this.m21645D() || ShareEditThumbMenu.this.f20451e - motionEvent.getY() >= ((float) ShareEditThumbMenu.this.f20390H.height)))) ? false : true;
                }
                if (ShareEditThumbMenu.this.f20414aF && ShareEditThumbMenu.this.f20415aG) {
                    return false;
                }
                motionEvent.setLocation(ShareEditThumbMenu.this.f20417aI ? motionEvent.getRawX() : motionEvent.getX() + ShareEditThumbMenu.this.f20388F, ((motionEvent.getY() + Util.getScreenHeight()) - ShareEditThumbMenu.this.f20389G) - ShareEditThumbMenu.this.f20451e);
                ShareEditThumbMenu.this.f20440ar.dispatchTouchEvent(motionEvent);
                return true;
            }
        });
        this.f20401S = (ShareArrowImageView) this.f20407Y.m19130aq().findViewById(R.id_renamed.up_arrow);
        InverseManager.INS.registerInverse(this.f20440ar, this.f20401S);
        this.f20402T = (RotateImageView) this.f20399Q.findViewById(R.id_renamed.share);
        this.f20403U = (RotateImageView) this.f20399Q.findViewById(R.id_renamed.edit);
        this.f20404V = (RotateImageView) this.f20399Q.findViewById(R.id_renamed.soloop);
        this.f20406X = (ThumbImageView) this.f20399Q.findViewById(R.id_renamed.popup_thumbnail);
        this.f20411aC = new View[4];
        View[] viewArr = this.f20411aC;
        viewArr[0] = this.f20405W;
        viewArr[1] = this.f20402T;
        viewArr[2] = this.f20403U;
        viewArr[3] = this.f20404V;
        this.f20399Q.setOnTouchListener(this);
        this.f20401S.setOnTouchListener(this);
        this.f20403U.setOnTouchListener(this);
        this.f20402T.setOnTouchListener(this);
        this.f20404V.setOnTouchListener(this);
        this.f20402T.setOnClickListener(this);
        this.f20403U.setOnClickListener(this);
        this.f20404V.setOnClickListener(this);
        this.f20406X.setOnClickListener(this);
        this.f20391I = (RelativeLayout.LayoutParams) this.f20401S.getLayoutParams();
        this.f20392J = (RelativeLayout.LayoutParams) this.f20403U.getLayoutParams();
        this.f20393K = (RelativeLayout.LayoutParams) this.f20402T.getLayoutParams();
        this.f20394L = (RelativeLayout.LayoutParams) this.f20404V.getLayoutParams();
        this.f20405W.setOnTouchListener(this);
        this.f20406X.setOnTouchListener(this);
    }

    public ShareEditThumbMenu(RelativeLayout relativeLayout, CameraControlUI viewOnClickListenerC3199a, Activity activity, ComboPreferences comboPreferences, IntrinsicsJvm.kt_4 bVar, CameraUIListener cameraUIListener, ThumbImageView thumbImageView) {
        this.f20399Q = null;
        this.f20405W = null;
        this.f20407Y = null;
        this.f20424ab = false;
        this.f20425ac = false;
        this.f20440ar = null;
        this.f20442at = null;
        this.f20443au = null;
        this.f20444av = null;
        this.f20445aw = null;
        this.f20446ax = null;
        this.f20447ay = null;
        this.f20412aD = null;
        this.f20413aE = null;
        this.f20417aI = false;
        this.f20399Q = relativeLayout;
        this.f20412aD = bVar;
        this.f20413aE = cameraUIListener;
        this.f20405W = thumbImageView;
        this.f20446ax = comboPreferences;
        this.f20447ay = Util.m24472l().getSharedPreferences("soloop_info", 0);
        this.f20447ay.registerOnSharedPreferenceChangeListener(this);
        this.f20407Y = viewOnClickListenerC3199a;
        this.f20440ar = (Camera) activity;
        this.f20444av = this.f20407Y.m19210t();
        Thumbnail c3203e = this.f20444av;
        this.f20424ab = c3203e != null && Util.m24289a(c3203e.m19291e());
        this.f20425ac = this.f20444av != null && m21757l();
        this.f20417aI = 1 == TextUtilsCompat.m2525a(Locale.getDefault());
        m21713n();
        m21715o();
        this.f20442at = new SpringInterpolator(6.0f, 2.0f);
        this.f20445aw = new PathInterpolator(0.66f, 0.0f, 0.34f, 1.0f);
        this.f20443au = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 2) {
                    return;
                }
                ShareEditThumbMenu.this.f20448az = true;
                ShareEditThumbMenu.this.m21743a(true, true);
            }
        };
        m21743a(true, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21738a() {
        Handler handler = this.f20443au;
        if (handler != null) {
            handler.removeMessages(2);
        }
        PopupWindow popupWindow = this.f20400R;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f20400R.dismiss();
        }
        m21642C();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21744b() {
        Camera camera = this.f20440ar;
        if (camera == null || camera.isFinishing()) {
            return;
        }
        this.f20400R.showAtLocation((RelativeLayout) this.f20440ar.findViewById(R.id_renamed.camera), (this.f20417aI ? 8388613 : 8388611) | 80, (int) this.f20388F, (int) this.f20389G);
    }

    /* renamed from: p */
    private float m21716p() {
        if (this.f20424ab && this.f20425ac) {
            return this.f20454h;
        }
        if (this.f20424ab || this.f20425ac) {
            return this.f20453g;
        }
        return this.f20452f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21739a(int OplusGLSurfaceView_13, boolean z) {
        this.f20402T.m18348a(OplusGLSurfaceView_13, z);
        this.f20403U.m18348a(OplusGLSurfaceView_13, z);
        this.f20404V.m18348a(OplusGLSurfaceView_13, z);
        this.f20406X.m18984a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21741a(Thumbnail c3203e) {
        this.f20444av = c3203e;
        m21756k();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21745b(Thumbnail c3203e) {
        this.f20426ad = true;
        m21695c(c3203e);
        m21698d(c3203e);
        if (m21725t() && this.f20405W.getVisibility() == 0) {
            m21693c(this.f20455i);
            m21694c(1);
            ComboPreferences comboPreferences = this.f20446ax;
            if (comboPreferences != null && c3203e != null && comboPreferences.getBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, true) && m21663M()) {
                this.f20446ax.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                if (!Util.m24289a(c3203e.m19291e())) {
                    m21639A();
                    this.f20427ae = true;
                    return;
                } else {
                    m21640B();
                    this.f20428af = true;
                    return;
                }
            }
            if (this.f20415aG) {
                m21719q();
            } else {
                this.f20416aH = true;
            }
            this.f20402T.setVisibility(4);
            this.f20403U.setVisibility(4);
            this.f20404V.setVisibility(4);
            m21678a(this.f20392J, this.f20403U, this.f20462p);
            m21678a(this.f20393K, this.f20402T, this.f20464r);
            m21678a(this.f20394L, this.f20404V, this.f20460n);
            m21646E();
            this.f20403U.clearAnimation();
            this.f20402T.clearAnimation();
            this.f20404V.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21688b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ShareEditThumbMenu", "setBgAlpha: " + this.f20437ao.getAlpha() + " to -> :" + OplusGLSurfaceView_13);
        this.f20437ao.setAlpha(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21747c() {
        if (this.f20416aH) {
            this.f20416aH = false;
            m21719q();
        }
    }

    /* renamed from: q */
    private void m21719q() {
        m21688b(255);
        m21693c(this.f20455i);
        m21737z();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21695c(Thumbnail c3203e) {
        this.f20444av = c3203e;
        Thumbnail c3203e2 = this.f20444av;
        if (c3203e2 == null) {
            return;
        }
        this.f20424ab = Util.m24289a(c3203e2.m19291e());
        this.f20438ap = m21716p();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m21698d(Thumbnail c3203e) {
        this.f20444av = c3203e;
        if (this.f20444av == null) {
            return;
        }
        this.f20425ac = m21757l();
        this.f20438ap = m21716p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21694c(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ShareEditThumbMenu", "setState: " + this.f20449c + " to -> :" + OplusGLSurfaceView_13);
        this.f20449c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21749d() {
        m21693c(this.f20455i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21743a(boolean z, boolean z2) {
        this.f20426ad = true;
        m21756k();
        this.f20399Q.clearAnimation();
        this.f20404V.clearAnimation();
        this.f20403U.clearAnimation();
        this.f20402T.clearAnimation();
        Handler handler = this.f20443au;
        if (handler != null) {
            handler.removeMessages(2);
        }
        if (z && this.f20437ao.getAlpha() != 0) {
            m21642C();
            m21721r();
        } else {
            m21699d(z2);
            m21738a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21699d(boolean z) {
        m21694c(0);
        m21642C();
        m21688b(0);
        this.f20404V.setVisibility(4);
        this.f20402T.setVisibility(4);
        this.f20403U.setVisibility(4);
        m21678a(this.f20394L, this.f20404V, this.f20460n);
        m21678a(this.f20392J, this.f20403U, this.f20462p);
        m21678a(this.f20393K, this.f20402T, this.f20464r);
        if (z) {
            m21749d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public float m21673a(float COUIBaseListPopupWindow_12) {
        float f2 = this.f20385C;
        return f2 + ((this.f20386D - f2) * COUIBaseListPopupWindow_12);
    }

    /* renamed from: r */
    private void m21721r() {
        this.f20385C = this.f20390H.height;
        this.f20386D = this.f20455i;
        m21694c(5);
        this.f20411aC[0] = this.f20405W;
        PopupWindow popupWindow = this.f20400R;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (5 == this.f20449c) {
                m21699d(true);
            }
        } else {
            this.f20387E = this.f20402T.getAlpha();
            this.f20436an = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.9

                /* renamed from: PlatformImplementations.kt_3 */
                float f20488a = 0.0f;

                /* renamed from: IntrinsicsJvm.kt_4 */
                float f20489b = 0.0f;

                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21693c(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21673a(COUIBaseListPopupWindow_12));
                    ShareEditThumbMenu.this.m21688b((int) ((1.0f - COUIBaseListPopupWindow_12) * 255.0f));
                    this.f20488a = ShareEditThumbMenu.this.f20387E + ((this.f20489b - ShareEditThumbMenu.this.f20387E) * COUIBaseListPopupWindow_12);
                    ShareEditThumbMenu.this.f20403U.setImageAlpha((int) (this.f20488a * 255.0f));
                    ShareEditThumbMenu.this.f20402T.setImageAlpha((int) (this.f20488a * 255.0f));
                    ShareEditThumbMenu.this.f20404V.setImageAlpha((int) (this.f20488a * 255.0f));
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.f20392J, ShareEditThumbMenu.this.f20403U, ShareEditThumbMenu.this.f20463q, ShareEditThumbMenu.this.f20462p, COUIBaseListPopupWindow_12, false);
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a3 = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a3.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a3.f20393K, ShareEditThumbMenu.this.f20402T, ShareEditThumbMenu.this.f20465s, ShareEditThumbMenu.this.f20464r, COUIBaseListPopupWindow_12, false);
                    if (!ShareEditThumbMenu.this.f20424ab) {
                        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a4 = ShareEditThumbMenu.this;
                        sharedPreferencesOnSharedPreferenceChangeListenerC3340a4.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a4.f20394L, ShareEditThumbMenu.this.f20404V, ShareEditThumbMenu.this.f20463q, ShareEditThumbMenu.this.f20462p, COUIBaseListPopupWindow_12, false);
                    } else {
                        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a5 = ShareEditThumbMenu.this;
                        sharedPreferencesOnSharedPreferenceChangeListenerC3340a5.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a5.f20394L, ShareEditThumbMenu.this.f20404V, ShareEditThumbMenu.this.f20461o, ShareEditThumbMenu.this.f20460n, COUIBaseListPopupWindow_12, false);
                    }
                }

                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                protected void mo21761a(Animation animation) {
                    super.mo21761a(animation);
                }

                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                protected void mo21760b(Animation animation) {
                    if (5 == ShareEditThumbMenu.this.f20449c) {
                        ShareEditThumbMenu.this.m21699d(true);
                    }
                    if (ShareEditThumbMenu.this.f20427ae || ShareEditThumbMenu.this.f20428af) {
                        ShareEditThumbMenu.this.m21737z();
                        ShareEditThumbMenu.this.m21646E();
                        ShareEditThumbMenu.this.f20427ae = false;
                        ShareEditThumbMenu.this.f20428af = false;
                    }
                    ShareEditThumbMenu.this.m21738a();
                }
            };
            this.f20436an.setDuration(300L);
            this.f20436an.setInterpolator(this.f20445aw);
            this.f20399Q.clearAnimation();
            this.f20399Q.startAnimation(this.f20436an);
        }
    }

    /* renamed from: s */
    private boolean m21723s() {
        Thumbnail c3203e = this.f20444av;
        this.f20424ab = c3203e != null && Util.m24289a(c3203e.m19291e());
        this.f20425ac = this.f20444av != null && m21757l();
        this.f20438ap = m21716p();
        Thumbnail c3203e2 = this.f20444av;
        return (c3203e2 == null || c3203e2.m19291e() == null || this.f20444av.f18277a || !m21725t()) ? false : true;
    }

    /* renamed from: t */
    private boolean m21725t() {
        return this.f20407Y.m19123aj() && this.f20407Y.m19133at();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21740a(Bitmap bitmap, int OplusGLSurfaceView_13, boolean z) {
        ThumbImageView thumbImageView = this.f20406X;
        if (thumbImageView != null) {
            thumbImageView.m18986a(bitmap, OplusGLSurfaceView_13, z, false);
        }
    }

    /* renamed from: u */
    private void m21727u() {
        CameraUIListener cameraUIListener = this.f20413aE;
        if (cameraUIListener != null && !cameraUIListener.mo10777bT()) {
            CameraLog.m12954a("ShareEditThumbMenu", "animToFullExpand, mCameraUIListener: " + this.f20413aE);
            return;
        }
        if (2 != this.f20449c) {
            return;
        }
        this.f20411aC[0] = this.f20406X;
        m21744b();
        m21688b(255);
        m21694c(4);
        if (this.f20432aj == null) {
            this.f20432aj = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.10
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    float fM21734y = ShareEditThumbMenu.this.m21734y() * COUIBaseListPopupWindow_12;
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21693c(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20439aq + fM21734y);
                }
            };
            this.f20432aj.setInterpolator(this.f20445aw);
        }
        this.f20439aq = this.f20390H.height;
        this.f20432aj.setDuration(300L);
        m21729v();
        this.f20399Q.clearAnimation();
        this.f20399Q.startAnimation(this.f20432aj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21679a(RelativeLayout.LayoutParams layoutParams, View view, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, boolean z) {
        float f2 = OplusGLSurfaceView_13 + ((int) (this.f20468v * 0.100000024f)) + 1;
        layoutParams.bottomMargin = (int) (f2 + ((i2 - f2) * COUIBaseListPopupWindow_12));
        view.requestLayout();
        if (0.5f >= COUIBaseListPopupWindow_12 || !z) {
            return;
        }
        view.setVisibility(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21678a(RelativeLayout.LayoutParams layoutParams, View view, int OplusGLSurfaceView_13) {
        layoutParams.bottomMargin = OplusGLSurfaceView_13 + ((int) (this.f20468v * 0.100000024f)) + 1;
        view.requestLayout();
    }

    /* renamed from: v */
    private void m21729v() {
        int OplusGLSurfaceView_13 = this.f20449c;
        if (6 == OplusGLSurfaceView_13 || 7 == OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13) {
            return;
        }
        m21694c(6);
        if (this.f20434al == null) {
            this.f20434al = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.11
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                protected void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20392J, ShareEditThumbMenu.this.f20403U, ShareEditThumbMenu.this.f20462p, ShareEditThumbMenu.this.f20463q, COUIBaseListPopupWindow_12, true);
                }
            };
            this.f20434al.setDuration(300L);
            this.f20434al.setStartOffset(80L);
            this.f20434al.setInterpolator(this.f20442at);
        }
        if (this.f20433ak == null) {
            this.f20433ak = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.12
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    if (1 == ShareEditThumbMenu.this.f20449c) {
                        ShareEditThumbMenu.this.f20402T.clearAnimation();
                    }
                    if (ShareEditThumbMenu.this.f20401S.getVisibility() == 0) {
                        ShareEditThumbMenu.this.m21642C();
                    }
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20393K, ShareEditThumbMenu.this.f20402T, ShareEditThumbMenu.this.f20464r, ShareEditThumbMenu.this.f20465s, COUIBaseListPopupWindow_12, true);
                }

                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                protected void mo21760b(Animation animation) {
                    if (1 == ShareEditThumbMenu.this.f20449c) {
                        ShareEditThumbMenu.this.f20402T.setVisibility(4);
                        return;
                    }
                    if (6 == ShareEditThumbMenu.this.f20449c) {
                        ShareEditThumbMenu.this.m21694c(7);
                        if (ShareEditThumbMenu.this.f20401S.getVisibility() == 0) {
                            ShareEditThumbMenu.this.m21642C();
                        }
                        if (ShareEditThumbMenu.this.f20412aD != null) {
                            ShareEditThumbMenu.this.f20412aD.mo19220a();
                        }
                        ShareEditThumbMenu.this.m21730w();
                        ShareEditThumbMenu.this.f20407Y.m19203q(45);
                    }
                }
            };
            this.f20433ak.setDuration(300L);
            this.f20433ak.setInterpolator(this.f20442at);
        }
        if (this.f20435am == null) {
            this.f20435am = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.13
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                protected void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    if (!ShareEditThumbMenu.this.f20424ab) {
                        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                        sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20394L, ShareEditThumbMenu.this.f20404V, ShareEditThumbMenu.this.f20462p, ShareEditThumbMenu.this.f20463q, COUIBaseListPopupWindow_12, true);
                    } else {
                        ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a2 = ShareEditThumbMenu.this;
                        sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.m21679a(sharedPreferencesOnSharedPreferenceChangeListenerC3340a2.f20394L, ShareEditThumbMenu.this.f20404V, ShareEditThumbMenu.this.f20460n, ShareEditThumbMenu.this.f20461o, COUIBaseListPopupWindow_12, true);
                    }
                }
            };
            this.f20435am.setDuration(300L);
            this.f20435am.setStartOffset(80L);
            this.f20435am.setInterpolator(this.f20442at);
        }
        if (this.f20425ac) {
            this.f20404V.startAnimation(this.f20435am);
            this.f20434al.setStartOffset(110L);
        }
        if (this.f20424ab) {
            this.f20403U.startAnimation(this.f20434al);
            this.f20433ak.setStartOffset(140L);
        } else {
            this.f20433ak.setStartOffset(110L);
        }
        m21733x();
        m21730w();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21750e() {
        int OplusGLSurfaceView_13 = this.f20449c;
        if (7 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13 || 6 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13) {
            this.f20443au.post(new Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.14
                @Override // java.lang.Runnable
                public void run() {
                    if (ShareEditThumbMenu.this.f20419aK) {
                        return;
                    }
                    ShareEditThumbMenu.this.m21730w();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m21730w() {
        float COUIBaseListPopupWindow_12 = m21657J() ? 0.3f : 1.0f;
        CameraLog.m12967f("ShareEditThumbMenu", "updateIconAlpha, mbEnable: " + this.f20448az);
        if (this.f20425ac) {
            this.f20404V.setImageAlpha((int) (COUIBaseListPopupWindow_12 * 255.0f));
            this.f20404V.setDrawableAlpha(COUIBaseListPopupWindow_12);
            this.f20404V.invalidate();
        }
        if (this.f20424ab) {
            this.f20403U.setImageAlpha((int) (COUIBaseListPopupWindow_12 * 255.0f));
            this.f20403U.setDrawableAlpha(COUIBaseListPopupWindow_12);
            this.f20403U.invalidate();
        }
        this.f20402T.setImageAlpha((int) (255.0f * COUIBaseListPopupWindow_12));
        this.f20402T.setDrawableAlpha(COUIBaseListPopupWindow_12);
        this.f20402T.invalidate();
        if (this.f20448az) {
            m21646E();
        }
    }

    /* renamed from: x */
    private void m21733x() {
        int OplusGLSurfaceView_13 = this.f20449c;
        if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
            return;
        }
        this.f20399Q.clearAnimation();
        this.f20402T.startAnimation(this.f20433ak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public float m21734y() {
        return this.f20438ap - this.f20439aq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m21737z() {
        if (!m21758m()) {
            CameraLog.m12966e("ShareEditThumbMenu", "showArrow, should not show arrow now");
            return;
        }
        if (0.0f == this.f20397O || 0.0f == this.f20398P) {
            this.f20397O = (((this.f20407Y.m19130aq().getHeight() - this.f20468v) / 2.0f) - m21675a(R.dimen.arrow_height)) - this.f20459m;
            this.f20398P = m21675a(R.dimen.arrow_margin_start) + ((this.f20468v - m21675a(R.dimen.arrow_width)) / 2.0f);
            RelativeLayout.LayoutParams layoutParams = this.f20391I;
            layoutParams.topMargin = (int) this.f20397O;
            layoutParams.setMarginStart((int) this.f20398P);
            this.f20401S.requestLayout();
        }
        if (this.f20415aG) {
            this.f20401S.setVisibility(0);
        }
    }

    /* renamed from: A */
    private void m21639A() {
        this.f20411aC[0] = this.f20406X;
        m21744b();
        m21688b(255);
        m21694c(4);
        if (this.f20432aj == null) {
            this.f20432aj = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.15
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    float fM21734y = ShareEditThumbMenu.this.m21734y() * COUIBaseListPopupWindow_12;
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21693c(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20439aq + fM21734y);
                }
            };
            this.f20432aj.setInterpolator(this.f20445aw);
        }
        this.f20439aq = this.f20390H.height;
        this.f20432aj.setDuration(300L);
        m21729v();
        this.f20399Q.clearAnimation();
        this.f20399Q.startAnimation(this.f20432aj);
    }

    /* renamed from: B */
    private void m21640B() {
        this.f20411aC[0] = this.f20406X;
        m21744b();
        m21688b(255);
        m21694c(4);
        if (this.f20432aj == null) {
            this.f20432aj = new PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.2
                @Override // com.oplus.camera.p172ui.menu.shareedit.ShareEditThumbMenu.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation) {
                    float fM21734y = ShareEditThumbMenu.this.m21734y() * COUIBaseListPopupWindow_12;
                    ShareEditThumbMenu sharedPreferencesOnSharedPreferenceChangeListenerC3340a = ShareEditThumbMenu.this;
                    sharedPreferencesOnSharedPreferenceChangeListenerC3340a.m21693c(sharedPreferencesOnSharedPreferenceChangeListenerC3340a.f20439aq + fM21734y);
                }
            };
            this.f20432aj.setInterpolator(this.f20445aw);
        }
        this.f20439aq = this.f20390H.height;
        this.f20432aj.setDuration(300L);
        m21729v();
        this.f20399Q.clearAnimation();
        this.f20399Q.startAnimation(this.f20432aj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m21642C() {
        this.f20401S.clearAnimation();
        this.f20401S.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21687b(float COUIBaseListPopupWindow_12) {
        float fExp = this.f20390H.height + COUIBaseListPopupWindow_12;
        if (this.f20455i > fExp) {
            return;
        }
        if (this.f20457k + m21716p() < fExp) {
            fExp = m21716p() + this.f20457k;
            m21693c(fExp);
        } else if (m21716p() < fExp) {
            fExp = (((float) Math.exp((-0.02f) * COUIBaseListPopupWindow_12)) * COUIBaseListPopupWindow_12) + this.f20390H.height;
            m21693c(fExp);
        } else {
            m21693c(fExp);
        }
        if (fExp >= m21716p() - this.f20383A && 2 == this.f20449c) {
            m21642C();
            m21727u();
        }
        if (3 != this.f20449c || fExp > m21716p() - this.f20384B) {
            return;
        }
        this.f20430ah = false;
        m21721r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21693c(float COUIBaseListPopupWindow_12) {
        RelativeLayout.LayoutParams layoutParams = this.f20390H;
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = (int) COUIBaseListPopupWindow_12;
        this.f20399Q.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public boolean m21645D() {
        return 255 == this.f20437ao.getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m21646E() {
        Handler handler = this.f20443au;
        if (handler != null) {
            handler.removeMessages(2);
            this.f20443au.sendEmptyMessageDelayed(2, 2851L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int OplusGLSurfaceView_13 = 0;
        if (!this.f20408Z || !this.f20423aa || !this.f20448az || this.f20407Y.m19129ap() || this.f20405W.getVisibility() != 0 || this.f20413aE.mo10873p()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTouch, !mbShareAndMarkEnable: ");
            sb.append(!this.f20408Z);
            sb.append(", !mbEnableTouch: ");
            sb.append(!this.f20423aa);
            sb.append(", !mbEnable: ");
            sb.append(!this.f20448az);
            sb.append(", isMoreModeTab: ");
            sb.append(this.f20407Y.m19129ap());
            sb.append(", mThumbImageViewVisibility: ");
            sb.append(this.f20405W.getVisibility());
            sb.append(", isDoubleFinger: ");
            sb.append(this.f20413aE.mo10873p());
            CameraLog.m12967f("ShareEditThumbMenu", sb.toString());
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            m21664N();
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.f20409aA;
                if (i2 >= zArr.length) {
                    break;
                }
                zArr[i2] = this.f20410aB[i2] == view.getId();
                i2++;
            }
            if (view.getId() == R.id_renamed.popup_thumbnail) {
                this.f20409aA[0] = true;
            }
            if (m21659K()) {
                CameraLog.m12967f("ShareEditThumbMenu", "onTouch, ACTION_DOWN isAnimating return");
                return true;
            }
            this.f20426ad = false;
            Handler handler = this.f20443au;
            if (handler != null) {
                handler.removeMessages(2);
            }
            this.f20396N = motionEvent.getY();
            this.f20395M = motionEvent.getY();
            if (this.f20390H.height < 0) {
                this.f20390H.height = this.f20399Q.getMeasuredHeight();
            }
            int i3 = this.f20449c;
            this.f20450d = i3;
            if (1 == i3 || 7 == i3 || i3 == 0) {
                this.f20430ah = true;
                m21694c(7 != this.f20449c ? 2 : 3);
                this.f20399Q.clearAnimation();
                this.f20431ai = 2 == this.f20449c;
            } else {
                this.f20430ah = false;
            }
            this.f20429ag = true;
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (m21659K()) {
                    CameraLog.m12967f("ShareEditThumbMenu", "onTouch, ACTION_MOVE isAnimating return");
                    return true;
                }
                if (this.f20426ad) {
                    CameraLog.m12967f("ShareEditThumbMenu", "onTouch, ACTION_MOVE mbIntercept return");
                    return true;
                }
                if (this.f20396N != 0.0f && this.f20430ah) {
                    this.f20420aL = motionEvent.getY() - this.f20396N;
                    if (Math.abs(this.f20420aL) < this.f20466t) {
                        return true;
                    }
                    int i4 = 0;
                    while (true) {
                        boolean[] zArr2 = this.f20409aA;
                        if (i4 >= zArr2.length) {
                            break;
                        }
                        if (zArr2[i4] && Math.abs(motionEvent.getY() - this.f20395M) > this.f20466t) {
                            this.f20409aA[i4] = false;
                        }
                        i4++;
                    }
                    if (this.f20429ag) {
                        this.f20429ag = false;
                        if (this.f20431ai) {
                            if (this.f20401S.getVisibility() == 0) {
                                m21642C();
                            }
                            if (!m21645D()) {
                                m21688b(255);
                            }
                        }
                    }
                }
                return true;
            }
            if (action == 3) {
                int i5 = 0;
                while (true) {
                    boolean[] zArr3 = this.f20409aA;
                    if (i5 >= zArr3.length) {
                        break;
                    }
                    zArr3[i5] = false;
                    i5++;
                }
            } else {
                return false;
            }
        }
        if (0.0f == this.f20396N || !this.f20430ah || !this.f20431ai) {
            if (0.0f > this.f20420aL) {
                m21721r();
                this.f20430ah = false;
            } else {
                m21687b((float) ((-r0) * 0.5d));
            }
        } else if (Math.abs(this.f20420aL) > this.f20466t) {
            if (this.f20420aL > 0.0f) {
                m21727u();
                this.f20430ah = false;
            } else {
                m21687b((float) ((-r0) * 0.5d));
            }
        }
        m21666O();
        if (this.f20426ad) {
            while (true) {
                boolean[] zArr4 = this.f20409aA;
                if (OplusGLSurfaceView_13 >= zArr4.length) {
                    break;
                }
                if (zArr4[OplusGLSurfaceView_13]) {
                    this.f20411aC[OplusGLSurfaceView_13].performClick();
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            return true;
        }
        m21646E();
        Object[] objArr = Math.abs(motionEvent.getY() - this.f20395M) < ((float) this.f20466t);
        int i6 = 0;
        while (true) {
            boolean[] zArr5 = this.f20409aA;
            if (i6 >= zArr5.length) {
                if (objArr != false) {
                    int i7 = this.f20450d;
                    if (1 == i7 || i7 == 0) {
                        m21642C();
                        m21727u();
                    } else {
                        m21694c(m21645D() ? 7 : 0);
                    }
                    return true;
                }
                if (this.f20431ai) {
                    m21642C();
                    m21727u();
                } else if (3 == this.f20449c) {
                    m21721r();
                }
                return true;
            }
            if (zArr5[i6] && objArr == true) {
                this.f20411aC[i6].performClick();
                return true;
            }
            i6++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m21677a(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || 1 > strArrSplit.length) {
            return null;
        }
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(str2) || "jpg".equalsIgnoreCase(str2)) {
            return "image/jpeg";
        }
        if ("raw".equalsIgnoreCase(str2) || "dng".equalsIgnoreCase(str2)) {
            return "image/x-adobe-dng";
        }
        if ("heic_8bits".equalsIgnoreCase(str2) || "heic_10bits".equalsIgnoreCase(str2) || "heic".equalsIgnoreCase(str2)) {
            return "image/heic";
        }
        if ("mp4".equalsIgnoreCase(str2)) {
            return MimeTypes.VIDEO_MP4;
        }
        if ("3gp".equalsIgnoreCase(str2)) {
            return "video/3gp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m21649F() {
        Thumbnail c3203eM19210t = this.f20407Y.m19210t();
        if (c3203eM19210t == null) {
            return;
        }
        Uri uriM19291e = c3203eM19210t.m19291e();
        if (m21683a(uriM19291e, Util.m24289a(uriM19291e))) {
            Intent intent = new Intent("android.intent.action.SEND");
            String strM19298l = c3203eM19210t.m19298l();
            if (strM19298l == null) {
                strM19298l = m21677a(c3203eM19210t.m19292f());
            }
            if (strM19298l == null) {
                strM19298l = Util.m24289a(uriM19291e) ? "image/*" : "video/*";
            }
            intent.setType(strM19298l);
            intent.putExtra("android.intent.extra.STREAM", uriM19291e);
            if (this.f20407Y.m19124ak()) {
                intent.setFlags(268468224);
            }
            m21654I();
            try {
                this.f20440ar.startActivity(Intent.createChooser(intent, null));
                this.f20440ar.overridePendingTransition(0, 0);
            } catch (Throwable th) {
                CameraLog.m12967f("ShareEditThumbMenu", "jumpSystemShare: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m21651G() {
        Thumbnail c3203eM19210t = this.f20407Y.m19210t();
        if (c3203eM19210t == null) {
            return;
        }
        Uri uriM19291e = c3203eM19210t.m19291e();
        if (m21683a(uriM19291e, Util.m24289a(uriM19291e))) {
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setData(uriM19291e);
            intent.setPackage(Util.m24327aP());
            if (Util.m24348ak()) {
                intent.putExtra("edit_skill", "doodle");
                intent.putExtra("finish_operate", "save,share");
                intent.putExtra("from", this.f20440ar.getPackageName());
                intent.putExtra("isInternalSdcard", true);
                intent.putExtra("editor_state_item", "graffiti");
                intent.setFlags(1);
            }
            if (this.f20407Y.m19124ak()) {
                intent.addFlags(268468224);
            }
            m21654I();
            try {
                this.f20440ar.startActivity(intent);
                this.f20440ar.overridePendingTransition(R.anim.gallery_push_up_enter, R.anim.camera_fade_out_for_edit);
            } catch (Throwable th) {
                CameraLog.m12967f("ShareEditThumbMenu", "jumpMark: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m21653H() {
        Thumbnail c3203eM19210t = this.f20407Y.m19210t();
        if (c3203eM19210t == null) {
            return;
        }
        Uri uriM19291e = c3203eM19210t.m19291e();
        if (m21683a(uriM19291e, Util.m24289a(uriM19291e))) {
            Intent intent = new Intent();
            intent.setAction("oplusos.intent.action.SOLOOP_VIDEO_EDITOR");
            long id_renamed = ContentUris.parseId(uriM19291e);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(id_renamed));
            intent.putStringArrayListExtra("id_list", arrayList);
            intent.putExtra("tab_name", "template");
            intent.putExtra("use_template", true);
            if (this.f20407Y.m19124ak()) {
                intent.setFlags(268468224);
            }
            m21654I();
            try {
                this.f20440ar.startActivity(intent);
                this.f20440ar.overridePendingTransition(1 == this.f20440ar.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in, 0);
            } catch (Throwable th) {
                CameraLog.m12967f("ShareEditThumbMenu", "jumpSoloop: " + th);
            }
        }
    }

    /* renamed from: I */
    private void m21654I() {
        if (this.f20407Y.m19124ak()) {
            try {
                new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("ShareEditThumbMenu", "OplusWindowManager exception:" + COUIBaseListPopupWindow_8.toString());
            } catch (Exception e2) {
                CameraLog.m12965d("ShareEditThumbMenu", "OplusWindowManager error:", e2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21683a(Uri uri, boolean z) throws Throwable {
        if (uri == null) {
            return false;
        }
        boolean zM24290a = Util.m24290a(uri, this.f20440ar.getContentResolver());
        if (!m21657J() && zM24290a) {
            return !z || m21682a(uri);
        }
        CameraLog.m12966e("ShareEditThumbMenu", "onThumbNailClick, imageCaptureListIsEmpty: " + ImageSaverThread.m14696a().m14714j() + ", imageSaveListIsEmpty: " + ImageSaverThread.m14696a().m14711g() + ", isUriValid: " + zM24290a);
        return false;
    }

    /* renamed from: J */
    private boolean m21657J() {
        return (ImageSaverThread.m14696a().m14714j() && ImageSaverThread.m14696a().m14711g()) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21682a(Uri uri) {
        try {
            return this.f20440ar.getContentResolver().loadThumbnail(uri, new Size(1, 1), null) != null;
        } catch (Exception unused) {
            CameraLog.m12967f("ShareEditThumbMenu", "checkFileOk: " + uri.toString());
            return false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21751f() {
        this.f20426ad = true;
        m21699d(true);
        this.f20399Q.setVisibility(8);
        this.f20415aG = false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21752g() {
        this.f20399Q.setVisibility(0);
        this.f20415aG = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21742a(boolean z) {
        if (z) {
            Util.m24270a(this.f20399Q, 0, (Animation.AnimationListener) null, 300L);
            this.f20415aG = true;
        } else {
            m21752g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws PackageManager.NameNotFoundException {
        if (0 != this.f20441as && 500 > System.currentTimeMillis() - this.f20441as) {
            CameraLog.m12967f("ShareEditThumbMenu", "onClick, mLastClickTime return");
        }
        if (!this.f20448az || this.f20419aK) {
            CameraLog.m12967f("ShareEditThumbMenu", "onClick, return mbEnable " + this.f20448az + ", mbPaused: " + this.f20419aK);
            return;
        }
        if (this.f20418aJ) {
            return;
        }
        this.f20418aJ = true;
        this.f20441as = System.currentTimeMillis();
        switch (view.getId()) {
            case R.id_renamed.edit /* 2131296576 */:
                String strM24327aP = Util.m24327aP();
                if (DisableUitl.m24536a(this.f20440ar, strM24327aP)) {
                    DisableUitl.m24534a(this.f20440ar, R.string.camera_disable_album, strM24327aP, "");
                    this.f20418aJ = false;
                    break;
                } else {
                    CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ShareEditThumbMenu.this.m21651G();
                            ShareEditThumbMenu.this.f20418aJ = false;
                        }
                    }, "share");
                    this.f20446ax.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                    this.f20407Y.m19203q(47);
                    break;
                }
            case R.id_renamed.popup_thumbnail /* 2131296975 */:
                this.f20407Y.onClick(view);
                this.f20418aJ = false;
                break;
            case R.id_renamed.share /* 2131297075 */:
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ShareEditThumbMenu.this.m21649F();
                        ShareEditThumbMenu.this.f20418aJ = false;
                    }
                }, "share");
                this.f20446ax.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                this.f20407Y.m19203q(46);
                break;
            case R.id_renamed.soloop /* 2131297100 */:
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Util.m24435d(ShareEditThumbMenu.this.f20440ar, "com.oplus.videoeditor") || !Util.m24167B(ShareEditThumbMenu.this.f20440ar) || !ShareEditThumbMenu.this.m21663M()) {
                            ShareEditThumbMenu.this.m21653H();
                            ShareEditThumbMenu.this.f20407Y.m19203q(55);
                            ShareEditThumbMenu.this.f20418aJ = false;
                            return;
                        }
                        ShareEditThumbMenu.this.f20440ar.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ShareEditThumbMenu.this.f20413aE != null) {
                                    ShareEditThumbMenu.this.f20413aE.mo10801br();
                                }
                                ShareEditThumbMenu.this.f20418aJ = false;
                            }
                        });
                    }
                }, "share");
                this.f20446ax.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                break;
            default:
                this.f20418aJ = false;
                break;
        }
    }

    /* renamed from: K */
    private boolean m21659K() {
        return m21684a(this.f20432aj) || m21684a(this.f20436an) || m21684a(this.f20433ak) || m21684a(this.f20434al) || m21684a(this.f20435am);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21684a(PlatformImplementations.kt_3 aVar) {
        return aVar != null && aVar.m21764a();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m21753h() {
        int OplusGLSurfaceView_13 = this.f20449c;
        return 7 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("key_is_soloop_in_market".equals(str)) {
            m21756k();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m21754i() {
        this.f20419aK = false;
        this.f20408Z = "on".equals(this.f20446ax.getString(CameraUIInterface.KEY_SHARE_AND_MARK, this.f20440ar.getString(R.string.camera_share_default_value)));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m21755j() {
        this.f20419aK = true;
        this.f20441as = 0L;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21746b(boolean z) {
        CameraLog.m12967f("ShareEditThumbMenu", "setEnableMenu, enable: " + z + ", mbEnable: " + this.f20448az);
        this.f20448az = z;
        if (this.f20448az) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f20449c;
        if (7 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13) {
            m21743a(false, true);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m21756k() {
        this.f20423aa = m21723s();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21748c(boolean z) {
        PopupWindow popupWindow = this.f20400R;
        if (popupWindow != null && popupWindow.isShowing() && this.f20417aI) {
            this.f20400R.setTouchable(z);
            this.f20400R.update();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m21757l() {
        Thumbnail c3203eM19210t = this.f20407Y.m19210t();
        return c3203eM19210t != null && (c3203eM19210t.m19298l() == null || !"image/x-adobe-dng".equals(c3203eM19210t.m19298l())) && !c3203eM19210t.m19292f().contains("raw") && m21663M() && ((Util.m24435d(this.f20440ar, "com.oplus.videoeditor") || (Util.m24167B(this.f20440ar) && m21660L())) && this.f20407Y.m19123aj());
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m21758m() {
        return !this.f20407Y.m19134au();
    }

    /* renamed from: L */
    private boolean m21660L() {
        SharedPreferences sharedPreferences = this.f20447ay;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("key_is_soloop_in_market", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public boolean m21663M() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP);
    }

    /* compiled from: ShareEditThumbMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static abstract class PlatformImplementations.kt_3 extends Animation {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f20491a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private volatile boolean f20492b = false;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract void mo21759a(float COUIBaseListPopupWindow_12, Transformation transformation);

        /* renamed from: PlatformImplementations.kt_3 */
        protected void mo21761a(Animation animation) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected void mo21760b(Animation animation) {
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected void m21765c(Animation animation) {
        }

        public PlatformImplementations.kt_3() {
            setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    PlatformImplementations.kt_3.this.f20491a = false;
                    PlatformImplementations.kt_3.this.f20492b = true;
                    PlatformImplementations.kt_3.this.mo21761a(animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PlatformImplementations.kt_3.this.f20491a = true;
                    PlatformImplementations.kt_3.this.f20492b = false;
                    PlatformImplementations.kt_3.this.mo21760b(animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    PlatformImplementations.kt_3.this.m21765c(animation);
                }
            });
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m21764a() {
            return this.f20492b;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
            if (this.f20491a) {
                return;
            }
            mo21759a(COUIBaseListPopupWindow_12, transformation);
        }
    }

    /* renamed from: N */
    private void m21664N() {
        if (this.f20421aM == null) {
            m21668P();
        }
        this.f20421aM.start();
    }

    /* renamed from: O */
    private void m21666O() {
        if (this.f20422aN == null) {
            m21671Q();
        }
        this.f20422aN.start();
    }

    /* renamed from: P */
    private void m21668P() {
        this.f20421aM = ValueAnimator.ofFloat(1.0f, 0.9f);
        this.f20421aM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShareEditThumbMenu.this.f20405W.setScaleX(fFloatValue);
                ShareEditThumbMenu.this.f20405W.setScaleY(fFloatValue);
                ShareEditThumbMenu.this.f20406X.setScaleX(fFloatValue);
                ShareEditThumbMenu.this.f20406X.setScaleY(fFloatValue);
            }
        });
        this.f20421aM.setDuration(200L);
        this.f20421aM.setInterpolator(f20381a);
    }

    /* renamed from: Q */
    private void m21671Q() {
        this.f20422aN = ValueAnimator.ofFloat(0.9f, 1.0f);
        this.f20422aN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.shareedit.PlatformImplementations.kt_3.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShareEditThumbMenu.this.f20405W.setScaleX(fFloatValue);
                ShareEditThumbMenu.this.f20405W.setScaleY(fFloatValue);
                ShareEditThumbMenu.this.f20406X.setScaleX(fFloatValue);
                ShareEditThumbMenu.this.f20406X.setScaleY(fFloatValue);
            }
        });
        this.f20422aN.setDuration(295L);
        this.f20422aN.setInterpolator(f20382b);
    }
}
