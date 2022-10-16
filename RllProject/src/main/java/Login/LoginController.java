package Login;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.example.demo.bean.Login;
//import com.example.demo.Service.LoginService;
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService loginservice;
    
	@PostMapping(value="signIn",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login)
	{
		return loginservice.signIn(login);
	}
	@PostMapping(value="signUp",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login)
	{
		return loginservice.signUp(login);
	}

	@PutMapping("/updateuser")
    public ResponseEntity<Object> updateUser(@RequestParam("id") int id,@RequestBody Login updatedUser) {
        try {
            List<Login> existingUser = loginservice.user(id);

            if(existingUser != null) {
                if(updatedUser.getName() != null) {
                    existingUser.get(0).setName(updatedUser.getName());
                }
                if(updatedUser.getDob() != null) {
                    existingUser.get(0).setDob(updatedUser.getDob());
                }
                if(updatedUser.getPassword() != null) {
                    existingUser.get(0).setPassword(updatedUser.getPassword());
                }

                return new ResponseEntity<Object>(loginservice.updateUser(existingUser.get(0)), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("Incorrect medicine Id.", HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to update medicine details, please try with different medicine name or try after some time.", HttpStatus.BAD_REQUEST);
        }
    }

}