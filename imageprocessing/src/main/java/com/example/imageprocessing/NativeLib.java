package com.example.imageprocessing;

public class NativeLib {

    // Used to load the 'imageprocessing' library on application startup.
    static {
        System.loadLibrary("imageprocessing");
    }

    /**
     * A native method that is implemented by the 'imageprocessing' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}