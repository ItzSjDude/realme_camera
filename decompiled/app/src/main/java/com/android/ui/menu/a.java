package com.android.ui.menu;

/* compiled from: CameraWatermarkDisplayInfoDialog.java */
/* loaded from: classes.dex */
public class a_renamed extends com.coui.appcompat.preference.d_renamed {
    public java.util.Set<java.lang.String> e_renamed = new java.util.HashSet();
    private boolean f_renamed = false;
    private java.lang.CharSequence[] g_renamed = null;
    private java.lang.CharSequence[] h_renamed = null;
    private com.coui.appcompat.widget.toolbar.COUIActionMenuItemView i_renamed = null;
    private com.android.ui.menu.a_renamed.InterfaceC0052a j_renamed = null;

    /* compiled from: CameraWatermarkDisplayInfoDialog.java */
    /* renamed from: com.android.ui.menu.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface InterfaceC0052a {
        void a_renamed(java.lang.String str);

        boolean a_renamed(java.lang.CharSequence charSequence, int i_renamed);

        boolean a_renamed(java.lang.CharSequence charSequence, java.util.Set<java.lang.String> set);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    static /* synthetic */ boolean a_renamed(com.android.ui.menu.a_renamed aVar, int i_renamed) {
        ?? r2 = (byte) (i_renamed | (aVar.f_renamed ? 1 : 0));
        aVar.f_renamed = r2;
        return r2;
    }

    public static com.android.ui.menu.a_renamed b_renamed(java.lang.String str) {
        com.android.ui.menu.a_renamed aVar = new com.android.ui.menu.a_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.coui.appcompat.preference.d_renamed, androidx.preference.d_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        androidx.preference.MultiSelectListPreference multiSelectListPreferenceC = c_renamed();
        if (multiSelectListPreferenceC.h_renamed() == null || multiSelectListPreferenceC.l_renamed() == null) {
            throw new java.lang.IllegalStateException("requires an_renamed entries array and an_renamed entryValues array.");
        }
        if (bundle == null) {
            this.e_renamed.clear();
            this.e_renamed.addAll(multiSelectListPreferenceC.m_renamed());
            this.h_renamed = multiSelectListPreferenceC.l_renamed();
            this.f_renamed = false;
        } else {
            this.e_renamed.clear();
            this.e_renamed.addAll(bundle.getStringArrayList("CameraWatermarkDisplayInfoDialog.values"));
            this.f_renamed = bundle.getBoolean("CameraWatermarkDisplayInfoDialog.changed", false);
            this.h_renamed = bundle.getCharSequenceArray("CameraWatermarkDisplayInfoDialog.entryValues");
        }
        this.g_renamed = multiSelectListPreferenceC.h_renamed();
    }

