package com.oplus.camera.soloop;

import java.util.List;

/* loaded from: classes2.dex */
public class SoloopRequest {
    public ClientMeta clientMeta = null;
    public List<Upgrades> upgrades = null;

    public static class ClientMeta {
        public int androidVersionCode = 0;
        public String channel = "";
        public String oplusOsCode = "";
        public String language = "";
        public String model = "";
        public String region = "";
    }

    public static class Upgrades {
        public String pkgName = "";
        public long verCode = 0;
    }
}
