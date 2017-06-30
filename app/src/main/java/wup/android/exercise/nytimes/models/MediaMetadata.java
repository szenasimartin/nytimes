
package wup.android.exercise.nytimes.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaMetadata implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;
    public final static Parcelable.Creator<MediaMetadata> CREATOR = new Creator<MediaMetadata>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MediaMetadata createFromParcel(Parcel in) {
            MediaMetadata instance = new MediaMetadata();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.format = ((String) in.readValue((String.class.getClassLoader())));
            instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public MediaMetadata[] newArray(int size) {
            return (new MediaMetadata[size]);
        }

    }
    ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(format);
        dest.writeValue(height);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
