package cn.com.myproject.qd.security;


import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author xx
 * @date 2017/6/21
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


//    @Autowired
//    private IRedisService redisService;
//    @Autowired
//    private GsonComponent gsonComponent;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if(filterInvocation.getRequest().getRequestURI().equals("/")){
            return null;
        }
        String url = filterInvocation.getRequestUrl();
        //截取带参数URL
        if(StringUtils.contains(url,"?")){
            url = StringUtils.substringBefore(url,"?");
        }
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

//        String sysType = "";
//        if (principal != null && !principal.toString().equals("anonymousUser")) {
//            sysType = ((SecurityUser)principal).getSysType() + "";
//        }
//        Object o = redisService.getHashValue(BaseConstant.URL_SECURITY_KEY + ":" + sysType, url);
//        Collection<ConfigAttribute> c = new ArrayList<>();
//        if (o != null) {
//            c = gsonComponent.getGson().fromJson(o.toString(), new TypeToken<Collection<SecurityConfig>>(){}.getType() );
//        }
//
//        return c;
        return null;

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
