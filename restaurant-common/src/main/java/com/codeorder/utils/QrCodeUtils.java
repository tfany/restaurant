package com.codeorder.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.util.ResourceUtils;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class QrCodeUtils {
    public String createQRCode(String content,int width,int height,String path) throws IOException {
        String resultImage="";
        if(!content.equals("")&&!content.equals(null)){
            ServletOutputStream stream=null;
            ByteArrayOutputStream os=new ByteArrayOutputStream();
            @SuppressWarnings("rawtypes")
            HashMap<EncodeHintType,Comparable> hints=new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//指定二维码的纠错等级为中
            hints.put(EncodeHintType.MARGIN,2);//指定二维码边距
            try {

                QRCodeWriter writer=new QRCodeWriter();
                BitMatrix bitMatrix=writer.encode(content, BarcodeFormat.QR_CODE,width,height,hints);
                MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
                BufferedImage bufferedImage= MatrixToImageWriter.toBufferedImage(bitMatrix,config);
//                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//                for (int x = 0; x < width; x++) {
//                    for (int y = 0; y < height; y++) {
//                        bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
//                    }
//                }
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(ImageIO.read(ResourceUtils.getFile(path)), width / 5 * 2, height / 5 * 2, width / 5, height / 5, null); // logo.png自行设置
                g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.draw(new RoundRectangle2D.Float(width / 5 * 2, height / 5 * 2, width / 5, height / 5, 20, 20));
                g2.dispose();
                g2.setColor(Color.white);
                g2.setBackground(Color.white);
                bufferedImage.flush();
                ImageIO.write(bufferedImage,"png",os);
                OutputStream out = new FileOutputStream("F:/Image/abb2.png");
                out.write(os.toByteArray());
                resultImage=new String("data:image/png;base64,"+ Base64.encode(os.toByteArray()));
                return resultImage;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(stream!=null){
                    stream.flush();
                    stream.close();
                }
            }
        }
        return null;
    }
}