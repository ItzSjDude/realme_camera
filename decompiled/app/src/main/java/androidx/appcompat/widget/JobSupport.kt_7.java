package androidx.appcompat.widget;

/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
class av_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f593a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.View f594b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.widget.TextView f595c;
    private final android.view.WindowManager.LayoutParams d_renamed = new android.view.WindowManager.LayoutParams();
    private final android.graphics.Rect e_renamed = new android.graphics.Rect();
    private final int[] f_renamed = new int[2];
    private final int[] g_renamed = new int[2];

    av_renamed(android.content.Context context) {
        this.f593a = context;
        this.f594b = android.view.LayoutInflater.from(this.f593a).inflate(androidx.appcompat.R_renamed.layout.abc_tooltip, (android.view.ViewGroup) null);
        this.f595c = (android.widget.TextView) this.f594b.findViewById(androidx.appcompat.R_renamed.id_renamed.message);
        this.d_renamed.setTitle(getClass().getSimpleName());
        this.d_renamed.packageName = this.f593a.getPackageName();
        android.view.WindowManager.LayoutParams layoutParams = this.d_renamed;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = androidx.appcompat.R_renamed.style.Animation_AppCompat_Tooltip;
        this.d_renamed.flags = 24;
    }

    void a_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed, java.lang.CharSequence charSequence) throws android.content.res.Resources.NotFoundException {
        if (b_renamed()) {
            a_renamed();
        }
        this.f595c.setText(charSequence);
        a_renamed(view, i_renamed, i2, z_renamed, this.d_renamed);
        ((android.view.WindowManager) this.f593a.getSystemService("window")).addView(this.f594b, this.d_renamed);
    }

    void a_renamed() {
        if (b_renamed()) {
            ((android.view.WindowManager) this.f593a.getSystemService("window")).removeView(this.f594b);
        }
    }

    boolean b_renamed() {
        return this.f594b.getParent() != null;
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed, android.view.WindowManager.LayoutParams layoutParams) throws android.content.res.Resources.NotFoundException {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f593a.getResources().getDimensionPixelOffset(androidx.appcompat.R_renamed.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i_renamed = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f593a.getResources().getDimensionPixelOffset(androidx.appcompat.R_renamed.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f593a.getResources().getDimensionPixelOffset(z_renamed ? androidx.appcompat.R_renamed.dimen.tooltip_y_offset_touch : androidx.appcompat.R_renamed.dimen.tooltip_y_offset_non_touch);
        android.view.View viewA = a_renamed(view);
        if (viewA == null) {
            android.util.Log.e_renamed("TooltipPopup", "Cannot find app view");
            return;
        }
        viewA.getWindowVisibleDisplayFrame(this.e_renamed);
        if (this.e_renamed.left < 0 && this.e_renamed.top < 0) {
            android.content.res.Resources resources = this.f593a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.e_renamed.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewA.getLocationOnScreen(this.g_renamed);
        view.getLocationOnScreen(this.f_renamed);
        int[] iArr = this.f_renamed;
        int i4 = iArr[0];
        int[] iArr2 = this.g_renamed;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x_renamed = (iArr[0] + i_renamed) - (viewA.getWidth() / 2);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f594b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f594b.getMeasuredHeight();
        int[] iArr3 = this.f_renamed;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z_renamed) {
            if (i5 >= 0) {
                layoutParams.y_renamed = i5;
                return;
            } else {
                layoutParams.y_renamed = i6;
                return;
            }
        }
        if (measuredHeight + i6 <= this.e_renamed.height()) {
            layoutParams.y_renamed = i6;
        } else {
            layoutParams.y_renamed = i5;
        }
    }

    private static android.view.View a_renamed(android.view.View view) {
        android.view.View rootView = view.getRootView();
        android.view.ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof android.view.WindowManager.LayoutParams) && ((android.view.WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (android.content.Context context = view.getContext(); context instanceof android.content.ContextWrapper; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof android.app.Activity) {
                return ((android.app.Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
