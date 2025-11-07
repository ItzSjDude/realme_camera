package com.coui.appcompat.widget.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.PointerIconCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import com.coui.appcompat.widget.COUIHintRedDot;

/* compiled from: COUINavigationItemView.java */
/* renamed from: com.coui.appcompat.widget.navigation.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUINavigationItemView extends FrameLayout implements MenuView.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Interpolator f8385a = PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int[] f8386b = {R.attr.state_checked};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float f8387c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final float f8388d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float f8389e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final float f8390f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private TextView f8391g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8392h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ImageView f8393i;

    /* renamed from: OplusGLSurfaceView_15 */
    private MenuItemImpl f8394j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ColorStateList f8395k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ColorStateList f8396l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8397m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8398n;

    /* renamed from: o */
    private COUIHintRedDot f8399o;

    /* renamed from: p */
    private ScaleAnimation f8400p;

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public boolean prefersCondensedTitle() {
        return false;
    }

    public COUINavigationItemView(Context context, int OplusGLSurfaceView_13) {
        super(context, null, 0);
        this.f8387c = 0.0f;
        this.f8388d = 1.0f;
        this.f8389e = 0.3f;
        this.f8390f = 0.5f;
        this.f8392h = -1;
        this.f8398n = OplusGLSurfaceView_13;
        m7967a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        removeAllViews();
        m7967a();
        initialize(this.f8394j, 0);
        this.f8391g.setTextColor(this.f8396l);
        this.f8391g.setTextSize(0, this.f8397m);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7967a() {
        int OplusGLSurfaceView_13 = coui.support.appcompat.R.layout.coui_navigation_item_layout;
        if (this.f8398n != 0) {
            OplusGLSurfaceView_13 = coui.support.appcompat.R.layout.coui_navigation_item_default_layout;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(OplusGLSurfaceView_13, (ViewGroup) this, true);
        this.f8393i = (ImageView) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.icon);
        this.f8391g = (TextView) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.normalLable);
        this.f8399o = (COUIHintRedDot) viewInflate.findViewById(coui.support.appcompat.R.id_renamed.tips);
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        this.f8394j = c0238j;
        setCheckable(c0238j.isCheckable());
        setChecked(c0238j.isChecked());
        setEnabled(c0238j.isEnabled());
        setIcon(c0238j.getIcon());
        setTitle(c0238j.getTitle());
        setId(c0238j.getItemId());
        if (Build.VERSION.SDK_INT >= 26) {
            setContentDescription(c0238j.getContentDescription());
            TooltipCompat.m1605a(this, c0238j.getTooltipText());
        }
    }

    public void setItemPosition(int OplusGLSurfaceView_13) {
        this.f8392h = OplusGLSurfaceView_13;
    }

    public int getItemPosition() {
        return this.f8392h;
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public MenuItemImpl getItemData() {
        return this.f8394j;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null || charSequence.toString().isEmpty()) {
            this.f8391g.setVisibility(8);
        } else {
            this.f8391g.setVisibility(0);
            this.f8391g.setText(charSequence);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f8393i.setSelected(z);
        this.f8391g.setSelected(z);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f8391g.isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction(16);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f8393i.setEnabled(z);
        this.f8391g.setEnabled(z);
        if (z) {
            ViewCompat.m2856a(this, PointerIconCompat.m2821a(getContext(), 1002));
        } else {
            ViewCompat.m2856a(this, (PointerIconCompat) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        MenuItemImpl c0238j = this.f8394j;
        if (c0238j != null && c0238j.isCheckable() && this.f8394j.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f8386b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int left;
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        if (m7968a(getContext())) {
            left = this.f8393i.getLeft() - (this.f8399o.getWidth() / 2);
        } else {
            left = (this.f8393i.getLeft() - (this.f8399o.getWidth() / 2)) + this.f8393i.getWidth();
        }
        int top = this.f8393i.getTop() - (this.f8399o.getHeight() / 2);
        COUIHintRedDot cOUIHintRedDot = this.f8399o;
        cOUIHintRedDot.layout(left, top, cOUIHintRedDot.getWidth() + left, this.f8399o.getHeight() + top);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            this.f8393i.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 21 ? drawable instanceof StateListDrawable : false) {
                int[] iArr = new int[1];
                iArr[0] = (this.f8394j.isChecked() ? 1 : -1) * R.attr.state_checked;
                this.f8393i.setImageState(iArr, true);
            }
        } else {
            this.f8393i.setVisibility(8);
            this.f8391g.setMaxLines(2);
        }
        this.f8393i.setImageDrawable(drawable);
    }

    @Deprecated
    public void setIconTintList(ColorStateList colorStateList) {
        this.f8395k = colorStateList;
        MenuItemImpl c0238j = this.f8394j;
        if (c0238j != null) {
            setIcon(c0238j.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.f8396l = colorStateList;
        this.f8391g.setTextColor(colorStateList);
    }

    public void setItemLayoutType(int OplusGLSurfaceView_13) {
        this.f8398n = OplusGLSurfaceView_13;
        removeAllViews();
        m7967a();
        initialize(this.f8394j, 0);
        this.f8391g.setTextColor(this.f8396l);
        this.f8391g.setTextSize(0, this.f8397m);
    }

    public void setTextSize(int OplusGLSurfaceView_13) {
        this.f8397m = OplusGLSurfaceView_13;
        this.f8391g.setTextSize(0, OplusGLSurfaceView_13);
    }

    public void setItemBackground(int OplusGLSurfaceView_13) {
        ViewCompat.m2850a(this, OplusGLSurfaceView_13 == 0 ? null : ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    public void setMaxTextWidth(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        this.f8391g.setMaxWidth(OplusGLSurfaceView_13);
    }

    public TextView getTextView() {
        return this.f8391g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7970a(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 0) {
            return;
        }
        if (i2 == 3) {
            if (this.f8399o.getVisibility() == 8) {
                return;
            }
            if (this.f8400p == null) {
                m7969b();
            }
            this.f8399o.startAnimation(this.f8400p);
            return;
        }
        if (i2 == 1) {
            this.f8399o.setPointMode(1);
            this.f8399o.setVisibility(0);
        } else if (i2 == 2) {
            this.f8399o.setPointNumber(OplusGLSurfaceView_13);
            this.f8399o.setPointMode(2);
            this.f8399o.setVisibility(0);
        }
    }

    public void setIcon(ImageView imageView) {
        this.f8393i = imageView;
    }

    public ImageView getIcon() {
        return this.f8393i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7969b() {
        this.f8400p = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f8400p.setDuration(400L);
        if (Build.VERSION.SDK_INT > 21) {
            this.f8400p.setInterpolator(PathInterpolatorCompat_2.m2772a(1.0f, 0.4f, 0.0f, 0.0f));
        }
        this.f8400p.setAnimationListener(new Animation.AnimationListener() { // from class: com.coui.appcompat.widget.navigation.PlatformImplementations.kt_3.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                COUINavigationItemView.this.f8399o.setVisibility(8);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7968a(Context context) {
        return context != null && Build.VERSION.SDK_INT > 16 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }
}
