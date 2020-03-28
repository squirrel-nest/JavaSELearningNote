package com.domain.html;

public class Option implements HtmlRender
{
    public Option()
    {
        text = null;
        value = null;
        disabled = false;
        selected = false;
    }

    public String render()
    {
        StringBuffer result = new StringBuffer("<option value=\"");
        result.append(value);
        result.append("\"");
        if(selected)
            result.append(" selected");
        result.append(">");
        result.append(text);
        result.append("</option>");
        return result.toString();
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    protected String text;
    protected String value;
    protected boolean disabled;
    protected boolean selected;
}