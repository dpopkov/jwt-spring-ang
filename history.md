History
-------
In reversed order.

* ExceptionHandling - to handle all exceptions.
* EmailExistsException, EmailNotFoundException, UsernameExistsException, UserNotFoundException.
* UserController (for test).
* SecurityConfiguration.
* UserService, UserServiceImpl implements UserService, UserDetailsService.
* UserRepository.
* JwtAccessDeniedHandler::handle.
* JwtAuthenticationEntryPoint::commence.
* JwtAuthorizationFilter::doFilterInternal.
* JwtProvider::isTokenValid.
* JwtProvider::getAuthentication.
* JwtProvider::getAuthorities.
* JwtProvider::generateJwtToken.
* SecurityConstants.
* Add yaml properties for h2 and mysql.
* Use mysql_db_users.sql script to create DB and user.
* UserPrincipal implements UserDetails.
* HttpResponse - A uniform way of sending a response back to the client.
* User entity.
