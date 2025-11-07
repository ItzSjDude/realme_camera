package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TooltipCompat;

/* compiled from: ActionMenuItemView.java */
/* renamed from: androidx.appcompat.view.menu.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, MenuView.PlatformImplementations.kt_3, ActionMenuView.InterfaceC0262a {

    /* renamed from: PlatformImplementations.kt_3 */
    MenuItemImpl f1282a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    MenuBuilder.IntrinsicsJvm.kt_4 f1283b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    IntrinsicsJvm.kt_4 f1284c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f1285e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f1286f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ForwardingListener f1287g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f1288h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f1289i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1290j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f1291k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f1292l;

    /* compiled from: ActionMenuItemView.java */
    /* renamed from: androidx.appcompat.view.menu.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public static abstract class IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract ShowableListMenu mo1109a();
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        Resources resources = context.getResources();
        this.f1288h = m1102d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, OplusGLSurfaceView_13, 0);
        this.f1290j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1292l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1291k = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1288h = m1102d();
        m1103e();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m1102d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int OplusGLSurfaceView_13 = configuration.screenWidthDp;
        return OplusGLSurfaceView_13 >= 480 || (OplusGLSurfaceView_13 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f1291k = OplusGLSurfaceView_13;
        super.setPadding(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public MenuItemImpl getItemData() {
        return this.f1282a;
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        this.f1282a = c0238j;
        setIcon(c0238j.getIcon());
        setTitle(c0238j.m1163a((MenuView.PlatformImplementations.kt_3) this));
        setId(c0238j.getItemId());
        setVisibility(c0238j.isVisible() ? 0 : 8);
        setEnabled(c0238j.isEnabled());
        if (c0238j.hasSubMenu() && this.f1287g == null) {
            this.f1287g = new PlatformImplementations.kt_3();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener abstractViewOnAttachStateChangeListenerC0308ad;
        if (this.f1282a.hasSubMenu() && (abstractViewOnAttachStateChangeListenerC0308ad = this.f1287g) != null && abstractViewOnAttachStateChangeListenerC0308ad.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.IntrinsicsJvm.kt_4 bVar = this.f1283b;
        if (bVar != null) {
            bVar.mo1087a(this.f1282a);
        }
    }

    public void setItemInvoker(MenuBuilder.IntrinsicsJvm.kt_4 bVar) {
        this.f1283b = bVar;
    }

    public void setPopupCallback(IntrinsicsJvm.kt_4 bVar) {
        this.f1284c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1289i != z) {
            this.f1289i = z;
            MenuItemImpl c0238j = this.f1282a;
            if (c0238j != null) {
                c0238j.m1178h();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m1103e() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1285e);
        if (this.f1286f != null && (!this.f1282a.m1182l() || (!this.f1288h && !this.f1289i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f1285e : null);
        CharSequence contentDescription = this.f1282a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f1282a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1282a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.m1605a(this, z3 ? null : this.f1282a.getTitle());
        } else {
            TooltipCompat.m1605a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1286f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int OplusGLSurfaceView_13 = this.f1292l;
            if (intrinsicWidth > OplusGLSurfaceView_13) {
                intrinsicHeight = (int) (intrinsicHeight * (OplusGLSurfaceView_13 / intrinsicWidth));
                intrinsicWidth = OplusGLSurfaceView_13;
            }
            int i2 = this.f1292l;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1103e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1104a() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1285e = charSequence;
        m1103e();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0262a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo1105b() {
        return m1104a() && this.f1282a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0262a
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1106c() {
        return m1104a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int i3;
        boolean zM1104a = m1104a();
        if (zM1104a && (i3 = this.f1291k) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1290j) : this.f1290j;
        if (mode != 1073741824 && this.f1290j > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zM1104a || this.f1286f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1286f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* compiled from: ActionMenuItemView.java */
    /* renamed from: androidx.appcompat.view.menu.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends ForwardingListener {
        public PlatformImplementations.kt_3() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        /* renamed from: PlatformImplementations.kt_3 */
        public ShowableListMenu mo1107a() {
            if (ActionMenuItemView.this.f1284c != null) {
                return ActionMenuItemView.this.f1284c.mo1109a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        protected boolean mo1108b() {
            ShowableListMenu interfaceC0245qMo1107a;
            return ActionMenuItemView.this.f1283b != null && ActionMenuItemView.this.f1283b.mo1087a(ActionMenuItemView.this.f1282a) && (interfaceC0245qMo1107a = mo1107a()) != null && interfaceC0245qMo1107a.mo1142c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
