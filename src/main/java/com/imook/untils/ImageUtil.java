package com.imook.untils;

import ch.qos.logback.core.util.FileUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    public static String generateThumbnail(InputStream thumbail,String fileName, String targetAddr) throws IOException {
        String realFileName = getRandomFileName(); // 文件的名字
        String extension = getFileExtension(fileName);// 文件的扩展名.jpg
        makeDirPath(targetAddr);
        String relativreAddr = targetAddr + realFileName + extension;//相对路径
        File dest = new File(PathUtil.getImgBasePath() + relativreAddr);
        try {
            Thumbnails.of(thumbail).size(200, 200).outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativreAddr;
    }

    /*创建目录路径所涉及的目录，即/home/work/xiangze/xxx.jpg*/
    // /home/work/xiangze
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;//全路径

        File dirdath = new File(realFileParentPath);
        if(!dirdath.exists()){
// 递归创建
            dirdath.mkdirs();
        }
    }

    // 获取输入文件的扩展名
    private static String getFileExtension(String cFile) {
        //   String originalFilename = cFile.getOriginalFilename();//  ?
        return cFile.substring(cFile.lastIndexOf(".") + 1);
    }

    //1.获取随机五位数，当前年月日小时分钟秒钟
    public static String getRandomFileName() {
        int random = r.nextInt(89999) + 10000; //整形
        String nowTimeStr = sDataFormat.format(new Date());//  字符串
        return random + nowTimeStr;  // 自动展示成字符串
    }

    /*缩略图*/
    public static void main(String[] args) throws IOException {

//        System.out.println(basePath);
        Thumbnails.of(new File("D:\\Program Files (x86)\\HotFoxDownstair\\xiaohuangren.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f).toFile("D:\\Program Files (x86)\\HotFoxDownstair\\xiaohuangren6.jpg");


    }
}
