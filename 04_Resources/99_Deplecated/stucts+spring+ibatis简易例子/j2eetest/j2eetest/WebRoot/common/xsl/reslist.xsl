<?xml version="1.0" encoding="GBK"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	 xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" 
	 xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
    <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes" omit-xml-declaration="yes" media-type="text/html" />
    <xsl:template match="/queryresult">
			  <xsl:for-each select="./list/Result">
				  <xsl:variable name="currentnode" select="position()"/>
				  <tr>
					  <xsl:attribute name="bgcolor">
						  <xsl:choose>
							  <xsl:when test="(position() mod 2)=1">
								  <xsl:value-of select="'#FFFFFF'"/>
							  </xsl:when>
							  <xsl:otherwise>
								  <xsl:value-of select="'#E6EAF5'"/>
							  </xsl:otherwise>
						  </xsl:choose>
					  </xsl:attribute>
					  <xsl:for-each select="/queryresult/list_fields/Head">
						  <xsl:variable name="asname" select="./NAMEEN"/>
						  <xsl:variable name="sssss" select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
						  <td align="center" nowrap="true">
			  		<xsl:choose>
						  <xsl:when test="string(./NAMEEN)='NODEID'"></xsl:when>
				  		  <xsl:otherwise>
			  		  	  	<xsl:choose>
			  		  	  	
			  		  	  	<xsl:when test="string(./NAMEEN)='PORTSTATUS'">
			  		  	  	<a href="synthesisquery/portstatus_goto.jsp?Cond={$sssss}" target="_blank">
								详细										
							 </a>
			  		  	  	</xsl:when>
			  		  	  	<xsl:when test="string(/queryresult/list/Result[position()=$currentnode]/NODEID)='1001004'">
			  		  	  		<xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>&#160;
			  		  	  	</xsl:when>
						  
						  <xsl:otherwise>							    	
						    	<font color="#ff0000">
			  		  	  			<xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>&#160;
			  		  	  		</font>				  		  	  		
			  		  	  	</xsl:otherwise>
		  		  	  	</xsl:choose>
					  </xsl:otherwise>   
					</xsl:choose> 
					  
				  </td>
			  </xsl:for-each>
		  </tr>				  
	  </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
