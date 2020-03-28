package com.domain.html;

import java.util.List;

public class UserInput extends BaseField implements HtmlRender
{
    public UserInput()
    {
        formName = null;
        selectName = null;
        textValue = null;
        buttonName = null;
        buttonTitle = null;
        buttonValue = null;
        multiple = false;
        readOnly = false;
        size = 0;
    }

    protected String getDefaultStyleClass()
    {
        return null;
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
        if(isRequired)
            results.append(" isRequired=\"true\"");
        else
            results.append(" isRequired=\"false\"");
        results.append(">");
        for(int i = 0; options != null && i < options.size(); i++)
        {
            Option option = (Option)options.get(i);
            results.append(option.render());
        }

        results.append("</select>");
        Button button = new Button();
        button.setName(buttonName);
        button.setValue(buttonValue);
        button.setTitle(buttonTitle);
        String openUrl = "WFCOMMON.pr_automata.WFCOMMON_P_OpenUserSel.do?formName=" + formName + "&selectName=" + selectName;
        if(multiple)
            openUrl = openUrl + "&needMultiple=true";
        else
            openUrl = openUrl + "&needMultiple=false";
        String winName = "window";
        String features = "dialogHeight:530px;dialogWidth:600px;center:yes";
        button.setOnclick("window.showModalDialog('" + openUrl + "'," + winName + ",'" + features + "')");
        results.append(button.render());
        return results.toString();
    }

    private void catJavaScript(StringBuffer stringbuffer, String s)
    {
    }

    public String getButtonName()
    {
        return buttonName;
    }

    public void setButtonName(String buttonName)
    {
        this.buttonName = buttonName;
    }

    public String getButtonTitle()
    {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle)
    {
        this.buttonTitle = buttonTitle;
    }

    public String getButtonValue()
    {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue)
    {
        this.buttonValue = buttonValue;
    }

    public String getFormName()
    {
        return formName;
    }

    public void setFormName(String formName)
    {
        this.formName = formName;
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

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
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

    public String getTextValue()
    {
        return textValue;
    }

    public void setTextValue(String textValue)
    {
        this.textValue = textValue;
    }

    protected String formName;
    protected String selectName;
    protected String textValue;
    protected String buttonName;
    protected String buttonTitle;
    protected String buttonValue;
    protected boolean multiple;
    protected boolean readOnly;
    protected int size;
    protected List options;
}