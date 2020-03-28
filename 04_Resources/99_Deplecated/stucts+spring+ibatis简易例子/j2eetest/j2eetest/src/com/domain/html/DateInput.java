package com.domain.html;

import java.io.PrintStream;

public class DateInput implements HtmlRender
{
    public DateInput()
    {
        textName = null;
        textValue = null;
        year = null;
        month = null;
        dateFormat = "YYYMMDD";
        readOnly = false;
        isRequired = false;
    }

    protected String getDefaultStyleClass()
    {
        return null;
    }

    public String render()
    {
        StringBuffer results = new StringBuffer();
        results.append("<input type=\"text\" name=\"");
        results.append(getTextName());
        results.append("\" value=\"");
        results.append(getTextValue());
        results.append("\" readOnly=\"true\" dtype=\"d(").append(dateFormat).append(")\" size=\"10\">\r\n");
        results.append("<img style=cursor:hand; border=0 src=\"/internet/WFCOMMON/images/date_icon.gif\" onClick=\"showCalendar(this)\" bindingFld=\"").append(getTextName()).append("\" >\r\n");
        return results.toString();
    }

    private void catJavaScript(StringBuffer stringbuffer, String s)
    {
    }

    public String getDateFormat()
    {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getTextName()
    {
        return textName;
    }

    public void setTextName(String textName)
    {
        this.textName = textName;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getTextValue()
    {
        return textValue;
    }

    public void setTextValue(String textValue)
    {
        this.textValue = textValue;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public boolean getIsRequired()
    {
        return isRequired;
    }

    public void setIsRequired(boolean isRequried)
    {
        isRequired = isRequried;
    }

    public static void main(String args[])
    {
        DateInput date = new DateInput();
        date.setTextName("startDate");
        date.setTextValue("20040805");
        date.setReadOnly(true);
      //  System.out.println(date.render());
    }

    protected String textName;
    protected String textValue;
    protected String year;
    protected String month;
    protected String dateFormat;
    protected boolean readOnly;
    protected boolean isRequired;
}