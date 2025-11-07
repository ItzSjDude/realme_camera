package com.oplus.camera.p144g.p145a;

import com.oplus.camera.p144g.p145a.ExifDef;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;

/* compiled from: ExifIFD.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ExifIFD {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f13775a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<ExifIFD> f13776b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<ExifEntry> f13777c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ExifIFD f13778d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ArrayList<byte[]> f13779e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public ArrayList<byte[]> f13780f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public ArrayList<byte[]> f13781g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public long f13782h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    public ByteOrder f13783i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13784j = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13739a(ByteOrder byteOrder) {
        this.f13783i = byteOrder;
        if (!ExifUtil.m13772a((List) this.f13777c)) {
            Iterator<ExifEntry> it = this.f13777c.iterator();
            while (it.hasNext()) {
                it.next().f13764a = byteOrder;
            }
        }
        if (ExifUtil.m13772a((List) this.f13776b)) {
            return;
        }
        Iterator<ExifIFD> it2 = this.f13776b.iterator();
        while (it2.hasNext()) {
            it2.next().m13739a(byteOrder);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13742a(int OplusGLSurfaceView_13, int[] iArr) {
        ExifTagDef c2733g = ExifDef.f13758a.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2733g == null) {
            return false;
        }
        m13736a(OplusGLSurfaceView_13, c2733g.f13805d.f13761c, iArr);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13736a(int OplusGLSurfaceView_13, int i2, int[] iArr) {
        ExifEntry c2728b = new ExifEntry(this.f13783i);
        c2728b.f13770g = new ExifTag(OplusGLSurfaceView_13);
        c2728b.f13771h = new ExifDef.PlatformImplementations.kt_3(i2);
        c2728b.m13728a(iArr);
        this.f13777c.add(c2728b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13741a(int OplusGLSurfaceView_13, String str) {
        ExifTagDef c2733g = ExifDef.f13758a.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2733g == null) {
            return false;
        }
        m13735a(OplusGLSurfaceView_13, c2733g.f13805d.f13761c, str);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13735a(int OplusGLSurfaceView_13, int i2, String str) {
        ExifEntry c2728b = new ExifEntry(this.f13783i);
        c2728b.f13770g = new ExifTag(OplusGLSurfaceView_13);
        c2728b.f13771h = new ExifDef.PlatformImplementations.kt_3(i2);
        c2728b.m13727a(str);
        this.f13777c.add(c2728b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ExifEntry m13734a(int OplusGLSurfaceView_13) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f13777c.size()) {
                i2 = -1;
                break;
            }
            if (this.f13777c.get(i2).f13770g.f13800a == OplusGLSurfaceView_13) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return null;
        }
        return this.f13777c.remove(i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ExifEntry m13744b(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f13777c.size(); i2++) {
            if (this.f13777c.get(i2).f13770g.f13800a == OplusGLSurfaceView_13) {
                return this.f13777c.get(i2);
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m13732d(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        byteBuffer.position(OplusGLSurfaceView_13);
        this.f13775a = this.f13777c.size();
        byteBuffer.putShort((short) this.f13775a);
        Iterator<ExifEntry> it = this.f13777c.iterator();
        while (it.hasNext()) {
            ExifEntry next = it.next();
            byteBuffer.putShort((short) next.f13770g.f13800a);
            byteBuffer.putShort((short) next.f13771h.f13761c);
            byteBuffer.putInt((int) next.f13772i);
            long OplusGLSurfaceView_15 = next.f13766c;
            next.f13768e = byteBuffer.position();
            if (OplusGLSurfaceView_15 > 4) {
                byteBuffer.putInt(this.f13784j);
                int iPosition = byteBuffer.position();
                byteBuffer.position(this.f13784j);
                try {
                    byteBuffer.put(next.f13773j);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                byteBuffer.position(iPosition);
                this.f13784j = (int) (this.f13784j + OplusGLSurfaceView_15);
                int i2 = this.f13784j;
                this.f13784j = (int) (i2 + ExifUtil.m13769a(i2));
            } else {
                int iPosition2 = byteBuffer.position();
                byteBuffer.put(next.f13773j);
                byteBuffer.position(iPosition2 + 4);
            }
        }
        return this.f13784j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m13733a() {
        this.f13775a = this.f13777c.size();
        long OplusGLSurfaceView_15 = (this.f13775a * 12) + 2;
        Iterator<ExifEntry> it = this.f13777c.iterator();
        long length = 0;
        long jM13769a = 0;
        while (it.hasNext()) {
            ExifEntry next = it.next();
            if (next.f13766c > 4) {
                jM13769a += next.f13766c + ExifUtil.m13769a(next.f13766c);
            }
        }
        if (!ExifUtil.m13772a((List) this.f13779e)) {
            Iterator<byte[]> it2 = this.f13779e.iterator();
            while (it2.hasNext()) {
                byte[] next2 = it2.next();
                length += next2.length + ExifUtil.m13769a(next2.length);
            }
        }
        if (!ExifUtil.m13772a((List) this.f13780f)) {
            Iterator<byte[]> it3 = this.f13780f.iterator();
            while (it3.hasNext()) {
                byte[] next3 = it3.next();
                length += next3.length + ExifUtil.m13769a(next3.length);
            }
        }
        if (!ExifUtil.m13772a((List) this.f13781g)) {
            Iterator<byte[]> it4 = this.f13781g.iterator();
            while (it4.hasNext()) {
                byte[] next4 = it4.next();
                length += next4.length + ExifUtil.m13769a(next4.length);
            }
        }
        return OplusGLSurfaceView_15 + jM13769a + length;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13740a(byte[] bArr) {
        this.f13779e = new ArrayList<>();
        this.f13779e.add(bArr);
        this.f13782h = bArr.length;
        m13744b(279).m13728a(new int[]{(int) this.f13782h});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13737a(ByteBuffer byteBuffer) {
        Iterator<ExifEntry> it = this.f13777c.iterator();
        ArrayList<Object> arrayList = null;
        ArrayList<Object> arrayList2 = null;
        ArrayList<Object> arrayList3 = null;
        ArrayList<Object> arrayList4 = null;
        ArrayList<Object> arrayList5 = null;
        ArrayList<Object> arrayList6 = null;
        while (it.hasNext()) {
            ExifEntry next = it.next();
            int OplusGLSurfaceView_13 = next.f13770g.f13800a;
            if (OplusGLSurfaceView_13 == 273) {
                arrayList = next.f13774k;
            } else if (OplusGLSurfaceView_13 == 279) {
                arrayList2 = next.f13774k;
            } else if (OplusGLSurfaceView_13 == 324) {
                arrayList5 = next.f13774k;
            } else if (OplusGLSurfaceView_13 == 325) {
                arrayList6 = next.f13774k;
            } else if (OplusGLSurfaceView_13 == 513) {
                arrayList3 = next.f13774k;
            } else if (OplusGLSurfaceView_13 == 514) {
                arrayList4 = next.f13774k;
            }
        }
        this.f13782h = 0L;
        if (!ExifUtil.m13772a((List) arrayList) && !ExifUtil.m13772a((List) arrayList2)) {
            this.f13779e = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                byte[] bArr = new byte[((Integer) arrayList2.get(i2)).intValue()];
                try {
                    byteBuffer.position(((Integer) arrayList.get(i2)).intValue());
                    byteBuffer.get(bArr, 0, bArr.length);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                this.f13782h += bArr.length;
                this.f13779e.add(bArr);
            }
        }
        if (!ExifUtil.m13772a((List) arrayList3) && !ExifUtil.m13772a((List) arrayList4)) {
            this.f13780f = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                byte[] bArr2 = new byte[((Integer) arrayList4.get(i3)).intValue()];
                byteBuffer.position(((Integer) arrayList3.get(i3)).intValue());
                byteBuffer.get(bArr2, 0, bArr2.length);
                this.f13782h += bArr2.length;
                this.f13780f.add(bArr2);
            }
        }
        if (ExifUtil.m13772a((List) arrayList5) || ExifUtil.m13772a((List) arrayList6)) {
            return;
        }
        this.f13781g = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList5.size(); i4++) {
            byte[] bArr3 = new byte[((Integer) arrayList6.get(i4)).intValue()];
            byteBuffer.position(((Integer) arrayList5.get(i4)).intValue());
            byteBuffer.get(bArr3, 0, bArr3.length);
            this.f13782h += bArr3.length;
            this.f13781g.add(bArr3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ExifIFD m13730a(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        if (byteBuffer == null) {
            return null;
        }
        ExifIFD c2729c = new ExifIFD();
        c2729c.f13775a = ExifUtil.m13767a(byteBuffer.getShort(OplusGLSurfaceView_13));
        c2729c.f13777c = new ArrayList<>(c2729c.f13775a);
        for (int i2 = 0; i2 < c2729c.f13775a; i2++) {
            c2729c.f13777c.add(ExifEntry.m13723a(byteBuffer, OplusGLSurfaceView_13 + 2 + (i2 * 12)));
        }
        c2729c.m13737a(byteBuffer);
        return c2729c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ExifEntry m13731c(int OplusGLSurfaceView_13) {
        Iterator<ExifEntry> it = this.f13777c.iterator();
        while (it.hasNext()) {
            ExifEntry next = it.next();
            if (next.f13770g.f13800a == OplusGLSurfaceView_13) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13743b(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        this.f13784j = OplusGLSurfaceView_13 + 2 + (this.f13777c.size() * 12) + 4;
        int i2 = this.f13784j;
        this.f13784j = (int) (i2 + ExifUtil.m13769a(i2));
        return m13732d(byteBuffer, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13745c(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        if (!ExifUtil.m13772a((List) this.f13779e)) {
            OplusGLSurfaceView_13 = m13729a(byteBuffer, this.f13779e, 273, OplusGLSurfaceView_13);
        }
        if (!ExifUtil.m13772a((List) this.f13780f)) {
            OplusGLSurfaceView_13 = m13729a(byteBuffer, this.f13780f, AbstractC0008a.KEY_INDEX, OplusGLSurfaceView_13);
        }
        return !ExifUtil.m13772a((List) this.f13781g) ? m13729a(byteBuffer, this.f13781g, 324, OplusGLSurfaceView_13) : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m13729a(ByteBuffer byteBuffer, ArrayList<byte[]> arrayList, int OplusGLSurfaceView_13, int i2) {
        ExifEntry c2728bM13731c = m13731c(OplusGLSurfaceView_13);
        if (c2728bM13731c != null) {
            int i3 = (int) (arrayList.size() > 1 ? byteBuffer.getInt((int) c2728bM13731c.f13768e) : c2728bM13731c.f13768e);
            Iterator<byte[]> it = arrayList.iterator();
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

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13738a(ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int[] iArr) {
        ExifEntry c2728bM13731c = m13731c(OplusGLSurfaceView_13);
        if (c2728bM13731c == null || iArr.length < 1) {
            return;
        }
        int i2 = (int) (iArr.length > 1 ? byteBuffer.getInt((int) c2728bM13731c.f13768e) : c2728bM13731c.f13768e);
        if (iArr.length > 1) {
            int i3 = 0;
            for (int i4 : iArr) {
                byteBuffer.position((i3 * 4) + i2);
                byteBuffer.putInt(i4);
                i3++;
            }
            return;
        }
        byteBuffer.position((int) c2728bM13731c.f13768e);
        byteBuffer.putInt(iArr[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExifIFD");
        sb.append(" : mEntryCount : ");
        sb.append(ExifUtil.m13770a(Integer.valueOf(this.f13775a)));
        sb.append(";\OplusGLSurfaceView_11");
        Iterator<ExifEntry> it = this.f13777c.iterator();
        while (it.hasNext()) {
            ExifEntry next = it.next();
            sb.append("ExifIFD");
            sb.append(" : exifEntry : ");
            sb.append(next.toString());
            sb.append(";\OplusGLSurfaceView_11");
        }
        return sb.toString();
    }
}
