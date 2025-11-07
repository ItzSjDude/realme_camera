package com.oplus.camera.p169t;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.control.MainShutterButton;

/* compiled from: StreetTrackLayout.java */
/* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class StreetTrackLayout extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f16628a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f16629b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f16630c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f16631d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f16632e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16633f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16634g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16635h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f16636i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f16637j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f16638k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f16639l;

    /* renamed from: OplusGLSurfaceView_6 */
    private double f16640m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f16641n;

    /* renamed from: o */
    private boolean f16642o;

    /* renamed from: p */
    private boolean f16643p;

    /* renamed from: q */
    private boolean f16644q;

    /* renamed from: r */
    private boolean f16645r;

    /* renamed from: s */
    private MainShutterButton f16646s;

    /* renamed from: t */
    private PlatformImplementations.kt_3 f16647t;

    /* renamed from: u */
    private Paint f16648u;

    /* renamed from: v */
    private IntrinsicsJvm.kt_4 f16649v;

    /* compiled from: StreetTrackLayout.java */
    /* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17360a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17361a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo17362b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo17363c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo17364d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo17365e();
    }

    public StreetTrackLayout(Context context) {
        super(context);
        this.f16628a = 0;
        this.f16629b = 0;
        this.f16630c = 0;
        this.f16631d = 0;
        this.f16632e = 0;
        this.f16633f = 0;
        this.f16634g = -1;
        this.f16635h = 0;
        this.f16636i = -1.0f;
        this.f16637j = -1.0f;
        this.f16638k = 0.0f;
        this.f16639l = 0.0f;
        this.f16640m = 0.0d;
        this.f16641n = false;
        this.f16642o = false;
        this.f16643p = false;
        this.f16644q = false;
        this.f16645r = true;
        this.f16646s = null;
        this.f16647t = null;
        this.f16648u = null;
        this.f16649v = null;
        this.f16629b = context.getResources().getDimensionPixelSize(R.dimen.street_mode_trace_button_size) / 2;
        this.f16628a = (context.getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height) / 2) - this.f16629b;
        this.f16632e = (this.f16628a * 2) / 20;
        this.f16640m = Math.tan(Math.toRadians(20.0d));
        this.f16646s = (MainShutterButton) ((Activity) getContext()).findViewById(R.id_renamed.shutter_button);
        m17369g();
        setOnClickListener(this);
        setOnLongClickListener(this);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        CameraLog.m12954a("StreetTrackLayout", "onLongClick");
        IntrinsicsJvm.kt_4 bVar = this.f16649v;
        if (bVar != null && bVar.mo17362b()) {
            this.f16645r = false;
            this.f16646s.setPressed(false);
            return true;
        }
        this.f16645r = true;
        this.f16646s.setVisibility(4);
        m17373a();
        IntrinsicsJvm.kt_4 bVar2 = this.f16649v;
        if (bVar2 != null) {
            bVar2.mo17363c();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IntrinsicsJvm.kt_4 bVar = this.f16649v;
        if (bVar != null) {
            bVar.mo17360a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17366a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        float fAbs = Math.abs(COUIBaseListPopupWindow_12 - f3);
        float fAbs2 = Math.abs(f2 - f4);
        int OplusGLSurfaceView_13 = this.f16632e;
        if (fAbs < OplusGLSurfaceView_13 && fAbs2 < OplusGLSurfaceView_13) {
            return -1;
        }
        this.f16636i = COUIBaseListPopupWindow_12;
        this.f16637j = f2;
        if (0.0f == fAbs || 0.0f == fAbs2) {
            if (0.0f == fAbs) {
                this.f16634g = f2 >= f4 ? 1 : 0;
            } else if (0.0f == fAbs2) {
                this.f16634g = COUIBaseListPopupWindow_12 >= f3 ? 3 : 2;
            }
            return this.f16634g;
        }
        if (COUIBaseListPopupWindow_12 <= f3 && f2 < f4) {
            double IntrinsicsJvm.kt_5 = fAbs2 / fAbs;
            double d2 = this.f16640m;
            if (IntrinsicsJvm.kt_5 < d2) {
                this.f16634g = 2;
            } else if (fAbs / fAbs2 < d2) {
                this.f16634g = 0;
            }
        } else if (COUIBaseListPopupWindow_12 > f3 && f2 <= f4) {
            double d3 = fAbs2 / fAbs;
            double d4 = this.f16640m;
            if (d3 < d4) {
                this.f16634g = 3;
            } else if (fAbs / fAbs2 < d4) {
                this.f16634g = 0;
            }
        } else if (COUIBaseListPopupWindow_12 < f3 && f2 >= f4) {
            double d5 = fAbs2 / fAbs;
            double d6 = this.f16640m;
            if (d5 < d6) {
                this.f16634g = 2;
            } else if (fAbs / fAbs2 < d6) {
                this.f16634g = 1;
            }
        } else if (COUIBaseListPopupWindow_12 >= f3 && f2 > f4) {
            double d7 = fAbs2 / fAbs;
            double d8 = this.f16640m;
            if (d7 < d8) {
                this.f16634g = 3;
            } else if (fAbs / fAbs2 < d8) {
                this.f16634g = 1;
            }
        }
        return this.f16634g;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        if (this.f16643p) {
            this.f16630c = getWidth() / 2;
            this.f16631d = getHeight() / 2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17373a() {
        this.f16643p = true;
        setLayoutParams(new RelativeLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height), getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height)));
        m17377c();
        m17368b(this.f16638k, this.f16639l);
        m17370h();
        m17378d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17368b(float COUIBaseListPopupWindow_12, float f2) {
        if (this.f16647t != null) {
            int OplusGLSurfaceView_13 = this.f16629b;
            this.f16647t.setX(((COUIBaseListPopupWindow_12 + (getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height) / 2)) - (getContext().getResources().getDimensionPixelSize(R.dimen.shutter_button_length) / 2)) - OplusGLSurfaceView_13);
            this.f16647t.setY(((f2 + (getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height) / 2)) - (getContext().getResources().getDimensionPixelSize(R.dimen.shutter_button_length) / 2)) - OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17376b() {
        this.f16643p = false;
        setLayoutParams(new RelativeLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.shutter_button_length), getContext().getResources().getDimensionPixelSize(R.dimen.shutter_button_length)));
        m17377c();
        m17371i();
        m17379e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17377c() {
        int[] iArr = new int[2];
        this.f16646s.getLocationInWindow(iArr);
        float width = (iArr[0] + (this.f16646s.getWidth() / 2)) - (getLayoutParams().width / 2);
        float height = (iArr[1] + (this.f16646s.getHeight() / 2)) - (getLayoutParams().height / 2);
        setX(width);
        setY(height);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17375a(float COUIBaseListPopupWindow_12, float f2) {
        return Math.sqrt(Math.pow((double) Math.abs(((float) this.f16630c) - COUIBaseListPopupWindow_12), 2.0d) + Math.pow((double) Math.abs(((float) this.f16631d) - f2), 2.0d)) <= ((double) this.f16628a);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17369g() {
        if (this.f16647t == null) {
            this.f16647t = new PlatformImplementations.kt_3(getContext());
            int OplusGLSurfaceView_13 = this.f16629b;
            this.f16647t.setLayoutParams(new RelativeLayout.LayoutParams(OplusGLSurfaceView_13 * 2, OplusGLSurfaceView_13 * 2));
            addView(this.f16647t);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m17370h() {
        PlatformImplementations.kt_3 aVar = this.f16647t;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m17371i() {
        PlatformImplementations.kt_3 aVar = this.f16647t;
        if (aVar != null) {
            aVar.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16641n) {
            m17374a(canvas);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17374a(Canvas canvas) {
        if (this.f16648u == null) {
            this.f16648u = new Paint();
            this.f16648u.setAntiAlias(true);
        }
        this.f16648u.setColor(getResources().getColor(R.color.street_trace_layout_background_color));
        this.f16648u.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f16628a, this.f16648u);
        this.f16648u.setColor(getResources().getColor(R.color.street_trace_layout_background_edge_color));
        this.f16648u.setStyle(Paint.Style.STROKE);
        this.f16648u.setStrokeWidth(2.0f);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f16628a + 1, this.f16648u);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17378d() {
        this.f16641n = true;
        setAlpha(0.8f);
        setBackgroundColor(0);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17379e() {
        this.f16641n = false;
        setBackgroundColor(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p169t.StreetTrackLayout.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m17372j() {
        this.f16646s.setPressed(false);
        this.f16646s.setVisibility(0);
        this.f16646s.performClick();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17367a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
        int i2;
        int i3;
        if (-1 == OplusGLSurfaceView_13 && (((2 == (i2 = this.f16634g) || 3 == i2) && COUIBaseListPopupWindow_12 > f2) || (((i3 = this.f16634g) == 0 || 1 == i3) && COUIBaseListPopupWindow_12 < f2))) {
            return this.f16635h;
        }
        if (2 == this.f16635h && 3 == OplusGLSurfaceView_13) {
            this.f16635h = 2;
        } else if (3 == this.f16635h && 2 == OplusGLSurfaceView_13) {
            this.f16635h = 3;
        } else if (this.f16635h == 0 && 1 == OplusGLSurfaceView_13) {
            this.f16635h = 0;
        } else if (1 == this.f16635h && OplusGLSurfaceView_13 == 0) {
            this.f16635h = 1;
        } else {
            this.f16635h = OplusGLSurfaceView_13;
        }
        return this.f16635h;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m17380f() {
        return this.f16643p;
    }

    /* compiled from: StreetTrackLayout.java */
    /* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 extends ImageView {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Paint f16651b;

        public PlatformImplementations.kt_3(Context context) {
            super(context);
            this.f16651b = new Paint();
            this.f16651b.setAntiAlias(true);
            this.f16651b.setColor(getContext().getColor(R.color.street_trace_button_background_color));
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            m17381a(canvas);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m17381a(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.f16651b);
        }
    }

    public int getTrackMaxRadius() {
        return this.f16628a;
    }

    public void setTrackListener(IntrinsicsJvm.kt_4 bVar) {
        this.f16649v = bVar;
    }
}
