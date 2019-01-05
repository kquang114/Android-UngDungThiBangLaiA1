package com.example.admin.onthia11;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.YTBViewHolder> {

    List<YoutubeVideo> youtubeVideoList;

    public VideoAdapter(){

    }
    public VideoAdapter(List<YoutubeVideo> youtubeVideoList){
        this.youtubeVideoList = youtubeVideoList;
    }

    @NonNull
    @Override
    public VideoAdapter.YTBViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.youtube_view, viewGroup, false);
        return new YTBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.YTBViewHolder ytbViewHolder, int i) {
        ytbViewHolder.ytbWeb.loadData(youtubeVideoList.get(i).getVideoUrl(), "text/html", "utf-8");
    }

    public int getItemCount() {
        return youtubeVideoList.size();
    }
    public class YTBViewHolder extends RecyclerView.ViewHolder{
        WebView  ytbWeb;

        public YTBViewHolder(View itemView){
            super(itemView);
            ytbWeb = itemView.findViewById(R.id.myYoutube);
            ytbWeb.getSettings().setJavaScriptEnabled(true);
            ytbWeb.setWebChromeClient(new WebChromeClient());
        }
    }
}
