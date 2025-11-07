package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import java.util.Objects;

/* compiled from: ModeInfo.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class ModeInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f20579a = "OplusGLSurfaceView_5";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f20580b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20581c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20582d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20583e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20584f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f20585g = true;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f20586h = true;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f20587i = true;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f20588j = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f20589k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f20590l;

    public ModeInfo(Activity activity, int OplusGLSurfaceView_13, int i2) {
        this.f20580b = null;
        this.f20581c = -1;
        this.f20590l = 0;
        this.f20581c = OplusGLSurfaceView_13;
        this.f20580b = m21914a(activity, OplusGLSurfaceView_13);
        this.f20582d = i2;
        m21924b(m21916j());
        m21921a(m21915i());
        m21927c(m21917k());
        m21929d(m21918l());
        this.f20590l = this.f20586h ? activity.getColor(R.color.color_white_with_full_percent_transparency) : activity.getColor(R.color.color_white_with_10_percent_transparency);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m21915i() {
        return m21916j();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m21916j() {
        int OplusGLSurfaceView_13 = this.f20581c;
        return (20 == OplusGLSurfaceView_13 || 21 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m21917k() {
        int OplusGLSurfaceView_13 = this.f20581c;
        return (20 == OplusGLSurfaceView_13 || 21 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m21918l() {
        int OplusGLSurfaceView_13 = this.f20581c;
        return (28 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13 || 9 == OplusGLSurfaceView_13 || 17 == OplusGLSurfaceView_13 || 30 == OplusGLSurfaceView_13) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m21919a() {
        return this.f20580b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m21922b() {
        return this.f20581c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m21925c() {
        return this.f20582d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m21928d() {
        return this.f20583e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21920a(int OplusGLSurfaceView_13) {
        this.f20583e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m21914a(Activity activity, int OplusGLSurfaceView_13) {
        return activity.getString(HeadlineHelper.m20344a(HeadlineHelper.m20351d(OplusGLSurfaceView_13)));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21923b(int OplusGLSurfaceView_13) {
        this.f20584f = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m21930e() {
        return this.f20584f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m21932f() {
        return this.f20585g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21921a(boolean z) {
        this.f20585g = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m21933g() {
        return this.f20586h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21924b(boolean z) {
        this.f20586h = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21927c(boolean z) {
        this.f20587i = z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m21934h() {
        return this.f20588j;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21929d(boolean z) {
        this.f20588j = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21926c(int OplusGLSurfaceView_13) {
        this.f20590l = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21931e(boolean z) {
        this.f20589k = z;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ModeInfo) && this.f20581c == ((ModeInfo) obj).f20581c;
    }

    public int hashCode() {
        return Objects.hash(this.f20580b, Integer.valueOf(this.f20581c), Integer.valueOf(this.f20582d), Integer.valueOf(this.f20583e), Integer.valueOf(this.f20584f), Boolean.valueOf(this.f20585g), Boolean.valueOf(this.f20586h), Boolean.valueOf(this.f20587i), Boolean.valueOf(this.f20588j), Boolean.valueOf(this.f20589k), Integer.valueOf(this.f20590l));
    }
}
