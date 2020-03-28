package com.domain.html;

public class Button extends BaseHandle implements HtmlRender
{

    public Button()
    {
        name = null;
        text = null;
        value = null;
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public String render()
    {
        String label = value;
        if(label == null && text != null)
            label = text;
        if(label == null || label.trim().length() < 1)
            label = "Click";
        StringBuffer results = new StringBuffer();
        results.append("<input type=\"button\"");
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
        results.append(label);
        results.append("\"");
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(">");
        return results.toString();
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

    protected String name;
    protected String text;
    protected String value;
}