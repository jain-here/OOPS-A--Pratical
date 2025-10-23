// Sample class with @APIDescription annotation
// Demonstrates applying custom annotations for documentation

@APIDescription(description = "This class handles user authentication and authorization operations")
public class AuthenticationService {
    
    @APIDescription(description = "Validates user credentials and returns authentication token")
    public String login(String username, String password) {
        // Simulate login logic
        return "AUTH_TOKEN_" + username.toUpperCase();
    }
    
    @APIDescription(description = "Invalidates the current user session and clears authentication token")
    public void logout(String token) {
        // Simulate logout logic
        System.out.println("User logged out successfully");
    }
    
    @APIDescription(description = "Checks if the provided token is valid and not expired")
    public boolean validateToken(String token) {
        // Simulate token validation
        return token != null && token.startsWith("AUTH_TOKEN_");
    }
    
    @APIDescription(description = "Generates a new password reset token for the specified email")
    public String resetPassword(String email) {
        // Simulate password reset
        return "RESET_TOKEN_" + email.hashCode();
    }
}
