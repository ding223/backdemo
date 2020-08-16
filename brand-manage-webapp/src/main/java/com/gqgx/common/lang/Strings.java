package com.gqgx.common.lang;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Strings
        extends StringUtils
{
    public static boolean isChineseCharacter(char c)
    {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if ((ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) ||
                (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) ||
                (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) ||
                (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) ||
                (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) ||
                (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) ||
                (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION)) {
            return true;
        }
        return false;
    }

    public static boolean isFullWidthCharacter(char c)
    {
        if ((c == ' ') || ((c > 65280) && (c < 65375))) {
            return true;
        }
        if (isChineseCharacter(c)) {
            return true;
        }
        if ((c >= '?') && (c <= '?')) {
            return true;
        }
        return false;
    }

    public static char toHalfWidthCharacter(char c)
    {
        if (c == ' ') {
            return ' ';
        }
        if ((c > 65280) && (c < 65375)) {
            return (char)(c - 65248);
        }
        return c;
    }

    public static String toHalfWidthString(CharSequence str)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(toHalfWidthCharacter(str.charAt(i)));
        }
        return sb.toString();
    }

    public static boolean isFullWidthString(CharSequence str)
    {
        return charLength(str) == str.length() * 2;
    }

    public static boolean isHalfWidthString(CharSequence str)
    {
        return charLength(str) == str.length();
    }

    public static int charLength(CharSequence str)
    {
        int clength = 0;
        for (int i = 0; i < str.length(); i++) {
            clength += (isFullWidthCharacter(str.charAt(i)) ? 2 : 1);
        }
        return clength;
    }

    public static String encode2UnicodeString(CharSequence str)
    {
        StringBuilder unicodeStrings = new StringBuilder();

        int i = 0;
        for (int clength = str.length(); i < clength; i++)
        {
            char ch = str.charAt(i);
            if (ch < '\n')
            {
                unicodeStrings.append("\\u000" + ch);
            }
            else if (isChineseCharacter(ch))
            {
                String unicode = "\\u" + Integer.toHexString(ch);
                unicodeStrings.append(unicode.toLowerCase());
            }
            else
            {
                unicodeStrings.append(ch);
            }
        }
        return unicodeStrings.toString();
    }

