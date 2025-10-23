// UserAPI class with annotated API methods
// Demonstrates RESTful API endpoints for user management

public class UserAPI {
    
    @APIInfo(endpoint = "/users", method = "GET")
    public String getAllUsers() {
        return "Fetching all users from the database";
    }
    
    @APIInfo(endpoint = "/users/{id}", method = "GET")
    public String getUserById(int id) {
        return "Fetching user with ID: " + id;
    }
    
    @APIInfo(endpoint = "/users", method = "POST")
    public String createUser(String username, String email) {
        return "Creating new user: " + username;
    }
    
    @APIInfo(endpoint = "/users/{id}", method = "PUT")
    public String updateUser(int id, String username, String email) {
        return "Updating user with ID: " + id;
    }
    
    @APIInfo(endpoint = "/users/{id}", method = "DELETE")
    public String deleteUser(int id) {
        return "Deleting user with ID: " + id;
    }
    
    @APIInfo(endpoint = "/users/search", method = "GET")
    public String searchUsers(String query) {
        return "Searching users with query: " + query;
    }
    
    @APIInfo(endpoint = "/users/{id}/activate", method = "POST")
    public String activateUser(int id) {
        return "Activating user account with ID: " + id;
    }
    
    @APIInfo(endpoint = "/users/{id}/deactivate", method = "POST")
    public String deactivateUser(int id) {
        return "Deactivating user account with ID: " + id;
    }
}
