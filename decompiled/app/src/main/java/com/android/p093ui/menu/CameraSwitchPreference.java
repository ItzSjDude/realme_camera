package com.android.p093ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;

/* loaded from: classes.dex */
public class CameraSwitchPreference extends COUISwitchPreference implements Preference.InterfaceC0644b {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f5975b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Preference f5976c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private COUIAlertDialog f5977d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private COUIAlertDialog f5978e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final DialogInterface.OnClickListener f5979f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final DialogInterface.OnClickListener f5980g;

    public CameraSwitchPreference(Context context) {
        super(context);
        this.f5975b = null;
        this.f5976c = null;
        this.f5977d = null;
        this.f5978e = null;
        this.f5979f = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSwitchPreference.this.m3903e(true);
            }
        };
        this.f5980g = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSwitchPreference.this.m6201l();
            }
        };
        this.f5975b = context;
        m3817a((Preference.InterfaceC0644b) this);
    }

    public CameraSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5975b = null;
        this.f5976c = null;
        this.f5977d = null;
        this.f5978e = null;
        this.f5979f = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSwitchPreference.this.m3903e(true);
            }
        };
        this.f5980g = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSwitchPreference.this.m6201l();
            }
        };
        this.f5975b = context;
        m3817a((Preference.InterfaceC0644b) this);
    }

    public CameraSwitchPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f5975b = null;
        this.f5976c = null;
        this.f5977d = null;
        this.f5978e = null;
        this.f5979f = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CameraSwitchPreference.this.m3903e(true);
            }
        };
        this.f5980g = new DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CameraSwitchPreference.this.m6201l();
            }
        };
        this.f5975b = context;
        m3817a((Preference.InterfaceC0644b) this);
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo3838c(boolean z) {
        CameraLog.m12954a("CameraSwitchPreference", "persistBoolean, key: " + m3791B() + ", value: " + z);
        try {
            return m3842d(z ? "on" : "off");
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12954a("CameraSwitchPreference", "persistBoolean, persistString error: " + COUIBaseListPopupWindow_8.getMessage());
            this.m3801L().edit().remove(this.m3791B()).commit();
            return this.m3842d(z ? "on" : "off");
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean mo3843d(boolean z) {
        boolean zD;
        boolean zEquals;
        try {
            zEquals = "on".equals(m3844e(z ? "on" : "off"));
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12954a("CameraSwitchPreference", "persistBoolean, getPersistedString error: " + COUIBaseListPopupWindow_8.getMessage());
            try {
                zD = super.mo3843d(z);
            } catch (Exception e2) {
                CameraLog.m12954a("CameraSwitchPreference", "persistBoolean, super.getPersistedBoolean error: " + e2.getMessage());
                zD = z;
            }
            m3801L().edit().remove(m3791B()).commit();
            m3842d(z ? "on" : "off");
            zEquals = zD;
        }
        CameraLog.m12954a("CameraSwitchPreference", "persistBoolean, key: " + m3791B() + ", defaultReturnValue: " + z + ", isOn: " + zEquals);
        return zEquals;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6202c() {
        COUIAlertDialog dialogInterfaceC1289b = this.f5978e;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f5978e.dismiss();
        }
        COUIAlertDialog.PlatformImplementations.kt_3 aVar = new COUIAlertDialog.PlatformImplementations.kt_3(this.f5975b, R.style.DialogAlert);
        aVar.setTitle(R.string.camera_storage_target_sdcard_switch_alert);
        aVar.setMessage(R.string.camera_storage_footer_summary);
        aVar.setPositiveButton(R.string.camera_storage_confirm, this.f5979f);
        aVar.setNegativeButton(R.string.camera_storage_cancel, this.f5980g);
        this.f5978e = aVar.create();
        if (!(this.f5975b instanceof Activity) || ((Activity) m3800K()).isFinishing()) {
            return;
        }
        this.f5978e.show();
    }

    @Override // androidx.preference.Preference.InterfaceC0644b
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (!CameraUIInterface.KEY_STORAGE_PLACE.equals(preference.m3791B()) || !"off".equals(preference.m3801L().getString(preference.m3791B(), "off"))) {
            return true;
        }
        this.f5976c = preference;
        m6202c();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m6201l() {
        Preference preference = this.f5976c;
        if (preference == null) {
            CameraLog.m12967f("CameraSwitchPreference", "Exception: null == mPreference");
            return;
        }
        synchronized (preference) {
            SharedPreferences.Editor editorEdit = this.f5976c.m3801L().edit();
            editorEdit.putString(this.f5976c.m3791B(), "off");
            editorEdit.apply();
            m3903e(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6203d() {
        CameraLog.m12959b("CameraSwitchPreference", "release");
        COUIAlertDialog dialogInterfaceC1289b = this.f5977d;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            CameraLog.m12954a("CameraSwitchPreference", "release, mRecordLocationDialog dismiss");
            this.f5977d.dismiss();
        }
        this.f5977d = null;
        COUIAlertDialog dialogInterfaceC1289b2 = this.f5978e;
        if (dialogInterfaceC1289b2 != null && dialogInterfaceC1289b2.isShowing()) {
            CameraLog.m12954a("CameraSwitchPreference", "release, mStoragePlaceDialog dismiss");
            this.f5978e.dismiss();
        }
        this.f5978e = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m6204e() {
        COUIAlertDialog dialogInterfaceC1289b = this.f5978e;
        return dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6205f() {
        COUIAlertDialog dialogInterfaceC1289b = this.f5978e;
        if (dialogInterfaceC1289b == null || !dialogInterfaceC1289b.isShowing()) {
            return;
        }
        this.f5978e.dismiss();
    }
}
