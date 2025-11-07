package com.oplus.camera.u_renamed;

/* compiled from: SuperTextManager.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5742a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.CameraUIListener f5743b;
    private com.oplus.camera.u_renamed.b_renamed d_renamed;
    private android.os.HandlerThread f_renamed;
    private android.os.Handler g_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.u_renamed.a_renamed f5744c = null;
    private final java.lang.Object e_renamed = new java.lang.Object();
    private boolean h_renamed = false;
    private java.util.Map<java.lang.Long, com.oplus.camera.u_renamed.a_renamed> i_renamed = new java.util.LinkedHashMap<java.lang.Long, com.oplus.camera.u_renamed.a_renamed>() { // from class: com.oplus.camera.u_renamed.d_renamed.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(java.util.Map.Entry<java.lang.Long, com.oplus.camera.u_renamed.a_renamed> entry) {
            return size() > 5;
        }
    };

    public d_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f5742a = null;
        this.f5743b = null;
        this.d_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.f5742a = activity;
        this.f5743b = cameraUIListener;
        this.d_renamed = com.oplus.camera.u_renamed.c_renamed.d_renamed();
        this.f_renamed = new android.os.HandlerThread("SuperTextManager");
        this.f_renamed.start();
        this.g_renamed = new android.os.Handler(this.f_renamed.getLooper()) { // from class: com.oplus.camera.u_renamed.d_renamed.2
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                com.oplus.camera.e_renamed.a_renamed("SuperTextManager", "handleMessage, what: " + message.what);
                int i_renamed = message.what;
                if (i_renamed != 101) {
                    if (i_renamed != 102) {
                        return;
                    }
                    com.oplus.camera.u_renamed.d_renamed.this.b_renamed((byte[]) message.obj, message.arg1, message.arg2, message.getData().getLong("timestamp"));
                    return;
                }
                android.os.Bundle data = message.getData();
                int i2 = data.getInt("width");
                int i3 = data.getInt("height");
                int i4 = data.getInt("orientation");
                long j_renamed = data.getLong("timestamp");
                if (i2 <= 0 || i3 <= 0) {
                    return;
                }
                com.oplus.camera.u_renamed.d_renamed.this.a_renamed(i2, i3, i4, j_renamed);
            }
        };
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed != this.d_renamed.b_renamed()) {
            this.d_renamed.a_renamed(i_renamed);
            d_renamed();
        }
    }

    public int a_renamed() {
        return this.d_renamed.b_renamed();
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SuperTextManager", "init, mSuperTextEngine: " + this.d_renamed);
        if (this.d_renamed != null) {
            a_renamed(false);
            this.d_renamed.a_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
        }
    }

    public boolean c_renamed() {
        com.oplus.camera.u_renamed.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            return bVar.a_renamed();
        }
        return false;
    }

    public void a_renamed(boolean z_renamed) {
        this.d_renamed.b_renamed(z_renamed);
    }

    public com.oplus.camera.u_renamed.a_renamed a_renamed(long j_renamed) {
        synchronized (this.e_renamed) {
            if (this.i_renamed.size() <= 0) {
                return new com.oplus.camera.u_renamed.a_renamed();
            }
            int i_renamed = 0;
            long j2 = 0;
            com.oplus.camera.u_renamed.a_renamed aVar = null;
            java.util.Iterator<java.lang.Long> it = this.i_renamed.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                com.oplus.camera.u_renamed.a_renamed aVar2 = this.i_renamed.get(java.lang.Long.valueOf(jLongValue));
                if (aVar2 != null && aVar2.c_renamed()) {
                    i_renamed++;
                    j2 = jLongValue;
                    aVar = aVar2;
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getProperDetectResultByTimestamp, time diff: ");
            long j3 = j_renamed - j2;
            sb.append(j3);
            sb.append(", availableCount: ");
            sb.append(i_renamed);
            sb.append(", availableResult: ");
            sb.append(aVar);
            com.oplus.camera.e_renamed.a_renamed("SuperTextManager", sb.toString());
            if (i_renamed >= 2 && aVar != null && aVar.c_renamed() && j3 <= 500) {
                return aVar;
            }
            d_renamed();
            return new com.oplus.camera.u_renamed.a_renamed();
        }
    }

    public void d_renamed() {
        synchronized (this.e_renamed) {
            this.i_renamed.clear();
        }
    }

    private void a_renamed(long j_renamed, com.oplus.camera.u_renamed.a_renamed aVar) {
        synchronized (this.e_renamed) {
            this.i_renamed.put(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2, int i3, long j_renamed) {
        if (c_renamed()) {
            return;
        }
        com.oplus.camera.u_renamed.a_renamed aVarA = this.d_renamed.a_renamed(i_renamed, i2, i3, true);
        if (c_renamed() || this.f5743b == null) {
            return;
        }
        if (g_renamed()) {
            a_renamed(aVarA);
            this.f5743b.a_renamed(aVarA);
        } else {
            this.f5743b.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
        }
        a_renamed(j_renamed, aVarA);
    }

    public void a_renamed(byte[] bArr, int i_renamed, int i2, long j_renamed) {
        if (this.h_renamed) {
            return;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("timestamp", j_renamed);
        messageObtain.what = 102;
        messageObtain.obj = bArr;
        messageObtain.arg1 = i_renamed;
        messageObtain.arg2 = i2;
        messageObtain.setData(bundle);
        this.g_renamed.sendMessage(messageObtain);
    }

    public void b_renamed(byte[] bArr, int i_renamed, int i2, long j_renamed) {
        com.oplus.camera.u_renamed.b_renamed bVar;
        this.h_renamed = true;
        if (!c_renamed() && (bVar = this.d_renamed) != null && this.f5743b != null) {
            com.oplus.camera.u_renamed.a_renamed aVarA = bVar.a_renamed(bArr, i_renamed, i2, a_renamed());
            if (!c_renamed()) {
                if (g_renamed()) {
                    a_renamed(aVarA);
                    this.f5743b.a_renamed(aVarA);
                } else {
                    this.f5743b.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
                }
                a_renamed(j_renamed, aVarA);
            }
        }
        this.h_renamed = false;
    }

    public boolean a_renamed(int i_renamed, int i2, int i3, int i4, long j_renamed) {
        com.oplus.camera.u_renamed.b_renamed bVar = this.d_renamed;
        if (bVar == null || !bVar.a_renamed(i_renamed, i2, i3, i4)) {
            return false;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 101;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("width", i2);
        bundle.putInt("height", i3);
        bundle.putInt("orientation", i4);
        bundle.putLong("timestamp", j_renamed);
        messageObtain.setData(bundle);
        this.g_renamed.sendMessage(messageObtain);
        com.oplus.camera.e_renamed.a_renamed("SuperTextManager", "setOesTextureId, sendMsg");
        return true;
    }

    public void e_renamed() {
        this.d_renamed.c_renamed();
    }

    public void f_renamed() {
        android.os.HandlerThread handlerThread = this.f_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        android.os.Handler handler = this.g_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.g_renamed = null;
        }
    }

    private void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        if (aVar == null || this.f5744c == null || !aVar.c_renamed() || !this.f5744c.c_renamed()) {
            this.f5744c = aVar;
            return;
        }
        android.graphics.PointF[] pointFArrB = aVar.b_renamed();
        android.graphics.PointF[] pointFArrB2 = this.f5744c.b_renamed();
        boolean[] zArr = new boolean[pointFArrB2.length];
        int i_renamed = 0;
        for (int i2 = 0; i2 < zArr.length; i2++) {
            zArr[i2] = false;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z_renamed = true;
            if (i3 >= pointFArrB.length) {
                break;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= pointFArrB2.length) {
                    z_renamed = false;
                    break;
                } else {
                    if (a_renamed(pointFArrB[i3], pointFArrB2[i6]) <= 1.0E-4f) {
                        pointFArrB[i3] = pointFArrB2[i6];
                        i4++;
                        zArr[i6] = true;
                        break;
                    }
                    i6++;
                }
            }
            if (!z_renamed) {
                i5 = i3;
            }
            i3++;
        }
        if (i4 == pointFArrB.length - 1) {
            while (true) {
                if (i_renamed >= pointFArrB2.length) {
                    break;
                }
                if (zArr[i_renamed]) {
                    i_renamed++;
                } else if (a_renamed(pointFArrB[i5], pointFArrB2[i_renamed]) <= 0.01f) {
                    pointFArrB[i5] = pointFArrB2[i_renamed];
                    com.oplus.camera.e_renamed.a_renamed("SuperTextManager", "optimisedResult, 3 points are reusable then reuse the fourth one");
                }
            }
        }
        this.f5744c = aVar;
    }

    private float a_renamed(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        float f_renamed = ((pointF.x_renamed - pointF2.x_renamed) * (pointF.x_renamed - pointF2.x_renamed)) + ((pointF.y_renamed - pointF2.y_renamed) * (pointF.y_renamed - pointF2.y_renamed));
        com.oplus.camera.e_renamed.a_renamed("SuperTextManager", "calcDiff, result: " + new java.math.BigDecimal(f_renamed) + ", p1: " + pointF + ", p2: " + pointF2);
        return f_renamed;
    }

    private boolean g_renamed() {
        synchronized (this.e_renamed) {
            if (this.i_renamed.size() < 5) {
                return true;
            }
            int i_renamed = 0;
            for (com.oplus.camera.u_renamed.a_renamed aVar : this.i_renamed.values()) {
                if (aVar != null && aVar.c_renamed()) {
                    i_renamed++;
                }
            }
            return i_renamed >= 3;
        }
    }
}
