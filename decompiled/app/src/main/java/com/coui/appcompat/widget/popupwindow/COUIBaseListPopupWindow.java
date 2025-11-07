package com.coui.appcompat.widget.popupwindow;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.p036h.MotionEventCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.coui.appcompat.widget.COUIListViewCompat;
import com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow;
import coui.support.appcompat.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: COUIBaseListPopupWindow.java */
/* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUIBaseListPopupWindow {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f8478a;

    /* renamed from: A */
    private Handler f8479A;

    /* renamed from: B */
    private Rect f8480B;

    /* renamed from: C */
    private boolean f8481C;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f8482b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected COUIBasePopupWindow f8483c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f8484d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ListAdapter f8485e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private IntrinsicsJvm.kt_4 f8486f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8487g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8488h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8489i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8490j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f8491k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f8492l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f8493m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f8494n;

    /* renamed from: o */
    private View f8495o;

    /* renamed from: p */
    private int f8496p;

    /* renamed from: q */
    private DataSetObserver f8497q;

    /* renamed from: r */
    private View f8498r;

    /* renamed from: s */
    private Drawable f8499s;

    /* renamed from: t */
    private AdapterView.OnItemClickListener f8500t;

    /* renamed from: u */
    private AdapterView.OnItemSelectedListener f8501u;

    /* renamed from: v */
    private final COUIBaseListPopupWindow_10 f8502v;

    /* renamed from: w */
    private final COUIBaseListPopupWindow_11 f8503w;

    /* renamed from: x */
    private final COUIBaseListPopupWindow_12 f8504x;

    /* renamed from: y */
    private final IntrinsicsJvm.kt_5 f8505y;

    /* renamed from: z */
    private Runnable f8506z;

    static {
        try {
            f8478a = COUIBasePopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.OplusGLSurfaceView_13("BaseListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6981a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f8497q;
        if (dataSetObserver == null) {
            this.f8497q = new COUIBaseListPopupWindow_8(this, null);
        } else {
            ListAdapter listAdapter2 = this.f8485e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f8485e = listAdapter;
        if (this.f8485e != null) {
            listAdapter.registerDataSetObserver(this.f8497q);
        }
        IntrinsicsJvm.kt_4 bVar = this.f8486f;
        if (bVar != null) {
            bVar.setAdapter((ListAdapter) new PlatformImplementations.kt_3(this.f8485e));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Drawable m8035e() {
        return this.f8483c.getBackground();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8029a(Drawable drawable) {
        this.f8483c.setBackgroundDrawable(drawable);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public View m8041l() {
        return this.f8498r;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m8039g() {
        return this.f8489i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8031b(int OplusGLSurfaceView_13) {
        this.f8489i = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m8037f() {
        if (this.f8491k) {
            return this.f8490j;
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8028a(int OplusGLSurfaceView_13) {
        this.f8490j = OplusGLSurfaceView_13;
        this.f8491k = true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m8042m() {
        return this.f8488h;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8032c(int OplusGLSurfaceView_13) {
        this.f8488h = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8033d(int OplusGLSurfaceView_13) {
        Drawable background = this.f8483c.getBackground();
        if (background != null) {
            background.getPadding(this.f8480B);
            this.f8488h = this.f8480B.left + this.f8480B.right + OplusGLSurfaceView_13;
        } else {
            m8032c(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8036e(int OplusGLSurfaceView_13) {
        this.f8487g = OplusGLSurfaceView_13;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* renamed from: COUIBaseListPopupWindow_10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo8014h() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow.mo8014h():void");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo6987c() {
        this.f8483c.dismiss();
        m8023a();
        this.f8483c.setContentView(null);
        this.f8486f = null;
        this.f8479A.removeCallbacks(this.f8502v);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8030a(COUIBasePopupWindow.PlatformImplementations.kt_3 aVar) {
        this.f8483c.m8085a(aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8023a() {
        View view = this.f8495o;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8495o);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m8038f(int OplusGLSurfaceView_13) {
        this.f8483c.setInputMethodMode(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m8040g(int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = this.f8486f;
        if (!m8034d() || bVar == null) {
            return;
        }
        bVar.f8512f = false;
        bVar.setSelection(OplusGLSurfaceView_13);
        if (Build.VERSION.SDK_INT < 11 || bVar.getChoiceMode() == 0) {
            return;
        }
        bVar.setItemChecked(OplusGLSurfaceView_13, true);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m8043n() {
        IntrinsicsJvm.kt_4 bVar = this.f8486f;
        if (bVar != null) {
            bVar.f8512f = true;
            bVar.requestLayout();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m8034d() {
        return this.f8483c.isShowing();
    }

    /* renamed from: o */
    public boolean m8044o() {
        return this.f8483c.getInputMethodMode() == 2;
    }

    /* renamed from: p */
    public ListView m8045p() {
        return this.f8486f;
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$1, reason: invalid class name */
    class COUIBaseListPopupWindow_2 extends IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseListPopupWindow f8507a;

        @Override // com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow mo8046a() {
            return this.f8507a;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected int mo8016j() {
        int measuredHeight;
        int iMakeMeasureSpec;
        int OplusGLSurfaceView_13 = 0;
        if (this.f8486f == null) {
            Context context = this.f8482b;
            this.f8506z = new Runnable() { // from class: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    View viewM8041l = COUIBaseListPopupWindow.this.m8041l();
                    if (viewM8041l == null || viewM8041l.getWindowToken() == null) {
                        return;
                    }
                    COUIBaseListPopupWindow.this.mo8014h();
                }
            };
            this.f8486f = new IntrinsicsJvm.kt_4(context, !this.f8481C);
            Drawable drawable = this.f8499s;
            if (drawable != null) {
                this.f8486f.setSelector(drawable);
            }
            this.f8486f.setAdapter((ListAdapter) new PlatformImplementations.kt_3(this.f8485e));
            this.f8486f.setOnItemClickListener(this.f8500t);
            this.f8486f.setFocusable(true);
            this.f8486f.setFocusableInTouchMode(true);
            this.f8486f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                    IntrinsicsJvm.kt_4 bVar;
                    if (i2 == -1 || (bVar = COUIBaseListPopupWindow.this.f8486f) == null) {
                        return;
                    }
                    bVar.f8512f = false;
                }
            });
            this.f8486f.setOnScrollListener(this.f8504x);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f8501u;
            if (onItemSelectedListener != null) {
                this.f8486f.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f8486f;
            View view2 = this.f8495o;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i2 = this.f8496p;
                if (i2 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i2 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                } else {
                    Log.COUIBaseListPopupWindow_8("BaseListPopupWindow", "Invalid hint position " + this.f8496p);
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(this.f8488h, Integer.MIN_VALUE), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f8483c.setContentView(view);
        } else {
            View view3 = this.f8495o;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f8483c.getBackground();
        if (background != null) {
            background.getPadding(this.f8480B);
            OplusGLSurfaceView_13 = this.f8480B.top + this.f8480B.bottom;
            if (!this.f8491k) {
                this.f8490j = -this.f8480B.top;
            }
        } else {
            this.f8480B.setEmpty();
        }
        this.f8483c.getInputMethodMode();
        int maxAvailableHeight = this.f8483c.getMaxAvailableHeight(m8041l(), this.f8490j);
        if (this.f8493m || this.f8487g == -1) {
            return maxAvailableHeight + OplusGLSurfaceView_13;
        }
        int i3 = this.f8488h;
        if (i3 == -2) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8482b.getResources().getDisplayMetrics().widthPixels - (this.f8480B.left + this.f8480B.right), Integer.MIN_VALUE);
        } else if (i3 == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8482b.getResources().getDisplayMetrics().widthPixels - (this.f8480B.left + this.f8480B.right), 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        int iA = this.f8486f.m7790a(iMakeMeasureSpec, 0, -1, maxAvailableHeight - measuredHeight, -1);
        if (iA > 0) {
            measuredHeight += OplusGLSurfaceView_13;
        }
        return iA + measuredHeight;
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static abstract class IntrinsicsJvm.kt_3 implements View.OnTouchListener {

        /* renamed from: PlatformImplementations.kt_3 */
        private final float f8517a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f8518b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f8519c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final View f8520d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Runnable f8521e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Runnable f8522f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f8523g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f8524h;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f8525i;

        /* renamed from: OplusGLSurfaceView_15 */
        private final int[] f8526j;

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract COUIBaseListPopupWindow mo8046a();

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean zM8057b;
            boolean z = this.f8523g;
            if (z) {
                zM8057b = this.f8524h ? m8057b(motionEvent) : m8057b(motionEvent) || !m8062c();
            } else {
                zM8057b = m8053a(motionEvent) && m8061b();
                if (zM8057b) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f8520d.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
            }
            this.f8523g = zM8057b;
            return zM8057b || z;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected boolean m8061b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            COUIBaseListPopupWindow c1499aMo8046a = mo8046a();
            if (c1499aMo8046a == null || c1499aMo8046a.m8034d()) {
                return true;
            }
            c1499aMo8046a.mo8014h();
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected boolean m8062c() {
            COUIBaseListPopupWindow c1499aMo8046a = mo8046a();
            if (c1499aMo8046a == null || !c1499aMo8046a.m8034d()) {
                return true;
            }
            c1499aMo8046a.mo6987c();
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean m8053a(android.view.MotionEvent r6) {
            /*
                r5 = this;
                android.view.View r0 = r5.f8520d
                boolean r1 = r0.isEnabled()
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                int r1 = androidx.core.p036h.MotionEventCompat.m2794a(r6)
                if (r1 == 0) goto L41
                r3 = 1
                if (r1 == r3) goto L3d
                r4 = 2
                if (r1 == r4) goto L1a
                r6 = 3
                if (r1 == r6) goto L3d
                goto L70
            L1a:
                int r1 = r5.f8525i
                int r1 = r6.findPointerIndex(r1)
                if (r1 < 0) goto L70
                float r4 = r6.getX(r1)
                float r6 = r6.getY(r1)
                float r1 = r5.f8517a
                boolean r6 = m8054a(r0, r4, r6, r1)
                if (r6 != 0) goto L70
                r5.m8059d()
                android.view.ViewParent r5 = r0.getParent()
                r5.requestDisallowInterceptTouchEvent(r3)
                return r3
            L3d:
                r5.m8059d()
                goto L70
            L41:
                int r6 = r6.getPointerId(r2)
                r5.f8525i = r6
                r5.f8524h = r2
                java.lang.Runnable r6 = r5.f8521e
                r1 = 0
                if (r6 != 0) goto L55
                com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 r6 = new com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$PlatformImplementations.kt_3
                r6.<init>(r5, r1)
                r5.f8521e = r6
            L55:
                java.lang.Runnable r6 = r5.f8521e
                int r3 = r5.f8518b
                long r3 = (long) r3
                r0.postDelayed(r6, r3)
                java.lang.Runnable r6 = r5.f8522f
                if (r6 != 0) goto L68
                com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 r6 = new com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4
                r6.<init>(r5, r1)
                r5.f8522f = r6
            L68:
                java.lang.Runnable r6 = r5.f8522f
                int r5 = r5.f8519c
                long r3 = (long) r5
                r0.postDelayed(r6, r3)
            L70:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow.IntrinsicsJvm.kt_3.m8053a(android.view.MotionEvent):boolean");
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m8059d() {
            Runnable runnable = this.f8522f;
            if (runnable != null) {
                this.f8520d.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.f8521e;
            if (runnable2 != null) {
                this.f8520d.removeCallbacks(runnable2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m8060e() {
            m8059d();
            View view = this.f8520d;
            if (view.isEnabled() && !view.isLongClickable() && m8061b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                this.f8523g = true;
                this.f8524h = true;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m8057b(MotionEvent motionEvent) {
            IntrinsicsJvm.kt_4 bVar;
            View view = this.f8520d;
            COUIBaseListPopupWindow c1499aMo8046a = mo8046a();
            if (c1499aMo8046a == null || !c1499aMo8046a.m8034d() || (bVar = c1499aMo8046a.f8486f) == null || !bVar.isShown()) {
                return false;
            }
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m8058b(view, motionEventObtainNoHistory);
            m8055a(bVar, motionEventObtainNoHistory);
            boolean zM8051a = bVar.m8051a(motionEventObtainNoHistory, this.f8525i);
            motionEventObtainNoHistory.recycle();
            int iM2794a = MotionEventCompat.m2794a(motionEvent);
            return zM8051a && (iM2794a != 1 && iM2794a != 3);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static boolean m8054a(View view, float COUIBaseListPopupWindow_12, float f2, float f3) {
            float f4 = -f3;
            return COUIBaseListPopupWindow_12 >= f4 && f2 >= f4 && COUIBaseListPopupWindow_12 < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m8055a(View view, MotionEvent motionEvent) {
            view.getLocationOnScreen(this.f8526j);
            motionEvent.offsetLocation(-r1[0], -r1[1]);
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m8058b(View view, MotionEvent motionEvent) {
            view.getLocationOnScreen(this.f8526j);
            motionEvent.offsetLocation(r1[0], r1[1]);
            return true;
        }

        /* compiled from: COUIBaseListPopupWindow.java */
        /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
        private class PlatformImplementations.kt_3 implements Runnable {
            private PlatformImplementations.kt_3() {
            }

            /* synthetic */ PlatformImplementations.kt_3(IntrinsicsJvm.kt_3 cVar, COUIBaseListPopupWindow_2 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                IntrinsicsJvm.kt_3.this.f8520d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* compiled from: COUIBaseListPopupWindow.java */
        /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
        private class IntrinsicsJvm.kt_4 implements Runnable {
            private IntrinsicsJvm.kt_4() {
            }

            /* synthetic */ IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_3 cVar, COUIBaseListPopupWindow_2 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                IntrinsicsJvm.kt_3.this.m8060e();
            }
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements ListAdapter {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ListAdapter f8511b;

        public PlatformImplementations.kt_3(ListAdapter listAdapter) {
            this.f8511b = listAdapter;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return null;
            }
            return listAdapter.getItem(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return 0L;
            }
            return listAdapter.getItemId(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter listAdapter = this.f8511b;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return null;
            }
            View view2 = listAdapter.getView(OplusGLSurfaceView_13, view, viewGroup);
            if (view2 == null) {
                return view2;
            }
            view2.setAlpha(0.0f);
            view2.animate().alpha(1.0f).setInterpolator(PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.66f, 1.0f)).setDuration(350L).setStartDelay(150L).start();
            return view2;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getItemViewType(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            if (this.f8511b == null) {
                if (COUIBaseListPopupWindow.this.f8485e != null) {
                    Log.IntrinsicsJvm.kt_5("COUIBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + COUIBaseListPopupWindow.this.f8485e + ",typeCount = " + COUIBaseListPopupWindow.this.f8485e.getViewTypeCount());
                } else {
                    Log.IntrinsicsJvm.kt_5("COUIBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + COUIBaseListPopupWindow.this.f8485e);
                }
            } else {
                Log.IntrinsicsJvm.kt_5("COUIBaseListPopupWindow", "listAdapter.typeCount = " + this.f8511b.getViewTypeCount());
            }
            ListAdapter listAdapter = this.f8511b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getViewTypeCount();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter listAdapter = this.f8511b;
            return listAdapter != null && listAdapter.isEmpty();
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f8511b;
            return listAdapter != null && listAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f8511b;
            return listAdapter != null && listAdapter.isEnabled(OplusGLSurfaceView_13);
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends COUIListViewCompat {

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f8512f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f8513g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f8514h;

        /* renamed from: OplusGLSurfaceView_13 */
        private ViewPropertyAnimatorCompat f8515i;

        /* renamed from: OplusGLSurfaceView_15 */
        private ListViewAutoScrollHelper f8516j;

        public IntrinsicsJvm.kt_4(Context context, boolean z) {
            super(context, null, R.attr.dropDownListViewStyle);
            this.f8513g = z;
            setCacheColorHint(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m8051a(android.view.MotionEvent r8, int r9) {
            /*
                r7 = this;
                int r0 = androidx.core.p036h.MotionEventCompat.m2794a(r8)
                r1 = 0
                r2 = 1
                if (r0 == r2) goto L16
                r3 = 2
                if (r0 == r3) goto L14
                r9 = 3
                if (r0 == r9) goto L11
            Le:
                r9 = r1
                r3 = r2
                goto L46
            L11:
                r9 = r1
                r3 = r9
                goto L46
            L14:
                r3 = r2
                goto L17
            L16:
                r3 = r1
            L17:
                int r9 = r8.findPointerIndex(r9)
                if (r9 >= 0) goto L1e
                goto L11
            L1e:
                float r4 = r8.getX(r9)
                int r4 = (int) r4
                float r9 = r8.getY(r9)
                int r9 = (int) r9
                int r5 = r7.pointToPosition(r4, r9)
                r6 = -1
                if (r5 != r6) goto L31
                r9 = r2
                goto L46
            L31:
                int r3 = r7.getFirstVisiblePosition()
                int r3 = r5 - r3
                android.view.View r3 = r7.getChildAt(r3)
                float r4 = (float) r4
                float r9 = (float) r9
                r7.m8048a(r3, r5, r4, r9)
                if (r0 != r2) goto Le
                r7.m8047a(r3, r5)
                goto Le
            L46:
                if (r3 == 0) goto L4a
                if (r9 == 0) goto L4d
            L4a:
                r7.m8050d()
            L4d:
                if (r3 == 0) goto L65
                androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f8516j
                if (r9 != 0) goto L5a
                androidx.core.widget.COUIBaseListPopupWindow_12 r9 = new androidx.core.widget.COUIBaseListPopupWindow_12
                r9.<init>(r7)
                r7.f8516j = r9
            L5a:
                androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f8516j
                r9.m3004a(r2)
                androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f8516j
                r9.onTouch(r7, r8)
                goto L6c
            L65:
                androidx.core.widget.COUIBaseListPopupWindow_12 r7 = r7.f8516j
                if (r7 == 0) goto L6c
                r7.m3004a(r1)
            L6c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow.IntrinsicsJvm.kt_4.m8051a(android.view.MotionEvent, int):boolean");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m8047a(View view, int OplusGLSurfaceView_13) {
            performItemClick(view, OplusGLSurfaceView_13, getItemIdAtPosition(OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m8050d() {
            this.f8514h = false;
            setPressed(false);
            drawableStateChanged();
            ViewPropertyAnimatorCompat c0517z = this.f8515i;
            if (c0517z != null) {
                c0517z.m2953b();
                this.f8515i = null;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m8048a(View view, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
            this.f8514h = true;
            setPressed(true);
            layoutChildren();
            setSelection(OplusGLSurfaceView_13);
            m7793a(OplusGLSurfaceView_13, view, COUIBaseListPopupWindow_12, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        @Override // com.coui.appcompat.widget.COUIListViewCompat
        /* renamed from: IntrinsicsJvm.kt_3 */
        protected boolean mo7797c() {
            return this.f8514h || super.mo7797c();
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            return (this.f8513g && this.f8512f) || super.isInTouchMode();
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            return this.f8513g || super.hasWindowFocus();
        }

        @Override // android.view.View
        public boolean isFocused() {
            return this.f8513g || super.isFocused();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.f8513g || super.hasFocus();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 extends DataSetObserver {
        private COUIBaseListPopupWindow_8() {
        }

        /* synthetic */ COUIBaseListPopupWindow_8(COUIBaseListPopupWindow c1499a, COUIBaseListPopupWindow_2 anonymousClass1) {
            this();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (COUIBaseListPopupWindow.this.m8034d()) {
                COUIBaseListPopupWindow.this.mo8014h();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            COUIBaseListPopupWindow.this.mo6987c();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseListPopupWindow f8529a;

        @Override // java.lang.Runnable
        public void run() {
            this.f8529a.m8043n();
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$COUIBaseListPopupWindow_10 */
    private class COUIBaseListPopupWindow_10 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseListPopupWindow f8533a;

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f8533a.f8486f == null || this.f8533a.f8486f.getCount() <= this.f8533a.f8486f.getChildCount() || this.f8533a.f8486f.getChildCount() > this.f8533a.f8484d) {
                return;
            }
            this.f8533a.f8483c.setInputMethodMode(2);
            this.f8533a.mo8014h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$COUIBaseListPopupWindow_11 */
    public class COUIBaseListPopupWindow_11 implements View.OnTouchListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseListPopupWindow f8532a;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f8532a.f8483c != null && this.f8532a.f8483c.isShowing() && x >= 0 && x < this.f8532a.f8483c.getWidth() && y >= 0 && y < this.f8532a.f8483c.getHeight()) {
                this.f8532a.f8479A.postDelayed(this.f8532a.f8502v, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            this.f8532a.f8479A.removeCallbacks(this.f8532a.f8502v);
            return false;
        }
    }

    /* compiled from: COUIBaseListPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.PlatformImplementations.kt_3$COUIBaseListPopupWindow_12 */
    private class COUIBaseListPopupWindow_12 implements AbsListView.OnScrollListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseListPopupWindow f8531a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int OplusGLSurfaceView_13, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (OplusGLSurfaceView_13 != 1 || this.f8531a.m8044o() || this.f8531a.f8483c.getContentView() == null) {
                return;
            }
            this.f8531a.f8479A.removeCallbacks(this.f8531a.f8502v);
            this.f8531a.f8502v.run();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8024a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f8478a;
        if (method != null) {
            try {
                method.invoke(this.f8483c, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.OplusGLSurfaceView_13("BaseListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}
