package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int OplusGLSurfaceView_13) {
            return new RatingCompat[OplusGLSurfaceView_13];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        this.mRatingStyle = OplusGLSurfaceView_13;
        this.mRatingValue = COUIBaseListPopupWindow_12;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        float COUIBaseListPopupWindow_12 = this.mRatingValue;
        sb.append(COUIBaseListPopupWindow_12 < 0.0f ? "unrated" : String.valueOf(COUIBaseListPopupWindow_12));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }

    public static RatingCompat newUnratedRating(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(OplusGLSurfaceView_13, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newStarRating(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float f2;
        if (OplusGLSurfaceView_13 == 3) {
            f2 = 3.0f;
        } else if (OplusGLSurfaceView_13 == 4) {
            f2 = 4.0f;
        } else {
            if (OplusGLSurfaceView_13 != 5) {
                Log.COUIBaseListPopupWindow_8(TAG, "Invalid rating style (" + OplusGLSurfaceView_13 + ") for PlatformImplementations.kt_3 star rating");
                return null;
            }
            f2 = 5.0f;
        }
        if (COUIBaseListPopupWindow_12 < 0.0f || COUIBaseListPopupWindow_12 > f2) {
            Log.COUIBaseListPopupWindow_8(TAG, "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    public static RatingCompat newPercentageRating(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 < 0.0f || COUIBaseListPopupWindow_12 > 100.0f) {
            Log.COUIBaseListPopupWindow_8(TAG, "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, COUIBaseListPopupWindow_12);
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public float getStarRating() {
        int OplusGLSurfaceView_13 = this.mRatingStyle;
        return ((OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 5) && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public float getPercentRating() {
        return (this.mRatingStyle == 6 && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompatNewUnratedRating = null;
        if (obj != null && Build.VERSION.SDK_INT >= 19) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompatNewUnratedRating = newHeartRating(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompatNewUnratedRating = newThumbRating(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatNewUnratedRating = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompatNewUnratedRating = newPercentageRating(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatNewUnratedRating = newUnratedRating(ratingStyle);
            }
            ratingCompatNewUnratedRating.mRatingObj = obj;
        }
        return ratingCompatNewUnratedRating;
    }

    public Object getRating() {
        if (this.mRatingObj == null && Build.VERSION.SDK_INT >= 19) {
            if (isRated()) {
                int OplusGLSurfaceView_13 = this.mRatingStyle;
                switch (OplusGLSurfaceView_13) {
                    case 1:
                        this.mRatingObj = Rating.newHeartRating(hasHeart());
                        break;
                    case 2:
                        this.mRatingObj = Rating.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.mRatingObj = Rating.newStarRating(OplusGLSurfaceView_13, getStarRating());
                        break;
                    case 6:
                        this.mRatingObj = Rating.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
            }
        }
        return this.mRatingObj;
    }
}
