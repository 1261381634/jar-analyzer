/*
 * MIT License
 *
 * Copyright (c) 2023-2024 4ra1n (Jar Analyzer Team)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.n1ar4.dbg.utils;

import org.objectweb.asm.Type;

@SuppressWarnings("all")
public class ASMUtil {
    public static String convertMethodDesc(String methodName, String methodDesc) {
        StringBuilder sb = new StringBuilder();

        Type returnType = Type.getReturnType(methodDesc);
        String className = returnType.getClassName();
        int lastDotIndex = className.lastIndexOf('.');
        String finalClassName = className.substring(lastDotIndex + 1);

        sb.append("<html>");
        return getString(methodName, methodDesc, sb, finalClassName);
    }

    private static String getString(String methodName, String methodDesc, StringBuilder sb, String finalClassName) {
        String className;
        int lastDotIndex;
        sb.append("<font style=\"color: blue; font-weight: bold;\">");
        sb.append(finalClassName);
        sb.append("</font>");

        sb.append(" ");

        Type[] argumentTypes = Type.getArgumentTypes(methodDesc);
        sb.append("<font style=\"color: red; font-weight: bold;\">");
        if (methodName.equals("<init>")) {
            methodName = "[init]";
        }
        if (methodName.equals("<clinit>")) {
            methodName = "[clinit]";
        }
        sb.append(methodName);
        sb.append("</font>");
        sb.append("(");
        for (int i = 0; i < argumentTypes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            className = argumentTypes[i].getClassName();
            lastDotIndex = className.lastIndexOf('.');
            finalClassName = className.substring(lastDotIndex + 1);
            sb.append(finalClassName);
        }
        sb.append(")");
        sb.append("</html>");

        return sb.toString();
    }

    public static String convertMethodDescWithClass(String owner, String methodName, String methodDesc) {
        StringBuilder sb = new StringBuilder();

        Type returnType = Type.getReturnType(methodDesc);
        String className = returnType.getClassName();
        int lastDotIndex = className.lastIndexOf('.');
        String finalClassName = className.substring(lastDotIndex + 1);

        sb.append("<html>");
        sb.append("<font style=\"color: orange; font-weight: bold;\">");
        sb.append(owner);
        sb.append("</font>");
        sb.append("\t");
        return getString(methodName, methodDesc, sb, finalClassName);
    }

    public static String renderClass(String className) {
        return "<html><font style=\"color: blue; font-weight: bold;\">" + className + "</html>";
    }
}