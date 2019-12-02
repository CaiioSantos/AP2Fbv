package com.example.downloadmanager.PackageLib;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.example.downloadmanager.PackageLib.Threadstypes.DownloadThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage extends  ManagerDownloads {

    @Override
    public boolean downloadRequest(String url) {

        URL linkdownload = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        try {
            linkdownload = new URL(url);
            httpURLConnection = (HttpURLConnection) linkdownload.openConnection();
            inputStream = httpURLConnection.getInputStream();

            try {
                file = new File(createFile(url,null).toString());
            }catch (Exception e){
                Log.i("ImageStatus","Image in storage!");
                return false;
            }


            fileOutputStream = new FileOutputStream(file);

            int readInput = -1;
            byte[] buffer = new byte[1024];
            while((readInput=inputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,readInput);
            }
            Log.i("ImageStatus","Image downloaded!" +readInput);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
    @Override
    public void downloadStartThread(String url) {
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.getInstancia();
        downloadThread.useService(url,"image");
    }


    @Override
    public File createFile(String urlForParse, String name) {
        String fileName = Uri.parse(urlForParse).getLastPathSegment();
        String directory = Environment.getExternalStorageDirectory().toString();
        File folderDir = new File(directory+"/Downloads");
        File folderImages = new File(directory+"/Downloads/images");
        File folderAndFile = new File(directory+"/Downloads/images/"+fileName);

        if(!folderDir.isDirectory()){
            folderImages.mkdirs();
            return folderAndFile;
        }else if (!folderImages.isDirectory()){
            folderImages.mkdir();
            return folderAndFile;
        }else if(!folderAndFile.exists()){
            return folderAndFile;
        }else{
            return null;
        }
    }
    }

