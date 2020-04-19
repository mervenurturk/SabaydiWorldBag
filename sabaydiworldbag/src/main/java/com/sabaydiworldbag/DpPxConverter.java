package com.sabaydiworldbag;

import android.content.Context;

public class DpPxConverter {
    public static float PxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float DpToPx(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
