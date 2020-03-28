package com.domain.html;

import com.util.StringUtil4Eos;

import java.util.*;

public class HTMLComponent
{
    private static String generatorTextInput(FormField field, String value, String prefix) throws NumberFormatException 
    {
        value = StringUtil4Eos.isNull(value)?StringUtil4Eos.ifNullToBlank(field.getDefaultValue()):value;
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getName());
            else
                hidden.setName(field.getName());
            hidden.setValue(value);
            return hidden.render();
        }
        
        TextInput textInput = new TextInput();
        if(StringUtil4Eos.isNotNull(prefix))
            textInput.setName(prefix + "/" + field.getName());
        else
            textInput.setName(field.getName());
        textInput.setValue(value);
        return textInput.render();
    }

    private static String generatorLongTextInput(FormField field, String value, String prefix) throws NumberFormatException
    {
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        LongTextInput longTextInput = new LongTextInput();
        if(StringUtil4Eos.isNotNull(prefix))
            longTextInput.setName(prefix + "/" + field.getName());
        else
            longTextInput.setName(field.getName());
        longTextInput.setValue(value);
        if(field.getAccessType().equals("read"))
            longTextInput.setReadonly(true);
        longTextInput.setCols("80");
        longTextInput.setRows("5");
        return longTextInput.render();
    }

/*
    private static String generatorNumberInput(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = "";
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return value + hidden.render();
        }
        NumberInput numberInput = new NumberInput();
        if(StringUtil4Eos.isNotNull(prefix))
            numberInput.setName(prefix + "/" + field.getPath());
        else
            numberInput.setName(field.getPath());
        numberInput.setIsRequired(field.isRequired());
        numberInput.setValue(value);
        numberInput.setOnkeypress("return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46");
        numberInput.setOnpaste("return !clipboardData.getData('text').match(/\\D/)");
        return numberInput.render();
    }
*/

    /*
    private static String generatorCheckBox(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = null;
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        if(!"true".equalsIgnoreCase(value) || !"false".equalsIgnoreCase(value) || !"yes".equalsIgnoreCase(value) || !"no".equalsIgnoreCase(value))
            value = "false";
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return value + hidden.render();
        }
        CheckBox checkBox = new CheckBox();
        if(StringUtil4Eos.isNotNull(prefix))
            checkBox.setName(prefix + "/" + field.getPath());
        else
            checkBox.setName(field.getPath());
        if("true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value))
            checkBox.setChecked(true);
        checkBox.setIsRequired(field.isRequired());
        checkBox.setValue(value);
        return checkBox.render();
    }
*/
    
/*
    private static String generatorDate(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = "";
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return value + hidden.render();
        }
        DateInput dateInput = new DateInput();
        if(StringUtil4Eos.isNotNull(prefix))
            dateInput.setTextName(prefix + "/" + field.getPath());
        else
            dateInput.setTextName(field.getPath());
        dateInput.setIsRequired(field.isRequired());
        dateInput.setReadOnly(true);
        dateInput.setTextValue(value);
        return dateInput.render();
    }
*/
    
