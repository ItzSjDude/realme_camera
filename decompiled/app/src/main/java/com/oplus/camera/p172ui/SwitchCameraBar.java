package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import androidx.core.p027a.p028a.ResourcesCompat;
import com.oplus.camera.ZoomUnit;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class SwitchCameraBar extends View {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final PathInterpolator f17329b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final PathInterpolator f17330c = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: A */
    private int f17331A;

    /* renamed from: B */
    private int f17332B;

    /* renamed from: C */
    private String f17333C;

    /* renamed from: D */
    private String f17334D;

    /* renamed from: E */
    private List<String> f17335E;

    /* renamed from: F */
    private int f17336F;

    /* renamed from: G */
    private int f17337G;

    /* renamed from: H */
    private int f17338H;

    /* renamed from: I */
    private float f17339I;

    /* renamed from: J */
    private ValueAnimator f17340J;

    /* renamed from: K */
    private ValueAnimator f17341K;

    /* renamed from: L */
    private ValueAnimator f17342L;

    /* renamed from: M */
    private ValueAnimator f17343M;

    /* renamed from: N */
    private ValueAnimator f17344N;

    /* renamed from: O */
    private ValueAnimator f17345O;

    /* renamed from: P */
    private ValueAnimator f17346P;

    /* renamed from: Q */
    private ValueAnimator f17347Q;

    /* renamed from: R */
    private ValueAnimator f17348R;

    /* renamed from: S */
    private ValueAnimator f17349S;

    /* renamed from: T */
    private float f17350T;

    /* renamed from: U */
    private float f17351U;

    /* renamed from: V */
    private float f17352V;

    /* renamed from: W */
    private float f17353W;

    /* renamed from: PlatformImplementations.kt_3 */
    protected GestureDetector f17354a;

    /* renamed from: aa */
    private float f17355aa;

    /* renamed from: ab */
    private float f17356ab;

    /* renamed from: ac */
    private float f17357ac;

    /* renamed from: ad */
    private float f17358ad;

    /* renamed from: ae */
    private float f17359ae;

    /* renamed from: af */
    private float f17360af;

    /* renamed from: ag */
    private float f17361ag;

    /* renamed from: ah */
    private AnimatorSet f17362ah;

    /* renamed from: ai */
    private ZoomUnit f17363ai;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f17364d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC3128a f17365e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f17366f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f17367g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ViewGroup.MarginLayoutParams f17368h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f17369i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Paint f17370j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Paint f17371k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Paint f17372l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f17373m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Rect f17374n;

    /* renamed from: o */
    private RectF f17375o;

    /* renamed from: p */
    private int f17376p;

    /* renamed from: q */
    private int f17377q;

    /* renamed from: r */
    private int f17378r;

    /* renamed from: s */
    private int f17379s;

    /* renamed from: t */
    private float f17380t;

    /* renamed from: u */
    private HashMap<String, Bitmap> f17381u;

    /* renamed from: v */
    private List<String> f17382v;

    /* renamed from: w */
    private List<Bitmap> f17383w;

    /* renamed from: x */
    private int f17384x;

    /* renamed from: y */
    private int f17385y;

    /* renamed from: z */
    private int f17386z;

    /* renamed from: com.oplus.camera.ui.SwitchCameraBar$PlatformImplementations.kt_3 */
    public interface InterfaceC3128a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12792a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo12793a();
    }

    public SwitchCameraBar(Context context) {
        this(context, null);
    }

    public SwitchCameraBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchCameraBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17364d = null;
        this.f17365e = null;
        this.f17366f = 0;
        this.f17367g = 0;
        this.f17368h = null;
        this.f17369i = false;
        this.f17370j = null;
        this.f17371k = null;
        this.f17372l = null;
        this.f17373m = null;
        this.f17374n = new Rect();
        this.f17375o = null;
        this.f17376p = 0;
        this.f17377q = 0;
        this.f17378r = 0;
        this.f17379s = 0;
        this.f17380t = 0.0f;
        this.f17381u = new HashMap<>();
        this.f17382v = null;
        this.f17383w = null;
        this.f17384x = 1;
        this.f17385y = 1;
        this.f17386z = 1;
        this.f17331A = 0;
        this.f17332B = 1;
        this.f17354a = null;
        this.f17333C = "0.6";
        this.f17334D = "2";
        this.f17335E = new ArrayList();
        this.f17336F = 0;
        this.f17337G = 0;
        this.f17338H = 0;
        this.f17339I = 0.0f;
        this.f17340J = null;
        this.f17341K = null;
        this.f17342L = null;
        this.f17343M = null;
        this.f17344N = null;
        this.f17345O = null;
        this.f17346P = null;
        this.f17347Q = null;
        this.f17348R = null;
        this.f17349S = null;
        this.f17350T = 0.0f;
        this.f17351U = 0.0f;
        this.f17352V = 0.0f;
        this.f17353W = 0.0f;
        this.f17355aa = 0.0f;
        this.f17356ab = 1.0f;
        this.f17357ac = 0.85f;
        this.f17358ad = 0.0f;
        this.f17359ae = 0.0f;
        this.f17360af = 0.0f;
        this.f17361ag = 0.0f;
        this.f17362ah = null;
        this.f17363ai = null;
        this.f17366f = getResources().getDimensionPixelSize(R.dimen.switch_camera_bar_margin_left);
        this.f17367g = getResources().getDimensionPixelSize(R.dimen.switch_camera_bar_margin_left_offset);
        m18389a();
        this.f17363ai = new ZoomUnit();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18424a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        this.f17368h = marginLayoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18427a(boolean z) {
        this.f17369i = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18389a() {
        this.f17376p = getContext().getResources().getDimensionPixelOffset(R.dimen.movie_seekbar_circle_radius);
        this.f17377q = getContext().getResources().getDimensionPixelSize(R.dimen.movie_seekbar_translate_y);
        int OplusGLSurfaceView_13 = this.f17376p;
        this.f17336F = OplusGLSurfaceView_13 * 2;
        this.f17378r = OplusGLSurfaceView_13 * 2;
        this.f17371k = new Paint();
        this.f17371k.setStyle(Paint.Style.FILL);
        this.f17371k.setColor(getContext().getColor(R.color.camera_white));
        this.f17371k.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.movie_seekbar_text_size));
        this.f17371k.setAntiAlias(true);
        this.f17371k.setTypeface(Util.m24411c(true));
        this.f17372l = new Paint();
        this.f17372l.setAntiAlias(true);
        this.f17337G = getContext().getResources().getColor(R.color.zoom_arc_seekbar_switch_bar_oval_stroke_color, null);
        this.f17372l.setColor(this.f17337G);
        this.f17372l.setStyle(Paint.Style.STROKE);
        this.f17339I = getContext().getResources().getDimensionPixelOffset(R.dimen.zoom_seekbar_oval_stroke_width);
        this.f17372l.setStrokeWidth(this.f17339I);
        this.f17370j = new Paint();
        this.f17373m = new Paint();
        this.f17373m.setStyle(Paint.Style.FILL);
        this.f17373m.setColor(getContext().getColor(Util.m24498u() ? R.color.color_white_with_20_percent_transparency : R.color.color_black_with_30_percent_transparency));
        m18405d();
        this.f17354a = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (SwitchCameraBar.this.f17365e != null && SwitchCameraBar.this.f17365e.mo12793a()) {
                    int iM18383a = SwitchCameraBar.this.m18383a(motionEvent.getX());
                    if (!SwitchCameraBar.this.m18401c() && SwitchCameraBar.this.m18384a(iM18383a) != SwitchCameraBar.this.f17385y) {
                        SwitchCameraBar.this.moveAnimation(iM18383a);
                    }
                }
                return true;
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18426a(String str, boolean z, boolean z2, int[] iArr) {
        CameraLog.m12954a("SwitchCameraBar", "init, selectValue: " + str + ", selectValue: " + str + ", supportUltraWide: " + z2);
        this.f17382v = new ArrayList();
        float configFloatValue = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_ULTAR_WIDE_ZOOM_POINT_VALUE);
        if (1.0E-6f < configFloatValue) {
            this.f17333C = Float.toString(configFloatValue);
        }
        float configFloatValue2 = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue2) {
            this.f17334D = this.f17363ai.m11589a(configFloatValue2);
        }
        float configFloatValue3 = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_MOVIE_MODE_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue3) {
            this.f17334D = this.f17363ai.m11589a(configFloatValue3);
        }
        if (z2) {
            this.f17382v.add(this.f17333C);
            this.f17384x = 2;
        }
        int OplusGLSurfaceView_13 = this.f17384x;
        this.f17385y = OplusGLSurfaceView_13;
        this.f17386z = OplusGLSurfaceView_13;
        this.f17382v.add("1");
        if (z && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_TELE_SUPPORT)) {
            this.f17382v.add(this.f17334D);
        }
        this.f17335E.add(this.f17333C);
        this.f17335E.add("1");
        this.f17335E.add(this.f17334D);
        this.f17386z = this.f17385y;
        this.f17331A = this.f17382v.size();
        this.f17379s = this.f17336F * this.f17331A;
        setSelectValue(str);
        setSelectBg(str);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (this.f17381u.get(this.f17335E.get(i2)) == null) {
                this.f17381u.put(this.f17335E.get(i2), m18387a(getResources(), iArr[i2]));
            }
        }
        m18394b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (SwitchCameraBar.this.getLayoutParams() == null || SwitchCameraBar.this.getVisibility() != 0 || SwitchCameraBar.this.getWidth() <= 0) {
                    return;
                }
                SwitchCameraBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) SwitchCameraBar.this.getLayoutParams();
                marginLayoutParams.width = SwitchCameraBar.this.f17379s;
                marginLayoutParams.leftMargin = (SwitchCameraBar.this.f17366f - ((SwitchCameraBar.this.f17379s / 2) - (SwitchCameraBar.this.getHeight() / 2))) - SwitchCameraBar.this.f17367g;
                if (Util.m24451g() == 0) {
                    marginLayoutParams.leftMargin = SwitchCameraBar.this.getResources().getDimensionPixelSize(R.dimen.movie_mode_switch_camera_bar_margin_left);
                } else if (1 != Util.m24451g()) {
                    if (SwitchCameraBar.this.f17368h != null) {
                        marginLayoutParams.leftMargin = SwitchCameraBar.this.f17368h.leftMargin;
                    }
                } else {
                    marginLayoutParams.leftMargin = SwitchCameraBar.this.getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_switch_camera_bar_margin_left);
                }
                SwitchCameraBar.this.setLayoutParams(marginLayoutParams);
            }
        });
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18394b() {
        if (Util.m24498u() && this.f17383w == null) {
            this.f17383w = new ArrayList();
            for (String str : this.f17382v) {
                this.f17383w.add(m18393b(str + "X"));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap m18393b(String str) {
        int OplusGLSurfaceView_13 = this.f17336F;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, OplusGLSurfaceView_13, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        this.f17371k.getTextBounds(str, 0, str.length(), new Rect());
        float COUIBaseListPopupWindow_12 = this.f17338H;
        int i2 = this.f17336F;
        canvas.rotate(COUIBaseListPopupWindow_12, i2 / 2, i2 / 2);
        canvas.drawText(str, (this.f17336F - r2.width()) / 2, (this.f17336F + r2.height()) / 2, this.f17371k);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18387a(Resources resources, int OplusGLSurfaceView_13) {
        Drawable drawableM2302a;
        if (resources == null || (drawableM2302a = ResourcesCompat.m2302a(resources, OplusGLSurfaceView_13, null)) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableM2302a.getIntrinsicWidth(), drawableM2302a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableM2302a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableM2302a.draw(canvas);
        if (this.f17338H == 0) {
            return bitmapCreateBitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f17338H);
        return Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, canvas.getWidth(), canvas.getHeight(), matrix, false);
    }

    public void setSelectValue(String str) {
        CameraLog.m12954a("SwitchCameraBar", "setSelectValue, value: " + str);
        this.f17364d = str;
    }

    public String getSelectValue() {
        return this.f17364d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSelectBg(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -396340000(0xffffffffe86054e0, float:-4.237503E24)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 2058955411(0x7ab92a93, float:4.807192E35)
            if (r0 == r1) goto L20
            r1 = 2059167876(0x7abc6884, float:4.891358E35)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "camera_tele"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = r2
            goto L35
        L20:
            java.lang.String r0 = "camera_main"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = r3
            goto L35
        L2a:
            java.lang.String r0 = "camera_ultra_wide"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L5c
            if (r5 == r3) goto L4c
            if (r5 == r2) goto L3c
            goto L6b
        L3c:
            java.util.List<java.lang.String> r5 = r4.f17382v
            java.lang.String r0 = r4.f17334D
            int r5 = r5.indexOf(r0)
            int r5 = r5 + r3
            r4.f17385y = r5
            int r5 = r4.f17385y
            r4.f17386z = r5
            goto L6b
        L4c:
            java.util.List<java.lang.String> r5 = r4.f17382v
            java.lang.String r0 = "1"
            int r5 = r5.indexOf(r0)
            int r5 = r5 + r3
            r4.f17385y = r5
            int r5 = r4.f17385y
            r4.f17386z = r5
            goto L6b
        L5c:
            java.util.List<java.lang.String> r5 = r4.f17382v
            java.lang.String r0 = r4.f17333C
            int r5 = r5.indexOf(r0)
            int r5 = r5 + r3
            r4.f17385y = r5
            int r5 = r4.f17385y
            r4.f17386z = r5
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.SwitchCameraBar.setSelectBg(java.lang.String):void");
    }

    public void setClickListener(InterfaceC3128a interfaceC3128a) {
        this.f17365e = interfaceC3128a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveAnimation(int OplusGLSurfaceView_13) {
        this.f17332B = m18384a(OplusGLSurfaceView_13);
        this.f17380t = (this.f17332B - this.f17385y) * this.f17376p * 2;
        if (this.f17362ah == null) {
            m18405d();
        }
        this.f17362ah.playTogether(this.f17340J, this.f17348R, this.f17341K, this.f17344N, this.f17342L, this.f17343M, this.f17346P, this.f17347Q, this.f17345O, this.f17349S);
        this.f17362ah.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18401c() {
        AnimatorSet animatorSet = this.f17362ah;
        return animatorSet != null && animatorSet.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public int m18383a(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f17336F;
        return (((int) (COUIBaseListPopupWindow_12 / OplusGLSurfaceView_13)) * OplusGLSurfaceView_13) + (OplusGLSurfaceView_13 / 2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f17331A == 0) {
            return;
        }
        m18390a(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18390a(Canvas canvas) {
        float fM18382a;
        if (this.f17382v == null || this.f17381u.size() == 0) {
            return;
        }
        this.f17375o = new RectF(0.0f, 0.0f, this.f17379s, this.f17378r);
        m18395b(canvas);
        if (this.f17380t != 0.0f) {
            fM18382a = m18382a(this.f17386z, 0) + (this.f17350T * this.f17380t);
        } else {
            fM18382a = m18382a(this.f17385y, 0);
        }
        m18391a(canvas, fM18382a);
        m18394b();
        boolean zM24498u = Util.m24498u();
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f17382v.size() + 1; OplusGLSurfaceView_13++) {
            StringBuilder sb = new StringBuilder();
            int i2 = OplusGLSurfaceView_13 - 1;
            sb.append(this.f17382v.get(i2));
            sb.append("X");
            String string = sb.toString();
            Bitmap bitmap = this.f17381u.get(this.f17382v.get(i2));
            if (bitmap != null) {
                this.f17371k.getTextBounds(string, 0, string.length(), this.f17374n);
                Bitmap bitmap2 = zM24498u ? this.f17383w.get(i2) : null;
                if (this.f17369i) {
                    float fM18382a2 = m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2);
                    float height = (this.f17378r / 2) - (bitmap.getHeight() / 2);
                    canvas.save();
                    this.f17370j.setAlpha(255);
                    if (this.f17385y == OplusGLSurfaceView_13) {
                        float COUIBaseListPopupWindow_12 = this.f17356ab;
                        canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, (bitmap.getWidth() / 2) + fM18382a2, (bitmap.getHeight() / 2) + height);
                    } else {
                        float f2 = this.f17357ac;
                        canvas.scale(f2, f2, (bitmap.getWidth() / 2) + fM18382a2, (bitmap.getHeight() / 2) + height);
                    }
                    canvas.drawBitmap(bitmap, fM18382a2, height, this.f17370j);
                    canvas.restore();
                } else if (this.f17385y != OplusGLSurfaceView_13 && this.f17386z != OplusGLSurfaceView_13) {
                    this.f17370j.setAlpha(255);
                    canvas.drawBitmap(bitmap, m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2), (this.f17378r / 2) - (bitmap.getHeight() / 2), this.f17370j);
                } else if (this.f17385y == OplusGLSurfaceView_13 || this.f17386z != OplusGLSurfaceView_13) {
                    int i3 = this.f17385y;
                    if (i3 == OplusGLSurfaceView_13) {
                        if (i3 == this.f17386z) {
                            if (zM24498u && bitmap2 != null) {
                                this.f17370j.setAlpha(255);
                                canvas.drawBitmap(bitmap2, m18382a(OplusGLSurfaceView_13, bitmap2.getHeight() / 2), 0.0f, this.f17370j);
                            } else {
                                this.f17371k.setAlpha(255);
                                canvas.drawText(string, m18382a(OplusGLSurfaceView_13, this.f17374n.width() / 2), (this.f17378r / 2) + (this.f17374n.height() / 2), this.f17371k);
                            }
                        } else if (zM24498u && bitmap2 != null) {
                            this.f17370j.setAlpha((int) (this.f17358ad * 255.0f));
                            canvas.drawBitmap(bitmap2, m18382a(OplusGLSurfaceView_13, bitmap2.getHeight() / 2) - (this.f17377q * (1.0f - this.f17359ae)), 0.0f, this.f17370j);
                        } else {
                            this.f17371k.setAlpha((int) (this.f17358ad * 255.0f));
                            canvas.drawText(string, m18382a(OplusGLSurfaceView_13, this.f17374n.width() / 2), ((this.f17378r / 2) + (this.f17374n.height() / 2)) - (this.f17377q * (1.0f - this.f17359ae)), this.f17371k);
                        }
                        if (m18401c()) {
                            this.f17370j.setAlpha((int) ((1.0f - this.f17360af) * 255.0f));
                            if (zM24498u) {
                                canvas.drawBitmap(bitmap, m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2) + (this.f17377q * this.f17361ag), (this.f17378r / 2) - (bitmap.getHeight() / 2), this.f17370j);
                            } else {
                                canvas.drawBitmap(bitmap, m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2), ((this.f17378r / 2) - (bitmap.getHeight() / 2)) + (this.f17377q * this.f17361ag), this.f17370j);
                            }
                        }
                    }
                } else if (zM24498u && bitmap2 != null) {
                    this.f17370j.setAlpha((int) ((1.0f - this.f17351U) * 255.0f));
                    canvas.drawBitmap(bitmap2, m18382a(OplusGLSurfaceView_13, bitmap2.getHeight() / 2), 0.0f, this.f17370j);
                    this.f17370j.setAlpha((int) (this.f17353W * 255.0f));
                    canvas.drawBitmap(bitmap, m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2) + (this.f17377q * (1.0f - this.f17355aa)), (this.f17378r / 2) - (bitmap.getHeight() / 2), this.f17370j);
                } else {
                    this.f17371k.setAlpha((int) ((1.0f - this.f17351U) * 255.0f));
                    canvas.drawText(string, m18382a(OplusGLSurfaceView_13, this.f17374n.width() / 2), ((this.f17378r / 2) + (this.f17374n.height() / 2)) - (this.f17377q * this.f17352V), this.f17371k);
                    this.f17370j.setAlpha((int) (this.f17353W * 255.0f));
                    canvas.drawBitmap(bitmap, m18382a(OplusGLSurfaceView_13, bitmap.getWidth() / 2), ((this.f17378r / 2) - (bitmap.getHeight() / 2)) + (this.f17377q * (1.0f - this.f17355aa)), this.f17370j);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f17354a.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m18382a(int OplusGLSurfaceView_13, int i2) {
        int i3 = this.f17379s;
        int i4 = this.f17331A;
        return (((i3 / i4) * OplusGLSurfaceView_13) - ((i3 / i4) / 2)) - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public int m18384a(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 / (this.f17379s / this.f17331A)) + 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18395b(Canvas canvas) {
        RectF rectF = this.f17375o;
        if (rectF != null) {
            int OplusGLSurfaceView_13 = this.f17376p;
            canvas.drawRoundRect(rectF, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f17373m);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18391a(Canvas canvas, float COUIBaseListPopupWindow_12) {
        canvas.drawCircle(COUIBaseListPopupWindow_12, this.f17378r / 2, this.f17376p - (Util.m24498u() ? 2 : 0), this.f17372l);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18405d() {
        m18414g();
        m18417h();
        m18411f();
        m18408e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m18408e() {
        this.f17341K = new ValueAnimator();
        this.f17341K.setFloatValues(0.0f, 1.0f);
        this.f17341K.setDuration(400L);
        this.f17341K.setInterpolator(f17330c);
        this.f17341K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17351U = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17344N = new ValueAnimator();
        this.f17344N.setFloatValues(0.0f, 1.0f);
        this.f17344N.setDuration(400L);
        this.f17344N.setInterpolator(f17329b);
        this.f17344N.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17352V = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17346P = new ValueAnimator();
        this.f17346P.setFloatValues(0.0f, 1.0f);
        this.f17346P.setDuration(400L);
        this.f17346P.setStartDelay(100L);
        this.f17346P.setInterpolator(f17330c);
        this.f17346P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17353W = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17347Q = new ValueAnimator();
        this.f17347Q.setFloatValues(0.0f, 1.0f);
        this.f17347Q.setDuration(400L);
        this.f17347Q.setStartDelay(100L);
        this.f17347Q.setInterpolator(f17329b);
        this.f17347Q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17355aa = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17348R = new ValueAnimator();
        this.f17348R.setFloatValues(0.85f, 1.0f);
        this.f17348R.setDuration(400L);
        this.f17348R.setInterpolator(f17329b);
        this.f17348R.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17356ab = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SwitchCameraBar.this.f17357ac = 1.85f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m18411f() {
        this.f17342L = new ValueAnimator();
        this.f17342L.setFloatValues(0.0f, 1.0f);
        this.f17342L.setDuration(400L);
        this.f17342L.setStartDelay(100L);
        this.f17342L.setInterpolator(f17330c);
        this.f17342L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17358ad = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17343M = new ValueAnimator();
        this.f17343M.setFloatValues(0.0f, 1.0f);
        this.f17343M.setDuration(400L);
        this.f17343M.setStartDelay(100L);
        this.f17343M.setInterpolator(f17329b);
        this.f17343M.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17359ae = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17345O = new ValueAnimator();
        this.f17345O.setFloatValues(0.0f, 1.0f);
        this.f17345O.setDuration(400L);
        this.f17345O.setInterpolator(f17330c);
        this.f17345O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17360af = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17349S = new ValueAnimator();
        this.f17349S.setFloatValues(0.0f, 1.0f);
        this.f17349S.setDuration(400L);
        this.f17349S.setInterpolator(f17329b);
        this.f17349S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17361ag = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m18414g() {
        this.f17362ah = new AnimatorSet();
        this.f17362ah.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchCameraBar switchCameraBar = SwitchCameraBar.this;
                switchCameraBar.f17386z = switchCameraBar.f17385y;
                SwitchCameraBar switchCameraBar2 = SwitchCameraBar.this;
                switchCameraBar2.f17385y = switchCameraBar2.f17332B;
                SwitchCameraBar switchCameraBar3 = SwitchCameraBar.this;
                switchCameraBar3.m18425a((String) switchCameraBar3.f17382v.get(SwitchCameraBar.this.f17385y - 1));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwitchCameraBar.this.f17380t = 0.0f;
            }
        });
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m18417h() {
        this.f17340J = new ValueAnimator();
        this.f17340J.setFloatValues(0.0f, 1.0f);
        this.f17340J.setDuration(500L);
        this.f17340J.setInterpolator(f17329b);
        this.f17340J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchCameraBar.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchCameraBar.this.f17350T = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SwitchCameraBar.this.invalidate();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18425a(String str) {
        CameraLog.m12954a("SwitchCameraBar", "changeIndex");
        InterfaceC3128a interfaceC3128a = this.f17365e;
        if (interfaceC3128a == null || !interfaceC3128a.mo12793a()) {
            return;
        }
        if (this.f17333C.equals(str)) {
            setSelectValue("camera_ultra_wide");
            this.f17365e.mo12792a("camera_ultra_wide");
        } else if ("1".equals(str)) {
            setSelectValue("camera_main");
            this.f17365e.mo12792a("camera_main");
        } else if (this.f17334D.equals(str)) {
            setSelectValue("camera_tele");
            this.f17365e.mo12792a("camera_tele");
        }
    }

    public void setItemRotation(int OplusGLSurfaceView_13) {
        this.f17338H = OplusGLSurfaceView_13;
    }
}
