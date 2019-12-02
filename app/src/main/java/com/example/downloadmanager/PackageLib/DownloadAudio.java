package com.example.downloadmanager.PackageLib;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadAudio extends ManagerDownloads  {

    @Override
    public boolean downloadRequest(String url) {
        URL linkdownload = null;
        InputStream inputStream = null;
        HttpURLConnection connection = null;
        FileOutputStream fileOutputStream =null;
        File file = null;
        String valorCampo = null;

        try {
            linkdownload = new URL(url);
            connection = (HttpURLConnection) linkdownload.openConnection();

            valorCampo = connection.getHeaderField("Content- Disposition");
            String namefile = valorCampo.substring(valorCampo.indexOf("namefile=\"") + 10, valorCampo.length() -1);
            inputStream =  connection.getInputStream();

            try {
                //used try catch to handle returned null (if Audio was found in storage) throws error
                file = new File(createFile(url,namefile).toString());
            }catch (Exception e){
                //
                Log.i("AudioStatus","Audio in storage!");
                return false;

            }


            fileOutputStream = new FileOutputStream(file);

            int InputR = -1;
            byte[] buffer = new byte[1024];
            while((InputR=inputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,InputR);

            }
            Log.i("AudioStatus","Download Finalizado" +InputR);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
                if (connection!=null){
                    connection.disconnect();
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
        DownloadThreadPool threadpool = new DownloadThreadPool();
        threadpool.getSingletonThreadPool();
        threadpool.useService(url,"audio");    }

    @Override
    public File createFile(String urlForParse, String name) {
        return super.createFile(urlForParse, name);
    }
} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
