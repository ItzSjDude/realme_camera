package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifModel.java */
/* loaded from: classes2.dex */
public class e_renamed {
    public java.nio.ByteBuffer i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.nio.ByteOrder f4554a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    public com.oplus.camera.g_renamed.a_renamed.d_renamed f4555b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.c_renamed> f4556c = null;
    public java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.c_renamed> d_renamed = null;
    public java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.c_renamed> e_renamed = null;
    public com.oplus.camera.g_renamed.a_renamed.c_renamed f_renamed = null;
    public com.oplus.camera.g_renamed.a_renamed.c_renamed g_renamed = null;
    public com.oplus.camera.g_renamed.a_renamed.c_renamed h_renamed = null;
    public java.nio.ByteBuffer j_renamed = null;
    public int k_renamed = 0;
    private java.lang.Runtime l_renamed = null;

    public e_renamed(byte[] bArr) {
        this.i_renamed = null;
        this.i_renamed = java.nio.ByteBuffer.wrap(bArr);
    }

    public void a_renamed(com.oplus.camera.g_renamed.a_renamed.c_renamed cVar, long j_renamed) {
        java.time.ZonedDateTime zonedDateTimeOfInstant = java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(j_renamed), java.time.ZoneId.systemDefault());
        java.lang.String str = java.time.format.DateTimeFormatter.ofPattern("yyyy:MM:dd_renamed HH:mm:ss").format(zonedDateTimeOfInstant) + "\u0000";
        java.lang.String str2 = java.time.format.DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant) + "\u0000";
        java.lang.String str3 = java.time.format.DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant) + "\u0000";
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVarB = cVar.b_renamed(36867);
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVarB2 = cVar.b_renamed(37521);
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVarB3 = cVar.b_renamed(36881);
        if (bVarB == null) {
            cVar.a_renamed(36867, str);
        } else {
            bVarB.a_renamed(str);
        }
        if (bVarB2 == null) {
            cVar.a_renamed(37521, str2);
        } else {
            bVarB2.a_renamed(str2);
        }
        if (bVarB3 == null) {
            cVar.a_renamed(36881, str3);
        } else {
            bVarB3.a_renamed(str3);
        }
    }

    public void a_renamed() {
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f_renamed.f4550c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            com.oplus.camera.g_renamed.a_renamed.g_renamed gVar = com.oplus.camera.g_renamed.a_renamed.a_renamed.f4541a.get(java.lang.Integer.valueOf(next.g_renamed.f4557a));
            if (gVar != null) {
                if (gVar.f4561c == 2) {
                    a_renamed(next);
                    it.remove();
                }
                if (gVar.f4561c == 3) {
                    b_renamed(next);
                    it.remove();
                }
                if (gVar.f4561c == 4) {
                    it.remove();
                }
            }
        }
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        cVar.f4548a = cVar.f4550c.size();
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar2 = this.g_renamed;
        if (cVar2 != null) {
            cVar2.f4548a = cVar2.f4550c.size();
            if (this.f_renamed.b_renamed(34665) == null) {
                this.f_renamed.a_renamed(34665, new int[]{0});
            }
        }
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar3 = this.h_renamed;
        if (cVar3 != null) {
            cVar3.f4548a = cVar3.f4550c.size();
            if (this.f_renamed.b_renamed(34853) == null) {
                this.f_renamed.a_renamed(34853, new int[]{0});
            }
        }
    }

    private void a_renamed(com.oplus.camera.g_renamed.a_renamed.b_renamed bVar) {
        if (this.g_renamed == null) {
            this.g_renamed = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
            this.g_renamed.f4550c = new java.util.ArrayList<>();
        }
        this.g_renamed.f4550c.add(bVar);
    }

    private void b_renamed(com.oplus.camera.g_renamed.a_renamed.b_renamed bVar) {
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
            this.h_renamed.f4550c = new java.util.ArrayList<>();
        }
        this.h_renamed.f4550c.add(bVar);
    }

    private void e_renamed() {
        if (com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.d_renamed)) {
            this.d_renamed = new java.util.ArrayList<>();
        }
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVar = new com.oplus.camera.g_renamed.a_renamed.b_renamed(this.f4554a);
        bVar.g_renamed = new com.oplus.camera.g_renamed.a_renamed.f_renamed(330);
        bVar.h_renamed = new com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2(4);
        bVar.a_renamed(new int[]{0, 0});
        this.f_renamed.f4549b = new java.util.ArrayList<>();
        this.f_renamed.f4550c.add(bVar);
    }

    private void f_renamed() {
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
        cVar.f4550c = com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(this.f_renamed.f4550c);
        cVar.a_renamed(330);
        cVar.f4548a = cVar.f4550c.size();
        cVar.e_renamed = this.f_renamed.e_renamed;
        cVar.h_renamed = this.f_renamed.h_renamed;
        this.f_renamed.f4549b.add(cVar);
        this.d_renamed.add(cVar);
        this.e_renamed.clear();
        this.e_renamed.add(cVar);
        this.e_renamed.add(this.f_renamed);
    }

    private void g_renamed() {
        this.f_renamed.e_renamed = new java.util.ArrayList<>();
        this.f_renamed.b_renamed(256).a_renamed(new int[]{1});
        this.f_renamed.b_renamed(257).a_renamed(new int[]{1});
        this.f_renamed.b_renamed(258).a_renamed(new int[]{8, 8, 8});
        this.f_renamed.b_renamed(262).a_renamed(new int[]{2});
        this.f_renamed.b_renamed(273).a_renamed(new int[]{1});
        this.f_renamed.b_renamed(277).a_renamed(new int[]{3});
        this.f_renamed.b_renamed(279).a_renamed(new int[]{2});
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        cVar.f_renamed = null;
        cVar.b_renamed(254).a_renamed(new int[]{1});
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar2 = this.f_renamed;
        cVar2.f4548a = cVar2.f4550c.size();
    }

    public void b_renamed() {
        e_renamed();
        f_renamed();
        g_renamed();
    }

    public void c_renamed() {
        this.f_renamed = com.oplus.camera.g_renamed.a_renamed.c_renamed.a_renamed(this.i_renamed, this.f4555b.f4553c);
        this.e_renamed = new java.util.ArrayList<>();
        a_renamed(this.f_renamed);
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f_renamed.f4550c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            int i_renamed = next.g_renamed.f4557a;
            if (i_renamed == 330) {
                this.d_renamed = new java.util.ArrayList<>();
                for (int i2 = 0; i2 < next.k_renamed.size(); i2++) {
                    com.oplus.camera.g_renamed.a_renamed.c_renamed cVarA = com.oplus.camera.g_renamed.a_renamed.c_renamed.a_renamed(this.i_renamed, ((java.lang.Integer) next.k_renamed.get(i2)).intValue());
                    this.d_renamed.add(cVarA);
                    a_renamed(cVarA);
                }
            } else if (i_renamed == 34665) {
                this.g_renamed = com.oplus.camera.g_renamed.a_renamed.c_renamed.a_renamed(this.i_renamed, ((java.lang.Integer) next.k_renamed.get(0)).intValue());
                a_renamed(this.g_renamed);
            } else if (i_renamed == 34853) {
                this.h_renamed = com.oplus.camera.g_renamed.a_renamed.c_renamed.a_renamed(this.i_renamed, ((java.lang.Integer) next.k_renamed.get(0)).intValue());
                a_renamed(this.h_renamed);
            }
        }
    }

    private void a_renamed(com.oplus.camera.g_renamed.a_renamed.c_renamed cVar) {
        if (cVar.h_renamed > 0) {
            int i_renamed = 0;
            java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.c_renamed> it = this.e_renamed.iterator();
            while (it.hasNext()) {
                if (cVar.h_renamed < it.next().h_renamed) {
                    break;
                } else {
                    i_renamed++;
                }
            }
            this.e_renamed.add(i_renamed, cVar);
        }
    }

    private int h_renamed() {
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        int iA = cVar != null ? (int) (0 + cVar.a_renamed()) : 0;
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar2 = this.g_renamed;
        if (cVar2 != null) {
            iA = (int) (iA + cVar2.a_renamed());
        }
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar3 = this.h_renamed;
        if (cVar3 != null) {
            iA = (int) (iA + cVar3.a_renamed());
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.d_renamed)) {
            java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.c_renamed> it = this.d_renamed.iterator();
            while (it.hasNext()) {
                iA = (int) (iA + it.next().a_renamed());
            }
        }
        return iA;
    }

    public void d_renamed() {
        int iH = h_renamed() + 100;
        if (a_renamed(iH)) {
            return;
        }
        this.k_renamed = 0;
        this.j_renamed = java.nio.ByteBuffer.wrap(new byte[iH]);
        this.j_renamed.order(this.f4554a);
        j_renamed();
        k_renamed();
        l_renamed();
        m_renamed();
        n_renamed();
        i_renamed();
    }

    private void i_renamed() {
        java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.c_renamed> arrayList = this.e_renamed;
        if (arrayList == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.c_renamed> it = arrayList.iterator();
        while (it.hasNext()) {
            this.k_renamed = it.next().c_renamed(this.j_renamed, this.k_renamed);
        }
    }

    private void j_renamed() {
        this.j_renamed.put(this.i_renamed.array(), 0, this.f4555b.f4553c);
        this.k_renamed = this.f4555b.f4553c;
    }

    private void k_renamed() {
        this.k_renamed = this.f_renamed.b_renamed(this.j_renamed, this.k_renamed);
    }

    private void l_renamed() {
        if (this.g_renamed == null) {
            return;
        }
        this.f_renamed.a_renamed(this.j_renamed, 34665, new int[]{this.k_renamed});
        this.k_renamed = this.g_renamed.b_renamed(this.j_renamed, this.k_renamed);
    }

    private void m_renamed() {
        if (this.h_renamed == null) {
            return;
        }
        this.f_renamed.a_renamed(this.j_renamed, 34853, new int[]{this.k_renamed});
        this.k_renamed = this.h_renamed.b_renamed(this.j_renamed, this.k_renamed);
    }

    private void n_renamed() {
        if (com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.d_renamed)) {
            return;
        }
        int[] iArr = new int[this.d_renamed.size()];
        int i_renamed = 0;
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.c_renamed> it = this.d_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.c_renamed next = it.next();
            int i2 = this.k_renamed;
            iArr[i_renamed] = i2;
            i_renamed++;
            this.k_renamed = next.b_renamed(this.j_renamed, i2);
        }
        this.f_renamed.a_renamed(this.j_renamed, 330, iArr);
    }

    public static com.oplus.camera.g_renamed.a_renamed.e_renamed a_renamed(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            return null;
        }
        com.oplus.camera.g_renamed.a_renamed.e_renamed eVar = new com.oplus.camera.g_renamed.a_renamed.e_renamed(bArr);
        if (bArr[0] == 73) {
            eVar.f4554a = java.nio.ByteOrder.LITTLE_ENDIAN;
        } else {
            eVar.f4554a = java.nio.ByteOrder.BIG_ENDIAN;
        }
        eVar.i_renamed.order(eVar.f4554a);
        eVar.f4555b = com.oplus.camera.g_renamed.a_renamed.d_renamed.a_renamed(eVar.i_renamed);
        eVar.c_renamed();
        return eVar;
    }

    public boolean a_renamed(long j_renamed) {
        if (this.l_renamed == null) {
            this.l_renamed = java.lang.Runtime.getRuntime();
        }
        if (this.l_renamed.maxMemory() - (this.l_renamed.totalMemory() - this.l_renamed.freeMemory()) > j_renamed) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("ExifModel", "checkMemory, realfree <= " + j_renamed);
        return true;
    }
}
