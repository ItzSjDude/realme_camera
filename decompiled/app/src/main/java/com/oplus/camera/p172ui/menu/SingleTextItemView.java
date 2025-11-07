package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.util.Util;

/* compiled from: SingleTextItemView.java */
/* renamed from: com.oplus.camera.ui.menu.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class SingleTextItemView extends TextView implements InverseAble {

    /* renamed from: A */
    private boolean f19449A;

    /* renamed from: PlatformImplementations.kt_3 */
    protected CameraUIListener f19450a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final BlurMaskFilter f19451b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f19452c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f19453d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f19454e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f19455f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f19456g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f19457h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f19458i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f19459j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f19460k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f19461l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f19462m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f19463n;

    /* renamed from: o */
    private int f19464o;

    /* renamed from: p */
    private int f19465p;

    /* renamed from: q */
    private int f19466q;

    /* renamed from: r */
    private int f19467r;

    /* renamed from: s */
    private int f19468s;

    /* renamed from: t */
    private int f19469t;

    /* renamed from: u */
    private Drawable f19470u;

    /* renamed from: v */
    private Bitmap f19471v;

    /* renamed from: w */
    private Canvas f19472w;

    /* renamed from: x */
    private String f19473x;

    /* renamed from: y */
    private String f19474y;

    /* renamed from: z */
    private Context f19475z;

    public SingleTextItemView(Context context, CameraUIListener cameraUIListener) {
        super(context);
        this.f19450a = null;
        this.f19452c = false;
        this.f19453d = false;
        this.f19454e = false;
        this.f19455f = false;
        this.f19456g = true;
        this.f19457h = false;
        this.f19458i = false;
        this.f19459j = false;
        this.f19460k = false;
        this.f19461l = 0;
        this.f19462m = 0;
        this.f19463n = 0;
        this.f19464o = 0;
        this.f19465p = 0;
        this.f19466q = 0;
        this.f19467r = 0;
        this.f19468s = 17;
        this.f19469t = 0;
        this.f19470u = null;
        this.f19471v = null;
        this.f19472w = null;
        this.f19475z = null;
        this.f19449A = true;
        this.f19475z = context;
        this.f19450a = cameraUIListener;
        this.f19463n = this.f19475z.getResources().getDimensionPixelSize(R.dimen.menu_option_item_width);
        if (!Util.m24346ai()) {
            this.f19469t = this.f19475z.getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
        }
        this.f19451b = new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.SOLID);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        CameraUIListener cameraUIListener = this.f19450a;
        if (cameraUIListener != null && cameraUIListener.mo10873p() && (actionMasked = motionEvent.getActionMasked()) != 3 && actionMasked != 2) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getViewWidth() {
        if (this.f19461l <= 0 || this.f19456g || this.f19454e) {
            if (this.f19466q == 0 || this.f19467r == 0 || this.f19457h) {
                measure(Util.getScreenWidth(), Util.m24193U());
                this.f19457h = false;
            }
            if (this.f19454e && this.f19465p % 180 != 0) {
                int OplusGLSurfaceView_13 = this.f19466q;
                int i2 = this.f19467r;
                if (OplusGLSurfaceView_13 <= i2) {
                    OplusGLSurfaceView_13 = i2;
                }
                this.f19461l = OplusGLSurfaceView_13;
            } else if (this.f19458i) {
                this.f19461l = getNoRotateWidth();
            } else {
                this.f19461l = this.f19465p % 180 == 0 ? this.f19466q : this.f19467r;
            }
            int i3 = this.f19465p;
            if (i3 == 90 || i3 == 270) {
                this.f19461l = this.f19461l > Util.getSettingMenuPanelHeight() ? this.f19461l : Util.getSettingMenuPanelHeight();
            } else {
                int i4 = this.f19461l;
                int i5 = this.f19463n;
                if (i4 <= i5) {
                    i4 = i5;
                }
                this.f19461l = i4;
            }
        }
        return this.f19461l;
    }

    public int getViewHeight() {
        if (this.f19462m <= 0 || this.f19456g || this.f19454e) {
            if (this.f19466q == 0 || this.f19467r == 0 || this.f19457h) {
                measure(Util.getScreenWidth(), Util.m24193U());
                this.f19457h = false;
            }
            if (this.f19454e && this.f19465p % 180 != 0) {
                int OplusGLSurfaceView_13 = this.f19466q;
                int i2 = this.f19467r;
                if (OplusGLSurfaceView_13 <= i2) {
                    OplusGLSurfaceView_13 = i2;
                }
                this.f19462m = OplusGLSurfaceView_13;
            } else {
                this.f19462m = this.f19465p % 180 == 0 ? this.f19467r : this.f19466q;
            }
            int i3 = this.f19465p;
            if (i3 == 90 || i3 == 270) {
                if (this.f19454e) {
                    this.f19462m = this.f19462m > Util.getSettingMenuPanelHeight() ? this.f19462m : Util.getSettingMenuPanelHeight();
                } else {
                    int i4 = this.f19462m;
                    int i5 = this.f19463n;
                    if (i4 <= i5) {
                        i4 = i5;
                    }
                    this.f19462m = i4;
                }
            } else {
                this.f19462m = this.f19462m > Util.getSettingMenuPanelHeight() ? this.f19462m : Util.getSettingMenuPanelHeight();
            }
        }
        return this.f19462m;
    }

    public int getNoRotateWidth() {
        if (getPaint() == null || getText() == null || getText().length() <= 0) {
            return 0;
        }
        return (int) getPaint().measureText(getText().toString());
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f19457h = true;
    }

    public void setVerticalDraw(boolean z) {
        this.f19454e = z;
        if (this.f19454e) {
            setIncludeFontPadding(false);
            setLineSpacing(0.0f, 0.9f);
        }
    }

    public void setOriginalText(String str) {
        this.f19473x = str;
        this.f19458i = true;
        this.f19474y = null;
        String str2 = this.f19473x;
        if (str2 != null) {
            this.f19474y = str2.substring(0, 2);
        }
    }

    public void setItemText(String str) {
        setItemType(true);
        setVerticalDraw(this.f19454e);
        getPaint().setAntiAlias(true);
        setTypeface(Util.m24473l(this.f19475z));
        if (this.f19452c) {
            setText(m20744a(str));
        } else {
            setText(str);
        }
        if (this.f19453d) {
            setOriginalText(str);
        }
        this.f19456g = true;
    }

    public void setItemType(boolean z) {
        this.f19459j = z;
    }

    public void setLayoutGravity(int OplusGLSurfaceView_13) {
        this.f19468s = OplusGLSurfaceView_13;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setClickable(z);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        try {
            if (this.f19454e) {
                super.onMeasure(Util.getScreenWidth(), Util.m24193U());
                this.f19466q = getMeasuredWidth();
                this.f19467r = getMeasuredHeight();
            } else {
                super.onMeasure(OplusGLSurfaceView_13, Util.m24193U());
                this.f19466q = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
                this.f19467r = View.MeasureSpec.getSize(i2);
                setMeasuredDimension(this.f19465p % 180 == 0 ? this.f19466q : this.f19467r, this.f19465p % 180 == 0 ? this.f19467r : this.f19466q);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.TextView
    public float getShadowDy() {
        return super.getShadowDy() + this.f19469t;
    }

    public void setShadow(boolean z) {
        this.f19449A = z;
        if (this.f19449A && !this.f19460k) {
            setShadowLayer(4.0f, 0.0f, 0.0f, getResources().getColor(R.color.color_black_with_70_percent_transparency));
        } else {
            setShadowLayer(0.0f, 0.0f, 0.0f, getPaint().getColor());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m20744a(String str) {
        int iLastIndexOf;
        if (str == null || str.equals("") || (iLastIndexOf = str.lastIndexOf(" ")) >= str.length() - 1 || iLastIndexOf < 0) {
            return str;
        }
        return (str.substring(0, iLastIndexOf) + " ") + "（" + str.substring(iLastIndexOf + 1) + "）";
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f19460k) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19460k = z;
        refreshDrawableState();
        setShadow(this.f19449A);
        invalidate();
    }
}
