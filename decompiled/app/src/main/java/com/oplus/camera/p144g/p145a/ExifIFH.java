package com.oplus.camera.p144g.p145a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ExifIFH.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ExifIFH {

    /* renamed from: PlatformImplementations.kt_3 */
    public ByteOrder f13785a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public byte[] f13786b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f13787c = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public static ExifIFH m13746a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ExifIFH c2730d = new ExifIFH();
        c2730d.f13786b = new byte[2];
        c2730d.f13786b[0] = byteBuffer.get(0);
        c2730d.f13786b[1] = byteBuffer.get(1);
        c2730d.f13785a = byteBuffer.order();
        c2730d.f13787c = byteBuffer.getInt(4);
        return c2730d;
    }

    public String toString() {
        return "ExifIFH : mOrder[0] : " + ExifUtil.m13770a(Byte.valueOf(this.f13786b[0])) + ";\nExifIFH : mOrder[1] : " + ExifUtil.m13770a(Byte.valueOf(this.f13786b[1])) + ";\nExifIFH : mByteOrder : " + this.f13785a + ";\nExifIFH : mFirstIFDOffset : " + ExifUtil.m13770a(Integer.valueOf(this.f13787c)) + ";\OplusGLSurfaceView_11";
    }
}
