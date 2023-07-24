package com.example.progress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class newView extends androidx.appcompat.widget.AppCompatTextView {
    private  float Text_Size;
    private  int Text_Color = R.color.black;
    private int  Elow_Widt = 15;
    private int Elow_Color = R.color.white;
    private int Color= R.color.black;

    private int text_Color=R.color.black;
    private int Progress=50;
    private Paint paint,lowpaint,textpaint;
    public newView(@NonNull Context context) {
        this(context,null);
    }

    public newView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    @SuppressLint("ResourceAsColor")
    public newView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array= context.obtainStyledAttributes(attrs,R.styleable.progress);
        Elow_Color=array.getColor(R.styleable.progress_low_color,Elow_Color);
        Color=array.getColor(R.styleable.progress_color,Color);
        Text_Color=array.getColor(R.styleable.progress_new_textcolor,Text_Color);
        Text_Size=array.getDimension(R.styleable.progress_new_textsize,Text_Size);
        array.recycle();
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(Elow_Widt);
        paint.setColor(Elow_Color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        //底色
        lowpaint=new Paint();
        lowpaint.setAntiAlias(true);
        lowpaint.setStrokeWidth(Elow_Widt);
        lowpaint.setColor(Color);
        lowpaint.setStyle(Paint.Style.STROKE);
        lowpaint.setStrokeCap(Paint.Cap.ROUND);
        //文字颜色
        textpaint=new Paint();
        textpaint.setAntiAlias(true);
        textpaint.setColor(Color);
        textpaint.setColor(Text_Color);
        textpaint.setTextSize(Text_Size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF oval_low=new RectF(Elow_Widt/2,Elow_Widt/2,getWidth()-(Elow_Widt/2),getHeight()-(Elow_Widt/2));
        //外圆
        canvas.drawArc(oval_low,0,360,false,paint);
        float Percent=((float) Progress/100)*360;
        //外圆
        canvas.drawArc(oval_low,0,Percent,false,lowpaint);
        Paint.FontMetricsInt fontMetrics = textpaint.getFontMetricsInt();
        String e_Progress= Progress+"%";
        Rect Rect=new Rect();
        textpaint.getTextBounds(e_Progress,0,e_Progress.length(),Rect);
        int dy=(fontMetrics.bottom-fontMetrics.top)/2-fontMetrics.bottom;
        int baseLine=getHeight()/2 + dy;
        int x=(getWidth()/2)-Rect.width()/2;
        canvas.drawText(e_Progress,x,baseLine,textpaint);
    }
    public void set_new(int Progress){
        this.Progress= Progress;
        invalidate();
    }
}
