package com.jpp.badge;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;


/**
 * Created by Administrator on 11/12/2017.
 */

public interface iAvatarBadgeViewPlus {
    public avatarBadgeViewPlus badgeText(int text);
    public avatarBadgeViewPlus badgeTextSize(int size);
    public avatarBadgeViewPlus badgeMaxNumber(int max);
    public avatarBadgeViewPlus badgeColor(int color);
    public avatarBadgeViewPlus badgeTextColor(int textColor);
    public avatarBadgeViewPlus drawbleIcon(Drawable drawable);
    public avatarBadgeViewPlus src(int image, ImageView.ScaleType scaleType);
    public avatarBadgeViewPlus iconPadding(int left, int top, int right, int bottom);
    public avatarBadgeViewPlus gravity(int gravity);
}
