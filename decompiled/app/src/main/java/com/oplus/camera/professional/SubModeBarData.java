package com.oplus.camera.professional;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;

/* compiled from: SubModeBarData.java */
/* renamed from: com.oplus.camera.professional.z */
/* loaded from: classes2.dex */
public class SubModeBarData {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f15817a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f15819c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f15820d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f15821e;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f15825i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f15818b = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15822f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ArrayList<String> f15823g = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ArrayList<String> f15824h = new ArrayList<>();

    public SubModeBarData(Context context) {
        this.f15817a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SubModeBarData m16140a(int OplusGLSurfaceView_13) {
        this.f15821e = this.f15817a.getResources().getString(OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SubModeBarData m16143b(int OplusGLSurfaceView_13) {
        this.f15822f = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SubModeBarData m16146c(int OplusGLSurfaceView_13) {
        this.f15818b = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SubModeBarData m16141a(String str) {
        this.f15819c = str;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SubModeBarData m16144b(String str) {
        this.f15820d = str;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public SubModeBarData m16148d(int OplusGLSurfaceView_13) {
        this.f15825i = this.f15817a.getResources().getString(OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public SubModeBarData m16150e(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        for (String str : this.f15817a.getResources().getStringArray(OplusGLSurfaceView_13)) {
            this.f15823g.add(str);
        }
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public SubModeBarData m16153f(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        for (String str : this.f15817a.getResources().getStringArray(OplusGLSurfaceView_13)) {
            this.f15824h.add(str);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m16142a() {
        return this.f15820d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<String> m16145b() {
        return this.f15823g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> m16147c() {
        return this.f15824h;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m16149d() {
        return this.f15825i;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m16151e() {
        return this.f15821e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m16152f() {
        return this.f15822f;
    }
}
