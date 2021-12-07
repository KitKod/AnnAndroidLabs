package com.example.lb_8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Draw2D extends View {
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    public Draw2D(Context context){
        super(context);
        //берем картинку из ресурсов
        Resources res=this.getResources();
        mBitmap= BitmapFactory.decodeResource(res,R.drawable.sorry);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        //стиль заливка
        mPaint.setStyle(Paint.Style.FILL);
        //закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);
        //рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(width-60, 50, 60, mPaint);
        //рисуем зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, height-180, width, height, mPaint);
        //рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        canvas.drawText("Зеленая лужайка", 30, height-140,
                mPaint);
        //выводим изображение
        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth()-
                120, height - mBitmap.getHeight() - 180, mPaint);
    }
}
