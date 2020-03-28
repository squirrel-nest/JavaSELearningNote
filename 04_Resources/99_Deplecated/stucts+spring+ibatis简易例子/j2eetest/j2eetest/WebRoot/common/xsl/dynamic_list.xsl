<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	 xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" 
	 xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
    <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes" omit-xml-declaration="yes" media-type="text/html" />
    <xsl:template match="/queryresult">
        <table class="sort-table" style="table-layout:fixed;" border="1" cellpadding="0" cellspacing="0">
	         <thead>
		        <tr>
					<xsl:for-each select="./list_fields/Head">
			        	<td style="word-break:break-all;word-wrap:break-word;" background="/internet/images/table_title_bg.gif" align="center">
							
							<xsl:value-of select="./NAMECN"/>
			        	</td>
			        </xsl:for-each>
				</tr>
			  </thead>
			  <xsl:for-each select="./list/Result">
				  <xsl:variable name="currentnode" select="position()"/>
				  <tr>
					  <xsl:attribute name="bgcolor">
						  <xsl:choose>
							  <xsl:when test="(position() mod 2)=1">
								  <xsl:value-of select="'#FFFFFF'"/>
							  </xsl:when>
							  <xsl:otherwise>
								  <xsl:value-of select="'#F1F4FA'"/>
							  </xsl:otherwise>
						  </xsl:choose>
					  </xsl:attribute>
					  <xsl:for-each select="/queryresult/list_fields/Head">
						  <xsl:variable name="asname" select="./NAMEEN"/>
						  
						  <td align="center">
							  <xsl:choose>
								  <xsl:when test="string(./ISPK)='1'">
									  <input type="checkbox">
										  <xsl:attribute name="name">
											  <xsl:value-of select="$asname"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:otherwise>
								     <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>&#160;
								  </xsl:otherwise>
							  </xsl:choose>
								  
								  
								     
								  
							  
						  </td>
					  </xsl:for-each>
				  </tr>				  
			  </xsl:for-each>
		</table>	
    </xsl:template>
</xsl:stylesheet>
