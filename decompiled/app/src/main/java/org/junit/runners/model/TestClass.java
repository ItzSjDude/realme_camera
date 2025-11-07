package org.junit.runners.model;

/* loaded from: classes2.dex */
public class TestClass implements org.junit.runners.model.Annotatable {
    private static final org.junit.runners.model.TestClass.FieldComparator FIELD_COMPARATOR;
    private static final org.junit.runners.model.TestClass.MethodComparator METHOD_COMPARATOR;
    private final java.lang.Class<?> clazz;
    private final java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<org.junit.runners.model.FrameworkField>> fieldsForAnnotations;
    private final java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<org.junit.runners.model.FrameworkMethod>> methodsForAnnotations;

    static {
        FIELD_COMPARATOR = new org.junit.runners.model.TestClass.FieldComparator();
        METHOD_COMPARATOR = new org.junit.runners.model.TestClass.MethodComparator();
    }

    public TestClass(java.lang.Class<?> cls) throws java.lang.SecurityException {
        this.clazz = cls;
        if (cls != null && cls.getConstructors().length > 1) {
            throw new java.lang.IllegalArgumentException("Test class can only have one constructor");
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
        scanAnnotatedMembers(linkedHashMap, linkedHashMap2);
        this.methodsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap);
        this.fieldsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap2);
    }

    protected void scanAnnotatedMembers(java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<org.junit.runners.model.FrameworkMethod>> map, java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<org.junit.runners.model.FrameworkField>> map2) throws java.lang.SecurityException {
        for (java.lang.Class<?> cls : getSuperClasses(this.clazz)) {
            for (java.lang.reflect.Method method : org.junit.internal.MethodSorter.getDeclaredMethods(cls)) {
                addToAnnotationLists(new org.junit.runners.model.FrameworkMethod(method), map);
            }
            for (java.lang.reflect.Field field : getSortedDeclaredFields(cls)) {
                addToAnnotationLists(new org.junit.runners.model.FrameworkField(field), map2);
            }
        }
    }

    private static java.lang.reflect.Field[] getSortedDeclaredFields(java.lang.Class<?> cls) {
        java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
        java.util.Arrays.sort(declaredFields, FIELD_COMPARATOR);
        return declaredFields;
    }

    protected static <T_renamed extends org.junit.runners.model.FrameworkMember<T_renamed>> void addToAnnotationLists(T_renamed t_renamed, java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<T_renamed>> map) {
        for (java.lang.annotation.Annotation annotation : t_renamed.getAnnotations()) {
            java.lang.Class<? extends java.lang.annotation.Annotation> clsAnnotationType = annotation.annotationType();
            java.util.List<T_renamed> annotatedMembers = getAnnotatedMembers(map, clsAnnotationType, true);
            if (t_renamed.isShadowedBy(annotatedMembers)) {
                return;
            }
            if (runsTopToBottom(clsAnnotationType)) {
                annotatedMembers.add(0, t_renamed);
            } else {
                annotatedMembers.add(t_renamed);
            }
        }
    }

    private static <T_renamed extends org.junit.runners.model.FrameworkMember<T_renamed>> java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<T_renamed>> makeDeeplyUnmodifiable(java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<T_renamed>> map) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<T_renamed>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), java.util.Collections.unmodifiableList(entry.getValue()));
        }
        return java.util.Collections.unmodifiableMap(linkedHashMap);
    }

    public java.util.List<org.junit.runners.model.FrameworkMethod> getAnnotatedMethods() {
        java.util.List<org.junit.runners.model.FrameworkMethod> listCollectValues = collectValues(this.methodsForAnnotations);
        java.util.Collections.sort(listCollectValues, METHOD_COMPARATOR);
        return listCollectValues;
    }

    public java.util.List<org.junit.runners.model.FrameworkMethod> getAnnotatedMethods(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return java.util.Collections.unmodifiableList(getAnnotatedMembers(this.methodsForAnnotations, cls, false));
    }

    public java.util.List<org.junit.runners.model.FrameworkField> getAnnotatedFields() {
        return collectValues(this.fieldsForAnnotations);
    }

    public java.util.List<org.junit.runners.model.FrameworkField> getAnnotatedFields(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return java.util.Collections.unmodifiableList(getAnnotatedMembers(this.fieldsForAnnotations, cls, false));
    }

    private <T_renamed> java.util.List<T_renamed> collectValues(java.util.Map<?, java.util.List<T_renamed>> map) {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator<java.util.List<T_renamed>> it = map.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next());
        }
        return new java.util.ArrayList(linkedHashSet);
    }

    private static <T_renamed> java.util.List<T_renamed> getAnnotatedMembers(java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<T_renamed>> map, java.lang.Class<? extends java.lang.annotation.Annotation> cls, boolean z_renamed) {
        if (!map.containsKey(cls) && z_renamed) {
            map.put(cls, new java.util.ArrayList());
        }
        java.util.List<T_renamed> list = map.get(cls);
        return list == null ? java.util.Collections.emptyList() : list;
    }

    private static boolean runsTopToBottom(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return cls.equals(org.junit.Before.class) || cls.equals(org.junit.BeforeClass.class);
    }

    private static java.util.List<java.lang.Class<?>> getSuperClasses(java.lang.Class<?> cls) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public java.lang.Class<?> getJavaClass() {
        return this.clazz;
    }

    public java.lang.String getName() {
        java.lang.Class<?> cls = this.clazz;
        return cls == null ? "null" : cls.getName();
    }

    public java.lang.reflect.Constructor<?> getOnlyConstructor() throws java.lang.SecurityException {
        java.lang.reflect.Constructor<?>[] constructors = this.clazz.getConstructors();
        org.junit.Assert.assertEquals(1L, constructors.length);
        return constructors[0];
    }

    @Override // org.junit.runners.model.Annotatable
    public java.lang.annotation.Annotation[] getAnnotations() {
        java.lang.Class<?> cls = this.clazz;
        if (cls == null) {
            return new java.lang.annotation.Annotation[0];
        }
        return cls.getAnnotations();
    }

    @Override // org.junit.runners.model.Annotatable
    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        java.lang.Class<?> cls2 = this.clazz;
        if (cls2 == null) {
            return null;
        }
        return (T_renamed) cls2.getAnnotation(cls);
    }

    public <T_renamed> java.util.List<T_renamed> getAnnotatedFieldValues(java.lang.Object obj, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.lang.Class<T_renamed> cls2) throws java.lang.IllegalArgumentException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.junit.runners.model.FrameworkField> it = getAnnotatedFields(cls).iterator();
        while (it.hasNext()) {
            try {
                java.lang.Object obj2 = it.next().get(obj);
                if (cls2.isInstance(obj2)) {
                    arrayList.add(cls2.cast(obj2));
                }
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw new java.lang.RuntimeException("How did getFields return a_renamed field we couldn't_renamed access?", e_renamed);
            }
        }
        return arrayList;
    }

    public <T_renamed> java.util.List<T_renamed> getAnnotatedMethodValues(java.lang.Object obj, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.lang.Class<T_renamed> cls2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : getAnnotatedMethods(cls)) {
            try {
                if (cls2.isAssignableFrom(frameworkMethod.getReturnType())) {
                    arrayList.add(cls2.cast(frameworkMethod.invokeExplosively(obj, new java.lang.Object[0])));
                }
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException("Exception in_renamed " + frameworkMethod.getName(), th);
            }
        }
        return arrayList;
    }

    public boolean isPublic() {
        return java.lang.reflect.Modifier.isPublic(this.clazz.getModifiers());
    }

    public boolean isANonStaticInnerClass() {
        return this.clazz.isMemberClass() && !java.lang.reflect.Modifier.isStatic(this.clazz.getModifiers());
    }

    public int hashCode() {
        java.lang.Class<?> cls = this.clazz;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.clazz == ((org.junit.runners.model.TestClass) obj).clazz;
    }

    private static class FieldComparator implements java.util.Comparator<java.lang.reflect.Field> {
        private FieldComparator() {
        }

        @Override // java.util.Comparator
        public int compare(java.lang.reflect.Field field, java.lang.reflect.Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    private static class MethodComparator implements java.util.Comparator<org.junit.runners.model.FrameworkMethod> {
        private MethodComparator() {
        }

        @Override // java.util.Comparator
        public int compare(org.junit.runners.model.FrameworkMethod frameworkMethod, org.junit.runners.model.FrameworkMethod frameworkMethod2) {
            return org.junit.internal.MethodSorter.NAME_ASCENDING.compare(frameworkMethod.getMethod(), frameworkMethod2.getMethod());
        }
    }
}
