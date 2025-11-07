package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* compiled from: ModePanelData.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class ModePanelData {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f20592b;

    /* renamed from: PlatformImplementations.kt_3 */
    private ArrayList<ModeInfo> f20591a = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f20593c = false;

    public ModePanelData(Activity activity) {
        this.f20592b = null;
        this.f20592b = activity;
        m21935a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21935a() {
        this.f20591a = new ArrayList<>();
        m21940c();
        this.f20593c = true;
        CameraLog.m12954a("ModePanelData", "init, " + this.f20591a.size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21936a(int OplusGLSurfaceView_13) {
        if (-1 != m21939c(OplusGLSurfaceView_13)) {
            return;
        }
        List<ModeDataInfo> listM21782a = DataBaseOperator.m21777a().m21782a("position_mode_panel");
        if (listM21782a == null) {
            CameraLog.m12967f("ModePanelData", "addRearItem, itemId: " + OplusGLSurfaceView_13 + " error, position panel has no data.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List list = (List) listM21782a.stream().sorted(Comparator.comparing($$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4.INSTANCE)).collect(Collectors.toList());
        int iM21911d = list.size() != 0 ? ((ModeDataInfo) list.get(list.size() - 1)).m21911d() : -1;
        if (9 == OplusGLSurfaceView_13) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_BREENO_SCAN, false, "position_mode_panel", iM21911d + 1, 9, false));
            DataBaseOperator.m21777a().m21785a(arrayList);
        } else if (17 == OplusGLSurfaceView_13) {
            arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_SOLOOP, false, "position_mode_panel", iM21911d + 1, 17, false));
            DataBaseOperator.m21777a().m21785a(arrayList);
        } else {
            arrayList.add(new ModeDataInfo(HeadlineHelper.m20351d(OplusGLSurfaceView_13), true, "position_mode_panel", iM21911d + 1, OplusGLSurfaceView_13, false));
            DataBaseOperator.m21777a().m21785a(arrayList);
        }
        m21940c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21938b(int OplusGLSurfaceView_13) {
        DataBaseOperator.m21777a().m21787b(OplusGLSurfaceView_13);
        m21940c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m21939c(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f20591a.size(); i2++) {
            if (this.f20591a.get(i2).m21922b() == OplusGLSurfaceView_13) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<ModeInfo> m21937b() {
        return this.f20591a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21940c() {
        this.f20591a.clear();
        List<ModeDataInfo> listM21782a = DataBaseOperator.m21777a().m21782a("position_mode_panel");
        if (listM21782a == null || listM21782a.isEmpty()) {
            return;
        }
        for (ModeDataInfo c3351i : (List) listM21782a.stream().sorted(Comparator.comparing($$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4.INSTANCE)).collect(Collectors.toList())) {
            if (!Util.m24495t() || (!ApsConstant.CAPTURE_MODE_ID_PHOTO.equals(c3351i.m21908a()) && !ApsConstant.CAPTURE_MODE_STICKER.equals(c3351i.m21908a()))) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) || !ApsConstant.CAPTURE_MODE_LONG_EXPOSURE.equals(c3351i.m21908a())) {
                    this.f20591a.add(new ModeInfo(this.f20592b, c3351i.m21912e(), HeadlineHelper.m20349c(c3351i.m21912e())));
                }
            }
        }
    }
}
