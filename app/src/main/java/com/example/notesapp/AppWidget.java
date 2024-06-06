package com.example.notesapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {



        for (int appWidgetId : appWidgetIds) {

            Intent launchActivity = new Intent(context, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchActivity, PendingIntent.FLAG_IMMUTABLE);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
            remoteViews.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);


            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

}
