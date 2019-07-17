package com.jpp.badge;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;



/**
 * Created by Administrator on 11/12/2017.
 */

public interface iBadgeViewPlus {
    public badgeViewPlus badgeText(int text);
    public badgeViewPlus badgeTextSize(int size);
    public badgeViewPlus badgeMaxNumber(int max);
    public badgeViewPlus badgeColor(int color);
    public badgeViewPlus badgeTextColor(int textColor);
    public badgeViewPlus drawbleIcon(Drawable drawable);
    public badgeViewPlus src(int image, ImageView.ScaleType scaleType);
    public badgeViewPlus iconPadding(int left, int top, int right, int bottom);
    public badgeViewPlus gravity(int gravity);
}
