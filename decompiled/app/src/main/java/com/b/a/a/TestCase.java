package com.b_renamed.a_renamed.a_renamed;

/* compiled from: AnimationManager.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    boolean f2327a;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f2328b;

    /* renamed from: c_renamed, reason: collision with root package name */
    long f2329c;
    long d_renamed;
    long e_renamed;
    private java.util.Map<java.lang.Integer, com.b_renamed.a_renamed.a_renamed.c_renamed> f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private int i_renamed;
    private int j_renamed;

    public com.b_renamed.a_renamed.a_renamed.e_renamed a_renamed(boolean z_renamed) {
        return this;
    }

    public e_renamed() {
        this(com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public e_renamed(long j_renamed) {
        this.f_renamed = new java.util.HashMap();
        this.g_renamed = false;
        this.h_renamed = false;
        this.f2327a = false;
        this.f2328b = false;
        this.f2329c = 0L;
        this.d_renamed = 0L;
        this.e_renamed = 0L;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.e_renamed = j_renamed < 1 ? com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS : j_renamed;
        this.j_renamed = (int) ((j_renamed * 30.0f) / 1000.0f);
        d_renamed();
        this.f_renamed.put(0, new com.b_renamed.a_renamed.a_renamed.c_renamed(this, 0));
    }

    public void a_renamed(long j_renamed) {
        this.e_renamed = j_renamed;
        this.j_renamed = (int) ((j_renamed * 30.0f) / 1000.0f);
        d_renamed();
    }

    private void d_renamed() {
        this.j_renamed += 5;
    }

    public com.b_renamed.a_renamed.a_renamed.e_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.j_renamed jVar) {
        if (jVar instanceof com.b_renamed.a_renamed.a_renamed.c_renamed) {
            com.b_renamed.a_renamed.a_renamed.c_renamed cVar = (com.b_renamed.a_renamed.a_renamed.c_renamed) jVar;
            com.b_renamed.a_renamed.n_renamed.a_renamed(!this.f_renamed.containsKey(java.lang.Integer.valueOf(cVar.f2323c)));
            this.f_renamed.put(java.lang.Integer.valueOf(cVar.f2323c), cVar);
        } else {
            a_renamed(0).a_renamed(jVar);
        }
        return this;
    }

    public com.b_renamed.a_renamed.a_renamed.c_renamed a_renamed(int i_renamed) {
        if (this.f_renamed.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            return this.f_renamed.get(java.lang.Integer.valueOf(i_renamed));
        }
        return null;
    }

    public void a_renamed() {
        c_renamed();
        this.f2328b = false;
        a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$e_renamed$LmysiJgAgWlX4SySnezuoPDoFP0
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                this.f_renamed$0.d_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed) obj);
            }
        });
        this.f2329c = java.lang.System.currentTimeMillis();
        this.d_renamed = 0L;
        a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$e_renamed$0r82rxXMXqBv6jbljtNdkTESh-Q_renamed
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                ((com.b_renamed.a_renamed.a_renamed.c_renamed) obj).b_renamed();
            }
        });
        this.h_renamed = false;
        if (com.b_renamed.a_renamed.c_renamed.a_renamed() != null) {
            com.b_renamed.a_renamed.c_renamed.a_renamed().c_renamed().a_renamed(this);
            this.g_renamed = true;
            b_renamed(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed cVar) {
        this.e_renamed = java.lang.Math.max(this.e_renamed, cVar.a_renamed());
    }

    public void a_renamed(java.util.function.Consumer<com.b_renamed.a_renamed.a_renamed.c_renamed> consumer) {
        java.util.Iterator<com.b_renamed.a_renamed.a_renamed.c_renamed> it = this.f_renamed.values().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public boolean b_renamed() {
        if (this.g_renamed && !this.h_renamed) {
            this.d_renamed = java.lang.Math.min(java.lang.System.currentTimeMillis() - this.f2329c, this.e_renamed);
            a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$e_renamed$urz0deaNPxIS6_YTT3SiVoVX8C4
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    this.f_renamed$0.b_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed) obj);
                }
            });
            int i_renamed = this.i_renamed;
            if (i_renamed == this.j_renamed) {
                this.h_renamed = true;
            } else {
                this.i_renamed = i_renamed + 1;
            }
        }
        return this.h_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed cVar) {
        cVar.a_renamed(this.i_renamed / this.j_renamed);
    }

    public void c_renamed() {
        this.i_renamed = 0;
        if (this.g_renamed) {
            a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$e_renamed$qRJZYqrm_kkhdIKfvvLKWkcvAnA
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    ((com.b_renamed.a_renamed.a_renamed.c_renamed) obj).d_renamed();
                }
            });
            this.g_renamed = false;
            b_renamed(2);
        }
        if (com.b_renamed.a_renamed.c_renamed.a_renamed() != null) {
            com.b_renamed.a_renamed.c_renamed.a_renamed().c_renamed().b_renamed(this);
        }
    }

    private void b_renamed(int i_renamed) {
        com.b_renamed.a_renamed.e_renamed eVarD;
        if (com.b_renamed.a_renamed.c_renamed.a_renamed() == null || (eVarD = com.b_renamed.a_renamed.c_renamed.a_renamed().d_renamed()) == null || eVarD.f2346a == null) {
            return;
        }
        if (i_renamed == 0) {
            com.b_renamed.a_renamed.b_renamed.c_renamed("SurfaceListener", "Calling onAnimationStart on_renamed " + eVarD.f2346a);
            eVarD.f2346a.a_renamed(this);
            return;
        }
        if (i_renamed == 1) {
            com.b_renamed.a_renamed.b_renamed.c_renamed("SurfaceListener", "Calling onAnimationComplete on_renamed " + eVarD.f2346a);
            eVarD.f2346a.b_renamed(this);
            return;
        }
        if (i_renamed != 2) {
            return;
        }
        com.b_renamed.a_renamed.b_renamed.c_renamed("SurfaceListener", "Calling onAnimationFinish on_renamed " + eVarD.f2346a);
        eVarD.f2346a.c_renamed(this);
    }
}
