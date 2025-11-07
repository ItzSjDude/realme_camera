package com.oplus.camera.ui.modepanel;

/* compiled from: ModePanelData.java */
/* loaded from: classes2.dex */
public class l_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f6739b;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> f6738a = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6740c = false;

    public l_renamed(android.app.Activity activity) {
        this.f6739b = null;
        this.f6739b = activity;
        a_renamed();
    }

    public void a_renamed() {
        this.f6738a = new java.util.ArrayList<>();
        c_renamed();
        this.f6740c = true;
        com.oplus.camera.e_renamed.a_renamed("ModePanelData", "init, " + this.f6738a.size());
    }

    public void a_renamed(int i_renamed) {
        if (-1 != c_renamed(i_renamed)) {
            return;
        }
        java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA = com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed("position_mode_panel");
        if (listA == null) {
            com.oplus.camera.e_renamed.f_renamed("ModePanelData", "addRearItem, itemId: " + i_renamed + " error, position panel has no data.");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List list = (java.util.List) listA.stream().sorted(java.util.Comparator.comparing(com.oplus.camera.ui.modepanel.$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4.INSTANCE)).collect(java.util.stream.Collectors.toList());
        int iD = list.size() != 0 ? ((com.oplus.camera.ui.modepanel.i_renamed) list.get(list.size() - 1)).d_renamed() : -1;
        if (9 == i_renamed) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_BREENO_SCAN, false, "position_mode_panel", iD + 1, 9, false));
            com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(arrayList);
        } else if (17 == i_renamed) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SOLOOP, false, "position_mode_panel", iD + 1, 17, false));
            com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(arrayList);
        } else {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.d_renamed(i_renamed), true, "position_mode_panel", iD + 1, i_renamed, false));
            com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(arrayList);
        }
        c_renamed();
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.b_renamed.a_renamed().b_renamed(i_renamed);
        c_renamed();
    }

    public int c_renamed(int i_renamed) {
        for (int i2 = 0; i2 < this.f6738a.size(); i2++) {
            if (this.f6738a.get(i2).b_renamed() == i_renamed) {
                return i2;
            }
        }
        return -1;
    }

    public java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> b_renamed() {
        return this.f6738a;
    }

    public void c_renamed() {
        this.f6738a.clear();
        java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA = com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed("position_mode_panel");
        if (listA == null || listA.isEmpty()) {
            return;
        }
        for (com.oplus.camera.ui.modepanel.i_renamed iVar : (java.util.List) listA.stream().sorted(java.util.Comparator.comparing(com.oplus.camera.ui.modepanel.$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4.INSTANCE)).collect(java.util.stream.Collectors.toList())) {
            if (!com.oplus.camera.util.Util.t_renamed() || (!com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO.equals(iVar.a_renamed()) && !com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER.equals(iVar.a_renamed()))) {
                if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) || !com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE.equals(iVar.a_renamed())) {
                    this.f6738a.add(new com.oplus.camera.ui.modepanel.k_renamed(this.f6739b, iVar.e_renamed(), com.oplus.camera.ui.menu.a_renamed.c_renamed.c_renamed(iVar.e_renamed())));
                }
            }
        }
    }
}
