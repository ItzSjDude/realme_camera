package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* compiled from: BlendModeColorFilterCompat.java */
/* renamed from: androidx.core.graphics.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class BlendModeColorFilterCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorFilter m2540a(int OplusGLSurfaceView_13, BlendModeCompat enumC0461b) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode blendModeM2541a = BlendModeUtils.m2541a(enumC0461b);
            if (blendModeM2541a != null) {
                return new BlendModeColorFilter(OplusGLSurfaceView_13, blendModeM2541a);
            }
            return null;
        }
        PorterDuff.Mode modeM2542b = BlendModeUtils.m2542b(enumC0461b);
        if (modeM2542b != null) {
            return new PorterDuffColorFilter(OplusGLSurfaceView_13, modeM2542b);
        }
        return null;
    }
}
