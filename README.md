
# Samples of NotificationCompat

Simple Samples for creating Beautiful Notification with NotificationCompat. - **Android Development Patterns Ep 2**

Heres is the link to Episode 2 [NotificationCompat Video](https://www.youtube.com/watch?v=-iog_fmm6mE&list=PLWz5rJ2EKKc-lJo_RGGXL2Psr8vVCTWjM&index=12).


NotificationCompat is the 2nd ep, of the serie: Android Development Patterns.

[Android Development Patterns playlist here](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc-lJo_RGGXL2Psr8vVCTWjM)

Heres is the link to [Android Developers Channel](https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg).

# Screenshots
![MainLayout](https://github.com/SteveCampos/NotificationCompat/blob/master/Screenshot_2016-04-19-23-04-24.png)
![NotificationLayer1](https://github.com/SteveCampos/NotificationCompat/blob/master/Screenshot_2016-04-17-13-28-25.png)
![NotificationLayer2](https://github.com/SteveCampos/NotificationCompat/blob/master/Screenshot_2016-04-19-22-56-56.png)

# Sample Code

--
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
--


