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

	Login login;
	public String signIn(String email,String password) {
		login=loginRepository.findByEmailid(email);
		if(login!=null)
		{
			
		
		if(login.getEmailid().equals(email)&&login.getPassword().equals(password))
		{
			return "login sucessfull";
		}
		else
		{
			return "invalid credentials";
		}
		
		
	}
	else
	{
		return "User not found";
	}
		

  }
	
	

		
	public String signUp(Login login) {
		
		{
			if(loginRepository.findByEmailid(login.getEmailid())==null)
			{
				loginRepository.save(login);
				return " User registered successfully";
			}
			else
			{
				return "User already exists";
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

		
	
			
