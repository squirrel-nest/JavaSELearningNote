package com.domain.html;

public abstract class BaseHandle
{

    public BaseHandle()
    {
        accesskey = null;
        tabindex = null;
        indexed = false;
        onclick = null;
        ondblclick = null;
        onmouseover = null;
        onmouseout = null;
        onmousemove = null;
        onmousedown = null;
        onmouseup = null;
        onpaste = null;
        onkeydown = null;
        onkeyup = null;
        onkeypress = null;
        onselect = null;
        onchange = null;
        onblur = null;
        onfocus = null;
        disabled = false;
        readonly = false;
        style = null;
        styleClass = null;
        styleId = null;
        title = null;
        accesskey = null;
        tabindex = null;
        onclick = null;
        ondblclick = null;
        onmouseover = null;
        onmouseout = null;
        onmousemove = null;
        onmousedown = null;
        onmouseup = null;
        onkeydown = null;
        onkeyup = null;
        onkeypress = null;
        onselect = null;
        onchange = null;
        onblur = null;
        onfocus = null;
        disabled = false;
        readonly = false;
        style = null;
        styleClass = null;
        styleId = null;
        title = null;
        indexed = false;
    }

    public void setAccesskey(String accessKey)
    {
        accesskey = accessKey;
    }

    public String getAccesskey()
    {
        return accesskey;
    }

    public void setTabindex(String tabIndex)
    {
        tabindex = tabIndex;
    }

    public String getTabindex()
    {
        return tabindex;
    }

    public void setIndexed(boolean indexed)
    {
        this.indexed = indexed;
    }

    public boolean getIndexed()
    {
        return indexed;
    }

    public void setOnclick(String onClick)
    {
        onclick = onClick;
    }

    public String getOnclick()
    {
        return onclick;
    }

    public void setOndblclick(String onDblClick)
    {
        ondblclick = onDblClick;
    }

    public String getOndblclick()
    {
        return ondblclick;
    }

    public void setOnmousedown(String onMouseDown)
    {
        onmousedown = onMouseDown;
    }

    public String getOnmousedown()
    {
        return onmousedown;
    }

    public void setOnmouseup(String onMouseUp)
    {
        onmouseup = onMouseUp;
    }

    public void setOnpaste(String onPaste)
    {
        onpaste = onPaste;
    }

    public String getOnmouseup()
    {
        return onmouseup;
    }

    public void setOnmousemove(String onMouseMove)
    {
        onmousemove = onMouseMove;
    }

    public String getOnmousemove()
    {
        return onmousemove;
    }

    public void setOnmouseover(String onMouseOver)
    {
        onmouseover = onMouseOver;
    }

    public String getOnmouseover()
    {
        return onmouseover;
    }

    public void setOnmouseout(String onMouseOut)
    {
        onmouseout = onMouseOut;
    }

    public String getOnmouseout()
    {
        return onmouseout;
    }

    public void setOnkeydown(String onKeyDown)
    {
        onkeydown = onKeyDown;
    }

    public String getOnkeydown()
    {
        return onkeydown;
    }

    public void setOnkeyup(String onKeyUp)
    {
        onkeyup = onKeyUp;
    }

    public String getOnkeyup()
    {
        return onkeyup;
    }

    public void setOnkeypress(String onKeyPress)
    {
        onkeypress = onKeyPress;
    }

    public String getOnkeypress()
    {
        return onkeypress;
    }

    public void setOnchange(String onChange)
    {
        onchange = onChange;
    }

    public String getOnchange()
    {
        return onchange;
    }

    public void setOnselect(String onSelect)
    {
        onselect = onSelect;
    }

    public String getOnselect()
    {
        return onselect;
    }

    public void setOnblur(String onBlur)
    {
        onblur = onBlur;
    }

    public String getOnblur()
    {
        return onblur;
    }

    public void setOnfocus(String onFocus)
    {
        onfocus = onFocus;
    }

