package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAssetPackageParticleDescParser {
    public static final int EMITTER_PLACE_BOTTOM = 3;
    public static final int EMITTER_PLACE_CENTER = 4;
    public static final int EMITTER_PLACE_LEFT = 0;
    public static final int EMITTER_PLACE_RIGHT = 1;
    public static final int EMITTER_PLACE_TOP = 2;
    public static final int PARTICLE_TYPE_EYE = 3;
    public static final int PARTICLE_TYPE_GESTURE = 2;
    public static final int PARTICLE_TYPE_MOUTH = 4;
    public static final int PARTICLE_TYPE_NORMAL = 0;
    public static final int PARTICLE_TYPE_TOUCH = 1;
    int m_ParticleType;
    java.util.ArrayList<com.meicam.sdk.NvsAssetPackageParticleDescParser.NvsParticleEmitterDesc> m_emitters = new java.util.ArrayList<>();

    public class NvsParticleEmitterDesc {
        public int m_emitterPlace = 4;
        public java.util.ArrayList<java.lang.String> m_emitterNames = new java.util.ArrayList<>();

        public NvsParticleEmitterDesc() {
        }
    }

    public NvsAssetPackageParticleDescParser(java.lang.String str) throws org.json.JSONException {
        this.m_ParticleType = 0;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String string = jSONObject.getString("particleType");
            if (string.equals("touch")) {
                this.m_ParticleType = 1;
            } else if (string.equals("gesture")) {
                this.m_ParticleType = 2;
            } else if (string.equals("eye")) {
                this.m_ParticleType = 3;
            } else if (string.equals("mouth")) {
                this.m_ParticleType = 4;
            }
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("emitterDesc");
            for (int i_renamed = 0; i_renamed < jSONArray.length(); i_renamed++) {
                try {
                    this.m_emitters.add(GetEmitterDescFromJson(jSONArray.getJSONObject(i_renamed)));
                } catch (org.json.JSONException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
    }

    public int GetParticleType() {
        return this.m_ParticleType;
    }

    public int GetLeftEyePlace() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionPlace(0);
    }

    public java.util.List<java.lang.String> GetLeftEyeEmitter() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionEmitter(0);
    }

    public int GetRightEyePlace() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionPlace(1);
    }

    public java.util.List<java.lang.String> GetRightEyeEmitter() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionEmitter(1);
    }

    public int GetParticlePartitionCount() {
        return this.m_emitters.size();
    }

    public int GetParticlePartitionPlace(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed >= this.m_emitters.size()) {
            return 4;
        }
        return this.m_emitters.get(i_renamed).m_emitterPlace;
    }

    public java.util.List<java.lang.String> GetParticlePartitionEmitter(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed >= this.m_emitters.size()) {
            return null;
        }
        return this.m_emitters.get(i_renamed).m_emitterNames;
    }

    private com.meicam.sdk.NvsAssetPackageParticleDescParser.NvsParticleEmitterDesc GetEmitterDescFromJson(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.meicam.sdk.NvsAssetPackageParticleDescParser.NvsParticleEmitterDesc nvsParticleEmitterDesc = new com.meicam.sdk.NvsAssetPackageParticleDescParser.NvsParticleEmitterDesc();
        java.lang.String string = jSONObject.has("place") ? jSONObject.getString("place") : "";
        nvsParticleEmitterDesc.m_emitterPlace = 4;
        if (string.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.LEFT)) {
            nvsParticleEmitterDesc.m_emitterPlace = 0;
        } else if (string.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT)) {
            nvsParticleEmitterDesc.m_emitterPlace = 1;
        } else if (string.equals("top")) {
            nvsParticleEmitterDesc.m_emitterPlace = 2;
        } else if (string.equals("bottom")) {
            nvsParticleEmitterDesc.m_emitterPlace = 3;
        }
        if (jSONObject.has("emitterName")) {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("emitterName");
            for (int i_renamed = 0; i_renamed < jSONArray.length(); i_renamed++) {
                nvsParticleEmitterDesc.m_emitterNames.add(jSONArray.getString(i_renamed));
            }
        }
        return nvsParticleEmitterDesc;
    }
}
