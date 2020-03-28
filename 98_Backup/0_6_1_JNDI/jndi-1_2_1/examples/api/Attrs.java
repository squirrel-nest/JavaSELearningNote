/*
 * Copyright (c) 1997.  Sun Microsystems. All rights reserved.
 *
 * Example program that displays the attributes of a named object.
 *     java Attrs <name_of_object>
 */

import javax.naming.*;
import javax.naming.directory.*;

import java.util.Properties;
import java.util.Enumeration;

class Attrs {
    static void printAttrs(Attributes attrs) {
	if (attrs == null) {
	    System.out.println("No attributes");
	} else {
	    /* print each attribute */
	    try {
		for (NamingEnumeration ae = attrs.getAll();
		     ae != null && ae.hasMoreElements();) {
		    Attribute attr = (Attribute)ae.next();
		    System.out.println("attribute: " + attr.getID());

		    /* print each value */
		    for (NamingEnumeration e = attr.getAll();
			 e.hasMoreElements();
			 System.out.println("value: " + e.nextElement()))
			;
		}
	    } catch (NamingException e) {
		e.printStackTrace();
	    }
	}
    }

    public static void main(String[] args) {
        if (args.length < 1) {
	    System.err.println("usage: java Attrs <name>");
	    System.exit(-1);
	}

	// Retrieve any jndi environment properties from system properties.
	// 
	// This approach of using system properties here is for
	// expediency only and not meant to be prescriptive.  This is
	// only one of the many ways to set up environment properties.

	Properties env = System.getProperties();

	try {
	    DirContext ctx = new InitialDirContext(env);
	    Attributes answer = null;

	    if (args.length > 1) {
		String[] ids = new String[args.length-1];
		System.arraycopy(args, 1, ids, 0, ids.length);
		answer = ctx.getAttributes(args[0], ids);
	    } else {
		answer = ctx.getAttributes(args[0]);
	    }
	    printAttrs(answer);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
