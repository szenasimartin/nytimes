
package wup.android.exercise.nytimes.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MostViewedArticleResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<Article> results = null;
    public final static Parcelable.Creator<MostViewedArticleResponse> CREATOR = new Creator<MostViewedArticleResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MostViewedArticleResponse createFromParcel(Parcel in) {
            MostViewedArticleResponse instance = new MostViewedArticleResponse();
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.copyright = ((String) in.readValue((String.class.getClassLoader())));
            instance.numResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.results, (Article.class.getClassLoader()));
            return instance;
        }

        public MostViewedArticleResponse[] newArray(int size) {
            return (new MostViewedArticleResponse[size]);
        }

    }
    ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(copyright);
        dest.writeValue(numResults);
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
