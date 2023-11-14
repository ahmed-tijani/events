package tn.esprit.healthcareapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "article")
public class Article {


    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "start_rdv")
    private String startRdv;
    @ColumnInfo(name = "end_rdv")
    private String endRdv;


    public Article(String title, String startRdv, String endRdv) {
        this.title = title;
        this.startRdv = startRdv;
        this.endRdv = endRdv;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartRdv() {
        return startRdv;
    }

    public void setStartRdv(String startRdv) {
        this.startRdv = startRdv;
    }

    public String getEndRdv() {
        return endRdv;
    }

    public void setEndRdv(String endRdv) {
        this.endRdv = endRdv;
    }
}
