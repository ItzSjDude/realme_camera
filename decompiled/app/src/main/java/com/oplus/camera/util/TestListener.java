package com.oplus.camera.util;

/* compiled from: ExportPGrantUtil.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7334a = "g_renamed";

    /* compiled from: ExportPGrantUtil.java */
    public interface b_renamed {
        void a_renamed(androidx.appcompat.app.f_renamed fVar);

        void a_renamed(androidx.appcompat.app.f_renamed fVar, boolean z_renamed);
    }

    public static void a_renamed(android.app.Activity activity, java.lang.String str, com.oplus.camera.util.g_renamed.b_renamed bVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.a_renamed(f7334a, "showPermissionGrantDialog, permission: " + str);
            return;
        }
        a_renamed(activity, new java.lang.String[]{str}, bVar);
    }

    public static void a_renamed(android.app.Activity activity, java.lang.String[] strArr, final com.oplus.camera.util.g_renamed.b_renamed bVar) {
        if (activity == null) {
            return;
        }
        if (strArr == null || strArr.length == 0) {
            com.oplus.camera.e_renamed.a_renamed(f7334a, "showPermissionGrantDialog, permissions is_renamed empty..");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(strArr));
        if (arrayList.contains("android.permission.READ_EXTERNAL_STORAGE") && arrayList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
            arrayList.remove("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (arrayList.contains("android.permission.ACCESS_COARSE_LOCATION") && arrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
            arrayList.remove("android.permission.ACCESS_COARSE_LOCATION");
        }
        final com.oplus.camera.util.g_renamed.c_renamed cVar = new com.oplus.camera.util.g_renamed.c_renamed(activity, com.oplus.camera.R_renamed.style.DefaultBottomSheetDialog);
        cVar.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.util.-$$Lambda$g_renamed$4vnD3yW_VK533aRjgqPk4qeg1tc
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                return com.oplus.camera.util.g_renamed.a_renamed(bVar, cVar, dialogInterface, i_renamed, keyEvent);
            }
        });
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.camera_pg_dialog_content_layout, (android.view.ViewGroup) null);
        android.view.View viewFindViewById = viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pg_content_layout);
        com.oplus.camera.ui.modepanel.NonFlingRecycleView nonFlingRecycleView = (com.oplus.camera.ui.modepanel.NonFlingRecycleView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.pg_recycleview);
        nonFlingRecycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity));
        nonFlingRecycleView.setAdapter(new com.oplus.camera.util.g_renamed.a_renamed(activity, arrayList));
        com.coui.appcompat.widget.COUIButton cOUIButton = (com.coui.appcompat.widget.COUIButton) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.btn_confirm);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.txt_exit);
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.txt_title);
        cOUIButton.setText(com.oplus.camera.R_renamed.string.camera_permissition_grant_sure);
        textView.setText(com.oplus.camera.R_renamed.string.camera_permissition_grant_cancel);
        textView2.setText(com.oplus.camera.R_renamed.string.camera_permissition_dialog_title);
        cOUIButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.util.-$$Lambda$g_renamed$WRorQWtfTQjxLDiCnnZlozI6OOw
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.oplus.camera.util.g_renamed.b_renamed(bVar, cVar, view);
            }
        });
        textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.util.-$$Lambda$g_renamed$es9lHb36pszNyH7sNZVKxPrGh1I
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.oplus.camera.util.g_renamed.a_renamed(bVar, cVar, view);
            }
        });
        if (com.oplus.camera.util.Util.u_renamed()) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) viewInflate.getLayoutParams();
            layoutParams.width = com.oplus.camera.util.Util.V_renamed();
            layoutParams.bottomMargin = (int) activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.full_page_statement_margin_bottom);
            layoutParams.addRule(14);
            viewInflate.setLayoutParams(layoutParams);
            viewFindViewById.setBackgroundResource(com.oplus.camera.R_renamed.drawable.folder_pg_dialog_bg);
        } else {
            viewFindViewById.setBackgroundResource(com.oplus.camera.R_renamed.drawable.pg_dialog_bg);
        }
        viewInflate.setForceDarkAllowed(true);
        cVar.c_renamed(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setCancelable(false);
        cVar.supportRequestWindowFeature(1);
        cVar.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(activity.getColor(com.oplus.camera.R_renamed.color.color_black_with_40_percent_transparency)));
        cVar.getWindow().setNavigationBarColor(activity.getColor(com.oplus.camera.R_renamed.color.camera_white));
        cVar.setContentView(viewInflate);
        cVar.getBehavior().setDraggable(false);
        cVar.c_renamed().getDragView().setVisibility(4);
        cVar.a_renamed(new android.graphics.drawable.ColorDrawable(0));
        cVar.show();
        if (bVar != null) {
            bVar.a_renamed(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a_renamed(com.oplus.camera.util.g_renamed.b_renamed bVar, com.oplus.camera.util.g_renamed.c_renamed cVar, android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
        if (i_renamed != 4) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.a_renamed(cVar, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b_renamed(com.oplus.camera.util.g_renamed.b_renamed bVar, com.oplus.camera.util.g_renamed.c_renamed cVar, android.view.View view) {
        if (bVar != null) {
            bVar.a_renamed(cVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.util.g_renamed.b_renamed bVar, com.oplus.camera.util.g_renamed.c_renamed cVar, android.view.View view) {
        if (bVar != null) {
            bVar.a_renamed(cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public static java.lang.String c_renamed(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return context.getString(com.oplus.camera.R_renamed.string.camera_permission_name_camera);
            }
            if (c2 == 1 || c2 == 2) {
                return context.getString(com.oplus.camera.R_renamed.string.camera_permission_name_storage);
            }
            if (c2 == 3) {
                return context.getString(com.oplus.camera.R_renamed.string.camera_permission_name_microphone);
            }
            if (c2 == 4 || c2 == 5) {
                return context.getString(com.oplus.camera.R_renamed.string.camera_permission_name_location);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public static java.lang.String d_renamed(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return context.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_camera);
            }
            if (c2 == 1 || c2 == 2) {
                return context.getString(com.oplus.camera.R_renamed.string.group_custom_detail_message_storage);
            }
            if (c2 == 3) {
                return context.getString(com.oplus.camera.R_renamed.string.group_custom_detail_message_mic_new);
            }
            if (c2 == 4 || c2 == 5) {
                return context.getString(com.oplus.camera.R_renamed.string.group_custom_detail_message_location);
            }
        }
        return "";
    }

    /* compiled from: ExportPGrantUtil.java */
    static class a_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.util.g_renamed.a_renamed.ExportPGrantUtil_4> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.content.Context f7335a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.List<java.lang.String> f7336b;

        public a_renamed(android.content.Context context, java.util.List<java.lang.String> list) {
            this.f7335a = context;
            this.f7336b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.util.g_renamed.a_renamed.ExportPGrantUtil_4 onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
            return new com.oplus.camera.util.g_renamed.a_renamed.ExportPGrantUtil_4(android.view.LayoutInflater.from(this.f7335a).inflate(com.oplus.camera.R_renamed.layout.camera_pg_item_layout, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.oplus.camera.util.g_renamed.a_renamed.ExportPGrantUtil_4 c0136a, int i_renamed) {
            java.lang.String strC = com.oplus.camera.util.g_renamed.c_renamed(this.f7335a, this.f7336b.get(i_renamed));
            java.lang.String strD = com.oplus.camera.util.g_renamed.d_renamed(this.f7335a, this.f7336b.get(i_renamed));
            c0136a.f7337a.setText(strC);
            c0136a.f7338b.setText(strD);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public int getItemCount() {
            java.util.List<java.lang.String> list = this.f7336b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* compiled from: ExportPGrantUtil.java */
        /* renamed from: com.oplus.camera.util.g_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        public class ExportPGrantUtil_4 extends androidx.recyclerview.widget.RecyclerView.w_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            android.widget.TextView f7337a;

            /* renamed from: b_renamed, reason: collision with root package name */
            android.widget.TextView f7338b;

            public ExportPGrantUtil_4(android.view.View view) {
                super(view);
                this.f7337a = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.pg_item_title_tv);
                this.f7338b = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.pg_item_title_desc);
            }
        }
    }

    /* compiled from: ExportPGrantUtil.java */
    static class c_renamed extends com.coui.appcompat.dialog.panel.b_renamed {
        public c_renamed(android.content.Context context, int i_renamed) {
            super(context, i_renamed);
        }

        @Override // com.coui.appcompat.dialog.panel.b_renamed, android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            getWindow().setNavigationBarColor(getContext().getColor(com.oplus.camera.R_renamed.color.camera_white));
        }
    }
}
