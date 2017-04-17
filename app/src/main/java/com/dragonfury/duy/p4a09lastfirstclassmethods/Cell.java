package com.dragonfury.duy.p4a09lastfirstclassmethods;

import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * Created by 1383504 on 2/14/2017.
 */
public class Cell extends RectF{
    public Cell(float left, float top, float right, float bottom) {
        super(left, top, right, bottom);
        xSpeed = (int)(Math.random()*5-2);
    }

    public static final Creator<RectF> CREATOR = null;
    private int xSpeed = 64, ySpeed = 83;
    int state = 1; //1 = block, 0 = Os, 10 = oval
    public void draw(Canvas c, Paint p) {
        if (state == 1) {
            c.drawRect(this, p);
        } else if (state == 0) {
            c.drawCircle(centerX(), centerY(), .48f * width(), p);
        } else if (state == 10) {
            c.drawOval(this, p);
        }
    }

    public void update(Canvas c) {
        if (right + xSpeed > c.getWidth()) {
            xSpeed *= -1;
            state = 0;
        }
        if (left + xSpeed < 0) {
            xSpeed *= -1;
            state = 1;
        }
        if (bottom + ySpeed > c.getHeight()) {
            ySpeed *= -1;
            state = 10;
        }
        if (left + ySpeed < 0) {
            ySpeed *= -1;
            state = 10;
        }
        this.offset(xSpeed, ySpeed);
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }
}
