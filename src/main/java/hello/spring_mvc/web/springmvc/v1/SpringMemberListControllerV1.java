package hello.spring_mvc.web.springmvc.v1;

import hello.spring_mvc.domain.member.Member;
import hello.spring_mvc.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    protected ModelAndView service() throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv =new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
