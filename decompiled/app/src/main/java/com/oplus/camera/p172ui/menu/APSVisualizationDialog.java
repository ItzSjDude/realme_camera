package com.oplus.camera.p172ui.menu;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.oplus.camera.R;
import com.oplus.camera.algovisualization.AuthenticationUtils;
import com.oplus.camera.algovisualization.ThreadUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: APSVisualizationDialog.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class APSVisualizationDialog extends AlertDialog implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private SharedPreferences f18936a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ProgressDialog f18937b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private EditText f18938c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Button f18939d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Button f18940e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f18941f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f18942g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f18943h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f18944i;

    public APSVisualizationDialog(Context context, SharedPreferences sharedPreferences, String str, String str2, String str3) {
        super(context);
        this.f18939d = null;
        this.f18940e = null;
        this.f18941f = null;
        this.f18942g = "";
        this.f18943h = "";
        this.f18944i = "";
        this.f18941f = context;
        this.f18936a = sharedPreferences;
        this.f18942g = str;
        this.f18944i = str2;
        this.f18943h = str3;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.camera_custom_alert_dialog);
        getWindow().clearFlags(131072);
        setCancelable(false);
        this.f18938c = (EditText) findViewById(R.id_renamed.et_passwd);
        this.f18939d = (Button) findViewById(R.id_renamed.btn_cancel);
        this.f18940e = (Button) findViewById(R.id_renamed.btn_connect);
        this.f18939d.setOnClickListener(this);
        this.f18940e.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SharedPreferences.Editor editorEdit = this.f18936a.edit();
        int id_renamed = view.getId();
        if (id_renamed == R.id_renamed.btn_cancel) {
            dismiss();
        } else {
            if (id_renamed != R.id_renamed.btn_connect) {
                return;
            }
            m20306a(editorEdit);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20306a(SharedPreferences.Editor editor) {
        if (TextUtils.isEmpty(this.f18938c.getText())) {
            Toast.makeText(this.f18941f, "password cannot be none", 0).show();
        } else {
            m20307a(this.f18938c.getText().toString(), editor);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20307a(final String str, final SharedPreferences.Editor editor) {
        final boolean[] zArr = {false};
        this.f18937b = ProgressDialog.show(getContext(), "Please wait...", "authenticating...", true);
        ThreadUtils.m11634a(new Runnable() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zArr[0] = AuthenticationUtils.m11617a(str);
                    APSVisualizationDialog.this.f18937b.dismiss();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                ThreadUtils.m11635b(new Runnable() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!zArr[0]) {
                            APSVisualizationDialog.this.f18937b.dismiss();
                            Toast.makeText(APSVisualizationDialog.this.f18941f, "password is invalid", 0).show();
                        } else {
                            APSVisualizationDialog.this.m20308b(editor);
                        }
                    }
                });
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20308b(SharedPreferences.Editor editor) {
        editor.putLong(this.f18943h, AuthenticationUtils.m11618b(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date())));
        editor.putBoolean(this.f18942g, true);
        editor.apply();
        dismiss();
        Toast.makeText(this.f18941f, this.f18944i, 0).show();
    }
}
