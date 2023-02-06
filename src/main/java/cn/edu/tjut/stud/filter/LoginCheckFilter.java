package cn.edu.tjut.stud.filter;


import cn.edu.tjut.stud.common.BaseContext;
import cn.edu.tjut.stud.common.R;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")//urlpatterns要拦截的请求
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}",request.getRequestURI());
        String[] urls = new String[]{
                "/user/login", "/user/logout",
                "/backend/**", "/front/**",
                "/users/login"
        };

        boolean check = check(urls, requestURI);


        if (check)
        {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getSession().getAttribute("user")!=null)
        {
            Long empId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request,response);
            return;
        }

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }


    public boolean check(String[] urls,String requestURI)
    {
        for (String url :
                urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match)
            {
                return true;
            }
        }
        return false;
    }
}
