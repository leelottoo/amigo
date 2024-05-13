package com.keduit.amigo.component;

import com.keduit.amigo.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class DashboardInterceptor implements HandlerInterceptor {

    @Autowired
    private UserAccessService userAccessService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURL().toString();
        LocalDateTime accessTime = LocalDateTime.now();

        // URL에 따라 각 카운터를 증가
        if (requestUrl.contains("/news")) {
            userAccessService.incrementNewsVisits(accessTime);
        } else if (requestUrl.contains("/movies")) {
            userAccessService.incrementMovieVisits(accessTime);
        }

        return true; // 요청을 컨트롤러로 계속 전달
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 요청 처리 후 실행될 로직
        // 예를 들어, 로깅을 수행합니다.
        System.out.println("After handling the request for " + request.getRequestURI());
    }

    // 토큰 유효성 검사 메소드
    private boolean validateToken(String authToken) {
        // 실제 토큰 검증 로직을 구현합니다.
        // 여기서는 단순 예시로 항상 true를 반환합니다.
        return true;
    }
}
