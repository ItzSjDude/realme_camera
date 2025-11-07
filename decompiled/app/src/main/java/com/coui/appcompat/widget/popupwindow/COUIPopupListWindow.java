package com.coui.appcompat.widget.popupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: COUIPopupListWindow.java */
/* renamed from: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUIPopupListWindow extends PopupWindow implements View.OnLayoutChangeListener {

    /* renamed from: A */
    private boolean f8587A;

    /* renamed from: B */
    private boolean f8588B;

    /* renamed from: C */
    private boolean f8589C;

    /* renamed from: D */
    private Animation.AnimationListener f8590D;

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f8591a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private BaseAdapter f8592b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private BaseAdapter f8593c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private BaseAdapter f8594d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private View f8595e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Rect f8596f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Rect f8597g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Rect f8598h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Rect f8599i;

    /* renamed from: OplusGLSurfaceView_15 */
    private List<PopupListItem> f8600j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ViewGroup f8601k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ListView f8602l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ListView f8603m;

    /* renamed from: OplusGLSurfaceView_11 */
    private AdapterView.OnItemClickListener f8604n;

    /* renamed from: o */
    private Point f8605o;

    /* renamed from: p */
    private int[] f8606p;

    /* renamed from: q */
    private int[] f8607q;

    /* renamed from: r */
    private int[] f8608r;

    /* renamed from: s */
    private float f8609s;

    /* renamed from: t */
    private float f8610t;

    /* renamed from: u */
    private int f8611u;

    /* renamed from: v */
    private int f8612v;

    /* renamed from: w */
    private Interpolator f8613w;

    /* renamed from: x */
    private Interpolator f8614x;

    /* renamed from: y */
    private int f8615y;

    /* renamed from: z */
    private boolean f8616z;

    public COUIPopupListWindow(Context context) throws Resources.NotFoundException {
        super(context);
        this.f8605o = new Point();
        this.f8606p = new int[2];
        this.f8607q = new int[2];
        this.f8608r = new int[4];
        this.f8590D = new Animation.AnimationListener() { // from class: com.coui.appcompat.widget.popupwindow.IntrinsicsJvm.kt_5.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIPopupListWindow.this.f8589C = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                COUIPopupListWindow.this.m8099b();
                COUIPopupListWindow.this.f8589C = false;
            }
        };
        this.f8591a = context;
        this.f8600j = new ArrayList();
        this.f8611u = context.getResources().getInteger(R.integer.coui_animation_time_move_veryfast);
        this.f8612v = context.getResources().getInteger(R.integer.coui_animation_time_move_veryfast);
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(context, R.anim.coui_curve_opacity_inout);
        this.f8614x = interpolatorLoadInterpolator;
        this.f8613w = interpolatorLoadInterpolator;
        this.f8615y = context.getResources().getDimensionPixelSize(R.dimen.coui_popup_list_window_min_width);
        this.f8603m = new ListView(context);
        this.f8603m.setDivider(null);
        this.f8603m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f8601k = m8086a(context);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        if (Build.VERSION.SDK_INT > 23) {
            setExitTransition(null);
            setEnterTransition(null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewGroup m8086a(Context context) throws Resources.NotFoundException {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.coui_popup_list_window_layout, (ViewGroup) null);
        this.f8602l = (ListView) frameLayout.findViewById(R.id_renamed.coui_popup_list_view);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.couiPopupListWindowBackground});
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = context.getResources().getDrawable(R.drawable.coui_popup_list_window_bg);
        }
        this.f8599i = new Rect();
        drawable.getPadding(this.f8599i);
        frameLayout.setBackground(drawable);
        typedArrayObtainStyledAttributes.recycle();
        return frameLayout;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8095a(View view) {
        if (view != null) {
            if ((this.f8592b == null && this.f8593c == null) || isShowing()) {
                return;
            }
            this.f8595e = view;
            this.f8595e.getRootView().removeOnLayoutChangeListener(this);
            this.f8595e.getRootView().addOnLayoutChangeListener(this);
            BaseAdapter baseAdapter = this.f8593c;
            if (baseAdapter == null) {
                this.f8594d = this.f8592b;
            } else {
                this.f8594d = baseAdapter;
            }
            this.f8602l.setAdapter((ListAdapter) this.f8594d);
            AdapterView.OnItemClickListener onItemClickListener = this.f8604n;
            if (onItemClickListener != null) {
                this.f8602l.setOnItemClickListener(onItemClickListener);
            }
            this.f8596f = new Rect();
            this.f8597g = new Rect();
            this.f8598h = new Rect();
            this.f8595e.getWindowVisibleDisplayFrame(this.f8596f);
            this.f8595e.getGlobalVisibleRect(this.f8597g);
            this.f8595e.getRootView().getGlobalVisibleRect(this.f8598h);
            this.f8597g.left -= this.f8608r[0];
            this.f8597g.top -= this.f8608r[1];
            this.f8597g.right += this.f8608r[2];
            this.f8597g.bottom += this.f8608r[3];
            this.f8595e.getRootView().getLocationOnScreen(this.f8606p);
            Rect rect = this.f8597g;
            int[] iArr = this.f8606p;
            rect.offset(iArr[0], iArr[1]);
            Rect rect2 = this.f8598h;
            int[] iArr2 = this.f8606p;
            rect2.offset(iArr2[0], iArr2[1]);
            Rect rect3 = this.f8596f;
            rect3.left = Math.max(rect3.left, this.f8598h.left);
            Rect rect4 = this.f8596f;
            rect4.top = Math.max(rect4.top, this.f8598h.top);
            Rect rect5 = this.f8596f;
            rect5.right = Math.min(rect5.right, this.f8598h.right);
            Rect rect6 = this.f8596f;
            rect6.bottom = Math.min(rect6.bottom, this.f8598h.bottom);
            m8088d();
            m8094a();
            m8090f();
            if (this.f8616z && this.f8587A) {
                setContentView(this.f8601k);
                m8091g();
                m8092h();
                showAtLocation(this.f8595e, 0, this.f8605o.x, this.f8605o.y);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8088d() {
        this.f8595e.getRootView().getLocationOnScreen(this.f8606p);
        int[] iArr = this.f8606p;
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        this.f8595e.getRootView().getLocationInWindow(this.f8606p);
        int[] iArr2 = this.f8606p;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        int[] iArr3 = this.f8607q;
        iArr3[0] = OplusGLSurfaceView_13 - i3;
        iArr3[1] = i2 - i4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8094a() {
        BaseAdapter baseAdapter = this.f8594d;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(m8089e(), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = baseAdapter.getCount();
        int OplusGLSurfaceView_13 = 0;
        int iMakeMeasureSpec3 = iMakeMeasureSpec2;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View view = baseAdapter.getView(i3, null, this.f8603m);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams.height != -2) {
                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
            OplusGLSurfaceView_13 += measuredHeight;
        }
        setWidth(Math.max(i2, this.f8615y) + this.f8599i.left + this.f8599i.right);
        setHeight(OplusGLSurfaceView_13 + this.f8599i.top + this.f8599i.bottom);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m8089e() {
        return ((this.f8596f.right - this.f8596f.left) - this.f8599i.left) - this.f8599i.right;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* renamed from: COUIBaseListPopupWindow_12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8090f() {
        /*
            r9 = this;
            r0 = 1
            r9.f8587A = r0
            r9.f8616z = r0
            android.graphics.Rect r1 = r9.f8596f
            int r1 = r1.right
            android.graphics.Rect r2 = r9.f8596f
            int r2 = r2.left
            int r1 = r1 - r2
            int r2 = r9.getWidth()
            r3 = 0
            if (r1 >= r2) goto L18
            r9.f8587A = r3
            return
        L18:
            android.graphics.Rect r1 = r9.f8597g
            int r1 = r1.centerX()
            int r2 = r9.getWidth()
            int r2 = r2 / 2
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.f8596f
            int r2 = r2.right
            int r4 = r9.getWidth()
            int r2 = r2 - r4
            int r1 = java.lang.Math.min(r1, r2)
            android.graphics.Rect r2 = r9.f8596f
            int r2 = r2.left
            int r1 = java.lang.Math.max(r2, r1)
            int[] r2 = r9.f8607q
            r2 = r2[r3]
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.f8597g
            int r2 = r2.top
            android.graphics.Rect r4 = r9.f8596f
            int r4 = r4.top
            int r2 = r2 - r4
            android.graphics.Rect r4 = r9.f8596f
            int r4 = r4.bottom
            android.graphics.Rect r5 = r9.f8597g
            int r5 = r5.bottom
            int r4 = r4 - r5
            int r5 = r9.getHeight()
            if (r2 < r5) goto L59
            r6 = r0
            goto L5a
        L59:
            r6 = r3
        L5a:
            if (r4 < r5) goto L5e
            r7 = r0
            goto L5f
        L5e:
            r7 = r3
        L5f:
            android.graphics.Rect r8 = r9.f8597g
            int r8 = r8.top
            int r8 = r8 - r5
            android.graphics.Rect r5 = r9.f8597g
            int r5 = r5.bottom
            if (r4 > 0) goto L6f
            if (r2 > 0) goto L6f
            r9.f8616z = r3
            return
        L6f:
            boolean r3 = r9.f8588B
            if (r3 == 0) goto L76
            if (r6 == 0) goto L7e
            goto L78
        L76:
            if (r7 == 0) goto L7e
        L78:
            boolean r2 = r9.f8588B
            if (r2 == 0) goto L9d
        L7c:
            r5 = r8
            goto L9d
        L7e:
            boolean r3 = r9.f8588B
            if (r3 == 0) goto L85
            if (r7 == 0) goto L8c
            goto L87
        L85:
            if (r6 == 0) goto L8c
        L87:
            boolean r2 = r9.f8588B
            if (r2 == 0) goto L7c
            goto L9d
        L8c:
            if (r2 <= r4) goto L96
            android.graphics.Rect r3 = r9.f8596f
            int r5 = r3.top
            r9.setHeight(r2)
            goto L9d
        L96:
            android.graphics.Rect r2 = r9.f8597g
            int r5 = r2.bottom
            r9.setHeight(r4)
        L9d:
            android.graphics.Point r2 = r9.f8605o
            int[] r9 = r9.f8607q
            r9 = r9[r0]
            int r5 = r5 - r9
            r2.set(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.COUIPopupListWindow.m8090f():void");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m8091g() {
        if ((this.f8597g.centerX() - this.f8607q[0]) - this.f8605o.x >= getWidth()) {
            this.f8609s = 1.0f;
        } else {
            this.f8609s = ((this.f8597g.centerX() - this.f8607q[0]) - this.f8605o.x) / getWidth();
        }
        if (this.f8605o.y >= this.f8597g.top - this.f8607q[1]) {
            this.f8610t = 0.0f;
        } else {
            this.f8610t = 1.0f;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m8092h() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, this.f8609s, 1, this.f8610t);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration(this.f8611u);
        scaleAnimation.setInterpolator(this.f8613w);
        alphaAnimation.setDuration(this.f8612v);
        alphaAnimation.setInterpolator(this.f8614x);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f8601k.startAnimation(animationSet);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m8093i() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.f8612v);
        alphaAnimation.setInterpolator(this.f8614x);
        alphaAnimation.setAnimationListener(this.f8590D);
        this.f8601k.startAnimation(alphaAnimation);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Rect rect = new Rect(OplusGLSurfaceView_13, i2, i3, i4);
        Rect rect2 = new Rect(i5, i6, i7, i8);
        if (!isShowing() || rect.equals(rect2)) {
            return;
        }
        m8099b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8099b() {
        super.dismiss();
        this.f8589C = false;
        this.f8595e.getRootView().removeOnLayoutChangeListener(this);
        setContentView(null);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!this.f8589C) {
            m8093i();
        } else {
            m8099b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8097a(List<PopupListItem> list) {
        if (list != null) {
            this.f8600j = list;
            this.f8592b = new DefaultAdapter(this.f8591a, list);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8096a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f8604n = onItemClickListener;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ListView m8100c() {
        return this.f8602l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8098a(boolean z) {
        if (z) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }
}
