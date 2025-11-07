package androidx.fragment.app;

/* compiled from: FragmentContainer.java */
/* loaded from: classes.dex */
public abstract class d_renamed {
    public abstract android.view.View a_renamed(int i_renamed);

    public abstract boolean a_renamed();

    @java.lang.Deprecated
    public androidx.fragment.app.Fragment a_renamed(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        return androidx.fragment.app.Fragment.instantiate(context, str, bundle);
    }
}
