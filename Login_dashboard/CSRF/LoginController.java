@RestController
@RequestMapping("/api/auth")
public class LoginController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
    try {
      CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
      String token = jwtTokenProvider.createToken(loginForm.getEmail(), userService.findByEmail(loginForm.getEmail()).getRoles());
      Map<Object, Object> model = new HashMap<>();
      model.put("email", loginForm.getEmail());
      model.put("token", token);
      model.put("_csrf", csrfToken.getToken());
      return ResponseEntity.ok(model);
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}
