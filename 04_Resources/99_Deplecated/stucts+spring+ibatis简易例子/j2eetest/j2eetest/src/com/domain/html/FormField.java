package com.domain.html;

public class FormField
{

    String name;
    String path;
    String dataType;
    String accessType;
    String description;
    String defaultValue;
    String fieldAttribute;
    boolean required;
    
    public FormField()
    {
        name = "";
        path = "";
        dataType = "";
        accessType = "";
        description = "";
        defaultValue = "";
        fieldAttribute = "";
    }

    public String getAccessType()
    {
        return accessType;
    }

    public String getDataType()
    {
        return dataType;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public String getFieldAttribute()
    {
        return fieldAttribute;
    }

    public boolean isRequired()
    {
        return required;
    }

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFieldAttribute(String fieldAttribute) {
		this.fieldAttribute = fieldAttribute;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}