package com.project.crop_prediction.ui.recents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.crop_prediction.R;
import com.project.crop_prediction.model.Recent;

import java.util.ArrayList;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    private ArrayList<Recent> recents;

    public static class RecentsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView title, subtitle;

        public RecentsViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.recent_image);
            title = view.findViewById(R.id.recent_title);
            subtitle = view.findViewById(R.id.recent_subtitle);
        }
    }

    public RecentsAdapter(ArrayList<Recent> recents) {
        this.recents = recents;
    }

    public RecentsAdapter() {
        this.recents = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentsViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.layout_recent_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        Recent recent = recents.get(position);
        holder.title.setText(recent.prediction.getPredictedName());
        holder.subtitle.setText("Some Details");
    }

    @Override
    public int getItemCount() {
        return recents.size();
    }

    public void reloadData() {
        this.notifyDataSetChanged();
    }

}
