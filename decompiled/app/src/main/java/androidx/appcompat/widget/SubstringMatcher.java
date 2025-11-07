package androidx.appcompat.widget;

/* compiled from: AppCompatHintHelper.java */
/* loaded from: classes.dex */
class k_renamed {
    static android.view.inputmethod.InputConnection a_renamed(android.view.inputmethod.InputConnection inputConnection, android.view.inputmethod.EditorInfo editorInfo, android.view.View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            android.view.ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof android.view.View)) {
                    break;
                }
                if (parent instanceof androidx.appcompat.widget.ay_renamed) {
                    editorInfo.hintText = ((androidx.appcompat.widget.ay_renamed) parent).a_renamed();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
