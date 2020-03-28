	Java Naming and Directory Interface(TM) (JNDI) Release Notes
                           FCS 1.2.1
			 Oct 15, 1999


This is the 1.2.1 maintenance version of JNDI. Please send feedback to
the JNDI team at jndi@java.sun.com, or to the public mailing list at
jndi-interest@java.sun.com.

CHANGES SINCE 1.2 FCS

- NamingManager.getInitialContext() should not throw
NullPointerException when the environment argument is null

- BasicAttribute/Attribute set/add methods ignore duplicate for
unordered attribute.

- Clarifications and typo fixes applied to javadoc


RELEASE INFORMATION

lib/jndi.jar
	Archive of class files for JNDI classes

doc/jndi-ext.html
	Documentation about using JNDI with the Java(TM) 2 SDK, versions 1.2.x,
	and the JDK 1.1.x.

examples/api		
	Simple examples using JNDI to access naming and	directory services

examples/spi		
	Simple example of service provider

The classes in this release have been generated using the Java(TM) 2 SDK,
Standard Edition, v1.2.

See individual release notes for service providers for information on
using JNDI with individual service providers.

ADDITIONAL INFORMATION

The JNDI 1.2 javadoc is available at
http://java.sun.com/products/jndi/1.2/javadoc.

The JNDI browser demo that works with JNDI 1.1.x will continue to work
with JNDI 1.2.



