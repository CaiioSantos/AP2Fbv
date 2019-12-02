package com.example.downloadmanager.PackageLib.Threadstypes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadThread {


    private ExecutorService service = Executors.newFixedThreadPool(50);

    private static  DownloadThread instancia;

    public DownloadThread(){}

    public static DownloadThread getInstancia() {
        if (instancia == null){
            instancia = new DownloadThread();
        }
        return instancia;
    }

    public void useService(String url,String type){
        if(type.equals("image")){
            service.execute(new ImageDownloadThread(url));
        }

        if(type.equals("audio")){
            service.execute(new AudioDownloadThread(url));
        }


    }
}
