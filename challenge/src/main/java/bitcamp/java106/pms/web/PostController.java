package bitcamp.java106.pms.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Post;
import bitcamp.java106.pms.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @RequestMapping("form")
    public void form() {
    }

    
    
    @RequestMapping("add")
    public String add(Post post) throws Exception {

            postService.add(post);
            return "redirect:list";
            
    }
    
    @RequestMapping("delete")
    public String delete(
            @RequestParam("no") int no) throws Exception {

        int count = postService.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(
            @PathVariable String page,
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) {

        System.out.printf("%s, %d, %d\n", page, pageNo, pageSize);
        map.put("list", postService.list(pageNo, pageSize));
    }
    
    @RequestMapping("update")
    public String update(Post post) throws Exception {

        int count = postService.update(post);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(
            @PathVariable int no, 
            Map<String,Object> map) throws Exception {

        Post post = postService.get(no);
        if (post == null) {
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        }
        map.put("post", post);
        return "post/view";
    }
    
}

//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - PostAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - PostController에서 add() 메서드를 추출하여 클래스로 정의. 
