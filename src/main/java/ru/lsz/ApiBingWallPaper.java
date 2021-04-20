package ru.lsz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "start_date",
        "end_date",
        "url",
        "copyright",
        "copyright_link"
})
public class ApiBingWallPaper {
    @JsonProperty("start_date")
    private String start_date;
    @JsonProperty("end_date")
    private String end_date;
    @JsonProperty("url")
    private String url;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("copyright_link")
    private String copyright_link;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyright_link() {
        return copyright_link;
    }

    public void setCopyright_link(String copyright_link) {
        this.copyright_link = copyright_link;
    }
}
