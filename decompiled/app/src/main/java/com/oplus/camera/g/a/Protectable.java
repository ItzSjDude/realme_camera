package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifIFD.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f4548a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.c_renamed> f4549b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.b_renamed> f4550c = null;
    public com.oplus.camera.g_renamed.a_renamed.c_renamed d_renamed = null;
    public java.util.ArrayList<byte[]> e_renamed = null;
    public java.util.ArrayList<byte[]> f_renamed = null;
    public java.util.ArrayList<byte[]> g_renamed = null;
    public long h_renamed = 0;
    public java.nio.ByteOrder i_renamed = null;
    private int j_renamed = 0;

    public void a_renamed(java.nio.ByteOrder byteOrder) {
        this.i_renamed = byteOrder;
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.f4550c)) {
            java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
            while (it.hasNext()) {
                it.next().f4545a = byteOrder;
            }
        }
        if (com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.f4549b)) {
            return;
        }
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.c_renamed> it2 = this.f4549b.iterator();
        while (it2.hasNext()) {
            it2.next().a_renamed(byteOrder);
        }
    }

    public boolean a_renamed(int i_renamed, int[] iArr) {
        com.oplus.camera.g_renamed.a_renamed.g_renamed gVar = com.oplus.camera.g_renamed.a_renamed.a_renamed.f4541a.get(java.lang.Integer.valueOf(i_renamed));
        if (gVar == null) {
            return false;
        }
        a_renamed(i_renamed, gVar.d_renamed.f4544c, iArr);
        return true;
    }

    public void a_renamed(int i_renamed, int i2, int[] iArr) {
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVar = new com.oplus.camera.g_renamed.a_renamed.b_renamed(this.i_renamed);
        bVar.g_renamed = new com.oplus.camera.g_renamed.a_renamed.f_renamed(i_renamed);
        bVar.h_renamed = new com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2(i2);
        bVar.a_renamed(iArr);
        this.f4550c.add(bVar);
    }

    public boolean a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.g_renamed.a_renamed.g_renamed gVar = com.oplus.camera.g_renamed.a_renamed.a_renamed.f4541a.get(java.lang.Integer.valueOf(i_renamed));
        if (gVar == null) {
            return false;
        }
        a_renamed(i_renamed, gVar.d_renamed.f4544c, str);
        return true;
    }

    public void a_renamed(int i_renamed, int i2, java.lang.String str) {
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVar = new com.oplus.camera.g_renamed.a_renamed.b_renamed(this.i_renamed);
        bVar.g_renamed = new com.oplus.camera.g_renamed.a_renamed.f_renamed(i_renamed);
        bVar.h_renamed = new com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2(i2);
        bVar.a_renamed(str);
        this.f4550c.add(bVar);
    }

    public com.oplus.camera.g_renamed.a_renamed.b_renamed a_renamed(int i_renamed) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f4550c.size()) {
                i2 = -1;
                break;
            }
            if (this.f4550c.get(i2).g_renamed.f4557a == i_renamed) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return null;
        }
        return this.f4550c.remove(i2);
    }

    public com.oplus.camera.g_renamed.a_renamed.b_renamed b_renamed(int i_renamed) {
        for (int i2 = 0; i2 < this.f4550c.size(); i2++) {
            if (this.f4550c.get(i2).g_renamed.f4557a == i_renamed) {
                return this.f4550c.get(i2);
            }
        }
        return null;
    }

    private int d_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        byteBuffer.position(i_renamed);
        this.f4548a = this.f4550c.size();
        byteBuffer.putShort((short) this.f4548a);
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            byteBuffer.putShort((short) next.g_renamed.f4557a);
            byteBuffer.putShort((short) next.h_renamed.f4544c);
            byteBuffer.putInt((int) next.i_renamed);
            long j_renamed = next.f4547c;
            next.e_renamed = byteBuffer.position();
            if (j_renamed > 4) {
                byteBuffer.putInt(this.j_renamed);
                int iPosition = byteBuffer.position();
                byteBuffer.position(this.j_renamed);
                try {
                    byteBuffer.put(next.j_renamed);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                byteBuffer.position(iPosition);
                this.j_renamed = (int) (this.j_renamed + j_renamed);
                int i2 = this.j_renamed;
                this.j_renamed = (int) (i2 + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(i2));
            } else {
                int iPosition2 = byteBuffer.position();
                byteBuffer.put(next.j_renamed);
                byteBuffer.position(iPosition2 + 4);
            }
        }
        return this.j_renamed;
    }

    public long a_renamed() {
        this.f4548a = this.f4550c.size();
        long j_renamed = (this.f4548a * 12) + 2;
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
        long length = 0;
        long jA = 0;
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            if (next.f4547c > 4) {
                jA += next.f4547c + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(next.f4547c);
            }
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.e_renamed)) {
            java.util.Iterator<byte[]> it2 = this.e_renamed.iterator();
            while (it2.hasNext()) {
                byte[] next2 = it2.next();
                length += next2.length + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(next2.length);
            }
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.f_renamed)) {
            java.util.Iterator<byte[]> it3 = this.f_renamed.iterator();
            while (it3.hasNext()) {
                byte[] next3 = it3.next();
                length += next3.length + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(next3.length);
            }
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.g_renamed)) {
            java.util.Iterator<byte[]> it4 = this.g_renamed.iterator();
            while (it4.hasNext()) {
                byte[] next4 = it4.next();
                length += next4.length + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(next4.length);
            }
        }
        return j_renamed + jA + length;
    }

    public void a_renamed(byte[] bArr) {
        this.e_renamed = new java.util.ArrayList<>();
        this.e_renamed.add(bArr);
        this.h_renamed = bArr.length;
        b_renamed(279).a_renamed(new int[]{(int) this.h_renamed});
    }

    public void a_renamed(java.nio.ByteBuffer byteBuffer) {
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
        java.util.ArrayList<java.lang.Object> arrayList = null;
        java.util.ArrayList<java.lang.Object> arrayList2 = null;
        java.util.ArrayList<java.lang.Object> arrayList3 = null;
        java.util.ArrayList<java.lang.Object> arrayList4 = null;
        java.util.ArrayList<java.lang.Object> arrayList5 = null;
        java.util.ArrayList<java.lang.Object> arrayList6 = null;
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            int i_renamed = next.g_renamed.f4557a;
            if (i_renamed == 273) {
                arrayList = next.k_renamed;
            } else if (i_renamed == 279) {
                arrayList2 = next.k_renamed;
            } else if (i_renamed == 324) {
                arrayList5 = next.k_renamed;
            } else if (i_renamed == 325) {
                arrayList6 = next.k_renamed;
            } else if (i_renamed == 513) {
                arrayList3 = next.k_renamed;
            } else if (i_renamed == 514) {
                arrayList4 = next.k_renamed;
            }
        }
        this.h_renamed = 0L;
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList) && !com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList2)) {
            this.e_renamed = new java.util.ArrayList<>();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                byte[] bArr = new byte[((java.lang.Integer) arrayList2.get(i2)).intValue()];
                try {
                    byteBuffer.position(((java.lang.Integer) arrayList.get(i2)).intValue());
                    byteBuffer.get(bArr, 0, bArr.length);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                this.h_renamed += bArr.length;
                this.e_renamed.add(bArr);
            }
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList3) && !com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList4)) {
            this.f_renamed = new java.util.ArrayList<>();
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                byte[] bArr2 = new byte[((java.lang.Integer) arrayList4.get(i3)).intValue()];
                byteBuffer.position(((java.lang.Integer) arrayList3.get(i3)).intValue());
                byteBuffer.get(bArr2, 0, bArr2.length);
                this.h_renamed += bArr2.length;
                this.f_renamed.add(bArr2);
            }
        }
        if (com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList5) || com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) arrayList6)) {
            return;
        }
        this.g_renamed = new java.util.ArrayList<>();
        for (int i4 = 0; i4 < arrayList5.size(); i4++) {
            byte[] bArr3 = new byte[((java.lang.Integer) arrayList6.get(i4)).intValue()];
            byteBuffer.position(((java.lang.Integer) arrayList5.get(i4)).intValue());
            byteBuffer.get(bArr3, 0, bArr3.length);
            this.h_renamed += bArr3.length;
            this.g_renamed.add(bArr3);
        }
    }

    public static com.oplus.camera.g_renamed.a_renamed.c_renamed a_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        if (byteBuffer == null) {
            return null;
        }
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
        cVar.f4548a = com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(byteBuffer.getShort(i_renamed));
        cVar.f4550c = new java.util.ArrayList<>(cVar.f4548a);
        for (int i2 = 0; i2 < cVar.f4548a; i2++) {
            cVar.f4550c.add(com.oplus.camera.g_renamed.a_renamed.b_renamed.a_renamed(byteBuffer, i_renamed + 2 + (i2 * 12)));
        }
        cVar.a_renamed(byteBuffer);
        return cVar;
    }

    private com.oplus.camera.g_renamed.a_renamed.b_renamed c_renamed(int i_renamed) {
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            if (next.g_renamed.f4557a == i_renamed) {
                return next;
            }
        }
        return null;
    }

    public int b_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        this.j_renamed = i_renamed + 2 + (this.f4550c.size() * 12) + 4;
        int i2 = this.j_renamed;
        this.j_renamed = (int) (i2 + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(i2));
        return d_renamed(byteBuffer, i_renamed);
    }

    public int c_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.e_renamed)) {
            i_renamed = a_renamed(byteBuffer, this.e_renamed, 273, i_renamed);
        }
        if (!com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.f_renamed)) {
            i_renamed = a_renamed(byteBuffer, this.f_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.KEY_INDEX, i_renamed);
        }
        return !com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed((java.util.List) this.g_renamed) ? a_renamed(byteBuffer, this.g_renamed, 324, i_renamed) : i_renamed;
    }

    private int a_renamed(java.nio.ByteBuffer byteBuffer, java.util.ArrayList<byte[]> arrayList, int i_renamed, int i2) {
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVarC = c_renamed(i_renamed);
        if (bVarC != null) {
            int i3 = (int) (arrayList.size() > 1 ? byteBuffer.getInt((int) bVarC.e_renamed) : bVarC.e_renamed);
            java.util.Iterator<byte[]> it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] next = it.next();
                byteBuffer.position(i2);
                byteBuffer.put(next);
                byteBuffer.position(i3);
                byteBuffer.putInt(i2);
                if (arrayList.size() > 1) {
                    i3 += 4;
                }
                i2 += next.length;
            }
        }
        return i2;
    }

    public void a_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed, int[] iArr) {
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVarC = c_renamed(i_renamed);
        if (bVarC == null || iArr.length < 1) {
            return;
        }
        int i2 = (int) (iArr.length > 1 ? byteBuffer.getInt((int) bVarC.e_renamed) : bVarC.e_renamed);
        if (iArr.length > 1) {
            int i3 = 0;
            for (int i4 : iArr) {
                byteBuffer.position((i3 * 4) + i2);
                byteBuffer.putInt(i4);
                i3++;
            }
            return;
        }
        byteBuffer.position((int) bVarC.e_renamed);
        byteBuffer.putInt(iArr[0]);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ExifIFD");
        sb.append(" : mEntryCount : ");
        sb.append(com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(java.lang.Integer.valueOf(this.f4548a)));
        sb.append(";\n_renamed");
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = this.f4550c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.g_renamed.a_renamed.b_renamed next = it.next();
            sb.append("ExifIFD");
            sb.append(" : exifEntry : ");
            sb.append(next.toString());
            sb.append(";\n_renamed");
        }
        return sb.toString();
    }
}
