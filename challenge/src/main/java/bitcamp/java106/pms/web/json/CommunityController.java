package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Community;
import bitcamp.java106.pms.service.CommunityService;

@RestController
@RequestMapping("/community")
public class CommunityController {

    CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }
    
   @RequestMapping("add")
   @ResponseStatus(HttpStatus.CREATED)
    public void add(Community community) throws Exception {
            communityService.add(community);
    }
    
    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // 응답 상태 코드 값의 기본은 "200(OK)" 이다.
    public void delete(
            @RequestParam("no") int no) throws Exception {
       communityService.delete(no);
    }
    
    @RequestMapping("list")
    public Object list(
            ) {
        return communityService.list();
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public void update(Community community) throws Exception {
        communityService.update(community);
    }
    
    @RequestMapping("{no}")
    public Community view(@PathVariable int no) throws Exception {
        return communityService.get(no);
    }
    
}

//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - CommunityAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - CommunityController에서 add() 메서드를 추출하여 클래스로 정의. 
