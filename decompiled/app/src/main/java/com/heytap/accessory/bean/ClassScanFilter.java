package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class ClassScanFilter implements IScanFilter {
    public static final Parcelable.Creator<ClassScanFilter> CREATOR = new Parcelable.Creator<ClassScanFilter>() { // from class: com.heytap.accessory.bean.ClassScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClassScanFilter createFromParcel(Parcel parcel) {
            return new ClassScanFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClassScanFilter[] newArray(int OplusGLSurfaceView_13) {
            return new ClassScanFilter[OplusGLSurfaceView_13];
        }
    };
    public static final String KEY = "ClassScanFilter";
    private Map<Integer, HashSet<Integer>> mMap;

    private boolean validityCheck(int OplusGLSurfaceView_13, int i2, int i3) {
        return i3 < OplusGLSurfaceView_13 || i3 > i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    private ClassScanFilter() {
        this.mMap = new HashMap();
    }

    public static ClassScanFilter create() {
        return new ClassScanFilter();
    }

    public Map<Integer, HashSet<Integer>> getMap() {
        return this.mMap;
    }

    public ClassScanFilter put(int OplusGLSurfaceView_13, int i2) {
        if (validityCheck(1, 8, OplusGLSurfaceView_13)) {
            throw new IllegalArgumentException("unknown major: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
        switch (OplusGLSurfaceView_13) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (validityCheck(0, 0, i2)) {
                    throw new IllegalArgumentException("unknown major: " + OplusGLSurfaceView_13 + ", minor: " + i2);
                }
                getMajorSet(OplusGLSurfaceView_13).add(Integer.valueOf(i2));
                return this;
            case 2:
            default:
                throw new IllegalArgumentException("unknown major in switch: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    private HashSet<Integer> getMajorSet(int OplusGLSurfaceView_13) {
        HashSet<Integer> hashSet = this.mMap.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (hashSet != null) {
            return hashSet;
        }
        HashSet<Integer> hashSet2 = new HashSet<>();
        this.mMap.put(Integer.valueOf(OplusGLSurfaceView_13), hashSet2);
        return hashSet2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClassScanFilter {\OplusGLSurfaceView_11");
        for (Map.Entry<Integer, HashSet<Integer>> entry : this.mMap.entrySet()) {
            sb.append("major " + entry.getKey() + ", minor [");
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(" ".concat(String.valueOf(it.next())));
            }
            sb.append(" ]\OplusGLSurfaceView_11");
        }
        sb.append("\OplusGLSurfaceView_11}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mMap.size());
        for (Map.Entry<Integer, HashSet<Integer>> entry : this.mMap.entrySet()) {
            parcel.writeValue(entry.getKey());
            parcel.writeInt(entry.getValue().size());
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                parcel.writeValue(it.next());
            }
        }
    }

    protected ClassScanFilter(Parcel parcel) {
        this.mMap = new HashMap();
        int OplusGLSurfaceView_13 = parcel.readInt();
        this.mMap = new HashMap(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 > 0) {
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                Integer num = (Integer) parcel.readValue(Integer.class.getClassLoader());
                if (num == null) {
                    return;
                }
                HashSet<Integer> hashSet = new HashSet<>();
                this.mMap.put(num, hashSet);
                int i3 = parcel.readInt();
                if (i3 > 0) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        hashSet.add((Integer) parcel.readValue(Integer.class.getClassLoader()));
                    }
                }
            }
        }
    }
}
