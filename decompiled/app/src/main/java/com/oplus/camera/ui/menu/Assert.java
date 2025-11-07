package com.oplus.camera.ui.menu;

/* compiled from: APSVisualizationDialog.java */
/* loaded from: classes2.dex */
public class a_renamed extends android.app.AlertDialog implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f6332a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.ProgressDialog f6333b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.EditText f6334c;
    private android.widget.Button d_renamed;
    private android.widget.Button e_renamed;
    private android.content.Context f_renamed;
    private java.lang.String g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;

    public a_renamed(android.content.Context context, android.content.SharedPreferences sharedPreferences, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(context);
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = "";
        this.h_renamed = "";
        this.i_renamed = "";
        this.f_renamed = context;
        this.f6332a = sharedPreferences;
        this.g_renamed = str;
        this.i_renamed = str2;
        this.h_renamed = str3;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.oplus.camera.R_renamed.layout.camera_custom_alert_dialog);
        getWindow().clearFlags(131072);
        setCancelable(false);
        this.f6334c = (android.widget.EditText) findViewById(com.oplus.camera.R_renamed.id_renamed.et_passwd);
        this.d_renamed = (android.widget.Button) findViewById(com.oplus.camera.R_renamed.id_renamed.btn_cancel);
        this.e_renamed = (android.widget.Button) findViewById(com.oplus.camera.R_renamed.id_renamed.btn_connect);
        this.d_renamed.setOnClickListener(this);
        this.e_renamed.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        android.content.SharedPreferences.Editor editorEdit = this.f6332a.edit();
        int id_renamed = view.getId();
        if (id_renamed == com.oplus.camera.R_renamed.id_renamed.btn_cancel) {
            dismiss();
        } else {
            if (id_renamed != com.oplus.camera.R_renamed.id_renamed.btn_connect) {
                return;
            }
            a_renamed(editorEdit);
        }
    }

    public void a_renamed(android.content.SharedPreferences.Editor editor) {
        if (android.text.TextUtils.isEmpty(this.f6334c.getText())) {
            android.widget.Toast.makeText(this.f_renamed, "password cannot be_renamed none", 0).show();
        } else {
            a_renamed(this.f6334c.getText().toString(), editor);
        }
    }

    public void a_renamed(final java.lang.String str, final android.content.SharedPreferences.Editor editor) {
        final boolean[] zArr = {false};
        this.f6333b = android.app.ProgressDialog.show(getContext(), "Please wait...", "authenticating...", true);
        com.oplus.camera.algovisualization.i_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.a_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zArr[0] = com.oplus.camera.algovisualization.e_renamed.a_renamed(str);
                    com.oplus.camera.ui.menu.a_renamed.this.f6333b.dismiss();
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                com.oplus.camera.algovisualization.i_renamed.b_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.a_renamed.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!zArr[0]) {
                            com.oplus.camera.ui.menu.a_renamed.this.f6333b.dismiss();
                            android.widget.Toast.makeText(com.oplus.camera.ui.menu.a_renamed.this.f_renamed, "password is_renamed invalid", 0).show();
                        } else {
                            com.oplus.camera.ui.menu.a_renamed.this.b_renamed(editor);
                        }
                    }
                });
            }
        });
    }

    public void b_renamed(android.content.SharedPreferences.Editor editor) {
        editor.putLong(this.h_renamed, com.oplus.camera.algovisualization.e_renamed.b_renamed(new java.text.SimpleDateFormat("yyyy-MM-dd_renamed hh:mm:ss:SSS").format(new java.util.Date())));
        editor.putBoolean(this.g_renamed, true);
        editor.apply();
        dismiss();
        android.widget.Toast.makeText(this.f_renamed, this.i_renamed, 0).show();
    }
}
