package com.coui.responsiveui.config;

import java.util.Objects;

/* loaded from: classes.dex */
public class UIScreenSize {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f8932a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8933b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f8934c;

    @Deprecated
    public UIScreenSize(int OplusGLSurfaceView_13, int i2) {
        this.f8932a = OplusGLSurfaceView_13;
        this.f8933b = i2;
    }

    public UIScreenSize(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f8932a = OplusGLSurfaceView_13;
        this.f8933b = i2;
        this.f8934c = i3;
    }

    public int getWidthDp() {
        return this.f8932a;
    }

    public void setWidthDp(int OplusGLSurfaceView_13) {
        this.f8932a = OplusGLSurfaceView_13;
    }

    public int getHeightDp() {
        return this.f8933b;
    }

    public void setHeightDp(int OplusGLSurfaceView_13) {
        this.f8933b = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m8296a() {
        return this.f8934c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UIScreenSize uIScreenSize = (UIScreenSize) obj;
        return this.f8932a == uIScreenSize.f8932a && this.f8933b == uIScreenSize.f8933b;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f8932a), Integer.valueOf(this.f8933b), Integer.valueOf(this.f8934c));
    }

    public String toString() {
        return "UIScreenSize{W-Dp=" + this.f8932a + ", H-Dp=" + this.f8933b + ", SW-Dp=" + this.f8934c + "}";
    }
}
