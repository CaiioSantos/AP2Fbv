package com.example.downloadmanager.PackageLib;



public final class DownloadFactory {

    private static DownloadFactory instancia;

    public DownloadFactory(){

    }

    public static DownloadFactory getInstancia() {
        if (instancia == null){
            instancia = new DownloadFactory();
        }
        return instancia;
    }


    public ManagerDownloads makeurlobject(String url, String tipo){

        String extension = "";
        int i = url.lastIndexOf(".");
        if(i>0){
            //Getting the url extension
            extension = url.substring(i+1);

            if(extension.equals("jpg") || extension.equals("png") && tipo.equals("image") ){
                return new DownloadImage();
            }

            if(tipo.equals("audio")){
                return new DownloadAudio();
            }

        }

        return null;
    }
}


