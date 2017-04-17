package com.dragonfury.duy.p4a09lastfirstclassmethods;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.graphics.Paint;

/**
 * Created by 1383504 on 2/14/2017.
 */
public class DrawView extends View {

    private Cell cell00;
    Paint nam = new Paint();
    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cell00.update(canvas);
        cell00.draw(canvas, nam);
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        cell00 = new Cell(0, 0, .1f*getWidth(), .1f* getWidth());
    }
}
