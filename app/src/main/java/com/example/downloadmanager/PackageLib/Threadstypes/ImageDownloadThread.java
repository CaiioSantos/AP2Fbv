package com.example.downloadmanager.PackageLib.Threadstypes;

import com.example.downloadmanager.PackageLib.DownloadImage;

public class ImageDownloadThread implements Runnable {


    private String url;

    public ImageDownloadThread(String url){
        this.url = url;
    }

    @Override
    public void run() {
        DownloadImage downloadImage = new DownloadImage();
        downloadImage.downloadRequest(url);
    }
}
