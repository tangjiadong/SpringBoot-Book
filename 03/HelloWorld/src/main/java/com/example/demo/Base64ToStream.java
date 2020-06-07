package com.example.demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

/**
 * 将本地图片转base64格式， 再转图片
 */
public class Base64ToStream {
    public static void main(String[] args) {
        //首先随便找一张图片放在你的本地磁盘目录中，此处为了方便学习特意该的图片名
        String base64 = ImageToBase64("d://test.png");
        //为了图片和Base64之间互转的方便测试直接将返回的base64格式传回
        Base64ToStream(base64);
    }

    private static String ImageToBase64(String imgPath) {
        byte[] data = null;
        InputStream in = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        return encoder.encode(Objects.requireNonNull(data));
    }

    private static void Base64ToStream(String base64) {
        BASE64Decoder decoder = new BASE64Decoder();
        //图片类型
        String fileType = "png";
        InputStream input = null;
        try {
            //转化成流
            byte[] imageByte = decoder.decodeBuffer(base64);
            input = new ByteArrayInputStream(imageByte);
            BufferedImage bi = ImageIO.read(input);
            File file = new File("d://Base64ToStream." + fileType + "");
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
