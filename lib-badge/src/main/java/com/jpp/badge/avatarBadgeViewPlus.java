package com.jpp.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jpp.images.circleImageViewPlus;
import com.jpp.text.textViewPlus;
import com.jpp.utils.units.jTools;
import com.jpp.utils.units.lan.lanSet;

/**
 * <h1>badge library</h1>
 * <p>ability to set all properties except drawble and image scale type in xml, all properties can be set from code</b>
 * @author  Omid Payandeh
 */

public class avatarBadgeViewPlus extends FrameLayout implements iAvatarBadgeViewPlus {
    //region Properties
    private circleImageViewPlus image;
    private textViewPlus title;
    private int badgeText;
    private float badgeTextSize;
    private int badgeMaxNumber;
    private int badgeColor;
    private int badgeTextColor;
    private Drawable drawbleIcon;
    private int src;
    private int iconPaddingLeft;
    private int iconPaddingTop;
    private int iconPaddingRight;
    private int iconPaddingBottom;
    private int gravity;
    //endregion
    //region Getter/Setter

    private int getGravity() {
        return gravity;
    }

    private void setGravity(int gravity) {
        this.gravity = gravity;
    }

    private int getBadgeText() {
        return badgeText;
    }

    private void setBadgeText(int badgeText) {
        this.badgeText = badgeText;
    }

    private float getBadgeTextSize() {
        return badgeTextSize;
    }

    private void setBadgeTextSize(float badgeTextSize) {
        this.badgeTextSize = badgeTextSize;
    }

    private int getBadgeMaxNumber() {
        return badgeMaxNumber;
    }

    private void setBadgeMaxNumber(int badgeMaxNumber) {
        this.badgeMaxNumber = badgeMaxNumber;
    }

    private int getBadgeColor() {
        return badgeColor;
    }

    private void setBadgeColor(int badgeColor) {
        this.badgeColor = badgeColor;
    }

    private int getBadgeTextColor() {
        return badgeTextColor;
    }

    private void setBadgeTextColor(int badgeTextColor) {
        this.badgeTextColor = badgeTextColor;
    }

    private Drawable getDrawbleIcon() {
        return drawbleIcon;
    }

    private void setDrawbleIcon(Drawable drawbleIcon) {
        this.drawbleIcon = drawbleIcon;
    }

    private int getSrc() {
        return src;
    }

    private void setSrc(int src) {
        this.src = src;
    }

    public int getIconPaddingLeft() {
        return iconPaddingLeft;
    }

    public void setIconPaddingLeft(int iconPaddingLeft) {
        this.iconPaddingLeft = iconPaddingLeft;
    }

    public int getIconPaddingTop() {
        return iconPaddingTop;
    }

    public void setIconPaddingTop(int iconPaddingTop) {
        this.iconPaddingTop = iconPaddingTop;
    }

    public int getIconPaddingRight() {
        return iconPaddingRight;
    }

    public void setIconPaddingRight(int iconPaddingRight) {
        this.iconPaddingRight = iconPaddingRight;
    }

    public int getIconPaddingBottom() {
        return iconPaddingBottom;
    }

    public void setIconPaddingBottom(int iconPaddingBottom) {
        this.iconPaddingBottom = iconPaddingBottom;
    }

    //endregion

