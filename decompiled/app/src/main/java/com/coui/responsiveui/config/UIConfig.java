package com.coui.responsiveui.config;

import java.util.Objects;

/* loaded from: classes.dex */
public class UIConfig {
    public static final int UNFOLDING_DURATION = 2650;

    /* renamed from: PlatformImplementations.kt_3 */
    private Status f8928a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8929b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private UIScreenSize f8930c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WindowType f8931d;

    public enum WindowType {
        SMALL,
        MEDIUM,
        LARGE
    }

    public UIConfig(Status status, UIScreenSize uIScreenSize, int OplusGLSurfaceView_13, WindowType windowType) {
        this.f8928a = status;
        this.f8930c = uIScreenSize;
        this.f8929b = OplusGLSurfaceView_13;
        this.f8931d = windowType;
    }

    public Status getStatus() {
        return this.f8928a;
    }

    public int getOrientation() {
        return this.f8929b;
    }

    public UIScreenSize getScreenSize() {
        return this.f8930c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m8295a(UIScreenSize uIScreenSize) {
        this.f8930c = uIScreenSize;
    }

    public WindowType getWindowType() {
        return this.f8931d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UIConfig uIConfig = (UIConfig) obj;
        return this.f8929b == uIConfig.f8929b && this.f8928a == uIConfig.f8928a && Objects.equals(this.f8930c, uIConfig.f8930c);
    }

    public int hashCode() {
        return Objects.hash(this.f8928a, Integer.valueOf(this.f8929b), this.f8930c);
    }

    public enum Status {
        FOLD("fd"),
        UNFOLDING("fding"),
        UNFOLD("ufd"),
        UNKNOWN("unknown");

        private String mName;

        Status(String str) {
            this.mName = "";
            this.mName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }

    public String toString() {
        return "UIConfig{mStatus= " + this.f8928a + ", mOrientation=" + this.f8929b + ", mScreenSize=" + this.f8930c + ", mWindowType=" + this.f8931d + "}";
    }
}
