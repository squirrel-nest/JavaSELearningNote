package com.domain.html;

public abstract class BaseInput extends BaseHandle
{

    public BaseInput()
    {
        cols = null;
        maxlength = null;
        id = null;
        rows = null;
        value = null;
    }

    public String getCols()
    {
        return cols;
    }

    public void setCols(String cols)
    {
        this.cols = cols;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getMaxlength()
    {
        return maxlength;
    }

    public void setMaxlength(String maxlength)
    {
        this.maxlength = maxlength;
    }

    public String getRows()
    {
        return rows;
    }

    public void setRows(String rows)
    {
        this.rows = rows;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    protected String cols;
    protected String maxlength;
    protected String id;
    protected String rows;
    protected String value;
}