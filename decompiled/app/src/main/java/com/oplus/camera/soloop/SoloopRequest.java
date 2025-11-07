package com.oplus.camera.soloop;

/* loaded from: classes2.dex */
public class SoloopRequest {
    public com.oplus.camera.soloop.SoloopRequest.ClientMeta clientMeta = null;
    public java.util.List<com.oplus.camera.soloop.SoloopRequest.Upgrades> upgrades = null;

    public static class ClientMeta {
        public int androidVersionCode = 0;
        public java.lang.String channel = "";
        public java.lang.String oplusOsCode = "";
        public java.lang.String language = "";
        public java.lang.String model = "";
        public java.lang.String region = "";
    }

    public static class Upgrades {
        public java.lang.String pkgName = "";
        public long verCode = 0;
    }
}
