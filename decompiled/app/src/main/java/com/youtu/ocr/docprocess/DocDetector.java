package com.youtu.ocr.docprocess;

/* loaded from: classes2.dex */
public class DocDetector implements com.youtu.ocr.docprocess.IText {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.youtu.ocr.docprocess.DocDetector f7772a;

    /* renamed from: b_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f7773b = !com.youtu.ocr.docprocess.DocDetector.class.desiredAssertionStatus();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f7774c;
    private static com.youtu.ocr.docprocess.a_renamed f_renamed;
    private int d_renamed = 25;
    private java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> e_renamed = new java.util.ArrayList(f7774c);

    public native java.lang.String FindQuadByTextureNative(boolean z_renamed);

    public native boolean SetOESTextureIDNative(int i_renamed, int i2, int i3, int i4);

    public native java.lang.String detectTextByByteNative(byte[] bArr, int i_renamed, int i2, int i3);

    public native boolean xnnInitedByByte(byte[] bArr);

    public native boolean xnnInitedByByteGPU(byte[] bArr, java.lang.String str);

    public native void xnnReleaseGLSource();

    static {
        java.lang.System.loadLibrary("YTCommon");
        java.lang.System.loadLibrary(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON);
        f7772a = new com.youtu.ocr.docprocess.DocDetector();
        f7774c = 10;
        f_renamed = new com.youtu.ocr.docprocess.a_renamed(f7774c, 1);
    }

    public com.youtu.ocr.docprocess.IText.DetectResult a_renamed(byte[] bArr, int i_renamed, int i2, int i3) {
        com.youtu.ocr.docprocess.IText.DetectResult detectResult = new com.youtu.ocr.docprocess.IText.DetectResult();
        com.google.gson.Gson gson = new com.google.gson.Gson();
        java.lang.String strReplace = detectTextByByteNative(bArr, i_renamed, i2, i3).replace("\\", "");
        if (strReplace.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        com.youtu.ocr.docprocess.IText.DetectResult detectResult2 = (com.youtu.ocr.docprocess.IText.DetectResult) gson.fromJson(strReplace, com.youtu.ocr.docprocess.IText.DetectResult.class);
        if (detectResult2.hasResult) {
            if (this.e_renamed.size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int i4 = detectResult2.pointArr[0].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i4 - list.get(list.size() - 1).pointArr[0].x_renamed)));
                int i5 = detectResult2.pointArr[0].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list2 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i5 - list2.get(list2.size() - 1).pointArr[0].y_renamed)));
                int i6 = detectResult2.pointArr[1].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list3 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i6 - list3.get(list3.size() - 1).pointArr[1].x_renamed)));
                int i7 = detectResult2.pointArr[1].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list4 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i7 - list4.get(list4.size() - 1).pointArr[1].y_renamed)));
                int i8 = detectResult2.pointArr[2].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list5 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i8 - list5.get(list5.size() - 1).pointArr[2].x_renamed)));
                int i9 = detectResult2.pointArr[2].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list6 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i9 - list6.get(list6.size() - 1).pointArr[2].y_renamed)));
                int i10 = detectResult2.pointArr[3].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list7 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i10 - list7.get(list7.size() - 1).pointArr[3].x_renamed)));
                int i11 = detectResult2.pointArr[3].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list8 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i11 - list8.get(list8.size() - 1).pointArr[3].y_renamed)));
                if (((java.lang.Integer) java.util.Collections.max(arrayList)).intValue() > this.d_renamed) {
                    this.e_renamed.clear();
                }
            }
        } else {
            this.e_renamed.clear();
        }
        if (detectResult2.hasResult) {
            if (this.e_renamed.size() < f7774c) {
                this.e_renamed.add(detectResult2);
            } else {
                this.e_renamed.remove(0);
                this.e_renamed.add(detectResult2);
            }
        }
        return a_renamed(detectResult2);
    }

    public boolean a_renamed(int i_renamed, int i2, int i3, int i4) {
        return SetOESTextureIDNative(i_renamed, i2, i3, i4);
    }

    public com.youtu.ocr.docprocess.IText.DetectResult a_renamed(boolean z_renamed) {
        com.youtu.ocr.docprocess.IText.DetectResult detectResult = new com.youtu.ocr.docprocess.IText.DetectResult();
        com.google.gson.Gson gson = new com.google.gson.Gson();
        java.lang.String strFindQuadByTextureNative = FindQuadByTextureNative(z_renamed);
        if (strFindQuadByTextureNative.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        com.youtu.ocr.docprocess.IText.DetectResult detectResult2 = (com.youtu.ocr.docprocess.IText.DetectResult) gson.fromJson(strFindQuadByTextureNative, com.youtu.ocr.docprocess.IText.DetectResult.class);
        if (detectResult2.hasResult) {
            if (this.e_renamed.size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int i_renamed = detectResult2.pointArr[0].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i_renamed - list.get(list.size() - 1).pointArr[0].x_renamed)));
                int i2 = detectResult2.pointArr[0].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list2 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i2 - list2.get(list2.size() - 1).pointArr[0].y_renamed)));
                int i3 = detectResult2.pointArr[1].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list3 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i3 - list3.get(list3.size() - 1).pointArr[1].x_renamed)));
                int i4 = detectResult2.pointArr[1].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list4 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i4 - list4.get(list4.size() - 1).pointArr[1].y_renamed)));
                int i5 = detectResult2.pointArr[2].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list5 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i5 - list5.get(list5.size() - 1).pointArr[2].x_renamed)));
                int i6 = detectResult2.pointArr[2].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list6 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i6 - list6.get(list6.size() - 1).pointArr[2].y_renamed)));
                int i7 = detectResult2.pointArr[3].x_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list7 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i7 - list7.get(list7.size() - 1).pointArr[3].x_renamed)));
                int i8 = detectResult2.pointArr[3].y_renamed;
                java.util.List<com.youtu.ocr.docprocess.IText.DetectResult> list8 = this.e_renamed;
                arrayList.add(java.lang.Integer.valueOf(java.lang.Math.abs(i8 - list8.get(list8.size() - 1).pointArr[3].y_renamed)));
                if (((java.lang.Integer) java.util.Collections.max(arrayList)).intValue() > this.d_renamed) {
                    this.e_renamed.clear();
                }
            }
        } else {
            this.e_renamed.clear();
        }
        if (detectResult2.hasResult) {
            if (this.e_renamed.size() < f7774c) {
                this.e_renamed.add(detectResult2);
            } else {
                this.e_renamed.remove(0);
                this.e_renamed.add(detectResult2);
            }
        }
        return a_renamed(detectResult2);
    }

    private com.youtu.ocr.docprocess.IText.DetectResult a_renamed(com.youtu.ocr.docprocess.IText.DetectResult detectResult) {
        com.youtu.ocr.docprocess.DocDetector docDetector = this;
        if (docDetector.e_renamed.size() < f7774c) {
            return detectResult;
        }
        double d_renamed = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        int i_renamed = 0;
        while (true) {
            double d9 = d6;
            if (i_renamed < f7774c) {
                if (docDetector.e_renamed.get(i_renamed).getHasResult()) {
                    double d10 = d8 + (docDetector.e_renamed.get(i_renamed).pointArr[0].x_renamed * f_renamed.a_renamed()[i_renamed]);
                    d_renamed += docDetector.e_renamed.get(i_renamed).pointArr[0].y_renamed * f_renamed.a_renamed()[i_renamed];
                    d2 += docDetector.e_renamed.get(i_renamed).pointArr[1].x_renamed * f_renamed.a_renamed()[i_renamed];
                    d3 += docDetector.e_renamed.get(i_renamed).pointArr[1].y_renamed * f_renamed.a_renamed()[i_renamed];
                    d4 += docDetector.e_renamed.get(i_renamed).pointArr[2].x_renamed * f_renamed.a_renamed()[i_renamed];
                    double d11 = d5 + (docDetector.e_renamed.get(i_renamed).pointArr[2].y_renamed * f_renamed.a_renamed()[i_renamed]);
                    double d12 = (docDetector.e_renamed.get(i_renamed).pointArr[3].x_renamed * f_renamed.a_renamed()[i_renamed]) + d9;
                    d7 += docDetector.e_renamed.get(i_renamed).pointArr[3].y_renamed * f_renamed.a_renamed()[i_renamed];
                    d5 = d11;
                    d6 = d12;
                    d8 = d10;
                } else {
                    d6 = d9;
                }
                i_renamed++;
                docDetector = this;
            } else {
                return new com.youtu.ocr.docprocess.IText.DetectResult(true, new android.graphics.Point[]{new android.graphics.Point((int) d8, (int) d_renamed), new android.graphics.Point((int) d2, (int) d3), new android.graphics.Point((int) d4, (int) d5), new android.graphics.Point((int) d9, (int) d7)});
            }
        }
    }
}
