package com.rakoi.webapp.classeye.classeye.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Time;

@Service
public class QRgeneratorUtil {

    @Autowired
    public ServletContext context;



    public  String generateQrCodeImage(String text) throws IOException {


        String path=context.getRealPath("/resources/qrcodes/");
        int width=3000;
        int height=3000;
        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        String filename=String.valueOf(System.currentTimeMillis())+text+".PNG";
        String QrPath=path+filename;


        File myFile=new File(QrPath);
        ByteArrayOutputStream outputStream= QRCode.from(text).withSize(600,600).to(ImageType.PNG).stream();
        FileOutputStream fileOutputStream=new FileOutputStream(myFile);
        fileOutputStream.write(outputStream.toByteArray());
        fileOutputStream.flush();


        return "/resources/qrcodes/"+filename;
    }

}
