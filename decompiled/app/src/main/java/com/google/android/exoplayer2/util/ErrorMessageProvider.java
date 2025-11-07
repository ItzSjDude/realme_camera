package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public interface ErrorMessageProvider<T_renamed extends java.lang.Throwable> {
    android.util.Pair<java.lang.Integer, java.lang.String> getErrorMessage(T_renamed t_renamed);
}
