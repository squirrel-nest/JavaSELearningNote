/*
 * Copyright (c) 1998.  Sun Microsystems. All rights reserved.
 */

import java.util.Hashtable;
import javax.naming.*;

class TestFlat {
    static void printBindings(String msg, NamingEnumeration bl) {
	System.out.println(msg);
	if (bl == null) 
	    System.out.println("No items in list");
	else {
	    try {
		while (bl.hasMore()) {
		    Binding b = (Binding)bl.next();
		    System.out.println(b.getName() + ":" + b.getObject());
		}
	    } catch (NamingException e) {
		e.printStackTrace();
	    }
	}
    }

    public static void main(String[] args) {
	// Set up to use factory
	Hashtable env = new Hashtable(5, 0.75f);
	env.put("java.naming.factory.initial", 
	    "examples.spi.flat.FlatInitCtxFactory");
	try {
	    Context initctx = new InitialContext(env);

	    initctx.bind("a", "binding_a");
	    initctx.bind("b", "binding_b");
	    initctx.bind("c", "binding_c");

	    printBindings("original", initctx.listBindings(""));

	    // make some changes
	    initctx.unbind("b");
	    initctx.rename("a", "aa");
	    initctx.bind("d", "binding_d");
	    initctx.rebind("c", "new_binding");
	    
	    printBindings("after changes", initctx.listBindings(""));
	    
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
