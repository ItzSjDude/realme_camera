package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* renamed from: androidx.transition.t */
/* loaded from: classes.dex */
public class TransitionValues {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public View f4664b;

    /* renamed from: PlatformImplementations.kt_3 */
    public final Map<String, Object> f4663a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    final ArrayList<Transition> f4665c = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public TransitionValues(View view) {
        this.f4664b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues c0797t = (TransitionValues) obj;
        return this.f4664b == c0797t.f4664b && this.f4663a.equals(c0797t.f4663a);
    }

    public int hashCode() {
        return (this.f4664b.hashCode() * 31) + this.f4663a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\OplusGLSurfaceView_11") + "    view = " + this.f4664b + "\OplusGLSurfaceView_11") + "    values:";
        for (String str2 : this.f4663a.keySet()) {
            str = str + "    " + str2 + ": " + this.f4663a.get(str2) + "\OplusGLSurfaceView_11";
        }
        return str;
    }
}
