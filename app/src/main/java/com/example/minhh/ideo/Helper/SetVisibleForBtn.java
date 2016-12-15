package com.example.minhh.ideo.Helper;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by minhh on 12/15/2016.
 */

public class SetVisibleForBtn {
    public SetVisibleForBtn() {
//        SetVisibleBtn();
    }

    public static void visibleAllBtn(Button btn1, Button btn2, Button btn3, Button btn4, LinearLayout controllayout) {
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        controllayout.setVisibility(View.VISIBLE);
    }

    public static void invisibleAllBtn(Button btn1, Button btn2, Button btn3, Button btn4, LinearLayout controllayout) {
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");

        btn1.setBackgroundColor(Color.parseColor("#cccccc"));
        btn2.setBackgroundColor(Color.parseColor("#cccccc"));
        btn3.setBackgroundColor(Color.parseColor("#cccccc"));
        btn4.setBackgroundColor(Color.parseColor("#cccccc"));

        controllayout.setVisibility(View.INVISIBLE);
    }
}
