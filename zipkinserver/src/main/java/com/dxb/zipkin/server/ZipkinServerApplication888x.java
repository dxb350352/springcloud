package com.dxb.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import zipkin.server.EnableZipkinServer;

@SpringCloudApplication
@EnableZipkinServer
public class ZipkinServerApplication888x {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication888x.class, args);
    }
}
