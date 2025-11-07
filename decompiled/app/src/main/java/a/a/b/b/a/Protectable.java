package a_renamed.a_renamed.b_renamed.b_renamed.a_renamed;

/* loaded from: classes.dex */
public class c_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public static final android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed> n_renamed = new android.util.LruCache<>(5);
    public final java.util.List<java.lang.Integer> o_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed p_renamed;
    public int q_renamed;
    public int r_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed s_renamed;
    public int t_renamed;
    public boolean u_renamed;
    public boolean v_renamed;
    public java.util.Stack<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed> w_renamed;
    public int[] x_renamed;

    public class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f18a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f19b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f20c;
        public int d_renamed;

        public a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar, int i_renamed, int i2, int i3, int i4) {
            this.f18a = 0;
            this.f19b = 0;
            this.f20c = 0;
            this.d_renamed = 0;
            this.f18a = i_renamed;
            this.f19b = i2;
            this.f20c = i3;
            this.d_renamed = i4;
        }
    }

    public c_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, boolean z_renamed) {
        super(context, null);
        this.o_renamed = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(this, 0, 0, 0, 0);
        this.w_renamed = new java.util.Stack<>();
        this.x_renamed = new int[1];
        this.p_renamed = aVar;
        this.v_renamed = false;
        this.u_renamed = !z_renamed;
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed a_renamed(co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar;
        synchronized (n_renamed) {
            cVar = n_renamed.get(java.lang.Thread.currentThread().getName());
            if (cVar == null) {
                cVar = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed(context, null, false);
                cVar.a_renamed();
                n_renamed.put(java.lang.Thread.currentThread().getName(), cVar);
            }
            cVar.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        }
        return cVar;
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed l_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar;
        synchronized (n_renamed) {
            cVar = n_renamed.get(java.lang.Thread.currentThread().getName());
            if (cVar == null) {
                cVar = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed(null, null, false);
                cVar.a_renamed();
                n_renamed.put(java.lang.Thread.currentThread().getName(), cVar);
            }
            cVar.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        }
        return cVar;
    }

    public static void m_renamed() {
        n_renamed.evictAll();
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.w_renamed.push(this.s_renamed);
        this.s_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(this, i_renamed, i2, i3, i4);
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar) {
        this.p_renamed = aVar;
    }

    public void b_renamed(int i_renamed) {
        this.t_renamed = i_renamed;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
        this.q_renamed = i_renamed;
        this.r_renamed = i2;
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed aVar = this.s_renamed;
        aVar.f18a = 0;
        aVar.f19b = 0;
        aVar.f20c = i_renamed;
        aVar.d_renamed = i2;
        v_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void d_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        s_renamed();
        this.p_renamed.a_renamed(b_renamed());
        this.p_renamed.draw();
        n_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
        if (this.v_renamed) {
            return;
        }
        super.f_renamed();
    }

    public void finalize() throws java.lang.Throwable {
        p_renamed();
        super.finalize();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        android.opengl.GLES20.glGenFramebuffers(1, this.x_renamed, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.x_renamed[0]);
        this.o_renamed.add(java.lang.Integer.valueOf(this.x_renamed[0]));
        o_renamed();
    }

    public void n_renamed() {
        u_renamed();
    }

    public final boolean o_renamed() {
        android.opengl.GLES20.glBindFramebuffer(36160, this.x_renamed[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.t_renamed, 0);
        u_renamed();
        return false;
    }

    public void p_renamed() {
        android.opengl.GLES20.glDeleteFramebuffers(1, this.x_renamed, 0);
    }

    public int q_renamed() {
        return this.t_renamed;
    }

    public void r_renamed() {
        if (this.w_renamed.isEmpty()) {
            return;
        }
        this.s_renamed = this.w_renamed.pop();
    }

    public void s_renamed() {
        v_renamed();
        android.opengl.GLES20.glBindFramebuffer(36160, this.x_renamed[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.t_renamed, 0);
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed aVar = this.s_renamed;
        android.opengl.GLES20.glViewport(aVar.f18a, aVar.f19b, aVar.f20c, aVar.d_renamed);
    }

    public void t_renamed() {
        java.util.List<java.lang.Integer> list = this.o_renamed;
        if (list != null) {
            int[] iArr = new int[list.size()];
            java.util.Iterator<java.lang.Integer> it = this.o_renamed.iterator();
            int i_renamed = 0;
            while (it.hasNext()) {
                iArr[i_renamed] = it.next().intValue();
                i_renamed++;
            }
            android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
    }

    public final void u_renamed() {
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
    }

    public final void v_renamed() {
        if (this.u_renamed) {
            return;
        }
        this.p_renamed.a_renamed();
        this.p_renamed.c_renamed(this.q_renamed, this.r_renamed);
        this.u_renamed = true;
    }
}
