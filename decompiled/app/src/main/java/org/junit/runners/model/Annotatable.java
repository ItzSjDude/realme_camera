package org.junit.runners.model;

/* loaded from: classes2.dex */
public interface Annotatable {
    <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls);

    java.lang.annotation.Annotation[] getAnnotations();
}
