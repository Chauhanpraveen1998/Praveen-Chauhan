@RestController
public class UserController {
  @Autowired
  private CsrfTokenRepository csrfTokenRepository;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Credentials credentials, HttpServletRequest request, HttpServletResponse response) {
    // authenticate user
    // generate CSRF token
    CsrfToken csrfToken = this.csrfTokenRepository.generateToken(request);
    this.csrfTokenRepository.saveToken(csrfToken, request, response);

    return ResponseEntity.ok().build();
  }
}
