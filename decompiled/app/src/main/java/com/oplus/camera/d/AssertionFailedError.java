package com.oplus.camera.d_renamed;

/* compiled from: Beauty3DManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f4363a;
    private com.oplus.camera.ui.beauty3d.g_renamed g_renamed;
    private com.oplus.camera.d_renamed.d_renamed h_renamed;
    private com.oplus.camera.d_renamed.c_renamed i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private volatile int f4364b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile boolean f4365c = false;
    private boolean d_renamed = false;
    private int e_renamed = 0;
    private com.oplus.camera.e_renamed.d_renamed f_renamed = null;
    private int[] j_renamed = {1};
    private int[] k_renamed = {2};
    private int[] l_renamed = {3};
    private int m_renamed = 0;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private android.os.Handler q_renamed = new android.os.Handler() { // from class: com.oplus.camera.d_renamed.b_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
            android.hardware.camera2.TotalCaptureResult totalCaptureResult = (android.hardware.camera2.TotalCaptureResult) message.obj;
            int i_renamed = message.what;
            if (i_renamed == 1) {
                com.oplus.camera.d_renamed.b_renamed.this.c_renamed(totalCaptureResult);
                return;
            }
            if (i_renamed == 2) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(totalCaptureResult);
            } else {
                if (i_renamed != 3) {
                    return;
                }
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(totalCaptureResult);
                com.oplus.camera.d_renamed.b_renamed.this.b_renamed(totalCaptureResult);
            }
        }
    };
    private com.oplus.camera.ui.beauty3d.g_renamed.a_renamed r_renamed = new com.oplus.camera.ui.beauty3d.g_renamed.a_renamed() { // from class: com.oplus.camera.d_renamed.b_renamed.2
        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void a_renamed() {
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.c_renamed();
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void b_renamed() {
            if (com.oplus.camera.d_renamed.b_renamed.this.f4364b == 1 || com.oplus.camera.d_renamed.b_renamed.this.h_renamed == null) {
                return;
            }
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(1);
            com.oplus.camera.d_renamed.b_renamed.this.h_renamed.d_renamed();
            com.oplus.camera.d_renamed.b_renamed.c_renamed(com.oplus.camera.d_renamed.b_renamed.this);
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void c_renamed() {
            if (com.oplus.camera.d_renamed.b_renamed.this.f4364b == 1 || com.oplus.camera.d_renamed.b_renamed.this.h_renamed == null) {
                return;
            }
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(1);
            com.oplus.camera.d_renamed.b_renamed.this.h_renamed.d_renamed();
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void a_renamed(boolean z_renamed) {
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.a_renamed(z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void d_renamed() {
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(0);
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.b_renamed(false);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void e_renamed() {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onEditSave");
            if (com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(com.oplus.camera.d_renamed.b_renamed.this.f4363a) == 0) {
                com.oplus.camera.ui.preview.a_renamed.o_renamed.c_renamed(com.oplus.camera.d_renamed.b_renamed.this.f4363a);
                com.oplus.camera.d_renamed.b_renamed.e_renamed(com.oplus.camera.d_renamed.b_renamed.this);
            }
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(0);
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.b_renamed(true);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void f_renamed() {
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.c_renamed(false);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void a_renamed(java.lang.String str, int[] iArr) {
            if ("com.oplus.beauty3d.mode".equals(str) && iArr != null && iArr[0] == 3) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(10);
            } else if ("com.oplus.beauty3d.scan.state".equals(str) && iArr != null) {
                com.oplus.camera.d_renamed.b_renamed.this.a_renamed(2);
            }
            if (iArr != null) {
                com.oplus.camera.d_renamed.b_renamed.this.b_renamed(str, iArr);
            }
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void g_renamed() {
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(8);
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.e_renamed();
            }
            com.oplus.camera.d_renamed.b_renamed.f_renamed(com.oplus.camera.d_renamed.b_renamed.this);
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void h_renamed() {
            com.oplus.camera.d_renamed.b_renamed.this.o_renamed();
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.f_renamed();
            }
            com.oplus.camera.d_renamed.b_renamed.g_renamed(com.oplus.camera.d_renamed.b_renamed.this);
        }

        @Override // com.oplus.camera.ui.beauty3d.g_renamed.a_renamed
        public void i_renamed() {
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(6);
            com.oplus.camera.d_renamed.b_renamed.this.a_renamed(false);
            if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                com.oplus.camera.d_renamed.b_renamed.this.h_renamed.b_renamed();
            }
            com.oplus.camera.d_renamed.b_renamed.this.d_renamed = false;
        }
    };

    static /* synthetic */ int c_renamed(com.oplus.camera.d_renamed.b_renamed bVar) {
        int i_renamed = bVar.m_renamed;
        bVar.m_renamed = i_renamed + 1;
        return i_renamed;
    }

    static /* synthetic */ int e_renamed(com.oplus.camera.d_renamed.b_renamed bVar) {
        int i_renamed = bVar.n_renamed;
        bVar.n_renamed = i_renamed + 1;
        return i_renamed;
    }

    static /* synthetic */ int f_renamed(com.oplus.camera.d_renamed.b_renamed bVar) {
        int i_renamed = bVar.p_renamed;
        bVar.p_renamed = i_renamed + 1;
        return i_renamed;
    }

    static /* synthetic */ int g_renamed(com.oplus.camera.d_renamed.b_renamed bVar) {
        int i_renamed = bVar.o_renamed;
        bVar.o_renamed = i_renamed + 1;
        return i_renamed;
    }

    public b_renamed(android.app.Activity activity, com.oplus.camera.d_renamed.d_renamed dVar) {
        this.f4363a = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.f4363a = activity;
        this.h_renamed = dVar;
        this.g_renamed = new com.oplus.camera.ui.beauty3d.g_renamed(activity);
        this.i_renamed = com.oplus.camera.d_renamed.c_renamed.a_renamed();
        this.i_renamed.a_renamed(activity);
    }

    public void a_renamed() {
        this.g_renamed.a_renamed(this.r_renamed);
    }

    public void b_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.d_renamed();
        }
        c_renamed();
    }

    public void c_renamed() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i_renamed = this.m_renamed;
        if (i_renamed > 0) {
            java.lang.String str = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_SCAN_CLICK, java.lang.String.valueOf(i_renamed));
            this.m_renamed = 0;
            sb.append(str);
        }
        int i2 = this.n_renamed;
        if (i2 > 0) {
            java.lang.String str2 = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_SAVE_CLICK, java.lang.String.valueOf(i2));
            this.n_renamed = 0;
            sb.append(str2);
        }
        int i3 = this.o_renamed;
        if (i3 > 0) {
            java.lang.String str3 = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_DELETE_CLICK, java.lang.String.valueOf(i3));
            this.o_renamed = 0;
            sb.append(str3);
        }
        int i4 = this.p_renamed;
        if (i4 > 0) {
            java.lang.String str4 = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_START_EDIT_CLICK, java.lang.String.valueOf(i4));
            this.p_renamed = 0;
            sb.append(str4);
        }
        if (sb.length() > 0) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.f4363a, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    public boolean d_renamed() {
        if (this.g_renamed == null) {
            return false;
        }
        a_renamed(false);
        return this.g_renamed.b_renamed(this.f4364b);
    }

    public void e_renamed() {
        java.util.HashMap<java.lang.String, int[]> mapN;
        if (this.h_renamed == null || (mapN = n_renamed()) == null) {
            return;
        }
        for (java.lang.String str : mapN.keySet()) {
            int[] iArr = mapN.get(str);
            if (iArr != null) {
                a_renamed(str, iArr);
            }
        }
    }

    public boolean a_renamed(java.lang.String str, int[] iArr) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar == null) {
            return false;
        }
        dVar.a_renamed(str, iArr);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "setBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    public boolean b_renamed(java.lang.String str, int[] iArr) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar == null) {
            return false;
        }
        dVar.a_renamed(str, iArr);
        this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "submitBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    public void a_renamed(android.util.Size size) {
        this.f4365c = false;
        if (this.f4364b == 3) {
            a_renamed(2);
        } else if (this.f4364b == 10) {
            com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
            if (gVar != null && gVar.k_renamed() != 0) {
                a_renamed(9);
            } else {
                a_renamed(8);
            }
        }
        b_renamed(size);
    }

    public int a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        if (!this.f4365c) {
            this.q_renamed.removeCallbacksAndMessages(null);
            return this.f4364b;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = captureResult;
        int i_renamed = this.f4364b;
        if (i_renamed == 3) {
            this.q_renamed.removeMessages(1);
            messageObtain.what = 1;
            this.q_renamed.sendMessage(messageObtain);
        } else if (i_renamed == 7) {
            this.q_renamed.removeMessages(2);
            messageObtain.what = 2;
            this.q_renamed.sendMessage(messageObtain);
        } else if (i_renamed == 10) {
            this.q_renamed.removeMessages(3);
            messageObtain.what = 3;
            this.q_renamed.sendMessage(messageObtain);
        }
        return this.f4364b;
    }

    public void a_renamed(com.oplus.camera.e_renamed.d_renamed dVar) {
        this.f_renamed = dVar;
        a_renamed(true);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DSessionConfigured, enterBeauty3D Mode");
    }

    public void b_renamed(com.oplus.camera.e_renamed.d_renamed dVar) {
        this.f_renamed = dVar;
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DCreateSession, enterBeauty3D Mode");
        if (this.f4364b == 6 || this.f4364b == 7) {
            a_renamed("com.oplus.beauty3d.mode", this.k_renamed);
            e_renamed();
            return;
        }
        if (this.f4364b == 1) {
            a_renamed("com.oplus.beauty3d.mode", this.j_renamed);
            a_renamed("com.oplus.beauty3d.scan.state", new int[]{0});
            return;
        }
        if (this.f4364b == 2) {
            a_renamed("com.oplus.beauty3d.mode", this.j_renamed);
            a_renamed("com.oplus.beauty3d.scan.state", new int[]{1});
            return;
        }
        if (this.f4364b == 8 || this.f4364b == 9) {
            a_renamed("com.oplus.beauty3d.mode", this.l_renamed);
            if (this.f4364b == 8) {
                a_renamed("com.oplus.beauty3d.analyses.rotatedegree", new int[]{0});
                a_renamed("com.oplus.beauty3d.custom.position", new int[]{0, 0});
            } else if (this.f4364b == 9) {
                e_renamed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.hardware.camera2.TotalCaptureResult totalCaptureResult) throws android.content.res.Resources.NotFoundException {
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(totalCaptureResult, com.oplus.camera.e_renamed.b_renamed.F_renamed);
        if (objA != null && (objA instanceof int[])) {
            int[] iArr = (int[]) objA;
            if (iArr.length == 6 && iArr[0] == 2) {
                c_renamed("com.oplus.beauty3d.analyses.result", java.util.Arrays.copyOfRange(iArr, 1, 6));
            }
        }
        java.lang.Object objA2 = com.oplus.camera.e_renamed.b_renamed.a_renamed(totalCaptureResult, com.oplus.camera.e_renamed.b_renamed.G_renamed);
        if (objA2 == null || !(objA2 instanceof int[])) {
            return;
        }
        int[] iArr2 = (int[]) objA2;
        if (iArr2.length == 11 && iArr2[0] == 3) {
            c_renamed("com.oplus.beauty3d.analyses.ffd", java.util.Arrays.copyOfRange(iArr2, 1, 11));
        }
    }

    public void b_renamed(android.hardware.camera2.CaptureResult captureResult) {
        if (this.f4364b == 2) {
            this.q_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.b_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.d_renamed.b_renamed.this.a_renamed(3);
                    com.oplus.camera.d_renamed.b_renamed.this.b_renamed(true);
                }
            });
        } else if (this.f4364b == 6) {
            this.q_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.b_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.d_renamed.b_renamed.this.a_renamed(7);
                    com.oplus.camera.d_renamed.b_renamed.this.d_renamed(true);
                }
            });
        } else if (this.f4364b == 8 || this.f4364b == 9) {
            this.q_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.b_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.d_renamed.b_renamed.this.a_renamed(10);
                    com.oplus.camera.d_renamed.b_renamed.this.d_renamed(true);
                }
            });
        }
        a_renamed(captureResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(android.hardware.camera2.TotalCaptureResult totalCaptureResult) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DEdit");
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(totalCaptureResult, com.oplus.camera.e_renamed.b_renamed.H_renamed);
        if (objA == null || !(objA instanceof int[])) {
            return;
        }
        int[] iArr = (int[]) objA;
        if (iArr.length == 2) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DEdit, styleResult.length: " + iArr.length);
            c_renamed("com.oplus.beauty3d.custom.result", iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(totalCaptureResult, com.oplus.camera.e_renamed.b_renamed.I_renamed);
        if (objA == null || !(objA instanceof int[])) {
            return;
        }
        int[] iArr = (int[]) objA;
        if (iArr.length < 2) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeautyScanResult, update hint: " + iArr[0]);
        int i_renamed = iArr[1];
        if (this.e_renamed != i_renamed) {
            this.e_renamed = i_renamed;
            b_renamed(i_renamed);
        }
        int i2 = iArr[0];
        if (i2 == 0) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeautyScanResult, BEAUTY3D_SCAN_SUCCESS");
            int i3 = iArr[1];
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeautyScanResult, update process: " + i3);
            if (i3 != 100 || this.d_renamed) {
                return;
            }
            b_renamed(100);
            this.d_renamed = true;
            this.q_renamed.removeMessages(1);
            l_renamed();
            return;
        }
        if (i2 == 1) {
            int i4 = iArr[1];
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeautyScanResult, update process: " + i4);
            b_renamed(i4);
            return;
        }
        if (i2 <= 19) {
            c_renamed(i2);
            return;
        }
        if (i2 >= 20) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeautyScanResult, updateHintValue: " + i2);
            a_renamed(false);
            c_renamed(i2);
            this.q_renamed.removeMessages(1);
            this.q_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.b_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.d_renamed.b_renamed.this.c_renamed(false);
                    if (com.oplus.camera.d_renamed.b_renamed.this.h_renamed != null) {
                        com.oplus.camera.d_renamed.b_renamed.this.h_renamed.a_renamed();
                    }
                }
            }, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    public int f_renamed() {
        return this.f4364b;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "setBeauty3DState, mBeauty3DState: " + this.f4364b + " -> " + i_renamed);
        this.f4364b = i_renamed;
    }

    private void c_renamed(int i_renamed) {
        java.lang.Integer numF = this.i_renamed.f_renamed(i_renamed);
        if (numF != null) {
            a_renamed(numF);
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.f4365c = z_renamed;
    }

    public boolean g_renamed() {
        return this.f4365c;
    }

    public void b_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DResume, beauty3dState: " + this.f4364b);
        if (this.g_renamed != null) {
            if (this.f4364b == 1) {
                com.oplus.camera.d_renamed.d_renamed dVar = this.h_renamed;
                if (dVar != null) {
                    dVar.c_renamed(true);
                }
                this.g_renamed.a_renamed(0, false, com.oplus.camera.util.Util.O_renamed(), com.oplus.camera.util.Util.N_renamed());
                this.g_renamed.d_renamed(false);
            } else if (this.f4364b == 2) {
                com.oplus.camera.d_renamed.d_renamed dVar2 = this.h_renamed;
                if (dVar2 != null) {
                    dVar2.c_renamed(true);
                }
                this.g_renamed.a_renamed(0, false);
                this.g_renamed.d_renamed(false);
            } else if (this.f4364b == 7 || this.f4364b == 9) {
                com.oplus.camera.d_renamed.d_renamed dVar3 = this.h_renamed;
                if (dVar3 != null) {
                    dVar3.c_renamed(true);
                }
                if (this.f4364b == 7 && this.g_renamed.k_renamed() != 1) {
                    if (this.g_renamed.k_renamed() == 0) {
                        this.g_renamed.a_renamed();
                    }
                    a_renamed(1, size);
                }
                this.g_renamed.f_renamed();
            } else if (this.f4364b == 8 || this.f4364b == 6) {
                com.oplus.camera.e_renamed.a_renamed("Beauty3DManager", "onBeauty3DResume, editUICurrentState: " + this.g_renamed.k_renamed());
                if (this.g_renamed.k_renamed() == 0) {
                    j_renamed();
                }
                a_renamed(this.f4364b == 8 ? 2 : 1, size);
                this.g_renamed.c_renamed(false);
            }
            if (this.f4364b != 0) {
                this.g_renamed.j_renamed();
            }
        }
    }

    public void h_renamed() {
        com.oplus.camera.d_renamed.d_renamed dVar = this.h_renamed;
        if (dVar != null) {
            dVar.c_renamed(false);
        }
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.a_renamed(0, false, com.oplus.camera.util.Util.O_renamed(), com.oplus.camera.util.Util.N_renamed());
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.d_renamed.d_renamed dVar = this.h_renamed;
        if (dVar != null) {
            dVar.c_renamed(false);
        }
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.d_renamed(z_renamed);
        }
    }

    public void c_renamed(android.util.Size size) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar == null || size == null) {
            return;
        }
        gVar.b_renamed(com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight()), com.oplus.camera.util.Util.a_renamed(size), com.oplus.camera.util.Util.O_renamed(), com.oplus.camera.util.Util.N_renamed());
    }

    public boolean i_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            return gVar.c_renamed();
        }
        return false;
    }

    public void j_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.a_renamed();
        }
    }

    public void k_renamed() {
        if (this.h_renamed != null) {
            a_renamed(false);
            a_renamed(1);
            this.h_renamed.d_renamed();
            this.m_renamed++;
        }
    }

    public void l_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.l_renamed();
        }
    }

    public void a_renamed(int i_renamed, android.util.Size size) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar == null || size == null) {
            return;
        }
        gVar.a_renamed(i_renamed, com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight()), com.oplus.camera.util.Util.a_renamed(size));
    }

    public void d_renamed(android.util.Size size) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar == null || size == null) {
            return;
        }
        gVar.c_renamed(com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight()), com.oplus.camera.util.Util.a_renamed(size), com.oplus.camera.util.Util.O_renamed(), com.oplus.camera.util.Util.N_renamed());
    }

    public void a_renamed(java.lang.Integer num) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.a_renamed(num);
        }
    }

    public void m_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.b_renamed();
        }
    }

    public void b_renamed(final int i_renamed) {
        android.app.Activity activity = this.f4363a;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.b_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.d_renamed.b_renamed.this.g_renamed != null) {
                        com.oplus.camera.d_renamed.b_renamed.this.g_renamed.a_renamed(i_renamed);
                    }
                }
            });
        }
    }

    public void c_renamed(java.lang.String str, int[] iArr) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.a_renamed(str, iArr);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.b_renamed(z_renamed);
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.d_renamed.d_renamed dVar = this.h_renamed;
        if (dVar != null) {
            dVar.c_renamed(false);
        }
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.c_renamed(z_renamed);
        }
    }

    public java.util.HashMap<java.lang.String, int[]> n_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            return gVar.g_renamed();
        }
        return null;
    }

    public void o_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.h_renamed();
        }
    }

    public void p_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.i_renamed();
        }
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.e_renamed(z_renamed);
        }
    }

    public void q_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.j_renamed();
        }
    }

    public void r_renamed() {
        com.oplus.camera.ui.beauty3d.g_renamed gVar = this.g_renamed;
        if (gVar != null) {
            gVar.e_renamed();
        }
        this.g_renamed = null;
        this.h_renamed = null;
        this.f4364b = 0;
    }
}
