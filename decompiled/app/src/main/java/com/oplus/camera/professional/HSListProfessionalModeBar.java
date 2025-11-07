package com.oplus.camera.professional;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.professional.HSPanelContainer;
import java.util.Locale;

/* compiled from: HSListProfessionalModeBar.java */
/* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class HSListProfessionalModeBar extends LinearLayout implements HSPanelContainer.IntrinsicsJvm.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    static final /* synthetic */ boolean f15430a = !HSListProfessionalModeBar.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HSListModeBarAdapter f15431b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f15432c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f15433d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15434e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15435f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f15436g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f15437h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Rect f15438i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Activity f15439j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_4 f15440k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15441l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f15442m;

    /* renamed from: OplusGLSurfaceView_11 */
    private PanelInterface f15443n;

    /* compiled from: HSListProfessionalModeBar.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        NO_PRESSED,
        ISO_PRESSED,
        SHUTTER_PRESSED,
        WB_PRESSED,
        AF_PRESSED,
        EV_PRESSED
    }

    /* compiled from: HSListProfessionalModeBar.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15440a(View view, View view2, long OplusGLSurfaceView_15);
    }

    public HSListProfessionalModeBar(Activity activity, int OplusGLSurfaceView_13) {
        super(activity);
        this.f15431b = null;
        this.f15432c = 0;
        this.f15433d = -1;
        this.f15434e = 0;
        this.f15435f = 0;
        this.f15436g = 0;
        this.f15437h = null;
        this.f15438i = null;
        this.f15439j = null;
        this.f15440k = null;
        this.f15441l = false;
        this.f15442m = PlatformImplementations.kt_3.NO_PRESSED;
        this.f15443n = null;
        this.f15439j = activity;
        this.f15432c = OplusGLSurfaceView_13;
        setGravity(17);
        setOrientation(0);
        setClipChildren(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15426a(int OplusGLSurfaceView_13, int i2, boolean z) {
        View childAt;
        int iM15429a = m15429a(OplusGLSurfaceView_13, i2);
        if (iM15429a == this.f15433d || iM15429a == -1 || this.f15434e <= 0 || iM15429a >= this.f15431b.getCount() || (childAt = getChildAt(iM15429a)) == null) {
            return;
        }
        childAt.setPressed(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15432a() {
        setItemPressed(false);
        this.f15433d = -1;
    }

    public int getSelectedPosition() {
        return this.f15433d;
    }

    public int getSelectedIndex() {
        int OplusGLSurfaceView_13 = this.f15433d;
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getChildCount()) {
            return -1;
        }
        return m15430a(getChildAt(this.f15433d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15430a(View view) {
        if (view == null) {
            return -1;
        }
        return ((Integer) view.getTag(R.id_renamed.professional_parameter_index)).intValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m15431a(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (OplusGLSurfaceView_13 == m15430a(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public PlatformImplementations.kt_3 getModePressState() {
        return this.f15442m;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View childAt2;
        View childAt3;
        View childAt4;
        CameraLog.m12967f("HSListProfessionalModeBar", "onTouchEvent, isEnabled: " + isEnabled());
        int actionMasked = motionEvent.getActionMasked();
        if (this.f15437h != null && (1 == actionMasked || 3 == actionMasked)) {
            this.f15431b.m15420a(this.f15437h, false);
            this.f15437h = null;
        }
        if (!isEnabled()) {
            m15426a(this.f15435f, this.f15436g, false);
            return isClickable() || isLongClickable();
        }
        if (motionEvent.getPointerCount() > 1) {
            m15426a(this.f15435f, this.f15436g, false);
            return true;
        }
        if (actionMasked == 0) {
            this.f15435f = (int) motionEvent.getX();
            this.f15436g = (int) motionEvent.getY();
            int iM15429a = m15429a(this.f15435f, this.f15436g);
            if (iM15429a == -1 || this.f15434e <= 0 || iM15429a >= this.f15431b.getCount() || (childAt = getChildAt(iM15429a)) == null || !((RotateView) childAt).f15814a) {
                return false;
            }
            this.f15431b.m15420a(childAt, true);
            this.f15437h = childAt;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (Math.abs(x - this.f15435f) > 10 || Math.abs(y - this.f15436g) > 10) {
                    this.f15441l = true;
                    int iM15429a2 = m15429a(this.f15435f, this.f15436g);
                    if (iM15429a2 == this.f15433d || iM15429a2 == -1 || this.f15434e <= 0 || iM15429a2 >= this.f15431b.getCount() || (childAt3 = getChildAt(iM15429a2)) == null || !((RotateView) childAt3).f15814a) {
                        return true;
                    }
                    childAt3.setPressed(false);
                }
            } else if (actionMasked == 3) {
                if (this.f15441l) {
                    this.f15441l = false;
                }
                int iM15429a3 = m15429a(this.f15435f, this.f15436g);
                if (iM15429a3 != this.f15433d && iM15429a3 != -1 && this.f15434e > 0 && iM15429a3 < this.f15431b.getCount() && (childAt4 = getChildAt(iM15429a3)) != null) {
                    RotateView c2907y = (RotateView) childAt4;
                    if (!c2907y.f15814a) {
                        return true;
                    }
                    if ((c2907y.getChildAt(0) instanceof ImageItem) || (c2907y.getChildAt(0) instanceof HSMainBarItem)) {
                        childAt4.setPressed(false);
                    }
                }
            } else if (actionMasked != 5) {
            }
        } else if (this.f15441l) {
            this.f15441l = false;
            int iM15429a4 = m15429a(this.f15435f, this.f15436g);
            if (iM15429a4 == this.f15433d || iM15429a4 == -1 || this.f15434e <= 0 || iM15429a4 >= this.f15431b.getCount() || (childAt2 = getChildAt(iM15429a4)) == null || !((RotateView) childAt2).f15814a) {
                return true;
            }
            childAt2.setPressed(false);
        } else if (!m15428b((int) motionEvent.getX(), (int) motionEvent.getY())) {
            m15428b(this.f15435f, this.f15436g);
        }
        return true;
    }

    private void setModePressedState(int OplusGLSurfaceView_13) {
        if (-1 == OplusGLSurfaceView_13) {
            CameraLog.m12967f("HSListProfessionalModeBar", "setModePressedState, invalid position");
            return;
        }
        if (this.f15434e > 0 && OplusGLSurfaceView_13 < this.f15431b.getCount()) {
            int iIntValue = ((Integer) getChildAt(OplusGLSurfaceView_13).getTag(R.id_renamed.professional_parameter_index)).intValue();
            if (OplusGLSurfaceView_13 == this.f15433d) {
                this.f15442m = PlatformImplementations.kt_3.NO_PRESSED;
                return;
            }
            if (iIntValue == 1) {
                this.f15442m = PlatformImplementations.kt_3.ISO_PRESSED;
                return;
            }
            if (iIntValue == 2) {
                this.f15442m = PlatformImplementations.kt_3.SHUTTER_PRESSED;
                return;
            }
            if (iIntValue == 3) {
                this.f15442m = PlatformImplementations.kt_3.EV_PRESSED;
                return;
            }
            if (iIntValue == 4) {
                this.f15442m = PlatformImplementations.kt_3.AF_PRESSED;
            } else if (iIntValue == 5) {
                this.f15442m = PlatformImplementations.kt_3.WB_PRESSED;
            } else {
                CameraLog.m12967f("HSListProfessionalModeBar", "setModePressedState, default invalid position");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15428b(int OplusGLSurfaceView_13, int i2) {
        int iM15429a = m15429a(OplusGLSurfaceView_13, i2);
        if (iM15429a == -1 || this.f15434e <= 0 || iM15429a >= this.f15431b.getCount()) {
            return false;
        }
        View childAt = getChildAt(iM15429a);
        if (childAt != null) {
            RotateView c2907y = (RotateView) childAt;
            if (!c2907y.f15814a) {
                return true;
            }
            if (m15430a(childAt) != 0) {
                setPressed(false);
            }
            childAt.setPressed(true);
            View childAt2 = c2907y.getChildAt(0);
            if (childAt2 != null && (childAt2 instanceof HSMainBarItem)) {
                ((HSMainBarItem) childAt2).m15444a();
            }
        }
        setModePressedState(iM15429a);
        if (m15430a(childAt) != 0) {
            this.f15433d = iM15429a;
        }
        m15437a(childAt, this.f15431b.getItemId(iM15429a));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15429a(int OplusGLSurfaceView_13, int i2) {
        Rect rect = this.f15438i;
        if (rect == null) {
            this.f15438i = new Rect();
            rect = this.f15438i;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!f15430a && childAt == null) {
                throw new AssertionError();
            }
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(OplusGLSurfaceView_13, i2)) {
                    return childCount;
                }
            }
        }
        CameraLog.m12967f("HSListProfessionalModeBar", "error frame is " + rect);
        return -1;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return -1 != this.f15433d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15437a(View view, long OplusGLSurfaceView_15) {
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
            this.f15440k.mo15440a(this, view, OplusGLSurfaceView_15);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m15425a(int OplusGLSurfaceView_13, Boolean bool) {
        HSMainBarItem c2888f;
        RotateView c2907y = new RotateView(this.f15439j, this.f15432c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        c2907y.setGravity(17);
        c2907y.setLayoutParams(layoutParams);
        c2907y.setClipChildren(false);
        if (bool.booleanValue()) {
            c2888f = new HSMainBarItem(this.f15439j, true);
        } else {
            c2888f = new HSMainBarItem(this.f15439j, false);
        }
        c2888f.setId(102);
        c2888f.setLayoutParams(layoutParams);
        c2907y.addView(c2888f);
        return c2907y;
    }

    public void setAdapter(HSListModeBarAdapter c2886d) throws Resources.NotFoundException {
        this.f15431b = c2886d;
        this.f15431b.m15423a(new int[]{100, 101, 102});
        this.f15434e = this.f15431b.getCount();
        m15427b();
        requestLayout();
    }

    public HSListModeBarAdapter getAdapter() {
        return this.f15431b;
    }

    public int getItemCount() {
        return this.f15434e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15435a(int OplusGLSurfaceView_13, boolean z) {
        this.f15433d = OplusGLSurfaceView_13;
        if (getChildAt(OplusGLSurfaceView_13) != null) {
            getChildAt(OplusGLSurfaceView_13).setPressed(z);
        }
    }

    public void setItemPressed(boolean z) {
        View childAt;
        int OplusGLSurfaceView_13 = this.f15433d;
        if (-1 == OplusGLSurfaceView_13 || (childAt = getChildAt(OplusGLSurfaceView_13)) == null) {
            return;
        }
        childAt.setPressed(z);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (!f15430a && childAt == null) {
                throw new AssertionError();
            }
            childAt.clearAnimation();
        }
        super.removeAllViews();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15427b() throws Resources.NotFoundException {
        View view;
        int dimensionPixelSize = this.f15439j.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_margin_side);
        int dimensionPixelSize2 = this.f15439j.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_margin_another);
        boolean z = 1 == TextUtilsCompat.m2525a(Locale.getDefault());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f15434e; OplusGLSurfaceView_13++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            if ((OplusGLSurfaceView_13 == 0 && !z) || (z && OplusGLSurfaceView_13 == this.f15434e - 1)) {
                layoutParams.leftMargin = dimensionPixelSize;
            } else if ((OplusGLSurfaceView_13 == 0 && z) || (!z && OplusGLSurfaceView_13 == this.f15434e - 1)) {
                layoutParams.leftMargin = dimensionPixelSize2;
                layoutParams.rightMargin = dimensionPixelSize;
            } else {
                layoutParams.leftMargin = dimensionPixelSize2;
            }
            if (OplusGLSurfaceView_13 == 0) {
                view = this.f15431b.getView(OplusGLSurfaceView_13, m15425a(OplusGLSurfaceView_13, (Boolean) true), this);
            } else {
                view = this.f15431b.getView(OplusGLSurfaceView_13, m15425a(OplusGLSurfaceView_13, (Boolean) false), this);
            }
            addView(view, layoutParams);
        }
    }

    public void setOnItemClickListener(IntrinsicsJvm.kt_4 bVar) {
        this.f15440k = bVar;
    }

    @Override // com.oplus.camera.professional.HSPanelContainer.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15434a(int OplusGLSurfaceView_13, String str, boolean z) {
        View viewM15431a = m15431a(OplusGLSurfaceView_13);
        if (viewM15431a != null) {
            this.f15431b.m15419a(viewM15431a, str);
            if (z) {
                if (viewM15431a.isPressed()) {
                    this.f15431b.m15418a(viewM15431a, 0, false);
                    return;
                } else {
                    this.f15431b.m15418a(viewM15431a, 0, true);
                    return;
                }
            }
            this.f15431b.m15418a(viewM15431a, 8, true);
        }
    }

    @Override // com.oplus.camera.professional.HSPanelContainer.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo15439b(int OplusGLSurfaceView_13, boolean z) {
        View viewM15431a = m15431a(OplusGLSurfaceView_13);
        if (viewM15431a != null) {
            if (z) {
                this.f15431b.m15418a(viewM15431a, 0, true);
            } else {
                this.f15431b.m15418a(viewM15431a, 8, true);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15436a(boolean z, boolean z2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt != null) {
                this.f15431b.m15421a(childAt, z, z2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15433a(int OplusGLSurfaceView_13, String str) {
        View viewM15431a = m15431a(OplusGLSurfaceView_13);
        if (viewM15431a != null) {
            this.f15431b.m15419a(viewM15431a, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m15438b(int OplusGLSurfaceView_13) {
        View viewM15431a = m15431a(OplusGLSurfaceView_13);
        HSListModeBarAdapter c2886d = this.f15431b;
        if (c2886d == null || viewM15431a == null) {
            return null;
        }
        return c2886d.m15417a(viewM15431a);
    }

    public void setPanelInterface(PanelInterface interfaceC2899q) {
        this.f15443n = interfaceC2899q;
    }
}
