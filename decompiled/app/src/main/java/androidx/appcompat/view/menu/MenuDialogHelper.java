package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import com.heytap.accessory.CommonStatusCodes;

/* compiled from: MenuDialogHelper.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    ListMenuPresenter f1362a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MenuBuilder f1363b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AlertDialog f1364c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MenuPresenter.PlatformImplementations.kt_3 f1365d;

    public MenuDialogHelper(MenuBuilder c0236h) {
        this.f1363b = c0236h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1158a(IBinder iBinder) {
        MenuBuilder c0236h = this.f1363b;
        AlertDialog.PlatformImplementations.kt_3 aVar = new AlertDialog.PlatformImplementations.kt_3(c0236h.getContext());
        this.f1362a = new ListMenuPresenter(aVar.getContext(), R.layout.abc_list_menu_item_layout);
        this.f1362a.setCallback(this);
        this.f1363b.addMenuPresenter(this.f1362a);
        aVar.setAdapter(this.f1362a.m1147a(), this);
        View headerView = c0236h.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(c0236h.getHeaderIcon()).setTitle(c0236h.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        this.f1364c = aVar.create();
        this.f1364c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1364c.getWindow().getAttributes();
        attributes.type = CommonStatusCodes.TIME_EXPIRED;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1364c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (OplusGLSurfaceView_13 == 82 || OplusGLSurfaceView_13 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1364c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1364c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1363b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1363b.performShortcut(OplusGLSurfaceView_13, keyEvent, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1157a() {
        AlertDialog dialogInterfaceC0204b = this.f1364c;
        if (dialogInterfaceC0204b != null) {
            dialogInterfaceC0204b.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1362a.onCloseMenu(this.f1363b, true);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo861a(MenuBuilder c0236h, boolean z) {
        if (z || c0236h == this.f1363b) {
            m1157a();
        }
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1365d;
        if (aVar != null) {
            aVar.mo861a(c0236h, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo862a(MenuBuilder c0236h) {
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1365d;
        if (aVar != null) {
            return aVar.mo862a(c0236h);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
        this.f1363b.performItemAction((MenuItemImpl) this.f1362a.m1147a().getItem(OplusGLSurfaceView_13), 0);
    }
}
