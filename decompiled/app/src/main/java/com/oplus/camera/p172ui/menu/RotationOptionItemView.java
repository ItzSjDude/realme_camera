package com.oplus.camera.p172ui.menu;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.util.Util;

/* compiled from: RotationOptionItemView.java */
/* renamed from: com.oplus.camera.ui.menu.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class RotationOptionItemView extends LottieAnimationView implements InverseAble {

    /* renamed from: A */
    private Bitmap f19377A;

    /* renamed from: B */
    private Bitmap f19378B;

    /* renamed from: C */
    private Bitmap f19379C;

    /* renamed from: D */
    private Paint f19380D;

    /* renamed from: E */
    private String f19381E;

    /* renamed from: F */
    private Paint f19382F;

    /* renamed from: G */
    private String f19383G;

    /* renamed from: H */
    private String f19384H;

    /* renamed from: I */
    private Paint f19385I;

    /* renamed from: J */
    private Paint f19386J;

    /* renamed from: K */
    private Paint f19387K;

    /* renamed from: L */
    private Paint f19388L;

    /* renamed from: M */
    private Paint f19389M;

    /* renamed from: N */
    private Paint f19390N;

    /* renamed from: O */
    private Matrix f19391O;

    /* renamed from: P */
    private ComboPreferences f19392P;

    /* renamed from: Q */
    private ValueAnimator f19393Q;

    /* renamed from: R */
    private ValueAnimator f19394R;

    /* renamed from: S */
    private ValueAnimator f19395S;

    /* renamed from: T */
    private String f19396T;

    /* renamed from: U */
    private int f19397U;

    /* renamed from: V */
    private int f19398V;

    /* renamed from: W */
    private int f19399W;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PathInterpolator f19400a;

    /* renamed from: aa */
    private int f19401aa;

    /* renamed from: ab */
    private int f19402ab;

    /* renamed from: ac */
    private int f19403ac;

    /* renamed from: ad */
    private int f19404ad;

    /* renamed from: ae */
    private int f19405ae;

    /* renamed from: af */
    private int f19406af;

    /* renamed from: ag */
    private int f19407ag;

    /* renamed from: ah */
    private int f19408ah;

    /* renamed from: ai */
    private int f19409ai;

    /* renamed from: aj */
    private int f19410aj;

    /* renamed from: ak */
    private long f19411ak;

    /* renamed from: al */
    private long f19412al;

    /* renamed from: am */
    private float f19413am;

    /* renamed from: an */
    private int[] f19414an;

    /* renamed from: ao */
    private CameraUIListener f19415ao;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArgbEvaluator f19416b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ValueAnimator f19417c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PathInterpolator f19418d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f19419e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f19420f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f19421g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f19422h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f19423i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f19424j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f19425k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f19426l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19427m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f19428n;

    /* renamed from: o */
    private boolean f19429o;

    /* renamed from: p */
    private boolean f19430p;

    /* renamed from: q */
    private boolean f19431q;

    /* renamed from: r */
    private boolean f19432r;

    /* renamed from: s */
    private Context f19433s;

    /* renamed from: t */
    private Canvas f19434t;

    /* renamed from: u */
    private Drawable f19435u;

    /* renamed from: v */
    private Drawable f19436v;

    /* renamed from: w */
    private Bitmap f19437w;

    /* renamed from: x */
    private Bitmap f19438x;

    /* renamed from: y */
    private Bitmap f19439y;

    /* renamed from: z */
    private Bitmap f19440z;

    public RotationOptionItemView(Context context, CameraUIListener cameraUIListener, boolean z, Bitmap bitmap, boolean z2, boolean z3, ComboPreferences comboPreferences) throws Resources.NotFoundException {
        super(context);
        this.f19400a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19416b = new ArgbEvaluator();
        this.f19417c = null;
        this.f19418d = new PathInterpolator(0.28f, 0.0f, 0.17f, 1.0f);
        this.f19419e = 0.0f;
        this.f19420f = 1.0f;
        this.f19421g = 0.0f;
        this.f19422h = false;
        this.f19423i = false;
        this.f19424j = false;
        this.f19425k = false;
        this.f19426l = false;
        this.f19427m = false;
        this.f19428n = false;
        this.f19429o = false;
        this.f19430p = false;
        this.f19431q = false;
        this.f19432r = false;
        this.f19433s = null;
        this.f19434t = null;
        this.f19435u = null;
        this.f19436v = null;
        this.f19437w = null;
        this.f19438x = null;
        this.f19439y = null;
        this.f19440z = null;
        this.f19377A = null;
        this.f19378B = null;
        this.f19379C = null;
        this.f19380D = new Paint();
        this.f19381E = null;
        this.f19382F = null;
        this.f19383G = null;
        this.f19384H = null;
        this.f19385I = null;
        this.f19386J = null;
        this.f19387K = null;
        this.f19388L = null;
        this.f19389M = null;
        this.f19390N = null;
        this.f19391O = null;
        this.f19392P = null;
        this.f19393Q = null;
        this.f19394R = null;
        this.f19395S = null;
        this.f19396T = null;
        this.f19397U = 0;
        this.f19398V = 0;
        this.f19399W = 0;
        this.f19401aa = 0;
        this.f19402ab = 0;
        this.f19403ac = 0;
        this.f19404ad = 0;
        this.f19405ae = 0;
        this.f19406af = 0;
        this.f19407ag = 0;
        this.f19408ah = 0;
        this.f19409ai = 0;
        this.f19410aj = 0;
        this.f19411ak = 0L;
        this.f19412al = 0L;
        this.f19413am = 0.5f;
        this.f19414an = null;
        this.f19415ao = null;
        this.f19433s = context;
        this.f19415ao = cameraUIListener;
        this.f19423i = z;
        this.f19439y = bitmap;
        this.f19425k = z2;
        this.f19392P = comboPreferences;
        this.f19430p = z3;
        if (this.f19423i) {
            this.f19404ad = this.f19433s.getResources().getDimensionPixelSize(R.dimen.sub_menu_layout_height);
            this.f19403ac = this.f19433s.getResources().getDimensionPixelSize(R.dimen.sub_menu_item_layout_width);
        } else {
            this.f19404ad = this.f19433s.getResources().getDimensionPixelSize(R.dimen.menu_indicator_layout_height);
            this.f19403ac = this.f19433s.getResources().getDimensionPixelSize(R.dimen.menu_indicator_layout_width);
        }
        this.f19384H = this.f19433s.getResources().getString(R.string.camera_sub_setting_menu_description_setting_title);
        this.f19406af = this.f19433s.getResources().getDimensionPixelSize(R.dimen.sub_menu_text_length);
        this.f19407ag = this.f19433s.getResources().getDimensionPixelSize(R.dimen.sub_menu_text_length_land);
        m20724k();
        m20725l();
        m20726m();
        this.f19414an = new int[2];
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m20724k() {
        setLayerType(1, null);
        this.f19386J = new Paint();
        this.f19386J.setMaskFilter(new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.OUTER));
        this.f19386J.setColor(getResources().getColor(R.color.color_black_with_70_percent_transparency));
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m20725l() {
        this.f19387K = new Paint();
        this.f19387K.setAntiAlias(true);
        this.f19388L = new Paint();
        this.f19388L.setAntiAlias(true);
        this.f19388L.setColor(getResources().getColor(R.color.color_black_with_30_percent_transparency));
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m20726m() throws Resources.NotFoundException {
        if (this.f19423i) {
            this.f19402ab = this.f19433s.getResources().getDimensionPixelSize(R.dimen.sub_menu_layout_height);
        } else {
            this.f19402ab = Util.getSettingMenuPanelHeight();
        }
        int dimensionPixelSize = this.f19433s.getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
        int dimensionPixelSize2 = 0;
        if (Util.m24346ai() && !this.f19423i) {
            dimensionPixelSize2 = this.f19433s.getResources().getDimensionPixelSize(R.dimen.ear_screen_menu_offset);
            dimensionPixelSize = 0;
        } else if (this.f19423i) {
            dimensionPixelSize = 0;
        }
        float measuredHeight = (int) ((this.f19402ab - getMeasuredHeight()) / 2.0f);
        if (this.f19402ab > 0) {
            this.f19413am = ((((getMeasuredHeight() / 2.0f) + measuredHeight) + dimensionPixelSize2) + dimensionPixelSize) / this.f19402ab;
        }
    }

    public void setShadowOn(boolean z) {
        this.f19430p = z;
    }

    public boolean getShadowOn() {
        return this.f19430p;
    }

    public void setMenuName(String str) {
        this.f19383G = str;
    }

    public void setSwitchIconNeedAnim(boolean z) {
        this.f19426l = z;
    }

    public void setOffAnimIcon(Bitmap bitmap) {
        this.f19440z = bitmap;
        Bitmap bitmap2 = this.f19440z;
        if (bitmap2 != null) {
            this.f19378B = Bitmap.createScaledBitmap(bitmap2.extractAlpha(), this.f19440z.getWidth(), this.f19440z.getHeight(), true);
        }
    }

    public void setLottieIconNeedAnim(boolean z) {
        this.f19432r = z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m20741h() {
        return this.f19432r;
    }

    public float getPivotYScaleValue() {
        return this.f19413am;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m20727n() {
        if (this.f19394R == null) {
            this.f19394R = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f19394R.setInterpolator(this.f19418d);
            this.f19394R.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.OplusGLSurfaceView_13.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RotationOptionItemView.this.f19420f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    RotationOptionItemView.this.postInvalidate();
                }
            });
            this.f19394R.setDuration(583L);
        }
        this.f19394R.cancel();
        this.f19394R.start();
    }

    /* renamed from: o */
    private void m20728o() {
        if (this.f19395S == null) {
            this.f19395S = ValueAnimator.ofFloat(0.001f, 1.0f);
            this.f19395S.setInterpolator(this.f19418d);
            this.f19395S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.OplusGLSurfaceView_13.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RotationOptionItemView.this.f19421g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    RotationOptionItemView.this.postInvalidate();
                }
            });
            this.f19395S.setDuration(583L);
        }
        this.f19395S.cancel();
        this.f19395S.start();
        this.f19431q = true;
    }

    /* renamed from: p */
    private void m20729p() {
        if (this.f19393Q == null) {
            this.f19393Q = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f19393Q.setInterpolator(this.f19418d);
            this.f19393Q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.OplusGLSurfaceView_13.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RotationOptionItemView.this.f19419e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    RotationOptionItemView.this.postInvalidate();
                }
            });
            this.f19393Q.setDuration(583L);
        }
        this.f19393Q.cancel();
        this.f19393Q.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20738a(Drawable drawable, boolean z) {
        if (this.f19426l) {
            this.f19431q = false;
            this.f19435u = this.f19436v;
            this.f19437w = this.f19438x;
        }
        if (drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        this.f19425k = z;
        refreshDrawableState();
        setImageDrawable(drawable);
        this.f19438x = Util.m24215a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        this.f19434t = new Canvas(this.f19438x);
        m20730q();
        this.f19436v = drawable;
        if (this.f19424j) {
            this.f19424j = false;
            if (this.f19425k) {
                if (this.f19439y != null) {
                    m20729p();
                }
            } else {
                m20727n();
                if (this.f19426l && !this.f19436v.equals(this.f19435u)) {
                    m20728o();
                }
            }
        } else {
            if (this.f19425k) {
                this.f19419e = 1.0f;
                this.f19420f = 0.0f;
            } else {
                this.f19419e = 0.0f;
                this.f19420f = 1.0f;
            }
            if (this.f19426l && !this.f19436v.equals(this.f19435u)) {
                m20728o();
            }
        }
        invalidate();
    }

    /* renamed from: q */
    private void m20730q() {
        Drawable drawable = getDrawable();
        if (m5517d() || drawable == null || (drawable instanceof LottieDrawable)) {
            return;
        }
        if (this.f19438x == null) {
            this.f19438x = Util.m24215a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.f19438x.setDensity(Util.f22962a);
            this.f19434t = new Canvas(this.f19438x);
        }
        drawable.setBounds(0, 0, this.f19434t.getWidth(), this.f19434t.getHeight());
        this.f19434t.drawColor(0, BlendMode.CLEAR);
        drawable.draw(this.f19434t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20739a(boolean z, int OplusGLSurfaceView_13, int i2) {
        if (z) {
            if (this.f19385I == null) {
                this.f19385I = new Paint();
                this.f19385I.setAntiAlias(true);
                this.f19385I.setColor(this.f19433s.getResources().getColor(R.color.camera_red_dot_hint_color, null));
            }
        } else {
            this.f19385I = null;
        }
        boolean z2 = this.f19427m != z;
        this.f19427m = z;
        this.f19408ah = OplusGLSurfaceView_13;
        this.f19409ai = i2;
        if (z2) {
            invalidate();
        }
    }

    public void setItemText(String str) {
        if (TextUtils.equals(this.f19381E, str)) {
            return;
        }
        this.f19381E = str;
        m20734u();
        m20735v();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z && m5517d() && !this.f19432r) {
            m5518e();
        }
        setClickable(z);
        setAlpha(z ? 1.0f : 0.5f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20737a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f19399W) {
            return;
        }
        this.f19399W = i2;
        m20735v();
        if (isShown() && z) {
            this.f19398V = this.f19397U;
            this.f19411ak = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f19399W - this.f19397U;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f19422h = i3 >= 0;
            this.f19412al = this.f19411ak + ((Math.abs(i3) * 1000) / 360);
        } else {
            this.f19397U = this.f19399W;
        }
        m20743j();
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f19401aa = i3 - OplusGLSurfaceView_13;
        this.f19402ab = i4 - i2;
    }

    public void setKey(String str) {
        this.f19396T = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0470  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.RotationOptionItemView.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: r */
    private boolean m20731r() {
        CameraUIListener cameraUIListener = this.f19415ao;
        int iMo10816ca = cameraUIListener != null ? cameraUIListener.mo10816ca() : 0;
        if (2 == iMo10816ca) {
            int OplusGLSurfaceView_13 = this.f19405ae;
            if (5 == OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13) {
                return true;
            }
        } else if (3 == iMo10816ca) {
            int i2 = this.f19405ae;
            if (i2 == 0 || 1 == i2) {
                return true;
            }
        } else if (4 == iMo10816ca) {
            if (this.f19415ao.mo10769bL().mo16630q()) {
                return true;
            }
        } else if (5 == this.f19405ae) {
            return true;
        }
        return false;
    }

    /* renamed from: s */
    private void m20732s() {
        if (this.f19377A == null) {
            this.f19377A = Util.m24215a(this.f19440z.getWidth(), this.f19440z.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f19377A);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(getContext().getColor(R.color.inverse_text_color), PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.f19440z, 0.0f, 0.0f, paint);
        }
    }

    /* renamed from: t */
    private void m20733t() {
        this.f19382F.setColor(this.f19433s.getColorStateList(R.color.menu_item_text_color_selector).getColorForState(getDrawableState(), R.color.oplus_submenu_text_color));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        CameraUIListener cameraUIListener = this.f19415ao;
        if (cameraUIListener != null && cameraUIListener.mo10873p() && (actionMasked = motionEvent.getActionMasked()) != 3 && actionMasked != 2) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        if (motionEvent.getActionMasked() == 3 && isEnabled()) {
            setAlpha(1.0f);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f19439y != null) {
            Rect rect = new Rect();
            getHitRect(rect);
            if (1 == motionEvent.getAction() && (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) || 1 == this.f19415ao.mo10816ca())) {
                this.f19424j = true;
            }
        }
        if (isEnabled()) {
            if (!this.f19423i) {
                Rect rect2 = (Rect) getTag(R.id_renamed.touch_area_tag);
                if (!rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    CameraLog.m12959b("RotationOptionItemView", "onTouchEvent, The click area is not included in the hot rect: " + rect2.toString() + ", x: " + motionEvent.getX() + ", y: " + motionEvent.getY() + ", mItemYOffset: " + this.f19410aj + ", mLayoutHeight:" + this.f19404ad + ", sSettingMenuItemHeight: " + Util.m24189Q());
                    getDrawingRect(rect2);
                    if (!rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        CameraLog.m12959b("RotationOptionItemView", "onTouchEvent, The click area is not included in the drawing rect, the drawing zone: " + rect2.toString());
                        return true;
                    }
                }
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                setAlpha(0.3f);
            } else if (action == 1 || (action != 2 && action == 3)) {
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public Object getTag(int OplusGLSurfaceView_13) {
        if (R.id_renamed.touch_area_tag == OplusGLSurfaceView_13) {
            Rect rect = new Rect();
            getDrawingRect(rect);
            if (rect.right == 0 && rect.bottom == 0) {
                CameraLog.m12959b("RotationOptionItemView", "getTag, left: " + rect.left + ", top: " + rect.top + ", right: " + rect.right + ", bottom: " + rect.bottom);
                rect.right = this.f19403ac;
                rect.bottom = Util.m24189Q();
            }
            return new Rect(rect.left, rect.top + (((Util.m24189Q() / 2) + this.f19410aj) - (this.f19404ad / 2)), rect.right, rect.bottom + this.f19404ad);
        }
        return super.getTag(OplusGLSurfaceView_13);
    }

    public int getViewWidth() {
        Bitmap bitmap = this.f19438x;
        int width = bitmap != null ? 0 + bitmap.getWidth() : 0;
        if (!TextUtils.isEmpty(this.f19381E)) {
            width = Math.max(width, (int) this.f19382F.measureText(this.f19381E));
        }
        if (this.f19423i) {
            int OplusGLSurfaceView_13 = this.f19406af;
            return width > OplusGLSurfaceView_13 ? OplusGLSurfaceView_13 : this.f19403ac;
        }
        return Math.max(width, this.f19403ac);
    }

    public int getViewHeight() {
        Bitmap bitmap = this.f19438x;
        int height = bitmap != null ? 0 + bitmap.getHeight() : 0;
        if (!TextUtils.isEmpty(this.f19381E)) {
            height = (int) (height + (this.f19382F.getFontMetrics().bottom - this.f19382F.getFontMetrics().top));
        }
        int OplusGLSurfaceView_13 = this.f19404ad;
        return height > OplusGLSurfaceView_13 ? height : OplusGLSurfaceView_13;
    }

    /* renamed from: u */
    private void m20734u() {
        if (this.f19382F == null) {
            this.f19382F = new Paint();
            this.f19382F.setTextSize(this.f19433s.getResources().getDimension(R.dimen.rotableview_text_size));
            this.f19382F.setTextAlign(Paint.Align.CENTER);
            this.f19382F.setFlags(1);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        if (this.f19382F == null) {
            m20734u();
        }
        super.setSelected(z);
        invalidate();
    }

    /* renamed from: v */
    private void m20735v() {
        if (TextUtils.isEmpty(this.f19381E)) {
            return;
        }
        this.f19382F.setTextSize(this.f19433s.getResources().getDimension(R.dimen.rotableview_text_size));
        int iMeasureText = (int) this.f19382F.measureText(this.f19381E);
        if (this.f19399W % 180 == 0 || iMeasureText < Util.m24189Q()) {
            return;
        }
        this.f19382F.setTextSize(this.f19433s.getResources().getDimension(R.dimen.rotableview_text_size_small));
    }

    public void setSizeRatioType(int OplusGLSurfaceView_13) {
        int i2;
        this.f19405ae = OplusGLSurfaceView_13;
        if (1 == this.f19415ao.mo10816ca()) {
            if (this.f19415ao.mo10769bL().mo16570k() == 0 && !this.f19428n && ((i2 = this.f19405ae) == 0 || 1 == i2)) {
                this.f19387K.setColor(getResources().getColor(R.color.color_white_with_20_percent_transparency));
            } else if (270 == this.f19415ao.mo10769bL().mo16570k() && !this.f19428n && this.f19414an[0] < 350 && 1 == this.f19405ae) {
                this.f19387K.setColor(getResources().getColor(R.color.color_white_with_20_percent_transparency));
            } else if (90 == this.f19415ao.mo10769bL().mo16570k() && !this.f19428n && this.f19414an[0] > 1440 && 1 == this.f19405ae) {
                this.f19387K.setColor(getResources().getColor(R.color.color_white_with_20_percent_transparency));
            } else {
                this.f19387K.setColor(getResources().getColor(R.color.color_black_with_30_percent_transparency));
            }
        }
        if (m20731r()) {
            if ("off".equals(this.f19392P.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                this.f19388L.setColor(this.f19433s.getColor(R.color.color_black_with_30_percent_transparency));
            } else {
                this.f19388L.setColor(this.f19433s.getColor(R.color.color_black_with_0_percent_transparency));
            }
        }
        postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20740a(final boolean z, boolean z2, int OplusGLSurfaceView_13) {
        ValueAnimator valueAnimator = this.f19417c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f19417c.end();
        }
        final int color = this.f19433s.getColor(R.color.color_black_with_30_percent_transparency);
        final int color2 = this.f19433s.getColor(R.color.color_black_with_0_percent_transparency);
        int color3 = this.f19388L.getColor();
        if (z && color3 == color) {
            return;
        }
        if ((z || color3 != color2) && z2 && m20731r()) {
            ArgbEvaluator argbEvaluator = this.f19416b;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? color2 : color);
            objArr[1] = Integer.valueOf(z ? color : color2);
            this.f19417c = ValueAnimator.ofObject(argbEvaluator, objArr);
            this.f19417c.setInterpolator(this.f19400a);
            this.f19417c.setDuration(OplusGLSurfaceView_13);
            this.f19417c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.OplusGLSurfaceView_13.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RotationOptionItemView.this.f19388L.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                    RotationOptionItemView.this.postInvalidate();
                }
            });
            this.f19417c.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.OplusGLSurfaceView_13.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RotationOptionItemView.this.f19388L.setColor(z ? color : color2);
                    RotationOptionItemView.this.postInvalidate();
                }
            });
            this.f19417c.start();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m20742i() {
        this.f19433s = null;
        this.f19438x = null;
        this.f19434t = null;
        this.f19382F = null;
        this.f19381E = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 2);
        if (this.f19428n && ((this.f19439y == null || !this.f19425k) && m20736w())) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        if (this.f19429o) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_style_second});
        }
        return iArrOnCreateDrawableState;
    }

    public void setStateSecond(boolean z) {
        this.f19429o = z;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19428n = z;
        refreshDrawableState();
        setSizeRatioType(this.f19405ae);
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m20743j() {
        getLocationOnScreen(this.f19414an);
        setSizeRatioType(this.f19405ae);
    }

    /* renamed from: w */
    private boolean m20736w() {
        CameraUIListener cameraUIListener = this.f19415ao;
        switch (cameraUIListener != null ? cameraUIListener.mo10769bL().mo16516h() : ApsConstant.CAPTURE_MODE_COMMON) {
            case "out":
                int OplusGLSurfaceView_13 = this.f19405ae;
                if (2 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) {
                    return true;
                }
                break;
            case "full":
                int i2 = this.f19405ae;
                if (1 == i2 || i2 == 0) {
                    return true;
                }
                break;
            case "left":
            case "right":
                int i3 = this.f19405ae;
                if (2 == i3 || 6 == i3) {
                    return true;
                }
                break;
            case "rack90":
            case "rack270":
                return true;
            case "full90":
            case "full270":
            case "low90":
            case "low270":
                break;
            default:
                if (5 != this.f19405ae) {
                    return true;
                }
                break;
        }
        return false;
    }
}
