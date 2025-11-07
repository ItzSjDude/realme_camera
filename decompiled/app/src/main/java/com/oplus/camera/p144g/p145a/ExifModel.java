package com.oplus.camera.p144g.p145a;

import com.oplus.camera.CameraLog;
import com.oplus.camera.p144g.p145a.ExifDef;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ExifModel.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class ExifModel {

    /* renamed from: OplusGLSurfaceView_13 */
    public ByteBuffer f13796i;

    /* renamed from: PlatformImplementations.kt_3 */
    public ByteOrder f13788a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ExifIFH f13789b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<ExifIFD> f13790c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ArrayList<ExifIFD> f13791d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ArrayList<ExifIFD> f13792e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public ExifIFD f13793f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public ExifIFD f13794g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public ExifIFD f13795h = null;

    /* renamed from: OplusGLSurfaceView_15 */
    public ByteBuffer f13797j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    public int f13798k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private Runtime f13799l = null;

    public ExifModel(byte[] bArr) {
        this.f13796i = null;
        this.f13796i = ByteBuffer.wrap(bArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13762a(ExifIFD c2729c, long OplusGLSurfaceView_15) {
        ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(OplusGLSurfaceView_15), ZoneId.systemDefault());
        String str = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss").format(zonedDateTimeOfInstant) + "\u0000";
        String str2 = DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant) + "\u0000";
        String str3 = DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant) + "\u0000";
        ExifEntry c2728bM13744b = c2729c.m13744b(36867);
        ExifEntry c2728bM13744b2 = c2729c.m13744b(37521);
        ExifEntry c2728bM13744b3 = c2729c.m13744b(36881);
        if (c2728bM13744b == null) {
            c2729c.m13741a(36867, str);
        } else {
            c2728bM13744b.m13727a(str);
        }
        if (c2728bM13744b2 == null) {
            c2729c.m13741a(37521, str2);
        } else {
            c2728bM13744b2.m13727a(str2);
        }
        if (c2728bM13744b3 == null) {
            c2729c.m13741a(36881, str3);
        } else {
            c2728bM13744b3.m13727a(str3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13761a() {
        Iterator<ExifEntry> it = this.f13793f.f13777c.iterator();
        while (it.hasNext()) {
            ExifEntry next = it.next();
            ExifTagDef c2733g = ExifDef.f13758a.get(Integer.valueOf(next.f13770g.f13800a));
            if (c2733g != null) {
                if (c2733g.f13804c == 2) {
                    m13748a(next);
                    it.remove();
                }
                if (c2733g.f13804c == 3) {
                    m13750b(next);
                    it.remove();
                }
                if (c2733g.f13804c == 4) {
                    it.remove();
                }
            }
        }
        ExifIFD c2729c = this.f13793f;
        c2729c.f13775a = c2729c.f13777c.size();
        ExifIFD c2729c2 = this.f13794g;
        if (c2729c2 != null) {
            c2729c2.f13775a = c2729c2.f13777c.size();
            if (this.f13793f.m13744b(34665) == null) {
                this.f13793f.m13742a(34665, new int[]{0});
            }
        }
        ExifIFD c2729c3 = this.f13795h;
        if (c2729c3 != null) {
            c2729c3.f13775a = c2729c3.f13777c.size();
            if (this.f13793f.m13744b(34853) == null) {
                this.f13793f.m13742a(34853, new int[]{0});
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13748a(ExifEntry c2728b) {
        if (this.f13794g == null) {
            this.f13794g = new ExifIFD();
            this.f13794g.f13777c = new ArrayList<>();
        }
        this.f13794g.f13777c.add(c2728b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13750b(ExifEntry c2728b) {
        if (this.f13795h == null) {
            this.f13795h = new ExifIFD();
            this.f13795h.f13777c = new ArrayList<>();
        }
        this.f13795h.f13777c.add(c2728b);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m13751e() {
        if (ExifUtil.m13772a((List) this.f13791d)) {
            this.f13791d = new ArrayList<>();
        }
        ExifEntry c2728b = new ExifEntry(this.f13788a);
        c2728b.f13770g = new ExifTag(330);
        c2728b.f13771h = new ExifDef.PlatformImplementations.kt_3(4);
        c2728b.m13728a(new int[]{0, 0});
        this.f13793f.f13776b = new ArrayList<>();
        this.f13793f.f13777c.add(c2728b);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m13752f() {
        ExifIFD c2729c = new ExifIFD();
        c2729c.f13777c = ExifUtil.m13771a(this.f13793f.f13777c);
        c2729c.m13734a(330);
        c2729c.f13775a = c2729c.f13777c.size();
        c2729c.f13779e = this.f13793f.f13779e;
        c2729c.f13782h = this.f13793f.f13782h;
        this.f13793f.f13776b.add(c2729c);
        this.f13791d.add(c2729c);
        this.f13792e.clear();
        this.f13792e.add(c2729c);
        this.f13792e.add(this.f13793f);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m13753g() {
        this.f13793f.f13779e = new ArrayList<>();
        this.f13793f.m13744b(256).m13728a(new int[]{1});
        this.f13793f.m13744b(257).m13728a(new int[]{1});
        this.f13793f.m13744b(258).m13728a(new int[]{8, 8, 8});
        this.f13793f.m13744b(262).m13728a(new int[]{2});
        this.f13793f.m13744b(273).m13728a(new int[]{1});
        this.f13793f.m13744b(277).m13728a(new int[]{3});
        this.f13793f.m13744b(279).m13728a(new int[]{2});
        ExifIFD c2729c = this.f13793f;
        c2729c.f13780f = null;
        c2729c.m13744b(254).m13728a(new int[]{1});
        ExifIFD c2729c2 = this.f13793f;
        c2729c2.f13775a = c2729c2.f13777c.size();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13764b() {
        m13751e();
        m13752f();
        m13753g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13765c() {
        this.f13793f = ExifIFD.m13730a(this.f13796i, this.f13789b.f13787c);
        this.f13792e = new ArrayList<>();
        m13749a(this.f13793f);
        Iterator<ExifEntry> it = this.f13793f.f13777c.iterator();
        while (it.hasNext()) {
            ExifEntry next = it.next();
            int OplusGLSurfaceView_13 = next.f13770g.f13800a;
            if (OplusGLSurfaceView_13 == 330) {
                this.f13791d = new ArrayList<>();
                for (int i2 = 0; i2 < next.f13774k.size(); i2++) {
                    ExifIFD c2729cM13730a = ExifIFD.m13730a(this.f13796i, ((Integer) next.f13774k.get(i2)).intValue());
                    this.f13791d.add(c2729cM13730a);
                    m13749a(c2729cM13730a);
                }
            } else if (OplusGLSurfaceView_13 == 34665) {
                this.f13794g = ExifIFD.m13730a(this.f13796i, ((Integer) next.f13774k.get(0)).intValue());
                m13749a(this.f13794g);
            } else if (OplusGLSurfaceView_13 == 34853) {
                this.f13795h = ExifIFD.m13730a(this.f13796i, ((Integer) next.f13774k.get(0)).intValue());
                m13749a(this.f13795h);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13749a(ExifIFD c2729c) {
        if (c2729c.f13782h > 0) {
            int OplusGLSurfaceView_13 = 0;
            Iterator<ExifIFD> it = this.f13792e.iterator();
            while (it.hasNext()) {
                if (c2729c.f13782h < it.next().f13782h) {
                    break;
                } else {
                    OplusGLSurfaceView_13++;
                }
            }
            this.f13792e.add(OplusGLSurfaceView_13, c2729c);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m13754h() {
        ExifIFD c2729c = this.f13793f;
        int iM13733a = c2729c != null ? (int) (0 + c2729c.m13733a()) : 0;
        ExifIFD c2729c2 = this.f13794g;
        if (c2729c2 != null) {
            iM13733a = (int) (iM13733a + c2729c2.m13733a());
        }
        ExifIFD c2729c3 = this.f13795h;
        if (c2729c3 != null) {
            iM13733a = (int) (iM13733a + c2729c3.m13733a());
        }
        if (!ExifUtil.m13772a((List) this.f13791d)) {
            Iterator<ExifIFD> it = this.f13791d.iterator();
            while (it.hasNext()) {
                iM13733a = (int) (iM13733a + it.next().m13733a());
            }
        }
        return iM13733a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13766d() {
        int iM13754h = m13754h() + 100;
        if (m13763a(iM13754h)) {
            return;
        }
        this.f13798k = 0;
        this.f13797j = ByteBuffer.wrap(new byte[iM13754h]);
        this.f13797j.order(this.f13788a);
        m13756j();
        m13757k();
        m13758l();
        m13759m();
        m13760n();
        m13755i();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m13755i() {
        ArrayList<ExifIFD> arrayList = this.f13792e;
        if (arrayList == null) {
            return;
        }
        Iterator<ExifIFD> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f13798k = it.next().m13745c(this.f13797j, this.f13798k);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m13756j() {
        this.f13797j.put(this.f13796i.array(), 0, this.f13789b.f13787c);
        this.f13798k = this.f13789b.f13787c;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m13757k() {
        this.f13798k = this.f13793f.m13743b(this.f13797j, this.f13798k);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m13758l() {
        if (this.f13794g == null) {
            return;
        }
        this.f13793f.m13738a(this.f13797j, 34665, new int[]{this.f13798k});
        this.f13798k = this.f13794g.m13743b(this.f13797j, this.f13798k);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m13759m() {
        if (this.f13795h == null) {
            return;
        }
        this.f13793f.m13738a(this.f13797j, 34853, new int[]{this.f13798k});
        this.f13798k = this.f13795h.m13743b(this.f13797j, this.f13798k);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m13760n() {
        if (ExifUtil.m13772a((List) this.f13791d)) {
            return;
        }
        int[] iArr = new int[this.f13791d.size()];
        int OplusGLSurfaceView_13 = 0;
        Iterator<ExifIFD> it = this.f13791d.iterator();
        while (it.hasNext()) {
            ExifIFD next = it.next();
            int i2 = this.f13798k;
            iArr[OplusGLSurfaceView_13] = i2;
            OplusGLSurfaceView_13++;
            this.f13798k = next.m13743b(this.f13797j, i2);
        }
        this.f13793f.m13738a(this.f13797j, 330, iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ExifModel m13747a(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            return null;
        }
        ExifModel c2731e = new ExifModel(bArr);
        if (bArr[0] == 73) {
            c2731e.f13788a = ByteOrder.LITTLE_ENDIAN;
        } else {
            c2731e.f13788a = ByteOrder.BIG_ENDIAN;
        }
        c2731e.f13796i.order(c2731e.f13788a);
        c2731e.f13789b = ExifIFH.m13746a(c2731e.f13796i);
        c2731e.m13765c();
        return c2731e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13763a(long OplusGLSurfaceView_15) {
        if (this.f13799l == null) {
            this.f13799l = Runtime.getRuntime();
        }
        if (this.f13799l.maxMemory() - (this.f13799l.totalMemory() - this.f13799l.freeMemory()) > OplusGLSurfaceView_15) {
            return false;
        }
        CameraLog.m12954a("ExifModel", "checkMemory, realfree <= " + OplusGLSurfaceView_15);
        return true;
    }
}
