/*
 * Copyright (c) 1997.  Sun Microsystems. All rights reserved.
 *
 * Example program that displays the contents of a named context.
 *     java List [-b] [<name_of_context>]
 * If -b is specified, list object name and the object to which it is bound
 * If -b is omitted, list object name and class.
 * If name_of_context is omitted, list the contents of the initial context.
 */
 
import javax.naming.*;
import java.util.Properties;

class List {
    static void printNameList(String msg, NamingEnumeration nl) {
	System.out.println(msg);
	if (nl == null) 
	    System.out.println("No items in name list");
	else {
	    try {
		while (nl.hasMore())
		    System.out.println(nl.next());
	    } catch (NamingException e) {
		e.printStackTrace();
	    }
	}
    }

    static void printBindingList(String msg, NamingEnumeration bl) {
	System.out.println(msg);
	if (bl == null) 
	    System.out.println("No items in binding list");
	else {
	  try {
	    while (bl.hasMore()) {
	      Binding b = (Binding)bl.next();
	      System.out.println(b.getName() + "(" + b.getObject() + ")");
	    }
	  } catch (NamingException e) {
	      e.printStackTrace();
	  }
	}
    }

    public static void main(String[] args) {
      boolean bindings = false;
      String target = "";

	// Retrieve any jndi environment properties from system properties.
	// 
	// This approach of using system properties here is for
	// expediency only and not meant to be prescriptive.  This is
	// only one of the many ways to set up environment properties.

	Properties env = System.getProperties();

	try {
	    Context ctx = new InitialContext(env);

	    switch (args.length) {
	    case 0:
	      break;
	    case 1:
	      target = args[0];
	      break;
	    case 2:
	      target = args[1];
	      bindings = true;
	      break;
	    default:
	      System.err.println("usage: java List [-b] [name]");
	      System.exit(-1);
	    }

	    if (bindings) {
	      printBindingList(target, ctx.listBindings(target));
	    } else {
	      printNameList(target, ctx.list(target));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
