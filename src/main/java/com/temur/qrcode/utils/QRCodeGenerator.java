package com.temur.qrcode.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.temur.qrcode.model.Student;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Student student) throws WriterException, IOException {
        String qrCodePath="/home/temur/Desktop/Real_loyiha/QRCodeImage/"; // file path

        String qrCodeName=qrCodePath+ student.getFirstName()+"_"+student.getLastName()+"-QRCODE.png";
        var qrCodeWriter=new QRCodeWriter();
        BitMatrix bitMatrix=qrCodeWriter.encode(
                "ID: "+student.getId()+"\n"+
                        "Firstname: "+student.getFirstName()+"\n"+
                        "Lastname: "+student.getLastName()+"\n"+
                        "Email: "+student.getEmail()+"\n"+
                        "Mobile: "+student.getMobile(),
                BarcodeFormat.QR_CODE,400,400
        );

        Path path= FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);

    }
}