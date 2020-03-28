package com.domain.html;

import java.util.List;

public class Select extends BaseField implements HtmlRender
{
    public Select()
    {
        multiple = false;
        selectName = null;
        size = 0;
    }

    public String render()
    {
        StringBuffer results = new StringBuffer("<select");
        results.append(" name=\"");
        results.append(name);
        results.append("\"");
        if(accesskey != null)
        {
            results.append(" accesskey=\"");
            results.append(accesskey);
            results.append("\"");
        }
        if(multiple)
            results.append(" multiple=\"multiple\"");
        if(size != 0)
        {
            results.append(" size=\"");
            results.append(size);
            results.append("\"");
        }
        if(tabindex != null)
        {
            results.append(" tabindex=\"");
            results.append(tabindex);
            results.append("\"");
        }
        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        results.append(">");
        for(int i = 0; options != null && i < options.size(); i++)
        {
            Option option = (Option)options.get(i);
            results.append(option.render());
        }

        results.append("</select>");
        return results.toString();
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public boolean isMultiple()
    {
        return multiple;
    }

    public void setMultiple(boolean multiple)
    {
        this.multiple = multiple;
    }

    public List getOptions()
    {
        return options;
    }

    public void setOptions(List options)
    {
        this.options = options;
    }

    public String getSelectName()
    {
        return selectName;
    }

    public void setSelectName(String selectName)
    {
        this.selectName = selectName;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    protected boolean multiple;
    protected String selectName;
    protected int size;
    protected List options;
}