package com.google.gson;

/* loaded from: classes.dex */
public final class JsonPrimitive extends com.google.gson.JsonElement {
    private static final java.lang.Class<?>[] PRIMITIVE_TYPES = {java.lang.Integer.TYPE, java.lang.Long.TYPE, java.lang.Short.TYPE, java.lang.Float.TYPE, java.lang.Double.TYPE, java.lang.Byte.TYPE, java.lang.Boolean.TYPE, java.lang.Character.TYPE, java.lang.Integer.class, java.lang.Long.class, java.lang.Short.class, java.lang.Float.class, java.lang.Double.class, java.lang.Byte.class, java.lang.Boolean.class, java.lang.Character.class};
    private java.lang.Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonPrimitive deepCopy() {
        return this;
    }

    public JsonPrimitive(java.lang.Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(java.lang.Number number) {
        setValue(number);
    }

    public JsonPrimitive(java.lang.String str) {
        setValue(str);
    }

    public JsonPrimitive(java.lang.Character ch_renamed) {
        setValue(ch_renamed);
    }

    JsonPrimitive(java.lang.Object obj) {
        setValue(obj);
    }

    void setValue(java.lang.Object obj) {
        if (obj instanceof java.lang.Character) {
            this.value = java.lang.String.valueOf(((java.lang.Character) obj).charValue());
        } else {
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument((obj instanceof java.lang.Number) || isPrimitiveOrString(obj));
            this.value = obj;
        }
    }

    public boolean isBoolean() {
        return this.value instanceof java.lang.Boolean;
    }

    @Override // com.google.gson.JsonElement
    java.lang.Boolean getAsBooleanWrapper() {
        return (java.lang.Boolean) this.value;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return getAsBooleanWrapper().booleanValue();
        }
        return java.lang.Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof java.lang.Number;
    }

    @Override // com.google.gson.JsonElement
    public java.lang.Number getAsNumber() {
        java.lang.Object obj = this.value;
        return obj instanceof java.lang.String ? new com.google.gson.internal.LazilyParsedNumber((java.lang.String) obj) : (java.lang.Number) obj;
    }

    public boolean isString() {
        return this.value instanceof java.lang.String;
    }

    @Override // com.google.gson.JsonElement
    public java.lang.String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return getAsBooleanWrapper().toString();
        }
        return (java.lang.String) this.value;
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : java.lang.Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigDecimal getAsBigDecimal() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigDecimal ? (java.math.BigDecimal) obj : new java.math.BigDecimal(obj.toString());
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigInteger getAsBigInteger() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigInteger ? (java.math.BigInteger) obj : new java.math.BigInteger(obj.toString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : java.lang.Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : java.lang.Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : java.lang.Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : java.lang.Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : java.lang.Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    private static boolean isPrimitiveOrString(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return true;
        }
        java.lang.Class<?> cls = obj.getClass();
        for (java.lang.Class<?> cls2 : PRIMITIVE_TYPES) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            java.lang.Object obj = this.value;
            if (obj instanceof java.lang.Number) {
                jDoubleToLongBits = java.lang.Double.doubleToLongBits(getAsNumber().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.gson.JsonPrimitive jsonPrimitive = (com.google.gson.JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        }
        if ((this.value instanceof java.lang.Number) && (jsonPrimitive.value instanceof java.lang.Number)) {
            double dDoubleValue = getAsNumber().doubleValue();
            double dDoubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (dDoubleValue != dDoubleValue2) {
                return java.lang.Double.isNaN(dDoubleValue) && java.lang.Double.isNaN(dDoubleValue2);
            }
            return true;
        }
        return this.value.equals(jsonPrimitive.value);
    }

    private static boolean isIntegral(com.google.gson.JsonPrimitive jsonPrimitive) {
        java.lang.Object obj = jsonPrimitive.value;
        if (!(obj instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number = (java.lang.Number) obj;
        return (number instanceof java.math.BigInteger) || (number instanceof java.lang.Long) || (number instanceof java.lang.Integer) || (number instanceof java.lang.Short) || (number instanceof java.lang.Byte);
    }
}
