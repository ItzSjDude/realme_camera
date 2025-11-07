package com.oplus.camera;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.CameraStatementAlert;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.camera.util.ExportPGrantUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraPermission.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class CameraPermission {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final List<String> f14331a = Arrays.asList("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f14332b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ComboPreferences f14333c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraStatementAlert f14334d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IntrinsicsJvm.kt_3 f14335e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private IntrinsicsJvm.kt_4 f14336f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f14337g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AppCompatDialog f14338h = null;

    /* compiled from: CameraPermission.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10928a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10929a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10930b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10931b(boolean z);
    }

    /* compiled from: CameraPermission.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10927a();
    }

    /* compiled from: CameraPermission.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo9574a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo9575b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m14296a(int OplusGLSurfaceView_13) {
        return 1 == OplusGLSurfaceView_13 ? EnterExitDcsMsgData.TIMING_OPEN_CAMERA : 2 == OplusGLSurfaceView_13 ? EnterExitDcsMsgData.TIMING_VIDEO_RECORD : 3 == OplusGLSurfaceView_13 ? EnterExitDcsMsgData.TIMING_SETTING_LOCATION : 4 == OplusGLSurfaceView_13 ? EnterExitDcsMsgData.TIMING_SETTING_LOCATION_SLOGAN : "";
    }

    public CameraPermission(Activity activity, ComboPreferences comboPreferences) {
        this.f14332b = null;
        this.f14333c = null;
        this.f14332b = activity;
        this.f14333c = comboPreferences;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14320a() {
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar != null) {
            cVar.m14336c();
        }
        if (this.f14333c.contains("pref_permission_denied")) {
            this.f14333c.edit().remove("pref_permission_denied").apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14324b() {
        CameraStatementAlert c2778i = this.f14334d;
        if (c2778i != null) {
            c2778i.m14361b();
            this.f14334d = null;
        }
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar != null) {
            cVar.m14336c();
            this.f14335e = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14325c() {
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar != null) {
            cVar.m14336c();
            this.f14335e = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14326d() {
        if (m14317k()) {
            return;
        }
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar == null || !cVar.m14334a()) {
            m14316j();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m14305a(Context context) {
        return context.checkSelfPermission("android.permission.CAMERA") == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m14327e() {
        Iterator<String> it = f14331a.iterator();
        while (it.hasNext()) {
            if (this.f14332b.checkSelfPermission(it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14328f() {
        if (this.f14332b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            m14316j();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private List<String> m14315i() {
        List<String> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (Util.m24504x(this.f14332b) && m14318l()) {
            arrayList = new ArrayList();
            arrayList.addAll(f14331a);
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        } else {
            arrayList = f14331a;
        }
        for (String str : arrayList) {
            if (this.f14332b.checkSelfPermission(str) != 0) {
                arrayList2.add(str);
            }
        }
        if (arrayList2.contains("android.permission.ACCESS_FINE_LOCATION") && this.f14332b.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            arrayList2.remove("android.permission.ACCESS_FINE_LOCATION");
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m14316j() {
        List<String> listM14315i = m14315i();
        if (listM14315i.isEmpty()) {
            this.f14333c.edit().putBoolean("pref_permission_denied", false).apply();
            this.f14333c.edit().putBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, true).apply();
            IntrinsicsJvm.kt_3 cVar = this.f14335e;
            if (cVar == null || cVar.m14339f()) {
                return;
            }
            this.f14335e.m14336c();
            return;
        }
        this.f14333c.edit().putBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false).apply();
        String[] strArr = (String[]) listM14315i.toArray(new String[listM14315i.size()]);
        if (this.f14333c.getBoolean("pref_permission_denied", false)) {
            if (!Util.m24348ak()) {
                m14303a(listM14315i, new IntrinsicsJvm.kt_5(m14306a(listM14315i), 1, listM14315i));
                return;
            } else {
                m14304a(strArr);
                return;
            }
        }
        PlatformImplementations.kt_3 aVar = this.f14337g;
        if (aVar != null) {
            aVar.mo10931b(true);
        }
        if (!Util.m24348ak()) {
            this.f14332b.requestPermissions(strArr, 1);
        } else {
            m14304a(strArr);
        }
        CameraLog.m12954a("CameraPermission", "requestPermissions, permissions: " + Arrays.toString(strArr));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14304a(final String[] strArr) {
        if (strArr == null) {
            return;
        }
        ExportPGrantUtil.IntrinsicsJvm.kt_4 bVar = new ExportPGrantUtil.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.COUIBaseListPopupWindow_10.1
            @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12686a(AppCompatDialog dialogC0208f) {
                CameraPermission.this.f14338h = dialogC0208f;
            }

            @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12687a(AppCompatDialog dialogC0208f, boolean z) throws Resources.NotFoundException {
                if (dialogC0208f != null && dialogC0208f.isShowing()) {
                    dialogC0208f.dismiss();
                }
                List listAsList = Arrays.asList(strArr);
                if (z) {
                    CameraPermission.this.f14332b.requestPermissions(strArr, 1);
                    return;
                }
                if (listAsList.contains("android.permission.CAMERA") || listAsList.contains("android.permission.WRITE_EXTERNAL_STORAGE") || listAsList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                    CameraPermission.this.f14332b.finish();
                } else if (listAsList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    CameraPermission.this.m14319m();
                }
            }
        };
        AppCompatDialog dialogC0208f = this.f14338h;
        if (dialogC0208f != null && dialogC0208f.isShowing()) {
            this.f14338h.dismiss();
        }
        ExportPGrantUtil.m24540a(this.f14332b, strArr, bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14303a(List<String> list, DialogInterface.OnClickListener onClickListener) {
        String string;
        String string2;
        int size = list.size();
        if (size == 0) {
            return;
        }
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar != null) {
            cVar.m14336c();
        }
        if (1 == size) {
            String str = list.get(0);
            Activity activity = this.f14332b;
            string = activity.getString(R.string.camera_permission_dialog_title, new Object[]{m14307b(activity, str)});
            string2 = m14297a(this.f14332b, str);
        } else if (2 == size && list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            Activity activity2 = this.f14332b;
            string = activity2.getString(R.string.camera_permission_dialog_title, new Object[]{activity2.getString(R.string.camera_permission_name_storage)});
            string2 = this.f14332b.getString(R.string.camera_permission_description_storage);
        } else {
            if (list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                list.remove("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (list.contains("android.permission.ACCESS_FINE_LOCATION") && list.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                list.remove("android.permission.ACCESS_FINE_LOCATION");
            }
            string = this.f14332b.getString(R.string.camera_permission_dialog_multi_title);
            string2 = null;
        }
        COUIAlertDialog.PlatformImplementations.kt_3 cancelable = new COUIAlertDialog.PlatformImplementations.kt_3(this.f14332b).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.COUIBaseListPopupWindow_10.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (OplusGLSurfaceView_13 != 4) {
                    return true;
                }
                CameraPermission.this.f14332b.finish();
                return true;
            }
        }).setTitle(string).setPositiveButton(R.string.camera_permission_dialog_ok, onClickListener).setCancelable(false);
        if (m14306a(list)) {
            cancelable.setNegativeButton(R.string.camera_permission_dialog_exit, onClickListener);
        } else {
            cancelable.setNegativeButton(R.string.camera_permission_dialog_cancel, onClickListener);
        }
        if (string2 == null) {
            View viewInflate = LayoutInflater.from(this.f14332b).inflate(R.layout.permission_dialog_content, (ViewGroup) null);
            ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id_renamed.permission_dialog_content);
            for (String str2 : list) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f14332b).inflate(R.layout.permission_dialog_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id_renamed.permission_dialog_name);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id_renamed.permission_dialog_usage);
                textView.setText(m14307b(this.f14332b, str2));
                textView2.setText(m14310c(this.f14332b, str2));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = this.f14332b.getResources().getDimensionPixelSize(R.dimen.permission_dialog_item_top_margin);
                viewGroup.addView(linearLayout, layoutParams);
            }
            cancelable.setView(viewInflate);
        } else {
            cancelable.setMessage(string2);
        }
        this.f14335e = new IntrinsicsJvm.kt_3(cancelable.create(), list, onClickListener);
        if (this.f14332b.isFinishing()) {
            return;
        }
        this.f14335e.m14335b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m14306a(List<String> list) {
        Iterator<String> it = f14331a.iterator();
        while (it.hasNext()) {
            if (list.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m14297a(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_description_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_description_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_description_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_description_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(R.string.camera_permission_description_location) : "";
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m14307b(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_name_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_name_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_name_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_name_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(R.string.camera_permission_name_location) : "";
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String m14310c(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_microphone);
        }
        return ("android.permission.ACCESS_COARSE_LOCATION".equals(str) || "android.permission.ACCESS_FINE_LOCATION".equals(str)) ? activity.getString(R.string.camera_permission_usage_location) : "";
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14329g() {
        CameraStatementAlert c2778i = this.f14334d;
        if (c2778i == null || !c2778i.m14359a()) {
            return;
        }
        this.f14334d.m14361b();
        this.f14334d = null;
        m14317k();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m14330h() {
        IntrinsicsJvm.kt_3 cVar = this.f14335e;
        if (cVar != null && cVar.m14334a()) {
            List<String> listM14337d = this.f14335e.m14337d();
            DialogInterface.OnClickListener onClickListenerM14338e = this.f14335e.m14338e();
            this.f14335e.m14336c();
            this.f14335e = null;
            m14303a(listM14337d, onClickListenerM14338e);
            return;
        }
        AppCompatDialog dialogC0208f = this.f14338h;
        if (dialogC0208f == null || !dialogC0208f.isShowing()) {
            return;
        }
        m14316j();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m14317k() {
        if (this.f14334d == null) {
            this.f14334d = new CameraStatementAlert(this.f14332b, new CameraStatementAlert.PlatformImplementations.kt_3() { // from class: com.oplus.camera.COUIBaseListPopupWindow_10.3
                @Override // com.oplus.camera.CameraStatementAlert.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14331a() {
                    if (CameraPermission.this.f14337g != null) {
                        CameraPermission.this.f14337g.mo10929a(true);
                    }
                }

                @Override // com.oplus.camera.CameraStatementAlert.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14332a(boolean z) {
                    if (CameraPermission.this.f14337g != null) {
                        CameraPermission.this.f14337g.mo10929a(z);
                    }
                }

                @Override // com.oplus.camera.CameraStatementAlert.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo14333b(boolean z) throws Resources.NotFoundException {
                    CameraLog.m12954a("CameraPermission", "onStatementAlertClick, isAgree: " + z);
                    if (CameraPermission.this.f14333c != null) {
                        CameraPermission.this.f14333c.edit().putBoolean("pref_allow_network_access", z).apply();
                        CameraPermission.this.f14333c.edit().putBoolean(CameraUIInterface.SHOW_ARROW_ANIMATION, true).apply();
                        CameraPermission.this.f14333c.edit().putBoolean("pref_camera_statement_agree", z).apply();
                        CameraPermission.this.f14333c.edit().putBoolean("pref_camera_statement_key", true).apply();
                    }
                    if (!z) {
                        CameraPermission.this.m14319m();
                    }
                    CameraPermission.this.m14316j();
                    if (CameraPermission.this.f14336f != null) {
                        CameraPermission.this.f14336f.mo10927a();
                    }
                    if (CameraPermission.this.f14337g != null) {
                        CameraPermission.this.f14337g.mo10929a(false);
                        if (!z) {
                            CameraPermission.this.f14337g.mo10928a();
                        } else {
                            CameraPermission.this.f14337g.mo10930b();
                        }
                    }
                    CameraPermission.m14302a(CameraPermission.this.f14332b, EnterExitDcsMsgData.STATEMENT_TYPE_PRIVACY, z ? EnterExitDcsMsgData.RESULT_AGREE : "cancel");
                }
            });
        }
        boolean zM14360a = this.f14334d.m14360a(this.f14333c);
        DataBaseOperator.m21777a().m21786b();
        this.f14337g.mo10929a(zM14360a);
        CameraLog.m12954a("CameraPermission", "showPrivacyPolicyAlertDialog, isShow: " + zM14360a);
        return zM14360a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14321a(int OplusGLSurfaceView_13, String[] strArr, int[] iArr, COUIBaseListPopupWindow_8 eVar) {
        boolean z;
        PlatformImplementations.kt_3 aVar = this.f14337g;
        if (aVar != null) {
            aVar.mo10931b(false);
        }
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            CameraLog.m12966e("CameraPermission", "onRequestPermissionsResult, requestCancelled!");
            z = true;
        } else {
            z = false;
        }
        this.f14333c.edit().putBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, true).apply();
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 && !z) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                        if (iArr[i2] != 0) {
                            m14303a(Arrays.asList("android.permission.RECORD_AUDIO"), new IntrinsicsJvm.kt_5(false, 2, Arrays.asList("android.permission.RECORD_AUDIO")));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        eVar.mo9574a();
        if (!z) {
            List<String> listM14299a = m14299a(strArr, iArr);
            this.f14333c.edit().putBoolean("pref_permission_denied", listM14299a.size() > 0).apply();
            if (!listM14299a.isEmpty()) {
                m14303a(listM14299a, new IntrinsicsJvm.kt_5(m14306a(listM14299a), 1, listM14299a));
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if ("android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i3])) {
                    if (iArr[i3] != 0) {
                        m14319m();
                        return;
                    } else {
                        eVar.mo9575b();
                        return;
                    }
                }
            }
            return;
        }
        m14319m();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m14318l() {
        ComboPreferences comboPreferences = this.f14333c;
        if (comboPreferences == null) {
            return false;
        }
        return "on".equals(comboPreferences.getString(CameraUIInterface.KEY_RECORD_LOCATION, this.f14332b.getString(R.string.camera_location_default_value))) || BaseSloganUtil.m11672a(this.f14332b, this.f14333c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m14319m() throws Resources.NotFoundException {
        ComboPreferences comboPreferences = this.f14333c;
        if (comboPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        if ("on".equals(this.f14333c.getString(CameraUIInterface.KEY_RECORD_LOCATION, this.f14332b.getString(R.string.camera_location_default_value)))) {
            editorEdit.putString(CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
        }
        BaseSloganUtil.m11681b(this.f14332b, this.f14333c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<String> m14299a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            if (iArr[OplusGLSurfaceView_13] != 0) {
                arrayList.add(strArr[OplusGLSurfaceView_13]);
            }
        }
        return arrayList;
    }

    /* compiled from: CameraPermission.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 implements DialogInterface.OnClickListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f14348b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f14349c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private List<String> f14350d;

        public IntrinsicsJvm.kt_5(boolean z, int OplusGLSurfaceView_13, List<String> list) {
            this.f14348b = false;
            this.f14349c = 0;
            this.f14350d = null;
            this.f14348b = z;
            this.f14349c = OplusGLSurfaceView_13;
            this.f14350d = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 != -2) {
                if (OplusGLSurfaceView_13 != -1) {
                    return;
                }
                CameraPermission.this.f14332b.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", CameraPermission.this.f14332b.getPackageName(), null)));
                dialogInterface.dismiss();
                if (CameraPermission.this.f14335e != null) {
                    CameraPermission.this.f14335e.m14336c();
                    CameraPermission.this.f14335e = null;
                }
                CameraPermission.m14300a(CameraPermission.this.f14332b, this.f14349c, this.f14350d, EnterExitDcsMsgData.RESULT_SETTING);
                return;
            }
            dialogInterface.dismiss();
            if (CameraPermission.this.f14335e != null) {
                CameraPermission.this.f14335e.m14336c();
                CameraPermission.this.f14335e = null;
            }
            CameraPermission.m14300a(CameraPermission.this.f14332b, this.f14349c, this.f14350d, this.f14348b ? "exit" : "cancel");
            if (this.f14348b) {
                CameraPermission.this.f14332b.finish();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14301a(Activity activity, int OplusGLSurfaceView_13, String[] strArr, int[] iArr) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_PERMISSION);
        enterExitDcsMsgData.mTiming = m14296a(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("android.permission.CAMERA".equals(strArr[i2])) {
                enterExitDcsMsgData.mCameraPermission = m14298a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i2]) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i2])) {
                enterExitDcsMsgData.mStoragePermission = m14298a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_PHONE_STATE".equals(strArr[i2])) {
                enterExitDcsMsgData.mImeiPermission = m14298a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                enterExitDcsMsgData.mRecorderPermission = m14298a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i2])) {
                enterExitDcsMsgData.mLocationPermission = m14298a(activity, strArr[i2], iArr[i2]);
            }
        }
        enterExitDcsMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14300a(Activity activity, int OplusGLSurfaceView_13, List<String> list, String str) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_AGREEMENT);
        enterExitDcsMsgData.mTiming = m14296a(OplusGLSurfaceView_13);
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

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14298a(Activity activity, String str, int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 ? "on" : activity.shouldShowRequestPermissionRationale(str) ? "off" : EnterExitDcsMsgData.PERMISSION_DISAGREE;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14302a(Activity activity, String str, String str2) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_STATEMENT);
        enterExitDcsMsgData.mStatementType = str;
        enterExitDcsMsgData.mResult = str2;
        enterExitDcsMsgData.report();
    }

    /* compiled from: CameraPermission.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_3 */
    class IntrinsicsJvm.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private COUIAlertDialog f14344b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private List<String> f14345c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private DialogInterface.OnClickListener f14346d;

        public IntrinsicsJvm.kt_3(COUIAlertDialog dialogInterfaceC1289b, List<String> list, DialogInterface.OnClickListener onClickListener) {
            this.f14344b = null;
            this.f14345c = null;
            this.f14346d = null;
            this.f14344b = dialogInterfaceC1289b;
            this.f14345c = list;
            this.f14346d = onClickListener;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m14334a() {
            COUIAlertDialog dialogInterfaceC1289b = this.f14344b;
            if (dialogInterfaceC1289b == null) {
                return false;
            }
            return dialogInterfaceC1289b.isShowing();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m14335b() {
            COUIAlertDialog dialogInterfaceC1289b = this.f14344b;
            if (dialogInterfaceC1289b != null) {
                dialogInterfaceC1289b.show();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m14336c() {
            if (m14334a()) {
                this.f14344b.dismiss();
            }
            this.f14344b = null;
            this.f14345c = null;
            this.f14346d = null;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public List<String> m14337d() {
            return this.f14345c;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public DialogInterface.OnClickListener m14338e() {
            return this.f14346d;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean m14339f() {
            List<String> list = this.f14345c;
            if (list != null) {
                return list.contains("android.permission.RECORD_AUDIO");
            }
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14323a(IntrinsicsJvm.kt_4 bVar) {
        this.f14336f = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14322a(PlatformImplementations.kt_3 aVar) {
        this.f14337g = aVar;
    }
}
