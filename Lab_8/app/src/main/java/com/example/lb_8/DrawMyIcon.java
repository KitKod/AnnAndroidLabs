package com.example.lb_8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class DrawMyIcon extends View {
    private Paint mPaint = new Paint();
    private Path path = new Path();

    public DrawMyIcon(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float circle_rad = 60;

        //стиль заливка
        mPaint.setStyle(Paint.Style.FILL);
        //закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);
        //рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(width / 2.0f, height / 2.0f, circle_rad, mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.FILL);

        float trap_start_x = (width / 2.0f) + 60;
        float trap_start_y = (height / 2.0f) + 60;

        path.moveTo(trap_start_x, trap_start_y);
        path.lineTo(trap_start_x - (circle_rad * 2), trap_start_y);
        path.lineTo((trap_start_x - (circle_rad * 2)) - 30, trap_start_y + 150);
        path.lineTo(trap_start_x + 30, trap_start_y + 150);
        path.lineTo(trap_start_x, trap_start_y);


        float rect_start_x = (width / 2.0f) + 40;
        float rect_start_y = trap_start_y + 150;

        path.moveTo(rect_start_x, rect_start_y);
        path.lineTo(rect_start_x, rect_start_y + 50);
        path.lineTo(rect_start_x - 80, rect_start_y + 50);
        path.lineTo(rect_start_x - 80, rect_start_y);

        path.addCircle(trap_start_x + 30, trap_start_y + 50, 20.0f, Path.Direction.CW);
        path.addCircle((trap_start_x - (circle_rad * 2)) - 30, trap_start_y + 50, 20.0f, Path.Direction.CW);

        canvas.drawPath(path, mPaint);

    }
}
