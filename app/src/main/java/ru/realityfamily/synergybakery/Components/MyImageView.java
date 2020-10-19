package ru.realityfamily.synergybakery.Components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyImageView extends androidx.appcompat.widget.AppCompatImageView {
    public MyImageView(@NonNull Context context) {
        super(context);
    }

    public MyImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size;
        if (getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT &&
                getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            size = width;
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.MATCH_PARENT &&
                getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            size = height;
        } else {
            size = Math.min(width, height);
        }
        setMeasuredDimension(size, size);
    }
}
