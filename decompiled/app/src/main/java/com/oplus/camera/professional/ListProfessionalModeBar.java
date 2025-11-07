package com.oplus.camera.professional;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ListProfessionalModeBar extends LinearLayout implements PanelContainer.IntrinsicsJvm.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    static final /* synthetic */ boolean f15371a = !ListProfessionalModeBar.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ListModeBarAdapter f15372b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f15373c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f15374d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15375e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15376f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f15377g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f15378h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Rect f15379i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Activity f15380j;

    /* renamed from: OplusGLSurfaceView_5 */
    private OnItemClickListener f15381k;

    /* renamed from: OplusGLSurfaceView_14 */
    private CameraUIInterface f15382l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15383m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ModePressState f15384n;

    /* renamed from: o */
    private PanelInterface f15385o;

    /* renamed from: p */
    private int f15386p;

    /* renamed from: q */
    private BaseScreenMode f15387q;

    public enum ModePressState {
        NO_PRESSED,
        ISO_PRESSED,
        SHUTTER_PRESSED,
        WB_PRESSED,
        AF_PRESSED,
        EV_PRESSED
    }

    public interface OnItemClickListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15392a(View view, View view2, long OplusGLSurfaceView_15);
    }

    public ListProfessionalModeBar(Activity activity, int OplusGLSurfaceView_13) {
        super(activity);
        this.f15372b = null;
        this.f15373c = 0;
        this.f15374d = -1;
        this.f15375e = 0;
        this.f15376f = 0;
        this.f15377g = 0;
        this.f15378h = null;
        this.f15379i = null;
        this.f15380j = null;
        this.f15381k = null;
        this.f15382l = null;
        this.f15383m = false;
        this.f15384n = ModePressState.NO_PRESSED;
        this.f15385o = null;
        this.f15386p = 0;
        this.f15387q = null;
        this.f15380j = activity;
        this.f15373c = OplusGLSurfaceView_13;
        setGravity(17);
        setOrientation(0);
        setClipChildren(false);
    }

    public ListProfessionalModeBar(Activity activity, int OplusGLSurfaceView_13, int i2) {
        super(activity);
        this.f15372b = null;
        this.f15373c = 0;
        this.f15374d = -1;
        this.f15375e = 0;
        this.f15376f = 0;
        this.f15377g = 0;
        this.f15378h = null;
        this.f15379i = null;
        this.f15380j = null;
        this.f15381k = null;
        this.f15382l = null;
        this.f15383m = false;
        this.f15384n = ModePressState.NO_PRESSED;
        this.f15385o = null;
        this.f15386p = 0;
        this.f15387q = null;
        this.f15380j = activity;
        this.f15373c = OplusGLSurfaceView_13;
        setGravity(17);
        setOrientation(i2);
        setClipChildren(false);
    }

    public void setCameraUIInterface(CameraUIInterface cameraUIInterface) {
        this.f15382l = cameraUIInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15374a(int OplusGLSurfaceView_13, int i2, boolean z) {
        View childAt;
        int iM15378a = m15378a(OplusGLSurfaceView_13, i2);
        if (iM15378a == this.f15374d || iM15378a == -1 || this.f15375e <= 0 || iM15378a >= this.f15372b.getCount() || (childAt = getChildAt(iM15378a)) == null) {
            return;
        }
        childAt.setPressed(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15381a() {
        setItemPressed(false);
        this.f15374d = -1;
    }

    public int getSelectedPosition() {
        return this.f15374d;
    }

    public int getSelectedIndex() {
        int OplusGLSurfaceView_13 = this.f15374d;
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getChildCount()) {
            return -1;
        }
        return m15379a(getChildAt(this.f15374d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15379a(View view) {
        if (view == null) {
            return -1;
        }
        return ((Integer) view.getTag(R.id_renamed.professional_parameter_index)).intValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m15380a(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (OplusGLSurfaceView_13 == m15379a(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public ModePressState getModePressState() {
        return this.f15384n;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View childAt2;
        View childAt3;
        View childAt4;
        CameraLog.m12967f("ListProfessionalModeBar", "onTouchEvent, isEnabled: " + isEnabled());
        int actionMasked = motionEvent.getActionMasked();
        if (this.f15378h != null && (1 == actionMasked || 3 == actionMasked)) {
            this.f15372b.m15369a(this.f15378h, false);
            this.f15378h = null;
        }
        if (!isEnabled()) {
            m15374a(this.f15376f, this.f15377g, false);
            return isClickable() || isLongClickable();
        }
        if (motionEvent.getPointerCount() > 1) {
            m15374a(this.f15376f, this.f15377g, false);
            return true;
        }
        if (actionMasked == 0) {
            this.f15376f = (int) motionEvent.getX();
            this.f15377g = (int) motionEvent.getY();
            int iM15378a = m15378a(this.f15376f, this.f15377g);
            if (iM15378a == -1 || this.f15375e <= 0 || iM15378a >= this.f15372b.getCount() || (childAt = getChildAt(iM15378a)) == null || !((RotateView) childAt).f15814a) {
                return false;
            }
            this.f15372b.m15369a(childAt, true);
            this.f15378h = childAt;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (Math.abs(x - this.f15376f) > 10 || Math.abs(y - this.f15377g) > 10) {
                    this.f15383m = true;
                    int iM15378a2 = m15378a(this.f15376f, this.f15377g);
                    if (iM15378a2 == this.f15374d || iM15378a2 == -1 || this.f15375e <= 0 || iM15378a2 >= this.f15372b.getCount() || (childAt3 = getChildAt(iM15378a2)) == null || !((RotateView) childAt3).f15814a) {
                        return true;
                    }
                    childAt3.setPressed(false);
                }
            } else if (actionMasked == 3) {
                if (this.f15383m) {
                    this.f15383m = false;
                }
                int iM15378a3 = m15378a(this.f15376f, this.f15377g);
                if (iM15378a3 != this.f15374d && iM15378a3 != -1 && this.f15375e > 0 && iM15378a3 < this.f15372b.getCount() && (childAt4 = getChildAt(iM15378a3)) != null) {
                    RotateView c2907y = (RotateView) childAt4;
                    if (!c2907y.f15814a) {
                        return true;
                    }
                    if ((c2907y.getChildAt(0) instanceof ImageItem) || (c2907y.getChildAt(0) instanceof MainBarItem)) {
                        childAt4.setPressed(false);
                    }
                }
            } else if (actionMasked != 5) {
            }
        } else if (this.f15383m) {
            this.f15383m = false;
            int iM15378a4 = m15378a(this.f15376f, this.f15377g);
            if (iM15378a4 == this.f15374d || iM15378a4 == -1 || this.f15375e <= 0 || iM15378a4 >= this.f15372b.getCount() || (childAt2 = getChildAt(iM15378a4)) == null || !((RotateView) childAt2).f15814a) {
                return true;
            }
            childAt2.setPressed(false);
        } else if (!m15375b((int) motionEvent.getX(), (int) motionEvent.getY())) {
            m15375b(this.f15376f, this.f15377g);
        }
        return true;
    }

    private void setModePressedState(int OplusGLSurfaceView_13) {
        if (-1 == OplusGLSurfaceView_13) {
            CameraLog.m12967f("ListProfessionalModeBar", "setModePressedState, invalid position");
            return;
        }
        if (this.f15375e > 0 && OplusGLSurfaceView_13 < this.f15372b.getCount()) {
            int iIntValue = ((Integer) getChildAt(OplusGLSurfaceView_13).getTag(R.id_renamed.professional_parameter_index)).intValue();
            if (OplusGLSurfaceView_13 == this.f15374d) {
                this.f15384n = ModePressState.NO_PRESSED;
                return;
            }
            if (iIntValue == 1) {
                this.f15384n = ModePressState.ISO_PRESSED;
                return;
            }
            if (iIntValue == 2) {
                this.f15384n = ModePressState.SHUTTER_PRESSED;
                return;
            }
            if (iIntValue == 3) {
                this.f15384n = ModePressState.EV_PRESSED;
                return;
            }
            if (iIntValue == 4) {
                this.f15384n = ModePressState.AF_PRESSED;
            } else if (iIntValue == 5) {
                this.f15384n = ModePressState.WB_PRESSED;
            } else {
                CameraLog.m12967f("ListProfessionalModeBar", "setModePressedState, default invalid position");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15375b(int OplusGLSurfaceView_13, int i2) {
        int iM15378a = m15378a(OplusGLSurfaceView_13, i2);
        if (iM15378a == -1 || this.f15375e <= 0 || iM15378a >= this.f15372b.getCount()) {
            return false;
        }
        View childAt = getChildAt(iM15378a);
        if (childAt != null) {
            RotateView c2907y = (RotateView) childAt;
            if (!c2907y.f15814a) {
                return true;
            }
            if (m15379a(childAt) != 0) {
                setPressed(false);
            }
            childAt.setPressed(true);
            View childAt2 = c2907y.getChildAt(0);
            if (childAt2 != null && (childAt2 instanceof MainBarItem)) {
                ((MainBarItem) childAt2).m15723a();
            }
        }
        setModePressedState(iM15378a);
        if (m15379a(childAt) != 0) {
            this.f15374d = iM15378a;
        }
        m15387a(childAt, this.f15372b.getItemId(iM15378a));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15378a(int OplusGLSurfaceView_13, int i2) {
        Rect rect = this.f15379i;
        if (rect == null) {
            this.f15379i = new Rect();
            rect = this.f15379i;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!f15371a && childAt == null) {
                throw new AssertionError();
            }
            if (childAt.getVisibility() == 0 && Util.m24295a(childAt, OplusGLSurfaceView_13, i2)) {
                return childCount;
            }
        }
        CameraLog.m12967f("ListProfessionalModeBar", "error frame is " + rect);
        return -1;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return -1 != this.f15374d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15387a(View view, long OplusGLSurfaceView_15) {
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
            this.f15381k.mo15392a(this, view, OplusGLSurfaceView_15);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View m15376c(int OplusGLSurfaceView_13) {
        LinearLayout.LayoutParams layoutParams;
        RotateView c2907y = new RotateView(this.f15380j, this.f15373c);
        if (1 == this.f15386p) {
            layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_item_width), getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_item_height));
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
        }
        c2907y.setGravity(17);
        c2907y.setLayoutParams(layoutParams);
        c2907y.setClipChildren(false);
        MainBarItem c2894l = new MainBarItem(this.f15380j, this.f15387q);
        c2894l.setId(102);
        c2894l.setLayoutParams(layoutParams);
        c2907y.addView(c2894l);
        return c2907y;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15389b() {
        BaseScreenMode abstractC2934a;
        boolean z = true;
        if (!Util.m24495t() ? Util.m24178H() != 2 : (abstractC2934a = this.f15387q) == null || !abstractC2934a.mo16631r() || this.f15387q.mo16630q()) {
            z = false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f15375e; OplusGLSurfaceView_13++) {
            ((MainBarItem) ((RotateView) getChildAt(OplusGLSurfaceView_13)).getChildAt(0)).setLightBackground(z);
        }
    }

    public void setAdapter(ListModeBarAdapter listModeBarAdapter) throws Resources.NotFoundException {
        this.f15372b = listModeBarAdapter;
        this.f15372b.m15372a(new int[]{100, 101, 102});
        this.f15375e = this.f15372b.getCount();
        m15377c();
        requestLayout();
    }

    public void setScreenMode(BaseScreenMode abstractC2934a) {
        this.f15387q = abstractC2934a;
        this.f15386p = abstractC2934a.mo16539j();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15385a(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        setScreenMode(abstractC2934a);
        if (1 == this.f15386p) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        removeAllViews();
        m15377c();
        requestLayout();
        m15389b();
    }

    public ListModeBarAdapter getAdapter() {
        return this.f15372b;
    }

    public int getItemCount() {
        return this.f15375e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15384a(int OplusGLSurfaceView_13, boolean z) {
        this.f15374d = OplusGLSurfaceView_13;
        if (getChildAt(OplusGLSurfaceView_13) != null) {
            getChildAt(OplusGLSurfaceView_13).setPressed(z);
        }
    }

    public void setItemPressed(boolean z) {
        View childAt;
        int OplusGLSurfaceView_13 = this.f15374d;
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
            if (!f15371a && childAt == null) {
                throw new AssertionError();
            }
            childAt.clearAnimation();
        }
        super.removeAllViews();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15377c() throws Resources.NotFoundException {
        int dimensionPixelSize = this.f15380j.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_margin_side);
        int dimensionPixelSize2 = this.f15380j.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_margin_another);
        boolean z = 1 == TextUtilsCompat.m2525a(Locale.getDefault());
        LinearLayout.LayoutParams layoutParams = 1 == this.f15386p ? new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_item_width), getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_item_height)) : null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f15375e; OplusGLSurfaceView_13++) {
            if (1 != this.f15386p) {
                layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                if ((OplusGLSurfaceView_13 == 0 && !z) || (z && OplusGLSurfaceView_13 == this.f15375e - 1)) {
                    layoutParams.leftMargin = dimensionPixelSize;
                } else if ((OplusGLSurfaceView_13 == 0 && z) || (!z && OplusGLSurfaceView_13 == this.f15375e - 1)) {
                    layoutParams.leftMargin = dimensionPixelSize2;
                    layoutParams.rightMargin = dimensionPixelSize;
                } else {
                    layoutParams.leftMargin = dimensionPixelSize2;
                }
            }
            addView(this.f15372b.getView(OplusGLSurfaceView_13, m15376c(OplusGLSurfaceView_13), this), layoutParams);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f15381k = onItemClickListener;
    }

    @Override // com.oplus.camera.professional.PanelContainer.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15383a(int OplusGLSurfaceView_13, String str, boolean z) {
        View viewM15380a = m15380a(OplusGLSurfaceView_13);
        if (viewM15380a != null) {
            this.f15372b.m15368a(viewM15380a, str);
            if (z) {
                if (viewM15380a.isPressed()) {
                    this.f15372b.m15367a(viewM15380a, 0, false);
                    return;
                } else {
                    this.f15372b.m15367a(viewM15380a, 0, true);
                    return;
                }
            }
            this.f15372b.m15367a(viewM15380a, 8, true);
        }
    }

    @Override // com.oplus.camera.professional.PanelContainer.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo15390b(int OplusGLSurfaceView_13, boolean z) {
        View viewM15380a = m15380a(OplusGLSurfaceView_13);
        if (viewM15380a != null) {
            if (z) {
                this.f15372b.m15367a(viewM15380a, 0, true);
            } else {
                this.f15372b.m15367a(viewM15380a, 8, true);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15386a(boolean z, boolean z2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt != null) {
                this.f15372b.m15370a(childAt, z, z2);
            }
        }
    }

    public void setVisibilityWithAnimation(int OplusGLSurfaceView_13) {
        Util.m24270a(this, OplusGLSurfaceView_13, (Animation.AnimationListener) null, 200L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15382a(int OplusGLSurfaceView_13, String str) {
        View viewM15380a = m15380a(OplusGLSurfaceView_13);
        if (viewM15380a != null) {
            this.f15372b.m15368a(viewM15380a, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m15388b(int OplusGLSurfaceView_13) {
        View viewM15380a = m15380a(OplusGLSurfaceView_13);
        ListModeBarAdapter listModeBarAdapter = this.f15372b;
        if (listModeBarAdapter == null || viewM15380a == null) {
            return null;
        }
        return listModeBarAdapter.m15366a(viewM15380a);
    }

    public void setPanelInterface(PanelInterface interfaceC2899q) {
        this.f15385o = interfaceC2899q;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15391b(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        m15381a();
        setAlpha(1.0f);
        CameraUIInterface cameraUIInterface = this.f15382l;
        if (cameraUIInterface != null && !cameraUIInterface.mo18057R()) {
            setVisibility(0);
        }
        m15385a(abstractC2934a);
        if (1 == this.f15386p) {
            setBackgroundColor(0);
        }
    }
}
