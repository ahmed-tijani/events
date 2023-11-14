package tn.esprit.healthcareapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.healthcareapp.database.AppDatabase;
import tn.esprit.healthcareapp.entities.Article;


public class RetrieveArticActivity extends AppCompatActivity implements ArticleAdapter.OnModifyDeleteClickListener {
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdvshow);

        recyclerView = findViewById(R.id.recyclerView);
        articleAdapter = new ArticleAdapter(getAllRdvsFromDatabase(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(articleAdapter);
    }

    private List<Article> getAllRdvsFromDatabase() {
        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        return appDatabase.articleDao().getAllRdvs();
    }



    ///////////////////////modify

    @Override
    public void onModifyClick(int position) {
        showModifyPopup(position);
    }

    private void showModifyPopup(int position) {

        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup_modify_rdv, null);

        EditText editTextTitle = view.findViewById(R.id.editTextTitle);
        EditText editTextDatedebut = view.findViewById(R.id.editTextDatedebut);
        EditText editTextDatefin = view.findViewById(R.id.editTextDatefin);

        Article selectedRdv = articleAdapter.getRdvAtPosition(position);
        editTextTitle.setText(selectedRdv.getTitle());
        editTextDatedebut.setText(String.valueOf(selectedRdv.getStartRdv()));
        editTextDatefin.setText(String.valueOf(selectedRdv.getEndRdv()));

        builder.setView(view);
        AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonModify).setOnClickListener(v -> {
            selectedRdv.setTitle(editTextTitle.getText().toString());
            selectedRdv.setStartRdv(editTextDatedebut.getText().toString());
            selectedRdv.setEndRdv((editTextDatefin.getText().toString()));

            appDatabase.articleDao().updateRdv(selectedRdv.getId(),selectedRdv.getTitle(),selectedRdv.getStartRdv(),selectedRdv.getEndRdv());

            articleAdapter.updateRdvList(getAllRdvsFromDatabase());
            articleAdapter.notifyDataSetChanged();

            alertDialog.dismiss();
        });

        // Handle canceling the modification
        view.findViewById(R.id.buttonCancel).setOnClickListener(v -> alertDialog.dismiss());

        alertDialog.show();
    }



    //////////////////////////////delete
    public void onDeleteButtonClick(View view) {
        int position = recyclerView.getChildLayoutPosition((View) view.getParent().getParent());
        Article selectedRdv = articleAdapter.getRdvAtPosition(position);

        deleteRdvFromDatabase(selectedRdv);

        articleAdapter.updateRdvList(getAllRdvsFromDatabase());
        articleAdapter.notifyDataSetChanged();
    }


    private void deleteRdvFromDatabase(Article article) {
        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        appDatabase.articleDao().deleteRdvById(article.getId());
    }
}