    @Override // androidx.preference.d_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("CameraWatermarkDisplayInfoDialog.values", new java.util.ArrayList<>(this.e_renamed));
        bundle.putBoolean("CameraWatermarkDisplayInfoDialog.changed", this.f_renamed);
        bundle.putCharSequenceArray("CameraWatermarkDisplayInfoDialog.entries", this.g_renamed);
        bundle.putCharSequenceArray("CameraWatermarkDisplayInfoDialog.entryValues", this.h_renamed);
    }

    private androidx.preference.MultiSelectListPreference c_renamed() {
        return (androidx.preference.MultiSelectListPreference) b_renamed();
    }

    @Override // androidx.preference.d_renamed, androidx.preference.f_renamed
    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
        super.a_renamed(aVar);
        int length = this.h_renamed.length;
        boolean[] zArr = new boolean[length];
        if (this.j_renamed != null) {
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                zArr[i_renamed] = this.j_renamed.a_renamed(this.h_renamed[i_renamed], this.e_renamed);
            }
        }
        aVar.setMultiChoiceItems(this.g_renamed, zArr, new android.content.DialogInterface.OnMultiChoiceClickListener() { // from class: com.android.ui.menu.a_renamed.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2, boolean z_renamed) {
                if (z_renamed) {
                    com.android.ui.menu.a_renamed aVar2 = com.android.ui.menu.a_renamed.this;
                    com.android.ui.menu.a_renamed.a_renamed(aVar2, aVar2.e_renamed.add(com.android.ui.menu.a_renamed.this.h_renamed[i2].toString()) ? 1 : 0);
                } else {
                    com.android.ui.menu.a_renamed aVar3 = com.android.ui.menu.a_renamed.this;
                    com.android.ui.menu.a_renamed.a_renamed(aVar3, aVar3.e_renamed.remove(com.android.ui.menu.a_renamed.this.h_renamed[i2].toString()) ? 1 : 0);
                }
                if (com.android.ui.menu.a_renamed.this.i_renamed != null) {
                    com.android.ui.menu.a_renamed.this.i_renamed.setEnabled(!com.android.ui.menu.a_renamed.this.e_renamed.isEmpty());
                }
                if (com.android.ui.menu.a_renamed.this.e_renamed.isEmpty()) {
                    com.oplus.camera.util.o_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed(), com.android.ui.menu.a_renamed.this.getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_display_info_tip));
                }
            }
        });
    }

    @Override // com.coui.appcompat.preference.d_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = (com.coui.appcompat.widget.toolbar.COUIToolbar) dialogOnCreateDialog.findViewById(com.oplus.camera.R_renamed.id_renamed.toolbar);
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = (androidx.recyclerview.widget.COUIRecyclerView) dialogOnCreateDialog.findViewById(com.oplus.camera.R_renamed.id_renamed.select_dialog_listview);
        this.i_renamed = (com.coui.appcompat.widget.toolbar.COUIActionMenuItemView) cOUIToolbar.findViewById(com.oplus.camera.R_renamed.id_renamed.menu_save);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) cOUIRecyclerView.getParent();
        com.android.ui.menu.a_renamed.b_renamed bVar = new com.android.ui.menu.a_renamed.b_renamed(getActivity());
        viewGroup.addView(bVar, new android.view.ViewGroup.MarginLayoutParams(-1, -1));
        viewGroup.removeView(cOUIRecyclerView);
        bVar.addView(cOUIRecyclerView, cOUIRecyclerView.getLayoutParams());
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.coui.appcompat.widget.toolbar.COUIActionMenuItemView cOUIActionMenuItemView = this.i_renamed;
        if (cOUIActionMenuItemView != null) {
            cOUIActionMenuItemView.setEnabled(!this.e_renamed.isEmpty());
        }
    }

    @Override // androidx.preference.d_renamed, androidx.preference.f_renamed
    public void a_renamed(boolean z_renamed) {
        if (z_renamed && this.f_renamed) {
            androidx.preference.MultiSelectListPreference multiSelectListPreferenceC = c_renamed();
            if (multiSelectListPreferenceC.b_renamed((java.lang.Object) this.e_renamed)) {
                multiSelectListPreferenceC.a_renamed(this.e_renamed);
            }
        }
        com.android.ui.menu.a_renamed.InterfaceC0052a interfaceC0052a = this.j_renamed;
        if (interfaceC0052a != null) {
            interfaceC0052a.a_renamed(z_renamed ? "0" : "1");
        }
        this.f_renamed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.j_renamed = null;
    }

    public void a_renamed(com.android.ui.menu.a_renamed.InterfaceC0052a interfaceC0052a) {
        this.j_renamed = interfaceC0052a;
    }

    /* compiled from: CameraWatermarkDisplayInfoDialog.java */
    public class b_renamed extends android.widget.LinearLayout {
        public b_renamed(android.content.Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            if (getChildAt(0) instanceof androidx.recyclerview.widget.RecyclerView) {
                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) getChildAt(0);
                int childCount = recyclerView.getChildCount();
                int x_renamed = (int) motionEvent.getX();
                int y_renamed = (int) motionEvent.getY();
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= childCount) {
                        break;
                    }
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) recyclerView.getChildAt(i_renamed);
                    android.graphics.Rect rect = new android.graphics.Rect();
                    viewGroup.getHitRect(rect);
                    if (rect.contains(x_renamed, y_renamed)) {
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            android.view.View childAt = viewGroup.getChildAt(i2);
                            if (childAt instanceof com.coui.appcompat.widget.COUICheckBox) {
                                return com.android.ui.menu.a_renamed.this.j_renamed.a_renamed(com.android.ui.menu.a_renamed.this.g_renamed[i_renamed], ((com.coui.appcompat.widget.COUICheckBox) childAt).getState());
                            }
                        }
                    } else {
                        i_renamed++;
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }
}
