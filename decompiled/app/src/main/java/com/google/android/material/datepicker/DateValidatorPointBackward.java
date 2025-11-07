package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public class DateValidatorPointBackward implements com.google.android.material.datepicker.CalendarConstraints.DateValidator {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointBackward> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointBackward>() { // from class: com.google.android.material.datepicker.DateValidatorPointBackward.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.DateValidatorPointBackward createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.material.datepicker.DateValidatorPointBackward(parcel.readLong());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.DateValidatorPointBackward[] newArray(int i_renamed) {
            return new com.google.android.material.datepicker.DateValidatorPointBackward[i_renamed];
        }
    };
    private final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DateValidatorPointBackward(long j_renamed) {
        this.point = j_renamed;
    }

    public static com.google.android.material.datepicker.DateValidatorPointBackward before(long j_renamed) {
        return new com.google.android.material.datepicker.DateValidatorPointBackward(j_renamed);
    }

    public static com.google.android.material.datepicker.DateValidatorPointBackward now() {
        return before(com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j_renamed) {
        return j_renamed <= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.point);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.android.material.datepicker.DateValidatorPointBackward) && this.point == ((com.google.android.material.datepicker.DateValidatorPointBackward) obj).point;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Long.valueOf(this.point)});
    }
}
