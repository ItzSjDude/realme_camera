package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* compiled from: DecorContentParent.java */
/* renamed from: androidx.appcompat.widget.y */
/* loaded from: classes.dex */
public interface DecorContentParent {
    /* renamed from: PlatformImplementations.kt_3 */
    void mo1233a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo1234a(Menu menu, MenuPresenter.PlatformImplementations.kt_3 aVar);

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo1239e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean mo1240f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean mo1241g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean mo1242h();

    /* renamed from: OplusGLSurfaceView_13 */
    boolean mo1243i();

    /* renamed from: OplusGLSurfaceView_15 */
    void mo1244j();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo1245k();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
