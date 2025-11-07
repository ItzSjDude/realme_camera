package com.oplus.camera.screen.a_renamed;

/* compiled from: ScreenSwitchController.java */
/* loaded from: classes2.dex */
public class e_renamed {
    private android.content.Context d_renamed;
    private android.os.Handler i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.ContentResolver f5355a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.a_renamed.a_renamed f5356b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.a_renamed.d_renamed f5357c = null;
    private int e_renamed = 1;
    private int f_renamed = -1;
    private int g_renamed = 0;
    private int h_renamed = com.oplus.camera.util.Util.i_renamed;
    private com.oplus.camera.capmode.BaseMode j_renamed = null;
    private java.util.ArrayList<java.lang.String> k_renamed = null;
    private boolean l_renamed = false;
    private final com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2 m_renamed = new com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2() { // from class: com.oplus.camera.screen.a_renamed.e_renamed.1
        @Override // com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2
        public void onEvent(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            com.oplus.camera.e_renamed.a_renamed("ScreenSwitchController", "onEvent, state: " + i_renamed);
            if (com.oplus.camera.screen.a_renamed.e_renamed.this.i_renamed == null || !com.oplus.camera.util.Util.u_renamed()) {
                return;
            }
            com.oplus.camera.screen.a_renamed.e_renamed eVar = com.oplus.camera.screen.a_renamed.e_renamed.this;
            if (eVar.e_renamed(eVar.h_renamed) != com.oplus.camera.screen.a_renamed.e_renamed.this.e_renamed(i_renamed)) {
                com.oplus.camera.util.Util.J_renamed();
                com.oplus.camera.screen.a_renamed.e_renamed.this.i_renamed.removeCallbacksAndMessages(null);
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 100;
                com.oplus.camera.screen.a_renamed.e_renamed.this.i_renamed.sendMessage(messageObtain);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public int e_renamed(int i_renamed) {
        if (i_renamed < 60) {
            return 3;
        }
        return i_renamed < 150 ? 2 : 1;
    }

    public e_renamed(android.content.Context context, com.oplus.camera.screen.a_renamed.a_renamed aVar) {
        this.d_renamed = null;
        this.i_renamed = null;
        this.d_renamed = context;
        a_renamed(aVar);
        com.oplus.camera.screen.FolderAngleDetectService.a_renamed(this.m_renamed);
        this.i_renamed = new android.os.Handler() { // from class: com.oplus.camera.screen.a_renamed.e_renamed.2
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                switch (message.what) {
                    case 100:
                        if (2 != com.oplus.camera.screen.a_renamed.e_renamed.this.e_renamed && 3 != com.oplus.camera.screen.a_renamed.e_renamed.this.e_renamed) {
                            com.oplus.camera.screen.a_renamed.e_renamed.this.h_renamed = com.oplus.camera.util.Util.i_renamed;
                            com.oplus.camera.screen.a_renamed.e_renamed.this.f5356b.b_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f5357c.a_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f_renamed, com.oplus.camera.util.Util.i_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.g_renamed, false, false), false, false);
                            com.oplus.camera.screen.a_renamed.e_renamed.this.l_renamed = false;
                            break;
                        }
                        break;
                    case 101:
                        com.oplus.camera.screen.a_renamed.e_renamed.this.f5356b.b_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f5357c.a_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f_renamed, com.oplus.camera.util.Util.i_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.g_renamed, true, false), false, true);
                        com.oplus.camera.screen.a_renamed.e_renamed eVar = com.oplus.camera.screen.a_renamed.e_renamed.this;
                        eVar.l_renamed = eVar.f5356b.a_renamed().o_renamed();
                        break;
                    case 102:
                        com.oplus.camera.screen.a_renamed.e_renamed.this.f5356b.b_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f5357c.a_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f_renamed, com.oplus.camera.util.Util.i_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.g_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.l_renamed, true), false, com.oplus.camera.screen.a_renamed.e_renamed.this.l_renamed);
                        break;
                    case 103:
                        com.oplus.camera.screen.a_renamed.e_renamed.this.f5356b.b_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f5357c.a_renamed(com.oplus.camera.screen.a_renamed.e_renamed.this.f_renamed, com.oplus.camera.util.Util.i_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.g_renamed, com.oplus.camera.screen.a_renamed.e_renamed.this.l_renamed, true), false, com.oplus.camera.screen.a_renamed.e_renamed.this.l_renamed);
                        break;
                }
            }
        };
    }

    private void a_renamed(com.oplus.camera.screen.a_renamed.a_renamed aVar) {
        this.f5355a = this.d_renamed.getContentResolver();
        this.f5357c = new com.oplus.camera.screen.a_renamed.d_renamed();
        this.f5356b = aVar;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "setOrientation, mOrientation: " + this.f_renamed + " --> " + i_renamed);
        if (i_renamed != this.f_renamed) {
            this.f_renamed = i_renamed;
            int i2 = this.e_renamed;
            if (2 == i2 || 3 == i2) {
                c_renamed(this.f_renamed);
                return;
            }
            com.oplus.camera.util.Util.f_renamed();
            this.i_renamed.removeCallbacksAndMessages(null);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 102;
            this.i_renamed.sendMessage(messageObtain);
        }
    }

    public void b_renamed(int i_renamed) {
        if (this.g_renamed != i_renamed) {
            com.oplus.camera.e_renamed.a_renamed("ScreenSwitchController", "updateCameraId, " + this.g_renamed + "-->" + i_renamed);
            this.g_renamed = i_renamed;
            this.i_renamed.removeCallbacksAndMessages(null);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 103;
            this.i_renamed.sendMessage(messageObtain);
        }
    }

    public void a_renamed(com.oplus.camera.capmode.BaseMode baseMode) {
        int i_renamed;
        com.oplus.camera.screen.f_renamed.a_renamed aVarA;
        if (baseMode == null || this.j_renamed == baseMode || 2 == (i_renamed = this.e_renamed) || 3 == i_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "updateCapMode, mode: " + baseMode.getCameraMode());
        this.j_renamed = baseMode;
        this.f5356b.a_renamed(baseMode);
        com.oplus.camera.screen.b_renamed.a_renamed aVarA2 = this.f5356b.a_renamed();
        com.oplus.camera.screen.f_renamed.a_renamed aVarI = this.f5356b.i_renamed();
        this.k_renamed = aVarA2.c_renamed();
        if (this.k_renamed == null) {
            return;
        }
        com.oplus.camera.screen.f_renamed.a_renamed preferredScreenMode = baseMode.getPreferredScreenMode(this.f_renamed);
        com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "updateCapMode, preferredScreenMode: " + preferredScreenMode);
        if ((this.k_renamed.contains(baseMode.getCameraMode()) && com.oplus.camera.screen.f_renamed.a_renamed.common != preferredScreenMode) || (com.oplus.camera.util.Util.u_renamed() && com.oplus.camera.screen.f_renamed.a_renamed.out == aVarI)) {
            com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "updateCapMode, notifyFolderChange, preferredScreenMode: " + preferredScreenMode);
            this.l_renamed = false;
            this.f5356b.b_renamed(preferredScreenMode, true, false);
            return;
        }
        if ((this.l_renamed && aVarA2.o_renamed()) || (aVarA = this.f5357c.a_renamed(this.f_renamed, com.oplus.camera.util.Util.i_renamed, this.g_renamed, false, false)) == this.f5356b.i_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "updateCapMode, targetScreenMode: " + aVarA);
        this.f5356b.b_renamed(aVarA, true, false);
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2) {
        if (z2 || !this.l_renamed) {
            this.h_renamed = com.oplus.camera.util.Util.i_renamed;
            com.oplus.camera.capmode.BaseMode baseMode = this.j_renamed;
            if (baseMode != null && baseMode.getLockedScreenMode() != null) {
                this.f5356b.b_renamed(this.j_renamed.getLockedScreenMode(), z2, z_renamed);
            } else {
                this.f5356b.b_renamed(this.f5357c.a_renamed(i_renamed, com.oplus.camera.util.Util.i_renamed, i2, z_renamed, false), z2, z_renamed);
            }
        }
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.screen.f_renamed.a_renamed aVar;
        com.oplus.camera.screen.f_renamed.a_renamed aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.common;
        if (-1 == com.oplus.camera.util.Util.g_renamed()) {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.common;
        } else if (com.oplus.camera.util.Util.g_renamed() == 0) {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.out;
        } else if (i_renamed == 0) {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.full;
        } else if (90 == i_renamed) {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.full270;
        } else if (270 == i_renamed) {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.full90;
        } else {
            aVar = com.oplus.camera.screen.f_renamed.a_renamed.full;
        }
        this.f5356b.b_renamed(aVar, false, false);
    }

    public void a_renamed() {
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.i_renamed = null;
        }
        this.d_renamed = null;
        com.oplus.camera.screen.FolderAngleDetectService.b_renamed(this.m_renamed);
    }

    public void a_renamed(com.oplus.camera.screen.f_renamed.a_renamed aVar) {
        com.oplus.camera.screen.a_renamed.d_renamed dVar = this.f5357c;
        dVar.f5354b = aVar;
        dVar.f5353a = aVar;
    }

    public void b_renamed() {
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 101;
            this.i_renamed.sendMessage(messageObtain);
        }
    }

    public int c_renamed() {
        return this.f_renamed;
    }

    public void d_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public boolean a_renamed(java.lang.String str) {
        com.oplus.camera.screen.f_renamed.a_renamed aVarValueOf = com.oplus.camera.screen.f_renamed.a_renamed.valueOf(str);
        boolean z_renamed = aVarValueOf != this.f5357c.a_renamed(this.f_renamed, com.oplus.camera.util.Util.i_renamed, this.g_renamed);
        boolean z2 = this.l_renamed && (aVarValueOf == com.oplus.camera.screen.f_renamed.a_renamed.left || aVarValueOf == com.oplus.camera.screen.f_renamed.a_renamed.right);
        com.oplus.camera.e_renamed.b_renamed("ScreenSwitchController", "checkIfScreenModeNeedChange, needChange: " + z_renamed + ", needLock: " + z2);
        return z_renamed && !z2;
    }
}
