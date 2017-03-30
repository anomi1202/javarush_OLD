package com.javarush.test.level16.lesson13.bonus01;


import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Ru on 19.01.2017.
 */
public class ImageReaderFactory {
    public static synchronized ImageReader getReader(ImageTypes format) {
        if (format == ImageTypes.JPG)
            return new JpgReader();
        else if (format == ImageTypes.BMP)
            return new BmpReader();

        else if (format == ImageTypes.PNG)
            return new PngReader();

        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
