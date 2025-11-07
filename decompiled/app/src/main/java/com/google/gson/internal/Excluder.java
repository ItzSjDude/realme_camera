package com.google.gson.internal;

/* loaded from: classes.dex */
public final class Excluder implements com.google.gson.TypeAdapterFactory, java.lang.Cloneable {
    public static final com.google.gson.internal.Excluder DEFAULT = new com.google.gson.internal.Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private java.util.List<com.google.gson.ExclusionStrategy> serializationStrategies = java.util.Collections.emptyList();
    private java.util.List<com.google.gson.ExclusionStrategy> deserializationStrategies = java.util.Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.gson.internal.Excluder m22clone() {
        try {
            return (com.google.gson.internal.Excluder) super.clone();
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    public com.google.gson.internal.Excluder withVersion(double d_renamed) {
        com.google.gson.internal.Excluder excluderM22clone = m22clone();
        excluderM22clone.version = d_renamed;
        return excluderM22clone;
    }

    public com.google.gson.internal.Excluder withModifiers(int... iArr) {
        com.google.gson.internal.Excluder excluderM22clone = m22clone();
        excluderM22clone.modifiers = 0;
        for (int i_renamed : iArr) {
            excluderM22clone.modifiers = i_renamed | excluderM22clone.modifiers;
        }
        return excluderM22clone;
    }

    public com.google.gson.internal.Excluder disableInnerClassSerialization() {
        com.google.gson.internal.Excluder excluderM22clone = m22clone();
        excluderM22clone.serializeInnerClasses = false;
        return excluderM22clone;
    }

    public com.google.gson.internal.Excluder excludeFieldsWithoutExposeAnnotation() {
        com.google.gson.internal.Excluder excluderM22clone = m22clone();
        excluderM22clone.requireExpose = true;
        return excluderM22clone;
    }

    public com.google.gson.internal.Excluder withExclusionStrategy(com.google.gson.ExclusionStrategy exclusionStrategy, boolean z_renamed, boolean z2) {
        com.google.gson.internal.Excluder excluderM22clone = m22clone();
        if (z_renamed) {
            excluderM22clone.serializationStrategies = new java.util.ArrayList(this.serializationStrategies);
            excluderM22clone.serializationStrategies.add(exclusionStrategy);
        }
        if (z2) {
            excluderM22clone.deserializationStrategies = new java.util.ArrayList(this.deserializationStrategies);
            excluderM22clone.deserializationStrategies.add(exclusionStrategy);
        }
        return excluderM22clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(final com.google.gson.Gson gson, final com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
        final boolean zExcludeClass = excludeClass(rawType, true);
        final boolean zExcludeClass2 = excludeClass(rawType, false);
        if (zExcludeClass || zExcludeClass2) {
            return new com.google.gson.TypeAdapter<T_renamed>() { // from class: com.google.gson.internal.Excluder.1
                private com.google.gson.TypeAdapter<T_renamed> delegate;

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                    if (zExcludeClass2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read2(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
                    if (zExcludeClass) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t_renamed);
                    }
                }

                private com.google.gson.TypeAdapter<T_renamed> delegate() {
                    com.google.gson.TypeAdapter<T_renamed> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    com.google.gson.TypeAdapter<T_renamed> delegateAdapter = gson.getDelegateAdapter(com.google.gson.internal.Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z_renamed) {
        com.google.gson.annotations.Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((com.google.gson.annotations.Since) field.getAnnotation(com.google.gson.annotations.Since.class), (com.google.gson.annotations.Until) field.getAnnotation(com.google.gson.annotations.Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (com.google.gson.annotations.Expose) field.getAnnotation(com.google.gson.annotations.Expose.class)) == null || (!z_renamed ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        java.util.List<com.google.gson.ExclusionStrategy> list = z_renamed ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.FieldAttributes fieldAttributes = new com.google.gson.FieldAttributes(field);
        java.util.Iterator<com.google.gson.ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeClass(java.lang.Class<?> cls, boolean z_renamed) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((com.google.gson.annotations.Since) cls.getAnnotation(com.google.gson.annotations.Since.class), (com.google.gson.annotations.Until) cls.getAnnotation(com.google.gson.annotations.Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        java.util.Iterator<com.google.gson.ExclusionStrategy> it = (z_renamed ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(java.lang.Class<?> cls) {
        return !java.lang.Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(java.lang.Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(java.lang.Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(com.google.gson.annotations.Since since, com.google.gson.annotations.Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(com.google.gson.annotations.Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(com.google.gson.annotations.Until until) {
        return until == null || until.value() > this.version;
    }
}
