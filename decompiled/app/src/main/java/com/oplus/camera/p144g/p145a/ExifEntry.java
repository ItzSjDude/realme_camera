package com.oplus.camera.p144g.p145a;

import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.p144g.p145a.ExifDef;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ExifEntry.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ExifEntry {

    /* renamed from: PlatformImplementations.kt_3 */
    public ByteOrder f13764a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long f13765b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public long f13766c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public long f13767d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long f13768e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public byte[] f13769f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public ExifTag f13770g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public ExifDef.PlatformImplementations.kt_3 f13771h;

    /* renamed from: OplusGLSurfaceView_13 */
    public long f13772i;

    /* renamed from: OplusGLSurfaceView_15 */
    public byte[] f13773j;

    /* renamed from: OplusGLSurfaceView_5 */
    public ArrayList<Object> f13774k;

    public ExifEntry(ByteOrder byteOrder) {
        this.f13764a = null;
        this.f13765b = 0L;
        this.f13766c = 0L;
        this.f13767d = 0L;
        this.f13768e = 0L;
        this.f13769f = null;
        this.f13770g = null;
        this.f13771h = null;
        this.f13772i = 0L;
        this.f13773j = null;
        this.f13774k = null;
        this.f13764a = byteOrder;
    }

    public ExifEntry(ExifEntry c2728b) {
        this.f13764a = null;
        this.f13765b = 0L;
        this.f13766c = 0L;
        this.f13767d = 0L;
        this.f13768e = 0L;
        this.f13769f = null;
        this.f13770g = null;
        this.f13771h = null;
        this.f13772i = 0L;
        this.f13773j = null;
        this.f13774k = null;
        this.f13764a = c2728b.f13764a;
        this.f13770g = new ExifTag(c2728b.f13770g.f13800a);
        this.f13771h = new ExifDef.PlatformImplementations.kt_3(c2728b.f13771h.f13761c);
        this.f13772i = c2728b.f13772i;
        this.f13773j = new byte[c2728b.f13773j.length];
        this.f13769f = c2728b.f13769f;
        this.f13766c = c2728b.f13766c;
        byte[] bArr = c2728b.f13773j;
        byte[] bArr2 = this.f13773j;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f13774k = new ArrayList<>(c2728b.f13774k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13727a(String str) {
        this.f13774k = new ArrayList<>();
        byte[] bytes = str.getBytes();
        for (byte b2 : bytes) {
            this.f13774k.add(Byte.valueOf(b2));
        }
        this.f13772i = bytes.length;
        this.f13766c = this.f13772i * this.f13771h.f13763e;
        this.f13773j = bytes;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13728a(int[] iArr) {
        this.f13774k = new ArrayList<>();
        for (int OplusGLSurfaceView_13 : iArr) {
            this.f13774k.add(Integer.valueOf(OplusGLSurfaceView_13));
        }
        this.f13772i = iArr.length;
        this.f13766c = this.f13772i * this.f13771h.f13763e;
        this.f13773j = new byte[(int) this.f13766c];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f13773j);
        byteBufferWrap.order(this.f13764a);
        Iterator<Object> it = this.f13774k.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            int i2 = this.f13771h.f13763e;
            if (i2 == 1) {
                byteBufferWrap.put(((Byte) next).byteValue());
            } else if (i2 == 2) {
                byteBufferWrap.putShort((short) ((Integer) next).intValue());
            } else if (i2 == 4) {
                byteBufferWrap.putInt(((Integer) next).intValue());
            } else if (i2 == 8) {
                byteBufferWrap.putDouble(((Integer) next).intValue());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ExifEntry m13723a(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        if (byteBuffer == null) {
            return null;
        }
        ExifEntry c2728b = new ExifEntry(byteBuffer.order());
        c2728b.f13765b = OplusGLSurfaceView_13;
        c2728b.f13770g = new ExifTag(ExifUtil.m13767a(byteBuffer.getShort(OplusGLSurfaceView_13)));
        int i2 = OplusGLSurfaceView_13 + 2;
        c2728b.f13771h = new ExifDef.PlatformImplementations.kt_3(byteBuffer.getShort(i2));
        c2728b.f13772i = ExifUtil.m13768a(byteBuffer.getInt(i2 + 2));
        c2728b.f13766c = c2728b.f13771h.f13763e * c2728b.f13772i;
        int i3 = OplusGLSurfaceView_13 + 8;
        c2728b.f13767d = i3;
        long OplusGLSurfaceView_15 = c2728b.f13766c;
        if (OplusGLSurfaceView_15 > 4) {
            c2728b.f13773j = new byte[(int) OplusGLSurfaceView_15];
            byteBuffer.position(byteBuffer.getInt(i3));
            byteBuffer.get(c2728b.f13773j);
        } else {
            c2728b.f13773j = new byte[4];
            byteBuffer.position(i3);
            byteBuffer.get(c2728b.f13773j);
        }
        c2728b.m13726a(byteBuffer);
        return c2728b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Object m13724a(ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int i2) {
        switch (this.f13771h.f13761c) {
            case 3:
            case 8:
                return Short.valueOf(byteBuffer.getShort(i2));
            case 4:
            case 9:
            case 11:
                return Integer.valueOf(byteBuffer.getInt(i2));
            case 5:
            case 10:
            case 12:
                return Double.valueOf(byteBuffer.getDouble(i2));
            case 6:
            case 7:
            default:
                if (this.f13769f == null) {
                    this.f13769f = new byte[(int) this.f13772i];
                }
                byte b2 = byteBuffer.get(i2);
                this.f13769f[OplusGLSurfaceView_13] = b2;
                return Byte.valueOf(b2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13726a(ByteBuffer byteBuffer) {
        this.f13774k = new ArrayList<>();
        int OplusGLSurfaceView_13 = 0;
        if (this.f13766c <= 4) {
            while (OplusGLSurfaceView_13 < this.f13772i) {
                this.f13774k.add(m13724a(byteBuffer, OplusGLSurfaceView_13, (int) (this.f13765b + 8 + (this.f13771h.f13763e * OplusGLSurfaceView_13))));
                OplusGLSurfaceView_13++;
            }
        } else {
            int i2 = byteBuffer.getInt((int) this.f13767d);
            while (OplusGLSurfaceView_13 < this.f13772i) {
                this.f13774k.add(m13724a(byteBuffer, OplusGLSurfaceView_13, (this.f13771h.f13763e * OplusGLSurfaceView_13) + i2));
                OplusGLSurfaceView_13++;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m13725a() {
        int OplusGLSurfaceView_13 = this.f13771h.f13761c;
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 7) {
            return new String(this.f13769f);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f13774k.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Short) {
                sb.append(ExifUtil.m13767a(((Short) next).shortValue()));
                sb.append(" ; ");
            } else {
                sb.append(next.toString());
                sb.append(" ; ");
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mExifTag");
        sb.append(" : ");
        sb.append(this.f13770g.toString());
        sb.append(";");
        sb.append("    ");
        sb.append("mDataCount");
        sb.append(" : ");
        sb.append(this.f13772i);
        sb.append(";");
        sb.append("    ");
        sb.append("mTotalByteCount");
        sb.append(" : ");
        sb.append(this.f13766c);
        sb.append(";");
        sb.append("    ");
        sb.append("mValue");
        sb.append(" : ");
        sb.append(this.f13766c > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS ? "too many" : m13725a());
        return sb.toString();
    }
}
