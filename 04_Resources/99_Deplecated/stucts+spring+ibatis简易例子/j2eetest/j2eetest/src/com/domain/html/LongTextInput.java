package com.domain.html;

public class LongTextInput extends BaseField implements HtmlRender
{
    public LongTextInput()
    {
        type = "textarea";
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public String render()
    {
        StringBuffer results = new StringBuffer("<textarea");
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
        if(cols != null)
        {
            results.append(" cols=\"");
            results.append(cols);
            results.append("\"");
        }
        if(rows != null)
        {
            results.append(" rows=\"");
            results.append(rows);
            results.append("\"");
        }
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        if(isRequired)
            results.append(" isRequired=\"true\"");
        else
            results.append(" isRequired=\"false\"");
        results.append(">");
        results.append(value);
        results.append("</textarea>");
        return results.toString();
    }

    private void catJavaScript(StringBuffer stringbuffer, String s)
    {
    }
}