/*
    private static String generatorEmail(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = "";
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return "<a href=\"mailto:" + value + "\">" + value + "</a>" + hidden.render();
        }
        EmailInput emailInput = new EmailInput();
        if(StringUtil4Eos.isNotNull(prefix))
            emailInput.setName(prefix + "/" + field.getPath());
        else
            emailInput.setName(field.getPath());
        emailInput.setIsRequired(field.isRequired());
        emailInput.setValue(value);
        return emailInput.render();
    }
*/
    
    /*
    private static String generatorUser(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = "";
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return value + hidden.render();
        }
        UserInput userInput = new UserInput();
        if(StringUtil4Eos.isNotNull(prefix))
            userInput.setName(prefix + "/" + field.getPath());
        else
            userInput.setName(field.getPath());
        userInput.setMultiple(false);
        userInput.setSize(1);
        userInput.setFormName(formName);
        if(StringUtil4Eos.isNotNull(prefix))
            userInput.setSelectName(prefix + "/" + field.getPath());
        else
            userInput.setSelectName(field.getPath());
        userInput.setButtonName("\u9009\u62E9\u7528\u6237");
        userInput.setIsRequired(field.isRequired());
        if(!value.equals(""))
        {
            ArrayList optionList = new ArrayList();
            Option option = new Option();
            option.setText(value);
            option.setValue(value);
            optionList.add(option);
            userInput.setOptions(optionList);
        }
        return userInput.render();
    }
*/
    
    private static String generatorSltSelect(FormField field, String value, String prefix) throws NumberFormatException
    {
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        HashMap valueMap = parseFieldAttribute(field.getFieldAttribute());
        Iterator keys = valueMap.keySet().iterator();
        String text = "";
        ArrayList options = new ArrayList();
        Option option;
        for(; keys != null && keys.hasNext(); options.add(option))
        {
            option = new Option();
            option.setText((String)keys.next());
            option.setValue((String)valueMap.get(option.getText()));
            if(option.getValue().equals(value) && !value.equals(""))
            {
                option.setSelected(true);
                text = option.getText();
            }
        }

        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getName());
            else
                hidden.setName(field.getName());
            hidden.setValue(value);
            return text + hidden.render();
        }
        Select select = new Select();
        select.setIsRequired(field.isRequired());
        if(StringUtil4Eos.isNotNull(prefix))
            select.setName(prefix + "/" + field.getName());
        else
            select.setName(field.getName());
        select.setOptions(options);
        return select.render();
    }

    /*
    private static String generatorSltRadio(WFSessionHandle handle, FormField field, String processInstID, String prefix, String formName)
        throws NumberFormatException, WFServiceException
    {
        String value = "";
        if(processInstID != null)
            value = EngineService.getRelativeDataManager().getRelativeData(handle, Integer.parseInt(processInstID), field.getPath());
        value = StringUtil4Eos.isNull(value) ? StringUtil4Eos.ifNullToBlank(field.getDefaultValue()) : value;
        HashMap valueMap = parseFieldAttribute(field.getFieldAttribute());
        Iterator keys = valueMap.keySet().iterator();
        String text = "";
        ArrayList radios = new ArrayList();
        RadioBox radio;
        for(; keys != null && keys.hasNext(); radios.add(radio))
        {
            radio = new RadioBox();
            String tempText = (String)keys.next();
            String tempValue = (String)valueMap.get(tempText);
            radio.setName(prefix + "/" + field.getPath());
            radio.setValue(tempValue);
            radio.setText(tempText);
            if(tempValue.equals(value) && !value.equals(""))
            {
                text = tempText;
                radio.setChecked(true);
            }
        }

        if(field.getAccessType().equals("read"))
        {
            Hidden hidden = new Hidden();
            if(StringUtil4Eos.isNotNull(prefix))
                hidden.setName(prefix + "/" + field.getPath());
            else
                hidden.setName(field.getPath());
            hidden.setValue(value);
            return text + hidden.render();
        }
        StringBuffer radioBuffer = new StringBuffer();
        for(int i = 0; radios != null && i < radios.size(); i++)
        {
            RadioBox radio = (RadioBox)radios.get(i);
            radioBuffer.append(radio.getText() + radio.render());
        }

        return radioBuffer.toString();
    }
*/
    private static HashMap parseFieldAttribute(String fieldAttribute)
    {
        HashMap map = new HashMap();
        String rows[] = StringUtil4Eos.splitStr(fieldAttribute, ";");
        for(int i = 0; rows != null && i < rows.length; i++)
        {
            String colums[] = rows[i].split(",");
            if(colums.length > 0)
            {
                String value = colums.length < 1 ? "" : colums[0];
                String key = colums.length < 2 ? "" : colums[1];
                map.put(key, value);
            }
        }

        return map;
    }

    public static void main(String args[])
    {
    	String fieldAttribute = "shanghai,北京;beijing,\u5317\u4EAC;guangzhou,\u5E7F\u5DDE,changsha,\u957F\u6C99";
    	FormField field = new FormField();
    	field.setName("test");
    	field.setDataType("Select");
    	field.setDefaultValue("");
    	field.setFieldAttribute(fieldAttribute);//DICT需要
    	//System.out.println(generatorHTMLComponent(field, "", "TEST"));

/*    	
        String fieldAttribute = "shanghai,\u4E0A\u6D77;beijing,\u5317\u4EAC;guangzhou,\u5E7F\u5DDE,changsha,\u957F\u6C99";
        String rows[] = StringUtil4Eos.splitStr(fieldAttribute, ";");
        for(int i = 0; rows != null && i < rows.length; i++)
        {
            String colums[] = rows[i].split(",");
            if(colums.length > 0)
            {
                String value = colums.length < 1 ? "" : colums[0];
                String key = colums.length < 2 ? "" : colums[1];
               // System.out.println("value=" + value + "  " + "key=" + key);
            }
        }
*/
    }

    public static String generatorHTMLComponent(FormField field, String value, String prefix) throws NumberFormatException {
        if(field == null)
            return "";
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("textInput"))
            return generatorTextInput(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("longTextInput"))
            return generatorLongTextInput(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("Select"))
            return generatorSltSelect(field, value, prefix);
        else
            return "&nbsp;";
/*
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("numberInput"))
            return generatorNumberInput(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("checkBox"))
            return generatorCheckBox(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("date"))
            return generatorDate(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("email"))
            return generatorEmail(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("user"))
            return generatorUser(field, value, prefix);
        if(StringUtil4Eos.ifNullToBlank(field.getDataType()).equals("sltRadio"))
            return generatorSltRadio(field, value, prefix);
*/
    }
}