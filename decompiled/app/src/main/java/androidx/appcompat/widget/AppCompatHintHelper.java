package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* compiled from: AppCompatHintHelper.java */
/* renamed from: androidx.appcompat.widget.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
class AppCompatHintHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    static InputConnection m1679a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof WithHint) {
                    editorInfo.hintText = ((WithHint) parent).m1625a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
