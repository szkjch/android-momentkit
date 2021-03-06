package cn.wildfire.chat.moment.thirdbar;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import cn.wildfire.chat.moment.third.widgets.TitleBar;
import cn.wildfirechat.chat.R;

/**
 * Created by 大灯泡 on 2017/3/22.
 * <p>
 * 拥有titlebar的act基类
 */

public abstract class BaseTitleBarActivity extends BaseStatusControlActivity {
    protected TitleBar titleBar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initTitlebar();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initTitlebar();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initTitlebar();
    }

    private void initTitlebar() {
        if (titleBar == null) titleBar = (TitleBar) findViewById(R.id.title_bar_view);
        if (titleBar != null) {
            titleBar.getTitleText().setOnClickListener(new MultiClickListener() {
                @Override
                public void onSingleClick() {
                    onTitleSingleClick();
                }

                @Override
                public void onDoubleClick() {
                    onTitleDoubleClick();
                }
            });
            titleBar.setOnTitleBarClickListener(onTitleClickListener);
        }
    }


    // titlebar相关事件
    private TitleBar.OnTitleBarClickListener onTitleClickListener = new TitleBar.OnTitleBarClickListener() {

        @Override
        public boolean onLeftClick(View v, boolean isLongClick) {
            if (!isLongClick) {
                onTitleLeftClick();
                return false;
            } else {
                return onTitleLeftLongClick();
            }
        }

        @Override
        public boolean onTitleLongClick(View v) {
            return BaseTitleBarActivity.this.onTitleLongClick(v);
        }

        @Override
        public boolean onRightClick(View v, boolean isLongClick) {
            if (!isLongClick) {
                onTitleRightClick();
                return false;
            } else {
                return onTitleRightLongClick();
            }
        }
    };

    public boolean onTitleLongClick(View v) {
        return false;
    }

    public boolean onTitleLeftLongClick() {
        return false;
    }

    public boolean onTitleRightLongClick() {
        return false;
    }

    public void onTitleLeftClick() {
        finish();
    }

    public void onTitleRightClick() {
    }

    public void onTitleDoubleClick() {
    }

    public void onTitleSingleClick() {
    }

    @Override
    public void setTitle(int resId) {
        if (titleBar != null && resId != 0) {
            titleBar.setTitleText(resId);
        }
    }

    public void setTitle(String title) {
        if (titleBar != null && !TextUtils.isEmpty(title)) {
            titleBar.setTitleText(title);
        }
    }

    public void setTitleMode(@TitleBar.TitleBarMode int mode) {
        if (titleBar != null) {
            titleBar.setMode(mode);
        }
    }

    public void setTitleRightText(String text) {
        if (titleBar != null) {
            titleBar.setRightText(text);
        }
    }

    public void setTitleRightIcon(int resid) {
        if (titleBar != null) {
            titleBar.setRightIcon(resid);
        }
    }

    public void setTitleLeftText(String text) {
        if (titleBar != null) {
            titleBar.setLeftText(text);
        }
    }

    public void setTitleLeftIcon(int resid) {
        if (titleBar != null) {
            titleBar.setLeftIcon(resid);
        }
    }

    public void setLeftTextColor(int color) {
        if (titleBar != null) {
            titleBar.setLeftTextColor(color);
        }
    }

    public void setRightTextColor(int color) {
        if (titleBar != null) {
            titleBar.setRightTextColor(color);
        }
    }

    public void setTitleBarBackground(int color) {
        if (titleBar != null) {
            titleBar.setTitleBarBackgroundColor(color);
        }
    }

    public TitleBar getTitleBar() {
        return titleBar;
    }

    public String getBarTitle() {
        if (titleBar != null) {
            return titleBar.getTitleView().getText().toString();
        }
        return null;
    }


}
