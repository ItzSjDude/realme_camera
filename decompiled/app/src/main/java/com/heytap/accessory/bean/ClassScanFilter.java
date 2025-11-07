package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class ClassScanFilter implements com.heytap.accessory.discovery.IScanFilter {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.ClassScanFilter> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.ClassScanFilter>() { // from class: com.heytap.accessory.bean.ClassScanFilter.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ClassScanFilter createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.ClassScanFilter(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ClassScanFilter[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.ClassScanFilter[i_renamed];
        }
    };
    public static final java.lang.String KEY = "ClassScanFilter";
    private java.util.Map<java.lang.Integer, java.util.HashSet<java.lang.Integer>> mMap;

    private boolean validityCheck(int i_renamed, int i2, int i3) {
        return i3 < i_renamed || i3 > i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public java.lang.String getKey() {
        return KEY;
    }

    private ClassScanFilter() {
        this.mMap = new java.util.HashMap();
    }

    public static com.heytap.accessory.bean.ClassScanFilter create() {
        return new com.heytap.accessory.bean.ClassScanFilter();
    }

    public java.util.Map<java.lang.Integer, java.util.HashSet<java.lang.Integer>> getMap() {
        return this.mMap;
    }

    public com.heytap.accessory.bean.ClassScanFilter put(int i_renamed, int i2) {
        if (validityCheck(1, 8, i_renamed)) {
            throw new java.lang.IllegalArgumentException("unknown major: ".concat(java.lang.String.valueOf(i_renamed)));
        }
        switch (i_renamed) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (validityCheck(0, 0, i2)) {
                    throw new java.lang.IllegalArgumentException("unknown major: " + i_renamed + ", minor: " + i2);
                }
                getMajorSet(i_renamed).add(java.lang.Integer.valueOf(i2));
                return this;
            case 2:
            default:
                throw new java.lang.IllegalArgumentException("unknown major in_renamed switch: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    private java.util.HashSet<java.lang.Integer> getMajorSet(int i_renamed) {
        java.util.HashSet<java.lang.Integer> hashSet = this.mMap.get(java.lang.Integer.valueOf(i_renamed));
        if (hashSet != null) {
            return hashSet;
        }
        java.util.HashSet<java.lang.Integer> hashSet2 = new java.util.HashSet<>();
        this.mMap.put(java.lang.Integer.valueOf(i_renamed), hashSet2);
        return hashSet2;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ClassScanFilter {\n_renamed");
        for (java.util.Map.Entry<java.lang.Integer, java.util.HashSet<java.lang.Integer>> entry : this.mMap.entrySet()) {
            sb.append("major " + entry.getKey() + ", minor [");
            java.util.Iterator<java.lang.Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(" ".concat(java.lang.String.valueOf(it.next())));
            }
            sb.append(" ]\n_renamed");
        }
        sb.append("\n_renamed}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mMap.size());
        for (java.util.Map.Entry<java.lang.Integer, java.util.HashSet<java.lang.Integer>> entry : this.mMap.entrySet()) {
            parcel.writeValue(entry.getKey());
            parcel.writeInt(entry.getValue().size());
            java.util.Iterator<java.lang.Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                parcel.writeValue(it.next());
            }
        }
    }

    protected ClassScanFilter(android.os.Parcel parcel) {
        this.mMap = new java.util.HashMap();
        int i_renamed = parcel.readInt();
        this.mMap = new java.util.HashMap(i_renamed);
        if (i_renamed > 0) {
            for (int i2 = 0; i2 < i_renamed; i2++) {
                java.lang.Integer num = (java.lang.Integer) parcel.readValue(java.lang.Integer.class.getClassLoader());
                if (num == null) {
                    return;
                }
                java.util.HashSet<java.lang.Integer> hashSet = new java.util.HashSet<>();
                this.mMap.put(num, hashSet);
                int i3 = parcel.readInt();
                if (i3 > 0) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        hashSet.add((java.lang.Integer) parcel.readValue(java.lang.Integer.class.getClassLoader()));
                    }
                }
            }
        }
    }
}
