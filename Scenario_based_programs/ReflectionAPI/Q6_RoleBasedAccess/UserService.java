// UserService class with role-based method restrictions
// Demonstrates methods restricted to specific user roles

public class UserService {
    
    @RoleAllowed(role = "ADMIN")
    public void deleteUser(int userId) {
        System.out.println("User with ID " + userId + " has been deleted.");
    }
    
    @RoleAllowed(role = "ADMIN")
    public void createUser(String username, String email) {
        System.out.println("New user created: " + username + " (" + email + ")");
    }
    
    @RoleAllowed(role = "ADMIN")
    public void modifyUserPermissions(int userId, String permissions) {
        System.out.println("Updated permissions for user " + userId + ": " + permissions);
    }
    
    @RoleAllowed(role = "USER")
    public void viewProfile(int userId) {
        System.out.println("Displaying profile for user ID: " + userId);
    }
    
    @RoleAllowed(role = "USER")
    public void updateProfile(int userId, String name, String email) {
        System.out.println("Profile updated for user " + userId);
    }
    
    @RoleAllowed(role = "MODERATOR")
    public void banUser(int userId, String reason) {
        System.out.println("User " + userId + " has been banned. Reason: " + reason);
    }
    
    @RoleAllowed(role = "MODERATOR")
    public void reviewContent(int contentId) {
        System.out.println("Reviewing content ID: " + contentId);
    }
    
    public void publicMethod() {
        System.out.println("This is a public method accessible to everyone.");
    }
}
