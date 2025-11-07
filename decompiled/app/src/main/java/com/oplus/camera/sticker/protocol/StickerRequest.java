package com.oplus.camera.sticker.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class StickerRequest extends Message<StickerRequest, Builder> {
    public static final String DEFAULT_ANDROIDVERSION = "";
    public static final String DEFAULT_CLIENTVERSION = "";
    public static final String DEFAULT_IMEI = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_MODEL = "";
    public static final String DEFAULT_OPLUSOSVERSION = "";
    public static final String DEFAULT_OTAVERSION = "";
    public static final String DEFAULT_PROTOCOLVERSION = "";
    public static final String DEFAULT_RESRESOLUTION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String androidVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String clientVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 11)
    public final Long compatibleApp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 10)
    public final Long localDataVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String locale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String model;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String oplusosVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String otaVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String protocolVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String resResolution;
    public static final ProtoAdapter<StickerRequest> ADAPTER = new ProtoAdapter_StickerRequest();
    public static final Long DEFAULT_LOCALDATAVERSION = 0L;
    public static final Long DEFAULT_COMPATIBLEAPP = 0L;

    public StickerRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long OplusGLSurfaceView_14, Long l2) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, OplusGLSurfaceView_14, l2, ByteString.EMPTY);
    }

    public StickerRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long OplusGLSurfaceView_14, Long l2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imei = str;
        this.model = str2;
        this.resResolution = str3;
        this.protocolVersion = str4;
        this.clientVersion = str5;
        this.oplusosVersion = str6;
        this.androidVersion = str7;
        this.otaVersion = str8;
        this.locale = str9;
        this.localDataVersion = OplusGLSurfaceView_14;
        this.compatibleApp = l2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.imei = this.imei;
        builder.model = this.model;
        builder.resResolution = this.resResolution;
        builder.protocolVersion = this.protocolVersion;
        builder.clientVersion = this.clientVersion;
        builder.oplusosVersion = this.oplusosVersion;
        builder.androidVersion = this.androidVersion;
        builder.otaVersion = this.otaVersion;
        builder.locale = this.locale;
        builder.localDataVersion = this.localDataVersion;
        builder.compatibleApp = this.compatibleApp;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StickerRequest)) {
            return false;
        }
        StickerRequest stickerRequest = (StickerRequest) obj;
        return unknownFields().equals(stickerRequest.unknownFields()) && Internal.equals(this.imei, stickerRequest.imei) && Internal.equals(this.model, stickerRequest.model) && Internal.equals(this.resResolution, stickerRequest.resResolution) && Internal.equals(this.protocolVersion, stickerRequest.protocolVersion) && Internal.equals(this.clientVersion, stickerRequest.clientVersion) && Internal.equals(this.oplusosVersion, stickerRequest.oplusosVersion) && Internal.equals(this.androidVersion, stickerRequest.androidVersion) && Internal.equals(this.otaVersion, stickerRequest.otaVersion) && Internal.equals(this.locale, stickerRequest.locale) && Internal.equals(this.localDataVersion, stickerRequest.localDataVersion) && Internal.equals(this.compatibleApp, stickerRequest.compatibleApp);
    }

    public int hashCode() {
        int OplusGLSurfaceView_13 = this.hashCode;
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.imei;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.model;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.resResolution;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.protocolVersion;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.clientVersion;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.oplusosVersion;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.androidVersion;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.otaVersion;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.locale;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Long OplusGLSurfaceView_14 = this.localDataVersion;
        int iHashCode11 = (iHashCode10 + (OplusGLSurfaceView_14 != null ? OplusGLSurfaceView_14.hashCode() : 0)) * 37;
        Long l2 = this.compatibleApp;
        int iHashCode12 = iHashCode11 + (l2 != null ? l2.hashCode() : 0);
        this.hashCode = iHashCode12;
        return iHashCode12;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.imei != null) {
            sb.append(", imei=");
            sb.append(this.imei);
        }
        if (this.model != null) {
            sb.append(", model=");
            sb.append(this.model);
        }
        if (this.resResolution != null) {
            sb.append(", resResolution=");
            sb.append(this.resResolution);
        }
        if (this.protocolVersion != null) {
            sb.append(", protocolVersion=");
            sb.append(this.protocolVersion);
        }
        if (this.clientVersion != null) {
            sb.append(", clientVersion=");
            sb.append(this.clientVersion);
        }
        if (this.oplusosVersion != null) {
            sb.append(", oplusosVersion=");
            sb.append(this.oplusosVersion);
        }
        if (this.androidVersion != null) {
            sb.append(", androidVersion=");
            sb.append(this.androidVersion);
        }
        if (this.otaVersion != null) {
            sb.append(", otaVersion=");
            sb.append(this.otaVersion);
        }
        if (this.locale != null) {
            sb.append(", locale=");
            sb.append(this.locale);
        }
        if (this.localDataVersion != null) {
            sb.append(", localDataVersion=");
            sb.append(this.localDataVersion);
        }
        if (this.compatibleApp != null) {
            sb.append(", compatibleApp=");
            sb.append(this.compatibleApp);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "StickerRequest{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public static final class Builder extends Message.Builder<StickerRequest, Builder> {
        public String androidVersion;
        public String clientVersion;
        public Long compatibleApp;
        public String imei;
        public Long localDataVersion;
        public String locale;
        public String model;
        public String oplusosVersion;
        public String otaVersion;
        public String protocolVersion;
        public String resResolution;

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder resResolution(String str) {
            this.resResolution = str;
            return this;
        }

        public Builder protocolVersion(String str) {
            this.protocolVersion = str;
            return this;
        }

        public Builder clientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder oplusosVersion(String str) {
            this.oplusosVersion = str;
            return this;
        }

        public Builder androidVersion(String str) {
            this.androidVersion = str;
            return this;
        }

        public Builder otaVersion(String str) {
            this.otaVersion = str;
            return this;
        }

        public Builder locale(String str) {
            this.locale = str;
            return this;
        }

        public Builder localDataVersion(Long OplusGLSurfaceView_14) {
            this.localDataVersion = OplusGLSurfaceView_14;
            return this;
        }

        public Builder compatibleApp(Long OplusGLSurfaceView_14) {
            this.compatibleApp = OplusGLSurfaceView_14;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public StickerRequest build() {
            return new StickerRequest(this.imei, this.model, this.resResolution, this.protocolVersion, this.clientVersion, this.oplusosVersion, this.androidVersion, this.otaVersion, this.locale, this.localDataVersion, this.compatibleApp, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerRequest extends ProtoAdapter<StickerRequest> {
        ProtoAdapter_StickerRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, StickerRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(StickerRequest stickerRequest) {
            return (stickerRequest.imei != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, stickerRequest.imei) : 0) + (stickerRequest.model != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, stickerRequest.model) : 0) + (stickerRequest.resResolution != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, stickerRequest.resResolution) : 0) + (stickerRequest.protocolVersion != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, stickerRequest.protocolVersion) : 0) + (stickerRequest.clientVersion != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, stickerRequest.clientVersion) : 0) + (stickerRequest.oplusosVersion != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, stickerRequest.oplusosVersion) : 0) + (stickerRequest.androidVersion != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, stickerRequest.androidVersion) : 0) + (stickerRequest.otaVersion != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, stickerRequest.otaVersion) : 0) + (stickerRequest.locale != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, stickerRequest.locale) : 0) + (stickerRequest.localDataVersion != null ? ProtoAdapter.INT64.encodedSizeWithTag(10, stickerRequest.localDataVersion) : 0) + (stickerRequest.compatibleApp != null ? ProtoAdapter.INT64.encodedSizeWithTag(11, stickerRequest.compatibleApp) : 0) + stickerRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, StickerRequest stickerRequest) throws IOException {
            if (stickerRequest.imei != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, stickerRequest.imei);
            }
            if (stickerRequest.model != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, stickerRequest.model);
            }
            if (stickerRequest.resResolution != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerRequest.resResolution);
            }
            if (stickerRequest.protocolVersion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, stickerRequest.protocolVersion);
            }
            if (stickerRequest.clientVersion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, stickerRequest.clientVersion);
            }
            if (stickerRequest.oplusosVersion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerRequest.oplusosVersion);
            }
            if (stickerRequest.androidVersion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, stickerRequest.androidVersion);
            }
            if (stickerRequest.otaVersion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, stickerRequest.otaVersion);
            }
            if (stickerRequest.locale != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, stickerRequest.locale);
            }
            if (stickerRequest.localDataVersion != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 10, stickerRequest.localDataVersion);
            }
            if (stickerRequest.compatibleApp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 11, stickerRequest.compatibleApp);
            }
            protoWriter.writeBytes(stickerRequest.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StickerRequest decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag != -1) {
                    switch (iNextTag) {
                        case 1:
                            builder.imei(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.model(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.resResolution(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.protocolVersion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.clientVersion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.oplusosVersion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.androidVersion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.otaVersion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.locale(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.localDataVersion(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 11:
                            builder.compatibleApp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        default:
                            FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public StickerRequest redact(StickerRequest stickerRequest) {
            Builder builderNewBuilder = stickerRequest.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }
}
