package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class VINParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final java.lang.String sequentialNumber;
    private final java.lang.String vehicleAttributes;
    private final java.lang.String vehicleDescriptorSection;
    private final java.lang.String vehicleIdentifierSection;
    private final java.lang.String vin;
    private final java.lang.String worldManufacturerID;

    public VINParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i_renamed, char c2, java.lang.String str7) {
        super(com.google.zxing.client.result.ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i_renamed;
        this.plantCode = c2;
        this.sequentialNumber = str7;
    }

    public java.lang.String getVIN() {
        return this.vin;
    }

    public java.lang.String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }

    public java.lang.String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public java.lang.String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public java.lang.String getCountryCode() {
        return this.countryCode;
    }

    public java.lang.String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public java.lang.String getSequentialNumber() {
        return this.sequentialNumber;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
        sb.append(this.worldManufacturerID);
        sb.append(' ');
        sb.append(this.vehicleDescriptorSection);
        sb.append(' ');
        sb.append(this.vehicleIdentifierSection);
        sb.append('\n_renamed');
        java.lang.String str = this.countryCode;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.modelYear);
        sb.append(' ');
        sb.append(this.plantCode);
        sb.append(' ');
        sb.append(this.sequentialNumber);
        sb.append('\n_renamed');
        return sb.toString();
    }
}
