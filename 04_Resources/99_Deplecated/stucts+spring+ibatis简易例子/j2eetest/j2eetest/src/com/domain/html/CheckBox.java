package com.domain.html;

import com.util.StringUtil4Eos;

public class CheckBox extends BaseHandle implements HtmlRender
{
    public CheckBox()
    {
        name = null;
        text = null;
        value = null;
        id = null;
        checked = false;
        isRequired = false;
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public String render()
    {
        StringBuffer results = new StringBuffer("<input type=\"checkbox\"");
        results.append(" name=\"");
        results.append(name);
        results.append("\"");
        if(accesskey != null)
        {
            results.append(" accesskey=\"");
            results.append(accesskey);
            results.append("\"");
        }
        if(tabindex != null)
        {
            results.append(" tabindex=\"");
            results.append(tabindex);
            results.append("\"");
        }
        results.append(" value=\"");
        results.append(value);
        results.append("\"");
        String result = StringUtil4Eos.ifNullToBlank(value);
        if(checked || result.equalsIgnoreCase("true") || result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("on"))
            results.append(" checked");
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        if(isRequired)
            results.append(" isRequired=\"true\"");
        else
            results.append(" isRequired=\"false\"");
        results.append("/>");
        return results.toString();
    }

    private void catJavaScript(StringBuffer stringbuffer, String s)
    {
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public boolean getIsRequired()
    {
        return isRequired;
    }

    public void setIsRequired(boolean isRequried)
    {
        isRequired = isRequried;
    }

    protected String name;
    protected String text;
    protected String value;
    protected String id;
    protected boolean checked;
    protected boolean isRequired;
}