package com.util;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtil4Eos
{
    public static String trim(String s)
    {
        if(s == null)
            return null;
        s = s.trim();
        if(s.length() == 0)
            return null;
        else
            return s;
    }

    public static String replaceStr(String s, String s1, String s2)
    {
        int i = 0;
        boolean flag = false;
        StringBuffer stringbuffer = new StringBuffer();
        if(s != null && s.length() > 0)
        {
            for(int j = s.indexOf(s1, i); j != -1; j = s.indexOf(s1, i))
            {
                stringbuffer.append(s.substring(i, j) + s2);
                i = j + s1.length();
            }

            stringbuffer.append(s.substring(i));
        }
        return stringbuffer.toString();
    }

    public static String cap(String s)
    {
        if(s == null)
        {
            return null;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(Character.toUpperCase(s.charAt(0)));
            stringbuffer.append(s.substring(1).toLowerCase());
            return stringbuffer.toString();
        }
    }

    public static boolean isWord(String s)
    {
        if(s == null)
            return false;
        char ac[] = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
            if(!Character.isLetterOrDigit(ac[i]) && ac[i] != '_')
                return false;

        return true;
    }

    public static boolean isNum(String s)
    {
        if(s == null || s.length() <= 0)
            return false;
        char ac[] = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
            if(!Character.isDigit(ac[i]))
                return false;

        return true;
    }

    public static boolean isNumEx(String s)
    {
        if(s == null || s.length() <= 0)
            return false;
        char ac[] = s.toCharArray();
        int i = 0;
        int j = 0;
        for(; i < s.length(); i++)
            if(!Character.isDigit(ac[i]))
            {
                if(ac[i] != '.')
                    return false;
                if(i == 0 || i == s.length() - 1)
                    return false;
                if(++j > 1)
                    return false;
            }

        return true;
    }

    public static Object getStringStr(String s, int i)
    {
        Vector vector = new Vector();
        Object obj = getStringNumber(s, 0);
        if(obj == null)
            if(i > 1)
                return null;
            else
                return s;
        for(int j = 0; j < ((Vector)obj).size(); j++)
        {
            int k = s.indexOf((String)((Vector)obj).elementAt(j));
            if(k != 0)
                vector.addElement(s.substring(0, k));
            s = s.substring(k + ((String)((Vector)obj).elementAt(j)).length());
        }

        if(s.length() != 0)
            vector.addElement(s);
        if(i <= 0)
            return vector;
        if(i > vector.size())
            return null;
        else
            return vector.elementAt(i - 1);
    }

    public static Object getStringNumber(String s, int i)
    {
        if(s == null)
            return null;
        char ac[] = s.toCharArray();
        String s1 = "";
        Vector vector = new Vector();
        for(int j = 0; j < s.length(); j++)
            if(Character.isDigit(ac[j]))
            {
                s1 = s1 + ac[j];
            } else
            {
                if(!s1.equals(""))
                    vector.addElement(s1);
                s1 = "";
            }

        if(!s1.equals(""))
            vector.addElement(s1);
        if(vector.isEmpty() || i > vector.size())
            return null;
        if(i <= 0)
            return vector;
        else
            return vector.elementAt(i - 1);
    }

    public static String replaceStrEq(String s, String s1, String s2)
    {
        if(s == null || s1 == null || s2 == null)
            return null;
        int i = s.length();
        int j = s1.length();
        int k = s2.length();
        if(i <= 0 || j <= 0 || k <= 0)
            return s;
        if(j != k)
            return s;
        int ai[] = new int[i];
        ai[0] = s.indexOf(s1, 0);
        if(ai[0] == -1)
            return s;
        int l = 1;
        do
        {
            ai[l] = s.indexOf(s1, ai[l - 1] + 1);
            if(ai[l] == -1)
                break;
            l++;
        } while(true);
        char ac[] = s.toCharArray();
        char ac1[] = s2.toCharArray();
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < j; j1++)
                ac[j1 + ai[i1]] = ac1[j1];

        }

        return new String(ac);
    }

    public static String replaceStrEx(String s, String s1, String s2)
    {
        if(s == null || s1 == null || s2 == null)
            return null;
        int i = s.length();
        int j = s1.length();
        int k = s2.length();
        if(i <= 0 || j <= 0 || k < 0)
            return s;
        int ai[] = new int[i];
        ai[0] = s.indexOf(s1, 0);
        if(ai[0] == -1)
            return s;
        int l = 1;
        do
        {
            ai[l] = s.indexOf(s1, ai[l - 1] + 1);
            if(ai[l] == -1)
                break;
            l++;
        } while(true);
        Vector vector = new Vector();
        String s3 = s.substring(0, ai[0]);
        if(s3 != null)
            vector.add(s3);
        int i1 = 1;
        for(i1 = 1; i1 < l; i1++)
            vector.add(s.substring(ai[i1 - 1] + j, ai[i1]));

        vector.add(s.substring(ai[i1 - 1] + j, i));
        StringBuffer stringbuffer = new StringBuffer("");
        for(i1 = 0; i1 < l; i1++)
            stringbuffer.append(vector.get(i1) + s2);

        stringbuffer.append(vector.get(i1));
        return stringbuffer.toString();
    }

    public static String[] splitStr(String s, String s1)
    {
        if(s == null || s.length() <= 0 || s1 == null || s1.length() <= 0)
            return null;
        String as[] = null;
        int ai[] = new int[s.length()];
        ai[0] = s.indexOf(s1, 0);
        if(ai[0] == -1)
        {
            as = new String[1];
            as[0] = s;
            return as;
        }
        int i = 1;
        do
        {
            ai[i] = s.indexOf(s1, ai[i - 1] + 1);
            if(ai[i] == -1)
                break;
            i++;
        } while(true);
        Vector vector = new Vector();
        int j = s1.length();
        boolean flag = false;
        Object obj = null;
        for(int k = 0; k < i + 1; k++)
        {
            String s2;
            if(k == 0)
                s2 = s.substring(0, ai[0]);
            else
            if(k == i)
                s2 = s.substring(ai[k - 1] + j, s.length());
            else
                s2 = s.substring(ai[k - 1] + j, ai[k]);
            if(s2 != null && s2.length() > 0)
                vector.add(s2);
        }

        if(vector.size() <= 0)
            return null;
        as = new String[vector.size()];
        Enumeration enumeration = vector.elements();
        for(int l = 0; enumeration.hasMoreElements(); l++)
            as[l] = (String)enumeration.nextElement();

        return as;
    }

    public static String contactStr(String as[], String s)
    {
        if(as == null || as.length <= 0 || s == null || s.length() <= 0)
            return null;
        StringBuffer stringbuffer = new StringBuffer("");
        for(int i = 0; i < as.length; i++)
            if(i == as.length - 1)
                stringbuffer.append(as[i]);
            else
                stringbuffer.append(as[i] + s);

        return stringbuffer.toString();
    }

    public static String contactStr(int ai[], String s)
    {
        if(ai == null || ai.length <= 0 || s == null || s.length() <= 0)
            return null;
        StringBuffer stringbuffer = new StringBuffer("");
        for(int i = 0; i < ai.length; i++)
            if(i == ai.length - 1)
                stringbuffer.append(new Integer(ai[i]));
            else
                stringbuffer.append(new Integer(ai[i]) + s);

        return stringbuffer.toString();
    }

    public static String[] sortByLength(String as[], boolean flag)
    {
        if(as == null || as.length <= 0)
            return null;
        int i = as.length;
        String as1[] = new String[i];
        for(int j = 0; j < i; j++)
            as1[j] = as[j];

        String s = "";
        boolean flag1 = false;
        boolean flag2 = false;
        for(int k = 0; k < i; k++)
        {
            for(int l = 0; l < i - k - 1; l++)
                if(as1[l].length() > as1[l + 1].length() && flag)
                {
                    String s1 = as1[l];
                    as1[l] = as1[l + 1];
                    as1[l + 1] = s1;
                } else
                if(as1[l].length() < as1[l + 1].length() && !flag)
                {
                    String s2 = as1[l];
                    as1[l] = as1[l + 1];
                    as1[l + 1] = s2;
                }

        }

        return as1;
    }

    public static String compactStr(String s)
    {
        if(s == null)
            return null;
        if(s.length() <= 0)
            return "";
        String s1 = new String(s);
        int i = 0;
        int j = s.length();
        while(s1.charAt(i) == ' ') 
            if(++i >= j)
                break;
        String as[] = splitStr(s1.trim(), " ");
        if(as == null)
            return null;
        boolean flag = false;
        for(int k = 0; k < as.length; k++)
            as[k] = as[k].trim();

        s1 = contactStr(as, " ");
        StringBuffer stringbuffer = new StringBuffer("");
        for(int l = 0; l < i; l++)
            stringbuffer.append(" ");

        return stringbuffer.toString() + s1;
    }

    public static String symbolSBCToDBC(String s)
    {
        if(s == null || s.length() <= 0)
            return s;
        int i = SBC.length >= DBC.length ? DBC.length : SBC.length;
        for(int j = 0; j < i; j++)
            s = replaceStrEx(s, SBC[j], DBC[j]);

        return s;
    }

    public static String symbolDBCToSBC(String s)
    {
        if(s == null || s.length() <= 0)
            return s;
        int i = SBC.length >= DBC.length ? DBC.length : SBC.length;
        for(int j = 0; j < i; j++)
            s = replaceStrEx(s, DBC[j], SBC[j]);

        return s;
    }

    public static boolean isEmailUrl(String s)
    {
        if(s == null || s.length() == 0)
            return false;
        return s.indexOf('@') > 0 && s.indexOf('@') == s.lastIndexOf('@') && s.indexOf('.') > 0 && s.lastIndexOf('.') > s.indexOf('@');
    }

    public static boolean isEmailAddress(String s)
    {
        if(s == null || s.length() <= 0)
            return false;
        boolean flag = false;
        int i = 0;
        char ac[] = s.trim().toCharArray();
        for(int j = 0; j < ac.length; j++)
        {
            if(ac[j] == ' ')
                return false;
            if(ac[j] == '.')
            {
                if(j == 0 || j == ac.length - 1)
                    return false;
            } else
            if(ac[j] == '@' && (++i > 1 || j == 0 || j == ac.length - 1))
                return false;
        }

        return s.indexOf('.') >= s.indexOf('@');
    }

    public static String formatDate(Date date, String s)
    {
        if(date == null || s == null)
        {
            return null;
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
            return simpledateformat.format(date);
        }
    }

    public static String clean(String s)
    {
        if(s == null)
        {
            return null;
        } else
        {
            String s1 = s;
            s1.replace('/', '\uFF0F');
            s1.replace('<', '\u3008');
            s1.replace('>', '\u3009');
            s1.replace('"', '\u201C');
            s1.replace(';', '\uFF1B');
            s1.replace('\'', ' ');
            s1 = replaceStrEx(s1, "&", "*");
            s1 = s1.trim();
            return s1;
        }
    }

    public static String cEmpty(String s)
    {
        if(s == null)
            return "";
        else
            return s;
    }

    public static String cNull(String s)
    {
        if(s == null)
            return null;
        if(s.trim().length() == 0)
            return null;
        else
            return s;
    }

    public static String nullString(String s)
    {
        if(s == null)
            return "Null";
        if(s.trim().length() == 0)
            return "Null";
        else
            return "'" + s.trim() + "'";
    }

    public static String filterString(String s, String s1)
    {
        String s2 = s;
        int j = s1.length();
        int i;
        while((i = s2.indexOf(s1)) != -1) 
            s2 = s2.substring(0, i - 1) + s2.substring(i + j);
        return s2;
    }

    public static int getTotalBytes(String s)
    {
        if(s == null)
            return 0;
        int i = 0;
        byte abyte0[] = s.getBytes();
        for(int j = 0; j < abyte0.length; j++)
            if(abyte0[j] != 0)
                i++;

        return i;
    }

    public static boolean isEmpty(String s)
    {
        if(s == null)
            return true;
        return s.trim().length() == 0;
    }

    public static boolean isStrSuite(String s, String s1)
    {
        s = s.trim();
        s1 = s1.trim();
        String as[] = splitStr(s, " ");
        String as1[] = splitStr(s1, " ");
        return isStringArraySuite(as, as1);
    }

    public static boolean isStringArraySuite(String as[], String as1[])
    {
        if(as.length > as1.length)
            return false;
        for(int i = 0; i < as.length; i++)
            if(!as[i].equals("*") && !as1[i].equals("*") && !as[i].equals(as1[i]))
                return false;

        return true;
    }

    public static String arrToString(Object obj)
    {
        String s = "\nlen=" + Array.getLength(obj);
        for(int i = 0; i < Array.getLength(obj); i++)
            s = s + "\nitem[" + i + "]=" + Array.get(obj, i);

        return s;
    }

    public static String mapToString(Map map)
    {
        String s = "\nlen=" + map.keySet().size();
        for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            s = s + "\nkey[" + obj + "]" + "  value=" + map.get(map.get(obj));
        }

        return s;
    }

    public static boolean isNotNullAndBlank(String s)
    {
        return !isNullOrBlank(s);
    }

    public static boolean isNullOrBlank(String s)
    {
        return isNull(s) || s.equals("") || s.equals("null");
    }

    public static boolean isNull(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isNotNull(String s)
    {
        if(s == null || s.trim().length() == 0)
            return false;
        return !s.trim().equalsIgnoreCase("null");
    }

    public static String ifNullToBlank(String s)
    {
        if(isNotNull(s) && !s.trim().equals("null"))
            return s.trim();
        else
            return "";
    }

    public static String ifNullToBlank(Object obj)
    {
        String s = "";
        String s1 = String.valueOf(obj);
        if(s1 == null || "".equals(s1) || "null".equals(s1) || "NULL".equals(s1))
            s = "";
        else
            s = s1;
        return s;
    }

    public static final String escapeXML(String s)
    {
        if(s == null || s.length() == 0)
            return s;
        char ac[] = s.toCharArray();
        StringBuffer stringbuffer = new StringBuffer(ac.length);
        for(int i = 0; i < ac.length; i++)
        {
            char c = ac[i];
            if(c == '<')
                stringbuffer.append("&lt;");
            else
            if(c == '&')
                stringbuffer.append("&amp;");
            else
            if(c == '"')
                stringbuffer.append("&quot;");
            else
                stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }

    public static String[] splitStrWithBlank(String s, String s1)
    {
        if(s == null)
            return null;
        if(s.trim().equals(""))
            return null;
        ArrayList arraylist = new ArrayList();
        for(int i = 0; (i = s.indexOf(s1)) >= 0;)
        {
            arraylist.add(s.substring(0, i));
            s = s.substring(i + 1, s.length());
        }

        arraylist.add(s);
        String as[] = new String[arraylist.size()];
        arraylist.toArray(as);
        return as;
    }

    public static String setCharAtPosAppendZero(String s, int i, char c)
    {
        if(s == null)
            s = "";
        for(; i > s.length() - 1; s = s + '0');
        String s1;
        if(i == 0)
            s1 = "";
        else
            s1 = s.substring(0, i);
        String s2;
        if(i == s.length() - 1)
            s2 = "";
        else
            s2 = s.substring(i + 1);
        return s1 + c + s2;
    }

    public static void main(String args[])
    {
        System.out.println("s= pos=5 char=a=" + setCharAtPosAppendZero("", 5, 'a'));
        System.out.println("s=abcde pos=0 char=7 =" + setCharAtPosAppendZero("abcde", 0, '7'));
        System.out.println("s=null pos=2 char=a =" + setCharAtPosAppendZero(null, 2, 'a'));
        System.out.println("s=abcde pos=2 char=x =" + setCharAtPosAppendZero("abcde", 2, 'x'));
        System.out.println("s=abcde pos=5 char=x =" + setCharAtPosAppendZero("abcde", 5, 'x'));
        System.out.println("s=abcde pos=6 char=x =" + setCharAtPosAppendZero("abcde", 5, 'x'));
    }

    public static String changeStreamToString(InputStream inputstream, String s)
        throws IOException
    {
        byte abyte0[] = new byte[0x186a0];
        int i = 0;
        do
        {
            int j = inputstream.read(abyte0, i, abyte0.length - i);
            if(j <= 0)
                break;
            i += j;
        } while(true);
        if(i >= abyte0.length - 1)
            throw new IOException("ERROR:The stream size is more than 99,999 bytes");
        else
            return new String(abyte0, 0, i, s);
    }

    static final String SBC[] = {
        "\uFF0C", "\u3002", "\uFF1B", "\u201C", "\u201D", "\uFF1F", "\uFF01", "\uFF08", "\uFF09", "\uFF1A", 
        "\u2014\u2014", "\u3001"
    };
    static final String DBC[] = {
        ",", ".", ";", "\"", "\"", "?", "!", "(", ")", ":", 
        "_", ","
    };

}