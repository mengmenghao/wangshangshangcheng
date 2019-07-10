package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.vo.User;
import com.cn.vo.User2;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter(filterName="/Filter",urlPatterns= {"*.jsp"})
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        
        HttpServletRequest request=(HttpServletRequest) arg0;
        HttpServletResponse response=(HttpServletResponse) arg1;
        HttpSession session=request.getSession();
        
        String path=request.getRequestURI();
        System.out.println(path);
        User u=(User)session.getAttribute("user");
        User2 u2=(User2)session.getAttribute("name");
        
        if(path.indexOf("/login.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/dl.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/register.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/zh.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/findServlet")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/find.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(path.indexOf("/fa.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }if(path.indexOf("/updatepass.jsp")>-1){//登录页面不过滤
            arg2.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        if(u!=null||u2!=null){//已经登录
            arg2.doFilter(request, response);//放行，递交给下一个过滤器
           return;
        }else{
            response.sendRedirect("dl.jsp");
        }
        arg2.doFilter(request, response);
       
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