    public avatarBadgeViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_avatar_image_bagde_plus, this, true);
        image = (circleImageViewPlus) getChildAt(0);
        title = (textViewPlus) getChildAt(1);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.badgeView, 0, 0);
        badgeText(a.getInteger(R.styleable.badgeView_badgeText, 0));
        badgeMaxNumber(a.getInteger(R.styleable.badgeView_badgeMaxNumber, 0));
        badgeTextSize(a.getInteger(R.styleable.badgeView_badgeTextSize, 0));
        customBorderWidth(a.getInteger(R.styleable.badgeView_custom_border_width, 0));
        customSize(a.getInteger(R.styleable.badgeView_custom_size, 0));
        iconPadding(a.getInteger(R.styleable.badgeView_iconPaddingLeft, 0),
                a.getInteger(R.styleable.badgeView_iconPaddingTop, 0),
                a.getInteger(R.styleable.badgeView_iconPaddingRight, 0),
                a.getInteger(R.styleable.badgeView_iconPaddingBottom, 0));
        badgeColor(a.getColor(R.styleable.badgeView_badgeColor, ContextCompat.getColor(context, android.R.color.holo_blue_dark)));
        borderColor(a.getColor(R.styleable.badgeView_border_color, ContextCompat.getColor(context, android.R.color.holo_blue_dark)));
        badgeTextColor(a.getColor(R.styleable.badgeView_badgeTextColor, ContextCompat.getColor(context, android.R.color.white)));
        a.recycle();

        //need improvements
        //handle lan
        if (!lanSet.isCurrentLanRtl(context)) {
            image.setScaleX(-1);
        }
    }

    public avatarBadgeViewPlus(Context context) {
        this(context, null);
    }


    @Override
    public avatarBadgeViewPlus badgeText(int text) {
        setBadgeText(text);
        title.setText(getBadgeText()>getBadgeMaxNumber() && getBadgeMaxNumber()!=0? String.format("+%d",getBadgeMaxNumber()):String.valueOf(getBadgeText()));
        if(getBadgeText()>0)
        {
            title.setVisibility(VISIBLE);
        }
        else{
            title.setVisibility(GONE);
        }
        return this;
    }

    @Override
    public avatarBadgeViewPlus badgeTextSize(int size) {
        setBadgeTextSize(size);
        title.setTextSize(getBadgeTextSize());
        return this;

    }

    @Override
    public avatarBadgeViewPlus badgeMaxNumber(int max) {
        setBadgeMaxNumber(max);
        title.setText(getBadgeText()>getBadgeMaxNumber() && getBadgeMaxNumber()!=0? String.format("+%d",getBadgeMaxNumber()):String.valueOf(getBadgeText()));
        return this;

    }

    @Override
    public avatarBadgeViewPlus badgeColor(int color) {
        setBadgeColor(color);
        ((GradientDrawable) title.getBackground()).setColor(getBadgeColor());
        return this;

    }

    @Override
    public avatarBadgeViewPlus badgeTextColor(int textColor) {
        setBadgeTextColor(textColor);
        title.setTextColor(getBadgeTextColor());
        return this;

    }

    @Override
    public avatarBadgeViewPlus drawbleIcon(Drawable drawable) {
        setDrawbleIcon(drawable);
        image.setImageDrawable(drawable);
        return this;

    }
    @Override
    public avatarBadgeViewPlus src(int picture, ImageView.ScaleType scaleType) {
        setSrc(picture);
        image.setImageResource(getSrc());
        image.setScaleType(scaleType);
        return this;

    }

    @Override
    public avatarBadgeViewPlus iconPadding(int left, int top, int right, int bottom) {
        setIconPaddingTop(top);
        setIconPaddingLeft(left);
        setIconPaddingBottom(bottom);
        setIconPaddingRight(right);
        image.setPadding(jTools.image.convertDpToPixel(getIconPaddingLeft(),getContext()),
                jTools.image.convertDpToPixel(getIconPaddingTop(),getContext()),
                jTools.image.convertDpToPixel(getIconPaddingRight(),getContext()),
                jTools.image.convertDpToPixel(getIconPaddingBottom(),getContext()));
        return this;

    }

    @Override
    public avatarBadgeViewPlus gravity(int gravity) {
        setGravity(gravity);
        LayoutParams lp = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, gravity);
        title.setLayoutParams(lp);
        return this;
    }
    public avatarBadgeViewPlus borderColor(int color) {
        image.setBorderColor(color);
        return this;
    }
    public avatarBadgeViewPlus customSize(int size) {
    image.getLayoutParams().width=jTools.image.convertDpToPixel(size,getContext());
        image.getLayoutParams().height=jTools.image.convertDpToPixel(size,getContext());
return this;
    }
    public avatarBadgeViewPlus customBorderWidth(int size) {
        image.setBorderWidth(jTools.image.convertDpToPixel(size,getContext()));
        return this;
    }
    public circleImageViewPlus getImageView()
    {
        return image;
    }
}
