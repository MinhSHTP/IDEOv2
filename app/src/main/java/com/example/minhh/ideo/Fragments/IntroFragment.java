package com.example.minhh.ideo.Fragments;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.minhh.ideo.Home;
import com.example.minhh.ideo.R;

/**
 * Created by minhh on 12/10/2016.
 */

public class IntroFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_introduce, container, false);
        WebView web = (WebView)view.findViewById(R.id.webView);
        web.setInitialScale(1);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.loadUrl("file:///android_asset/introduce/introduce");
        return view;
    }
}
