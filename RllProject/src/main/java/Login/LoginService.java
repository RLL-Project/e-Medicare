package Login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.bean.Login;
//import com.example.demo.Repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getRole().equals(ll.getRole()) && login.getRole().equals("admin")) {
							return "Admin sucessfully login";
				}else if(login.getRole().equals(ll.getRole()) && login.getRole().equals("user")){
							return "User successfully login";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "Email Id alreay exists";
		}else {
			if(login.getRole().equals("admin")) {
				return "You can't create admin account";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
		}
	}
	public List<Login> user(int Id) {
        return loginRepository.findById(Id);
    }
	public Login updateUser( Login updatedUser) {
        return loginRepository.save(updatedUser);
    }


	}

		
	
			
