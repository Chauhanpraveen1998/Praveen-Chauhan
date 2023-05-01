@Component
public class JwtTokenProvider {

  private static final String SECRET_KEY = "mySecretKey";

  @Value("${app.jwtExpirationInMs}")
  private long jwtExpirationInMs;

  public String createToken(String email, List<Role> roles) {
    Claims claims = Jwts.claims().setSubject(email);
    claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
    return Jwts.builder()
            .set
