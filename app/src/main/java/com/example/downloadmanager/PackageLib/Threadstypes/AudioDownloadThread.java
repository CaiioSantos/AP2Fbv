package com.example.downloadmanager.PackageLib.Threadstypes;

import com.example.downloadmanager.PackageLib.DownloadAudio;

public class AudioDownloadThread implements  Runnable {
    private String url;

    public AudioDownloadThread (String url){
        this.url = url;
    }

    @Override
    public void run() {
        DownloadAudio downloadAudio = new DownloadAudio();
        downloadAudio.downloadRequest(url);
    }
}
