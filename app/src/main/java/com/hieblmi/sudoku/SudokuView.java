package com.hieblmi.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class SudokuView extends View {

    private String TAG = "SudokuView";

    private int tileWidth;
    private int tileHeight;



    private SudokuActivity sudoku;


    private Paint gridColor;

    public SudokuView(Context context) {
        super(context);

        sudoku = (SudokuActivity) context;

        gridColor = new Paint();
        gridColor.setColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d(TAG, "onSizeChanged");

        super.onSizeChanged(w, h, oldw, oldh);

        tileWidth = w / 9;
        tileHeight =  h / 9;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw");

        super.onDraw(canvas);

        // Draw the minor grid lines
        for (int i = 0; i < 9; i++) {
            canvas.drawLine(0, i * tileHeight, getWidth(), i * tileHeight, gridColor);
            canvas.drawLine(0, i * tileHeight + 1, getWidth(), i * tileHeight + 1,
                    gridColor);
            canvas.drawLine(i * tileWidth, 0, i * tileWidth, getHeight(), gridColor);
            canvas.drawLine(i * tileWidth + 1, 0, i * tileWidth + 1, getHeight(),
                    gridColor);
        }
    }
}
