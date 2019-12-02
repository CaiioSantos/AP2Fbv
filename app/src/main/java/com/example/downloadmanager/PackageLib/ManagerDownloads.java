package com.example.downloadmanager.PackageLib;

import java.io.File;

public abstract class ManagerDownloads {

    public boolean downloadRequest(String url) {
        return false;
    }

    public void downloadStartThread(String url) {
    }

    public File createFile(String urlForParse, String name) {
        return null;
    }
}
