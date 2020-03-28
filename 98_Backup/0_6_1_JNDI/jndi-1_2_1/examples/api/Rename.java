/*
 * Copyright (c) 1997.  Sun Microsystems. All rights reserved.
 *
 * Example program that looks up the object bound to a name.
 *     java Lookup <name_of_object>
 */

import javax.naming.*;
import java.util.Properties;

class Rename {
    public static void main(String[] args) {
        if (args.length < 2) {
	    System.err.println("usage: java Rename <old_name> <new_name>");
	    System.exit(-1);
	}

	// Retrieve any jndi environment properties from system properties.
	// 
	// This approach of using system properties here is for
	// expediency only and not meant to be prescriptive.  This is
	// only one of the many ways to set up environment properties.

	Properties env = System.getProperties();

	try {
	    Context ctx = new InitialContext(env);
	    ctx.rename(args[0], args[1]);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
