package com.squareup.wire;

/* loaded from: classes2.dex */
final class RuntimeMessageAdapter<M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> extends com.squareup.wire.ProtoAdapter<M_renamed> {
    private static final java.lang.String REDACTED = "██";
    private final java.lang.Class<B_renamed> builderType;
    private final java.util.Map<java.lang.Integer, com.squareup.wire.FieldBinding<M_renamed, B_renamed>> fieldBindings;
    private final java.lang.Class<M_renamed> messageType;

    static <M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> com.squareup.wire.RuntimeMessageAdapter<M_renamed, B_renamed> create(java.lang.Class<M_renamed> cls) {
        java.lang.Class builderType = getBuilderType(cls);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
            com.squareup.wire.WireField wireField = (com.squareup.wire.WireField) field.getAnnotation(com.squareup.wire.WireField.class);
            if (wireField != null) {
                linkedHashMap.put(java.lang.Integer.valueOf(wireField.tag()), new com.squareup.wire.FieldBinding(wireField, field, builderType));
            }
        }
        return new com.squareup.wire.RuntimeMessageAdapter<>(cls, builderType, java.util.Collections.unmodifiableMap(linkedHashMap));
    }

    RuntimeMessageAdapter(java.lang.Class<M_renamed> cls, java.lang.Class<B_renamed> cls2, java.util.Map<java.lang.Integer, com.squareup.wire.FieldBinding<M_renamed, B_renamed>> map) {
        super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, cls);
        this.messageType = cls;
        this.builderType = cls2;
        this.fieldBindings = map;
    }

    java.util.Map<java.lang.Integer, com.squareup.wire.FieldBinding<M_renamed, B_renamed>> fieldBindings() {
        return this.fieldBindings;
    }

    B_renamed newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    private static <M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> java.lang.Class<B_renamed> getBuilderType(java.lang.Class<M_renamed> cls) {
        try {
            return (java.lang.Class<B_renamed>) java.lang.Class.forName(cls.getName() + "$Builder");
        } catch (java.lang.ClassNotFoundException unused) {
            throw new java.lang.IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(M_renamed m_renamed) {
        int i_renamed = m_renamed.cachedSerializedSize;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iEncodedSizeWithTag = 0;
        for (com.squareup.wire.FieldBinding<M_renamed, B_renamed> fieldBinding : this.fieldBindings.values()) {
            java.lang.Object obj = fieldBinding.get(m_renamed);
            if (obj != null) {
                iEncodedSizeWithTag += fieldBinding.adapter().encodedSizeWithTag(fieldBinding.tag, obj);
            }
        }
        int size = iEncodedSizeWithTag + m_renamed.unknownFields().size();
        m_renamed.cachedSerializedSize = size;
        return size;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(com.squareup.wire.ProtoWriter protoWriter, M_renamed m_renamed) throws java.io.IOException {
        for (com.squareup.wire.FieldBinding<M_renamed, B_renamed> fieldBinding : this.fieldBindings.values()) {
            java.lang.Object obj = fieldBinding.get(m_renamed);
            if (obj != null) {
                fieldBinding.adapter().encodeWithTag(protoWriter, fieldBinding.tag, obj);
            }
        }
        protoWriter.writeBytes(m_renamed.unknownFields());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M_renamed redact(M_renamed m_renamed) {
        com.squareup.wire.Message.Builder<M_renamed, B_renamed> builderNewBuilder = m_renamed.newBuilder();
        for (com.squareup.wire.FieldBinding<M_renamed, B_renamed> fieldBinding : this.fieldBindings.values()) {
            if (fieldBinding.redacted && fieldBinding.label == com.squareup.wire.WireField.Label.REQUIRED) {
                throw new java.lang.UnsupportedOperationException(java.lang.String.format("Field '%s_renamed' in_renamed %s_renamed is_renamed required and cannot be_renamed redacted.", fieldBinding.name, this.javaType.getName()));
            }
            boolean zIsAssignableFrom = com.squareup.wire.Message.class.isAssignableFrom(fieldBinding.singleAdapter().javaType);
            if (fieldBinding.redacted || (zIsAssignableFrom && !fieldBinding.label.isRepeated())) {
                java.lang.Object fromBuilder = fieldBinding.getFromBuilder(builderNewBuilder);
                if (fromBuilder != null) {
                    fieldBinding.set(builderNewBuilder, fieldBinding.adapter().redact(fromBuilder));
                }
            } else if (zIsAssignableFrom && fieldBinding.label.isRepeated()) {
                com.squareup.wire.internal.Internal.redactElements((java.util.List) fieldBinding.getFromBuilder(builderNewBuilder), fieldBinding.singleAdapter());
            }
        }
        builderNewBuilder.clearUnknownFields();
        return (M_renamed) builderNewBuilder.build();
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.squareup.wire.RuntimeMessageAdapter) && ((com.squareup.wire.RuntimeMessageAdapter) obj).messageType == this.messageType;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public java.lang.String toString(M_renamed m_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.squareup.wire.FieldBinding<M_renamed, B_renamed> fieldBinding : this.fieldBindings.values()) {
            java.lang.Object obj = fieldBinding.get(m_renamed);
            if (obj != null) {
                sb.append(", ");
                sb.append(fieldBinding.name);
                sb.append('=');
                if (fieldBinding.redacted) {
                    obj = REDACTED;
                }
                sb.append(obj);
            }
        }
        sb.replace(0, 2, this.messageType.getSimpleName() + '{');
        sb.append('}');
        return sb.toString();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M_renamed decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
        com.squareup.wire.ProtoAdapter<?> protoAdapterSingleAdapter;
        com.squareup.wire.Message.Builder builderNewBuilder = newBuilder();
        long jBeginMessage = protoReader.beginMessage();
        while (true) {
            int iNextTag = protoReader.nextTag();
            if (iNextTag != -1) {
                com.squareup.wire.FieldBinding<M_renamed, B_renamed> fieldBinding = this.fieldBindings.get(java.lang.Integer.valueOf(iNextTag));
                if (fieldBinding != null) {
                    try {
                        if (fieldBinding.isMap()) {
                            protoAdapterSingleAdapter = fieldBinding.adapter();
                        } else {
                            protoAdapterSingleAdapter = fieldBinding.singleAdapter();
                        }
                        fieldBinding.value(builderNewBuilder, protoAdapterSingleAdapter.decode(protoReader));
                    } catch (com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException e_renamed) {
                        builderNewBuilder.addUnknownField(iNextTag, com.squareup.wire.FieldEncoding.VARINT, java.lang.Long.valueOf(e_renamed.value));
                    }
                } else {
                    com.squareup.wire.FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builderNewBuilder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            } else {
                protoReader.endMessage(jBeginMessage);
                return (M_renamed) builderNewBuilder.build();
            }
        }
    }
}
