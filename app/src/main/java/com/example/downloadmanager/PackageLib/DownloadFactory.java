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


    public DownloadImage makeurl(String url, String tipo){

        String  ext = "";
        int i  = url.lastIndexOf("");
        if (i>0){
            ext = url.substring(i+1);

            if(ext.equals("png")|| ext.equals("jpg") && tipo.equals("image")){
                return new DownloadImage();
            }
            if (tipo.equals("audio")){
                return new DownloadAudio();
            }
        }

        return null;
    }
}


