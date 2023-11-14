package tn.esprit.healthcareapp.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import tn.esprit.healthcareapp.entities.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Insert
    void insertRdv(Article article);

    @Query("SELECT * FROM article")
    List<Article> getAllRdvs();

    @Query("DELETE FROM article WHERE id = :rdvId")
    void deleteRdvById(int rdvId);

    @Query("UPDATE article SET title = :newTitre, start_rdv = :newStartRdv, end_rdv = :newEndRdv WHERE id = :rdvId")
    void updateRdv(int rdvId, String newTitre, String newStartRdv, String newEndRdv);


}