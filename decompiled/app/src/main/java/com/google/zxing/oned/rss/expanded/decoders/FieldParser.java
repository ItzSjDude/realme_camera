package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class FieldParser {
    private static final java.lang.Object VARIABLE_LENGTH = new java.lang.Object();
    private static final java.lang.Object[][] TWO_DIGIT_DATA_LENGTH = {new java.lang.Object[]{"00", 18}, new java.lang.Object[]{"01", 14}, new java.lang.Object[]{"02", 14}, new java.lang.Object[]{com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE, VARIABLE_LENGTH, 20}, new java.lang.Object[]{com.oplus.camera.statistics.model.FocusAimMsgData.KEY_SEPARATE_METERING_FOCUS, 6}, new java.lang.Object[]{"12", 6}, new java.lang.Object[]{"13", 6}, new java.lang.Object[]{"15", 6}, new java.lang.Object[]{"17", 6}, new java.lang.Object[]{"20", 2}, new java.lang.Object[]{"21", VARIABLE_LENGTH, 20}, new java.lang.Object[]{"22", VARIABLE_LENGTH, 29}, new java.lang.Object[]{com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS, VARIABLE_LENGTH, 8}, new java.lang.Object[]{com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_GRID, VARIABLE_LENGTH, 8}, new java.lang.Object[]{"90", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"91", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"92", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"93", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"94", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"95", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"96", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"97", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"98", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"99", VARIABLE_LENGTH, 30}};
    private static final java.lang.Object[][] THREE_DIGIT_DATA_LENGTH = {new java.lang.Object[]{"240", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"241", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"242", VARIABLE_LENGTH, 6}, new java.lang.Object[]{"250", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"251", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"253", VARIABLE_LENGTH, 17}, new java.lang.Object[]{"254", VARIABLE_LENGTH, 20}, new java.lang.Object[]{"400", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"401", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"402", 17}, new java.lang.Object[]{"403", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"410", 13}, new java.lang.Object[]{"411", 13}, new java.lang.Object[]{"412", 13}, new java.lang.Object[]{"413", 13}, new java.lang.Object[]{"414", 13}, new java.lang.Object[]{"420", VARIABLE_LENGTH, 20}, new java.lang.Object[]{"421", VARIABLE_LENGTH, 15}, new java.lang.Object[]{"422", 3}, new java.lang.Object[]{"423", VARIABLE_LENGTH, 15}, new java.lang.Object[]{"424", 3}, new java.lang.Object[]{"425", 3}, new java.lang.Object[]{"426", 3}};
    private static final java.lang.Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = {new java.lang.Object[]{"310", 6}, new java.lang.Object[]{"311", 6}, new java.lang.Object[]{"312", 6}, new java.lang.Object[]{"313", 6}, new java.lang.Object[]{"314", 6}, new java.lang.Object[]{"315", 6}, new java.lang.Object[]{"316", 6}, new java.lang.Object[]{"320", 6}, new java.lang.Object[]{"321", 6}, new java.lang.Object[]{"322", 6}, new java.lang.Object[]{"323", 6}, new java.lang.Object[]{"324", 6}, new java.lang.Object[]{"325", 6}, new java.lang.Object[]{"326", 6}, new java.lang.Object[]{"327", 6}, new java.lang.Object[]{"328", 6}, new java.lang.Object[]{"329", 6}, new java.lang.Object[]{"330", 6}, new java.lang.Object[]{"331", 6}, new java.lang.Object[]{"332", 6}, new java.lang.Object[]{"333", 6}, new java.lang.Object[]{"334", 6}, new java.lang.Object[]{"335", 6}, new java.lang.Object[]{"336", 6}, new java.lang.Object[]{"340", 6}, new java.lang.Object[]{"341", 6}, new java.lang.Object[]{"342", 6}, new java.lang.Object[]{"343", 6}, new java.lang.Object[]{"344", 6}, new java.lang.Object[]{"345", 6}, new java.lang.Object[]{"346", 6}, new java.lang.Object[]{"347", 6}, new java.lang.Object[]{"348", 6}, new java.lang.Object[]{"349", 6}, new java.lang.Object[]{com.anc.humansdk.doubleexposure.BuildConfig.BUILD_NUMBER, 6}, new java.lang.Object[]{"351", 6}, new java.lang.Object[]{"352", 6}, new java.lang.Object[]{"353", 6}, new java.lang.Object[]{"354", 6}, new java.lang.Object[]{"355", 6}, new java.lang.Object[]{"356", 6}, new java.lang.Object[]{"357", 6}, new java.lang.Object[]{"360", 6}, new java.lang.Object[]{"361", 6}, new java.lang.Object[]{"362", 6}, new java.lang.Object[]{"363", 6}, new java.lang.Object[]{"364", 6}, new java.lang.Object[]{"365", 6}, new java.lang.Object[]{"366", 6}, new java.lang.Object[]{"367", 6}, new java.lang.Object[]{"368", 6}, new java.lang.Object[]{"369", 6}, new java.lang.Object[]{"390", VARIABLE_LENGTH, 15}, new java.lang.Object[]{"391", VARIABLE_LENGTH, 18}, new java.lang.Object[]{"392", VARIABLE_LENGTH, 15}, new java.lang.Object[]{"393", VARIABLE_LENGTH, 18}, new java.lang.Object[]{"703", VARIABLE_LENGTH, 30}};
    private static final java.lang.Object[][] FOUR_DIGIT_DATA_LENGTH = {new java.lang.Object[]{"7001", 13}, new java.lang.Object[]{"7002", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"7003", 10}, new java.lang.Object[]{"8001", 14}, new java.lang.Object[]{"8002", VARIABLE_LENGTH, 20}, new java.lang.Object[]{"8003", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"8004", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"8005", 6}, new java.lang.Object[]{"8006", 18}, new java.lang.Object[]{"8007", VARIABLE_LENGTH, 30}, new java.lang.Object[]{"8008", VARIABLE_LENGTH, 12}, new java.lang.Object[]{"8018", 18}, new java.lang.Object[]{"8020", VARIABLE_LENGTH, 25}, new java.lang.Object[]{"8100", 6}, new java.lang.Object[]{"8101", 10}, new java.lang.Object[]{"8102", 2}, new java.lang.Object[]{"8110", VARIABLE_LENGTH, 70}, new java.lang.Object[]{"8200", VARIABLE_LENGTH, 70}};

    private FieldParser() {
    }

    static java.lang.String parseFieldsInGeneralPurpose(java.lang.String str) throws com.google.zxing.NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String strSubstring = str.substring(0, 2);
        for (java.lang.Object[] objArr : TWO_DIGIT_DATA_LENGTH) {
            if (objArr[0].equals(strSubstring)) {
                if (objArr[1] == VARIABLE_LENGTH) {
                    return processVariableAI(2, ((java.lang.Integer) objArr[2]).intValue(), str);
                }
                return processFixedAI(2, ((java.lang.Integer) objArr[1]).intValue(), str);
            }
        }
        if (str.length() < 3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String strSubstring2 = str.substring(0, 3);
        for (java.lang.Object[] objArr2 : THREE_DIGIT_DATA_LENGTH) {
            if (objArr2[0].equals(strSubstring2)) {
                if (objArr2[1] == VARIABLE_LENGTH) {
                    return processVariableAI(3, ((java.lang.Integer) objArr2[2]).intValue(), str);
                }
                return processFixedAI(3, ((java.lang.Integer) objArr2[1]).intValue(), str);
            }
        }
        for (java.lang.Object[] objArr3 : THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH) {
            if (objArr3[0].equals(strSubstring2)) {
                if (objArr3[1] == VARIABLE_LENGTH) {
                    return processVariableAI(4, ((java.lang.Integer) objArr3[2]).intValue(), str);
                }
                return processFixedAI(4, ((java.lang.Integer) objArr3[1]).intValue(), str);
            }
        }
        if (str.length() < 4) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String strSubstring3 = str.substring(0, 4);
        for (java.lang.Object[] objArr4 : FOUR_DIGIT_DATA_LENGTH) {
            if (objArr4[0].equals(strSubstring3)) {
                if (objArr4[1] == VARIABLE_LENGTH) {
                    return processVariableAI(4, ((java.lang.Integer) objArr4[2]).intValue(), str);
                }
                return processFixedAI(4, ((java.lang.Integer) objArr4[1]).intValue(), str);
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static java.lang.String processFixedAI(int i_renamed, int i2, java.lang.String str) throws com.google.zxing.NotFoundException {
        if (str.length() < i_renamed) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String strSubstring = str.substring(0, i_renamed);
        int i3 = i2 + i_renamed;
        if (str.length() < i3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String strSubstring2 = str.substring(i_renamed, i3);
        java.lang.String str2 = "(" + strSubstring + ')' + strSubstring2;
        java.lang.String fieldsInGeneralPurpose = parseFieldsInGeneralPurpose(str.substring(i3));
        if (fieldsInGeneralPurpose == null) {
            return str2;
        }
        return str2 + fieldsInGeneralPurpose;
    }

    private static java.lang.String processVariableAI(int i_renamed, int i2, java.lang.String str) throws com.google.zxing.NotFoundException {
        java.lang.String strSubstring = str.substring(0, i_renamed);
        int iMin = java.lang.Math.min(str.length(), i2 + i_renamed);
        java.lang.String strSubstring2 = str.substring(i_renamed, iMin);
        java.lang.String str2 = "(" + strSubstring + ')' + strSubstring2;
        java.lang.String fieldsInGeneralPurpose = parseFieldsInGeneralPurpose(str.substring(iMin));
        if (fieldsInGeneralPurpose == null) {
            return str2;
        }
        return str2 + fieldsInGeneralPurpose;
    }
}
