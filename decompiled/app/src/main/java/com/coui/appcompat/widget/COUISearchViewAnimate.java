package com.coui.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class COUISearchViewAnimate extends LinearLayout implements CollapsibleActionView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f7722a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ImageView f7723b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f7724c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private COUISearchView f7725d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SearchCancelButton f7726e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ImageView f7727f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private LinearLayout f7728g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private volatile C1421a f7729h;

    /* renamed from: OplusGLSurfaceView_13 */
    private AtomicInteger f7730i;

    /* renamed from: OplusGLSurfaceView_15 */
    private List<InterfaceC1423c> f7731j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1422b f7732k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f7733l;

    /* renamed from: OplusGLSurfaceView_6 */
    private MenuItem f7734m;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUIToolbar f7735n;

    /* renamed from: o */
    private boolean f7736o;

    /* renamed from: p */
    private boolean f7737p;

    /* renamed from: q */
    private ImageView f7738q;

    /* renamed from: r */
    private boolean f7739r;

    /* renamed from: s */
    private boolean f7740s;

    /* renamed from: t */
    private int f7741t;

    /* renamed from: com.coui.appcompat.widget.COUISearchViewAnimate$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1422b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7427a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7428b(int OplusGLSurfaceView_13);
    }

    /* renamed from: com.coui.appcompat.widget.COUISearchViewAnimate$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1423c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7429a(int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7411a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1058a() {
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1059b() {
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int OplusGLSurfaceView_13) {
        if (this.f7741t != OplusGLSurfaceView_13) {
            if ((8388615 & OplusGLSurfaceView_13) == 0) {
                OplusGLSurfaceView_13 |= 8388611;
            }
            if ((OplusGLSurfaceView_13 & 112) == 0) {
                OplusGLSurfaceView_13 |= 16;
            }
            this.f7741t = OplusGLSurfaceView_13;
            m7413a(this.f7728g, this.f7741t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7413a(View view, int OplusGLSurfaceView_13) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        Arrays.fill(layoutParams2.getRules(), 0);
        layoutParams2.alignWithParent = true;
        int i2 = OplusGLSurfaceView_13 & 112;
        int i3 = 15;
        if (i2 != 16) {
            if (i2 == 48) {
                i3 = 10;
            } else if (i2 == 80) {
                i3 = 12;
            }
        }
        layoutParams2.addRule(i3);
        view.requestLayout();
    }

    @Override // android.widget.LinearLayout
    public int getGravity() {
        return this.f7741t;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
    }

    public void setOnAnimationListener(InterfaceC1422b interfaceC1422b) {
        this.f7732k = interfaceC1422b;
    }

    public void setIconCanAnimate(boolean z) {
        this.f7737p = z;
    }

    public long getAnimatorDuration() {
        return this.f7733l;
    }

    public COUISearchView getSearchView() {
        return this.f7725d;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.f7723b;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        TextView textView = this.f7724c;
        if (textView != null) {
            textView.setEnabled(z);
        }
        LinearLayout linearLayout = this.f7728g;
        if (linearLayout != null) {
            linearLayout.setEnabled(z);
        }
        COUISearchView cOUISearchView = this.f7725d;
        if (cOUISearchView != null) {
            cOUISearchView.setEnabled(z);
        }
        SearchCancelButton searchCancelButton = this.f7726e;
        if (searchCancelButton != null) {
            searchCancelButton.setEnabled(z);
        }
    }

    public int getSearchState() {
        return this.f7730i.get();
    }

    private void setToolBarChildVisibility(int OplusGLSurfaceView_13) {
        COUIToolbar cOUIToolbar = this.f7735n;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f7735n.getChildAt(i2);
                if (childAt != this) {
                    childAt.setVisibility(OplusGLSurfaceView_13);
                }
            }
        }
    }

    private void setToolBarAlpha(float COUIBaseListPopupWindow_12) {
        COUIToolbar cOUIToolbar = this.f7735n;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = this.f7735n.getChildAt(OplusGLSurfaceView_13);
                if (childAt != this) {
                    childAt.setAlpha(COUIBaseListPopupWindow_12);
                }
            }
        }
    }

    private void setMenuItem(MenuItem menuItem) {
        this.f7734m = menuItem;
        MenuItem menuItem2 = this.f7734m;
        if (menuItem2 != null) {
            COUIToolbar cOUIToolbar = this.f7735n;
            if (menuItem2.getActionView() == this) {
                this.f7734m.setActionView((View) null);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7424a(boolean z) {
        COUISearchView cOUISearchView = this.f7725d;
        if (cOUISearchView == null || cOUISearchView.getSearchAutoComplete() == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (f7722a) {
            Log.IntrinsicsJvm.kt_5("COUISearchViewAnimate", "openSoftInput: " + z);
        }
        if (z) {
            m7419c();
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f7725d.getSearchAutoComplete(), 0);
                return;
            }
            return;
        }
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.f7725d.getSearchAutoComplete().getWindowToken(), 0);
    }

    public boolean getCancelIconAnimating() {
        return this.f7736o;
    }

    public void setInputMethodAnimationEnabled(boolean z) {
        this.f7740s = z;
    }

    public boolean getInputMethodAnimationEnabled() {
        return this.f7740s;
    }

    public void setQueryHint(CharSequence charSequence) {
        TextView textView = this.f7724c;
        if (textView != null) {
            textView.setText(charSequence);
        }
        COUISearchView cOUISearchView = this.f7725d;
        if (cOUISearchView != null) {
            cOUISearchView.setQueryHint(charSequence);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(m7411a(OplusGLSurfaceView_13), i2);
        m7413a(this.f7728g, this.f7741t);
    }

    private C1421a getAnimatorHelper() {
        if (this.f7729h == null) {
            synchronized (this) {
                if (this.f7729h == null) {
                    this.f7729h = new C1421a();
                }
            }
        }
        return this.f7729h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7419c() {
        SearchView.SearchAutoComplete searchAutoComplete;
        COUISearchView cOUISearchView = this.f7725d;
        if (cOUISearchView == null || (searchAutoComplete = cOUISearchView.getSearchAutoComplete()) == null) {
            return;
        }
        searchAutoComplete.setFocusable(true);
        searchAutoComplete.setFocusableInTouchMode(true);
        searchAutoComplete.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7420d() throws NoSuchFieldException {
        COUISearchView cOUISearchView = this.f7725d;
        if (cOUISearchView != null) {
            cOUISearchView.clearFocus();
            this.f7725d.setFocusable(false);
            this.f7725d.onWindowFocusChanged(false);
            SearchView.SearchAutoComplete searchAutoComplete = this.f7725d.getSearchAutoComplete();
            if (searchAutoComplete != null) {
                searchAutoComplete.setFocusable(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7412a(int OplusGLSurfaceView_13, int i2) {
        List<InterfaceC1423c> list = this.f7731j;
        if (list != null) {
            for (InterfaceC1423c interfaceC1423c : list) {
                if (interfaceC1423c != null) {
                    interfaceC1423c.m7429a(OplusGLSurfaceView_13, i2);
                }
            }
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUISearchViewAnimate$PlatformImplementations.kt_3 */
    private class C1421a {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private long f7745b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private volatile AtomicBoolean f7746c = new AtomicBoolean(false);

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Runnable f7747d = new Runnable() { // from class: com.coui.appcompat.widget.COUISearchViewAnimate.PlatformImplementations.kt_3.1
            @Override // java.lang.Runnable
            public void run() throws NoSuchFieldException {
                if (COUISearchViewAnimate.this.f7739r) {
                    COUISearchViewAnimate.this.m7420d();
                    COUISearchViewAnimate.this.m7424a(true);
                }
                COUISearchViewAnimate.this.f7739r = true;
                if (COUISearchViewAnimate.this.f7732k != null) {
                    COUISearchViewAnimate.this.f7732k.m7427a(1);
                }
                COUISearchViewAnimate.this.m7412a(0, 1);
            }
        };

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Runnable f7748e = new Runnable() { // from class: com.coui.appcompat.widget.COUISearchViewAnimate.PlatformImplementations.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.m7419c();
                C1421a.this.f7746c.set(false);
                if (COUISearchViewAnimate.this.f7732k != null) {
                    COUISearchViewAnimate.this.f7732k.m7428b(1);
                }
            }
        };

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Runnable f7749f = new Runnable() { // from class: com.coui.appcompat.widget.COUISearchViewAnimate.PlatformImplementations.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.m7419c();
                COUISearchViewAnimate.this.m7424a(false);
                if (COUISearchViewAnimate.this.f7732k != null) {
                    COUISearchViewAnimate.this.f7732k.m7427a(0);
                }
                COUISearchViewAnimate.this.m7412a(1, 0);
            }
        };

        /* renamed from: COUIBaseListPopupWindow_11 */
        private Runnable f7750g = new Runnable() { // from class: com.coui.appcompat.widget.COUISearchViewAnimate.PlatformImplementations.kt_3.4
            @Override // java.lang.Runnable
            public void run() throws NoSuchFieldException {
                COUISearchViewAnimate.this.m7420d();
                C1421a.this.f7746c.set(false);
                COUISearchViewAnimate.this.f7725d.m1351a((CharSequence) "", false);
                if (COUISearchViewAnimate.this.f7732k != null) {
                    COUISearchViewAnimate.this.f7732k.m7428b(0);
                }
            }
        };

        C1421a() {
            this.f7745b = COUISearchViewAnimate.this.f7733l;
        }
    }

    public void setInputTextColor(int OplusGLSurfaceView_13) {
        this.f7725d.getSearchAutoComplete().setTextColor(OplusGLSurfaceView_13);
    }

    public void setInputHintTextColor(int OplusGLSurfaceView_13) {
        this.f7725d.getSearchAutoComplete().setHintTextColor(OplusGLSurfaceView_13);
    }

    public void setSearchViewIcon(Drawable drawable) {
        this.f7723b.setImageDrawable(drawable);
    }

    public void setHintTextViewHintTextColor(int OplusGLSurfaceView_13) {
        this.f7724c.setHintTextColor(OplusGLSurfaceView_13);
    }

    public void setHintTextViewTextColor(int OplusGLSurfaceView_13) {
        this.f7724c.setTextColor(OplusGLSurfaceView_13);
    }

    public void setSearchViewBackgroundColor(int OplusGLSurfaceView_13) {
        this.f7725d.setBackgroundColor(OplusGLSurfaceView_13);
    }

    public void setHintViewBackground(Drawable drawable) {
        this.f7728g.setBackground(drawable);
    }

    public void setCloseBtnImageDrawable(Drawable drawable) {
        this.f7738q.setImageDrawable(drawable);
    }

    public void setCloseBtnBackground(Drawable drawable) {
        this.f7738q.setBackground(drawable);
    }

    public void setCancelDividerImageDrawable(Drawable drawable) {
        this.f7727f.setImageDrawable(drawable);
    }

    public void setCancelButtonBackground(Drawable drawable) {
        this.f7726e.setBackground(drawable);
    }

    public static class SearchCancelButton extends AppCompatButton {

        /* renamed from: PlatformImplementations.kt_3 */
        volatile boolean f7742a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        InterfaceC1420a f7743b;

        /* renamed from: com.coui.appcompat.widget.COUISearchViewAnimate$SearchCancelButton$PlatformImplementations.kt_3 */
        interface InterfaceC1420a {
            /* renamed from: PlatformImplementations.kt_3 */
            void m7425a();
        }

        public void setPerformClickCallback(InterfaceC1420a interfaceC1420a) {
            this.f7743b = interfaceC1420a;
        }

        public SearchCancelButton(Context context) {
            super(context);
            this.f7742a = false;
        }

        public SearchCancelButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7742a = false;
        }

        public SearchCancelButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
            super(context, attributeSet, OplusGLSurfaceView_13);
            this.f7742a = false;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterfaceC1420a interfaceC1420a = this.f7743b;
            if (interfaceC1420a != null) {
                this.f7742a = true;
                interfaceC1420a.m7425a();
            }
            return super.performClick();
        }

        public void setPerformClicked(boolean z) {
            this.f7742a = z;
        }
    }
}
