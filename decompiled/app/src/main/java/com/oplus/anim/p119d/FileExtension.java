package com.oplus.anim.p119d;

import com.oplus.anim.L;

/* compiled from: FileExtension.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension enumC2362a : values()) {
            if (str.endsWith(enumC2362a.extension)) {
                return enumC2362a;
            }
        }
        L.m9348b("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
