package com.domain.html;

public abstract class BaseField extends BaseInput
{
    public BaseField()
    {
        accept = null;
        name = null;
        type = null;
        displayName = null;
        regExp = null;
        errMsg = null;
        javaScriptFunc = null;
        isNull = "true";
        isRequired = false;
        fieldType = null;
    }

    public String getAccept()
    {
        return accept;
    }

    public void setAccept(String accept)
    {
        this.accept = accept;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public String getIsNull()
    {
        return isNull;
    }

    public void setIsNull(String isNull)
    {
        this.isNull = isNull;
    }

    public String getJavaScriptFunc()
    {
        return javaScriptFunc;
    }

    public void setJavaScriptFunc(String javaScriptFunc)
    {
        this.javaScriptFunc = javaScriptFunc;
    }

    public String getRegExp()
    {
        return regExp;
    }

    public void setRegExp(String regExp)
    {
        this.regExp = regExp;
    }

    public boolean getIsRequired()
    {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired)
    {
        this.isRequired = isRequired;
    }

    public void catAutoCheckJS(StringBuffer buf, String id, String regexp, String errmsg, String length, String isnull, String usererrmsg, 
            String displayname, String userregexp, String userjavascript)
    {
        buf.append("<script language=\"JavaScript\">");
        if(isnull == null || isnull.equalsIgnoreCase("true"))
            isnull = "true";
        else
            isnull = "false";
        buf.append("var " + id + "_regexp = '" + regexp + "';");
        buf.append("addAutoCheckFunc(new Function(\"return autoEosCheck('" + id + "'," + id + "_regexp, '" + errmsg + "', " + (length != null ? length + ", " : "0, ") + isnull);
        if(usererrmsg != null)
        {
            buf.append(",'");
            buf.append(usererrmsg);
            buf.append("'");
        } else
        {
            buf.append(", null");
        }
        if(displayname != null)
        {
            buf.append(",'");
            buf.append(displayname);
            buf.append("'");
        } else
        {
            buf.append(", null");
        }
        if(userregexp != null)
        {
            buf.append(",'");
            buf.append(userregexp);
            buf.append("',");
        } else
        {
            buf.append(", null, ");
        }
        if(userjavascript != null)
            buf.append(userjavascript);
        else
            buf.append("null");
        buf.append(")\"));</script>");
    }

    public String getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    public void setRequired(boolean isRequired)
    {
        this.isRequired = isRequired;
    }

    protected String accept;
    protected String name;
    protected String type;
    protected String displayName;
    protected String regExp;
    protected String errMsg;
    protected String javaScriptFunc;
    protected String isNull;
    protected boolean isRequired;
    protected String fieldType;
}