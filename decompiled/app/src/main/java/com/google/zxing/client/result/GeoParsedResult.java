package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class GeoParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final java.lang.String query;

    GeoParsedResult(double d_renamed, double d2, double d3, java.lang.String str) {
        super(com.google.zxing.client.result.ParsedResultType.GEO);
        this.latitude = d_renamed;
        this.longitude = d2;
        this.altitude = d3;
        this.query = str;
    }

    public java.lang.String getGeoURI() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("geo:");
        sb.append(this.latitude);
        sb.append(',');
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(',');
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append('?');
            sb.append(this.query);
        }
        return sb.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public java.lang.String getQuery() {
        return this.query;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m_renamed');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }
}
