package com.oplus.camera.professional;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;

/* compiled from: HSSubModeBarData.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class HSSubModeBarData {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f15575a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f15577c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f15578d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f15579e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f15580f;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f15583i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f15576b = -1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ArrayList<String> f15581g = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ArrayList<String> f15582h = new ArrayList<>();

    public HSSubModeBarData(Context context) {
        this.f15575a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public HSSubModeBarData m15700a(int OplusGLSurfaceView_13) {
        this.f15579e = this.f15575a.getResources().getString(OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public HSSubModeBarData m15701a(String str) {
        this.f15580f = str;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public HSSubModeBarData m15703b(int OplusGLSurfaceView_13) {
        this.f15576b = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public HSSubModeBarData m15704b(String str) {
        this.f15577c = str;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public HSSubModeBarData m15707c(String str) {
        this.f15578d = str;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public HSSubModeBarData m15706c(int OplusGLSurfaceView_13) {
        this.f15583i = this.f15575a.getResources().getString(OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public HSSubModeBarData m15709d(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        for (String str : this.f15575a.getResources().getStringArray(OplusGLSurfaceView_13)) {
            this.f15581g.add(str);
        }
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public HSSubModeBarData m15711e(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        for (String str : this.f15575a.getResources().getStringArray(OplusGLSurfaceView_13)) {
            this.f15582h.add(str);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15702a() {
        return this.f15578d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<String> m15705b() {
        return this.f15581g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> m15708c() {
        return this.f15582h;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m15710d() {
        return this.f15583i;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m15712e() {
        return this.f15580f;
    }
}
