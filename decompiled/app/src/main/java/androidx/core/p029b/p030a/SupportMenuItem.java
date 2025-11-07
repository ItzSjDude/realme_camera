package androidx.core.p029b.p030a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p036h.ActionProvider;

/* compiled from: SupportMenuItem.java */
/* renamed from: androidx.core.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public interface SupportMenuItem extends MenuItem {
    /* renamed from: PlatformImplementations.kt_3 */
    SupportMenuItem mo1097a(ActionProvider abstractC0491b);

    /* renamed from: PlatformImplementations.kt_3 */
    SupportMenuItem mo1098a(CharSequence charSequence);

    /* renamed from: PlatformImplementations.kt_3 */
    ActionProvider mo1099a();

    /* renamed from: IntrinsicsJvm.kt_4 */
    SupportMenuItem mo1101b(CharSequence charSequence);

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int OplusGLSurfaceView_13);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c2, int OplusGLSurfaceView_13);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c2, int OplusGLSurfaceView_13);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c2, char c3, int OplusGLSurfaceView_13, int i2);

    @Override // android.view.MenuItem
    void setShowAsAction(int OplusGLSurfaceView_13);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int OplusGLSurfaceView_13);
}
