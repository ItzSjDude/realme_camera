package com.coui.responsiveui.config;

/* loaded from: classes.dex */
public class UIConfig {
    public static final int UNFOLDING_DURATION = 2650;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.responsiveui.config.UIConfig.Status f3149a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3150b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.coui.responsiveui.config.UIScreenSize f3151c;
    private com.coui.responsiveui.config.UIConfig.WindowType d_renamed;

    public enum WindowType {
        SMALL,
        MEDIUM,
        LARGE
    }

    public UIConfig(com.coui.responsiveui.config.UIConfig.Status status, com.coui.responsiveui.config.UIScreenSize uIScreenSize, int i_renamed, com.coui.responsiveui.config.UIConfig.WindowType windowType) {
        this.f3149a = status;
        this.f3151c = uIScreenSize;
        this.f3150b = i_renamed;
        this.d_renamed = windowType;
    }

    public com.coui.responsiveui.config.UIConfig.Status getStatus() {
        return this.f3149a;
    }

    public int getOrientation() {
        return this.f3150b;
    }

    public com.coui.responsiveui.config.UIScreenSize getScreenSize() {
        return this.f3151c;
    }

    void a_renamed(com.coui.responsiveui.config.UIScreenSize uIScreenSize) {
        this.f3151c = uIScreenSize;
    }

    public com.coui.responsiveui.config.UIConfig.WindowType getWindowType() {
        return this.d_renamed;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.coui.responsiveui.config.UIConfig uIConfig = (com.coui.responsiveui.config.UIConfig) obj;
        return this.f3150b == uIConfig.f3150b && this.f3149a == uIConfig.f3149a && java.util.Objects.equals(this.f3151c, uIConfig.f3151c);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.f3149a, java.lang.Integer.valueOf(this.f3150b), this.f3151c);
    }

    public enum Status {
        FOLD("fd_renamed"),
        UNFOLDING("fding"),
        UNFOLD("ufd"),
        UNKNOWN("unknown");

        private java.lang.String mName;

        Status(java.lang.String str) {
            this.mName = "";
            this.mName = str;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.mName;
        }
    }

    public java.lang.String toString() {
        return "UIConfig{mStatus= " + this.f3149a + ", mOrientation=" + this.f3150b + ", mScreenSize=" + this.f3151c + ", mWindowType=" + this.d_renamed + "}";
    }
}
