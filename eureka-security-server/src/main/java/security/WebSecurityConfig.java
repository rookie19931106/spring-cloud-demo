package security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jay
 * @date 2020/1/11 21:34
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configue(HttpSecurity http) throws Exception{
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
