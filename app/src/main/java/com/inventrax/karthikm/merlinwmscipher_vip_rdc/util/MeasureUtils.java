package com.inventrax.karthikm.merlinwmscipher_vip_rdc.util;


import com.inventrax.karthikm.merlinwmscipher_vip_rdc.application.AbstractApplication;

public class MeasureUtils {

    public static int pxToDp(int px) {
        final float scale = AbstractApplication.get().getResources().getDisplayMetrics().density;
        return (int) ((px * scale) + 0.5f);
    }

}
