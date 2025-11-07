package com.oplus.camera.sticker.p168ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.widget.COUICheckBox;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.sticker.StickerItemDBHelper;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.p168ui.StickerRecycleBinAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: StickerRecycleBinDialog.java */
/* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class StickerRecycleBinDialog extends Dialog implements Toolbar.InterfaceC0302c, StickerRecycleBinAdapter.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f16475a = 2;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f16476b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private FooterGridView f16477c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private StickerRecycleBinAdapter f16478d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PlatformImplementations.kt_3 f16479e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f16480f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIToolbar f16481g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIAlertDialog f16482h;

    /* compiled from: StickerRecycleBinDialog.java */
    /* renamed from: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12658a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12659a(int OplusGLSurfaceView_13, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12660b(int OplusGLSurfaceView_13, boolean z);
    }

    public StickerRecycleBinDialog(Context context) {
        super(context, R.style.StickerRecycleDialogStyle);
        this.f16477c = null;
        this.f16478d = null;
        this.f16479e = null;
        this.f16480f = null;
        this.f16481g = null;
        this.f16482h = null;
        this.f16480f = context;
    }

    @Override // androidx.appcompat.widget.Toolbar.InterfaceC0302c
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo935a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id_renamed.sticker_cancel) {
            dismiss();
            return true;
        }
        if (itemId != R.id_renamed.sticker_select_all) {
            return true;
        }
        if (m17178h()) {
            this.f16478d.m17159b();
            return true;
        }
        this.f16478d.m17156a();
        this.f16479e.mo12658a();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17183a(PlatformImplementations.kt_3 aVar) {
        this.f16479e = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getContext().getColor(R.color.sticker_recycle_bin_background_color));
        getWindow().setUiOptions(1);
        setContentView(R.layout.editor_sticker_recycle_bin_layout);
        getWindow().setNavigationBarColor(0);
        m17175f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m17175f() {
        this.f16481g = (COUIToolbar) findViewById(R.id_renamed.sticker_recycle_toolbar);
        COUIToolbar cOUIToolbar = this.f16481g;
        if (cOUIToolbar != null) {
            cOUIToolbar.showOverflowMenu();
            this.f16481g.setIsTitleCenterStyle(true);
            this.f16481g.inflateMenu(R.menu.sticker_menu);
            this.f16481g.setTitle(R.string.sticker_recycle_bin_title_select);
            this.f16481g.setTitleTextColor(getContext().getColor(R.color.sticker_recycle_bin_title_text_color));
            this.f16481g.setOnMenuItemClickListener(this);
        }
        this.f16477c = (FooterGridView) findViewById(R.id_renamed.sticker_recycle_bin_grid_view);
        this.f16478d = new StickerRecycleBinAdapter(getContext(), StickerItemDBHelper.m16949a(getContext(), 1L), true);
        this.f16478d.m17158a(this);
        FooterGridView footerGridView = this.f16477c;
        if (footerGridView != null) {
            footerGridView.setDrawForeground(false);
            this.f16477c.setAdapter((BaseAdapter) this.f16478d);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m17181a();
    }

    @Override // android.app.Dialog
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(getContext()).inflate(R.menu.sticker_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17181a() {
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id_renamed.delete_sticker);
        if (checkedTextView != null) {
            checkedTextView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StickerRecycleBinDialog.this.m17179i();
                }
            });
            StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
            if (viewOnClickListenerC3018k != null && viewOnClickListenerC3018k.m17161d() == 0) {
                checkedTextView.setClickable(false);
                checkedTextView.setChecked(false);
                checkedTextView.setTextColor(getContext().getColor(R.color.sticker_recycle_bin_unchecked_color));
            } else {
                checkedTextView.setClickable(true);
                checkedTextView.setChecked(true);
                checkedTextView.setTextColor(-1);
            }
        }
        final COUICheckBox cOUICheckBox = (COUICheckBox) this.f16481g.findViewById(R.id_renamed.sticker_select_all);
        ActionMenuItemView viewOnClickListenerC0230b = (ActionMenuItemView) this.f16481g.findViewById(R.id_renamed.sticker_cancel);
        if (viewOnClickListenerC0230b != null) {
            viewOnClickListenerC0230b.setTextColor(getContext().getColor(R.color.sticker_recycle_bin_title_text_color));
        }
        if (cOUICheckBox != null) {
            cOUICheckBox.setOnStateChangeListener(new COUICheckBox.InterfaceC1358a() { // from class: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14.2
                @Override // com.coui.appcompat.widget.COUICheckBox.InterfaceC1358a
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo7029a(COUICheckBox cOUICheckBox2, int OplusGLSurfaceView_13) {
                    if (StickerRecycleBinDialog.this.f16478d == null) {
                        return;
                    }
                    if (OplusGLSurfaceView_13 == StickerRecycleBinDialog.f16475a) {
                        StickerRecycleBinDialog.this.f16478d.m17156a();
                        return;
                    }
                    if (OplusGLSurfaceView_13 == StickerRecycleBinDialog.f16476b) {
                        cOUICheckBox.setState(OplusGLSurfaceView_13);
                        if (StickerRecycleBinDialog.this.m17177g() || StickerRecycleBinDialog.this.m17178h()) {
                            StickerRecycleBinDialog.this.f16478d.m17159b();
                        }
                    }
                }
            });
            cOUICheckBox.setState(m17178h() ? f16475a : f16476b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m17177g() {
        StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
        return viewOnClickListenerC3018k != null && viewOnClickListenerC3018k.m17161d() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m17178h() {
        StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
        return viewOnClickListenerC3018k != null && viewOnClickListenerC3018k.m17160c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17184b() {
        COUIAlertDialog dialogInterfaceC1289b = this.f16482h;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f16482h.cancel();
            this.f16482h = null;
            m17179i();
        } else {
            this.f16482h = null;
        }
        m17181a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m17179i() {
        if (this.f16482h == null) {
            this.f16482h = new COUIAlertDialog.PlatformImplementations.kt_3(this.f16480f).m6600f(1).setNeutralButton(R.string.sticker_recycle_bin_delete_sticker, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    StickerRecycleBinDialog.this.m17180j();
                    StickerRecycleBinDialog.this.f16482h = null;
                }
            }).setNegativeButton(R.string.sticker_recycle_bin_cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.sticker.ui.OplusGLSurfaceView_14.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    if (StickerRecycleBinDialog.this.f16478d != null && StickerRecycleBinDialog.this.f16479e != null) {
                        StickerRecycleBinDialog.this.f16479e.mo12660b(StickerRecycleBinDialog.this.f16478d.m17162e().size(), StickerRecycleBinDialog.this.f16478d.m17160c());
                    }
                    StickerRecycleBinDialog.this.f16482h = null;
                }
            }).create();
        }
        if (this.f16482h.isShowing()) {
            return;
        }
        this.f16482h.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m17180j() {
        StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
        if (viewOnClickListenerC3018k != null) {
            Map<String, StickerItem> mapM17162e = viewOnClickListenerC3018k.m17162e();
            if (mapM17162e.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<StickerItem> it = mapM17162e.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                StickerMediator.m16958a(this.f16480f).m16964a(arrayList);
                PlatformImplementations.kt_3 aVar = this.f16479e;
                if (aVar != null) {
                    aVar.mo12659a(arrayList.size(), this.f16478d.m17160c());
                    return;
                }
                return;
            }
            CameraLog.m12966e("StickerRecycleBinDialog", "deleteSelectedStickers, size is 0!");
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        COUIAlertDialog dialogInterfaceC1289b = this.f16482h;
        if (dialogInterfaceC1289b != null) {
            dialogInterfaceC1289b.dismiss();
        }
        StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
        if (viewOnClickListenerC3018k != null) {
            viewOnClickListenerC3018k.m17163f();
        }
        COUIAlertDialog dialogInterfaceC1289b2 = this.f16482h;
        if (dialogInterfaceC1289b2 != null) {
            dialogInterfaceC1289b2.cancel();
            this.f16482h = null;
        }
        super.dismiss();
    }

    @Override // com.oplus.camera.sticker.p168ui.StickerRecycleBinAdapter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17164a(StickerRecycleBinAdapter viewOnClickListenerC3018k) throws Resources.NotFoundException {
        if (viewOnClickListenerC3018k == null) {
            return;
        }
        int iM17161d = viewOnClickListenerC3018k.m17161d();
        String string = getContext().getString(R.string.sticker_recycle_bin_title_select);
        if (iM17161d > 0) {
            string = getContext().getResources().getQuantityString(R.plurals.sticker_recycle_bin_title_has_selected, iM17161d, Integer.valueOf(iM17161d));
        }
        this.f16481g.setTitle(string);
        m17181a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17182a(StickerItem stickerItem) {
        if (stickerItem == null || !isShowing()) {
            return;
        }
        StickerRecycleBinAdapter viewOnClickListenerC3018k = this.f16478d;
        if (viewOnClickListenerC3018k != null && viewOnClickListenerC3018k.getCount() == 0) {
            dismiss();
        }
        StickerRecycleBinAdapter viewOnClickListenerC3018k2 = this.f16478d;
        if (viewOnClickListenerC3018k2 != null) {
            viewOnClickListenerC3018k2.m17157a(stickerItem);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17185c() {
        COUIAlertDialog dialogInterfaceC1289b = this.f16482h;
        if (dialogInterfaceC1289b != null) {
            dialogInterfaceC1289b.cancel();
            this.f16482h = null;
        }
    }
}