    public String getOnfocus()
    {
        return onfocus;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    public boolean getDisabled()
    {
        return disabled;
    }

    public void setReadonly(boolean readonly)
    {
        this.readonly = readonly;
    }

    public boolean getReadonly()
    {
        return readonly;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyleClass(String styleClass)
    {
        this.styleClass = styleClass;
    }

    public String getStyleClass()
    {
        return styleClass;
    }

    public void setStyleId(String styleId)
    {
        this.styleId = styleId;
    }

    public String getStyleId()
    {
        return styleId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    protected String prepareStyles()
    {
        StringBuffer styles = new StringBuffer();
        if(style != null)
        {
            styles.append(" style=\"");
            styles.append(style);
            styles.append("\"");
        }
        if(styleClass == null)
            styleClass = getDefaultStyleClass();
        if(styleClass != null)
        {
            styles.append(" class=\"");
            styles.append(styleClass);
            styles.append("\"");
        }
        if(styleId != null)
        {
            styles.append(" id=\"");
            styles.append(styleId);
            styles.append("\"");
        }
        if(title != null)
        {
            styles.append(" title=\"");
            styles.append(title);
            styles.append("\"");
        }
        return styles.toString();
    }

    protected String prepareEventHandlers()
    {
        StringBuffer handlers = new StringBuffer();
        prepareClipboardEvents(handlers);
        prepareMouseEvents(handlers);
        prepareKeyEvents(handlers);
        prepareTextEvents(handlers);
        prepareFocusEvents(handlers);
        return handlers.toString();
    }

    protected void prepareClipboardEvents(StringBuffer handlers)
    {
        if(onpaste != null)
        {
            handlers.append(" onpaste=\"");
            handlers.append(onpaste);
            handlers.append("\"");
        }
    }

    protected void prepareMouseEvents(StringBuffer handlers)
    {
        if(onclick != null)
        {
            handlers.append(" onclick=\"");
            handlers.append(onclick);
            handlers.append("\"");
        }
        if(ondblclick != null)
        {
            handlers.append(" ondblclick=\"");
            handlers.append(ondblclick);
            handlers.append("\"");
        }
        if(onmouseover != null)
        {
            handlers.append(" onmouseover=\"");
            handlers.append(onmouseover);
            handlers.append("\"");
        }
        if(onmouseout != null)
        {
            handlers.append(" onmouseout=\"");
            handlers.append(onmouseout);
            handlers.append("\"");
        }
        if(onmousemove != null)
        {
            handlers.append(" onmousemove=\"");
            handlers.append(onmousemove);
            handlers.append("\"");
        }
        if(onmousedown != null)
        {
            handlers.append(" onmousedown=\"");
            handlers.append(onmousedown);
            handlers.append("\"");
        }
        if(onmouseup != null)
        {
            handlers.append(" onmouseup=\"");
            handlers.append(onmouseup);
            handlers.append("\"");
        }
    }

    protected void prepareKeyEvents(StringBuffer handlers)
    {
        if(onkeydown != null)
        {
            handlers.append(" onkeydown=\"");
            handlers.append(onkeydown);
            handlers.append("\"");
        }
        if(onkeyup != null)
        {
            handlers.append(" onkeyup=\"");
            handlers.append(onkeyup);
            handlers.append("\"");
        }
        if(onkeypress != null)
        {
            handlers.append(" onkeypress=\"");
            handlers.append(onkeypress);
            handlers.append("\"");
        }
    }

    protected void prepareTextEvents(StringBuffer handlers)
    {
        if(onselect != null)
        {
            handlers.append(" onselect=\"");
            handlers.append(onselect);
            handlers.append("\"");
        }
        if(onchange != null)
        {
            handlers.append(" onchange=\"");
            handlers.append(onchange);
            handlers.append("\"");
        }
    }

    protected void prepareFocusEvents(StringBuffer handlers)
    {
        if(onblur != null)
        {
            handlers.append(" onblur=\"");
            handlers.append(onblur);
            handlers.append("\"");
        }
        if(onfocus != null)
        {
            handlers.append(" onfocus=\"");
            handlers.append(onfocus);
            handlers.append("\"");
        }
        if(disabled)
            handlers.append(" disabled=\"disabled\"");
        if(readonly)
            handlers.append(" readonly=\"readonly\"");
    }

    protected abstract String getDefaultStyleClass();

    protected String accesskey;
    protected String tabindex;
    protected boolean indexed;
    private String onclick;
    private String ondblclick;
    private String onmouseover;
    private String onmouseout;
    private String onmousemove;
    private String onmousedown;
    private String onmouseup;
    private String onpaste;
    private String onkeydown;
    private String onkeyup;
    private String onkeypress;
    private String onselect;
    private String onchange;
    private String onblur;
    private String onfocus;
    private boolean disabled;
    private boolean readonly;
    private String style;
    private String styleClass;
    private String styleId;
    private String title;
}