package org.junit.runner;

@java.lang.annotation.Inherited
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface RunWith {
    java.lang.Class<? extends org.junit.runner.Runner> value();
}
