package com.airbnb.lottie.p088d;

import com.airbnb.lottie.p091f.Logger_3;

/* compiled from: FileExtension.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public enum FileExtension_2 {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    FileExtension_2(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension_2 forFile(String str) {
        for (FileExtension_2 enumC1139c : values()) {
            if (str.endsWith(enumC1139c.extension)) {
                return enumC1139c;
            }
        }
        Logger_3.m6100b("Unable to find correct extension for " + str);
        return JSON;
    }
}
