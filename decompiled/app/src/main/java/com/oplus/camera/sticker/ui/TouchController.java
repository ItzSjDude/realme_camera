package com.oplus.camera.sticker.ui;

/* compiled from: StickerRecycleBinDialog.java */
/* loaded from: classes2.dex */
public class l_renamed extends android.app.Dialog implements androidx.appcompat.widget.Toolbar.c_renamed, com.oplus.camera.sticker.ui.k_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f5572a = 2;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f5573b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.FooterGridView f5574c;
    private com.oplus.camera.sticker.ui.k_renamed d_renamed;
    private com.oplus.camera.sticker.ui.l_renamed.a_renamed e_renamed;
    private android.content.Context f_renamed;
    private com.coui.appcompat.widget.toolbar.COUIToolbar g_renamed;
    private com.coui.appcompat.dialog.app.b_renamed h_renamed;

    /* compiled from: StickerRecycleBinDialog.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(int i_renamed, boolean z_renamed);

        void b_renamed(int i_renamed, boolean z_renamed);
    }

    public l_renamed(android.content.Context context) {
        super(context, com.oplus.camera.R_renamed.style.StickerRecycleDialogStyle);
        this.f5574c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.f_renamed = context;
    }

    @Override // androidx.appcompat.widget.Toolbar.c_renamed
    public boolean a_renamed(android.view.MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == com.oplus.camera.R_renamed.id_renamed.sticker_cancel) {
            dismiss();
            return true;
        }
        if (itemId != com.oplus.camera.R_renamed.id_renamed.sticker_select_all) {
            return true;
        }
        if (h_renamed()) {
            this.d_renamed.b_renamed();
            return true;
        }
        this.d_renamed.a_renamed();
        this.e_renamed.a_renamed();
        return true;
    }

    public void a_renamed(com.oplus.camera.sticker.ui.l_renamed.a_renamed aVar) {
        this.e_renamed = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getContext().getColor(com.oplus.camera.R_renamed.color.sticker_recycle_bin_background_color));
        getWindow().setUiOptions(1);
        setContentView(com.oplus.camera.R_renamed.layout.editor_sticker_recycle_bin_layout);
        getWindow().setNavigationBarColor(0);
        f_renamed();
    }

    private void f_renamed() {
        this.g_renamed = (com.coui.appcompat.widget.toolbar.COUIToolbar) findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_recycle_toolbar);
        com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = this.g_renamed;
        if (cOUIToolbar != null) {
            cOUIToolbar.showOverflowMenu();
            this.g_renamed.setIsTitleCenterStyle(true);
            this.g_renamed.inflateMenu(com.oplus.camera.R_renamed.menu.sticker_menu);
            this.g_renamed.setTitle(com.oplus.camera.R_renamed.string.sticker_recycle_bin_title_select);
            this.g_renamed.setTitleTextColor(getContext().getColor(com.oplus.camera.R_renamed.color.sticker_recycle_bin_title_text_color));
            this.g_renamed.setOnMenuItemClickListener(this);
        }
        this.f5574c = (com.oplus.camera.sticker.ui.FooterGridView) findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_recycle_bin_grid_view);
        this.d_renamed = new com.oplus.camera.sticker.ui.k_renamed(getContext(), com.oplus.camera.sticker.g_renamed.a_renamed(getContext(), 1L), true);
        this.d_renamed.a_renamed(this);
        com.oplus.camera.sticker.ui.FooterGridView footerGridView = this.f5574c;
        if (footerGridView != null) {
            footerGridView.setDrawForeground(false);
            this.f5574c.setAdapter((android.widget.BaseAdapter) this.d_renamed);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a_renamed();
    }

    @Override // android.app.Dialog
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        new android.view.MenuInflater(getContext()).inflate(com.oplus.camera.R_renamed.menu.sticker_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void a_renamed() {
        android.widget.CheckedTextView checkedTextView = (android.widget.CheckedTextView) findViewById(com.oplus.camera.R_renamed.id_renamed.delete_sticker);
        if (checkedTextView != null) {
            checkedTextView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.l_renamed.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.sticker.ui.l_renamed.this.i_renamed();
                }
            });
            com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
            if (kVar != null && kVar.d_renamed() == 0) {
                checkedTextView.setClickable(false);
                checkedTextView.setChecked(false);
                checkedTextView.setTextColor(getContext().getColor(com.oplus.camera.R_renamed.color.sticker_recycle_bin_unchecked_color));
            } else {
                checkedTextView.setClickable(true);
                checkedTextView.setChecked(true);
                checkedTextView.setTextColor(-1);
            }
        }
        final com.coui.appcompat.widget.COUICheckBox cOUICheckBox = (com.coui.appcompat.widget.COUICheckBox) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_select_all);
        androidx.appcompat.view.menu.b_renamed bVar = (androidx.appcompat.view.menu.b_renamed) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_cancel);
        if (bVar != null) {
            bVar.setTextColor(getContext().getColor(com.oplus.camera.R_renamed.color.sticker_recycle_bin_title_text_color));
        }
        if (cOUICheckBox != null) {
            cOUICheckBox.setOnStateChangeListener(new com.coui.appcompat.widget.COUICheckBox.a_renamed() { // from class: com.oplus.camera.sticker.ui.l_renamed.2
                @Override // com.coui.appcompat.widget.COUICheckBox.a_renamed
                public void a_renamed(com.coui.appcompat.widget.COUICheckBox cOUICheckBox2, int i_renamed) {
                    if (com.oplus.camera.sticker.ui.l_renamed.this.d_renamed == null) {
                        return;
                    }
                    if (i_renamed == com.oplus.camera.sticker.ui.l_renamed.f5572a) {
                        com.oplus.camera.sticker.ui.l_renamed.this.d_renamed.a_renamed();
                        return;
                    }
                    if (i_renamed == com.oplus.camera.sticker.ui.l_renamed.f5573b) {
                        cOUICheckBox.setState(i_renamed);
                        if (com.oplus.camera.sticker.ui.l_renamed.this.g_renamed() || com.oplus.camera.sticker.ui.l_renamed.this.h_renamed()) {
                            com.oplus.camera.sticker.ui.l_renamed.this.d_renamed.b_renamed();
                        }
                    }
                }
            });
            cOUICheckBox.setState(h_renamed() ? f5572a : f5573b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g_renamed() {
        com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
        return kVar != null && kVar.d_renamed() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h_renamed() {
        com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
        return kVar != null && kVar.c_renamed();
    }

    public void b_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.h_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.h_renamed.cancel();
            this.h_renamed = null;
            i_renamed();
        } else {
            this.h_renamed = null;
        }
        a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.f_renamed).f_renamed(1).setNeutralButton(com.oplus.camera.R_renamed.string.sticker_recycle_bin_delete_sticker, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.sticker.ui.l_renamed.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    com.oplus.camera.sticker.ui.l_renamed.this.j_renamed();
                    com.oplus.camera.sticker.ui.l_renamed.this.h_renamed = null;
                }
            }).setNegativeButton(com.oplus.camera.R_renamed.string.sticker_recycle_bin_cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.sticker.ui.l_renamed.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    if (com.oplus.camera.sticker.ui.l_renamed.this.d_renamed != null && com.oplus.camera.sticker.ui.l_renamed.this.e_renamed != null) {
                        com.oplus.camera.sticker.ui.l_renamed.this.e_renamed.b_renamed(com.oplus.camera.sticker.ui.l_renamed.this.d_renamed.e_renamed().size(), com.oplus.camera.sticker.ui.l_renamed.this.d_renamed.c_renamed());
                    }
                    com.oplus.camera.sticker.ui.l_renamed.this.h_renamed = null;
                }
            }).create();
        }
        if (this.h_renamed.isShowing()) {
            return;
        }
        this.h_renamed.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
        if (kVar != null) {
            java.util.Map<java.lang.String, com.oplus.camera.sticker.data.StickerItem> mapE = kVar.e_renamed();
            if (mapE.size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<com.oplus.camera.sticker.data.StickerItem> it = mapE.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                com.oplus.camera.sticker.h_renamed.a_renamed(this.f_renamed).a_renamed(arrayList);
                com.oplus.camera.sticker.ui.l_renamed.a_renamed aVar = this.e_renamed;
                if (aVar != null) {
                    aVar.a_renamed(arrayList.size(), this.d_renamed.c_renamed());
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.e_renamed("StickerRecycleBinDialog", "deleteSelectedStickers, size is_renamed 0!");
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
        if (kVar != null) {
            kVar.f_renamed();
        }
        com.coui.appcompat.dialog.app.b_renamed bVar2 = this.h_renamed;
        if (bVar2 != null) {
            bVar2.cancel();
            this.h_renamed = null;
        }
        super.dismiss();
    }

    @Override // com.oplus.camera.sticker.ui.k_renamed.a_renamed
    public void a_renamed(com.oplus.camera.sticker.ui.k_renamed kVar) throws android.content.res.Resources.NotFoundException {
        if (kVar == null) {
            return;
        }
        int iD = kVar.d_renamed();
        java.lang.String string = getContext().getString(com.oplus.camera.R_renamed.string.sticker_recycle_bin_title_select);
        if (iD > 0) {
            string = getContext().getResources().getQuantityString(com.oplus.camera.R_renamed.plurals.sticker_recycle_bin_title_has_selected, iD, java.lang.Integer.valueOf(iD));
        }
        this.g_renamed.setTitle(string);
        a_renamed();
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (stickerItem == null || !isShowing()) {
            return;
        }
        com.oplus.camera.sticker.ui.k_renamed kVar = this.d_renamed;
        if (kVar != null && kVar.getCount() == 0) {
            dismiss();
        }
        com.oplus.camera.sticker.ui.k_renamed kVar2 = this.d_renamed;
        if (kVar2 != null) {
            kVar2.a_renamed(stickerItem);
        }
    }

    public void c_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.cancel();
            this.h_renamed = null;
        }
    }
}
