package com.oplus.camera;

/* compiled from: CameraPermission.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.List<java.lang.String> f4689a = java.util.Arrays.asList("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f4690b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ComboPreferences f4691c;
    private com.oplus.camera.i_renamed d_renamed = null;
    private com.oplus.camera.h_renamed.c_renamed e_renamed = null;
    private com.oplus.camera.h_renamed.b_renamed f_renamed = null;
    private com.oplus.camera.h_renamed.a_renamed g_renamed = null;
    private androidx.appcompat.app.f_renamed h_renamed = null;

    /* compiled from: CameraPermission.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);

        void b_renamed();

        void b_renamed(boolean z_renamed);
    }

    /* compiled from: CameraPermission.java */
    public interface b_renamed {
        void a_renamed();
    }

    /* compiled from: CameraPermission.java */
    public interface e_renamed {
        void a_renamed();

        void b_renamed();
    }

    private static java.lang.String a_renamed(int i_renamed) {
        return 1 == i_renamed ? com.oplus.camera.statistics.model.EnterExitDcsMsgData.TIMING_OPEN_CAMERA : 2 == i_renamed ? com.oplus.camera.statistics.model.EnterExitDcsMsgData.TIMING_VIDEO_RECORD : 3 == i_renamed ? com.oplus.camera.statistics.model.EnterExitDcsMsgData.TIMING_SETTING_LOCATION : 4 == i_renamed ? com.oplus.camera.statistics.model.EnterExitDcsMsgData.TIMING_SETTING_LOCATION_SLOGAN : "";
    }

    public h_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences) {
        this.f4690b = null;
        this.f4691c = null;
        this.f4690b = activity;
        this.f4691c = comboPreferences;
    }

    public void a_renamed() {
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.c_renamed();
        }
        if (this.f4691c.contains("pref_permission_denied")) {
            this.f4691c.edit().remove("pref_permission_denied").apply();
        }
    }

    public void b_renamed() {
        com.oplus.camera.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            iVar.b_renamed();
            this.d_renamed = null;
        }
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.c_renamed();
            this.e_renamed = null;
        }
    }

    public void c_renamed() {
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.c_renamed();
            this.e_renamed = null;
        }
    }

    public void d_renamed() {
        if (k_renamed()) {
            return;
        }
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar == null || !cVar.a_renamed()) {
            j_renamed();
        }
    }

    public static boolean a_renamed(android.content.Context context) {
        return context.checkSelfPermission("android.permission.CAMERA") == 0;
    }

    public boolean e_renamed() {
        java.util.Iterator<java.lang.String> it = f4689a.iterator();
        while (it.hasNext()) {
            if (this.f4690b.checkSelfPermission(it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public void f_renamed() {
        if (this.f4690b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            j_renamed();
        }
    }

    private java.util.List<java.lang.String> i_renamed() {
        java.util.List<java.lang.String> arrayList;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        if (com.oplus.camera.util.Util.x_renamed(this.f4690b) && l_renamed()) {
            arrayList = new java.util.ArrayList();
            arrayList.addAll(f4689a);
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        } else {
            arrayList = f4689a;
        }
        for (java.lang.String str : arrayList) {
            if (this.f4690b.checkSelfPermission(str) != 0) {
                arrayList2.add(str);
            }
        }
        if (arrayList2.contains("android.permission.ACCESS_FINE_LOCATION") && this.f4690b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            arrayList2.remove("android.permission.ACCESS_FINE_LOCATION");
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        java.util.List<java.lang.String> listI = i_renamed();
        if (listI.isEmpty()) {
            this.f4691c.edit().putBoolean("pref_permission_denied", false).apply();
            this.f4691c.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, true).apply();
            com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
            if (cVar == null || cVar.f_renamed()) {
                return;
            }
            this.e_renamed.c_renamed();
            return;
        }
        this.f4691c.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false).apply();
        java.lang.String[] strArr = (java.lang.String[]) listI.toArray(new java.lang.String[listI.size()]);
        if (this.f4691c.getBoolean("pref_permission_denied", false)) {
            if (!com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed(listI, new com.oplus.camera.h_renamed.d_renamed(a_renamed(listI), 1, listI));
                return;
            } else {
                a_renamed(strArr);
                return;
            }
        }
        com.oplus.camera.h_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            aVar.b_renamed(true);
        }
        if (!com.oplus.camera.util.Util.ak_renamed()) {
            this.f4690b.requestPermissions(strArr, 1);
        } else {
            a_renamed(strArr);
        }
        com.oplus.camera.e_renamed.a_renamed("CameraPermission", "requestPermissions, permissions: " + java.util.Arrays.toString(strArr));
    }

    private void a_renamed(final java.lang.String[] strArr) {
        if (strArr == null) {
            return;
        }
        com.oplus.camera.util.g_renamed.b_renamed bVar = new com.oplus.camera.util.g_renamed.b_renamed() { // from class: com.oplus.camera.h_renamed.1
            @Override // com.oplus.camera.util.g_renamed.b_renamed
            public void a_renamed(androidx.appcompat.app.f_renamed fVar) {
                com.oplus.camera.h_renamed.this.h_renamed = fVar;
            }

            @Override // com.oplus.camera.util.g_renamed.b_renamed
            public void a_renamed(androidx.appcompat.app.f_renamed fVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
                if (fVar != null && fVar.isShowing()) {
                    fVar.dismiss();
                }
                java.util.List listAsList = java.util.Arrays.asList(strArr);
                if (z_renamed) {
                    com.oplus.camera.h_renamed.this.f4690b.requestPermissions(strArr, 1);
                    return;
                }
                if (listAsList.contains("android.permission.CAMERA") || listAsList.contains("android.permission.WRITE_EXTERNAL_STORAGE") || listAsList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                    com.oplus.camera.h_renamed.this.f4690b.finish();
                } else if (listAsList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    com.oplus.camera.h_renamed.this.m_renamed();
                }
            }
        };
        androidx.appcompat.app.f_renamed fVar = this.h_renamed;
        if (fVar != null && fVar.isShowing()) {
            this.h_renamed.dismiss();
        }
        com.oplus.camera.util.g_renamed.a_renamed(this.f4690b, strArr, bVar);
    }

    private void a_renamed(java.util.List<java.lang.String> list, android.content.DialogInterface.OnClickListener onClickListener) {
        java.lang.String string;
        java.lang.String string2;
        int size = list.size();
        if (size == 0) {
            return;
        }
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.c_renamed();
        }
        if (1 == size) {
            java.lang.String str = list.get(0);
            android.app.Activity activity = this.f4690b;
            string = activity.getString(com.oplus.camera.R_renamed.string.camera_permission_dialog_title, new java.lang.Object[]{b_renamed(activity, str)});
            string2 = a_renamed(this.f4690b, str);
        } else if (2 == size && list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            android.app.Activity activity2 = this.f4690b;
            string = activity2.getString(com.oplus.camera.R_renamed.string.camera_permission_dialog_title, new java.lang.Object[]{activity2.getString(com.oplus.camera.R_renamed.string.camera_permission_name_storage)});
            string2 = this.f4690b.getString(com.oplus.camera.R_renamed.string.camera_permission_description_storage);
        } else {
            if (list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                list.remove("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (list.contains("android.permission.ACCESS_FINE_LOCATION") && list.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                list.remove("android.permission.ACCESS_FINE_LOCATION");
            }
            string = this.f4690b.getString(com.oplus.camera.R_renamed.string.camera_permission_dialog_multi_title);
            string2 = null;
        }
        com.coui.appcompat.dialog.app.b_renamed.a_renamed cancelable = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.f4690b).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.h_renamed.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (i_renamed != 4) {
                    return true;
                }
                com.oplus.camera.h_renamed.this.f4690b.finish();
                return true;
            }
        }).setTitle(string).setPositiveButton(com.oplus.camera.R_renamed.string.camera_permission_dialog_ok, onClickListener).setCancelable(false);
        if (a_renamed(list)) {
            cancelable.setNegativeButton(com.oplus.camera.R_renamed.string.camera_permission_dialog_exit, onClickListener);
        } else {
            cancelable.setNegativeButton(com.oplus.camera.R_renamed.string.camera_permission_dialog_cancel, onClickListener);
        }
        if (string2 == null) {
            android.view.View viewInflate = android.view.LayoutInflater.from(this.f4690b).inflate(com.oplus.camera.R_renamed.layout.permission_dialog_content, (android.view.ViewGroup) null);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.permission_dialog_content);
            for (java.lang.String str2 : list) {
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) android.view.LayoutInflater.from(this.f4690b).inflate(com.oplus.camera.R_renamed.layout.permission_dialog_item, (android.view.ViewGroup) null);
                android.widget.TextView textView = (android.widget.TextView) linearLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.permission_dialog_name);
                android.widget.TextView textView2 = (android.widget.TextView) linearLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.permission_dialog_usage);
                textView.setText(b_renamed(this.f4690b, str2));
                textView2.setText(c_renamed(this.f4690b, str2));
                android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = this.f4690b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.permission_dialog_item_top_margin);
                viewGroup.addView(linearLayout, layoutParams);
            }
            cancelable.setView(viewInflate);
        } else {
            cancelable.setMessage(string2);
        }
        this.e_renamed = new com.oplus.camera.h_renamed.c_renamed(cancelable.create(), list, onClickListener);
        if (this.f4690b.isFinishing()) {
            return;
        }
        this.e_renamed.b_renamed();
    }

    private boolean a_renamed(java.util.List<java.lang.String> list) {
        java.util.Iterator<java.lang.String> it = f4689a.iterator();
        while (it.hasNext()) {
            if (list.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private java.lang.String a_renamed(android.app.Activity activity, java.lang.String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_description_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_description_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_description_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_description_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(com.oplus.camera.R_renamed.string.camera_permission_description_location) : "";
    }

    private java.lang.String b_renamed(android.app.Activity activity, java.lang.String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_name_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_name_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_name_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_name_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(com.oplus.camera.R_renamed.string.camera_permission_name_location) : "";
    }

    private java.lang.String c_renamed(android.app.Activity activity, java.lang.String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(com.oplus.camera.R_renamed.string.camera_permission_usage_location) : "";
    }

    public void g_renamed() {
        com.oplus.camera.i_renamed iVar = this.d_renamed;
        if (iVar == null || !iVar.a_renamed()) {
            return;
        }
        this.d_renamed.b_renamed();
        this.d_renamed = null;
        k_renamed();
    }

    public void h_renamed() {
        com.oplus.camera.h_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null && cVar.a_renamed()) {
            java.util.List<java.lang.String> listD = this.e_renamed.d_renamed();
            android.content.DialogInterface.OnClickListener onClickListenerE = this.e_renamed.e_renamed();
            this.e_renamed.c_renamed();
            this.e_renamed = null;
            a_renamed(listD, onClickListenerE);
            return;
        }
        androidx.appcompat.app.f_renamed fVar = this.h_renamed;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        j_renamed();
    }

    private boolean k_renamed() {
        if (this.d_renamed == null) {
            this.d_renamed = new com.oplus.camera.i_renamed(this.f4690b, new com.oplus.camera.i_renamed.a_renamed() { // from class: com.oplus.camera.h_renamed.3
                @Override // com.oplus.camera.i_renamed.a_renamed
                public void a_renamed() {
                    if (com.oplus.camera.h_renamed.this.g_renamed != null) {
                        com.oplus.camera.h_renamed.this.g_renamed.a_renamed(true);
                    }
                }

                @Override // com.oplus.camera.i_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    if (com.oplus.camera.h_renamed.this.g_renamed != null) {
                        com.oplus.camera.h_renamed.this.g_renamed.a_renamed(z_renamed);
                    }
                }

                @Override // com.oplus.camera.i_renamed.a_renamed
                public void b_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.e_renamed.a_renamed("CameraPermission", "onStatementAlertClick, isAgree: " + z_renamed);
                    if (com.oplus.camera.h_renamed.this.f4691c != null) {
                        com.oplus.camera.h_renamed.this.f4691c.edit().putBoolean("pref_allow_network_access", z_renamed).apply();
                        com.oplus.camera.h_renamed.this.f4691c.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.SHOW_ARROW_ANIMATION, true).apply();
                        com.oplus.camera.h_renamed.this.f4691c.edit().putBoolean("pref_camera_statement_agree", z_renamed).apply();
                        com.oplus.camera.h_renamed.this.f4691c.edit().putBoolean("pref_camera_statement_key", true).apply();
                    }
                    if (!z_renamed) {
                        com.oplus.camera.h_renamed.this.m_renamed();
                    }
                    com.oplus.camera.h_renamed.this.j_renamed();
                    if (com.oplus.camera.h_renamed.this.f_renamed != null) {
                        com.oplus.camera.h_renamed.this.f_renamed.a_renamed();
                    }
                    if (com.oplus.camera.h_renamed.this.g_renamed != null) {
                        com.oplus.camera.h_renamed.this.g_renamed.a_renamed(false);
                        if (!z_renamed) {
                            com.oplus.camera.h_renamed.this.g_renamed.a_renamed();
                        } else {
                            com.oplus.camera.h_renamed.this.g_renamed.b_renamed();
                        }
                    }
                    com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.h_renamed.this.f4690b, com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_PRIVACY, z_renamed ? com.oplus.camera.statistics.model.EnterExitDcsMsgData.RESULT_AGREE : "cancel");
                }
            });
        }
        boolean zA = this.d_renamed.a_renamed(this.f4691c);
        com.oplus.camera.ui.modepanel.b_renamed.a_renamed().b_renamed();
        this.g_renamed.a_renamed(zA);
        com.oplus.camera.e_renamed.a_renamed("CameraPermission", "showPrivacyPolicyAlertDialog, isShow: " + zA);
        return zA;
    }

    public void a_renamed(int i_renamed, java.lang.String[] strArr, int[] iArr, com.oplus.camera.h_renamed.e_renamed eVar) {
        boolean z_renamed;
        com.oplus.camera.h_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            aVar.b_renamed(false);
        }
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            com.oplus.camera.e_renamed.e_renamed("CameraPermission", "onRequestPermissionsResult, requestCancelled!");
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        this.f4691c.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, true).apply();
        if (i_renamed != 1) {
            if (i_renamed == 2 && !z_renamed) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                        if (iArr[i2] != 0) {
                            a_renamed(java.util.Arrays.asList("android.permission.RECORD_AUDIO"), new com.oplus.camera.h_renamed.d_renamed(false, 2, java.util.Arrays.asList("android.permission.RECORD_AUDIO")));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        eVar.a_renamed();
        if (!z_renamed) {
            java.util.List<java.lang.String> listA = a_renamed(strArr, iArr);
            this.f4691c.edit().putBoolean("pref_permission_denied", listA.size() > 0).apply();
            if (!listA.isEmpty()) {
                a_renamed(listA, new com.oplus.camera.h_renamed.d_renamed(a_renamed(listA), 1, listA));
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if ("android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i3])) {
                    if (iArr[i3] != 0) {
                        m_renamed();
                        return;
                    } else {
                        eVar.b_renamed();
                        return;
                    }
                }
            }
            return;
        }
        m_renamed();
    }

    private boolean l_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.f4691c;
        if (comboPreferences == null) {
            return false;
        }
        return "on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, this.f4690b.getString(com.oplus.camera.R_renamed.string.camera_location_default_value))) || com.oplus.camera.c_renamed.a_renamed(this.f4690b, this.f4691c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ComboPreferences comboPreferences = this.f4691c;
        if (comboPreferences == null) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        if ("on_renamed".equals(this.f4691c.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, this.f4690b.getString(com.oplus.camera.R_renamed.string.camera_location_default_value)))) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
        }
        com.oplus.camera.c_renamed.b_renamed(this.f4690b, this.f4691c);
    }

    private java.util.List<java.lang.String> a_renamed(java.lang.String[] strArr, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            if (iArr[i_renamed] != 0) {
                arrayList.add(strArr[i_renamed]);
            }
        }
        return arrayList;
    }

    /* compiled from: CameraPermission.java */
    private class d_renamed implements android.content.DialogInterface.OnClickListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4700b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f4701c;
        private java.util.List<java.lang.String> d_renamed;

        public d_renamed(boolean z_renamed, int i_renamed, java.util.List<java.lang.String> list) {
            this.f4700b = false;
            this.f4701c = 0;
            this.d_renamed = null;
            this.f4700b = z_renamed;
            this.f4701c = i_renamed;
            this.d_renamed = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
            if (i_renamed != -2) {
                if (i_renamed != -1) {
                    return;
                }
                com.oplus.camera.h_renamed.this.f4690b.startActivity(new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.fromParts("package", com.oplus.camera.h_renamed.this.f4690b.getPackageName(), null)));
                dialogInterface.dismiss();
                if (com.oplus.camera.h_renamed.this.e_renamed != null) {
                    com.oplus.camera.h_renamed.this.e_renamed.c_renamed();
                    com.oplus.camera.h_renamed.this.e_renamed = null;
                }
                com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.h_renamed.this.f4690b, this.f4701c, this.d_renamed, com.oplus.camera.statistics.model.EnterExitDcsMsgData.RESULT_SETTING);
                return;
            }
            dialogInterface.dismiss();
            if (com.oplus.camera.h_renamed.this.e_renamed != null) {
                com.oplus.camera.h_renamed.this.e_renamed.c_renamed();
                com.oplus.camera.h_renamed.this.e_renamed = null;
            }
            com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.h_renamed.this.f4690b, this.f4701c, this.d_renamed, this.f4700b ? "exit" : "cancel");
            if (this.f4700b) {
                com.oplus.camera.h_renamed.this.f4690b.finish();
            }
        }
    }

    public static void a_renamed(android.app.Activity activity, int i_renamed, java.lang.String[] strArr, int[] iArr) {
        com.oplus.camera.statistics.model.EnterExitDcsMsgData enterExitDcsMsgData = new com.oplus.camera.statistics.model.EnterExitDcsMsgData(activity, com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_PERMISSION);
        enterExitDcsMsgData.mTiming = a_renamed(i_renamed);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("android.permission.CAMERA".equals(strArr[i2])) {
                enterExitDcsMsgData.mCameraPermission = a_renamed(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i2]) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i2])) {
                enterExitDcsMsgData.mStoragePermission = a_renamed(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_PHONE_STATE".equals(strArr[i2])) {
                enterExitDcsMsgData.mImeiPermission = a_renamed(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                enterExitDcsMsgData.mRecorderPermission = a_renamed(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i2])) {
                enterExitDcsMsgData.mLocationPermission = a_renamed(activity, strArr[i2], iArr[i2]);
            }
        }
        enterExitDcsMsgData.report();
    }

    public static void a_renamed(android.app.Activity activity, int i_renamed, java.util.List<java.lang.String> list, java.lang.String str) {
        com.oplus.camera.statistics.model.EnterExitDcsMsgData enterExitDcsMsgData = new com.oplus.camera.statistics.model.EnterExitDcsMsgData(activity, com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_AGREEMENT);
        enterExitDcsMsgData.mTiming = a_renamed(i_renamed);
        enterExitDcsMsgData.mResult = str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("android.permission.CAMERA".equals(list.get(i2))) {
                enterExitDcsMsgData.mbCamera = true;
            } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(list.get(i2)) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(list.get(i2))) {
                enterExitDcsMsgData.mbStorage = true;
            } else if ("android.permission.READ_PHONE_STATE".equals(list.get(i2))) {
                enterExitDcsMsgData.mbImei = true;
            } else if ("android.permission.RECORD_AUDIO".equals(list.get(i2))) {
                enterExitDcsMsgData.mbRecorder = true;
            } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(list.get(i2))) {
                enterExitDcsMsgData.mbLocation = true;
            }
        }
        enterExitDcsMsgData.report();
    }

    public static java.lang.String a_renamed(android.app.Activity activity, java.lang.String str, int i_renamed) {
        return i_renamed == 0 ? "on_renamed" : activity.shouldShowRequestPermissionRationale(str) ? "off" : com.oplus.camera.statistics.model.EnterExitDcsMsgData.PERMISSION_DISAGREE;
    }

    public static void a_renamed(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.EnterExitDcsMsgData enterExitDcsMsgData = new com.oplus.camera.statistics.model.EnterExitDcsMsgData(activity, com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_STATEMENT);
        enterExitDcsMsgData.mStatementType = str;
        enterExitDcsMsgData.mResult = str2;
        enterExitDcsMsgData.report();
    }

    /* compiled from: CameraPermission.java */
    class c_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.coui.appcompat.dialog.app.b_renamed f4697b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.List<java.lang.String> f4698c;
        private android.content.DialogInterface.OnClickListener d_renamed;

        public c_renamed(com.coui.appcompat.dialog.app.b_renamed bVar, java.util.List<java.lang.String> list, android.content.DialogInterface.OnClickListener onClickListener) {
            this.f4697b = null;
            this.f4698c = null;
            this.d_renamed = null;
            this.f4697b = bVar;
            this.f4698c = list;
            this.d_renamed = onClickListener;
        }

        public boolean a_renamed() {
            com.coui.appcompat.dialog.app.b_renamed bVar = this.f4697b;
            if (bVar == null) {
                return false;
            }
            return bVar.isShowing();
        }

        public void b_renamed() {
            com.coui.appcompat.dialog.app.b_renamed bVar = this.f4697b;
            if (bVar != null) {
                bVar.show();
            }
        }

        public void c_renamed() {
            if (a_renamed()) {
                this.f4697b.dismiss();
            }
            this.f4697b = null;
            this.f4698c = null;
            this.d_renamed = null;
        }

        public java.util.List<java.lang.String> d_renamed() {
            return this.f4698c;
        }

        public android.content.DialogInterface.OnClickListener e_renamed() {
            return this.d_renamed;
        }

        public boolean f_renamed() {
            java.util.List<java.lang.String> list = this.f4698c;
            if (list != null) {
                return list.contains("android.permission.RECORD_AUDIO");
            }
            return false;
        }
    }

    public void a_renamed(com.oplus.camera.h_renamed.b_renamed bVar) {
        this.f_renamed = bVar;
    }

    public void a_renamed(com.oplus.camera.h_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }
}
