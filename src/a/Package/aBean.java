package a.Package;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class aBean {
	private String name, password;
	boolean check = false;
	boolean admin = false;
	//hard coded for now but is to be replace with reading from file/db
	public String[][] users = {
            {"admin", "admin", "true"},
            {"name", "password", "false" }
        };
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	//checks if user and password is valid
	public boolean validate() {
		
		for (int i = 0; i < users.length; i++) {
			if (name.contentEquals(users[i][0]) && password.contentEquals(users[i][1])){
				check = true;
				if (users[i][2].equals("true")) {
					admin = true;
				}
			}
		}
		
		if (check) {
			return true;
		 }else {
				return false;
			} 
		
	}
	// Updates array with username and password for later use/save
	public void update(String uName) {
		for (int i = 0; i < users.length; i++) {
			if (users[i][0].contentEquals(uName)) {
				users[i][0] = name;
				users[i][1] = password;		
				
			}
		}
	}
}

			
		
