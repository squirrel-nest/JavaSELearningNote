package com.domain.html;

public class TextInput extends BaseField implements HtmlRender
{
    public TextInput()
    {
        type = "text";
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public String render()
    {
        StringBuffer results = new StringBuffer("<input type=\"");
        results.append(type);
        results.append("\" name=\"");
        results.append(name);
        results.append("\"");
        if(accesskey != null)
        {
            results.append(" accesskey=\"");
            results.append(accesskey);
            results.append("\"");
        }
        if(accept != null)
        {
            results.append(" accept=\"");
            results.append(accept);
            results.append("\"");
        }
        if(maxlength != null)
        {
            results.append(" maxlength=\"");
            results.append(maxlength);
            results.append("\"");
        }
        if(cols != null)
        {
            results.append(" size=\"");
            results.append(cols);
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
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        if(id != null)
        {
            results.append(" id=\"");
            results.append(id);
            results.append("\"");
        }
        if(isRequired)
            results.append(" isRequired=\"true\"");
        else
            results.append(" isRequired=\"false\"");
        results.append(">");
        return results.toString();
    }

    private void catJavaScript(StringBuffer stringbuffer, String s)
    {
    }
}