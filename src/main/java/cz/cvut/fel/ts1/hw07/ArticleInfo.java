package cz.cvut.fel.ts1.hw07;

public class ArticleInfo {

    private String title;
    private String doi;
    private String datePublished;

    public ArticleInfo( String title, String doi, String datePublished ) {
        this.title = title;
        this.doi = doi;
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public String getDoi() {
        return doi;
    }

    public String getDatePublished() {
        return datePublished;
    }
}
