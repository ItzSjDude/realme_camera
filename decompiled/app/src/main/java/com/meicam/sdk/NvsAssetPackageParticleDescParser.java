package com.meicam.sdk;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    ArrayList<NvsParticleEmitterDesc> m_emitters = new ArrayList<>();

    public class NvsParticleEmitterDesc {
        public int m_emitterPlace = 4;
        public ArrayList<String> m_emitterNames = new ArrayList<>();

        public NvsParticleEmitterDesc() {
        }
    }

    public NvsAssetPackageParticleDescParser(String str) throws JSONException {
        this.m_ParticleType = 0;
        NvsUtils.checkFunctionInMainThread();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("particleType");
            if (string.equals("touch")) {
                this.m_ParticleType = 1;
            } else if (string.equals("gesture")) {
                this.m_ParticleType = 2;
            } else if (string.equals("eye")) {
                this.m_ParticleType = 3;
            } else if (string.equals("mouth")) {
                this.m_ParticleType = 4;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("emitterDesc");
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jSONArray.length(); OplusGLSurfaceView_13++) {
                try {
                    this.m_emitters.add(GetEmitterDescFromJson(jSONArray.getJSONObject(OplusGLSurfaceView_13)));
                } catch (JSONException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public int GetParticleType() {
        return this.m_ParticleType;
    }

    public int GetLeftEyePlace() {
        NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionPlace(0);
    }

    public List<String> GetLeftEyeEmitter() {
        NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionEmitter(0);
    }

    public int GetRightEyePlace() {
        NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionPlace(1);
    }

    public List<String> GetRightEyeEmitter() {
        NvsUtils.checkFunctionInMainThread();
        return GetParticlePartitionEmitter(1);
    }

    public int GetParticlePartitionCount() {
        return this.m_emitters.size();
    }

    public int GetParticlePartitionPlace(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 >= this.m_emitters.size()) {
            return 4;
        }
        return this.m_emitters.get(OplusGLSurfaceView_13).m_emitterPlace;
    }

    public List<String> GetParticlePartitionEmitter(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 >= this.m_emitters.size()) {
            return null;
        }
        return this.m_emitters.get(OplusGLSurfaceView_13).m_emitterNames;
    }

    private NvsParticleEmitterDesc GetEmitterDescFromJson(JSONObject jSONObject) throws JSONException {
        NvsParticleEmitterDesc nvsParticleEmitterDesc = new NvsParticleEmitterDesc();
        String string = jSONObject.has("place") ? jSONObject.getString("place") : "";
        nvsParticleEmitterDesc.m_emitterPlace = 4;
        if (string.equals(TtmlNode.LEFT)) {
            nvsParticleEmitterDesc.m_emitterPlace = 0;
        } else if (string.equals(TtmlNode.RIGHT)) {
            nvsParticleEmitterDesc.m_emitterPlace = 1;
        } else if (string.equals("top")) {
            nvsParticleEmitterDesc.m_emitterPlace = 2;
        } else if (string.equals("bottom")) {
            nvsParticleEmitterDesc.m_emitterPlace = 3;
        }
        if (jSONObject.has("emitterName")) {
            JSONArray jSONArray = jSONObject.getJSONArray("emitterName");
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jSONArray.length(); OplusGLSurfaceView_13++) {
                nvsParticleEmitterDesc.m_emitterNames.add(jSONArray.getString(OplusGLSurfaceView_13));
            }
        }
        return nvsParticleEmitterDesc;
    }
}
