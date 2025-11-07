package com.airbnb.lottie.d_renamed;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum c_renamed {
    JSON(".json"),
    ZIP(".zip");

    public final java.lang.String extension;

    c_renamed(java.lang.String str) {
        this.extension = str;
    }

    public java.lang.String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.extension;
    }

    public static com.airbnb.lottie.d_renamed.c_renamed forFile(java.lang.String str) {
        for (com.airbnb.lottie.d_renamed.c_renamed cVar : values()) {
            if (str.endsWith(cVar.extension)) {
                return cVar;
            }
        }
        com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Unable to find correct extension for " + str);
        return JSON;
    }
}
