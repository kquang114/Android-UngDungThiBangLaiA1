package com.example.admin.onthia11.a1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.onthia11.MainActivity;
import com.example.admin.onthia11.R;
import com.example.admin.onthia11.VideoAdapter;
import com.example.admin.onthia11.YoutubeVideo;

import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class HuongDanChayXeFragment extends Fragment {



    RecyclerView recyclerView;
    Vector<YoutubeVideo> youtubeVideo = new Vector<>();
//    VideoView videoView;

    public HuongDanChayXeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Hướng Dẫn Chạy Vòng Số 8");
        View view = inflater.inflate(R.layout.fragment_huong_dan_chay_xe, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        youtubeVideo.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yNDJ_Sjxn2E\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideo.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XIRi2gdtZO0\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideo.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YRfN6t4uURk\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideo.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8UDiMUJXztI\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideo);
        recyclerView.setAdapter(videoAdapter);

        return view;
    }
}
