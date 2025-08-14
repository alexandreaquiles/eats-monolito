package br.com.caelum.eats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.caelum.eats.model.Role;
import br.com.caelum.eats.service.JwtAuthenticationEntryPoint;
import br.com.caelum.eats.service.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/restaurantes/**", "/pedidos/**", "/pagamentos/**", "/tipos-de-cozinha/**", "/formas-de-pagamento/**").permitAll()
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/admin/**").hasRole(Role.ROLES.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/parceiros/restaurantes").permitAll()
                .requestMatchers("/parceiros/restaurantes/do-usuario/{username}").access(new WebExpressionAuthorizationManager("@restauranteAuthorizationService.checaUsername(authentication,#username)"))
                .requestMatchers("/parceiros/restaurantes/{restauranteId}/**").access(new WebExpressionAuthorizationManager("@restauranteAuthorizationService.checaId(authentication,#restauranteId)"))
                .requestMatchers("/parceiros/**").hasRole(Role.ROLES.PARCEIRO.name())
                .anyRequest().authenticated()
            )
            .cors(cors -> cors.disable())
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exc -> exc.authenticationEntryPoint(this.jwtAuthenticationEntryPoint));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
