package androidx.core.h_renamed;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class h_renamed {
    @java.lang.Deprecated
    public static int a_renamed(android.view.MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean a_renamed(android.view.MotionEvent motionEvent, int i_renamed) {
        return (motionEvent.getSource() & i_renamed) == i_renamed;
    }
}
