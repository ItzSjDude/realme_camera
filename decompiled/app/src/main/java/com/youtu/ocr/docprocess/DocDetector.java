package com.youtu.ocr.docprocess;

import android.graphics.Point;
import com.google.gson.Gson;
import com.oplus.camera.aps.constant.ApsConstant;
import com.youtu.ocr.docprocess.IText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class DocDetector implements IText {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final DocDetector f24201a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final /* synthetic */ boolean f24202b = !DocDetector.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f24203c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static GussianBlur f24204f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f24205d = 25;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private List<IText.DetectResult> f24206e = new ArrayList(f24203c);

    public native String FindQuadByTextureNative(boolean z);

    public native boolean SetOESTextureIDNative(int OplusGLSurfaceView_13, int i2, int i3, int i4);

    public native String detectTextByByteNative(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3);

    public native boolean xnnInitedByByte(byte[] bArr);

    public native boolean xnnInitedByByteGPU(byte[] bArr, String str);

    public native void xnnReleaseGLSource();

    static {
        System.loadLibrary("YTCommon");
        System.loadLibrary(ApsConstant.CAPTURE_MODE_COMMON);
        f24201a = new DocDetector();
        f24203c = 10;
        f24204f = new GussianBlur(f24203c, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public IText.DetectResult m25552a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        IText.DetectResult detectResult = new IText.DetectResult();
        Gson gson = new Gson();
        String strReplace = detectTextByByteNative(bArr, OplusGLSurfaceView_13, i2, i3).replace("\\", "");
        if (strReplace.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        IText.DetectResult detectResult2 = (IText.DetectResult) gson.fromJson(strReplace, IText.DetectResult.class);
        if (detectResult2.hasResult) {
            if (this.f24206e.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i4 = detectResult2.pointArr[0].x;
                List<IText.DetectResult> list = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i4 - list.get(list.size() - 1).pointArr[0].x)));
                int i5 = detectResult2.pointArr[0].y;
                List<IText.DetectResult> list2 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i5 - list2.get(list2.size() - 1).pointArr[0].y)));
                int i6 = detectResult2.pointArr[1].x;
                List<IText.DetectResult> list3 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i6 - list3.get(list3.size() - 1).pointArr[1].x)));
                int i7 = detectResult2.pointArr[1].y;
                List<IText.DetectResult> list4 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i7 - list4.get(list4.size() - 1).pointArr[1].y)));
                int i8 = detectResult2.pointArr[2].x;
                List<IText.DetectResult> list5 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i8 - list5.get(list5.size() - 1).pointArr[2].x)));
                int i9 = detectResult2.pointArr[2].y;
                List<IText.DetectResult> list6 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i9 - list6.get(list6.size() - 1).pointArr[2].y)));
                int i10 = detectResult2.pointArr[3].x;
                List<IText.DetectResult> list7 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i10 - list7.get(list7.size() - 1).pointArr[3].x)));
                int i11 = detectResult2.pointArr[3].y;
                List<IText.DetectResult> list8 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i11 - list8.get(list8.size() - 1).pointArr[3].y)));
                if (((Integer) Collections.max(arrayList)).intValue() > this.f24205d) {
                    this.f24206e.clear();
                }
            }
        } else {
            this.f24206e.clear();
        }
        if (detectResult2.hasResult) {
            if (this.f24206e.size() < f24203c) {
                this.f24206e.add(detectResult2);
            } else {
                this.f24206e.remove(0);
                this.f24206e.add(detectResult2);
            }
        }
        return m25550a(detectResult2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25553a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return SetOESTextureIDNative(OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public IText.DetectResult m25551a(boolean z) {
        IText.DetectResult detectResult = new IText.DetectResult();
        Gson gson = new Gson();
        String strFindQuadByTextureNative = FindQuadByTextureNative(z);
        if (strFindQuadByTextureNative.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        IText.DetectResult detectResult2 = (IText.DetectResult) gson.fromJson(strFindQuadByTextureNative, IText.DetectResult.class);
        if (detectResult2.hasResult) {
            if (this.f24206e.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int OplusGLSurfaceView_13 = detectResult2.pointArr[0].x;
                List<IText.DetectResult> list = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(OplusGLSurfaceView_13 - list.get(list.size() - 1).pointArr[0].x)));
                int i2 = detectResult2.pointArr[0].y;
                List<IText.DetectResult> list2 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i2 - list2.get(list2.size() - 1).pointArr[0].y)));
                int i3 = detectResult2.pointArr[1].x;
                List<IText.DetectResult> list3 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i3 - list3.get(list3.size() - 1).pointArr[1].x)));
                int i4 = detectResult2.pointArr[1].y;
                List<IText.DetectResult> list4 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i4 - list4.get(list4.size() - 1).pointArr[1].y)));
                int i5 = detectResult2.pointArr[2].x;
                List<IText.DetectResult> list5 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i5 - list5.get(list5.size() - 1).pointArr[2].x)));
                int i6 = detectResult2.pointArr[2].y;
                List<IText.DetectResult> list6 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i6 - list6.get(list6.size() - 1).pointArr[2].y)));
                int i7 = detectResult2.pointArr[3].x;
                List<IText.DetectResult> list7 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i7 - list7.get(list7.size() - 1).pointArr[3].x)));
                int i8 = detectResult2.pointArr[3].y;
                List<IText.DetectResult> list8 = this.f24206e;
                arrayList.add(Integer.valueOf(Math.abs(i8 - list8.get(list8.size() - 1).pointArr[3].y)));
                if (((Integer) Collections.max(arrayList)).intValue() > this.f24205d) {
                    this.f24206e.clear();
                }
            }
        } else {
            this.f24206e.clear();
        }
        if (detectResult2.hasResult) {
            if (this.f24206e.size() < f24203c) {
                this.f24206e.add(detectResult2);
            } else {
                this.f24206e.remove(0);
                this.f24206e.add(detectResult2);
            }
        }
        return m25550a(detectResult2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private IText.DetectResult m25550a(IText.DetectResult detectResult) {
        DocDetector docDetector = this;
        if (docDetector.f24206e.size() < f24203c) {
            return detectResult;
        }
        double IntrinsicsJvm.kt_5 = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            double d9 = d6;
            if (OplusGLSurfaceView_13 < f24203c) {
                if (docDetector.f24206e.get(OplusGLSurfaceView_13).getHasResult()) {
                    double d10 = d8 + (docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[0].x * f24204f.m25554a()[OplusGLSurfaceView_13]);
                    IntrinsicsJvm.kt_5 += docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[0].y * f24204f.m25554a()[OplusGLSurfaceView_13];
                    d2 += docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[1].x * f24204f.m25554a()[OplusGLSurfaceView_13];
                    d3 += docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[1].y * f24204f.m25554a()[OplusGLSurfaceView_13];
                    d4 += docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[2].x * f24204f.m25554a()[OplusGLSurfaceView_13];
                    double d11 = d5 + (docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[2].y * f24204f.m25554a()[OplusGLSurfaceView_13]);
                    double d12 = (docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[3].x * f24204f.m25554a()[OplusGLSurfaceView_13]) + d9;
                    d7 += docDetector.f24206e.get(OplusGLSurfaceView_13).pointArr[3].y * f24204f.m25554a()[OplusGLSurfaceView_13];
                    d5 = d11;
                    d6 = d12;
                    d8 = d10;
                } else {
                    d6 = d9;
                }
                OplusGLSurfaceView_13++;
                docDetector = this;
            } else {
                return new IText.DetectResult(true, new Point[]{new Point((int) d8, (int) IntrinsicsJvm.kt_5), new Point((int) d2, (int) d3), new Point((int) d4, (int) d5), new Point((int) d9, (int) d7)});
            }
        }
    }
}
