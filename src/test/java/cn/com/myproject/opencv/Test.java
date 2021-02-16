package cn.com.myproject.opencv;


import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    static {
        OpenCV.loadLocally();
    }
    public static void main(String[] args) {
        final Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("Initial matrix: " + m.dump());

        final Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));

        final Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));

        System.out.println( "Final matrix: {0}." + m.dump());

    }


}
