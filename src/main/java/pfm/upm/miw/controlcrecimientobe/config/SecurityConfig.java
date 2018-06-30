package pfm.upm.miw.controlcrecimientobe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pfm.upm.miw.controlcrecimientobe.recursos.ControlCrecimientoRecurso;
import pfm.upm.miw.controlcrecimientobe.recursos.PercentilOmsRecurso;
import pfm.upm.miw.controlcrecimientobe.recursos.PersonaRecurso;
import pfm.upm.miw.controlcrecimientobe.recursos.UsuarioRecurso;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication()
        .withUser("usuarioApiRest").password("usuarioApiRest").roles("CUSTOMER").and()
        .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers(UsuarioRecurso.USUARIOS + "/**").authenticated()
        .antMatchers(PersonaRecurso.PERSONAS + "/**").authenticated()
        .antMatchers(ControlCrecimientoRecurso.CONTROLES + "/**").authenticated()
        .antMatchers(PercentilOmsRecurso.PERCENTILES + "/**").authenticated()
        .and().httpBasic();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
