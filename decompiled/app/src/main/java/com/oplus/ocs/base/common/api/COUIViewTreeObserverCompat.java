package com.oplus.ocs.base.common.api;

/* loaded from: classes2.dex */
class u_renamed<O_renamed extends com.oplus.ocs.base.common.api.a_renamed.c_renamed> implements android.os.Handler.Callback {

    /* renamed from: c_renamed, reason: collision with root package name */
    static java.util.Map<com.oplus.ocs.base.common.api.a_renamed.f_renamed, com.oplus.ocs.base.common.api.h_renamed> f7586c = new java.util.concurrent.ConcurrentHashMap();
    private static final java.lang.String d_renamed = "u_renamed";
    private static volatile com.oplus.ocs.base.common.api.u_renamed f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f7587a;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.oplus.ocs.base.common.b_renamed f7588b;
    private android.os.Looper e_renamed;

    public static com.oplus.ocs.base.common.api.u_renamed a_renamed(android.content.Context context) {
        if (f_renamed == null) {
            synchronized (com.oplus.ocs.base.common.api.u_renamed.class) {
                if (f_renamed == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("OplusApiManager", 9);
                    handlerThread.start();
                    if (handlerThread.getLooper() != null) {
                        f_renamed = new com.oplus.ocs.base.common.api.u_renamed(context, handlerThread.getLooper());
                    } else {
                        f_renamed = new com.oplus.ocs.base.common.api.u_renamed(context, android.os.Looper.getMainLooper());
                    }
                }
            }
        }
        return f_renamed;
    }

    private u_renamed(android.content.Context context, android.os.Looper looper) {
        if (context.getApplicationContext() != null) {
            this.f7587a = context.getApplicationContext();
        } else {
            this.f7587a = context;
        }
        this.e_renamed = looper;
        this.f7588b = new com.oplus.ocs.base.common.b_renamed(this.e_renamed, this);
    }

    final void a_renamed(com.oplus.ocs.base.common.api.a_renamed aVar) {
        android.os.Message messageObtainMessage = this.f7588b.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = aVar;
        this.f7588b.sendMessage(messageObtainMessage);
    }

    final void a_renamed(final com.oplus.ocs.base.common.api.g_renamed gVar, com.oplus.ocs.base.internal.a_renamed aVar) {
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(aVar, "clientsettings not be_renamed null");
        if (f7586c.containsKey(gVar.getApi().b_renamed())) {
            return;
        }
        com.oplus.ocs.base.common.api.v_renamed vVar = new com.oplus.ocs.base.common.api.v_renamed(this.f7587a, gVar.getApi(), gVar.f7548a, aVar);
        vVar.a_renamed(new com.oplus.ocs.base.common.api.s_renamed() { // from class: com.oplus.ocs.base.common.api.u_renamed.1
            @Override // com.oplus.ocs.base.common.api.s_renamed
            public final void a_renamed() {
                com.oplus.ocs.base.common.api.u_renamed.a_renamed(gVar.getApi().b_renamed());
            }
        });
        vVar.a_renamed(new com.oplus.ocs.base.common.api.r_renamed() { // from class: com.oplus.ocs.base.common.api.u_renamed.2
            @Override // com.oplus.ocs.base.common.api.r_renamed
            public final void a_renamed(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) {
                if (capabilityInfo != null) {
                    gVar.checkAuthResult(capabilityInfo);
                }
            }
        });
        f7586c.put(gVar.getApi().b_renamed(), vVar);
        a_renamed(gVar.getApi());
    }

    static void a_renamed(com.oplus.ocs.base.common.api.g_renamed gVar) {
        com.oplus.ocs.base.common.CapabilityInfo capabilityInfoA = com.oplus.ocs.base.common.api.c_renamed.a_renamed(gVar.getApi());
        if (capabilityInfoA != null) {
            gVar.checkAuthResult(capabilityInfoA);
        }
    }

    final void a_renamed(com.oplus.ocs.base.common.api.g_renamed gVar, final com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return;
        }
        if (gVar.isConnected()) {
            new android.os.Handler(handler == null ? android.os.Looper.getMainLooper() : handler.getLooper()) { // from class: com.oplus.ocs.base.common.api.u_renamed.3
                @Override // android.os.Handler
                public final void handleMessage(android.os.Message message) {
                    super.handleMessage(message);
                    com.oplus.ocs.base.common.api.f_renamed fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.a_renamed();
                    }
                }
            }.sendEmptyMessage(0);
        } else {
            hVar.a_renamed(fVar, handler);
        }
    }

    static void a_renamed(com.oplus.ocs.base.common.api.g_renamed gVar, com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return;
        }
        hVar.a_renamed(eVar, handler);
    }

    static android.os.IBinder b_renamed(com.oplus.ocs.base.common.api.g_renamed gVar) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return null;
        }
        return hVar.d_renamed();
    }

    static int c_renamed(com.oplus.ocs.base.common.api.g_renamed gVar) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return 0;
        }
        return hVar.e_renamed();
    }

    static com.oplus.ocs.base.common.AuthResult d_renamed(com.oplus.ocs.base.common.api.g_renamed gVar) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return null;
        }
        return hVar.f_renamed();
    }

    static boolean e_renamed(com.oplus.ocs.base.common.api.g_renamed gVar) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return false;
        }
        return hVar.c_renamed();
    }

    static <T_renamed> void a_renamed(com.oplus.ocs.base.common.api.g_renamed gVar, com.oplus.ocs.base.common.api.i_renamed<T_renamed> iVar) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(d_renamed, "addQueue " + gVar.getClass().getSimpleName());
        com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(gVar, "oplusApi not be_renamed null");
        if (!f7586c.containsKey(gVar.getApi().b_renamed()) || (hVar = f7586c.get(gVar.getApi().b_renamed())) == null) {
            return;
        }
        hVar.a_renamed(iVar);
    }

    static void a_renamed(com.oplus.ocs.base.common.api.a_renamed.f_renamed fVar) {
        f7586c.remove(fVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        com.oplus.ocs.base.common.api.h_renamed hVar;
        com.oplus.ocs.base.common.api.a_renamed aVar;
        com.oplus.ocs.base.common.api.h_renamed hVar2;
        com.oplus.ocs.base.b_renamed.b_renamed.a_renamed(d_renamed, "handle message " + message.what);
        int i_renamed = message.what;
        if (i_renamed == 0) {
            com.oplus.ocs.base.common.api.a_renamed aVar2 = (com.oplus.ocs.base.common.api.a_renamed) message.obj;
            if (aVar2 == null || aVar2.b_renamed() == null || (hVar = f7586c.get(aVar2.b_renamed())) == null) {
                return false;
            }
            hVar.a_renamed();
            return false;
        }
        if (i_renamed != 1 || (aVar = (com.oplus.ocs.base.common.api.a_renamed) message.obj) == null || aVar.b_renamed() == null || (hVar2 = f7586c.get(aVar.b_renamed())) == null) {
            return false;
        }
        hVar2.b_renamed();
        a_renamed(aVar.b_renamed());
        return false;
    }
}
