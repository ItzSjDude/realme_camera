package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* renamed from: androidx.appcompat.widget.ag */
/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f1790a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MenuItemHoverListener f1791b;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1790a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.OplusGLSurfaceView_13("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    /* renamed from: PlatformImplementations.kt_3 */
    DropDownListView mo1424a(Context context, boolean z) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1454a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1764g.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1455b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1764g.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1453a(MenuItemHoverListener interfaceC0310af) {
        this.f1791b = interfaceC0310af;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1456c(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1790a;
            if (method != null) {
                try {
                    method.invoke(this.f1764g, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.OplusGLSurfaceView_13("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.f1764g.setTouchModal(z);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1145b(MenuBuilder c0236h, MenuItem menuItem) {
        MenuItemHoverListener interfaceC0310af = this.f1791b;
        if (interfaceC0310af != null) {
            interfaceC0310af.mo1145b(c0236h, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1144a(MenuBuilder c0236h, MenuItem menuItem) {
        MenuItemHoverListener interfaceC0310af = this.f1791b;
        if (interfaceC0310af != null) {
            interfaceC0310af.mo1144a(c0236h, menuItem);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.ag$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends DropDownListView {

        /* renamed from: IntrinsicsJvm.kt_4 */
        final int f1792b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final int f1793c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private MenuItemHoverListener f1794d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private MenuItem f1795e;

        @Override // androidx.appcompat.widget.DropDownListView
        /* renamed from: PlatformImplementations.kt_3 */
        public /* bridge */ /* synthetic */ int mo1408a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
            return super.mo1408a(OplusGLSurfaceView_13, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        /* renamed from: PlatformImplementations.kt_3 */
        public /* bridge */ /* synthetic */ boolean mo1409a(MotionEvent motionEvent, int OplusGLSurfaceView_13) {
            return super.mo1409a(motionEvent, OplusGLSurfaceView_13);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public PlatformImplementations.kt_3(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f1792b = 21;
                this.f1793c = 22;
            } else {
                this.f1792b = 22;
                this.f1793c = 21;
            }
        }

        public void setHoverListener(MenuItemHoverListener interfaceC0310af) {
            this.f1794d = interfaceC0310af;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && OplusGLSurfaceView_13 == this.f1792b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && OplusGLSurfaceView_13 == this.f1793c) {
                setSelection(-1);
                ((MenuAdapter) getAdapter()).m1153a().close(false);
                return true;
            }
            return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            MenuAdapter c0235g;
            int iPointToPosition;
            int OplusGLSurfaceView_13;
            if (this.f1794d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0235g = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0235g = (MenuAdapter) adapter;
                }
                MenuItemImpl item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (OplusGLSurfaceView_13 = iPointToPosition - headersCount) >= 0 && OplusGLSurfaceView_13 < c0235g.getCount()) {
                    item = c0235g.getItem(OplusGLSurfaceView_13);
                }
                MenuItem menuItem = this.f1795e;
                if (menuItem != item) {
                    MenuBuilder c0236hM1153a = c0235g.m1153a();
                    if (menuItem != null) {
                        this.f1794d.mo1144a(c0236hM1153a, menuItem);
                    }
                    this.f1795e = item;
                    if (item != null) {
                        this.f1794d.mo1145b(c0236hM1153a, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
