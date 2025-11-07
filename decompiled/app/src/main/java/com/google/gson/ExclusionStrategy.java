package com.google.gson;

/* loaded from: classes.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(java.lang.Class<?> cls);

    boolean shouldSkipField(com.google.gson.FieldAttributes fieldAttributes);
}
