package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsFxDescription {
    long m_fxDescription = 0;

    private native java.util.List<com.meicam.sdk.NvsFxDescription.ParamInfoObject> nativeGetAllParamsInfo(long j_renamed);

    private native java.lang.String nativeGetName(long j_renamed);

    public static class ParamInfoObject {
        public static final java.lang.String PARAM_BOOL_DEF_VAL = "boolDefVal";
        public static final java.lang.String PARAM_COLOR_DEF_A = "colorDefA";
        public static final java.lang.String PARAM_COLOR_DEF_B = "colorDefB";
        public static final java.lang.String PARAM_COLOR_DEF_G = "colorDefG";
        public static final java.lang.String PARAM_COLOR_DEF_R = "colorDefR";
        public static final java.lang.String PARAM_FLOAT_DEF_VAL = "floatDefVal";
        public static final java.lang.String PARAM_FLOAT_MAX_VAL = "floatMaxVal";
        public static final java.lang.String PARAM_FLOAT_MIN_VAL = "floatMinVal";
        public static final java.lang.String PARAM_INT_DEF_VAL = "intDefVal";
        public static final java.lang.String PARAM_INT_MAX_VAL = "intMaxVal";
        public static final java.lang.String PARAM_INT_MIN_VAL = "intMinVal";
        public static final java.lang.String PARAM_MENU_ARRAY = "menuArray";
        public static final java.lang.String PARAM_MENU_DEF_VAL = "menuDefVal";
        public static final java.lang.String PARAM_NAME = "paramName";
        public static final java.lang.String PARAM_POSITION2D_DEF_X = "position2DDefX";
        public static final java.lang.String PARAM_POSITION2D_DEF_Y = "position2DDefY";
        public static final java.lang.String PARAM_POSITION3D_DEF_X = "position3DDefX";
        public static final java.lang.String PARAM_POSITION3D_DEF_Y = "position3DDefY";
        public static final java.lang.String PARAM_POSITION3D_DEF_Z = "position3DDefZ";
        public static final java.lang.String PARAM_STRING_DEF = "stringDef";
        public static final java.lang.String PARAM_STRING_TYPE = "stringType";
        public static final int PARAM_STRING_TYPE_DIRECTORYPATH = 3;
        public static final int PARAM_STRING_TYPE_FILEPATH = 2;
        public static final int PARAM_STRING_TYPE_INVALID = -1;
        public static final int PARAM_STRING_TYPE_LABEL = 4;
        public static final int PARAM_STRING_TYPE_MULTILINE = 1;
        public static final int PARAM_STRING_TYPE_SINGLELINE = 0;
        public static final java.lang.String PARAM_TYPE = "paramType";
        public static final java.lang.String PARAM_TYPE_BOOL = "BOOL";
        public static final java.lang.String PARAM_TYPE_COLOR = "COLOR";
        public static final java.lang.String PARAM_TYPE_FLOAT = "FLOAT";
        public static final java.lang.String PARAM_TYPE_INT = "INT";
        public static final java.lang.String PARAM_TYPE_MENU = "MENU";
        public static final java.lang.String PARAM_TYPE_POSITION2D = "POSITION2D";
        public static final java.lang.String PARAM_TYPE_POSITION3D = "POSITION3D";
        public static final java.lang.String PARAM_TYPE_STRING = "STRING";
        private java.util.Map<java.lang.String, java.lang.Object> m_mapParams = new java.util.HashMap();

        ParamInfoObject() {
        }

        public final int getInteger(java.lang.String str) {
            return ((java.lang.Integer) this.m_mapParams.get(str)).intValue();
        }

        public final double getFloat(java.lang.String str) {
            return ((java.lang.Double) this.m_mapParams.get(str)).doubleValue();
        }

        public final java.lang.String getString(java.lang.String str) {
            return (java.lang.String) this.m_mapParams.get(str);
        }

        public final java.lang.Object getObject(java.lang.String str) {
            return this.m_mapParams.get(str);
        }

        public final boolean getBoolean(java.lang.String str) {
            return ((java.lang.Integer) this.m_mapParams.get(str)).intValue() != 0;
        }

        final void setInteger(java.lang.String str, int i_renamed) {
            this.m_mapParams.put(str, java.lang.Integer.valueOf(i_renamed));
        }

        final void setFloat(java.lang.String str, double d_renamed) {
            this.m_mapParams.put(str, java.lang.Double.valueOf(d_renamed));
        }

        final void setString(java.lang.String str, java.lang.String str2) {
            this.m_mapParams.put(str, str2);
        }

        final void setObject(java.lang.String str, java.lang.Object obj) {
            this.m_mapParams.put(str, obj);
        }
    }

    void setFxDescription(long j_renamed) {
        this.m_fxDescription = j_renamed;
    }

    public java.lang.String getName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetName(this.m_fxDescription);
    }

    public java.util.List<com.meicam.sdk.NvsFxDescription.ParamInfoObject> getAllParamsInfo() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllParamsInfo(this.m_fxDescription);
    }
}
