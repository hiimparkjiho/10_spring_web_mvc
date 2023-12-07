package exception;

import org.springframework.web.bind.annotation.GetMapping;

public class OtherController {

    @GetMapping("other-controller-null")
    public String otherNullPointException(){
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }

    @GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {
        if(true){
            throw new MemberRegistException("입사 불가");
        }
        return "/";
    }

    @GetMapping("other-controller-array")
    public String otherArrayException(){
        double[] array = new double[0];
        System.out.println(array);
        return "/";
    }
}
