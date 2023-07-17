package com.example.imageprocessing;

import android.graphics.Bitmap;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class Visualize {
    public static void drawRectangle(
            Mat src, Point start, Point end, Scalar color, int thickness, int lineType
    )
    {
        Imgproc.rectangle(src, start, end, color, thickness, lineType, 0);
    }

    public static void drawRectangle(
            Bitmap src, Point start, Point end, Scalar color, int thickness, int lineType
    )
    {
        Mat mapSrc = new Mat();
        Utils.bitmapToMat(src, mapSrc);
        Imgproc.rectangle(mapSrc, start, end, color, thickness, lineType, 0);
    }
}
