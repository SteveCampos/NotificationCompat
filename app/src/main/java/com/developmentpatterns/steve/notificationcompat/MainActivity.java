package com.developmentpatterns.steve.notificationcompat;

/*
* Author : Steve Campos Vega
* Github: https://github.com/SteveCampos
* */
import android.app.Activity;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int NOTIFICATION_ID = 465023;

    /*
    * Android Development Patterns Ep 2
    * https://www.youtube.com/watch?v=-iog_fmm6mE
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonSmall = (Button) findViewById(R.id.buttonSmall);
        Button buttonLarge = (Button) findViewById(R.id.buttonLarge);
        Button buttonAction = (Button) findViewById(R.id.buttonAction);
        Button buttonSound = (Button) findViewById(R.id.buttonSound);
        Button buttonBigTextStyle = (Button) findViewById(R.id.buttonBigTextStyle);
        Button buttonBigPictureStyle = (Button) findViewById(R.id.buttonBigPictureStyle);
        Button buttonInboxStyle = (Button) findViewById(R.id.buttonInboxStyle);
        Button buttonMediaStyle = (Button) findViewById(R.id.buttonMediaStyle);


        buttonSmall.setOnClickListener(this);
        buttonLarge.setOnClickListener(this);
        buttonAction.setOnClickListener(this);
        buttonSound.setOnClickListener(this);
        buttonBigTextStyle.setOnClickListener(this);
        buttonBigPictureStyle.setOnClickListener(this);
        buttonInboxStyle.setOnClickListener(this);
        buttonMediaStyle.setOnClickListener(this);
    }

    private Activity getActivity(){
        return this;
    }

    private void sendNotificationSmallIcon(Activity activity){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Backup");
        String text = "It's time to initiate a backup.";
        builder.setContentText(text);
        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID , notification);
    }

    private void sendNotificationLargeIcon(Activity activity){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);

        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Johana Smith");
        String text = "Hey, want to get some lunch? What do " +
                "you think about burritos?";
        builder.setContentText(text);

        Bitmap profilePicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.profile_picture
        );
        builder.setLargeIcon(profilePicture);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 1, notification);

    }

    private void sendNotificationWithAction(Activity activity){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);

        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Drink water");
        String text = "Steve, It's time to drink water.";
        builder.setContentText(text);

        Bitmap bitmap = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.drink_water
        );
        builder.setLargeIcon(bitmap);

        builder.addAction(new NotificationCompat.Action(
                R.drawable.ic_notifications_off_black_24dp, "Off Notification", null
        ));

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 2, notification);

    }

    private void sendNotificationWithSound(Activity activity){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);

        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Manuel");
        String text = "Bro, today state of trance. Goooooo!";
        builder.setContentText(text);

        Bitmap profilePicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.zayn_makik
        );
        builder.setLargeIcon(profilePicture);

        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(notificationSound);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 3, notification);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSmall:
                sendNotificationSmallIcon(getActivity());
                break;
            case R.id.buttonLarge:
                sendNotificationLargeIcon(getActivity());
                break;
            case R.id.buttonAction:
                sendNotificationWithAction(getActivity());
                break;
            case R.id.buttonSound:
                sendNotificationWithSound(getActivity());
                break;
            case R.id.buttonBigTextStyle:
                break;
            case R.id.buttonBigPictureStyle:
                break;
            case R.id.buttonInboxStyle:
                break;
            case R.id.buttonMediaStyle:
                break;
        }
    }
}
