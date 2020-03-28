/*
 * Copyright (c) 1997.  Sun Microsystems. All rights reserved.
 *
 * Example program that looks up the object bound to a name.
 *     java Search <name_of_object> [attrid attrvalue]*
 */

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Properties;
import java.util.Enumeration;

class Search {
    static void printSearchList(String msg, NamingEnumeration sl) {
	System.out.println(msg);
	if (sl == null) 
	    System.out.println("No matching entries found");
	else {
	    try {
		while (sl.hasMore()) {
		  SearchResult si = (SearchResult)sl.next();
		  /* print its name */
		  System.out.println("Name: " + si.getName());
		  Attrs.printAttrs(si.getAttributes());
		}
	    } catch (NamingException e) {
		System.err.println("Cannot continue listing search results - " + e);
	    }
	}
    }

    public static void main(String[] args) {
        if (args.length < 1) {
	    System.err.println(
		   "usage: java Search <name_of_object> [attrId attrValue]");
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

	    Attributes match = new BasicAttributes();
	    for (int i = 1; i <args.length; i+= 2) {
		match.put(args[i], args[i+1]);
	    }
	    printSearchList(args[0], ctx.search(args[0], match));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
