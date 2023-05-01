@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
    AuthenticationResponse authenticationResponse = userService.login(authenticationRequest);
    return ResponseEntity.ok(authenticationResponse);
  }

}
