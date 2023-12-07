package exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {
    @GetMapping("controller-null")
    public String nullPointerExceptionTest(){
        String str = null;
        System.out.println(str.charAt(0));  // 메인으로 가지 않는 이유는 이 구문에서 에러가 나기 때문에
        return "/main";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("Controller 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userException() throws MemberRegistException{
        boolean check = true;
        if(check){
            throw new MemberRegistException("입사가 불가능합니다");
        }
        return "/";
    }


}
