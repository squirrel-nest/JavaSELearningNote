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
								  <xsl:when test="string(./NAMEEN)='STREETID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="streetid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='SITEID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="siteid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='ROOMID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="roomid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='ADSLID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="adslid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  								  
								  <xsl:when test="string(./NAMEEN)='TRANSYSID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="transysid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='SDHNETID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="sdhnetid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='SDHSLOTID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="sdhslotid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='WELLID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="wellid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='OPTICCABLEID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="opticcableid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='OPTICLINKERID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="opticlinkerid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='OPTICDIVIDERID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="opticdividerid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='OPTICTERMID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="optictermid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='ELECABLEID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="elecableid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='ELELINKERID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="elelinkerid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='ZHXID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="zhxid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='IDFID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="idfid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <xsl:when test="string(./NAMEEN)='CONNECTMODULEID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="connectmoduleid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  								  
								  <!--????????????? add by yinyq 2006-9 -->							 
								  <xsl:when test="string(./NAMEEN)='PRODUCTTYPEID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="producttypeid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  

								   <!--???SR??? add by yinyq 2007-1 -->							 
								  <xsl:when test="string(./NAMEEN)='SRID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="srid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								   <!--???????Χ??? add by yinyq 2007-1 -->							 
								  <xsl:when test="string(./NAMEEN)='PID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="pid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								   <!--?????Χ??? add by yinyq 2007-1 -->							 
								  <xsl:when test="string(./NAMEEN)='ID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="id"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								   <!--???????????? add by yinyq 2007-1 -->							 
								  <xsl:when test="string(./NAMEEN)='PORTID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="portid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  

								  <!--????豸?????? add by liuyh 2006-1-15 -->	
								   <xsl:when test="string(./NAMEEN)='ID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="id"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>

								  </xsl:when>
								  
								  <!-- Lan add by lzw 2006-1-15 -->	
								   <xsl:when test="string(./NAMEEN)='LANID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="id"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  								  
								   <!--???PVLAN add by liuyh 2006-1-19 -->	
								   <xsl:when test="string(./NAMEEN)='PVLANID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="pvlanid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								  
								  <!--PVLAN???????? add by liuyh 2006-1-25 -->	
								   <xsl:when test="string(./NAMEEN)='RELAYID'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="relayid"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>

								   <!--????????ID??? add by liuyh 2006-2-6 -->	
								   
								   <xsl:when test="string(./NAMEEN)='LANID2'">
								     <a href="pubquery/portlogicid_goto.jsp?id={$sssss}" target="_blank">
										详细													
									 </a>	  	     
								  </xsl:when>
								  
								   <xsl:when test="string(./NAMEEN)='USERINFO'">
								     <a href="pubquery/userinfo_goto.jsp?Cond={$sssss}" target="_blank">
										详细													
									 </a>	  	     
								  </xsl:when>
								  
								   <!--??????? add by liuyh 2006-3-7 -->	
								   <xsl:when test="string(./NAMEEN)='STS'">
								      <input type="checkbox" class="checkbox2">
										  <xsl:attribute name="name">
											  <xsl:value-of select="sts"/>
										  </xsl:attribute>
										  <xsl:attribute name="value">
											  <xsl:value-of select="/queryresult/list/Result[position()=$currentnode]/*[name()=$asname]"/>
										  </xsl:attribute>
									  </input>
								  </xsl:when>
								 
								  <xsl:otherwise>
								     <xsl:choose>
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