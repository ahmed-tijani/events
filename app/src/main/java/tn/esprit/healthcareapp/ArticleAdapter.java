package tn.esprit.healthcareapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.healthcareapp.entities.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.RdvViewHolder> {

    private List<Article> articleList;
    private OnModifyDeleteClickListener listener;

    public interface OnModifyDeleteClickListener {
        void onModifyClick(int position);
    }

    public ArticleAdapter(List<Article> articleList, OnModifyDeleteClickListener listener) {
        this.articleList = articleList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RdvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rdv, parent, false);
        return new RdvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RdvViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.titleTextView.setText("Titre: " + article.getTitle());
        holder.datedebutTextView.setText("Datedebut: " + String.valueOf(article.getStartRdv()));
        holder.datefinTextView.setText("Datefin: " + String.valueOf(article.getEndRdv()));

        // Set click listeners for modify and delete buttons
        holder.btnModify.setOnClickListener(v -> listener.onModifyClick(position));
        // Add delete button logic if needed
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    static class RdvViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView datedebutTextView;
        TextView datefinTextView;
        Button btnModify;
        Button btnDelete;

        RdvViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            datedebutTextView = itemView.findViewById(R.id.datedebutTextView);
            datefinTextView = itemView.findViewById(R.id.datefinTextView);
            btnModify = itemView.findViewById(R.id.btnModify);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    public Article getRdvAtPosition(int position) {
        return articleList.get(position);
    }

    public void updateRdvList(List<Article> rdvs) {
        articleList.clear();
        articleList.addAll(rdvs);
        notifyDataSetChanged();
    }
}
