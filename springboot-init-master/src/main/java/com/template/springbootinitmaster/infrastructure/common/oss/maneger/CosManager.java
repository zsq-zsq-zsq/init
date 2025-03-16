//package com.template.springbootinitmaster.infrastructure.common.oss.maneger;
//
//import com.qcloud.cos.COSClient;
//import com.qcloud.cos.model.PutObjectRequest;
//import com.qcloud.cos.model.PutObjectResult;
//import java.io.File;
//import com.template.springbootinitmaster.infrastructure.common.oss.config.CosClientConfig;
//import jakarta.annotation.Resource;
//import org.springframework.stereotype.Component;
//
///**
// * Cos 对象存储操作
// *
// */
//@Component
//public class CosManager {
//
//    @Resource
//    private CosClientConfig cosClientConfig;
//
//    @Resource
//    private COSClient cosClient;
//
//
//    /**
//     * 上传对象
//     *
//     * @param key 唯一键
//     * @param file 文件
//     * @return
//     */
//    public PutObjectResult putObject(String key, File file) {
//        PutObjectRequest putObjectRequest = new PutObjectRequest(cosClientConfig.getBucket(), key,
//                file);
//        return cosClient.putObject(putObjectRequest);
//    }
//}
