package com.example.downloadmanager.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.downloadmanager.PackageLib.DownloadFactory;
import com.example.downloadmanager.PackageLib.ManagerDownloads;
import com.example.downloadmanager.R;

public class InsertURLmusic extends AppCompatActivity {
    // EXAMPLE ACTIVITY TO SHOW LIBRARY USAGE.
    //String link2 = "https://static.gamespot.com/uploads/scale_medium/1197/11970954/3181241-ig-lozbreathofthewildrelease-20170112.jpg";
    //String link = "https://freemusicarchive.org/music/download/f18f1ef116794e17a787d807515b060e8591d1e2";


    DownloadFactory dfactory = new DownloadFactory();
    //DownloadMng audiomanager = dfactory.makeurlobject(link,"audio");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_urlmusic);
        Button btn = findViewById(R.id.searchbtn);
        final EditText urlBox = findViewById(R.id.UrlBox);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String link = null;
                link = urlBox.getText().toString();
                ManagerDownloads imagemanager = dfactory.makeurlobject(link,"audio");
                if(imagemanager!=null) {
                    imagemanager.downloadStartThread(link);
                }

            }
        });
    }
}
