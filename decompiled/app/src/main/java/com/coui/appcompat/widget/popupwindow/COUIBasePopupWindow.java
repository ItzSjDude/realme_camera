package com.coui.appcompat.widget.popupwindow;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.p036h.ViewCompat;
import com.coui.appcompat.widget.COUIViewCompat;
import com.google.android.exoplayer2.C1547C;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;

/* compiled from: COUIBasePopupWindow.java */
/* renamed from: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIBasePopupWindow extends PopupWindow {

    /* renamed from: R */
    private static final int[] f8534R = {R.attr.state_above_anchor};

    /* renamed from: A */
    private int f8535A;

    /* renamed from: B */
    private int f8536B;

    /* renamed from: C */
    private int f8537C;

    /* renamed from: D */
    private float f8538D;

    /* renamed from: E */
    private int[] f8539E;

    /* renamed from: F */
    private int[] f8540F;

    /* renamed from: G */
    private Rect f8541G;

    /* renamed from: H */
    private Drawable f8542H;

    /* renamed from: I */
    private Drawable f8543I;

    /* renamed from: J */
    private Drawable f8544J;

    /* renamed from: K */
    private int f8545K;

    /* renamed from: L */
    private int f8546L;

    /* renamed from: M */
    private boolean f8547M;

    /* renamed from: N */
    private int f8548N;

    /* renamed from: O */
    private PlatformImplementations.kt_3 f8549O;

    /* renamed from: P */
    private boolean f8550P;

    /* renamed from: Q */
    private int f8551Q;

    /* renamed from: S */
    private WeakReference<View> f8552S;

    /* renamed from: T */
    private final ViewTreeObserver.OnScrollChangedListener f8553T;

    /* renamed from: U */
    private int f8554U;

    /* renamed from: V */
    private int f8555V;

    /* renamed from: W */
    private int f8556W;

    /* renamed from: X */
    private boolean f8557X;

    /* renamed from: Y */
    private boolean f8558Y;

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f8559a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WindowManager f8560b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f8561c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f8562d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private View f8563e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f8564f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f8565g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8566h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8567i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f8568j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f8569k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f8570l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8571m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f8572n;

    /* renamed from: o */
    private boolean f8573o;

    /* renamed from: p */
    private boolean f8574p;

    /* renamed from: q */
    private boolean f8575q;

    /* renamed from: r */
    private boolean f8576r;

    /* renamed from: s */
    private boolean f8577s;

    /* renamed from: t */
    private boolean f8578t;

    /* renamed from: u */
    private View.OnTouchListener f8579u;

    /* renamed from: v */
    private int f8580v;

    /* renamed from: w */
    private int f8581w;

    /* renamed from: x */
    private int f8582x;

    /* renamed from: y */
    private int f8583y;

    /* renamed from: z */
    private int f8584z;

    /* compiled from: COUIBasePopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo6984a();
    }

    public COUIBasePopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        this.f8566h = 0;
        this.f8567i = 1;
        this.f8568j = true;
        this.f8569k = false;
        this.f8570l = true;
        this.f8571m = -1;
        this.f8574p = true;
        this.f8575q = false;
        this.f8577s = true;
        this.f8578t = false;
        this.f8539E = new int[2];
        this.f8540F = new int[2];
        this.f8541G = new Rect();
        this.f8548N = 1000;
        this.f8550P = false;
        this.f8551Q = -1;
        this.f8553T = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_4.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view = COUIBasePopupWindow.this.f8552S != null ? (View) COUIBasePopupWindow.this.f8552S.get() : null;
                if (view == null || COUIBasePopupWindow.this.f8564f == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) COUIBasePopupWindow.this.f8564f.getLayoutParams();
                COUIBasePopupWindow c1500b = COUIBasePopupWindow.this;
                c1500b.m8069a(c1500b.m8070a(view, layoutParams, c1500b.f8554U, COUIBasePopupWindow.this.f8555V, COUIBasePopupWindow.this.f8556W));
                COUIBasePopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        };
        this.f8559a = context;
        this.f8560b = (WindowManager) context.getSystemService("window");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R.styleable.PopupWindow, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R.styleable.PopupWindowCompat, OplusGLSurfaceView_13, i2);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.PopupWindow_android_popupBackground);
        this.f8538D = typedArrayObtainStyledAttributes2.getDimension(coui.support.appcompat.R.styleable.PopupWindowCompat_supportPopupElevation, 0.0f);
        this.f8557X = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R.styleable.PopupWindow_overlapAnchor, false);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(coui.support.appcompat.R.styleable.PopupWindowCompat_android_popupAnimationStyle, -1);
        this.f8551Q = resourceId == coui.support.appcompat.R.style.Animation_COUI_PopupWindow ? -1 : resourceId;
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
        setBackgroundDrawable(drawable);
    }

    public COUIBasePopupWindow() {
        this(null, 0, 0);
    }

    public COUIBasePopupWindow(View view, int OplusGLSurfaceView_13, int i2) {
        this(view, OplusGLSurfaceView_13, i2, false);
    }

    public COUIBasePopupWindow(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f8566h = 0;
        this.f8567i = 1;
        this.f8568j = true;
        this.f8569k = false;
        this.f8570l = true;
        this.f8571m = -1;
        this.f8574p = true;
        this.f8575q = false;
        this.f8577s = true;
        this.f8578t = false;
        this.f8539E = new int[2];
        this.f8540F = new int[2];
        this.f8541G = new Rect();
        this.f8548N = 1000;
        this.f8550P = false;
        this.f8551Q = -1;
        this.f8553T = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_4.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2 = COUIBasePopupWindow.this.f8552S != null ? (View) COUIBasePopupWindow.this.f8552S.get() : null;
                if (view2 == null || COUIBasePopupWindow.this.f8564f == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) COUIBasePopupWindow.this.f8564f.getLayoutParams();
                COUIBasePopupWindow c1500b = COUIBasePopupWindow.this;
                c1500b.m8069a(c1500b.m8070a(view2, layoutParams, c1500b.f8554U, COUIBasePopupWindow.this.f8555V, COUIBasePopupWindow.this.f8556W));
                COUIBasePopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        };
        if (view != null) {
            this.f8559a = view.getContext();
            this.f8560b = (WindowManager) this.f8559a.getSystemService("window");
        }
        setContentView(view);
        setWidth(OplusGLSurfaceView_13);
        setHeight(i2);
        setFocusable(z);
    }

    @Override // android.widget.PopupWindow
    public Drawable getBackground() {
        return this.f8542H;
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(Drawable drawable) {
        this.f8542H = drawable;
        if (this.f8542H instanceof StateListDrawable) {
            this.f8544J = null;
            this.f8543I = null;
        }
    }

    @Override // android.widget.PopupWindow
    public float getElevation() {
        return this.f8538D;
    }

    @Override // android.widget.PopupWindow
    public void setElevation(float COUIBaseListPopupWindow_12) {
        this.f8538D = COUIBaseListPopupWindow_12;
    }

    @Override // android.widget.PopupWindow
    public int getAnimationStyle() {
        return this.f8551Q;
    }

    @Override // android.widget.PopupWindow
    public void setIgnoreCheekPress() {
        this.f8550P = true;
    }

    @Override // android.widget.PopupWindow
    public void setAnimationStyle(int OplusGLSurfaceView_13) {
        this.f8551Q = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.f8563e;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        View view2;
        if (isShowing()) {
            return;
        }
        this.f8563e = view;
        if (this.f8559a == null && (view2 = this.f8563e) != null) {
            this.f8559a = view2.getContext();
        }
        if (this.f8560b == null && this.f8563e != null) {
            this.f8560b = (WindowManager) this.f8559a.getSystemService("window");
        }
        Context context = this.f8559a;
        if (context == null || this.f8578t) {
            return;
        }
        setAttachedInDecor(context.getApplicationInfo().targetSdkVersion >= 22);
    }

    @Override // android.widget.PopupWindow
    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.f8579u = onTouchListener;
    }

    @Override // android.widget.PopupWindow
    public boolean isFocusable() {
        return this.f8565g;
    }

    @Override // android.widget.PopupWindow
    public void setFocusable(boolean z) {
        this.f8565g = z;
    }

    @Override // android.widget.PopupWindow
    public int getInputMethodMode() {
        return this.f8566h;
    }

    @Override // android.widget.PopupWindow
    public void setInputMethodMode(int OplusGLSurfaceView_13) {
        this.f8566h = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public void setSoftInputMode(int OplusGLSurfaceView_13) {
        this.f8567i = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public int getSoftInputMode() {
        return this.f8567i;
    }

    @Override // android.widget.PopupWindow
    public boolean isTouchable() {
        return this.f8568j;
    }

    @Override // android.widget.PopupWindow
    public void setTouchable(boolean z) {
        this.f8568j = z;
    }

    @Override // android.widget.PopupWindow
    public boolean isOutsideTouchable() {
        return this.f8569k;
    }

    @Override // android.widget.PopupWindow
    public void setOutsideTouchable(boolean z) {
        this.f8569k = z;
    }

    @Override // android.widget.PopupWindow
    public boolean isClippingEnabled() {
        return this.f8570l;
    }

    @Override // android.widget.PopupWindow
    public void setClippingEnabled(boolean z) {
        this.f8570l = z;
    }

    public void setClipToScreenEnabled(boolean z) {
        this.f8573o = z;
        setClippingEnabled(!z);
    }

    @Override // android.widget.PopupWindow
    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.f8571m >= 0 || (context = this.f8559a) == null) ? this.f8571m == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    @Override // android.widget.PopupWindow
    public void setSplitTouchEnabled(boolean z) {
        this.f8571m = z ? 1 : 0;
    }

    public boolean isLayoutInScreenEnabled() {
        return this.f8572n;
    }

    public void setLayoutInScreenEnabled(boolean z) {
        this.f8572n = z;
    }

    @Override // android.widget.PopupWindow
    public boolean isAttachedInDecor() {
        return this.f8577s;
    }

    @Override // android.widget.PopupWindow
    public void setAttachedInDecor(boolean z) {
        this.f8577s = z;
        this.f8578t = true;
    }

    public void setLayoutInsetDecor(boolean z) {
        this.f8575q = z;
    }

    @Override // android.widget.PopupWindow
    public void setWindowLayoutType(int OplusGLSurfaceView_13) {
        this.f8548N = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public int getWindowLayoutType() {
        return this.f8548N;
    }

    @Override // android.widget.PopupWindow
    public void setTouchModal(boolean z) {
        this.f8576r = !z;
    }

    @Override // android.widget.PopupWindow
    public void setWindowLayoutMode(int OplusGLSurfaceView_13, int i2) {
        this.f8580v = OplusGLSurfaceView_13;
        this.f8583y = i2;
    }

    @Override // android.widget.PopupWindow
    public int getHeight() {
        return this.f8584z;
    }

    @Override // android.widget.PopupWindow
    public void setHeight(int OplusGLSurfaceView_13) {
        this.f8584z = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public int getWidth() {
        return this.f8581w;
    }

    @Override // android.widget.PopupWindow
    public void setWidth(int OplusGLSurfaceView_13) {
        this.f8581w = OplusGLSurfaceView_13;
    }

    @Override // android.widget.PopupWindow
    public boolean isShowing() {
        return this.f8561c;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        showAtLocation(view.getWindowToken(), OplusGLSurfaceView_13, i2, i3);
    }

    public void showAtLocation(IBinder iBinder, int OplusGLSurfaceView_13, int i2, int i3) {
        if (isShowing() || this.f8563e == null) {
            return;
        }
        m8079d();
        this.f8561c = true;
        this.f8562d = false;
        WindowManager.LayoutParams layoutParamsM8064a = m8064a(iBinder);
        layoutParamsM8064a.windowAnimations = m8076c();
        m8075b(layoutParamsM8064a);
        if (OplusGLSurfaceView_13 == 0) {
            OplusGLSurfaceView_13 = BadgeDrawable.TOP_START;
        }
        layoutParamsM8064a.gravity = OplusGLSurfaceView_13;
        layoutParamsM8064a.x = i2;
        layoutParamsM8064a.y = i3;
        int i4 = this.f8583y;
        if (i4 < 0) {
            this.f8535A = i4;
            layoutParamsM8064a.height = i4;
        }
        int i5 = this.f8580v;
        if (i5 < 0) {
            this.f8582x = i5;
            layoutParamsM8064a.width = i5;
        }
        mo8084a(layoutParamsM8064a);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int OplusGLSurfaceView_13, int i2) {
        showAsDropDown(view, OplusGLSurfaceView_13, i2, BadgeDrawable.TOP_START);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        if (isShowing() || this.f8563e == null) {
            return;
        }
        m8066a(view, OplusGLSurfaceView_13, i2, i3);
        this.f8561c = true;
        this.f8562d = true;
        WindowManager.LayoutParams layoutParamsM8064a = m8064a(view.getWindowToken());
        m8075b(layoutParamsM8064a);
        m8069a(m8070a(view, layoutParamsM8064a, OplusGLSurfaceView_13, i2, i3));
        int i4 = this.f8583y;
        if (i4 < 0) {
            this.f8535A = i4;
            layoutParamsM8064a.height = i4;
        }
        int i5 = this.f8580v;
        if (i5 < 0) {
            this.f8582x = i5;
            layoutParamsM8064a.width = i5;
        }
        layoutParamsM8064a.windowAnimations = m8076c();
        mo8084a(layoutParamsM8064a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m8069a(boolean z) {
        if (z != this.f8547M) {
            this.f8547M = z;
            if (this.f8542H != null) {
                Drawable drawable = this.f8543I;
                if (drawable != null) {
                    if (this.f8547M) {
                        this.f8564f.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.f8564f.setBackgroundDrawable(this.f8544J);
                        return;
                    }
                }
                this.f8564f.refreshDrawableState();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public boolean isAboveAnchor() {
        return this.f8547M;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8075b(WindowManager.LayoutParams layoutParams) {
        View view = this.f8563e;
        if (view == null || this.f8559a == null || this.f8560b == null) {
            throw new IllegalStateException("You must specify PlatformImplementations.kt_3 valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.f8542H != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int OplusGLSurfaceView_13 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -2;
            IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(this.f8559a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, OplusGLSurfaceView_13);
            bVar.setBackgroundDrawable(this.f8542H);
            bVar.addView(this.f8563e, layoutParams3);
            this.f8564f = bVar;
        } else {
            this.f8564f = view;
        }
        ViewCompat.m2841a(this.f8564f, this.f8538D);
        this.f8558Y = COUIViewCompat.m8185b(this.f8564f) == 2;
        this.f8536B = layoutParams.width;
        this.f8537C = layoutParams.height;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8084a(WindowManager.LayoutParams layoutParams) {
        Context context = this.f8559a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f8564f.setFitsSystemWindows(this.f8575q);
        m8074b();
        this.f8560b.addView(this.f8564f, layoutParams);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8074b() {
        View view;
        WeakReference<View> weakReference = this.f8552S;
        if (weakReference == null || (view = weakReference.get()) == null || !this.f8558Y) {
            return;
        }
        this.f8564f.setLayoutDirection(view.getLayoutDirection());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private WindowManager.LayoutParams m8064a(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = BadgeDrawable.TOP_START;
        int OplusGLSurfaceView_13 = this.f8581w;
        this.f8582x = OplusGLSurfaceView_13;
        layoutParams.width = OplusGLSurfaceView_13;
        int i2 = this.f8584z;
        this.f8535A = i2;
        layoutParams.height = i2;
        Drawable drawable = this.f8542H;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = m8063a(layoutParams.flags);
        layoutParams.type = this.f8548N;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.f8567i;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[PHI: r4
      0x001f: PHI (r4v3 int) = (r4v2 int), (r4v21 int) binds: [B:11:0x001d, B:8:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m8063a(int r4) {
        /*
            r3 = this;
            r0 = -8815129(0xffffffffff797de7, float:-3.316315E38)
            r4 = r4 & r0
            boolean r0 = r3.f8550P
            if (r0 == 0) goto Lc
            r0 = 32768(0x8000, float:4.5918E-41)
            r4 = r4 | r0
        Lc:
            boolean r0 = r3.f8565g
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != 0) goto L1a
            r4 = r4 | 8
            int r0 = r3.f8566h
            r2 = 1
            if (r0 != r2) goto L20
            goto L1f
        L1a:
            int r0 = r3.f8566h
            r2 = 2
            if (r0 != r2) goto L20
        L1f:
            r4 = r4 | r1
        L20:
            boolean r0 = r3.f8568j
            if (r0 != 0) goto L26
            r4 = r4 | 16
        L26:
            boolean r0 = r3.f8569k
            if (r0 == 0) goto L2d
            r0 = 262144(0x40000, float:3.67342E-40)
            r4 = r4 | r0
        L2d:
            boolean r0 = r3.f8570l
            if (r0 != 0) goto L33
            r4 = r4 | 512(0x200, float:7.175E-43)
        L33:
            boolean r0 = r3.isSplitTouchEnabled()
            if (r0 == 0) goto L3c
            r0 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 | r0
        L3c:
            boolean r0 = r3.f8572n
            if (r0 == 0) goto L42
            r4 = r4 | 256(0x100, float:3.59E-43)
        L42:
            boolean r0 = r3.f8575q
            if (r0 == 0) goto L49
            r0 = 65536(0x10000, float:9.18355E-41)
            r4 = r4 | r0
        L49:
            boolean r0 = r3.f8576r
            if (r0 == 0) goto L4f
            r4 = r4 | 32
        L4f:
            boolean r3 = r3.f8577s
            if (r3 == 0) goto L56
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = r4 | r3
        L56:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow.m8063a(int):int");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m8076c() {
        int OplusGLSurfaceView_13 = this.f8551Q;
        if (OplusGLSurfaceView_13 != -1) {
            return OplusGLSurfaceView_13;
        }
        if (this.f8562d) {
            return this.f8547M ? coui.support.appcompat.R.style.Animation_COUI_DropDownUp : coui.support.appcompat.R.style.Animation_COUI_DropDownDown;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m8070a(View view, WindowManager.LayoutParams layoutParams, int OplusGLSurfaceView_13, int i2, int i3) {
        boolean z;
        int height = view.getHeight();
        int width = view.getWidth();
        int i4 = this.f8557X ? i2 - height : i2;
        view.getLocationInWindow(this.f8539E);
        int[] iArr = this.f8539E;
        layoutParams.x = iArr[0] + OplusGLSurfaceView_13;
        layoutParams.y = iArr[1] + height + i4;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7;
        if (absoluteGravity == 5) {
            layoutParams.x -= this.f8536B - width;
        }
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.f8540F);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i5 = this.f8540F[1] + height + i4;
        View rootView = view.getRootView();
        if (i5 + this.f8537C > rect.bottom || (layoutParams.x + this.f8536B) - rootView.getWidth() > 0) {
            if (this.f8574p) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.f8536B + scrollX + OplusGLSurfaceView_13, this.f8537C + scrollY + height + i4), true);
            }
            view.getLocationInWindow(this.f8539E);
            int[] iArr2 = this.f8539E;
            layoutParams.x = iArr2[0] + OplusGLSurfaceView_13;
            layoutParams.y = iArr2[1] + height + i4;
            if (absoluteGravity == 5) {
                layoutParams.x -= this.f8536B - width;
            }
            view.getLocationOnScreen(this.f8540F);
            int i6 = rect.bottom;
            int[] iArr3 = this.f8540F;
            z = ((i6 - iArr3[1]) - height) - i4 < (iArr3[1] - i4) - rect.top;
            if (z) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.f8539E[1]) + i4;
            } else {
                layoutParams.y = this.f8539E[1] + height + i4;
            }
        } else {
            z = false;
        }
        if (this.f8573o) {
            int i7 = rect.right - rect.left;
            int i8 = layoutParams.x + layoutParams.width;
            if (i8 > i7) {
                layoutParams.x -= i8 - i7;
            }
            if (layoutParams.x < rect.left) {
                layoutParams.x = rect.left;
                layoutParams.width = Math.min(layoutParams.width, i7);
            }
            if (z) {
                int i9 = (this.f8540F[1] + i4) - this.f8537C;
                if (i9 < 0) {
                    layoutParams.y += i9;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= C1547C.ENCODING_PCM_MU_LAW;
        this.f8545K = (this.f8539E[0] - layoutParams.x) + (height / 2);
        this.f8546L = (this.f8539E[1] - layoutParams.y) + (width / 2);
        return z;
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(View view) {
        return getMaxAvailableHeight(view, 0);
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(View view, int OplusGLSurfaceView_13) {
        return getMaxAvailableHeight(view, OplusGLSurfaceView_13, false);
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(View view, int OplusGLSurfaceView_13, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.f8539E;
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int iMax = Math.max((i2 - (iArr[1] + view.getHeight())) - OplusGLSurfaceView_13, (iArr[1] - rect.top) + OplusGLSurfaceView_13);
        Drawable drawable = this.f8542H;
        if (drawable == null) {
            return iMax;
        }
        drawable.getPadding(this.f8541G);
        return iMax - (this.f8541G.top + this.f8541G.bottom);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!isShowing() || this.f8564f == null) {
            return;
        }
        this.f8561c = false;
        m8079d();
        try {
            this.f8560b.removeViewImmediate(this.f8564f);
        } finally {
            View view = this.f8564f;
            View view2 = this.f8563e;
            if (view != view2 && (view instanceof ViewGroup)) {
                ((ViewGroup) view).removeView(view2);
            }
            this.f8564f = null;
            PlatformImplementations.kt_3 aVar = this.f8549O;
            if (aVar != null) {
                aVar.mo6984a();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8085a(PlatformImplementations.kt_3 aVar) {
        this.f8549O = aVar;
    }

    @Override // android.widget.PopupWindow
    public void update() {
        if (!isShowing() || this.f8563e == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f8564f.getLayoutParams();
        boolean z = false;
        int iM8076c = m8076c();
        if (iM8076c != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = iM8076c;
            z = true;
        }
        int iM8063a = m8063a(layoutParams.flags);
        if (iM8063a != layoutParams.flags) {
            layoutParams.flags = iM8063a;
            z = true;
        }
        if (z) {
            m8074b();
            this.f8560b.updateViewLayout(this.f8564f, layoutParams);
        }
    }

    @Override // android.widget.PopupWindow
    public void update(int OplusGLSurfaceView_13, int i2) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f8564f.getLayoutParams();
        update(layoutParams.x, layoutParams.y, OplusGLSurfaceView_13, i2, false);
    }

    @Override // android.widget.PopupWindow
    public void update(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        update(OplusGLSurfaceView_13, i2, i3, i4, false);
    }

    @Override // android.widget.PopupWindow
    public void update(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z) {
        if (i3 != -1) {
            this.f8582x = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.f8535A = i4;
            setHeight(i4);
        }
        if (!isShowing() || this.f8563e == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f8564f.getLayoutParams();
        int i5 = this.f8580v;
        if (i5 >= 0) {
            i5 = this.f8582x;
        }
        if (i3 != -1 && layoutParams.width != i5) {
            this.f8582x = i5;
            layoutParams.width = i5;
            z = true;
        }
        int i6 = this.f8583y;
        if (i6 >= 0) {
            i6 = this.f8535A;
        }
        if (i4 != -1 && layoutParams.height != i6) {
            this.f8535A = i6;
            layoutParams.height = i6;
            z = true;
        }
        if (layoutParams.x != OplusGLSurfaceView_13) {
            layoutParams.x = OplusGLSurfaceView_13;
            z = true;
        }
        if (layoutParams.y != i2) {
            layoutParams.y = i2;
            z = true;
        }
        int iM8076c = m8076c();
        if (iM8076c != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = iM8076c;
            z = true;
        }
        int iM8063a = m8063a(layoutParams.flags);
        if (iM8063a != layoutParams.flags) {
            layoutParams.flags = iM8063a;
            z = true;
        }
        if (z) {
            m8074b();
            this.f8560b.updateViewLayout(this.f8564f, layoutParams);
        }
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int OplusGLSurfaceView_13, int i2) {
        m8067a(view, false, 0, 0, true, OplusGLSurfaceView_13, i2, this.f8556W);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        m8067a(view, true, OplusGLSurfaceView_13, i2, true, i3, i4, this.f8556W);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8067a(View view, boolean z, int OplusGLSurfaceView_13, int i2, boolean z2, int i3, int i4, int i5) {
        int i6 = i3;
        int i7 = i4;
        if (!isShowing() || this.f8563e == null) {
            return;
        }
        WeakReference<View> weakReference = this.f8552S;
        boolean z3 = true;
        boolean z4 = z && !(this.f8554U == OplusGLSurfaceView_13 && this.f8555V == i2);
        if (weakReference == null || weakReference.get() != view || (z4 && !this.f8562d)) {
            m8066a(view, OplusGLSurfaceView_13, i2, i5);
        } else if (z4) {
            this.f8554U = OplusGLSurfaceView_13;
            this.f8555V = i2;
            this.f8556W = i5;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f8564f.getLayoutParams();
        if (z2) {
            if (i6 == -1) {
                i6 = this.f8536B;
            } else {
                this.f8536B = i6;
            }
            if (i7 == -1) {
                i7 = this.f8537C;
            } else {
                this.f8537C = i7;
            }
        }
        int i8 = i6;
        int i9 = i7;
        int i10 = layoutParams.x;
        int i11 = layoutParams.y;
        if (z) {
            m8069a(m8070a(view, layoutParams, OplusGLSurfaceView_13, i2, i5));
        } else {
            m8069a(m8070a(view, layoutParams, this.f8554U, this.f8555V, this.f8556W));
        }
        int i12 = layoutParams.x;
        int i13 = layoutParams.y;
        if (i10 == layoutParams.x && i11 == layoutParams.y) {
            z3 = false;
        }
        update(i12, i13, i8, i9, z3);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8079d() {
        WeakReference<View> weakReference = this.f8552S;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.f8553T);
        }
        this.f8552S = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8066a(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        m8079d();
        this.f8552S = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.f8553T);
        }
        this.f8554U = OplusGLSurfaceView_13;
        this.f8555V = i2;
        this.f8556W = i3;
    }

    /* compiled from: COUIBasePopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends FrameLayout {
        public IntrinsicsJvm.kt_4(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
            if (COUIBasePopupWindow.this.f8547M) {
                int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
                View.mergeDrawableStates(iArrOnCreateDrawableState, COUIBasePopupWindow.f8534R);
                return iArrOnCreateDrawableState;
            }
            return super.onCreateDrawableState(OplusGLSurfaceView_13);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    COUIBasePopupWindow.this.dismiss();
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (COUIBasePopupWindow.this.f8579u == null || !COUIBasePopupWindow.this.f8579u.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                COUIBasePopupWindow.this.dismiss();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                COUIBasePopupWindow.this.dismiss();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int OplusGLSurfaceView_13) {
            if (COUIBasePopupWindow.this.f8563e != null) {
                COUIBasePopupWindow.this.f8563e.sendAccessibilityEvent(OplusGLSurfaceView_13);
            } else {
                super.sendAccessibilityEvent(OplusGLSurfaceView_13);
            }
        }
    }
}
