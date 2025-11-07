package com.coui.appcompat.widget.floatingbutton;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.p024a.CardView;
import androidx.core.p027a.p028a.ResourcesCompat;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIFABPressFeedbackUtil;
import com.coui.appcompat.p099a.COUIStateListUtil;
import com.coui.appcompat.widget.COUIAnimationListenerAdapter;
import com.coui.appcompat.widget.floatingbutton.COUIFloatingButton;
import com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import coui.support.appcompat.R;

/* compiled from: COUIFloatingButtonLabel.java */
/* renamed from: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUIFloatingButtonLabel extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f8082a = "PlatformImplementations.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f8083b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ValueAnimator f8084c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f8085d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ShapeableImageView f8086e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CardView f8087f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f8088g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIFloatingButtonItem f8089h;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIFloatingButton.InterfaceC1465a f8090i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f8091j;

    public COUIFloatingButtonLabel(Context context) {
        super(context);
        m7748a(context, (AttributeSet) null);
    }

    @Override // android.view.View
    @SuppressLint({"RestrictedApi"})
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
        getChildFloatingButton().setVisibility(OplusGLSurfaceView_13);
        if (m7762a()) {
            getFloatingButtonLabelBackground().setVisibility(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        m7752b();
        if (OplusGLSurfaceView_13 == 1) {
            setLabelEnabled(false);
        } else {
            setLabel(this.f8085d.getText().toString());
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f8085d.setEnabled(z);
        this.f8086e.setEnabled(z);
        this.f8087f.setEnabled(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7762a() {
        return this.f8088g;
    }

    private void setLabelEnabled(boolean z) {
        this.f8088g = z;
        this.f8087f.setVisibility(z ? 0 : 8);
    }

    public TextView getFloatingButtonLabelText() {
        return this.f8085d;
    }

    public CardView getFloatingButtonLabelBackground() {
        return this.f8087f;
    }

    public ImageView getChildFloatingButton() {
        return this.f8086e;
    }

    public COUIFloatingButtonItem getFloatingButtonItem() {
        COUIFloatingButtonItem cOUIFloatingButtonItem = this.f8089h;
        if (cOUIFloatingButtonItem != null) {
            return cOUIFloatingButtonItem;
        }
        throw new IllegalStateException("SpeedDialActionItem not set yet!");
    }

    public COUIFloatingButtonItem.C1469a getFloatingButtonItemBuilder() {
        return new COUIFloatingButtonItem.C1469a(getFloatingButtonItem());
    }

    public void setFloatingButtonItem(COUIFloatingButtonItem cOUIFloatingButtonItem) throws Resources.NotFoundException {
        this.f8089h = cOUIFloatingButtonItem;
        setId(cOUIFloatingButtonItem.getFloatingButtonItemLocation());
        setLabel(cOUIFloatingButtonItem.getLabel(getContext()));
        setFabIcon(cOUIFloatingButtonItem.getFabImageDrawable(getContext()));
        ColorStateList fabBackgroundColor = cOUIFloatingButtonItem.getFabBackgroundColor();
        int color = getContext().getResources().getColor(R.color.couiGreenTintControlNormal);
        int iM6399a = COUIContextUtil.m6399a(getContext(), R.attr.couiTintControlNormal, color);
        if (fabBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            fabBackgroundColor = COUIStateListUtil.m6465a(iM6399a, color);
        }
        setFabBackgroundColor(fabBackgroundColor);
        ColorStateList labelColor = cOUIFloatingButtonItem.getLabelColor();
        if (labelColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelColor = ResourcesCompat.m2304b(getResources(), R.color.coui_floating_button_label_text_color, getContext().getTheme());
        }
        setLabelTextColor(labelColor);
        ColorStateList labelBackgroundColor = cOUIFloatingButtonItem.getLabelBackgroundColor();
        if (labelBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelBackgroundColor = COUIStateListUtil.m6465a(iM6399a, color);
        }
        setLabelBackgroundColor(labelBackgroundColor);
        if (cOUIFloatingButtonItem.isCOUIFloatingButtonExpandEnable()) {
            m7753c();
        }
        getChildFloatingButton().setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIFloatingButtonLabel.this.m7755d();
            }
        });
    }

    public void setOnActionSelectedListener(COUIFloatingButton.InterfaceC1465a interfaceC1465a) {
        this.f8090i = interfaceC1465a;
        if (this.f8090i != null) {
            getFloatingButtonLabelBackground().setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIFloatingButtonItem floatingButtonItem = COUIFloatingButtonLabel.this.getFloatingButtonItem();
                    if (COUIFloatingButtonLabel.this.f8090i == null || floatingButtonItem == null) {
                        return;
                    }
                    COUIFloatingButtonLabel.this.f8090i.m7726a(floatingButtonItem);
                }
            });
        } else {
            getChildFloatingButton().setOnClickListener(null);
            getFloatingButtonLabelBackground().setOnClickListener(null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7748a(Context context, AttributeSet attributeSet) {
        View viewInflate = inflate(context, R.layout.coui_floating_button_item_label, this);
        this.f8086e = (ShapeableImageView) viewInflate.findViewById(R.id_renamed.coui_floating_button_child_fab);
        this.f8085d = (TextView) viewInflate.findViewById(R.id_renamed.coui_floating_button_label);
        this.f8087f = (CardView) viewInflate.findViewById(R.id_renamed.coui_floating_button_label_container);
        this.f8086e.setElevation(24.0f);
        this.f8086e.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.3
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setAlpha(0.3f);
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        this.f8086e.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
        this.f8087f.setCardElevation(24.0f);
        this.f8087f.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.4
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setAlpha(0.3f);
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIFloatingButtonLabel.m7750b(COUIFloatingButtonLabel.this.getContext(), 5.67f));
            }
        });
        setOrientation(0);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIFloatingButtonLabel, 0, 0);
        try {
            try {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIFloatingButtonLabel_srcCompat, Integer.MIN_VALUE);
                if (resourceId == Integer.MIN_VALUE) {
                    resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIFloatingButtonLabel_android_src, Integer.MIN_VALUE);
                }
                COUIFloatingButtonItem.C1469a c1469a = new COUIFloatingButtonItem.C1469a(getId(), resourceId);
                c1469a.m7742a(typedArrayObtainStyledAttributes.getString(R.styleable.COUIFloatingButtonLabel_fabLabel));
                c1469a.m7741a(ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.COUIFloatingButtonLabel_fabBackgroundColor, COUIContextUtil.m6399a(getContext(), R.attr.couiTintControlNormal, 0))));
                c1469a.m7744b(ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.COUIFloatingButtonLabel_fabLabelColor, Integer.MIN_VALUE)));
                c1469a.m7745c(ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.COUIFloatingButtonLabel_fabLabelBackgroundColor, Integer.MIN_VALUE)));
                setFloatingButtonItem(c1469a.m7743a());
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(f8082a, "Failure setting FabWithLabelView icon" + COUIBaseListPopupWindow_8.getMessage());
            }
            typedArrayObtainStyledAttributes.recycle();
            setClipChildren(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7752b() throws Resources.NotFoundException {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.coui_floating_button_fab_normal_size);
        getContext().getResources().getDimensionPixelSize(R.dimen.coui_floating_button_fab_side_margin);
        getContext().getResources().getDimensionPixelSize(R.dimen.coui_floating_button_item_normal_bottom_margin);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f8086e.getLayoutParams();
        if (getOrientation() == 0) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize, -2);
            layoutParams3.gravity = 16;
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams = layoutParams3;
        }
        setLayoutParams(layoutParams);
        this.f8086e.setLayoutParams(layoutParams2);
    }

    private void setFabIcon(Drawable drawable) {
        this.f8086e.setImageDrawable(drawable);
    }

    private void setLabel(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f8085d.setText(charSequence);
            setLabelEnabled(getOrientation() == 0);
        } else {
            setLabelEnabled(false);
        }
    }

    private void setFabBackgroundColor(ColorStateList colorStateList) {
        this.f8086e.setBackgroundTintList(colorStateList);
    }

    private void setLabelTextColor(ColorStateList colorStateList) {
        this.f8085d.setTextColor(colorStateList);
    }

    private void setLabelBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            this.f8087f.setCardBackgroundColor(0);
            this.f8091j = this.f8087f.getElevation();
            this.f8087f.setElevation(0.0f);
        } else {
            this.f8087f.setCardBackgroundColor(colorStateList);
            float COUIBaseListPopupWindow_12 = this.f8091j;
            if (COUIBaseListPopupWindow_12 != 0.0f) {
                this.f8087f.setElevation(COUIBaseListPopupWindow_12);
                this.f8091j = 0.0f;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7753c() {
        this.f8086e.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    COUIFloatingButtonLabel.this.m7758e();
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                COUIFloatingButtonLabel.this.m7760f();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7755d() {
        COUIFloatingButtonItem floatingButtonItem = getFloatingButtonItem();
        COUIFloatingButton.InterfaceC1465a interfaceC1465a = this.f8090i;
        if (interfaceC1465a == null || floatingButtonItem == null) {
            return;
        }
        interfaceC1465a.m7726a(floatingButtonItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m7758e() {
        clearAnimation();
        m7761g();
        COUIFloatingButtonTouchAnimation c1471bM6403a = COUIFABPressFeedbackUtil.m6403a(this.f8086e);
        this.f8084c = COUIFABPressFeedbackUtil.m6402a();
        this.f8084c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIFloatingButtonLabel.this.f8083b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIFloatingButtonLabel.this.f8083b >= 0.98f) {
                    COUIFloatingButtonLabel.this.f8083b = 0.98f;
                }
            }
        });
        c1471bM6403a.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.coui.appcompat.widget.floatingbutton.PlatformImplementations.kt_3.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIFloatingButtonLabel.this.f8084c.start();
            }
        });
        this.f8086e.startAnimation(c1471bM6403a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m7760f() {
        clearAnimation();
        m7761g();
        ShapeableImageView shapeableImageView = this.f8086e;
        shapeableImageView.startAnimation(COUIFABPressFeedbackUtil.m6404a(shapeableImageView, this.f8083b));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7761g() {
        ValueAnimator valueAnimator = this.f8084c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f8084c.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m7750b(Context context, float COUIBaseListPopupWindow_12) {
        return Math.round(TypedValue.applyDimension(1, COUIBaseListPopupWindow_12, context.getResources().getDisplayMetrics()));
    }
}
