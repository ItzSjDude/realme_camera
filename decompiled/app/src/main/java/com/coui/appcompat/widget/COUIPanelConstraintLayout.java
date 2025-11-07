package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIPanelMultiWindowUtils;
import coui.support.appcompat.R;

/* compiled from: COUIPanelConstraintLayout.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class COUIPanelConstraintLayout extends ConstraintLayout {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f8343g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f8344h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Drawable f8345i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8346j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ConstraintSet f8347k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ImageView f8348l;

    /* renamed from: OplusGLSurfaceView_6 */
    private View f8349m;

    /* renamed from: OplusGLSurfaceView_11 */
    private View f8350n;

    /* renamed from: o */
    private COUIButtonBarLayout f8351o;

    /* renamed from: p */
    private Button f8352p;

    /* renamed from: q */
    private Button f8353q;

    /* renamed from: r */
    private Button f8354r;

    /* renamed from: s */
    private String f8355s;

    /* renamed from: t */
    private String f8356t;

    /* renamed from: u */
    private String f8357u;

    /* renamed from: v */
    private View.OnClickListener f8358v;

    /* renamed from: w */
    private View.OnClickListener f8359w;

    /* renamed from: x */
    private View.OnClickListener f8360x;

    /* renamed from: y */
    private int f8361y;

    /* renamed from: z */
    private ColorStateList f8362z;

    public COUIPanelConstraintLayout(Context context) {
        this(context, null);
    }

    public COUIPanelConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPanelConstraintLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f8344h = true;
        m7951c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7951c() throws Resources.NotFoundException {
        this.f8347k = new ConstraintSet();
        this.f8347k.m2192a(this);
        m7952d();
        this.f8347k.m2195b(this);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f8362z = getContext().getResources().getColorStateList(R.color.coui_bottom_sheet_bottom_btn_text_color, getContext().getTheme());
        } else {
            this.f8361y = COUIContextUtil.m6399a(getContext(), R.attr.couiTintControlNormal, getContext().getResources().getColor(R.color.couiGreenTintControlNormal));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7952d() {
        int dimension = (int) getResources().getDimension(R.dimen.coui_panel_drag_view_width);
        int dimension2 = (int) getResources().getDimension(R.dimen.coui_panel_drag_view_height);
        this.f8345i = AppCompatResources.m732b(getContext(), R.drawable.coui_panel_drag_view);
        this.f8346j = getContext().getResources().getColor(R.color.coui_panel_drag_view_color);
        Drawable drawable = this.f8345i;
        if (drawable != null) {
            drawable.setTint(this.f8346j);
        }
        this.f8348l = new ImageView(getContext());
        this.f8348l.setId(View.generateViewId());
        this.f8348l.setImageDrawable(this.f8345i);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8348l.setForceDarkAllowed(false);
        }
        addView(this.f8348l);
        this.f8347k.m2194b(this.f8348l.getId(), dimension);
        this.f8347k.m2189a(this.f8348l.getId(), dimension2);
        m7949a(this.f8348l.getId(), true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7955b() {
        View view;
        if (TextUtils.isEmpty(this.f8355s) && TextUtils.isEmpty(this.f8356t) && TextUtils.isEmpty(this.f8357u)) {
            return;
        }
        if (this.f8351o == null) {
            this.f8351o = (COUIButtonBarLayout) LayoutInflater.from(getContext()).inflate(R.layout.coui_alert_dialog_button_panel, (ViewGroup) null);
        }
        COUIButtonBarLayout cOUIButtonBarLayout = this.f8351o;
        if (cOUIButtonBarLayout != null) {
            cOUIButtonBarLayout.setVerButDividerVerMargin(getContext().getResources().getDimensionPixelOffset(R.dimen.coui_panel_bottom_bar_padding_top));
            this.f8351o.setVerButVerPadding(getContext().getResources().getDimensionPixelOffset(R.dimen.coui_panel_bottom_button_vertical_padding));
            this.f8351o.setVerPaddingBottom(getContext().getResources().getDimensionPixelOffset(R.dimen.coui_panel_bottom_bar_padding_bottom));
            this.f8351o.setVerButPaddingOffset(0);
            this.f8352p = (Button) this.f8351o.findViewById(android.R.id_renamed.button2);
            this.f8353q = (Button) this.f8351o.findViewById(android.R.id_renamed.button3);
            this.f8354r = (Button) this.f8351o.findViewById(android.R.id_renamed.button1);
            m7950a(this.f8352p, this.f8355s, this.f8358v);
            m7950a(this.f8353q, this.f8356t, this.f8359w);
            m7950a(this.f8354r, this.f8357u, this.f8360x);
            if (this.f8351o.getParent() == null) {
                addView(this.f8351o);
                this.f8347k.m2194b(this.f8351o.getId(), -1);
                this.f8347k.m2189a(this.f8351o.getId(), -2);
                m7949a(this.f8351o.getId(), false);
                m7953e();
                ConstraintSet c0401c = this.f8347k;
                if (c0401c == null || this.f8350n == null || (view = this.f8349m) == null) {
                    return;
                }
                c0401c.m2190a(view.getId(), 4, this.f8350n.getId(), 3);
                this.f8347k.m2195b(this);
                ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) this.f8349m.getLayoutParams();
                c0398a.f2473U = true;
                c0398a.f2453A = 0.0f;
                this.f8349m.setLayoutParams(c0398a);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7953e() {
        if (this.f8351o != null) {
            this.f8350n = new View(getContext());
            COUIDarkModeUtil.m6400a(this.f8350n, false);
            this.f8350n.setId(View.generateViewId());
            if (this.f8344h) {
                this.f8350n.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.coui_panel_divider_background_color)));
            }
            addView(this.f8350n);
            this.f8347k.m2194b(this.f8350n.getId(), -1);
            this.f8347k.m2189a(this.f8350n.getId(), 1);
            this.f8347k.m2190a(this.f8350n.getId(), 6, 0, 6);
            this.f8347k.m2190a(this.f8350n.getId(), 7, 0, 7);
            this.f8347k.m2190a(this.f8350n.getId(), 4, this.f8351o.getId(), 3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7956b(View view) {
        if (view != null) {
            this.f8349m = view;
            if (this.f8349m.getId() == -1) {
                this.f8349m.setId(View.generateViewId());
            }
            addView(this.f8349m);
            this.f8347k.m2194b(this.f8349m.getId(), -1);
            this.f8347k.m2189a(this.f8349m.getId(), -2);
            this.f8347k.m2190a(this.f8349m.getId(), 6, 0, 6);
            this.f8347k.m2190a(this.f8349m.getId(), 7, 0, 7);
            this.f8347k.m2190a(this.f8349m.getId(), 3, this.f8348l.getId(), 4);
            if (this.f8350n != null) {
                this.f8347k.m2190a(this.f8349m.getId(), 4, this.f8350n.getId(), 3);
            } else if (this.f8351o != null) {
                this.f8347k.m2190a(this.f8349m.getId(), 4, this.f8351o.getId(), 3);
            } else {
                this.f8347k.m2190a(this.f8349m.getId(), 4, 0, 4);
            }
            this.f8347k.m2195b(this);
            ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) this.f8349m.getLayoutParams();
            c0398a.f2473U = true;
            c0398a.f2453A = 0.0f;
            this.f8349m.setLayoutParams(c0398a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7949a(int OplusGLSurfaceView_13, boolean z) {
        ConstraintSet c0401c = this.f8347k;
        if (c0401c == null || OplusGLSurfaceView_13 == -1) {
            return;
        }
        c0401c.m2190a(OplusGLSurfaceView_13, 6, 0, 6);
        this.f8347k.m2190a(OplusGLSurfaceView_13, 7, 0, 7);
        if (z) {
            this.f8347k.m2190a(OplusGLSurfaceView_13, 3, 0, 3);
        } else {
            this.f8347k.m2190a(OplusGLSurfaceView_13, 4, 0, 4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7950a(Button button, String str, View.OnClickListener onClickListener) {
        if (button != null) {
            if (TextUtils.isEmpty(str)) {
                button.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            button.setText(str);
            button.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.TD07));
            button.setTypeface(Typeface.create("sans-serif-medium", 0));
            button.setSingleLine(false);
            button.setOnClickListener(onClickListener);
            if (Build.VERSION.SDK_INT >= 23) {
                button.setTextColor(this.f8362z);
            } else {
                button.setTextColor(this.f8361y);
            }
            button.setGravity(17);
            button.setTextAlignment(4);
        }
    }

    public void setDragViewDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f8345i = drawable;
            this.f8348l.setImageDrawable(this.f8345i);
        }
    }

    public void setDragViewDrawableTintColor(int OplusGLSurfaceView_13) {
        Drawable drawable = this.f8345i;
        if (drawable == null || this.f8346j == OplusGLSurfaceView_13) {
            return;
        }
        this.f8346j = OplusGLSurfaceView_13;
        drawable.setTint(this.f8346j);
        this.f8348l.setImageDrawable(this.f8345i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getMaxHeight() {
        return COUIPanelMultiWindowUtils.m6438a(getContext(), (Configuration) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7954a(String str, View.OnClickListener onClickListener) {
        this.f8355s = str;
        this.f8358v = onClickListener;
        m7950a(this.f8352p, this.f8355s, this.f8358v);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7957b(String str, View.OnClickListener onClickListener) {
        this.f8356t = str;
        this.f8359w = onClickListener;
        m7950a(this.f8353q, this.f8356t, this.f8359w);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7958c(String str, View.OnClickListener onClickListener) {
        this.f8357u = str;
        this.f8360x = onClickListener;
        m7950a(this.f8354r, this.f8357u, this.f8360x);
    }

    public void setLayoutAtMaxHeight(boolean z) {
        this.f8343g = z;
    }

    public boolean getLayoutAtMaxHeight() {
        return this.f8343g;
    }

    public void setDividerVisibility(boolean z) {
        this.f8344h = z;
        View view = this.f8350n;
        if (view != null) {
            if (z) {
                view.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.coui_panel_divider_background_color)));
            } else {
                view.setBackground(null);
            }
        }
    }

    public ImageView getDragView() {
        return this.f8348l;
    }

    public View getDivider() {
        return this.f8350n;
    }

    public COUIButtonBarLayout getBtnBarLayout() {
        return this.f8351o;
    }
}
