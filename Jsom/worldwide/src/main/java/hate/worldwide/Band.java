package hate.worldwide;

import lombok.Getter;

public class Band {
    @Getter
    private String Bandname;
    @Getter
    private String hometown;
    @Getter
    private String genre;
    @Getter
    private String last_ablbum;
    @Getter
    private String Singer;

    public Band(String Bandname, String hometown, String genre, String last_ablbum, String Singer) {
        this.Bandname = Bandname;
        this.hometown = hometown;
        this.genre = genre;
        this.last_ablbum = last_ablbum;
        this.Singer = Singer;
    }
    public String getBandname() {
        return Bandname;
    }

    public String gethometown() {
        return hometown;
    }

    public String getgenre() {
        return genre;
    }

    public String getlast_ablbum() {
        return last_ablbum;
    }

    public String getSinger() {
        return Singer;
    }



}
