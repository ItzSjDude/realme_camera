package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: WrappedDrawableState.java */
/* renamed from: androidx.core.graphics.drawable.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: PlatformImplementations.kt_3 */
    int f2966a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Drawable.ConstantState f2967b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ColorStateList f2968c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    PorterDuff.Mode f2969d;

    WrappedDrawableState(WrappedDrawableState c0469f) {
        this.f2968c = null;
        this.f2969d = WrappedDrawableApi14.f2958a;
        if (c0469f != null) {
            this.f2966a = c0469f.f2966a;
            this.f2967b = c0469f.f2967b;
            this.f2968c = c0469f.f2968c;
            this.f2969d = c0469f.f2969d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new WrappedDrawableApi21(this, resources);
        }
        return new WrappedDrawableApi14(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int OplusGLSurfaceView_13 = this.f2966a;
        Drawable.ConstantState constantState = this.f2967b;
        return (constantState != null ? constantState.getChangingConfigurations() : 0) | OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m2591a() {
        return this.f2967b != null;
    }
}
