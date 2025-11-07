package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* compiled from: TooltipPopup.java */
/* renamed from: androidx.appcompat.widget.av */
/* loaded from: classes.dex */
class TooltipPopup {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f1912a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final View f1913b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final TextView f1914c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final WindowManager.LayoutParams f1915d = new WindowManager.LayoutParams();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Rect f1916e = new Rect();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int[] f1917f = new int[2];

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int[] f1918g = new int[2];

    TooltipPopup(Context context) {
        this.f1912a = context;
        this.f1913b = LayoutInflater.from(this.f1912a).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1914c = (TextView) this.f1913b.findViewById(R.id_renamed.message);
        this.f1915d.setTitle(getClass().getSimpleName());
        this.f1915d.packageName = this.f1912a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f1915d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f1915d.flags = 24;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1617a(View view, int OplusGLSurfaceView_13, int i2, boolean z, CharSequence charSequence) throws Resources.NotFoundException {
        if (m1618b()) {
            m1616a();
        }
        this.f1914c.setText(charSequence);
        m1615a(view, OplusGLSurfaceView_13, i2, z, this.f1915d);
        ((WindowManager) this.f1912a.getSystemService("window")).addView(this.f1913b, this.f1915d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1616a() {
        if (m1618b()) {
            ((WindowManager) this.f1912a.getSystemService("window")).removeView(this.f1913b);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m1618b() {
        return this.f1913b.getParent() != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1615a(View view, int OplusGLSurfaceView_13, int i2, boolean z, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1912a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            OplusGLSurfaceView_13 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1912a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1912a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View viewM1614a = m1614a(view);
        if (viewM1614a == null) {
            Log.COUIBaseListPopupWindow_8("TooltipPopup", "Cannot find app view");
            return;
        }
        viewM1614a.getWindowVisibleDisplayFrame(this.f1916e);
        if (this.f1916e.left < 0 && this.f1916e.top < 0) {
            Resources resources = this.f1912a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1916e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewM1614a.getLocationOnScreen(this.f1918g);
        view.getLocationOnScreen(this.f1917f);
        int[] iArr = this.f1917f;
        int i4 = iArr[0];
        int[] iArr2 = this.f1918g;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + OplusGLSurfaceView_13) - (viewM1614a.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1913b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1913b.getMeasuredHeight();
        int[] iArr3 = this.f1917f;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
                return;
            } else {
                layoutParams.y = i6;
                return;
            }
        }
        if (measuredHeight + i6 <= this.f1916e.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static View m1614a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
