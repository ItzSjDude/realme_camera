package com.google.protobuf;

/* loaded from: classes.dex */
final class MessageSchema<T_renamed> implements com.google.protobuf.Schema<T_renamed> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final com.google.protobuf.MessageLite defaultInstance;
    private final com.google.protobuf.ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final com.google.protobuf.ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final com.google.protobuf.MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final com.google.protobuf.NewInstanceSchema newInstanceSchema;
    private final java.lang.Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final sun.misc.Unsafe UNSAFE = com.google.protobuf.UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int i_renamed) {
        return (i_renamed & 536870912) != 0;
    }

    private static boolean isRequired(int i_renamed) {
        return (i_renamed & 268435456) != 0;
    }

    private static long offset(int i_renamed) {
        return i_renamed & OFFSET_MASK;
    }

    private static int type(int i_renamed) {
        return (i_renamed & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, java.lang.Object[] objArr, int i_renamed, int i2, com.google.protobuf.MessageLite messageLite, boolean z_renamed, boolean z2, int[] iArr2, int i3, int i4, com.google.protobuf.NewInstanceSchema newInstanceSchema, com.google.protobuf.ListFieldSchema listFieldSchema, com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i_renamed;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof com.google.protobuf.GeneratedMessageLite;
        this.proto3 = z_renamed;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T_renamed> com.google.protobuf.MessageSchema<T_renamed> newSchema(java.lang.Class<T_renamed> cls, com.google.protobuf.MessageInfo messageInfo, com.google.protobuf.NewInstanceSchema newInstanceSchema, com.google.protobuf.ListFieldSchema listFieldSchema, com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof com.google.protobuf.RawMessageInfo) {
            return newSchemaForRawMessageInfo((com.google.protobuf.RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((com.google.protobuf.StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T_renamed> com.google.protobuf.MessageSchema<T_renamed> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo rawMessageInfo, com.google.protobuf.NewInstanceSchema newInstanceSchema, com.google.protobuf.ListFieldSchema listFieldSchema, com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MapFieldSchema mapFieldSchema) {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iCharAt;
        int i8;
        int iCharAt2;
        int iCharAt3;
        int i9;
        int i10;
        char c2;
        int[] iArr;
        char c3;
        int i11;
        char cCharAt;
        int i12;
        char cCharAt2;
        int i13;
        char cCharAt3;
        char cCharAt4;
        char cCharAt5;
        char cCharAt6;
        char cCharAt7;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        char c4;
        int iObjectFieldOffset;
        java.lang.String str;
        int i17;
        java.lang.Class<?> cls;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i20;
        int i21;
        java.lang.reflect.Field fieldReflectField2;
        java.lang.reflect.Field fieldReflectField3;
        int i22;
        char cCharAt10;
        int i23;
        char cCharAt11;
        int i24;
        char cCharAt12;
        char cCharAt13;
        char cCharAt14;
        boolean z_renamed = rawMessageInfo.getSyntax() == com.google.protobuf.ProtoSyntax.PROTO3;
        java.lang.String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int iCharAt4 = stringInfo.charAt(0);
        char c5 = 55296;
        if (iCharAt4 >= 55296) {
            int i25 = iCharAt4 & 8191;
            int i26 = 1;
            int i27 = 13;
            while (true) {
                i_renamed = i26 + 1;
                cCharAt14 = stringInfo.charAt(i26);
                if (cCharAt14 < 55296) {
                    break;
                }
                i25 |= (cCharAt14 & 8191) << i27;
                i27 += 13;
                i26 = i_renamed;
            }
            iCharAt4 = (cCharAt14 << i27) | i25;
        } else {
            i_renamed = 1;
        }
        int i28 = i_renamed + 1;
        int iCharAt5 = stringInfo.charAt(i_renamed);
        if (iCharAt5 >= 55296) {
            int i29 = iCharAt5 & 8191;
            int i30 = 13;
            while (true) {
                i2 = i28 + 1;
                cCharAt13 = stringInfo.charAt(i28);
                if (cCharAt13 < 55296) {
                    break;
                }
                i29 |= (cCharAt13 & 8191) << i30;
                i30 += 13;
                i28 = i2;
            }
            iCharAt5 = i29 | (cCharAt13 << i30);
        } else {
            i2 = i28;
        }
        if (iCharAt5 == 0) {
            c3 = 0;
            i9 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i10 = 0;
            iArr = EMPTY_INT_ARRAY;
            c2 = 0;
        } else {
            int i31 = i2 + 1;
            char cCharAt15 = stringInfo.charAt(i2);
            if (cCharAt15 >= 55296) {
                int i32 = cCharAt15 & 8191;
                int i33 = 13;
                while (true) {
                    i3 = i31 + 1;
                    cCharAt8 = stringInfo.charAt(i31);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i32 |= (cCharAt8 & 8191) << i33;
                    i33 += 13;
                    i31 = i3;
                }
                i4 = (cCharAt8 << i33) | i32;
            } else {
                i3 = i31;
                i4 = cCharAt15;
            }
            int i34 = i3 + 1;
            int iCharAt6 = stringInfo.charAt(i3);
            if (iCharAt6 >= 55296) {
                int i35 = iCharAt6 & 8191;
                int i36 = 13;
                while (true) {
                    i5 = i34 + 1;
                    cCharAt7 = stringInfo.charAt(i34);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt7 & 8191) << i36;
                    i36 += 13;
                    i34 = i5;
                }
                iCharAt6 = i35 | (cCharAt7 << i36);
            } else {
                i5 = i34;
            }
            int i37 = i5 + 1;
            char cCharAt16 = stringInfo.charAt(i5);
            if (cCharAt16 >= 55296) {
                int i38 = cCharAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i6 = i37 + 1;
                    cCharAt6 = stringInfo.charAt(i37);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt6 & 8191) << i39;
                    i39 += 13;
                    i37 = i6;
                }
                cCharAt16 = ((cCharAt6 << i39) | i38) == true ? 1 : 0;
            } else {
                i6 = i37;
            }
            int i40 = i6 + 1;
            char cCharAt17 = stringInfo.charAt(i6);
            if (cCharAt17 >= 55296) {
                int i41 = cCharAt17 & 8191;
                int i42 = 13;
                while (true) {
                    i7 = i40 + 1;
                    cCharAt5 = stringInfo.charAt(i40);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt5 & 8191) << i42;
                    i42 += 13;
                    i40 = i7;
                }
                cCharAt17 = ((cCharAt5 << i42) | i41) == true ? 1 : 0;
            } else {
                i7 = i40;
            }
            int i43 = i7 + 1;
            iCharAt = stringInfo.charAt(i7);
            if (iCharAt >= 55296) {
                int i44 = iCharAt & 8191;
                int i45 = 13;
                while (true) {
                    i8 = i43 + 1;
                    cCharAt4 = stringInfo.charAt(i43);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt4 & 8191) << i45;
                    i45 += 13;
                    i43 = i8;
                }
                iCharAt = (cCharAt4 << i45) | i44;
            } else {
                i8 = i43;
            }
            int i46 = i8 + 1;
            iCharAt2 = stringInfo.charAt(i8);
            if (iCharAt2 >= 55296) {
                int i47 = iCharAt2 & 8191;
                int i48 = 13;
                while (true) {
                    i13 = i46 + 1;
                    cCharAt3 = stringInfo.charAt(i46);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt3 & 8191) << i48;
                    i48 += 13;
                    i46 = i13;
                }
                iCharAt2 = (cCharAt3 << i48) | i47;
                i46 = i13;
            }
            int i49 = i46 + 1;
            int iCharAt7 = stringInfo.charAt(i46);
            if (iCharAt7 >= 55296) {
                int i50 = iCharAt7 & 8191;
                int i51 = 13;
                while (true) {
                    i12 = i49 + 1;
                    cCharAt2 = stringInfo.charAt(i49);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt2 & 8191) << i51;
                    i51 += 13;
                    i49 = i12;
                }
                iCharAt7 = i50 | (cCharAt2 << i51);
                i49 = i12;
            }
            int i52 = i49 + 1;
            iCharAt3 = stringInfo.charAt(i49);
            if (iCharAt3 >= 55296) {
                int i53 = 13;
                int i54 = iCharAt3 & 8191;
                int i55 = i52;
                while (true) {
                    i11 = i55 + 1;
                    cCharAt = stringInfo.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i53;
                    i53 += 13;
                    i55 = i11;
                }
                iCharAt3 = i54 | (cCharAt << i53);
                i52 = i11;
            }
            i9 = (i4 * 2) + iCharAt6;
            int i56 = i52;
            i10 = i4;
            c2 = cCharAt16;
            i2 = i56;
            char c6 = cCharAt17;
            iArr = new int[iCharAt3 + iCharAt2 + iCharAt7];
            c3 = c6;
        }
        sun.misc.Unsafe unsafe = UNSAFE;
        java.lang.Object[] objects = rawMessageInfo.getObjects();
        java.lang.Class<?> cls2 = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt * 3];
        java.lang.Object[] objArr = new java.lang.Object[iCharAt * 2];
        int i57 = iCharAt2 + iCharAt3;
        int i58 = i57;
        int i59 = iCharAt3;
        int i60 = 0;
        int i61 = 0;
        while (i2 < length) {
            int i62 = i2 + 1;
            int iCharAt8 = stringInfo.charAt(i2);
            if (iCharAt8 >= c5) {
                int i63 = 13;
                int i64 = iCharAt8 & 8191;
                int i65 = i62;
                while (true) {
                    i24 = i65 + 1;
                    cCharAt12 = stringInfo.charAt(i65);
                    if (cCharAt12 < c5) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i63;
                    i63 += 13;
                    i65 = i24;
                }
                iCharAt8 = i64 | (cCharAt12 << i63);
                i14 = i24;
            } else {
                i14 = i62;
            }
            int i66 = i14 + 1;
            int iCharAt9 = stringInfo.charAt(i14);
            int i67 = length;
            char c7 = 55296;
            if (iCharAt9 >= 55296) {
                int i68 = 13;
                int i69 = iCharAt9 & 8191;
                int i70 = i66;
                while (true) {
                    i23 = i70 + 1;
                    cCharAt11 = stringInfo.charAt(i70);
                    if (cCharAt11 < c7) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i68;
                    i68 += 13;
                    i70 = i23;
                    c7 = 55296;
                }
                iCharAt9 = i69 | (cCharAt11 << i68);
                i15 = i23;
            } else {
                i15 = i66;
            }
            int i71 = i57;
            int i72 = iCharAt9 & 255;
            int i73 = iCharAt3;
            if ((iCharAt9 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            boolean z2 = z_renamed;
            if (i72 >= 51) {
                int i74 = i15 + 1;
                int iCharAt10 = stringInfo.charAt(i15);
                char c8 = 55296;
                if (iCharAt10 >= 55296) {
                    int i75 = iCharAt10 & 8191;
                    int i76 = 13;
                    while (true) {
                        i22 = i74 + 1;
                        cCharAt10 = stringInfo.charAt(i74);
                        if (cCharAt10 < c8) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i74 = i22;
                        c8 = 55296;
                    }
                    iCharAt10 = i75 | (cCharAt10 << i76);
                    i74 = i22;
                }
                int i77 = i72 - 51;
                int i78 = i74;
                if (i77 == 9 || i77 == 17) {
                    i21 = i9 + 1;
                    objArr[((i61 / 3) * 2) + 1] = objects[i9];
                } else if (i77 == 12 && (iCharAt4 & 1) == 1) {
                    i21 = i9 + 1;
                    objArr[((i61 / 3) * 2) + 1] = objects[i9];
                } else {
                    i21 = i9;
                }
                int i79 = iCharAt10 * 2;
                java.lang.Object obj = objects[i79];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls2, (java.lang.String) obj);
                    objects[i79] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i80 = i79 + 1;
                java.lang.Object obj2 = objects[i80];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls2, (java.lang.String) obj2);
                    objects[i80] = fieldReflectField3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                str = stringInfo;
                i17 = iCharAt4;
                i16 = i21;
                iObjectFieldOffset = iObjectFieldOffset3;
                i18 = i78;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                c4 = c3;
                i19 = 0;
                cls = cls2;
            } else {
                i16 = i9 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls2, (java.lang.String) objects[i9]);
                if (i72 == 9 || i72 == 17) {
                    c4 = c3;
                    objArr[((i61 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i72 == 27 || i72 == 49) {
                        c4 = c3;
                        i20 = i16 + 1;
                        objArr[((i61 / 3) * 2) + 1] = objects[i16];
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        c4 = c3;
                        if ((iCharAt4 & 1) == 1) {
                            i20 = i16 + 1;
                            objArr[((i61 / 3) * 2) + 1] = objects[i16];
                        }
                    } else if (i72 == 50) {
                        int i81 = i59 + 1;
                        iArr[i59] = i61;
                        int i82 = (i61 / 3) * 2;
                        int i83 = i16 + 1;
                        objArr[i82] = objects[i16];
                        if ((iCharAt9 & 2048) != 0) {
                            i16 = i83 + 1;
                            objArr[i82 + 1] = objects[i83];
                            c4 = c3;
                            i59 = i81;
                        } else {
                            i59 = i81;
                            i16 = i83;
                            c4 = c3;
                        }
                    } else {
                        c4 = c3;
                    }
                    i16 = i20;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt4 & 1) != 1 || i72 > 17) {
                    str = stringInfo;
                    i17 = iCharAt4;
                    cls = cls2;
                    i18 = i15;
                    i19 = 0;
                    iObjectFieldOffset2 = 0;
                } else {
                    int i84 = i15 + 1;
                    int iCharAt11 = stringInfo.charAt(i15);
                    if (iCharAt11 >= 55296) {
                        int i85 = iCharAt11 & 8191;
                        int i86 = 13;
                        while (true) {
                            i18 = i84 + 1;
                            cCharAt9 = stringInfo.charAt(i84);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i85 |= (cCharAt9 & 8191) << i86;
                            i86 += 13;
                            i84 = i18;
                        }
                        iCharAt11 = i85 | (cCharAt9 << i86);
                    } else {
                        i18 = i84;
                    }
                    int i87 = (i10 * 2) + (iCharAt11 / 32);
                    java.lang.Object obj3 = objects[i87];
                    str = stringInfo;
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls2, (java.lang.String) obj3);
                        objects[i87] = fieldReflectField;
                    }
                    i17 = iCharAt4;
                    cls = cls2;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i19 = iCharAt11 % 32;
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i58] = iObjectFieldOffset;
                    i58++;
                }
            }
            int i88 = i61 + 1;
            iArr2[i61] = iCharAt8;
            int i89 = i88 + 1;
            iArr2[i88] = ((iCharAt9 & 256) != 0 ? 268435456 : 0) | ((iCharAt9 & 512) != 0 ? 536870912 : 0) | (i72 << 20) | iObjectFieldOffset;
            i61 = i89 + 1;
            iArr2[i89] = (i19 << 20) | iObjectFieldOffset2;
            iCharAt4 = i17;
            cls2 = cls;
            i9 = i16;
            i57 = i71;
            length = i67;
            iCharAt3 = i73;
            c3 = c4;
            i2 = i18;
            z_renamed = z2;
            stringInfo = str;
            c5 = 55296;
        }
        return new com.google.protobuf.MessageSchema<>(iArr2, objArr, c2, c3, rawMessageInfo.getDefaultInstance(), z_renamed, false, iArr, iCharAt3, i57, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(java.lang.Class<?> cls, java.lang.String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (java.lang.NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new java.lang.RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + java.util.Arrays.toString(declaredFields));
        }
    }

    static <T_renamed> com.google.protobuf.MessageSchema<T_renamed> newSchemaForMessageInfo(com.google.protobuf.StructuralMessageInfo structuralMessageInfo, com.google.protobuf.NewInstanceSchema newInstanceSchema, com.google.protobuf.ListFieldSchema listFieldSchema, com.google.protobuf.UnknownFieldSchema<?, ?> unknownFieldSchema, com.google.protobuf.ExtensionSchema<?> extensionSchema, com.google.protobuf.MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i_renamed;
        boolean z_renamed = structuralMessageInfo.getSyntax() == com.google.protobuf.ProtoSyntax.PROTO3;
        com.google.protobuf.FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        java.lang.Object[] objArr = new java.lang.Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (com.google.protobuf.FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == com.google.protobuf.FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().id_renamed() >= 18 && fieldInfo.getType().id_renamed() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            com.google.protobuf.FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, z_renamed, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == com.google.protobuf.FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else {
                if (fieldInfo2.getType().id_renamed() >= 18 && fieldInfo2.getType().id_renamed() <= 49) {
                    i_renamed = i5;
                    iArr3[i8] = (int) com.google.protobuf.UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i8++;
                }
                i4++;
                i5 = i_renamed + 3;
            }
            i_renamed = i5;
            i4++;
            i5 = i_renamed + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        java.lang.System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        java.lang.System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        java.lang.System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new com.google.protobuf.MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z_renamed, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r7, int[] r8, int r9, boolean r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r7.getOneof()
            r1 = 0
            if (r0 == 0) goto L27
            com.google.protobuf.FieldType r10 = r7.getType()
            int r10 = r10.id_renamed()
            int r10 = r10 + 51
            java.lang.reflect.Field r2 = r0.getValueField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r3 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r3
            r3 = r10
            r10 = r0
        L25:
            r0 = r1
            goto L6b
        L27:
            com.google.protobuf.FieldType r0 = r7.getType()
            java.lang.reflect.Field r2 = r7.getField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            int r3 = r0.id_renamed()
            if (r10 != 0) goto L58
            boolean r10 = r0.isList()
            if (r10 != 0) goto L58
            boolean r10 = r0.isMap()
            if (r10 != 0) goto L58
            java.lang.reflect.Field r10 = r7.getPresenceField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r10)
            int r10 = (int) r4
            int r0 = r7.getPresenceMask()
            int r0 = java.lang.Integer.numberOfTrailingZeros(r0)
            goto L6b
        L58:
            java.lang.reflect.Field r10 = r7.getCachedSizeField()
            if (r10 != 0) goto L61
            r10 = r1
            r0 = r10
            goto L6b
        L61:
            java.lang.reflect.Field r10 = r7.getCachedSizeField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r10)
            int r10 = (int) r4
            goto L25
        L6b:
            int r4 = r7.getFieldNumber()
            r8[r9] = r4
            int r4 = r9 + 1
            boolean r5 = r7.isEnforceUtf8()
            if (r5 == 0) goto L7c
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7d
        L7c:
            r5 = r1
        L7d:
            boolean r6 = r7.isRequired()
            if (r6 == 0) goto L85
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L85:
            r1 = r1 | r5
            int r3 = r3 << 20
            r1 = r1 | r3
            r1 = r1 | r2
            r8[r4] = r1
            int r1 = r9 + 2
            int r0 = r0 << 20
            r10 = r10 | r0
            r8[r1] = r10
            java.lang.Class r8 = r7.getMessageFieldClass()
            java.lang.Object r10 = r7.getMapDefaultEntry()
            if (r10 == 0) goto Lbd
            int r9 = r9 / 3
            int r9 = r9 * 2
            java.lang.Object r10 = r7.getMapDefaultEntry()
            r11[r9] = r10
            if (r8 == 0) goto Lae
            int r9 = r9 + 1
            r11[r9] = r8
            goto Lda
        Lae:
            com.google.protobuf.Internal$EnumVerifier r8 = r7.getEnumVerifier()
            if (r8 == 0) goto Lda
            int r9 = r9 + 1
            com.google.protobuf.Internal$EnumVerifier r7 = r7.getEnumVerifier()
            r11[r9] = r7
            goto Lda
        Lbd:
            if (r8 == 0) goto Lc8
            int r9 = r9 / 3
            int r9 = r9 * 2
            int r9 = r9 + 1
            r11[r9] = r8
            goto Lda
        Lc8:
            com.google.protobuf.Internal$EnumVerifier r8 = r7.getEnumVerifier()
            if (r8 == 0) goto Lda
            int r9 = r9 / 3
            int r9 = r9 * 2
            int r9 = r9 + 1
            com.google.protobuf.Internal$EnumVerifier r7 = r7.getEnumVerifier()
            r11[r9] = r7
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    @Override // com.google.protobuf.Schema
    public T_renamed newInstance() {
        return (T_renamed) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T_renamed t_renamed, T_renamed t2) {
        int length = this.buffer.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed += 3) {
            if (!equals(t_renamed, t2, i_renamed)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t_renamed).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t_renamed).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i_renamed);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && java.lang.Double.doubleToLongBits(com.google.protobuf.UnsafeUtil.getDouble(t_renamed, jOffset)) == java.lang.Double.doubleToLongBits(com.google.protobuf.UnsafeUtil.getDouble(t2, jOffset))) {
                    break;
                }
                break;
            case 1:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && java.lang.Float.floatToIntBits(com.google.protobuf.UnsafeUtil.getFloat(t_renamed, jOffset)) == java.lang.Float.floatToIntBits(com.google.protobuf.UnsafeUtil.getFloat(t2, jOffset))) {
                    break;
                }
                break;
            case 2:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 3:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 4:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 5:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 6:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 7:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getBoolean(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getBoolean(t2, jOffset)) {
                    break;
                }
                break;
            case 8:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.SchemaUtil.safeEquals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), com.google.protobuf.UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 9:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.SchemaUtil.safeEquals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), com.google.protobuf.UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 10:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.SchemaUtil.safeEquals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), com.google.protobuf.UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 11:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 12:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 13:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 14:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 15:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 16:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) == com.google.protobuf.UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 17:
                if (arePresentForEquals(t_renamed, t2, i_renamed) && com.google.protobuf.SchemaUtil.safeEquals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), com.google.protobuf.UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (isOneofCaseEqual(t_renamed, t2, i_renamed) && com.google.protobuf.SchemaUtil.safeEquals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), com.google.protobuf.UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T_renamed t_renamed) {
        int i_renamed;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(java.lang.Double.doubleToLongBits(com.google.protobuf.UnsafeUtil.getDouble(t_renamed, jOffset)));
                    i2 = i_renamed + iHashLong;
                    break;
                case 1:
                    i_renamed = i2 * 53;
                    iHashLong = java.lang.Float.floatToIntBits(com.google.protobuf.UnsafeUtil.getFloat(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 2:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 3:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 4:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 5:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 6:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 7:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashBoolean(com.google.protobuf.UnsafeUtil.getBoolean(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 8:
                    i_renamed = i2 * 53;
                    iHashLong = ((java.lang.String) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset)).hashCode();
                    i2 = i_renamed + iHashLong;
                    break;
                case 9:
                    java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                    i2 = i_renamed + iHashLong;
                    break;
                case 11:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 12:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 13:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 14:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 15:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset);
                    i2 = i_renamed + iHashLong;
                    break;
                case 16:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.Internal.hashLong(com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                    i2 = i_renamed + iHashLong;
                    break;
                case 17:
                    java.lang.Object object2 = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                    i2 = i_renamed + iHashLong;
                    break;
                case 50:
                    i_renamed = i2 * 53;
                    iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                    i2 = i_renamed + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(java.lang.Double.doubleToLongBits(oneofDoubleAt(t_renamed, jOffset)));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = java.lang.Float.floatToIntBits(oneofFloatAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(oneofLongAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(oneofLongAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(oneofLongAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashBoolean(oneofBooleanAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = ((java.lang.String) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset)).hashCode();
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(oneofLongAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = oneofIntAt(t_renamed, jOffset);
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.Internal.hashLong(oneofLongAt(t_renamed, jOffset));
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t_renamed, iNumberAt, i3)) {
                        i_renamed = i2 * 53;
                        iHashLong = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset).hashCode();
                        i2 = i_renamed + iHashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t_renamed).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t_renamed).hashCode() : iHashCode2;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T_renamed t_renamed, T_renamed t2) {
        if (t2 == null) {
            throw new java.lang.NullPointerException();
        }
        for (int i_renamed = 0; i_renamed < this.buffer.length; i_renamed += 3) {
            mergeSingleField(t_renamed, t2, i_renamed);
        }
        if (this.proto3) {
            return;
        }
        com.google.protobuf.SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t_renamed, t2);
        if (this.hasExtensions) {
            com.google.protobuf.SchemaUtil.mergeExtensions(this.extensionSchema, t_renamed, t2);
        }
    }

    private void mergeSingleField(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i_renamed);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i_renamed);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putDouble(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putFloat(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putLong(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putLong(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putLong(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putBoolean(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 9:
                mergeMessage(t_renamed, t2, i_renamed);
                break;
            case 10:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putLong(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putInt(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t2, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putLong(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t_renamed, i_renamed);
                    break;
                }
                break;
            case 17:
                mergeMessage(t_renamed, t2, i_renamed);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t_renamed, t2, jOffset);
                break;
            case 50:
                com.google.protobuf.SchemaUtil.mergeMap(this.mapFieldSchema, t_renamed, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t_renamed, iNumberAt, i_renamed);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t_renamed, t2, i_renamed);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i_renamed)) {
                    com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t_renamed, iNumberAt, i_renamed);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t_renamed, t2, i_renamed);
                break;
        }
    }

    private void mergeMessage(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        long jOffset = offset(typeAndOffsetAt(i_renamed));
        if (isFieldPresent(t2, i_renamed)) {
            java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
            java.lang.Object object2 = com.google.protobuf.UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.Internal.mergeMessage(object, object2));
                setFieldPresent(t_renamed, i_renamed);
            } else if (object2 != null) {
                com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, object2);
                setFieldPresent(t_renamed, i_renamed);
            }
        }
    }

    private void mergeOneofMessage(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i_renamed);
        int iNumberAt = numberAt(i_renamed);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, i_renamed)) {
            java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
            java.lang.Object object2 = com.google.protobuf.UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, com.google.protobuf.Internal.mergeMessage(object, object2));
                setOneofPresent(t_renamed, iNumberAt, i_renamed);
            } else if (object2 != null) {
                com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, object2);
                setOneofPresent(t_renamed, iNumberAt, i_renamed);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T_renamed t_renamed) {
        return this.proto3 ? getSerializedSizeProto3(t_renamed) : getSerializedSizeProto2(t_renamed);
    }

    private int getSerializedSizeProto2(T_renamed t_renamed) {
        int i_renamed;
        int i2;
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        sun.misc.Unsafe unsafe = UNSAFE;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        for (int i6 = 0; i6 < this.buffer.length; i6 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int iNumberAt = numberAt(i6);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i_renamed = this.buffer[i6 + 2];
                int i7 = OFFSET_MASK & i_renamed;
                int i8 = 1 << (i_renamed >>> 20);
                if (i7 != i5) {
                    i4 = unsafe.getInt(t_renamed, i7);
                    i5 = i7;
                }
                i2 = i8;
            } else if (!this.useCachedSizeField || iType < com.google.protobuf.FieldType.DOUBLE_LIST_PACKED.id_renamed() || iType > com.google.protobuf.FieldType.SINT64_LIST_PACKED.id_renamed()) {
                i_renamed = 0;
                i2 = 0;
            } else {
                i_renamed = this.buffer[i6 + 2] & OFFSET_MASK;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i4 & i2) != 0) {
                        java.lang.Object object = unsafe.getObject(t_renamed, jOffset);
                        if (object instanceof com.google.protobuf.ByteString) {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) object);
                        } else {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeStringSize(iNumberAt, (java.lang.String) object);
                        }
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) unsafe.getObject(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeGroupSize(iNumberAt, (com.google.protobuf.MessageLite) unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeInt64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeUInt64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeInt32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeBoolList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeStringList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset));
                    i3 += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessageList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeByteStringList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset));
                    i3 += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeUInt32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeEnumList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeSInt32List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeSInt64List(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 37:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 38:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeUInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 39:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 41:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 42:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeBoolListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 43:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeUInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 44:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeEnumListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 45:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 47:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeSInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeSInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i_renamed, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeGroupList(iNumberAt, (java.util.List) unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t_renamed, jOffset), getMapFieldDefaultEntry(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        java.lang.Object object2 = unsafe.getObject(t_renamed, jOffset);
                        if (object2 instanceof com.google.protobuf.ByteString) {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) object2);
                        } else {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeStringSize(iNumberAt, (java.lang.String) object2);
                        }
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) unsafe.getObject(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t_renamed, iNumberAt, i6)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeGroupSize(iNumberAt, (com.google.protobuf.MessageLite) unsafe.getObject(t_renamed, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int unknownFieldsSerializedSize = i3 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t_renamed);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t_renamed).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T_renamed t_renamed) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        sun.misc.Unsafe unsafe = UNSAFE;
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < com.google.protobuf.FieldType.DOUBLE_LIST_PACKED.id_renamed() || iType > com.google.protobuf.FieldType.SINT64_LIST_PACKED.id_renamed()) ? 0 : this.buffer[i2 + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt64Size(iNumberAt, com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt64Size(iNumberAt, com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt32Size(iNumberAt, com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t_renamed, i2)) {
                        java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
                        if (object instanceof com.google.protobuf.ByteString) {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) object);
                        } else {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeStringSize(iNumberAt, (java.lang.String) object);
                        }
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessage(iNumberAt, com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), getMessageFieldSchema(i2));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt32Size(iNumberAt, com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeEnumSize(iNumberAt, com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt32Size(iNumberAt, com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt64Size(iNumberAt, com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t_renamed, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeGroupSize(iNumberAt, (com.google.protobuf.MessageLite) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), getMessageFieldSchema(i2));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeStringList(iNumberAt, listAt(t_renamed, jOffset));
                    i_renamed += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t_renamed, jOffset), getMessageFieldSchema(i2));
                    i_renamed += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t_renamed, jOffset));
                    i_renamed += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t_renamed, jOffset), false);
                    i_renamed += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 37:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 38:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeUInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 39:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 41:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 42:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeBoolListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 43:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeUInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 44:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeEnumListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 45:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeFixed64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 47:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeSInt32ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = com.google.protobuf.SchemaUtil.computeSizeSInt64ListNoTag((java.util.List) unsafe.getObject(t_renamed, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t_renamed, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = com.google.protobuf.CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i_renamed += iComputeDoubleSize;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t_renamed, jOffset), getMessageFieldSchema(i2));
                    i_renamed += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), getMapFieldDefaultEntry(i2));
                    i_renamed += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        java.lang.Object object2 = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
                        if (object2 instanceof com.google.protobuf.ByteString) {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) object2);
                        } else {
                            iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeStringSize(iNumberAt, (java.lang.String) object2);
                        }
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.SchemaUtil.computeSizeMessage(iNumberAt, com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), getMessageFieldSchema(i2));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeBytesSize(iNumberAt, (com.google.protobuf.ByteString) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t_renamed, jOffset));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t_renamed, iNumberAt, i2)) {
                        iComputeDoubleSize = com.google.protobuf.CodedOutputStream.computeGroupSize(iNumberAt, (com.google.protobuf.MessageLite) com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset), getMessageFieldSchema(i2));
                        i_renamed += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i_renamed + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t_renamed);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, T_renamed t_renamed) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t_renamed));
    }

    private static java.util.List<?> listAt(java.lang.Object obj, long j_renamed) {
        return (java.util.List) com.google.protobuf.UnsafeUtil.getObject(obj, j_renamed);
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t_renamed, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t_renamed, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t_renamed, writer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T_renamed r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T_renamed r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T_renamed r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K_renamed, V_renamed> void writeMapHelper(com.google.protobuf.Writer writer, int i_renamed, java.lang.Object obj, int i2) throws java.io.IOException {
        if (obj != null) {
            writer.writeMap(i_renamed, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema, T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t_renamed), writer);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T_renamed t_renamed, com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t_renamed, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:32:0x0076, code lost:
    
        r0 = r16.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:34:0x007a, code lost:
    
        if (r0 >= r16.repeatedFieldOffsetStart) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:35:0x007c, code lost:
    
        r13 = filterMapUnknownEnumValues(r19, r16.intArray[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:361:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:36:0x0087, code lost:
    
        if (r13 == null) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:37:0x0089, code lost:
    
        r17.setBuilderToMessage(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:38:0x008c, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.protobuf.ExtensionSchema<ET> r18, T_renamed r19, com.google.protobuf.Reader r20, com.google.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    static com.google.protobuf.UnknownFieldSetLite getMutableUnknownFields(java.lang.Object obj) {
        com.google.protobuf.GeneratedMessageLite generatedMessageLite = (com.google.protobuf.GeneratedMessageLite) obj;
        com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        com.google.protobuf.UnknownFieldSetLite unknownFieldSetLiteNewInstance = com.google.protobuf.UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[com.google.protobuf.WireFormat.FieldType.values().length];

        static {
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[com.google.protobuf.WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i_renamed, int i2, com.google.protobuf.WireFormat.FieldType fieldType, java.lang.Class<?> cls, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        switch (com.google.protobuf.MessageSchema.SceneLoader_2.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                registers.object1 = java.lang.Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return com.google.protobuf.ArrayDecoders.decodeBytes(bArr, i_renamed, registers);
            case 3:
                registers.object1 = java.lang.Double.valueOf(com.google.protobuf.ArrayDecoders.decodeDouble(bArr, i_renamed));
                return i_renamed + 8;
            case 4:
            case 5:
                registers.object1 = java.lang.Integer.valueOf(com.google.protobuf.ArrayDecoders.decodeFixed32(bArr, i_renamed));
                return i_renamed + 4;
            case 6:
            case 7:
                registers.object1 = java.lang.Long.valueOf(com.google.protobuf.ArrayDecoders.decodeFixed64(bArr, i_renamed));
                return i_renamed + 8;
            case 8:
                registers.object1 = java.lang.Float.valueOf(com.google.protobuf.ArrayDecoders.decodeFloat(bArr, i_renamed));
                return i_renamed + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                registers.object1 = java.lang.Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                registers.object1 = java.lang.Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return com.google.protobuf.ArrayDecoders.decodeMessageField(com.google.protobuf.Protobuf.getInstance().schemaFor((java.lang.Class) cls), bArr, i_renamed, i2, registers);
            case 15:
                int iDecodeVarint322 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                registers.object1 = java.lang.Integer.valueOf(com.google.protobuf.CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                registers.object1 = java.lang.Long.valueOf(com.google.protobuf.CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return com.google.protobuf.ArrayDecoders.decodeStringRequireUtf8(bArr, i_renamed, registers);
            default:
                throw new java.lang.RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K_renamed, V_renamed>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K_renamed, V_renamed> int decodeMapEntry(byte[] bArr, int i_renamed, int i2, com.google.protobuf.MapEntryLite.Metadata<K_renamed, V_renamed> metadata, java.util.Map<K_renamed, V_renamed> map, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        int iDecodeVarint32;
        int iDecodeVarint322 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint322) {
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint322 + i3;
        java.lang.Object obj = metadata.defaultKey;
        java.lang.Object obj2 = metadata.defaultValue;
        while (iDecodeVarint322 < i4) {
            int i5 = iDecodeVarint322 + 1;
            byte b2 = bArr[iDecodeVarint322];
            if (b2 < 0) {
                iDecodeVarint32 = com.google.protobuf.ArrayDecoders.decodeVarint32(b2, bArr, i5, registers);
                b2 = registers.int1;
            } else {
                iDecodeVarint32 = i5;
            }
            int i6 = b2 >>> 3;
            int i7 = b2 & 7;
            if (i6 == 1) {
                if (i7 == metadata.keyType.getWireType()) {
                    iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint322 = com.google.protobuf.ArrayDecoders.skipField(b2, bArr, iDecodeVarint32, i2, registers);
                }
            } else if (i6 == 2 && i7 == metadata.valueType.getWireType()) {
                iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint322 = com.google.protobuf.ArrayDecoders.skipField(b2, bArr, iDecodeVarint32, i2, registers);
            }
        }
        if (iDecodeVarint322 != i4) {
            throw com.google.protobuf.InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, long j_renamed, int i7, long j2, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        int iDecodeVarint32List;
        com.google.protobuf.Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (com.google.protobuf.Internal.ProtobufList) UNSAFE.getObject(t_renamed, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UNSAFE.putObject(t_renamed, j2, protobufListMutableCopyWithCapacity2);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedDoubleList(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return com.google.protobuf.ArrayDecoders.decodeDoubleList(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedFloatList(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return com.google.protobuf.ArrayDecoders.decodeFloatList(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedVarint64List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return com.google.protobuf.ArrayDecoders.decodeVarint64List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedVarint32List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return com.google.protobuf.ArrayDecoders.decodeVarint32List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedFixed64List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return com.google.protobuf.ArrayDecoders.decodeFixed64List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedFixed32List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return com.google.protobuf.ArrayDecoders.decodeFixed32List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedBoolList(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return com.google.protobuf.ArrayDecoders.decodeBoolList(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j_renamed & 536870912) == 0) {
                        return com.google.protobuf.ArrayDecoders.decodeStringList(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                    }
                    return com.google.protobuf.ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodeBytesList(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iDecodeVarint32List = com.google.protobuf.ArrayDecoders.decodePackedVarint32List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                } else if (i5 == 0) {
                    iDecodeVarint32List = com.google.protobuf.ArrayDecoders.decodeVarint32List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                com.google.protobuf.GeneratedMessageLite generatedMessageLite = (com.google.protobuf.GeneratedMessageLite) t_renamed;
                com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite2 = (com.google.protobuf.UnknownFieldSetLite) com.google.protobuf.SchemaUtil.filterUnknownEnumList(i4, (java.util.List<java.lang.Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i6), unknownFieldSetLite, (com.google.protobuf.UnknownFieldSchema<UT, com.google.protobuf.UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedSInt32List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return com.google.protobuf.ArrayDecoders.decodeSInt32List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return com.google.protobuf.ArrayDecoders.decodePackedSInt64List(bArr, i_renamed, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return com.google.protobuf.ArrayDecoders.decodeSInt64List(i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return com.google.protobuf.ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i_renamed, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
        }
        return i_renamed;
    }

    private <K_renamed, V_renamed> int parseMapField(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2, int i3, long j_renamed, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        java.lang.Object objNewMapField;
        sun.misc.Unsafe unsafe = UNSAFE;
        java.lang.Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        java.lang.Object object = unsafe.getObject(t_renamed, j_renamed);
        if (this.mapFieldSchema.isImmutable(object)) {
            objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t_renamed, j_renamed, objNewMapField);
        } else {
            objNewMapField = object;
        }
        return decodeMapEntry(bArr, i_renamed, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(objNewMapField), registers);
    }

    private int parseOneofField(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, long j_renamed, int i8, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        sun.misc.Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & OFFSET_MASK;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Double.valueOf(com.google.protobuf.ArrayDecoders.decodeDouble(bArr, i_renamed)));
                    int i9 = i_renamed + 8;
                    unsafe.putInt(t_renamed, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Float.valueOf(com.google.protobuf.ArrayDecoders.decodeFloat(bArr, i_renamed)));
                    int i10 = i_renamed + 4;
                    unsafe.putInt(t_renamed, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int iDecodeVarint64 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Long.valueOf(registers.long1));
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iDecodeVarint32 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Integer.valueOf(registers.int1));
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Long.valueOf(com.google.protobuf.ArrayDecoders.decodeFixed64(bArr, i_renamed)));
                    int i11 = i_renamed + 8;
                    unsafe.putInt(t_renamed, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Integer.valueOf(com.google.protobuf.ArrayDecoders.decodeFixed32(bArr, i_renamed)));
                    int i12 = i_renamed + 4;
                    unsafe.putInt(t_renamed, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iDecodeVarint642 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint642;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iDecodeVarint322 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                    int i13 = registers.int1;
                    if (i13 == 0) {
                        unsafe.putObject(t_renamed, j_renamed, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !com.google.protobuf.Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i13)) {
                            throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(t_renamed, j_renamed, new java.lang.String(bArr, iDecodeVarint322, i13, com.google.protobuf.Internal.UTF_8));
                        iDecodeVarint322 += i13;
                    }
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint322;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int iDecodeMessageField = com.google.protobuf.ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i_renamed, i2, registers);
                    java.lang.Object object = unsafe.getInt(t_renamed, j2) == i4 ? unsafe.getObject(t_renamed, j_renamed) : null;
                    if (object == null) {
                        unsafe.putObject(t_renamed, j_renamed, registers.object1);
                    } else {
                        unsafe.putObject(t_renamed, j_renamed, com.google.protobuf.Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeMessageField;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iDecodeBytes = com.google.protobuf.ArrayDecoders.decodeBytes(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, registers.object1);
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeBytes;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iDecodeVarint323 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                    int i14 = registers.int1;
                    com.google.protobuf.Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                        unsafe.putObject(t_renamed, j_renamed, java.lang.Integer.valueOf(i14));
                        unsafe.putInt(t_renamed, j2, i4);
                    } else {
                        getMutableUnknownFields(t_renamed).storeField(i3, java.lang.Long.valueOf(i14));
                    }
                    return iDecodeVarint323;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int iDecodeVarint324 = com.google.protobuf.ArrayDecoders.decodeVarint32(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Integer.valueOf(com.google.protobuf.CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint324;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iDecodeVarint643 = com.google.protobuf.ArrayDecoders.decodeVarint64(bArr, i_renamed, registers);
                    unsafe.putObject(t_renamed, j_renamed, java.lang.Long.valueOf(com.google.protobuf.CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeVarint643;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int iDecodeGroupField = com.google.protobuf.ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i_renamed, i2, (i3 & (-8)) | 4, registers);
                    java.lang.Object object2 = unsafe.getInt(t_renamed, j2) == i4 ? unsafe.getObject(t_renamed, j_renamed) : null;
                    if (object2 == null) {
                        unsafe.putObject(t_renamed, j_renamed, registers.object1);
                    } else {
                        unsafe.putObject(t_renamed, j_renamed, com.google.protobuf.Internal.mergeMessage(object2, registers.object1));
                    }
                    unsafe.putInt(t_renamed, j2, i4);
                    return iDecodeGroupField;
                }
                break;
        }
        return i_renamed;
    }

    private com.google.protobuf.Schema getMessageFieldSchema(int i_renamed) {
        int i2 = (i_renamed / 3) * 2;
        com.google.protobuf.Schema schema = (com.google.protobuf.Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        com.google.protobuf.Schema<T_renamed> schemaSchemaFor = com.google.protobuf.Protobuf.getInstance().schemaFor((java.lang.Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private java.lang.Object getMapFieldDefaultEntry(int i_renamed) {
        return this.objects[(i_renamed / 3) * 2];
    }

    private com.google.protobuf.Internal.EnumVerifier getEnumFieldVerifier(int i_renamed) {
        return (com.google.protobuf.Internal.EnumVerifier) this.objects[((i_renamed / 3) * 2) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:120:0x035d, code lost:
    
        if (r0 != r11) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:121:0x035f, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r9 = r36;
        r1 = r17;
        r3 = r18;
        r7 = r19;
        r2 = r20;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:128:0x03a6, code lost:
    
        if (r0 != r15) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:132:0x03c9, code lost:
    
        if (r0 != r15) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:134:0x03cc, code lost:
    
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:26:0x008f. Please report as_renamed an_renamed issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int parseProto2Message(T_renamed r31, byte[] r32, int r33, int r34, int r35, com.google.protobuf.ArrayDecoders.Registers r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:102:0x022b, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:104:0x022e, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:91:0x01de, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:98:0x020c, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:18:0x005c. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseProto3Message(T_renamed r28, byte[] r29, int r30, int r31, com.google.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException {
        if (this.proto3) {
            parseProto3Message(t_renamed, bArr, i_renamed, i2, registers);
        } else {
            parseProto2Message(t_renamed, bArr, i_renamed, i2, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T_renamed t_renamed) {
        int i_renamed;
        int i2 = this.checkInitializedCount;
        while (true) {
            i_renamed = this.repeatedFieldOffsetStart;
            if (i2 >= i_renamed) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i2]));
            java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
            if (object != null) {
                com.google.protobuf.UnsafeUtil.putObject(t_renamed, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i_renamed < length) {
            this.listFieldSchema.makeImmutableListAt(t_renamed, this.intArray[i_renamed]);
            i_renamed++;
        }
        this.unknownFieldSchema.makeImmutable(t_renamed);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t_renamed);
        }
    }

    private final <K_renamed, V_renamed> void mergeMap(java.lang.Object obj, int i_renamed, java.lang.Object obj2, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.Reader reader) throws java.io.IOException {
        long jOffset = offset(typeAndOffsetAt(i_renamed));
        java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            com.google.protobuf.UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            java.lang.Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            com.google.protobuf.UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(java.lang.Object obj, int i_renamed, UB ub, com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        com.google.protobuf.Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i_renamed);
        java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i_renamed)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i_renamed)) == null) ? ub : (UB) filterUnknownEnumMap(i_renamed, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K_renamed, V_renamed, UT, UB> UB filterUnknownEnumMap(int i_renamed, int i2, java.util.Map<K_renamed, V_renamed> map, com.google.protobuf.Internal.EnumVerifier enumVerifier, UB ub, com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        com.google.protobuf.MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i_renamed));
        java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<K_renamed, V_renamed> next = it.next();
            if (!enumVerifier.isInRange(((java.lang.Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                com.google.protobuf.ByteString.CodedBuilder codedBuilderNewCodedBuilder = com.google.protobuf.ByteString.newCodedBuilder(com.google.protobuf.MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    com.google.protobuf.MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (java.io.IOException e_renamed) {
                    throw new java.lang.RuntimeException(e_renamed);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x007a  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T_renamed r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = -1
            r3 = r0
            r2 = r1
            r1 = r3
        L5:
            int r4 = r12.checkInitializedCount
            r5 = 1
            if (r1 >= r4) goto L96
            int[] r4 = r12.intArray
            r4 = r4[r1]
            int r6 = r12.numberAt(r4)
            int r7 = r12.typeAndOffsetAt(r4)
            boolean r8 = r12.proto3
            if (r8 != 0) goto L33
            int[] r8 = r12.buffer
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r2) goto L34
            sun.misc.Unsafe r2 = com.google.protobuf.MessageSchema.UNSAFE
            long r10 = (long) r9
            int r2 = r2.getInt(r13, r10)
            r3 = r2
            r2 = r9
            goto L34
        L33:
            r5 = r0
        L34:
            boolean r8 = isRequired(r7)
            if (r8 == 0) goto L41
            boolean r8 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r8 != 0) goto L41
            return r0
        L41:
            int r8 = type(r7)
            r9 = 9
            if (r8 == r9) goto L81
            r9 = 17
            if (r8 == r9) goto L81
            r5 = 27
            if (r8 == r5) goto L7a
            r5 = 60
            if (r8 == r5) goto L69
            r5 = 68
            if (r8 == r5) goto L69
            r5 = 49
            if (r8 == r5) goto L7a
            r5 = 50
            if (r8 == r5) goto L62
            goto L92
        L62:
            boolean r4 = r12.isMapInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L69:
            boolean r5 = r12.isOneofPresent(r13, r6, r4)
            if (r5 == 0) goto L92
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L7a:
            boolean r4 = r12.isListInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L81:
            boolean r5 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r5 == 0) goto L92
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L92:
            int r1 = r1 + 1
            goto L5
        L96:
            boolean r1 = r12.hasExtensions
            if (r1 == 0) goto La7
            com.google.protobuf.ExtensionSchema<?> r12 = r12.extensionSchema
            com.google.protobuf.FieldSet r12 = r12.getExtensions(r13)
            boolean r12 = r12.isInitialized()
            if (r12 != 0) goto La7
            return r0
        La7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(java.lang.Object obj, int i_renamed, com.google.protobuf.Schema schema) {
        return schema.isInitialized(com.google.protobuf.UnsafeUtil.getObject(obj, offset(i_renamed)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N_renamed> boolean isListInitialized(java.lang.Object obj, int i_renamed, int i2) {
        java.util.List list = (java.util.List) com.google.protobuf.UnsafeUtil.getObject(obj, offset(i_renamed));
        if (list.isEmpty()) {
            return true;
        }
        com.google.protobuf.Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T_renamed t_renamed, int i_renamed, int i2) {
        java.util.Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(com.google.protobuf.UnsafeUtil.getObject(t_renamed, offset(i_renamed)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != com.google.protobuf.WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (java.lang.Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = com.google.protobuf.Protobuf.getInstance().schemaFor((java.lang.Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i_renamed, java.lang.Object obj, com.google.protobuf.Writer writer) throws java.io.IOException {
        if (obj instanceof java.lang.String) {
            writer.writeString(i_renamed, (java.lang.String) obj);
        } else {
            writer.writeBytes(i_renamed, (com.google.protobuf.ByteString) obj);
        }
    }

    private void readString(java.lang.Object obj, int i_renamed, com.google.protobuf.Reader reader) throws java.io.IOException {
        if (isEnforceUtf8(i_renamed)) {
            com.google.protobuf.UnsafeUtil.putObject(obj, offset(i_renamed), reader.readStringRequireUtf8());
        } else if (this.lite) {
            com.google.protobuf.UnsafeUtil.putObject(obj, offset(i_renamed), reader.readString());
        } else {
            com.google.protobuf.UnsafeUtil.putObject(obj, offset(i_renamed), reader.readBytes());
        }
    }

    private void readStringList(java.lang.Object obj, int i_renamed, com.google.protobuf.Reader reader) throws java.io.IOException {
        if (isEnforceUtf8(i_renamed)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i_renamed)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i_renamed)));
        }
    }

    private <E_renamed> void readMessageList(java.lang.Object obj, int i_renamed, com.google.protobuf.Reader reader, com.google.protobuf.Schema<E_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i_renamed)), schema, extensionRegistryLite);
    }

    private <E_renamed> void readGroupList(java.lang.Object obj, long j_renamed, com.google.protobuf.Reader reader, com.google.protobuf.Schema<E_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j_renamed), schema, extensionRegistryLite);
    }

    private int numberAt(int i_renamed) {
        return this.buffer[i_renamed];
    }

    private int typeAndOffsetAt(int i_renamed) {
        return this.buffer[i_renamed + 1];
    }

    private int presenceMaskAndOffsetAt(int i_renamed) {
        return this.buffer[i_renamed + 2];
    }

    private static <T_renamed> double doubleAt(T_renamed t_renamed, long j_renamed) {
        return com.google.protobuf.UnsafeUtil.getDouble(t_renamed, j_renamed);
    }

    private static <T_renamed> float floatAt(T_renamed t_renamed, long j_renamed) {
        return com.google.protobuf.UnsafeUtil.getFloat(t_renamed, j_renamed);
    }

    private static <T_renamed> int intAt(T_renamed t_renamed, long j_renamed) {
        return com.google.protobuf.UnsafeUtil.getInt(t_renamed, j_renamed);
    }

    private static <T_renamed> long longAt(T_renamed t_renamed, long j_renamed) {
        return com.google.protobuf.UnsafeUtil.getLong(t_renamed, j_renamed);
    }

    private static <T_renamed> boolean booleanAt(T_renamed t_renamed, long j_renamed) {
        return com.google.protobuf.UnsafeUtil.getBoolean(t_renamed, j_renamed);
    }

    private static <T_renamed> double oneofDoubleAt(T_renamed t_renamed, long j_renamed) {
        return ((java.lang.Double) com.google.protobuf.UnsafeUtil.getObject(t_renamed, j_renamed)).doubleValue();
    }

    private static <T_renamed> float oneofFloatAt(T_renamed t_renamed, long j_renamed) {
        return ((java.lang.Float) com.google.protobuf.UnsafeUtil.getObject(t_renamed, j_renamed)).floatValue();
    }

    private static <T_renamed> int oneofIntAt(T_renamed t_renamed, long j_renamed) {
        return ((java.lang.Integer) com.google.protobuf.UnsafeUtil.getObject(t_renamed, j_renamed)).intValue();
    }

    private static <T_renamed> long oneofLongAt(T_renamed t_renamed, long j_renamed) {
        return ((java.lang.Long) com.google.protobuf.UnsafeUtil.getObject(t_renamed, j_renamed)).longValue();
    }

    private static <T_renamed> boolean oneofBooleanAt(T_renamed t_renamed, long j_renamed) {
        return ((java.lang.Boolean) com.google.protobuf.UnsafeUtil.getObject(t_renamed, j_renamed)).booleanValue();
    }

    private boolean arePresentForEquals(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        return isFieldPresent(t_renamed, i_renamed) == isFieldPresent(t2, i_renamed);
    }

    private boolean isFieldPresent(T_renamed t_renamed, int i_renamed, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t_renamed, i_renamed);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T_renamed t_renamed, int i_renamed) {
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i_renamed);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return com.google.protobuf.UnsafeUtil.getDouble(t_renamed, jOffset) != 0.0d;
                case 1:
                    return com.google.protobuf.UnsafeUtil.getFloat(t_renamed, jOffset) != 0.0f;
                case 2:
                    return com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) != 0;
                case 3:
                    return com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) != 0;
                case 4:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 5:
                    return com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) != 0;
                case 6:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 7:
                    return com.google.protobuf.UnsafeUtil.getBoolean(t_renamed, jOffset);
                case 8:
                    java.lang.Object object = com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset);
                    if (object instanceof java.lang.String) {
                        return !((java.lang.String) object).isEmpty();
                    }
                    if (object instanceof com.google.protobuf.ByteString) {
                        return !com.google.protobuf.ByteString.EMPTY.equals(object);
                    }
                    throw new java.lang.IllegalArgumentException();
                case 9:
                    return com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset) != null;
                case 10:
                    return !com.google.protobuf.ByteString.EMPTY.equals(com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset));
                case 11:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 12:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 13:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 14:
                    return com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) != 0;
                case 15:
                    return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jOffset) != 0;
                case 16:
                    return com.google.protobuf.UnsafeUtil.getLong(t_renamed, jOffset) != 0;
                case 17:
                    return com.google.protobuf.UnsafeUtil.getObject(t_renamed, jOffset) != null;
                default:
                    throw new java.lang.IllegalArgumentException();
            }
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i_renamed);
        return (com.google.protobuf.UnsafeUtil.getInt(t_renamed, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private void setFieldPresent(T_renamed t_renamed, int i_renamed) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i_renamed);
        long j_renamed = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        com.google.protobuf.UnsafeUtil.putInt(t_renamed, j_renamed, com.google.protobuf.UnsafeUtil.getInt(t_renamed, j_renamed) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private boolean isOneofPresent(T_renamed t_renamed, int i_renamed, int i2) {
        return com.google.protobuf.UnsafeUtil.getInt(t_renamed, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == i_renamed;
    }

    private boolean isOneofCaseEqual(T_renamed t_renamed, T_renamed t2, int i_renamed) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i_renamed) & OFFSET_MASK;
        return com.google.protobuf.UnsafeUtil.getInt(t_renamed, jPresenceMaskAndOffsetAt) == com.google.protobuf.UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T_renamed t_renamed, int i_renamed, int i2) {
        com.google.protobuf.UnsafeUtil.putInt(t_renamed, presenceMaskAndOffsetAt(i2) & OFFSET_MASK, i_renamed);
    }

    private int positionForFieldNumber(int i_renamed) {
        if (i_renamed < this.minFieldNumber || i_renamed > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i_renamed, 0);
    }

    private int positionForFieldNumber(int i_renamed, int i2) {
        if (i_renamed < this.minFieldNumber || i_renamed > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i_renamed, i2);
    }

    private int slowPositionForFieldNumber(int i_renamed, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i_renamed == iNumberAt) {
                return i4;
            }
            if (i_renamed < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
