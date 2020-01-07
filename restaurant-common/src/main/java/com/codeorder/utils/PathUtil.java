package com.codeorder.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;


public class PathUtil {
    /**
     * 获取存放图片的绝对路径
     *
     * @return path
     * windows和linux位置不同
     */
    public static String getImgBasePath() {
        String basePath;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            basePath = "c:/codeorder/";
        } else {
            basePath = "/home/tfany/codeorder/";
        }
        return basePath;
    }

    public static MultipartFile getCommonsMult(String name) throws IOException {
        File file = new File(name);
        FileItem fileItem = new DiskFileItem(
                "formFieldName",//form表单文件控件的名字随便起
                Files.probeContentType(file.toPath()),//文件类型
                false, //是否是表单字段
                file.getName(),//原始文件名
                (int) file.length(),//Interger的最大值可以存储两部1G的电影
                file.getParentFile());//文件会在哪个目录创建

        //最关键的一步：为DiskFileItem的OutputStream赋值
        //IOUtils是org.apache.commons.io.IOUtils;
        //与此类似的还有FileUtils
        IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());

        return new CommonsMultipartFile(fileItem);
    }

    public static void deleteFile(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath.substring(1));
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (File file : files) {
                    file.delete();
                }
            }
            fileOrPath.delete();
        }
    }

    /**
     * 只保留数据库存在的图片
     *
     * @param url url
     */
    public static void deleteFiles(String url) {
        if (url != null) {
            try {
                File file = new File(PathUtil.getImgBasePath() + url);
                if (file.exists()) {
                    File[] files = file.getParentFile().listFiles();
                    for (File file1 : files) {
                        if (!file.getName().equals(file1.getName())) {
                            file1.delete();
                        }
                    }
                }
            } catch (Exception ignored) {

            }
        }
    }

    public static void deleteDir(String url) {

        File file = new File(url);
        if (!file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                f.delete();
            }
        }
        file.delete();
    }

    /**
     * 获取存放图片的地址
     *
     * @return imagePath 相随地址
     */
    public static String getShopImage() {
        return "/shop/";
    }

    public static String getDishImagePath(String dishId) {
        return "/dish/" + dishId + "/";

    }
}
