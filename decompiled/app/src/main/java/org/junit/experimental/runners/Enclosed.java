package org.junit.experimental.runners;

/* loaded from: classes2.dex */
public class Enclosed extends org.junit.runners.Suite {
    public Enclosed(java.lang.Class<?> cls, org.junit.runners.model.RunnerBuilder runnerBuilder) throws java.lang.Throwable {
        super(runnerBuilder, cls, filterAbstractClasses(cls.getClasses()));
    }

    private static java.lang.Class<?>[] filterAbstractClasses(java.lang.Class<?>[] clsArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(clsArr.length);
        for (java.lang.Class<?> cls : clsArr) {
            if (!java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (java.lang.Class[]) arrayList.toArray(new java.lang.Class[arrayList.size()]);
    }
}
