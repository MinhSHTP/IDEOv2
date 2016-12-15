package com.example.minhh.ideo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.minhh.ideo.Helper.StringUtil;

import java.io.File;
import java.io.InputStream;

public class ShowThisWord extends AppCompatActivity {
    ImageView imgViewHaNoi, imgViewHcm, imgViewDescription, videoTab, imageTab;
    VideoView _videoView;
    String Path = "";
    Activity _activity;
    LinearLayout _showthisswordLayout;
    RelativeLayout _contentlayout; /*_videolayout*/;

    boolean _FlagIsHaNoi = false;//default is Hcm - FlagIsHanoi will false.
    boolean _FlagVideoTabIsEnable = false;//is disable
    boolean _FlagImageTabIsEnable = false;//is disable

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_this_word);
        _activity = this;
        this.setTitle(Dictionary._wordItemSelected);
//        showToast("Name: "+Home._wordItemSelected+" - ID: "+Home._IDItemSelected);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _contentlayout = (RelativeLayout) findViewById(R.id.content_layout);
//        _videolayout = (RelativeLayout) findViewById(R.id.video_layout);

        _videoView = (VideoView)findViewById(R.id.videoview);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(_videoView);
        _videoView.setMediaController(mediaController);

        videoTab = (ImageView) findViewById(R.id.video_tab);
        imageTab = (ImageView) findViewById(R.id.image_tab);
        imgViewDescription = (ImageView) findViewById(R.id.image_description);


        videoTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_FlagVideoTabIsEnable) {
                    _FlagVideoTabIsEnable = false;
                    _videoView.setVisibility(View.INVISIBLE);
//                    changePositionOf(videoTab.getId());
                    videoTab.setImageResource(R.drawable.video_disable);
                    showToast("Video bị tạm dừng");
                    _videoView.stopPlayback();
                } else {
                    _FlagVideoTabIsEnable = true;
//                    _relativelayout.addView(_videoView);
                    _videoView.setVisibility(View.VISIBLE);
//                    _contentlayout.
//                    changePositionOf(_videolayout.getId());
                    videoTab.setImageResource(R.drawable.video_enable);
                    if (Path != "")
                    {
                        loadVideoWord(Path);
                    }
                }
            }
        });


        imageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_FlagImageTabIsEnable) {
                    _FlagImageTabIsEnable = false;
//                    _videolayout.setVisibility(View.INVISIBLE);
                    imgViewDescription.setVisibility(View.INVISIBLE);
                    changePositionOf(imageTab.getId());
                    imageTab.setImageResource(R.drawable.way_disable);
                } else {
                    _FlagImageTabIsEnable = true;
//                    _relativelayout.addView(_videoView);
//                    _videolayout.setVisibility(View.VISIBLE);
//                    _contentlayout.
                    imgViewDescription.setVisibility(View.VISIBLE);
                    changePositionOf(imgViewDescription.getId());
                    imageTab.setImageResource(R.drawable.way_enable);
                }
            }
        });


        imgViewHaNoi = (ImageView) findViewById(R.id.HaNoi);
        imgViewHaNoi.setLayoutParams(GetParamsLinear(20, 20, 0, 0));
        imgViewHcm = (ImageView) findViewById(R.id.Hcm);
        imgViewHcm.setLayoutParams(GetParamsLinear(20, 20, 0, 0));

        imgViewHaNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!_FlagIsHaNoi)//Hanoi is OFF
                {
                    _FlagIsHaNoi = true;
                    imgViewHcm.setImageResource(R.drawable.off_hcm);
                    imgViewHaNoi.setImageResource(R.drawable.on_ha_noi);
                    if (_FlagVideoTabIsEnable) {
                        videoTab.performClick();
                    }
                    if (_FlagImageTabIsEnable) {
                        imageTab.performClick();
                    }
                    imgViewDescription.setImageDrawable(loadDrawableFromAssets(_activity, "hn/" + Dictionary._IDItemSelected + ".png"));
//                    imgViewHaNoi.setSelected(true);
//                    imgViewHcm.setSelected(false);
                    Path = "android.resource://" + getPackageName() + "/raw/" + "hn_" + Dictionary._IDItemSelected;
                }
//                if(imgViewHaNoi.isSelected())
//                {
//                    showToast("@@");
//                }
            }
        });


        imgViewHcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_FlagIsHaNoi)//Hanoi is ON
                {
                    _FlagIsHaNoi = false;
                    imgViewHcm.setImageResource(R.drawable.on_hcm);
                    imgViewHaNoi.setImageResource(R.drawable.off_ha_noi);
                    if (_FlagVideoTabIsEnable) {
                        videoTab.performClick();
                    }
                    if (_FlagImageTabIsEnable) {
                        imageTab.performClick();
                    }
                    imgViewDescription.setImageDrawable(loadDrawableFromAssets(_activity, "hcm/" + Dictionary._IDItemSelected + ".png"));
//                    imgViewHcm.setSelected(true);
//                    imgViewHaNoi.setSelected(false);
                    Path = "android.resource://" + getPackageName() + "/raw/" + "hcm_" + Dictionary._IDItemSelected;
//                    loadVideoWord(Path);
                }
//                if(imgViewHcm.isSelected())
//                {
//                    showToast("@@");
//                }
            }
        });


        _showthisswordLayout = (LinearLayout) findViewById(R.id.showthisword_layout);
//        mediaController.setAnchorView(_showthisswordLayout);
//        TextView tv = new TextView(this);
//        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        tv.setText("SHTP-TRAINING");
//        _showthisswordLayout.addView(tv);
        imgViewDescription.setImageDrawable(loadDrawableFromAssets(_activity, "hcm/" + Dictionary._IDItemSelected + ".png"));
        Path = "android.resource://" + getPackageName() + "/raw/" + "hcm_" + Dictionary._IDItemSelected;
        _videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                showToast("Video không tồn tại");
                return true;
            }
        });
        _videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                _videoView.start();
            }
        });
//        loadVideoWord(Path);
    }



    public void changePositionOf(int idView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.BELOW, idView);
        videoTab.setLayoutParams(params);
    }

    public void loadVideoWord(String fullPath) {
        Uri uri = Uri.parse(fullPath);
        _videoView.setVideoURI(uri);
        _videoView.start();
    }

//    public void resetStringPath(String path)
//    {
//        Path = "android.resource://" + getPackageName() + "/raw/";
//    }

    public LinearLayout.LayoutParams GetParamsLinear(int left, int top, int right, int bottom) {
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int width = ((display.widthPixels * 40) / 100); // ((display.getWidth()*20)/100)
        int height = ((display.heightPixels * 10) / 100);// ((display.getHeight()*30)/100)
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
        parms.setMargins(20, 20, 0, 0);
        return parms;
    }

    public Drawable loadDrawableFromAssets(Context context, String path) {
        InputStream stream = null;
        try {
            stream = context.getAssets().open(path);
            return Drawable.createFromStream(stream, null);
        } catch (Exception ignored) {
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }
}
