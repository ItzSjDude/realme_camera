package com.oplus.camera;

/* compiled from: CameraTipsManager.java */
/* loaded from: classes2.dex */
public class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f4719a = com.oplus.camera.util.Util.a_renamed("com.oplus.camera.OPEN_CAMERA_TIME", com.oplus.ocs.camera.BuildConfig.FLAVOR, "b3Bwbw==");

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final java.lang.String f4720b = com.oplus.camera.util.Util.a_renamed("com.oplus.camera.CLICK_ULTRA_WIDE", com.oplus.ocs.camera.BuildConfig.FLAVOR, "b3Bwbw==");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.j_renamed f4721c = null;
    private java.util.Queue<java.lang.Integer> d_renamed;
    private android.content.Context f_renamed;
    private android.content.SharedPreferences g_renamed;
    private int e_renamed = 0;
    private boolean h_renamed = false;

    private j_renamed() {
        this.d_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.d_renamed = new java.util.PriorityQueue(new java.util.Comparator<java.lang.Integer>() { // from class: com.oplus.camera.j_renamed.1
            @Override // java.util.Comparator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public int compare(java.lang.Integer num, java.lang.Integer num2) {
                return num.intValue() - num2.intValue();
            }
        });
        this.f_renamed = com.oplus.camera.MyApplication.d_renamed();
        this.g_renamed = androidx.preference.j_renamed.a_renamed(this.f_renamed);
    }

    public static com.oplus.camera.j_renamed a_renamed() {
        if (f4721c == null) {
            synchronized (com.oplus.camera.j_renamed.class) {
                if (f4721c == null) {
                    f4721c = new com.oplus.camera.j_renamed();
                }
            }
        }
        return f4721c;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "addTipsToQueue, mTipsShown: " + this.e_renamed + ", queueTag: " + i_renamed);
        if (this.e_renamed != 0) {
            if (this.d_renamed.contains(java.lang.Integer.valueOf(i_renamed)) || this.e_renamed == i_renamed) {
                return;
            }
            this.d_renamed.add(java.lang.Integer.valueOf(i_renamed));
            return;
        }
        b_renamed(i_renamed);
    }

    public void b_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.oplus.camera.TIPS_MANAGER_BR_ACTION");
        intent.putExtra("com.oplus.camera.TIPS_MANAGER_DATA", i_renamed);
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "sendShowTipsBroadcast, queueTag: " + i_renamed);
        androidx.e_renamed.a_renamed.a_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed()).a_renamed(intent);
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "resetBroadcastState");
        this.e_renamed = 0;
    }

    public void c_renamed() {
        java.util.Queue<java.lang.Integer> queue = this.d_renamed;
        if (queue != null && !queue.isEmpty()) {
            java.lang.Integer numPoll = this.d_renamed.poll();
            b_renamed(numPoll == null ? 0 : numPoll.intValue());
        } else {
            b_renamed();
        }
    }

    public int d_renamed() {
        int i_renamed = this.g_renamed.getInt("com.oplus.camera.OPEN_CAMERA_TIME", 0);
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "getOpenCameraTime, openCameraTime: " + i_renamed);
        return i_renamed;
    }

    public void e_renamed() {
        int i_renamed = this.g_renamed.getInt("com.oplus.camera.OPEN_CAMERA_TIME", 0) + 1;
        this.g_renamed.edit().putInt("com.oplus.camera.OPEN_CAMERA_TIME", i_renamed).apply();
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "addOpenCameraTime, openCameraTime: " + i_renamed);
    }

    public boolean f_renamed() {
        boolean z_renamed = this.g_renamed.getBoolean("com.oplus.camera.CLICK_ULTRA_WIDE", false);
        com.oplus.camera.e_renamed.b_renamed("CameraTipsManager", "hasClickedUltraWide, click: " + z_renamed);
        return z_renamed;
    }

    public void g_renamed() {
        if (this.h_renamed) {
            return;
        }
        this.h_renamed = true;
        this.g_renamed.edit().putBoolean("com.oplus.camera.CLICK_ULTRA_WIDE", true).apply();
    }
}
