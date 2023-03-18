package com.example.calc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class PaintView extends View {

    Paint otherPaint, outerPaint, textPaint;
    float arcLeft;

    public PaintView(Context context){
        super(context);
        textPaint = new Paint(Paint.LINEAR_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(pxFromDp(context, 24));

        outerPaint = new Paint();
        outerPaint.setStyle(Paint.Style.FILL);
        outerPaint.setColor(getResources().getColor(R.color.purple_200));
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        arcLeft = pxFromDp(context, 20);
        otherPaint = new Paint();
    }

    static float pxFromDp(final Context context, final float dp) {
//        return dp * context.getResources().getDisplayMetrics().density;
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPaint(outerPaint);
        otherPaint.setColor(Color.WHITE);
        otherPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(
                getLeft() + (getRight() - getLeft()) / 3,
                getTop() + (getBottom() - getTop()) / 3,
                getRight() - (getRight() - getLeft()) / 3,
                getBottom() - (getBottom() - getTop()) / 3, otherPaint);

        otherPaint.setColor(getResources().getColor(R.color.purple_200));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, arcLeft, otherPaint);
        canvas.drawText("Geeks for Geeks", (float) (getWidth() * 0.3), (float) (getHeight() * 0.8), textPaint);
    }
}
