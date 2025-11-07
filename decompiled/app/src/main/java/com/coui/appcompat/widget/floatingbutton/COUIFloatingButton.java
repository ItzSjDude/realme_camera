package com.coui.appcompat.widget.floatingbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p036h.ViewCompat;
import androidx.dynamicanimation.p043a.DynamicAnimation;
import androidx.dynamicanimation.p043a.SpringAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIFABPressFeedbackUtil;
import com.coui.appcompat.p099a.COUIStateListUtil;
import com.coui.appcompat.widget.COUIAnimationListenerAdapter;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUIFloatingButton extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f8023a = "COUIFloatingButton";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final PathInterpolator f8024b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f8025c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final InstanceState f8026d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private List<COUIFloatingButtonLabel> f8027e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f8028f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ShapeableImageView f8029g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f8030h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8031i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8032j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Runnable f8033k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ValueAnimator f8034l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PathInterpolator f8035m;

    /* renamed from: OplusGLSurfaceView_11 */
    private PathInterpolator f8036n;

    /* renamed from: o */
    private PathInterpolator f8037o;

    /* renamed from: p */
    private PathInterpolator f8038p;

    /* renamed from: q */
    private PathInterpolator f8039q;

    /* renamed from: r */
    private boolean f8040r;

    /* renamed from: s */
    private InterfaceC1466b f8041s;

    /* renamed from: t */
    private InterfaceC1465a f8042t;

    /* renamed from: u */
    private InterfaceC1465a f8043u;

    /* renamed from: v */
    private InterfaceC1465a f8044v;

    /* renamed from: w */
    private InterfaceC1467c f8045w;

    /* renamed from: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton$PlatformImplementations.kt_3 */
    public interface InterfaceC1465a {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7726a(COUIFloatingButtonItem cOUIFloatingButtonItem);
    }

    /* renamed from: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1466b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7727a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7728a();
    }

    /* renamed from: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1467c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7729a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7670a(FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) throws Resources.NotFoundException {
        if (m7711c()) {
            m7710b();
            ViewCompat.m2895n(this.f8029g).m2954c(0.0f).m2947a(0L).m2955c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Collection<COUIFloatingButtonLabel> m7706a(Collection<COUIFloatingButtonItem> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<COUIFloatingButtonItem> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(m7701a(it.next()));
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public COUIFloatingButtonLabel m7701a(COUIFloatingButtonItem cOUIFloatingButtonItem) {
        return m7702a(cOUIFloatingButtonItem, this.f8027e.size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public COUIFloatingButtonLabel m7702a(COUIFloatingButtonItem cOUIFloatingButtonItem, int OplusGLSurfaceView_13) {
        return m7703a(cOUIFloatingButtonItem, OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public COUIFloatingButtonLabel m7703a(COUIFloatingButtonItem cOUIFloatingButtonItem, int OplusGLSurfaceView_13, boolean z) {
        return m7704a(cOUIFloatingButtonItem, OplusGLSurfaceView_13, z, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public COUIFloatingButtonLabel m7704a(COUIFloatingButtonItem cOUIFloatingButtonItem, int OplusGLSurfaceView_13, boolean z, int i2) {
        COUIFloatingButtonLabel c1470aM7675b = m7675b(cOUIFloatingButtonItem.getFloatingButtonItemLocation());
        if (c1470aM7675b != null) {
            return m7705a(c1470aM7675b.getFloatingButtonItem(), cOUIFloatingButtonItem);
        }
        COUIFloatingButtonLabel c1470aCreateFabWithLabelView = cOUIFloatingButtonItem.createFabWithLabelView(getContext());
        c1470aCreateFabWithLabelView.setOrientation(getOrientation() == 1 ? 0 : 1);
        c1470aCreateFabWithLabelView.setOnActionSelectedListener(this.f8044v);
        c1470aCreateFabWithLabelView.setVisibility(i2);
        int iM7661a = m7661a(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0) {
            c1470aCreateFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.coui_floating_button_item_first_bottom_margin));
            addView(c1470aCreateFabWithLabelView, iM7661a);
        } else {
            c1470aCreateFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.coui_floating_button_item_normal_bottom_margin));
            addView(c1470aCreateFabWithLabelView, iM7661a);
        }
        this.f8027e.add(OplusGLSurfaceView_13, c1470aCreateFabWithLabelView);
        m7668a(c1470aCreateFabWithLabelView, 0, OplusGLSurfaceView_13, 300, false);
        return c1470aCreateFabWithLabelView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public COUIFloatingButtonLabel m7705a(COUIFloatingButtonItem cOUIFloatingButtonItem, COUIFloatingButtonItem cOUIFloatingButtonItem2) {
        COUIFloatingButtonLabel c1470aM7675b;
        int iIndexOf;
        if (cOUIFloatingButtonItem == null || (c1470aM7675b = m7675b(cOUIFloatingButtonItem.getFloatingButtonItemLocation())) == null || (iIndexOf = this.f8027e.indexOf(c1470aM7675b)) < 0) {
            return null;
        }
        int visibility = c1470aM7675b.getVisibility();
        m7663a(m7675b(cOUIFloatingButtonItem2.getFloatingButtonItemLocation()), (Iterator<COUIFloatingButtonLabel>) null, false);
        m7663a(m7675b(cOUIFloatingButtonItem.getFloatingButtonItemLocation()), (Iterator<COUIFloatingButtonLabel>) null, false);
        return m7704a(cOUIFloatingButtonItem2, iIndexOf, false, visibility);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIFloatingButtonItem m7663a(COUIFloatingButtonLabel c1470a, Iterator<COUIFloatingButtonLabel> it, boolean z) {
        if (c1470a == null) {
            return null;
        }
        COUIFloatingButtonItem floatingButtonItem = c1470a.getFloatingButtonItem();
        if (it != null) {
            it.remove();
        } else {
            this.f8027e.remove(c1470a);
        }
        removeView(c1470a);
        return floatingButtonItem;
    }

    public ArrayList<COUIFloatingButtonItem> getActionItems() {
        ArrayList<COUIFloatingButtonItem> arrayList = new ArrayList<>(this.f8027e.size());
        Iterator<COUIFloatingButtonLabel> it = this.f8027e.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFloatingButtonItem());
        }
        return arrayList;
    }

    public void setOnActionSelectedListener(InterfaceC1465a interfaceC1465a) {
        this.f8042t = interfaceC1465a;
        if (interfaceC1465a != null) {
            this.f8043u = this.f8042t;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f8027e.size(); OplusGLSurfaceView_13++) {
            this.f8027e.get(OplusGLSurfaceView_13).setOnActionSelectedListener(this.f8044v);
        }
    }

    public void setOnChangeListener(InterfaceC1466b interfaceC1466b) {
        this.f8041s = interfaceC1466b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7707a() throws Resources.NotFoundException {
        m7672a(true, true, 300, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7710b() throws Resources.NotFoundException {
        m7672a(false, true, 300, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7709a(boolean z, int OplusGLSurfaceView_13, boolean z2) throws Resources.NotFoundException {
        m7672a(false, z, OplusGLSurfaceView_13, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m7711c() {
        return this.f8026d.mCOUIFloatingButtonMenuIsOpen;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m7712d() {
        return this.f8026d.mCOUIFloatingButtonAnimationIsRun;
    }

    public ShapeableImageView getMainFloatingButton() {
        return this.f8029g;
    }

    public void setMainFabDrawable(Drawable drawable) {
        this.f8028f = drawable;
        m7671a(false, false);
    }

    public ColorStateList getMainFloatingButtonBackgroundColor() {
        return this.f8026d.mMainCOUIFloatingButtonBackgroundColor;
    }

    public void setMainFloatingButtonBackgroundColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.f8026d.mMainCOUIFloatingButtonBackgroundColor = colorStateList;
        m7697j();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setFloatingButtonExpandEnable(boolean z) {
        if (z) {
            this.f8029g.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        COUIFloatingButton.this.m7693h();
                        return false;
                    }
                    if (motionEvent.getAction() == 1) {
                        COUIFloatingButton.this.m7695i();
                        return false;
                    }
                    if (motionEvent.getAction() != 3) {
                        return false;
                    }
                    COUIFloatingButton.this.m7695i();
                    return false;
                }
            });
        }
        this.f8029g.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws Resources.NotFoundException {
                if (COUIFloatingButton.this.f8045w != null) {
                    COUIFloatingButton.this.f8045w.m7729a();
                }
                COUIFloatingButton.this.m7691g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m7691g() throws Resources.NotFoundException {
        if (m7711c()) {
            InterfaceC1466b interfaceC1466b = this.f8041s;
            if (interfaceC1466b == null || !interfaceC1466b.m7728a()) {
                m7710b();
                return;
            }
            return;
        }
        m7707a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m7693h() {
        m7677b(true);
        COUIFloatingButtonTouchAnimation c1471bM6403a = COUIFABPressFeedbackUtil.m6403a(this.f8029g);
        this.f8034l = COUIFABPressFeedbackUtil.m6402a();
        this.f8034l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIFloatingButton.this.f8025c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (!COUIFloatingButton.this.f8040r || valueAnimator.getCurrentPlayTime() <= valueAnimator.getDuration() * 0.4f) {
                    return;
                }
                COUIFloatingButton.this.f8040r = false;
                COUIFloatingButton.this.m7695i();
            }
        });
        c1471bM6403a.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIFloatingButton.this.f8034l.start();
            }
        });
        this.f8029g.startAnimation(c1471bM6403a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m7695i() {
        m7677b(false);
        if (this.f8040r) {
            return;
        }
        this.f8029g.startAnimation(COUIFABPressFeedbackUtil.m6404a(this.f8029g, this.f8025c));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7677b(boolean z) {
        boolean z2 = false;
        this.f8040r = false;
        ValueAnimator valueAnimator = this.f8034l;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (!z && this.f8034l.getCurrentPlayTime() < this.f8034l.getDuration() * 0.4f) {
                z2 = true;
            }
            this.f8040r = z2;
            if (!this.f8040r) {
                this.f8034l.cancel();
            }
        }
        if (this.f8040r) {
            return;
        }
        clearAnimation();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        this.f8026d.mCOUIFloatingButtonItems = getActionItems();
        bundle.putParcelable(InstanceState.class.getName(), this.f8026d);
        bundle.putParcelable("superState", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            InstanceState instanceState = (InstanceState) bundle.getParcelable(InstanceState.class.getName());
            if (instanceState != null && instanceState.mCOUIFloatingButtonItems != null && !instanceState.mCOUIFloatingButtonItems.isEmpty()) {
                setMainFloatingButtonBackgroundColor(instanceState.mMainCOUIFloatingButtonBackgroundColor);
                m7706a(instanceState.mCOUIFloatingButtonItems);
                m7672a(instanceState.mCOUIFloatingButtonMenuIsOpen, false, 300, false);
            }
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getMainFloatingButton().setEnabled(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7661a(int OplusGLSurfaceView_13) {
        return this.f8027e.size() - OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7672a(boolean z, boolean z2, int OplusGLSurfaceView_13, boolean z3) throws Resources.NotFoundException {
        if (z && this.f8027e.isEmpty()) {
            z = false;
            InterfaceC1466b interfaceC1466b = this.f8041s;
            if (interfaceC1466b != null) {
                interfaceC1466b.m7728a();
            }
        }
        if (m7711c() == z) {
            return;
        }
        if (!m7712d()) {
            m7678b(z, z2, OplusGLSurfaceView_13, z3);
            m7671a(z2, z3);
            m7697j();
        }
        InterfaceC1466b interfaceC1466b2 = this.f8041s;
        if (interfaceC1466b2 != null) {
            interfaceC1466b2.m7727a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7671a(boolean z, boolean z2) {
        if (m7711c()) {
            m7708a(this.f8029g, 45.0f, z2);
            return;
        }
        m7699a(z2).start();
        Drawable drawable = this.f8028f;
        if (drawable != null) {
            this.f8029g.setImageDrawable(drawable);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7697j() throws Resources.NotFoundException {
        ColorStateList mainFloatingButtonBackgroundColor = getMainFloatingButtonBackgroundColor();
        if (mainFloatingButtonBackgroundColor != ColorStateList.valueOf(Integer.MIN_VALUE)) {
            this.f8029g.setBackgroundTintList(mainFloatingButtonBackgroundColor);
        } else {
            int color = getContext().getResources().getColor(R.color.couiGreenTintControlNormal);
            this.f8029g.setBackgroundTintList(COUIStateListUtil.m6465a(COUIContextUtil.m6399a(getContext(), R.attr.couiTintControlNormal, color), color));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIFloatingButtonLabel m7675b(int OplusGLSurfaceView_13) {
        for (COUIFloatingButtonLabel c1470a : this.f8027e) {
            if (c1470a.getId() == OplusGLSurfaceView_13) {
                return c1470a;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUIFloatingButtonLabel m7682c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.f8027e.size()) {
            return this.f8027e.get(OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7678b(boolean z, boolean z2, int OplusGLSurfaceView_13, boolean z3) {
        int size = this.f8027e.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = (size - 1) - i2;
                COUIFloatingButtonLabel c1470a = this.f8027e.get(i3);
                if (this.f8031i != 0) {
                    if (!m7688f(i3)) {
                        c1470a.setVisibility(8);
                        if (z2) {
                            m7667a(c1470a, i2 * 50, i3, 8);
                        }
                    } else {
                        c1470a.setVisibility(0);
                        if (z2) {
                            m7667a(c1470a, i2 * 50, i3, 0);
                        }
                    }
                } else if (z2) {
                    m7667a(c1470a, i2 * 50, i3, 0);
                }
            }
            this.f8026d.mCOUIFloatingButtonMenuIsOpen = true;
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            COUIFloatingButtonLabel c1470a2 = this.f8027e.get(i4);
            if (z2) {
                m7668a(c1470a2, i4 * 50, i4, OplusGLSurfaceView_13, z3);
            }
        }
        this.f8026d.mCOUIFloatingButtonMenuIsOpen = false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m7713e() {
        ViewCompat.m2895n(this.f8029g).m2953b();
        this.f8029g.setVisibility(0);
        this.f8029g.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(f8024b).setDuration(350L).setListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = true;
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.f8033k);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.f8033k);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ValueAnimator m7700a(Animator.AnimatorListener animatorListener) {
        ViewCompat.m2895n(this.f8029g).m2953b();
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("alpha", this.f8029g.getAlpha(), 0.0f), PropertyValuesHolder.ofFloat("scaleX", this.f8029g.getScaleX(), 0.6f), PropertyValuesHolder.ofFloat("scaleY", this.f8029g.getScaleY(), 0.6f));
        valueAnimatorOfPropertyValuesHolder.setInterpolator(f8024b);
        valueAnimatorOfPropertyValuesHolder.setDuration(350L);
        valueAnimatorOfPropertyValuesHolder.addListener(animatorListener);
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue("alpha")).floatValue();
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue("scaleX")).floatValue();
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue("scaleY")).floatValue();
                COUIFloatingButton.this.f8029g.setAlpha(fFloatValue);
                COUIFloatingButton.this.f8029g.setScaleX(fFloatValue2);
                COUIFloatingButton.this.f8029g.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfPropertyValuesHolder;
    }

    @Deprecated
    /* renamed from: COUIBaseListPopupWindow_12 */
    public ValueAnimator m7714f() {
        return m7700a(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = true;
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.postDelayed(cOUIFloatingButton.f8033k, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIFloatingButton.this.f8029g.setVisibility(0);
                COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.f8033k);
                COUIFloatingButton.this.f8029g.setVisibility(8);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7667a(final COUIFloatingButtonLabel c1470a, int OplusGLSurfaceView_13, final int i2, final int i3) {
        AnimatorSet animatorSet = new AnimatorSet();
        final SpringAnimation c0552f = new SpringAnimation(c1470a, DynamicAnimation.f3296b, 0.0f);
        c0552f.m3232e().m3236a(500.0f);
        c0552f.m3232e().m3239b(0.8f);
        c0552f.mo3199g(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "scaleX", 0.6f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "scaleY", 0.6f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "scaleX", 0.6f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "scaleY", 0.6f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "alpha", 0.0f, 1.0f);
        final ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat6.setInterpolator(this.f8035m);
        objectAnimatorOfFloat6.setDuration(350L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat5, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(this.f8035m);
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(OplusGLSurfaceView_13);
        if (c1470a.getFloatingButtonLabelText().getText() != "") {
            if (m7698k()) {
                c1470a.getFloatingButtonLabelBackground().setPivotX(0.0f);
                c1470a.getFloatingButtonLabelBackground().setPivotY(0.0f);
            } else {
                c1470a.getFloatingButtonLabelBackground().setPivotX(c1470a.getFloatingButtonLabelBackground().getWidth());
                c1470a.getFloatingButtonLabelBackground().setPivotY(0.0f);
            }
        }
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIFloatingButton.this.m7685e(i2)) {
                    COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = true;
                    COUIFloatingButton.this.setOnActionSelectedListener(null);
                }
                objectAnimatorOfFloat6.start();
                c0552f.m3231a(0.0f);
                c1470a.setVisibility(i3);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIFloatingButton.this.m7684d(i2)) {
                    COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = false;
                    COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                    cOUIFloatingButton.setOnActionSelectedListener(cOUIFloatingButton.f8043u);
                }
            }
        });
        animatorSet.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7668a(final COUIFloatingButtonLabel c1470a, int OplusGLSurfaceView_13, final int i2, final int i3, final boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int iM7689g = m7689g(i2);
        if (z) {
            iM7689g += marginLayoutParams.bottomMargin + this.f8029g.getHeight();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1470a, "translationY", iM7689g);
        objectAnimatorOfFloat.setStartDelay(OplusGLSurfaceView_13);
        objectAnimatorOfFloat.setDuration(i3);
        objectAnimatorOfFloat.setInterpolator(this.f8036n);
        if (c1470a.getFloatingButtonLabelText().getText() != "") {
            if (m7698k()) {
                c1470a.getFloatingButtonLabelBackground().setPivotX(0.0f);
                c1470a.getFloatingButtonLabelBackground().setPivotY(c1470a.getFloatingButtonLabelBackground().getHeight());
            } else {
                c1470a.getFloatingButtonLabelBackground().setPivotX(c1470a.getFloatingButtonLabelBackground().getWidth());
                c1470a.getFloatingButtonLabelBackground().setPivotY(c1470a.getFloatingButtonLabelBackground().getHeight());
            }
        }
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIFloatingButton.this.m7684d(i2)) {
                    COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = true;
                    COUIFloatingButton.this.setOnActionSelectedListener(null);
                }
                if (z) {
                    COUIFloatingButton.this.m7669a(c1470a, i2, i3, true);
                } else {
                    COUIFloatingButton.this.m7669a(c1470a, i2, i3, false);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c1470a.setTranslationY(COUIFloatingButton.this.m7689g(i2));
                c1470a.getChildFloatingButton().setPivotX(c1470a.getChildFloatingButton().getWidth() / 2.0f);
                c1470a.getChildFloatingButton().setPivotY(c1470a.getChildFloatingButton().getHeight() / 2.0f);
                c1470a.setPivotX(r3.getWidth());
                c1470a.setPivotY(r3.getHeight());
                if (COUIFloatingButton.this.m7685e(i2)) {
                    COUIFloatingButton.this.f8026d.mCOUIFloatingButtonAnimationIsRun = false;
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7669a(COUIFloatingButtonLabel c1470a, int OplusGLSurfaceView_13, int i2, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "scaleX", 1.0f, 0.6f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "scaleY", 1.0f, 0.6f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "scaleX", 1.0f, 0.6f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "scaleY", 1.0f, 0.6f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(c1470a.getChildFloatingButton(), "alpha", 1.0f, 0.0f);
        final ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(c1470a.getFloatingButtonLabelBackground(), "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat6.setInterpolator(this.f8037o);
        objectAnimatorOfFloat6.setDuration(200L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat5, objectAnimatorOfFloat4, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(this.f8036n);
        animatorSet.setDuration(i2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                objectAnimatorOfFloat6.start();
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m7684d(int OplusGLSurfaceView_13) {
        COUIFloatingButtonLabel c1470aM7682c = m7682c(OplusGLSurfaceView_13);
        return c1470aM7682c != null && indexOfChild(c1470aM7682c) == this.f8027e.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m7685e(int OplusGLSurfaceView_13) {
        COUIFloatingButtonLabel c1470aM7682c = m7682c(OplusGLSurfaceView_13);
        return c1470aM7682c != null && indexOfChild(c1470aM7682c) == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7708a(View view, float COUIBaseListPopupWindow_12, boolean z) {
        this.f8030h = COUIBaseListPopupWindow_12;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f8029g, "rotation", 0.0f, COUIBaseListPopupWindow_12);
        objectAnimatorOfFloat.setInterpolator(this.f8038p);
        objectAnimatorOfFloat.setDuration(z ? 250L : 300L);
        objectAnimatorOfFloat.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ObjectAnimator m7699a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f8029g, "rotation", this.f8030h, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f8039q);
        objectAnimatorOfFloat.setDuration(z ? 250L : 300L);
        return objectAnimatorOfFloat;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m7698k() {
        return getLayoutDirection() == 1;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private static class InstanceState implements Parcelable {
        public static final Parcelable.Creator<InstanceState> CREATOR = new Parcelable.Creator<InstanceState>() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.InstanceState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public InstanceState createFromParcel(Parcel parcel) {
                return new InstanceState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public InstanceState[] newArray(int OplusGLSurfaceView_13) {
                return new InstanceState[OplusGLSurfaceView_13];
            }
        };
        private boolean mCOUIFloatingButtonAnimationIsRun;
        private ArrayList<COUIFloatingButtonItem> mCOUIFloatingButtonItems;
        private boolean mCOUIFloatingButtonMenuIsOpen;
        private ColorStateList mMainCOUIFloatingButtonBackgroundColor;
        private boolean mUseReverseAnimationOnClose;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeByte(this.mCOUIFloatingButtonMenuIsOpen ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mCOUIFloatingButtonAnimationIsRun ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mUseReverseAnimationOnClose ? (byte) 1 : (byte) 0);
            parcel.writeTypedList(this.mCOUIFloatingButtonItems);
        }

        public InstanceState() {
            this.mCOUIFloatingButtonMenuIsOpen = false;
            this.mCOUIFloatingButtonAnimationIsRun = false;
            this.mMainCOUIFloatingButtonBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mUseReverseAnimationOnClose = false;
            this.mCOUIFloatingButtonItems = new ArrayList<>();
        }

        protected InstanceState(Parcel parcel) {
            this.mCOUIFloatingButtonMenuIsOpen = false;
            this.mCOUIFloatingButtonAnimationIsRun = false;
            this.mMainCOUIFloatingButtonBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mUseReverseAnimationOnClose = false;
            this.mCOUIFloatingButtonItems = new ArrayList<>();
            this.mCOUIFloatingButtonMenuIsOpen = parcel.readByte() != 0;
            this.mCOUIFloatingButtonAnimationIsRun = parcel.readByte() != 0;
            this.mUseReverseAnimationOnClose = parcel.readByte() != 0;
            this.mCOUIFloatingButtonItems = parcel.createTypedArrayList(COUIFloatingButtonItem.CREATOR);
        }
    }

    public static class COUIFloatingButtonBehavior extends CoordinatorLayout.AbstractC0408b<View> {

        /* renamed from: PlatformImplementations.kt_3 */
        private Rect f8066a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private FloatingActionButton.OnVisibilityChangedListener f8067b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f8068c;

        public COUIFloatingButtonBehavior() {
            this.f8068c = true;
        }

        public COUIFloatingButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f8068c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f24533x48c0caa5, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static boolean m7719c(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0411e) {
                return ((CoordinatorLayout.C0411e) layoutParams).m2225b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
        public void onAttachedToLayoutParams(CoordinatorLayout.C0411e c0411e) {
            if (c0411e.f2668h == 0) {
                c0411e.f2668h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) throws Resources.NotFoundException {
            if (view2 instanceof AppBarLayout) {
                m7717a(coordinatorLayout, (AppBarLayout) view2, view);
                return false;
            }
            if (!m7719c(view2)) {
                return false;
            }
            m7718b(view2, view);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int OplusGLSurfaceView_13) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (view2 instanceof AppBarLayout) {
                    if (m7717a(coordinatorLayout, (AppBarLayout) view2, view)) {
                        break;
                    }
                } else {
                    if (m7719c(view2) && m7718b(view2, view)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(view, OplusGLSurfaceView_13);
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        protected void m7720a(View view) {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).show(this.f8067b);
            } else if (view instanceof COUIFloatingButton) {
                view.setVisibility(0);
            } else {
                view.setVisibility(0);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected void m7721b(View view) throws Resources.NotFoundException {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).hide(this.f8067b);
            } else if (view instanceof COUIFloatingButton) {
                ((COUIFloatingButton) view).m7670a(this.f8067b);
            } else {
                view.setVisibility(4);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m7716a(View view, View view2) {
            return this.f8068c && ((CoordinatorLayout.C0411e) view2.getLayoutParams()).m2216a() == view.getId() && view2.getVisibility() == 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m7717a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!m7716a(appBarLayout, view)) {
                return false;
            }
            if (this.f8066a == null) {
                this.f8066a = new Rect();
            }
            Rect rect = this.f8066a;
            ViewGroupUtils_3.m7768b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= m7715a(appBarLayout)) {
                view.setVisibility(8);
                return true;
            }
            view.setVisibility(0);
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m7715a(AppBarLayout appBarLayout) {
            int iM2894m = ViewCompat.m2894m(appBarLayout);
            if (iM2894m != 0) {
                return iM2894m * 2;
            }
            int childCount = appBarLayout.getChildCount();
            if (childCount >= 1) {
                return ViewCompat.m2894m(appBarLayout.getChildAt(childCount - 1)) * 2;
            }
            return 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m7718b(View view, View view2) throws Resources.NotFoundException {
            if (!m7716a(view, view2)) {
                return false;
            }
            if (view.getTop() < (view2.getHeight() / 2) + ((CoordinatorLayout.C0411e) view2.getLayoutParams()).topMargin) {
                m7721b(view2);
                return true;
            }
            m7720a(view2);
            return true;
        }
    }

    public static class ScrollViewBehavior extends COUIFloatingButtonBehavior {

        /* renamed from: PlatformImplementations.kt_3 */
        ValueAnimator f8069a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f8070b;

        public ScrollViewBehavior() {
            this.f8069a = new ObjectAnimator();
            this.f8070b = false;
        }

        public ScrollViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8069a = new ObjectAnimator();
            this.f8070b = false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, final View view, View view2, View view3, int OplusGLSurfaceView_13, int i2) {
            if (view3 instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view3;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (recyclerView.getChildCount() != 0 && itemCount != 0 && !this.f8070b) {
                    recyclerView.addOnScrollListener(new RecyclerView.AbstractC0698n() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButton.ScrollViewBehavior.1
                        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
                        public void onScrollStateChanged(RecyclerView recyclerView2, int i3) {
                            super.onScrollStateChanged(recyclerView2, i3);
                        }

                        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
                        public void onScrolled(RecyclerView recyclerView2, int i3, int i4) throws Resources.NotFoundException {
                            super.onScrolled(recyclerView2, i3, i4);
                            View view4 = view;
                            if (view4 instanceof COUIFloatingButton) {
                                ScrollViewBehavior.this.m7725a((COUIFloatingButton) view4, i4);
                            }
                        }
                    });
                    this.f8070b = true;
                }
                return false;
            }
            if (view3 instanceof AbsListView) {
                AbsListView absListView = (AbsListView) view3;
                int count = absListView.getCount();
                int childCount = absListView.getChildCount();
                View childAt = absListView.getChildAt(0);
                int top = view3.getTop() - view3.getPaddingTop();
                int bottom = view3.getBottom() - view3.getPaddingBottom();
                View childAt2 = absListView.getChildAt(childCount - 1);
                if (childCount > 0 && count > 0) {
                    if (absListView.getFirstVisiblePosition() == 0 && childAt.getTop() >= (-top)) {
                        return false;
                    }
                    if (childAt2 != null && absListView.getLastVisiblePosition() == count - 1 && childAt2.getBottom() <= bottom) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) throws Resources.NotFoundException {
            super.onNestedPreScroll(coordinatorLayout, view, view2, OplusGLSurfaceView_13, i2, iArr, i3);
            if (view instanceof COUIFloatingButton) {
                m7725a((COUIFloatingButton) view, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m7725a(COUIFloatingButton cOUIFloatingButton, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
            if (OplusGLSurfaceView_13 <= 10 || cOUIFloatingButton.getVisibility() != 0) {
                if (OplusGLSurfaceView_13 < -10) {
                    cOUIFloatingButton.m7713e();
                }
            } else {
                if (cOUIFloatingButton.m7711c() && !this.f8069a.isRunning()) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f8069a = cOUIFloatingButton.m7714f();
                    animatorSet.playTogether(this.f8069a, cOUIFloatingButton.m7699a(true));
                    animatorSet.setDuration(150L);
                    cOUIFloatingButton.m7709a(true, 250, true);
                    animatorSet.start();
                    return;
                }
                if (this.f8069a.isRunning()) {
                    return;
                }
                this.f8069a = cOUIFloatingButton.m7714f();
                this.f8069a.start();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m7688f(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f8027e.size()) {
            return false;
        }
        return (((float) m7689g(OplusGLSurfaceView_13)) + ((float) ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin)) + ((float) this.f8029g.getHeight()) <= ((float) (this.f8031i + this.f8032j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m7689g(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f8027e.size()) {
            return 0;
        }
        return m7662a(getContext(), (OplusGLSurfaceView_13 * 76) + 92);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m7662a(Context context, float COUIBaseListPopupWindow_12) {
        return Math.round(TypedValue.applyDimension(1, COUIBaseListPopupWindow_12, context.getResources().getDisplayMetrics()));
    }

    public void setFloatingButtonClickListener(InterfaceC1467c interfaceC1467c) {
        this.f8045w = interfaceC1467c;
    }
}
