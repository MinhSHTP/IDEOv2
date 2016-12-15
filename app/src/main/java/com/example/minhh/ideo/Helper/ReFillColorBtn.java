package com.example.minhh.ideo.Helper;

import android.graphics.Color;
import android.widget.Button;

/**
 * Created by minhh on 12/15/2016.
 */

public class ReFillColorBtn {
    public ReFillColorBtn()
    {
//        ReFillBtn();
    }

    public static void ReFillBtn(Button btnCheck, String resultWord)
    {
        if(btnCheck.getText().toString().equals(resultWord))
        {
            btnCheck.setBackgroundColor(Color.GREEN);
        }
        else
        {
            btnCheck.setBackgroundColor(Color.RED);
        }
    }
}
