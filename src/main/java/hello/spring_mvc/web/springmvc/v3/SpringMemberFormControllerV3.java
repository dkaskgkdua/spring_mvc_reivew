package hello.spring_mvc.web.springmvc.v3;

import hello.spring_mvc.domain.member.Member;
import hello.spring_mvc.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberFormControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String process() {
        return "new-form";
    }

    @GetMapping
    protected String list(Model model) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

    @PostMapping("/save")
    protected String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) throws ServletException, IOException {

        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }
}