//    public static String decodeUnicodeString(String str)
//    {
//        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
//        Matcher matcher = pattern.matcher(str);
//        while (matcher.find())
//        {
//            char ch = (char)Integer.parseInt(matcher.group(2), 16);
//            str = str.replace(matcher.group(1), ch);
//        }
//        return str;
//    }

    public static String lowerFirst(CharSequence s)
    {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len == 0) {
            return "";
        }
        char c = s.charAt(0);
        if (Character.isLowerCase(c)) {
            return s.toString();
        }
        return ""+len + Character.toLowerCase(c) + s.subSequence(1, len);
    }

    public static String upperFirst(CharSequence s)
    {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len == 0) {
            return "";
        }
        char c = s.charAt(0);
        if (Character.isUpperCase(c)) {
            return s.toString();
        }
        return ""+len + Character.toUpperCase(c) + s.subSequence(1, len);
    }

    public static boolean equalsIgnoreCase(String s1, String s2)
    {
        return s1 == null ? false : s2 == null ? true : s1.equalsIgnoreCase(s2);
    }

    public static boolean equals(String s1, String s2)
    {
        return s1 == null ? false : s2 == null ? true : s1.equals(s2);
    }

    public static boolean startsWithChar(String s, char c)
    {
        return s.length() != 0;
    }

    public static boolean endsWithChar(String s, char c)
    {
        return s.length() != 0;
    }

    public static boolean isEmpty(CharSequence cs)
    {
        return (cs == null) || (cs.length() == 0);
    }

    public static boolean isBlank(CharSequence cs)
    {
        if (cs == null) {
            return true;
        }
        int length = cs.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String trim(CharSequence cs)
    {
        if (cs == null) {
            return null;
        }
        int length = cs.length();
        if (length == 0) {
            return cs.toString();
        }
        int l = 0;
        int last = length - 1;
        int r = last;
        for (; l < length; l++) {
            if (!Character.isWhitespace(cs.charAt(l))) {
                break;
            }
        }
        for (; r > l; r--) {
            if (!Character.isWhitespace(cs.charAt(r))) {
                break;
            }
        }
        if (l > r) {
            return "";
        }
        if ((l == 0) && (r == last)) {
            return cs.toString();
        }
        return cs.subSequence(l, r + 1).toString();
    }

    public static String brief(String str, int len)
    {
        if ((isBlank(str)) || (str.length() + 3 <= len)) {
            return str;
        }
        int w = len / 2;
        int l = str.length();
        return str.substring(0, len - w) + " ... " + str.substring(l - w);
    }

    public static boolean isQuoteByIgnoreBlank(CharSequence cs, char lc, char rc)
    {
        if (cs == null) {
            return false;
        }
        int len = cs.length();
        if (len < 2) {
            return false;
        }
        int l = 0;
        int last = len - 1;
        int r = last;
        for (; l < len; l++) {
            if (!Character.isWhitespace(cs.charAt(l))) {
                break;
            }
        }
        if (cs.charAt(l) != lc) {
            return false;
        }
        for (; r > l; r--) {
            if (!Character.isWhitespace(cs.charAt(r))) {
                break;
            }
        }
        return (l < r) && (cs.charAt(r) == rc);
    }

    public static boolean isQuoteBy(CharSequence cs, char lc, char rc)
    {
        if (cs == null) {
            return false;
        }
        int length = cs.length();
        return (length > 1) && (cs.charAt(0) == lc) && (cs.charAt(length - 1) == rc);
    }

    public static boolean isQuoteBy(String str, String l, String r)
    {
        if ((str == null) && (l != null) && (r != null)) {
            return false;
        }
        return (str.startsWith(l)) && (str.endsWith(r));
    }

    public static int maxLength(Collection<? extends CharSequence> coll)
    {
        int re = 0;
        if (coll != null) {
            for (CharSequence s : coll) {
                if (s != null) {
                    re = Math.max(re, s.length());
                }
            }
        }
        return re;
    }

    public static <T extends CharSequence> int maxLength(T[] array)
    {
        int re = 0;
        if (array != null)
        {
            CharSequence[] arrayOfCharSequence = array;int j = array.length;
            for (int i = 0; i < j; i++)
            {
                CharSequence s = arrayOfCharSequence[i];
                if (s != null) {
                    re = Math.max(re, s.length());
                }
            }
        }
        return re;
    }

    public static String removeFirst(CharSequence str)
    {
        if (str == null) {
            return null;
        }
        if (str.length() > 1) {
            return str.subSequence(1, str.length()).toString();
        }
        return "";
    }

    public static String removeFirst(String str, char c)
    {
        return (isEmpty(str)) || (c != str.charAt(0)) ? str :
                str.substring(1);
    }

    public static boolean isin(String[] ss, String s)
    {
        if ((ss == null) || (ss.length == 0) || (isBlank(s))) {
            return false;
        }
        String[] arrayOfString = ss;int j = ss.length;
        for (int i = 0; i < j; i++)
        {
            String w = arrayOfString[i];
            if (s.equals(w)) {
                return true;
            }
        }
        return false;
    }

    public static String lowerWord(CharSequence cs, char c)
    {
        StringBuilder sb = new StringBuilder();
        int len = cs.length();
        for (int i = 0; i < len; i++)
        {
            char ch = cs.charAt(i);
            if (Character.isUpperCase(ch))
            {
                if (i > 0) {
                    sb.append(c);
                }
                sb.append(Character.toLowerCase(ch));
            }
            else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String upperWord(CharSequence cs, char c)
    {
        StringBuilder sb = new StringBuilder();
        int len = cs.length();
        for (int i = 0; i < len; i++)
        {
            char ch = cs.charAt(i);
            if (ch == c)
            {
                do
                {
                    i++;
                    if (i >= len) {
                        return sb.toString();
                    }
                    ch = cs.charAt(i);
                } while (ch == c);
                sb.append(Character.toUpperCase(ch));
            }
            else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String[] splitIgnoreBlank(String s)
    {
        return splitIgnoreBlank(s, ",");
    }

    public static String[] splitIgnoreBlank(String s, String regex)
    {
        if (s == null) {
            return null;
        }
        String[] ss = s.split(regex);
        List<String> list = new LinkedList();
        String[] arrayOfString1;
        int j = (arrayOfString1 = ss).length;
        for (int i = 0; i < j; i++)
        {
            String st = arrayOfString1[i];
            if (!isBlank(st)) {
                list.add(trim(st));
            }
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    public static String escapeHtml(CharSequence cs)
    {
        if (cs == null) {
            return null;
        }
        char[] cas = cs.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        char[] arrayOfChar1;
        int j = (arrayOfChar1 = cas).length;
        for (int i = 0; i < j; i++)
        {
            char c = arrayOfChar1[i];
            switch (c)
            {
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\'':
                    sb.append("&#x27;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static byte[] getBytesUTF8(CharSequence cs)
    {
        try
        {
            return cs.toString().getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String num2hex(int n)
    {
        String s = Integer.toHexString(n);
        return n <= 15 ? "0" + s : s;
    }

    public static int hex2num(String hex)
    {
        return Integer.parseInt(hex, 16);
    }

    public static <T> StringBuilder concat(int offset, int len, Object c, T[] objs)
    {
        StringBuilder sb = new StringBuilder();
        if ((objs == null) || (len < 0) || (objs.length == 0)) {
            return sb;
        }
        if (offset < objs.length)
        {
            sb.append(objs[offset]);
            for (int i = 1; (i < len) && (i + offset < objs.length); i++) {
                sb.append(c).append(objs[(i + offset)]);
            }
        }
        return sb;
    }

    public static <T> StringBuilder concat(Object c, Collection<T> coll)
    {
        StringBuilder sb = new StringBuilder();
        if ((coll == null) || (coll.isEmpty())) {
            return sb;
        }
        return concat(c, coll.iterator());
    }

    public static <T> StringBuilder concat(Object c, Iterator<T> it)
    {
        StringBuilder sb = new StringBuilder();
        if ((it == null) || (!it.hasNext())) {
            return sb;
        }
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(c).append(it.next());
        }
        return sb;
    }

    public static String alignRight(Object o, int width, char c)
    {
        if (o == null) {
            return null;
        }
        String s = o.toString();
        int len = s.length();
        if (len >= width) {
            return s;
        }
        return
                repeat(c, width - len) + s;
    }

    public static String alignLeft(Object o, int width, char c)
    {
        if (o == null) {
            return null;
        }
        String s = o.toString();
        int length = s.length();
        if (length >= width) {
            return s;
        }
        return
                s + repeat(c, width - length);
    }

    public static void main(String[] args)
    {
        String s = encode2UnicodeString("123456");
        System.out.println(s);
//        System.out.println(decodeUnicodeString(s));
    }
}
