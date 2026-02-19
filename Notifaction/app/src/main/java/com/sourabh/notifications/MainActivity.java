package com.sourabh.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    //step 5
    private static final String CHANNEL_ID = "channel1";

    // step 1
     NotificationManager nm;

    //step 3
     NotificationCompat.Builder notificationBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  step 2  Notification Manager
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create channel (API 26+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // step 6
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Permission for message", NotificationManager.IMPORTANCE_HIGH);
            //step 7
            nm.createNotificationChannel(channel);
        }

  //step 4 here we want channal id so we create channel
        // Build notification (ONE TIME)
        notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.img)
                        .setContentTitle("Neetin")
                        .setContentText("Hi Sourabh, how are you?")
                        .setAutoCancel(true);
//step 8
        // Button
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //last step
                nm.notify(1, notificationBuilder.build());
            }
        });
    }
}
// note if you want to add big icone in  so convert drawable imge to mipmap learn late 