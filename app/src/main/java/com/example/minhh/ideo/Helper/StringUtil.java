package com.example.minhh.ideo.Helper;

/**
 * Created by minhh on 11/22/2016.
 */

public class StringUtil
{
    private static final String[] VietnameseSigns = new String[]{
    "aAeEoOuUiIdDyY",

            "áàạảãâấầậẩẫăắằặẳẵ",

            "ÁÀẠẢÃÂẤẦẬẨẪĂẮẰẶẲẴ",

            "éèẹẻẽêếềệểễ",

            "ÉÈẸẺẼÊẾỀỆỂỄ",

            "óòọỏõôốồộổỗơớờợởỡ",

            "ÓÒỌỎÕÔỐỒỘỔỖƠỚỜỢỞỠ",

            "úùụủũưứừựửữ",

            "ÚÙỤỦŨƯỨỪỰỬỮ",

            "íìịỉĩ",

            "ÍÌỊỈĨ",

            "đ",

            "Đ",

            "ýỳỵỷỹ",

            "ÝỲỴỶỸ"

};

    public static String RemoveVietnameseString(String str)

    {

        for (int i = 1; i < VietnameseSigns.length; i++)

        {

            for (int j = 0; j < VietnameseSigns[i].length(); j++)

                str = str.replace(VietnameseSigns[i].charAt(j), VietnameseSigns[0].charAt(i-1));

        }

        return str;

    }
}
