/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:�û�Ȩ����֤����</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @date 2006-08-22
 * @author licm
 * @version 1.0
 */
package com.filters;

import javax.servlet.*;
import javax.servlet.http.*;

import com.domain.Test;

import java.io.*;
import java.util.*;

public class AuthenticateFilter extends HttpServlet implements Filter {
  private FilterConfig filterConfig;
  private static HashSet excludeURI = null;
  private static String webRoot = null;
  //Handle the passed-in FilterConfig
  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }
  //Process the request/response pair
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    String uri = request.getRequestURI();
    try {
      //�û�ID
      /*String userid = null;
      //�û����ڹ�˾��ȫ�ۺ�
      String cartularyNo = null;
      //�û���ɫ����
      String userRole = null;*/
      UserTBL userInfo = null;
      //ϵͳ������·��
      if(webRoot == null){
        webRoot = request.getContextPath();
      }
      
      //System.out.println("webRoot : " + webRoot);
      if(!isSpecialURI(uri)){
        //System.out.println("uri :" + uri);
        //���session���Ƿ��Ѵ�����֤��Ϣ
        /*userid = (String) request.getSession().getAttribute(GlobeData.
            SESSION_USER_ID);
        cartularyNo = (String) request.getSession().getAttribute(GlobeData.
            SESSION_CARTULARY_NO);
        userRole = (String) request.getSession().getAttribute(GlobeData.
            SESSION_USER_ROLE);*/
    	//System.out.println("filter" + request.getSession().getId());
    	  userInfo = (UserTBL)request.getSession().getAttribute("userInfo");    	
        if (userInfo == null) {
          response.sendRedirect("sessionovertime.jsp");//../login.jsp
          return;
        }
      }
      filterChain.doFilter(req, resp);
    }
    catch (ServletException sx) {
      filterConfig.getServletContext().log(sx.getMessage());
    }
    catch (IOException iox) {
      filterConfig.getServletContext().log(iox.getMessage());
    }
  }
  //Clean up resources
  public void destroy() {
  }

  //��ⶨ�ƵĲ������˵�URI
  private boolean isSpecialURI(String uri){
    boolean result = false;
    if(excludeURI == null){
      excludeURI = new HashSet();
      String exclude = filterConfig.getInitParameter("exclude");
      if(exclude != null){
        StringTokenizer stk = new StringTokenizer(exclude, ",");
        while (stk.hasMoreTokens()) {
          excludeURI.add(stk.nextToken());
        }
      }
    }
    result = excludeURI.contains(uri) || (uri.toLowerCase().indexOf("/images/") > 0) || (uri.toLowerCase().indexOf("/lib/") > 0);
    Iterator it_values = excludeURI.iterator();
    while(it_values.hasNext()){
      result = uri.endsWith((String)it_values.next());
      if(result){
        break;
      }
    }
    result = result || (uri.toLowerCase().indexOf("/images/") > 0)
        || (uri.toLowerCase().indexOf("/lib/") > 0)
        || uri.endsWith(webRoot)
        || uri.endsWith(webRoot + "/");
    return result;
  }
}