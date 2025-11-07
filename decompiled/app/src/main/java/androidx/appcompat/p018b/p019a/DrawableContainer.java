package androidx.appcompat.p018b.p019a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

/* compiled from: DrawableContainer.java */
/* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class DrawableContainer extends Drawable implements Drawable.Callback {

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 f1107a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Rect f1108b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable f1109c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f1110d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1112f;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f1115i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Runnable f1116j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f1117k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f1118l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f1119m;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1111e = 255;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f1113g = -1;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f1114h = -1;

    DrawableContainer() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1110d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f1107a.getChangingConfigurations() | super.getChangingConfigurations();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1009a() {
        return isAutoMirrored() && DrawableCompat.m2583i(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectM1032f = this.f1107a.m1032f();
        if (rectM1032f != null) {
            rect.set(rectM1032f);
            padding = (rectM1032f.right | ((rectM1032f.left | rectM1032f.top) | rectM1032f.bottom)) != 0;
        } else {
            Drawable drawable = this.f1109c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (m1009a()) {
            int OplusGLSurfaceView_13 = rect.left;
            rect.left = rect.right;
            rect.right = OplusGLSurfaceView_13;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        if (this.f1112f && this.f1111e == OplusGLSurfaceView_13) {
            return;
        }
        this.f1112f = true;
        this.f1111e = OplusGLSurfaceView_13;
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            if (this.f1117k == 0) {
                drawable.setAlpha(OplusGLSurfaceView_13);
            } else {
                m1011a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1111e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f1107a.f1156z != z) {
            IntrinsicsJvm.kt_4 bVar = this.f1107a;
            bVar.f1156z = z;
            Drawable drawable = this.f1109c;
            if (drawable != null) {
                drawable.setDither(bVar.f1156z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IntrinsicsJvm.kt_4 bVar = this.f1107a;
        bVar.f1128G = true;
        if (bVar.f1127F != colorFilter) {
            this.f1107a.f1127F = colorFilter;
            Drawable drawable = this.f1109c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        IntrinsicsJvm.kt_4 bVar = this.f1107a;
        bVar.f1131J = true;
        if (bVar.f1129H != colorStateList) {
            this.f1107a.f1129H = colorStateList;
            DrawableCompat.m2570a(this.f1109c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        IntrinsicsJvm.kt_4 bVar = this.f1107a;
        bVar.f1132K = true;
        if (bVar.f1130I != mode) {
            this.f1107a.f1130I = mode;
            DrawableCompat.m2573a(this.f1109c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1110d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1109c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1107a.m1040n();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f1107a.f1126E != z) {
            IntrinsicsJvm.kt_4 bVar = this.f1107a;
            bVar.f1126E = z;
            Drawable drawable = this.f1109c;
            if (drawable != null) {
                DrawableCompat.m2574a(drawable, bVar.f1126E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1107a.f1126E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f1110d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1110d = null;
            this.f1114h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1109c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1112f) {
                this.f1109c.setAlpha(this.f1111e);
            }
        }
        if (this.f1118l != 0) {
            this.f1118l = 0L;
            z = true;
        }
        if (this.f1117k != 0) {
            this.f1117k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float COUIBaseListPopupWindow_12, float f2) {
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            DrawableCompat.m2567a(drawable, COUIBaseListPopupWindow_12, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Rect rect = this.f1108b;
        if (rect == null) {
            this.f1108b = new Rect(OplusGLSurfaceView_13, i2, i3, i4);
        } else {
            rect.set(OplusGLSurfaceView_13, i2, i3, i4);
        }
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            DrawableCompat.m2569a(drawable, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1108b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1110d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1109c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int OplusGLSurfaceView_13) {
        Drawable drawable = this.f1110d;
        if (drawable != null) {
            return drawable.setLevel(OplusGLSurfaceView_13);
        }
        Drawable drawable2 = this.f1109c;
        if (drawable2 != null) {
            return drawable2.setLevel(OplusGLSurfaceView_13);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int OplusGLSurfaceView_13) {
        return this.f1107a.m1029d(OplusGLSurfaceView_13, m1013d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1107a.m1033g()) {
            return this.f1107a.m1034h();
        }
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1107a.m1033g()) {
            return this.f1107a.m1035i();
        }
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1107a.m1033g()) {
            return this.f1107a.m1036j();
        }
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1107a.m1033g()) {
            return this.f1107a.m1037k();
        }
        Drawable drawable = this.f1109c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        IntrinsicsJvm.kt_4 bVar = this.f1107a;
        if (bVar != null) {
            bVar.m1023b();
        }
        if (drawable != this.f1109c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
        if (drawable != this.f1109c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, OplusGLSurfaceView_15);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1109c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f1110d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1109c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1109c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1107a.m1039m();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    int m1013d() {
        return this.f1113g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1012a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f1113g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f1107a.f1125D > 0) {
            Drawable drawable = this.f1110d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f1109c;
            if (drawable2 != null) {
                this.f1110d = drawable2;
                this.f1114h = this.f1113g;
                this.f1118l = this.f1107a.f1125D + jUptimeMillis;
            } else {
                this.f1110d = null;
                this.f1114h = -1;
                this.f1118l = 0L;
            }
        } else {
            Drawable drawable3 = this.f1109c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f1107a.f1140j) {
            Drawable drawableM1022b = this.f1107a.m1022b(OplusGLSurfaceView_13);
            this.f1109c = drawableM1022b;
            this.f1113g = OplusGLSurfaceView_13;
            if (drawableM1022b != null) {
                if (this.f1107a.f1124C > 0) {
                    this.f1117k = jUptimeMillis + this.f1107a.f1124C;
                }
                m1008a(drawableM1022b);
            }
        } else {
            this.f1109c = null;
            this.f1113g = -1;
        }
        if (this.f1117k != 0 || this.f1118l != 0) {
            Runnable runnable = this.f1116j;
            if (runnable == null) {
                this.f1116j = new Runnable() { // from class: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainer.this.m1011a(true);
                        DrawableContainer.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            m1011a(true);
        }
        invalidateSelf();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1008a(Drawable drawable) {
        if (this.f1119m == null) {
            this.f1119m = new PlatformImplementations.kt_3();
        }
        drawable.setCallback(this.f1119m.m1015a(drawable.getCallback()));
        try {
            if (this.f1107a.f1124C <= 0 && this.f1112f) {
                drawable.setAlpha(this.f1111e);
            }
            if (this.f1107a.f1128G) {
                drawable.setColorFilter(this.f1107a.f1127F);
            } else {
                if (this.f1107a.f1131J) {
                    DrawableCompat.m2570a(drawable, this.f1107a.f1129H);
                }
                if (this.f1107a.f1132K) {
                    DrawableCompat.m2573a(drawable, this.f1107a.f1130I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1107a.f1156z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f1107a.f1126E);
            }
            Rect rect = this.f1108b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f1119m.m1014a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m1011a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1112f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1109c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f1117k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1111e
            r3.setAlpha(r9)
            r13.f1117k = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 r9 = r13.f1107a
            int r9 = r9.f1124C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f1109c
            int r3 = 255 - r3
            int r10 = r13.f1111e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = r0
            goto L3b
        L38:
            r13.f1117k = r7
        L3a:
            r3 = r6
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f1110d
            if (r9 == 0) goto L68
            long r10 = r13.f1118l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L55
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1110d = r0
            r0 = -1
            r13.f1114h = r0
            r13.f1118l = r7
            goto L6a
        L55:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 r4 = r13.f1107a
            int r4 = r4.f1125D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.f1110d
            int r5 = r13.f1111e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L6b
        L68:
            r13.f1118l = r7
        L6a:
            r0 = r3
        L6b:
            if (r14 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.Runnable r14 = r13.f1116j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p018b.p019a.DrawableContainer.m1011a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1109c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m1010a(Resources resources) {
        this.f1107a.m1020a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f1107a.m1019a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1107a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f1107a.m1041o()) {
            return null;
        }
        this.f1107a.f1136f = getChangingConfigurations();
        return this.f1107a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1115i && super.mutate() == this) {
            IntrinsicsJvm.kt_4 bVarMo991c = mo991c();
            bVarMo991c.mo1000a();
            mo988a(bVarMo991c);
            this.f1115i = true;
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    IntrinsicsJvm.kt_4 mo991c() {
        return this.f1107a;
    }

    void clearMutated() {
        this.f1107a.m1030e();
        this.f1115i = false;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    static abstract class IntrinsicsJvm.kt_4 extends Drawable.ConstantState {

        /* renamed from: A */
        boolean f1122A;

        /* renamed from: B */
        int f1123B;

        /* renamed from: C */
        int f1124C;

        /* renamed from: D */
        int f1125D;

        /* renamed from: E */
        boolean f1126E;

        /* renamed from: F */
        ColorFilter f1127F;

        /* renamed from: G */
        boolean f1128G;

        /* renamed from: H */
        ColorStateList f1129H;

        /* renamed from: I */
        PorterDuff.Mode f1130I;

        /* renamed from: J */
        boolean f1131J;

        /* renamed from: K */
        boolean f1132K;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final DrawableContainer f1133c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        Resources f1134d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f1135e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f1136f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        int f1137g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        SparseArray<Drawable.ConstantState> f1138h;

        /* renamed from: OplusGLSurfaceView_13 */
        Drawable[] f1139i;

        /* renamed from: OplusGLSurfaceView_15 */
        int f1140j;

        /* renamed from: OplusGLSurfaceView_5 */
        boolean f1141k;

        /* renamed from: OplusGLSurfaceView_14 */
        boolean f1142l;

        /* renamed from: OplusGLSurfaceView_6 */
        Rect f1143m;

        /* renamed from: OplusGLSurfaceView_11 */
        boolean f1144n;

        /* renamed from: o */
        boolean f1145o;

        /* renamed from: p */
        int f1146p;

        /* renamed from: q */
        int f1147q;

        /* renamed from: r */
        int f1148r;

        /* renamed from: s */
        int f1149s;

        /* renamed from: t */
        boolean f1150t;

        /* renamed from: u */
        int f1151u;

        /* renamed from: v */
        boolean f1152v;

        /* renamed from: w */
        boolean f1153w;

        /* renamed from: x */
        boolean f1154x;

        /* renamed from: y */
        boolean f1155y;

        /* renamed from: z */
        boolean f1156z;

        IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_4 bVar, DrawableContainer c0216b, Resources resources) {
            Resources resources2;
            this.f1135e = 160;
            this.f1141k = false;
            this.f1144n = false;
            this.f1156z = true;
            this.f1124C = 0;
            this.f1125D = 0;
            this.f1133c = c0216b;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = bVar != null ? bVar.f1134d : null;
            }
            this.f1134d = resources2;
            this.f1135e = DrawableContainer.m1007a(resources, bVar != null ? bVar.f1135e : 0);
            if (bVar != null) {
                this.f1136f = bVar.f1136f;
                this.f1137g = bVar.f1137g;
                this.f1154x = true;
                this.f1155y = true;
                this.f1141k = bVar.f1141k;
                this.f1144n = bVar.f1144n;
                this.f1156z = bVar.f1156z;
                this.f1122A = bVar.f1122A;
                this.f1123B = bVar.f1123B;
                this.f1124C = bVar.f1124C;
                this.f1125D = bVar.f1125D;
                this.f1126E = bVar.f1126E;
                this.f1127F = bVar.f1127F;
                this.f1128G = bVar.f1128G;
                this.f1129H = bVar.f1129H;
                this.f1130I = bVar.f1130I;
                this.f1131J = bVar.f1131J;
                this.f1132K = bVar.f1132K;
                if (bVar.f1135e == this.f1135e) {
                    if (bVar.f1142l) {
                        this.f1143m = new Rect(bVar.f1143m);
                        this.f1142l = true;
                    }
                    if (bVar.f1145o) {
                        this.f1146p = bVar.f1146p;
                        this.f1147q = bVar.f1147q;
                        this.f1148r = bVar.f1148r;
                        this.f1149s = bVar.f1149s;
                        this.f1145o = true;
                    }
                }
                if (bVar.f1150t) {
                    this.f1151u = bVar.f1151u;
                    this.f1150t = true;
                }
                if (bVar.f1152v) {
                    this.f1153w = bVar.f1153w;
                    this.f1152v = true;
                }
                Drawable[] drawableArr = bVar.f1139i;
                this.f1139i = new Drawable[drawableArr.length];
                this.f1140j = bVar.f1140j;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.f1138h;
                if (sparseArray != null) {
                    this.f1138h = sparseArray.clone();
                } else {
                    this.f1138h = new SparseArray<>(this.f1140j);
                }
                int OplusGLSurfaceView_13 = this.f1140j;
                for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f1138h.put(i2, constantState);
                        } else {
                            this.f1139i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f1139i = new Drawable[10];
            this.f1140j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1137g | this.f1136f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final int m1018a(Drawable drawable) {
            int OplusGLSurfaceView_13 = this.f1140j;
            if (OplusGLSurfaceView_13 >= this.f1139i.length) {
                mo1031e(OplusGLSurfaceView_13, OplusGLSurfaceView_13 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1133c);
            this.f1139i[OplusGLSurfaceView_13] = drawable;
            this.f1140j++;
            this.f1137g = drawable.getChangingConfigurations() | this.f1137g;
            m1023b();
            this.f1143m = null;
            this.f1142l = false;
            this.f1145o = false;
            this.f1154x = false;
            return OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m1023b() {
            this.f1150t = false;
            this.f1152v = false;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        final int m1025c() {
            return this.f1139i.length;
        }

        /* renamed from: p */
        private void m1017p() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1138h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    this.f1139i[this.f1138h.keyAt(OplusGLSurfaceView_13)] = m1016b(this.f1138h.valueAt(OplusGLSurfaceView_13).newDrawable(this.f1134d));
                }
                this.f1138h = null;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Drawable m1016b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f1123B);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f1133c);
            return drawableMutate;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final int m1027d() {
            return this.f1140j;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final Drawable m1022b(int OplusGLSurfaceView_13) {
            int iIndexOfKey;
            Drawable drawable = this.f1139i[OplusGLSurfaceView_13];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1138h;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(OplusGLSurfaceView_13)) < 0) {
                return null;
            }
            Drawable drawableM1016b = m1016b(this.f1138h.valueAt(iIndexOfKey).newDrawable(this.f1134d));
            this.f1139i[OplusGLSurfaceView_13] = drawableM1016b;
            this.f1138h.removeAt(iIndexOfKey);
            if (this.f1138h.size() == 0) {
                this.f1138h = null;
            }
            return drawableM1016b;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        final boolean m1029d(int OplusGLSurfaceView_13, int i2) {
            int i3 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(OplusGLSurfaceView_13) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f1123B = OplusGLSurfaceView_13;
            return z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final void m1020a(Resources resources) {
            if (resources != null) {
                this.f1134d = resources;
                int iM1007a = DrawableContainer.m1007a(resources, this.f1135e);
                int OplusGLSurfaceView_13 = this.f1135e;
                this.f1135e = iM1007a;
                if (OplusGLSurfaceView_13 != iM1007a) {
                    this.f1145o = false;
                    this.f1142l = false;
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final void m1019a(Resources.Theme theme) {
            if (theme != null) {
                m1017p();
                int OplusGLSurfaceView_13 = this.f1140j;
                Drawable[] drawableArr = this.f1139i;
                for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f1137g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                m1020a(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f1138h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1000a() {
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.f1122A = true;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        final void m1030e() {
            this.f1122A = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final void m1021a(boolean z) {
            this.f1141k = z;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public final Rect m1032f() {
            if (this.f1141k) {
                return null;
            }
            if (this.f1143m != null || this.f1142l) {
                return this.f1143m;
            }
            m1017p();
            Rect rect = new Rect();
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.f1142l = true;
            this.f1143m = rect2;
            return rect2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final void m1024b(boolean z) {
            this.f1144n = z;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public final boolean m1033g() {
            return this.f1144n;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public final int m1034h() {
            if (!this.f1145o) {
                m1038l();
            }
            return this.f1146p;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public final int m1035i() {
            if (!this.f1145o) {
                m1038l();
            }
            return this.f1147q;
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public final int m1036j() {
            if (!this.f1145o) {
                m1038l();
            }
            return this.f1148r;
        }

        /* renamed from: OplusGLSurfaceView_5 */
        public final int m1037k() {
            if (!this.f1145o) {
                m1038l();
            }
            return this.f1149s;
        }

        /* renamed from: OplusGLSurfaceView_14 */
        protected void m1038l() {
            this.f1145o = true;
            m1017p();
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            this.f1147q = -1;
            this.f1146p = -1;
            this.f1149s = 0;
            this.f1148r = 0;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1146p) {
                    this.f1146p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1147q) {
                    this.f1147q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1148r) {
                    this.f1148r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1149s) {
                    this.f1149s = minimumHeight;
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final void m1026c(int OplusGLSurfaceView_13) {
            this.f1124C = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final void m1028d(int OplusGLSurfaceView_13) {
            this.f1125D = OplusGLSurfaceView_13;
        }

        /* renamed from: OplusGLSurfaceView_6 */
        public final int m1039m() {
            if (this.f1150t) {
                return this.f1151u;
            }
            m1017p();
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            int opacity = OplusGLSurfaceView_13 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < OplusGLSurfaceView_13; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f1151u = opacity;
            this.f1150t = true;
            return opacity;
        }

        /* renamed from: OplusGLSurfaceView_11 */
        public final boolean m1040n() {
            if (this.f1152v) {
                return this.f1153w;
            }
            m1017p();
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= OplusGLSurfaceView_13) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.f1153w = z;
            this.f1152v = true;
            return z;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo1031e(int OplusGLSurfaceView_13, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f1139i, 0, drawableArr, 0, OplusGLSurfaceView_13);
            this.f1139i = drawableArr;
        }

        /* renamed from: o */
        public synchronized boolean m1041o() {
            if (this.f1154x) {
                return this.f1155y;
            }
            m1017p();
            this.f1154x = true;
            int OplusGLSurfaceView_13 = this.f1140j;
            Drawable[] drawableArr = this.f1139i;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f1155y = false;
                    return false;
                }
            }
            this.f1155y = true;
            return true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo988a(IntrinsicsJvm.kt_4 bVar) {
        this.f1107a = bVar;
        int OplusGLSurfaceView_13 = this.f1113g;
        if (OplusGLSurfaceView_13 >= 0) {
            this.f1109c = bVar.m1022b(OplusGLSurfaceView_13);
            Drawable drawable = this.f1109c;
            if (drawable != null) {
                m1008a(drawable);
            }
        }
        this.f1114h = -1;
        this.f1110d = null;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements Drawable.Callback {

        /* renamed from: PlatformImplementations.kt_3 */
        private Drawable.Callback f1121a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m1015a(Drawable.Callback callback) {
            this.f1121a = callback;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable.Callback m1014a() {
            Drawable.Callback callback = this.f1121a;
            this.f1121a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
            Drawable.Callback callback = this.f1121a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, OplusGLSurfaceView_15);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1121a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m1007a(Resources resources, int OplusGLSurfaceView_13) {
        if (resources != null) {
            OplusGLSurfaceView_13 = resources.getDisplayMetrics().densityDpi;
        }
        if (OplusGLSurfaceView_13 == 0) {
            return 160;
        }
        return OplusGLSurfaceView_13;
    }
}
