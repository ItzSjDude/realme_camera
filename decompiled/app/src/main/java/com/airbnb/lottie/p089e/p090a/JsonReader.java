package com.airbnb.lottie.p089e.p090a;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* compiled from: JsonReader.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String[] f5746g = new String[128];

    /* renamed from: PlatformImplementations.kt_3 */
    int f5747a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int[] f5748b = new int[32];

    /* renamed from: IntrinsicsJvm.kt_3 */
    String[] f5749c = new String[32];

    /* renamed from: IntrinsicsJvm.kt_5 */
    int[] f5750d = new int[32];

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f5751e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean f5752f;

    /* compiled from: JsonReader.java */
    /* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo5912a(PlatformImplementations.kt_3 aVar) throws IOException;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo5914a() throws IOException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo5916b() throws IOException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo5917c() throws IOException;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract void mo5918d() throws IOException;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract boolean mo5919e() throws IOException;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract IntrinsicsJvm.kt_4 mo5920f() throws IOException;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract String mo5921g() throws IOException;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public abstract void mo5922h() throws IOException;

    /* renamed from: OplusGLSurfaceView_13 */
    public abstract String mo5923i() throws IOException;

    /* renamed from: OplusGLSurfaceView_15 */
    public abstract boolean mo5924j() throws IOException;

    /* renamed from: OplusGLSurfaceView_5 */
    public abstract double mo5925k() throws IOException;

    /* renamed from: OplusGLSurfaceView_14 */
    public abstract int mo5926l() throws IOException;

    /* renamed from: OplusGLSurfaceView_6 */
    public abstract void mo5927m() throws IOException;

    static {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 31; OplusGLSurfaceView_13++) {
            f5746g[OplusGLSurfaceView_13] = String.format("\\u%04x", Integer.valueOf(OplusGLSurfaceView_13));
        }
        String[] strArr = f5746g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\IntrinsicsJvm.kt_4";
        strArr[10] = "\\OplusGLSurfaceView_11";
        strArr[13] = "\\r";
        strArr[12] = "\\COUIBaseListPopupWindow_12";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JsonReader m5909a(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    JsonReader() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m5915a(int OplusGLSurfaceView_13) {
        int i2 = this.f5747a;
        int[] iArr = this.f5748b;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new JsonDataException("Nesting too deep at " + m5928n());
            }
            this.f5748b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f5749c;
            this.f5749c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f5750d;
            this.f5750d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f5748b;
        int i3 = this.f5747a;
        this.f5747a = i3 + 1;
        iArr3[i3] = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final JsonEncodingException m5913a(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + m5928n());
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public final String m5928n() {
        return JsonScope.m5930a(this.f5747a, this.f5748b, this.f5749c, this.f5750d);
    }

    /* compiled from: JsonReader.java */
    /* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final String[] f5753a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Options f5754b;

        private PlatformImplementations.kt_3(String[] strArr, Options options) {
            this.f5753a = strArr;
            this.f5754b = options;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static PlatformImplementations.kt_3 m5929a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
                    JsonReader.m5911b(buffer, strArr[OplusGLSurfaceView_13]);
                    buffer.readByte();
                    byteStringArr[OplusGLSurfaceView_13] = buffer.readByteString();
                }
                return new PlatformImplementations.kt_3((String[]) strArr.clone(), Options.m26011of(byteStringArr));
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new AssertionError(COUIBaseListPopupWindow_8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m5911b(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.p089e.p090a.JsonReader.f5746g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p089e.p090a.JsonReader.m5911b(okio.BufferedSink, java.lang.String):void");
    }
}
