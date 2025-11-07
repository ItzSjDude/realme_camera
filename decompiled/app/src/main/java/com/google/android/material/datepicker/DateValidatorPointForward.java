package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public class DateValidatorPointForward implements com.google.android.material.datepicker.CalendarConstraints.DateValidator {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointForward> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointForward>() { // from class: com.google.android.material.datepicker.DateValidatorPointForward.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.DateValidatorPointForward createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.material.datepicker.DateValidatorPointForward(parcel.readLong());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.DateValidatorPointForward[] newArray(int i_renamed) {
            return new com.google.android.material.datepicker.DateValidatorPointForward[i_renamed];
        }
    };
    private final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DateValidatorPointForward(long j_renamed) {
        this.point = j_renamed;
    }

    public static com.google.android.material.datepicker.DateValidatorPointForward from(long j_renamed) {
        return new com.google.android.material.datepicker.DateValidatorPointForward(j_renamed);
    }

    public static com.google.android.material.datepicker.DateValidatorPointForward now() {
        return from(com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j_renamed) {
        return j_renamed >= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.point);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.android.material.datepicker.DateValidatorPointForward) && this.point == ((com.google.android.material.datepicker.DateValidatorPointForward) obj).point;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Long.valueOf(this.point)});
    }
}
