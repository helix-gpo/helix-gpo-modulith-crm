package com.helix.gpo.crm.aws;

import org.springframework.modulith.NamedInterface;
import org.springframework.web.multipart.MultipartFile;

@NamedInterface(name = "awsServiceApi")
public interface AwsServiceApi {

    String uploadFile(String bucket, MultipartFile image, String key);

    String generatePresignedUrl(String bucket, String key, String contentType);

}
