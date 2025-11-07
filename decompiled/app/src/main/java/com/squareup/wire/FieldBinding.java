package com.squareup.wire;

/* loaded from: classes2.dex */
final class FieldBinding<M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> {
    private com.squareup.wire.ProtoAdapter<java.lang.Object> adapter;
    private final java.lang.String adapterString;
    private final java.lang.reflect.Field builderField;
    private final java.lang.reflect.Method builderMethod;
    private com.squareup.wire.ProtoAdapter<?> keyAdapter;
    private final java.lang.String keyAdapterString;
    public final com.squareup.wire.WireField.Label label;
    private final java.lang.reflect.Field messageField;
    public final java.lang.String name;
    public final boolean redacted;
    private com.squareup.wire.ProtoAdapter<?> singleAdapter;
    public final int tag;

    private static java.lang.reflect.Field getBuilderField(java.lang.Class<?> cls, java.lang.String str) {
        try {
            return cls.getField(str);
        } catch (java.lang.NoSuchFieldException unused) {
            throw new java.lang.AssertionError("No builder field " + cls.getName() + "." + str);
        }
    }

    private static java.lang.reflect.Method getBuilderMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (java.lang.NoSuchMethodException unused) {
            throw new java.lang.AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + ")");
        }
    }

    FieldBinding(com.squareup.wire.WireField wireField, java.lang.reflect.Field field, java.lang.Class<B_renamed> cls) {
        this.label = wireField.label();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.messageField = field;
        this.builderField = getBuilderField(cls, this.name);
        this.builderMethod = getBuilderMethod(cls, this.name, field.getType());
    }

    boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    com.squareup.wire.ProtoAdapter<?> singleAdapter() {
        com.squareup.wire.ProtoAdapter<?> protoAdapter = this.singleAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        com.squareup.wire.ProtoAdapter<?> protoAdapter2 = com.squareup.wire.ProtoAdapter.get(this.adapterString);
        this.singleAdapter = protoAdapter2;
        return protoAdapter2;
    }

    com.squareup.wire.ProtoAdapter<?> keyAdapter() {
        com.squareup.wire.ProtoAdapter<?> protoAdapter = this.keyAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        com.squareup.wire.ProtoAdapter<?> protoAdapter2 = com.squareup.wire.ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = protoAdapter2;
        return protoAdapter2;
    }

    com.squareup.wire.ProtoAdapter<java.lang.Object> adapter() {
        com.squareup.wire.ProtoAdapter<java.lang.Object> protoAdapter = this.adapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        if (isMap()) {
            com.squareup.wire.ProtoAdapter<java.lang.Object> protoAdapterNewMapAdapter = com.squareup.wire.ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
            this.adapter = protoAdapterNewMapAdapter;
            return protoAdapterNewMapAdapter;
        }
        com.squareup.wire.ProtoAdapter<?> protoAdapterWithLabel = singleAdapter().withLabel(this.label);
        this.adapter = protoAdapterWithLabel;
        return protoAdapterWithLabel;
    }

    void value(B_renamed b2, java.lang.Object obj) {
        if (this.label.isRepeated()) {
            ((java.util.List) getFromBuilder(b2)).add(obj);
        } else if (!this.keyAdapterString.isEmpty()) {
            ((java.util.Map) getFromBuilder(b2)).putAll((java.util.Map) obj);
        } else {
            set(b2, obj);
        }
    }

    void set(B_renamed b2, java.lang.Object obj) {
        try {
            if (this.label.isOneOf()) {
                this.builderMethod.invoke(b2, obj);
            } else {
                this.builderField.set(b2, obj);
            }
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    java.lang.Object get(M_renamed m_renamed) {
        try {
            return this.messageField.get(m_renamed);
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    java.lang.Object getFromBuilder(B_renamed b2) {
        try {
            return this.builderField.get(b2);
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }
}
