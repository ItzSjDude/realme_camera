package com.google.protobuf;

/* loaded from: classes.dex */
interface MessageInfoFactory {
    boolean isSupported(java.lang.Class<?> cls);

    com.google.protobuf.MessageInfo messageInfoFor(java.lang.Class<?> cls);
}
