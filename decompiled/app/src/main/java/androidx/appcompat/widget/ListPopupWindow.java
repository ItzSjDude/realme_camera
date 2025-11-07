package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
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
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.p036h.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* renamed from: androidx.appcompat.widget.ae */
/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f1747a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Method f1748b;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Method f1749h;

    /* renamed from: A */
    private Drawable f1750A;

    /* renamed from: B */
    private AdapterView.OnItemClickListener f1751B;

    /* renamed from: C */
    private AdapterView.OnItemSelectedListener f1752C;

    /* renamed from: D */
    private final IntrinsicsJvm.kt_5 f1753D;

    /* renamed from: E */
    private final IntrinsicsJvm.kt_3 f1754E;

    /* renamed from: F */
    private final PlatformImplementations.kt_3 f1755F;

    /* renamed from: G */
    private Runnable f1756G;

    /* renamed from: H */
    private final Rect f1757H;

    /* renamed from: I */
    private Rect f1758I;

    /* renamed from: J */
    private boolean f1759J;

    /* renamed from: IntrinsicsJvm.kt_3 */
    DropDownListView f1760c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f1761d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final COUIBaseListPopupWindow_8 f1762e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final Handler f1763f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    PopupWindow f1764g;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f1765i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ListAdapter f1766j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f1767k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f1768l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f1769m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f1770n;

    /* renamed from: o */
    private int f1771o;

    /* renamed from: p */
    private boolean f1772p;

    /* renamed from: q */
    private boolean f1773q;

    /* renamed from: r */
    private boolean f1774r;

    /* renamed from: s */
    private boolean f1775s;

    /* renamed from: t */
    private int f1776t;

    /* renamed from: u */
    private boolean f1777u;

    /* renamed from: v */
    private boolean f1778v;

    /* renamed from: w */
    private View f1779w;

    /* renamed from: x */
    private int f1780x;

    /* renamed from: y */
    private DataSetObserver f1781y;

    /* renamed from: z */
    private View f1782z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1747a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.OplusGLSurfaceView_13("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f1749h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.OplusGLSurfaceView_13("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f1748b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.OplusGLSurfaceView_13("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        this.f1767k = -2;
        this.f1768l = -2;
        this.f1771o = 1002;
        this.f1773q = true;
        this.f1776t = 0;
        this.f1777u = false;
        this.f1778v = false;
        this.f1761d = Integer.MAX_VALUE;
        this.f1780x = 0;
        this.f1762e = new COUIBaseListPopupWindow_8();
        this.f1753D = new IntrinsicsJvm.kt_5();
        this.f1754E = new IntrinsicsJvm.kt_3();
        this.f1755F = new PlatformImplementations.kt_3();
        this.f1757H = new Rect();
        this.f1765i = context;
        this.f1763f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, OplusGLSurfaceView_13, i2);
        this.f1769m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1770n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1770n != 0) {
            this.f1772p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f1764g = new AppCompatPopupWindow(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f1764g.setInputMethodMode(1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1311a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1781y;
        if (dataSetObserver == null) {
            this.f1781y = new IntrinsicsJvm.kt_4();
        } else {
            ListAdapter listAdapter2 = this.f1766j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1766j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1781y);
        }
        DropDownListView c0306ab = this.f1760c;
        if (c0306ab != null) {
            c0306ab.setAdapter(this.f1766j);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m1435d(int OplusGLSurfaceView_13) {
        this.f1780x = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1430a(boolean z) {
        this.f1759J = z;
        this.f1764g.setFocusable(z);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m1443i() {
        return this.f1759J;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Drawable m1434d() {
        return this.f1764g.getBackground();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1427a(Drawable drawable) {
        this.f1764g.setBackgroundDrawable(drawable);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m1437e(int OplusGLSurfaceView_13) {
        this.f1764g.setAnimationStyle(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public View m1444j() {
        return this.f1782z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1432b(View view) {
        this.f1782z = view;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m1438f() {
        return this.f1769m;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1431b(int OplusGLSurfaceView_13) {
        this.f1769m = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m1436e() {
        if (this.f1772p) {
            return this.f1770n;
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1425a(int OplusGLSurfaceView_13) {
        this.f1770n = OplusGLSurfaceView_13;
        this.f1772p = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1426a(Rect rect) {
        this.f1758I = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m1439f(int OplusGLSurfaceView_13) {
        this.f1776t = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m1446k() {
        return this.f1768l;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m1440g(int OplusGLSurfaceView_13) {
        this.f1768l = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m1441h(int OplusGLSurfaceView_13) {
        Drawable background = this.f1764g.getBackground();
        if (background != null) {
            background.getPadding(this.f1757H);
            this.f1768l = this.f1757H.left + this.f1757H.right + OplusGLSurfaceView_13;
        } else {
            m1440g(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1428a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1751B = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: a_ */
    public void mo1136a_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iM1423h = m1423h();
        boolean zM1448m = m1448m();
        PopupWindowCompat.m3040a(this.f1764g, this.f1771o);
        if (this.f1764g.isShowing()) {
            if (ViewCompat.m2826D(m1444j())) {
                int width = this.f1768l;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = m1444j().getWidth();
                }
                int OplusGLSurfaceView_13 = this.f1767k;
                if (OplusGLSurfaceView_13 == -1) {
                    if (!zM1448m) {
                        iM1423h = -1;
                    }
                    if (zM1448m) {
                        this.f1764g.setWidth(this.f1768l == -1 ? -1 : 0);
                        this.f1764g.setHeight(0);
                    } else {
                        this.f1764g.setWidth(this.f1768l == -1 ? -1 : 0);
                        this.f1764g.setHeight(-1);
                    }
                } else if (OplusGLSurfaceView_13 != -2) {
                    iM1423h = OplusGLSurfaceView_13;
                }
                this.f1764g.setOutsideTouchable((this.f1778v || this.f1777u) ? false : true);
                this.f1764g.update(m1444j(), this.f1769m, this.f1770n, width < 0 ? -1 : width, iM1423h < 0 ? -1 : iM1423h);
                return;
            }
            return;
        }
        int width2 = this.f1768l;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = m1444j().getWidth();
        }
        int i2 = this.f1767k;
        if (i2 == -1) {
            iM1423h = -1;
        } else if (i2 != -2) {
            iM1423h = i2;
        }
        this.f1764g.setWidth(width2);
        this.f1764g.setHeight(iM1423h);
        m1421c(true);
        this.f1764g.setOutsideTouchable((this.f1778v || this.f1777u) ? false : true);
        this.f1764g.setTouchInterceptor(this.f1753D);
        if (this.f1775s) {
            PopupWindowCompat.m3042a(this.f1764g, this.f1774r);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1749h;
            if (method != null) {
                try {
                    method.invoke(this.f1764g, this.f1758I);
                } catch (Exception e2) {
                    Log.COUIBaseListPopupWindow_8("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.f1764g.setEpicenterBounds(this.f1758I);
        }
        PopupWindowCompat.m3041a(this.f1764g, m1444j(), this.f1769m, this.f1770n, this.f1776t);
        this.f1760c.setSelection(-1);
        if (!this.f1759J || this.f1760c.isInTouchMode()) {
            m1447l();
        }
        if (this.f1759J) {
            return;
        }
        this.f1763f.post(this.f1755F);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1137b() {
        this.f1764g.dismiss();
        m1422g();
        this.f1764g.setContentView(null);
        this.f1760c = null;
        this.f1763f.removeCallbacks(this.f1762e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1429a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1764g.setOnDismissListener(onDismissListener);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m1422g() {
        View view = this.f1779w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1779w);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m1442i(int OplusGLSurfaceView_13) {
        this.f1764g.setInputMethodMode(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m1445j(int OplusGLSurfaceView_13) {
        DropDownListView c0306ab = this.f1760c;
        if (!mo1142c() || c0306ab == null) {
            return;
        }
        c0306ab.setListSelectionHidden(false);
        c0306ab.setSelection(OplusGLSurfaceView_13);
        if (c0306ab.getChoiceMode() != 0) {
            c0306ab.setItemChecked(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m1447l() {
        DropDownListView c0306ab = this.f1760c;
        if (c0306ab != null) {
            c0306ab.setListSelectionHidden(true);
            c0306ab.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1142c() {
        return this.f1764g.isShowing();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m1448m() {
        return this.f1764g.getInputMethodMode() == 2;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public Object m1449n() {
        if (mo1142c()) {
            return this.f1760c.getSelectedItem();
        }
        return null;
    }

    /* renamed from: o */
    public int m1450o() {
        if (mo1142c()) {
            return this.f1760c.getSelectedItemPosition();
        }
        return -1;
    }

    /* renamed from: p */
    public long m1451p() {
        if (mo1142c()) {
            return this.f1760c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: q */
    public View m1452q() {
        if (mo1142c()) {
            return this.f1760c.getSelectedView();
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: b_ */
    public ListView mo1140b_() {
        return this.f1760c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    DropDownListView mo1424a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m1423h() {
        int measuredHeight;
        int OplusGLSurfaceView_13;
        int iMakeMeasureSpec;
        int i2;
        if (this.f1760c == null) {
            Context context = this.f1765i;
            this.f1756G = new Runnable() { // from class: androidx.appcompat.widget.ae.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    View viewM1444j = ListPopupWindow.this.m1444j();
                    if (viewM1444j == null || viewM1444j.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.mo1136a_();
                }
            };
            this.f1760c = mo1424a(context, !this.f1759J);
            Drawable drawable = this.f1750A;
            if (drawable != null) {
                this.f1760c.setSelector(drawable);
            }
            this.f1760c.setAdapter(this.f1766j);
            this.f1760c.setOnItemClickListener(this.f1751B);
            this.f1760c.setFocusable(true);
            this.f1760c.setFocusableInTouchMode(true);
            this.f1760c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ae.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long OplusGLSurfaceView_15) {
                    DropDownListView c0306ab;
                    if (i3 == -1 || (c0306ab = ListPopupWindow.this.f1760c) == null) {
                        return;
                    }
                    c0306ab.setListSelectionHidden(false);
                }
            });
            this.f1760c.setOnScrollListener(this.f1754E);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1752C;
            if (onItemSelectedListener != null) {
                this.f1760c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f1760c;
            View view2 = this.f1779w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.f1780x;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i3 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                } else {
                    Log.COUIBaseListPopupWindow_8("ListPopupWindow", "Invalid hint position " + this.f1780x);
                }
                int i4 = this.f1768l;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f1764g.setContentView(view);
        } else {
            View view3 = this.f1779w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f1764g.getBackground();
        if (background != null) {
            background.getPadding(this.f1757H);
            OplusGLSurfaceView_13 = this.f1757H.top + this.f1757H.bottom;
            if (!this.f1772p) {
                this.f1770n = -this.f1757H.top;
            }
        } else {
            this.f1757H.setEmpty();
            OplusGLSurfaceView_13 = 0;
        }
        int iM1420a = m1420a(m1444j(), this.f1770n, this.f1764g.getInputMethodMode() == 2);
        if (this.f1777u || this.f1767k == -1) {
            return iM1420a + OplusGLSurfaceView_13;
        }
        int i5 = this.f1768l;
        if (i5 == -2) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1765i.getResources().getDisplayMetrics().widthPixels - (this.f1757H.left + this.f1757H.right), Integer.MIN_VALUE);
        } else if (i5 == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1765i.getResources().getDisplayMetrics().widthPixels - (this.f1757H.left + this.f1757H.right), 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        int iMo1408a = this.f1760c.mo1408a(iMakeMeasureSpec, 0, -1, iM1420a - measuredHeight, -1);
        if (iMo1408a > 0) {
            measuredHeight += OplusGLSurfaceView_13 + this.f1760c.getPaddingTop() + this.f1760c.getPaddingBottom();
        }
        return iMo1408a + measuredHeight;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1433b(boolean z) {
        this.f1775s = true;
        this.f1774r = z;
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ae$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends DataSetObserver {
        IntrinsicsJvm.kt_4() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (ListPopupWindow.this.mo1142c()) {
                ListPopupWindow.this.mo1136a_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.mo1137b();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ae$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {
        PlatformImplementations.kt_3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m1447l();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ae$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 implements Runnable {
        COUIBaseListPopupWindow_8() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (ListPopupWindow.this.f1760c == null || !ViewCompat.m2826D(ListPopupWindow.this.f1760c) || ListPopupWindow.this.f1760c.getCount() <= ListPopupWindow.this.f1760c.getChildCount() || ListPopupWindow.this.f1760c.getChildCount() > ListPopupWindow.this.f1761d) {
                return;
            }
            ListPopupWindow.this.f1764g.setInputMethodMode(2);
            ListPopupWindow.this.mo1136a_();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ae$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 implements View.OnTouchListener {
        IntrinsicsJvm.kt_5() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f1764g != null && ListPopupWindow.this.f1764g.isShowing() && x >= 0 && x < ListPopupWindow.this.f1764g.getWidth() && y >= 0 && y < ListPopupWindow.this.f1764g.getHeight()) {
                ListPopupWindow.this.f1763f.postDelayed(ListPopupWindow.this.f1762e, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow.this.f1763f.removeCallbacks(ListPopupWindow.this.f1762e);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ae$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int OplusGLSurfaceView_13, int i2, int i3) {
        }

        IntrinsicsJvm.kt_3() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (OplusGLSurfaceView_13 != 1 || ListPopupWindow.this.m1448m() || ListPopupWindow.this.f1764g.getContentView() == null) {
                return;
            }
            ListPopupWindow.this.f1763f.removeCallbacks(ListPopupWindow.this.f1762e);
            ListPopupWindow.this.f1762e.run();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1421c(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1747a;
            if (method != null) {
                try {
                    method.invoke(this.f1764g, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.OplusGLSurfaceView_13("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.f1764g.setIsClippedToScreen(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m1420a(View view, int OplusGLSurfaceView_13, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f1748b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.f1764g, view, Integer.valueOf(OplusGLSurfaceView_13), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.OplusGLSurfaceView_13("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.f1764g.getMaxAvailableHeight(view, OplusGLSurfaceView_13);
        }
        return this.f1764g.getMaxAvailableHeight(view, OplusGLSurfaceView_13, z);
    }
}
