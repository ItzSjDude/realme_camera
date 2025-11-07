package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifEntry.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.nio.ByteOrder f4545a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public long f4546b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public long f4547c;
    public long d_renamed;
    public long e_renamed;
    public byte[] f_renamed;
    public com.oplus.camera.g_renamed.a_renamed.f_renamed g_renamed;
    public com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2 h_renamed;
    public long i_renamed;
    public byte[] j_renamed;
    public java.util.ArrayList<java.lang.Object> k_renamed;

    public b_renamed(java.nio.ByteOrder byteOrder) {
        this.f4545a = null;
        this.f4546b = 0L;
        this.f4547c = 0L;
        this.d_renamed = 0L;
        this.e_renamed = 0L;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = 0L;
        this.j_renamed = null;
        this.k_renamed = null;
        this.f4545a = byteOrder;
    }

    public b_renamed(com.oplus.camera.g_renamed.a_renamed.b_renamed bVar) {
        this.f4545a = null;
        this.f4546b = 0L;
        this.f4547c = 0L;
        this.d_renamed = 0L;
        this.e_renamed = 0L;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = 0L;
        this.j_renamed = null;
        this.k_renamed = null;
        this.f4545a = bVar.f4545a;
        this.g_renamed = new com.oplus.camera.g_renamed.a_renamed.f_renamed(bVar.g_renamed.f4557a);
        this.h_renamed = new com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2(bVar.h_renamed.f4544c);
        this.i_renamed = bVar.i_renamed;
        this.j_renamed = new byte[bVar.j_renamed.length];
        this.f_renamed = bVar.f_renamed;
        this.f4547c = bVar.f4547c;
        byte[] bArr = bVar.j_renamed;
        byte[] bArr2 = this.j_renamed;
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.k_renamed = new java.util.ArrayList<>(bVar.k_renamed);
    }

    public void a_renamed(java.lang.String str) {
        this.k_renamed = new java.util.ArrayList<>();
        byte[] bytes = str.getBytes();
        for (byte b2 : bytes) {
            this.k_renamed.add(java.lang.Byte.valueOf(b2));
        }
        this.i_renamed = bytes.length;
        this.f4547c = this.i_renamed * this.h_renamed.e_renamed;
        this.j_renamed = bytes;
    }

    public void a_renamed(int[] iArr) {
        this.k_renamed = new java.util.ArrayList<>();
        for (int i_renamed : iArr) {
            this.k_renamed.add(java.lang.Integer.valueOf(i_renamed));
        }
        this.i_renamed = iArr.length;
        this.f4547c = this.i_renamed * this.h_renamed.e_renamed;
        this.j_renamed = new byte[(int) this.f4547c];
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(this.j_renamed);
        byteBufferWrap.order(this.f4545a);
        java.util.Iterator<java.lang.Object> it = this.k_renamed.iterator();
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            int i2 = this.h_renamed.e_renamed;
            if (i2 == 1) {
                byteBufferWrap.put(((java.lang.Byte) next).byteValue());
            } else if (i2 == 2) {
                byteBufferWrap.putShort((short) ((java.lang.Integer) next).intValue());
            } else if (i2 == 4) {
                byteBufferWrap.putInt(((java.lang.Integer) next).intValue());
            } else if (i2 == 8) {
                byteBufferWrap.putDouble(((java.lang.Integer) next).intValue());
            }
        }
    }

    public static com.oplus.camera.g_renamed.a_renamed.b_renamed a_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        if (byteBuffer == null) {
            return null;
        }
        com.oplus.camera.g_renamed.a_renamed.b_renamed bVar = new com.oplus.camera.g_renamed.a_renamed.b_renamed(byteBuffer.order());
        bVar.f4546b = i_renamed;
        bVar.g_renamed = new com.oplus.camera.g_renamed.a_renamed.f_renamed(com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(byteBuffer.getShort(i_renamed)));
        int i2 = i_renamed + 2;
        bVar.h_renamed = new com.oplus.camera.g_renamed.a_renamed.a_renamed.ExifDef_2(byteBuffer.getShort(i2));
        bVar.i_renamed = com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(byteBuffer.getInt(i2 + 2));
        bVar.f4547c = bVar.h_renamed.e_renamed * bVar.i_renamed;
        int i3 = i_renamed + 8;
        bVar.d_renamed = i3;
        long j_renamed = bVar.f4547c;
        if (j_renamed > 4) {
            bVar.j_renamed = new byte[(int) j_renamed];
            byteBuffer.position(byteBuffer.getInt(i3));
            byteBuffer.get(bVar.j_renamed);
        } else {
            bVar.j_renamed = new byte[4];
            byteBuffer.position(i3);
            byteBuffer.get(bVar.j_renamed);
        }
        bVar.a_renamed(byteBuffer);
        return bVar;
    }

    private java.lang.Object a_renamed(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) {
        switch (this.h_renamed.f4544c) {
            case 3:
            case 8:
                return java.lang.Short.valueOf(byteBuffer.getShort(i2));
            case 4:
            case 9:
            case 11:
                return java.lang.Integer.valueOf(byteBuffer.getInt(i2));
            case 5:
            case 10:
            case 12:
                return java.lang.Double.valueOf(byteBuffer.getDouble(i2));
            case 6:
            case 7:
            default:
                if (this.f_renamed == null) {
                    this.f_renamed = new byte[(int) this.i_renamed];
                }
                byte b2 = byteBuffer.get(i2);
                this.f_renamed[i_renamed] = b2;
                return java.lang.Byte.valueOf(b2);
        }
    }

    private void a_renamed(java.nio.ByteBuffer byteBuffer) {
        this.k_renamed = new java.util.ArrayList<>();
        int i_renamed = 0;
        if (this.f4547c <= 4) {
            while (i_renamed < this.i_renamed) {
                this.k_renamed.add(a_renamed(byteBuffer, i_renamed, (int) (this.f4546b + 8 + (this.h_renamed.e_renamed * i_renamed))));
                i_renamed++;
            }
        } else {
            int i2 = byteBuffer.getInt((int) this.d_renamed);
            while (i_renamed < this.i_renamed) {
                this.k_renamed.add(a_renamed(byteBuffer, i_renamed, (this.h_renamed.e_renamed * i_renamed) + i2));
                i_renamed++;
            }
        }
    }

    private java.lang.String a_renamed() {
        int i_renamed = this.h_renamed.f4544c;
        if (i_renamed == 1 || i_renamed == 2 || i_renamed == 6 || i_renamed == 7) {
            return new java.lang.String(this.f_renamed);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.Object> it = this.k_renamed.iterator();
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            if (next instanceof java.lang.Short) {
                sb.append(com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(((java.lang.Short) next).shortValue()));
                sb.append(" ; ");
            } else {
                sb.append(next.toString());
                sb.append(" ; ");
            }
        }
        return sb.toString();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("mExifTag");
        sb.append(" : ");
        sb.append(this.g_renamed.toString());
        sb.append(";");
        sb.append("    ");
        sb.append("mDataCount");
        sb.append(" : ");
        sb.append(this.i_renamed);
        sb.append(";");
        sb.append("    ");
        sb.append("mTotalByteCount");
        sb.append(" : ");
        sb.append(this.f4547c);
        sb.append(";");
        sb.append("    ");
        sb.append("mValue");
        sb.append(" : ");
        sb.append(this.f4547c > com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS ? "too many" : a_renamed());
        return sb.toString();
    }
}
