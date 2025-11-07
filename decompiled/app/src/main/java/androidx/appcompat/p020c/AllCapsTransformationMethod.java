package androidx.appcompat.p020c;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: AllCapsTransformationMethod.java */
/* renamed from: androidx.appcompat.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: PlatformImplementations.kt_3 */
    private Locale f1160a;

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int OplusGLSurfaceView_13, Rect rect) {
    }

    public AllCapsTransformationMethod(Context context) {
        this.f1160a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1160a);
        }
        return null;
    }
}
