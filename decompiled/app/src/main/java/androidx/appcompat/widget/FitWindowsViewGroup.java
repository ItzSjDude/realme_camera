package androidx.appcompat.widget;

import android.graphics.Rect;

/* compiled from: FitWindowsViewGroup.java */
/* renamed from: androidx.appcompat.widget.ac */
/* loaded from: classes.dex */
public interface FitWindowsViewGroup {

    /* compiled from: FitWindowsViewGroup.java */
    /* renamed from: androidx.appcompat.widget.ac$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo849a(Rect rect);
    }

    void setOnFitSystemWindowsListener(PlatformImplementations.kt_3 aVar);
}
