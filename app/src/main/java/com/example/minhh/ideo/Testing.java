package com.example.minhh.ideo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.minhh.ideo.Helper.InitializeListClip;

import java.util.Random;

public class Testing extends AppCompatActivity {

    Button _btnA, _btnB, _btnC, _btnD, _btnOtherWord, _btnResult;
    VideoView _randomVideo;
    String _fullPathVideo;

    String _clipRandomSelected = "";//word
    String _idClipRandomSelected = "";//id of word

    int[] _region = {0, 1};// 0 is Ha Noi, 1 is TPHCM.
    int[] _btnAnswer = {0, 1, 2, 3};

    String _regionClip = "";

    LinearLayout _controlLayout;


    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        _controlLayout = (LinearLayout) findViewById(R.id.control_layout);
        _btnOtherWord=(Button)findViewById(R.id.other_word_btn);
        _btnResult=(Button)findViewById(R.id.result_btn);

        //region onclick event of button Other word, result
        _btnOtherWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invisibleAllBtn();
                generateClip();

            }
        });

        _btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //endregion

        _btnA = (Button) findViewById(R.id.buttonA);
        _btnB = (Button) findViewById(R.id.buttonB);
        _btnC = (Button) findViewById(R.id.buttonC);
        _btnD = (Button) findViewById(R.id.buttonD);

        //region event onClick of button A, B, C, D
        _btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((_btnA.getText().toString().equals(_clipRandomSelected + " - TPHCM"))||(_btnA.getText().toString().equals(_clipRandomSelected + " - Hà Nội")))
                {
                    _btnA.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    _btnA.setBackgroundColor(Color.RED);
                }
            }
        });

        _btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((_btnB.getText().toString().equals(_clipRandomSelected + " - TPHCM"))||(_btnB.getText().toString().equals(_clipRandomSelected + " - Hà Nội")))
                {
                    _btnB.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    _btnB.setBackgroundColor(Color.RED);
                }
            }
        });

        _btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((_btnC.getText().toString().equals(_clipRandomSelected + " - TPHCM"))||(_btnC.getText().toString().equals(_clipRandomSelected + " - Hà Nội")))
                {
                    _btnC.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    _btnC.setBackgroundColor(Color.RED);
                }
            }
        });

        _btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((_btnD.getText().toString().equals(_clipRandomSelected + " - TPHCM"))||(_btnD.getText().toString().equals(_clipRandomSelected + " - Hà Nội")))
                {
                    _btnD.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    _btnD.setBackgroundColor(Color.RED);
                }
            }
        });
        //endregion

        _randomVideo = (VideoView) findViewById(R.id.testingVideoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(_randomVideo);
        _randomVideo.setMediaController(mediaController);
        _randomVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                generateClip();
//                generateResultButton();
                return true;
            }
        });

        _randomVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                generateResultButton();
                if ((_btnA.getVisibility() == View.INVISIBLE) && (_btnB.getVisibility() == View.INVISIBLE) && (_btnC.getVisibility() == View.INVISIBLE) && (_btnD.getVisibility() == View.INVISIBLE)) {
                   visibleAllBtn();
                }
            }
        });

        generateClip();
//        generateResultButton();

    }

    public void visibleAllBtn()
    {
        _btnA.setVisibility(View.VISIBLE);
        _btnB.setVisibility(View.VISIBLE);
        _btnC.setVisibility(View.VISIBLE);
        _btnD.setVisibility(View.VISIBLE);
        _controlLayout.setVisibility(View.VISIBLE);
    }

    public void invisibleAllBtn()
    {
        _btnA.setVisibility(View.INVISIBLE);
        _btnB.setVisibility(View.INVISIBLE);
        _btnC.setVisibility(View.INVISIBLE);
        _btnD.setVisibility(View.INVISIBLE);
        _controlLayout.setVisibility(View.INVISIBLE);
    }

    public void generateClip() {
        Random ran = new Random();
        if (ran.nextInt(_region.length) == 1) {
            _regionClip = "hcm_";
        } else if (ran.nextInt(_region.length) == 0) {
            _regionClip = "hn_";
        }
        _clipRandomSelected = InitializeListClip.resultList.get(ran.nextInt(InitializeListClip.resultList.size()));
        for (int f = 0; f < InitializeListClip.resultList.size(); f++) {
            if (_clipRandomSelected == InitializeListClip.resultList.get(f)) {
                _idClipRandomSelected = String.valueOf(f);
                showToast("" + InitializeListClip.resultList.get(f) + " - id:" + f + " - region: " + _regionClip);
                _fullPathVideo = "android.resource://" + getPackageName() + "/raw/" + _regionClip + f;
                break;
            }
        }
        loadVideoRandom(_fullPathVideo);
    }

    public void loadVideoRandom(String fullPath) {
        Uri uri = Uri.parse(fullPath);
        _randomVideo.setVideoURI(uri);
        _randomVideo.start();
    }

    public void getResultIntoBtn(Button btnResult) {
        if (_regionClip == "hn_") {
            btnResult.setText(_clipRandomSelected + " - Hà Nội");
//            showToast(btnResult.getText().toString());
        } else if (_regionClip == "hcm_") {
            btnResult.setText(_clipRandomSelected + " - TPHCM");
//            showToast(btnResult.getText().toString());
        }
    }

    public void getAnswerRandomIntoBtn(Button btnAnswer) {
        Random ran = new Random();
        String regionClip = "";
        String clipName = "";
        switch (ran.nextInt(_region.length)) {
            case 0:
                regionClip = "Hà Nội";
                clipName = InitializeListClip.resultList.get(ran.nextInt(InitializeListClip.resultList.size()));
                break;
            case 1:
                regionClip = "TPHCM";
                clipName = InitializeListClip.resultList.get(ran.nextInt(InitializeListClip.resultList.size()));
                break;
        }
        btnAnswer.setText(clipName + " - " + regionClip);
    }

    public void generateRestButton(Button btn1, Button btn2, Button btn3) {
        if (btn1.getText().toString().equals("")) {
            getAnswerRandomIntoBtn(btn1);
        }
        if (btn2.getText().toString().equals("")) {
            getAnswerRandomIntoBtn(btn2);
        }
        if (btn3.getText().toString().equals("")) {
            getAnswerRandomIntoBtn(btn3);
        }
    }

    public void generateResultButton() {
        Random ran = new Random();
        switch (ran.nextInt(_btnAnswer.length)) {
            case 0:
                if (_btnA.getText().toString().equals("")) {
                    getResultIntoBtn(_btnA);
                }
                generateRestButton(_btnB, _btnC, _btnD);
//
                break;
            case 1:
                if (_btnB.getText().toString().equals("")) {
                    getResultIntoBtn(_btnB);
                }
                generateRestButton(_btnA, _btnC, _btnD);
//
                break;
            case 2:
                if (_btnC.getText().toString().equals("")) {
                    getResultIntoBtn(_btnC);
                }
                generateRestButton(_btnA, _btnB, _btnD);
//
                break;
            case 3:
                if (_btnD.getText().equals("")) {
                    getResultIntoBtn(_btnD);
                }
                generateRestButton(_btnA, _btnB, _btnC);
//
                break;
        }
    }
}
