package com.baizhi.test;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * Created by wdwhwn on 2018/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestA
{
    @Autowired
    private FastFileStorageClient storageClient;

//    文件上传
    @Test
    public void  contextLoads() throws FileNotFoundException {
        String path="D:\\123.jpg";
        File file=new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        StorePath str = storageClient.uploadFile(fileInputStream, file.length(),path.substring(path.lastIndexOf(".")+1), null);
        System.out.println(str.getGroup()+" "+str.getPath());
    }
//    测试文件下载
    @Test
    public void testDownload() throws IOException {
        byte[] group1s = storageClient.downloadFile("group1", "M00/00/00/wKhVilvXaLeAfh6KAAHAAM_WIlM242.png", new DownloadByteArray());
        FileOutputStream outputStream = new FileOutputStream("D:\\22.png");
        outputStream.write(group1s);
        outputStream.close();
    }
}
