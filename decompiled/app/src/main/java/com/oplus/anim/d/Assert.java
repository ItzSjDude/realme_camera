package com.oplus.anim.d_renamed;

/* compiled from: FileExtension.java */
/* loaded from: classes2.dex */
public enum a_renamed {
    JSON(".json"),
    ZIP(".zip");

    public final java.lang.String extension;

    a_renamed(java.lang.String str) {
        this.extension = str;
    }

    public static com.oplus.anim.d_renamed.a_renamed forFile(java.lang.String str) {
        for (com.oplus.anim.d_renamed.a_renamed aVar : values()) {
            if (str.endsWith(aVar.extension)) {
                return aVar;
            }
        }
        com.oplus.anim.k_renamed.b_renamed("Unable to find correct extension for " + str);
        return JSON;
    }

    public java.lang.String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.extension;
    }
}
