package hello.spring_mvc.web.springmvc.v2;

import hello.spring_mvc.domain.member.Member;
import hello.spring_mvc.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberFormControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/members")
    protected ModelAndView list() throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv =new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }

    @RequestMapping("/save")
    protected ModelAndView save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv =new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
