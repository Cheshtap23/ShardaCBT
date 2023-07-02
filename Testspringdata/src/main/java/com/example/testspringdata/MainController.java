package com.example.testspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController
{
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;

    @GetMapping("/")
    public String getLandingPage()
    {
        return "landingpage";
    }
//    public String saveCredential(){
//        Credential cr=new Credential();
//        cr.setUsername("abhinav");
//        cr.setPassword("1234");
//        credentialRepository.save(cr);
//        return "New Credential Saved";
//
//    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username")String username,
                         @RequestParam("password")String password)
    {
        Credential credential= new Credential();
        credential.setUsername(username);
        credential.setPassword(password);

        credentialRepository.save(credential);
        return "signup2";
    }

    @PostMapping("/signup2")
    public String signup2(@RequestParam("username")String username,
                          @RequestParam("fname")String fname,
                          @RequestParam("lname")String lname,
                          @RequestParam("email")String email,
                          @RequestParam("phone")String phone, HttpSession session)
    {
        Userdetail userdetail = new Userdetail();
        userdetail.setUsername(username);
        userdetail.setFname(fname);
        userdetail.setEmail(email);
        userdetail.setLname(lname);
        userdetail.setPhone(phone);
        session.setAttribute("username",username);
        session.setAttribute("fname",fname);
        session.setAttribute("lname",lname);
        session.setAttribute("email",email);
        session.setAttribute("phone",phone);

        userdetailRepository.save(userdetail);
        return "dashboard";
    }

    @PostMapping("/login")

    public String login(@RequestParam("username")String username,@RequestParam("password")String password, HttpSession session, Model model) {

        Optional<Credential> credValue = credentialRepository.findById(username);
        if (credValue.isPresent()) {
            if (credValue.get().getPassword().equals(password)) {
                session.setAttribute("username", username);
                Optional<Userdetail> useValue = userdetailRepository.findById(username);
                if (useValue.isPresent()) {
                    model.addAttribute("userdetail", useValue.get());
                }
                return "dashboard";
            } else {
                return "landingpage";
            }
        } else {
            return "landingpage";
        }
    }

}