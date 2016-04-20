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
        builder.setContentTitle("Zayn");
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

    private void sendNotificationBigPictureStyle(Activity activity){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);

        Bitmap profilePicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.profile_luz
        );

        Bitmap bigPicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.big_picture
        );

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.bigPicture(bigPicture);
        style.setBigContentTitle("New picture from Luz");
        style.setSummaryText("Science is awesome, look at.");
        style.bigLargeIcon(profilePicture);
        builder.setStyle(style);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 4, notification);

    }

    private void sendNotificationInboxStyle(Activity activity){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);

        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);

        Bitmap profilePicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.profile_manual
        );
        builder.setLargeIcon(profilePicture);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Manuel");
        String messages = "Bro!, today Armin in Mamacona\n" +
                "State of trance, fucking holy madness\n" +
                "Goooooooooooo!";


        if (!messages.isEmpty()) {
            String[] lines = messages.split("\\n");
            for (int i= 0; i < lines.length ; i++) {
                inboxStyle.addLine(lines[i]);
            }
            inboxStyle.setSummaryText(lines.length + " new messages");
        }
        builder.setStyle(inboxStyle);
        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 5, notification);
    }

    public void sendNotificationBigTextStyle(Activity activity){

        Bitmap profilePicture = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.profile_carl_sagan
        );
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setLargeIcon(profilePicture);

        NotificationCompat.BigTextStyle bigTextStyle= new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Carl Sagan");
        bigTextStyle.setSummaryText("Quote of the Day");
        bigTextStyle.bigText("Science is much more than a body of knowledge." +
                " It is a way of thinking. This is central to its success." +
                " Science invites us to let the facts in, even when they don’t conform to our preconceptions.");
        builder.setStyle(bigTextStyle);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIFICATION_ID + 6, notification);

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
                sendNotificationBigTextStyle(getActivity());
                break;
            case R.id.buttonBigPictureStyle:
                sendNotificationBigPictureStyle(getActivity());
                break;
            case R.id.buttonInboxStyle:
                sendNotificationInboxStyle(getActivity());
                break;
            case R.id.buttonMediaStyle:
                break;
        }
    }
}
